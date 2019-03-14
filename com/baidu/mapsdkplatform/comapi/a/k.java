package com.baidu.mapsdkplatform.comapi.a;

import android.animation.Animator;
import com.baidu.mapapi.animation.Animation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class k implements Animator.AnimatorListener {
    final /* synthetic */ j a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar) {
        this.a = jVar;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        Animation.AnimationListener animationListener;
        Animation.AnimationListener animationListener2;
        animationListener = this.a.d;
        if (animationListener != null) {
            animationListener2 = this.a.d;
            animationListener2.onAnimationCancel();
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        Animation.AnimationListener animationListener;
        Animation.AnimationListener animationListener2;
        animationListener = this.a.d;
        if (animationListener != null) {
            animationListener2 = this.a.d;
            animationListener2.onAnimationEnd();
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
        Animation.AnimationListener animationListener;
        Animation.AnimationListener animationListener2;
        animationListener = this.a.d;
        if (animationListener != null) {
            animationListener2 = this.a.d;
            animationListener2.onAnimationRepeat();
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        Animation.AnimationListener animationListener;
        Animation.AnimationListener animationListener2;
        animationListener = this.a.d;
        if (animationListener != null) {
            animationListener2 = this.a.d;
            animationListener2.onAnimationStart();
        }
    }
}
