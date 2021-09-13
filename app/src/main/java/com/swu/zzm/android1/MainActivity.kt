package com.swu.zzm.android1

import android.animation.Animator
import android.animation.ObjectAnimator
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import java.util.function.ObjIntConsumer

class MainActivity : AppCompatActivity(),View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //监听被点击的事件
        mLoginBtn.setOnClickListener {
            //添加旋转动画 动画结束之后进入下一个界面
            ObjectAnimator.ofFloat(mImageView,"rotation",0f,360f).apply {
                duration = 100
                repeatCount = 30
                start()
                //监听动画的结束事件
                addListener(object :MyAnimatorListener(){
                    override fun onAnimationEnd(animation: Animator?) {
                        startActivity(Intent(this@MainActivity,DetailActivity::class.java))
                    }
                })
            }

        }
    }

    override fun onClick(v: View?) {
        print("按钮被点击了")
    }
}