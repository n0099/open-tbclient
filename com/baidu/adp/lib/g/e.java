package com.baidu.adp.lib.g;

import android.view.animation.Animation;
/* loaded from: classes.dex */
public abstract class e implements Animation.AnimationListener {
    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
        i.hs().post(new f(this, animation));
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        i.hs().post(new g(this, animation));
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
        i.hs().post(new h(this, animation));
    }

    public void a(Animation animation) {
    }

    public void b(Animation animation) {
    }

    public void c(Animation animation) {
    }
}
