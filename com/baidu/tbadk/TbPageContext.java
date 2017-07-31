package com.baidu.tbadk;

import android.graphics.drawable.Animatable;
import android.view.View;
import android.view.animation.Animation;
import com.baidu.adp.base.e;
import com.baidu.tbadk.core.c;
/* loaded from: classes.dex */
public interface TbPageContext<T> extends e<T> {
    c getLayoutMode();

    void showToast(int i);

    void showToast(int i, boolean z);

    void showToast(String str);

    void showToast(String str, boolean z);

    void startAnimatable(Animatable animatable);

    void startAnimation(View view, Animation animation, Animation.AnimationListener animationListener);
}
