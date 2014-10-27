package com.baidu.tbadk.core;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes.dex */
public class a {
    public static final void a(Context context, Animatable animatable) {
        if (context instanceof BaseActivity) {
            ((BaseActivity) context).startAnimatable(animatable);
        } else if (context instanceof BaseFragmentActivity) {
            ((BaseFragmentActivity) context).startAnimatable(animatable);
        }
    }

    public static final void a(Context context, View view, Animation animation, Animation.AnimationListener animationListener) {
        if (context instanceof BaseActivity) {
            ((BaseActivity) context).startAnimation(view, animation, animationListener);
        } else if (context instanceof BaseFragmentActivity) {
            ((BaseFragmentActivity) context).startAnimation(view, animation, animationListener);
        }
    }

    public static final void a(Context context, View view, int i, Animation.AnimationListener animationListener) {
        if (view != null) {
            try {
                a(context, view, AnimationUtils.loadAnimation(TbadkApplication.m251getInst().getApplicationContext(), i), animationListener);
            } catch (Resources.NotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
