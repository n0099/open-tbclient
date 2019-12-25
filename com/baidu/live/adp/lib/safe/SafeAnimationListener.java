package com.baidu.live.adp.lib.safe;

import android.view.animation.Animation;
/* loaded from: classes2.dex */
public abstract class SafeAnimationListener implements Animation.AnimationListener {
    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(final Animation animation) {
        SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.live.adp.lib.safe.SafeAnimationListener.1
            @Override // java.lang.Runnable
            public void run() {
                SafeAnimationListener.this.onSafeAnimationStart(animation);
            }
        });
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(final Animation animation) {
        SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.live.adp.lib.safe.SafeAnimationListener.2
            @Override // java.lang.Runnable
            public void run() {
                SafeAnimationListener.this.onSafeAnimationEnd(animation);
            }
        });
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(final Animation animation) {
        SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.live.adp.lib.safe.SafeAnimationListener.3
            @Override // java.lang.Runnable
            public void run() {
                SafeAnimationListener.this.onSafeAnimationRepeat(animation);
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
