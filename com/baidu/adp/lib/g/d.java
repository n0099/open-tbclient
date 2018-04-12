package com.baidu.adp.lib.g;

import android.view.animation.Animation;
/* loaded from: classes.dex */
public abstract class d implements Animation.AnimationListener {
    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(final Animation animation) {
        e.fw().post(new Runnable() { // from class: com.baidu.adp.lib.g.d.1
            @Override // java.lang.Runnable
            public void run() {
                d.this.a(animation);
            }
        });
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(final Animation animation) {
        e.fw().post(new Runnable() { // from class: com.baidu.adp.lib.g.d.2
            @Override // java.lang.Runnable
            public void run() {
                d.this.b(animation);
            }
        });
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(final Animation animation) {
        e.fw().post(new Runnable() { // from class: com.baidu.adp.lib.g.d.3
            @Override // java.lang.Runnable
            public void run() {
                d.this.c(animation);
            }
        });
    }

    public void a(Animation animation) {
    }

    public void b(Animation animation) {
    }

    public void c(Animation animation) {
    }
}
