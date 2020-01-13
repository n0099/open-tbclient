package com.baidu.adp.lib.f;

import android.view.animation.Animation;
/* loaded from: classes.dex */
public abstract class d implements Animation.AnimationListener {
    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(final Animation animation) {
        e.gx().post(new Runnable() { // from class: com.baidu.adp.lib.f.d.1
            @Override // java.lang.Runnable
            public void run() {
                d.this.onSafeAnimationStart(animation);
            }
        });
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(final Animation animation) {
        e.gx().post(new Runnable() { // from class: com.baidu.adp.lib.f.d.2
            @Override // java.lang.Runnable
            public void run() {
                d.this.onSafeAnimationEnd(animation);
            }
        });
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(final Animation animation) {
        e.gx().post(new Runnable() { // from class: com.baidu.adp.lib.f.d.3
            @Override // java.lang.Runnable
            public void run() {
                d.this.onSafeAnimationRepeat(animation);
            }
        });
    }

    public void onSafeAnimationStart(Animation animation) {
    }

    public void onSafeAnimationEnd(Animation animation) {
    }

    public void onSafeAnimationRepeat(Animation animation) {
    }
}
