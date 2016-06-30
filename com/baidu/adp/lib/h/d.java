package com.baidu.adp.lib.h;

import android.view.animation.Animation;
/* loaded from: classes.dex */
public abstract class d implements Animation.AnimationListener {
    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
        h.dM().post(new e(this, animation));
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        h.dM().post(new f(this, animation));
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
        h.dM().post(new g(this, animation));
    }

    public void a(Animation animation) {
    }

    public void b(Animation animation) {
    }

    public void c(Animation animation) {
    }
}
