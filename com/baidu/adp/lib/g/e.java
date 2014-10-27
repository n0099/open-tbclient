package com.baidu.adp.lib.g;

import android.os.Handler;
import android.os.Looper;
import android.view.animation.Animation;
/* loaded from: classes.dex */
public abstract class e implements Animation.AnimationListener {
    public static final Handler lA = new Handler(Looper.getMainLooper());

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
        lA.post(new f(this, animation));
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        lA.post(new g(this, animation));
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
        lA.post(new h(this, animation));
    }

    public void a(Animation animation) {
    }

    public void b(Animation animation) {
    }

    public void c(Animation animation) {
    }
}
