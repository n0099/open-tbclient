package com.baidu.mapsdkplatform.comapi.a;

import android.animation.Animator;
import com.baidu.mapapi.animation.Animation;
/* loaded from: classes2.dex */
public class g implements Animator.AnimatorListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ f f7800a;

    public g(f fVar) {
        this.f7800a = fVar;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        Animation.AnimationListener animationListener;
        Animation.AnimationListener animationListener2;
        animationListener = this.f7800a.f7796d;
        if (animationListener != null) {
            animationListener2 = this.f7800a.f7796d;
            animationListener2.onAnimationCancel();
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        Animation.AnimationListener animationListener;
        Animation.AnimationListener animationListener2;
        animationListener = this.f7800a.f7796d;
        if (animationListener != null) {
            animationListener2 = this.f7800a.f7796d;
            animationListener2.onAnimationEnd();
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
        Animation.AnimationListener animationListener;
        Animation.AnimationListener animationListener2;
        animationListener = this.f7800a.f7796d;
        if (animationListener != null) {
            animationListener2 = this.f7800a.f7796d;
            animationListener2.onAnimationRepeat();
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        Animation.AnimationListener animationListener;
        Animation.AnimationListener animationListener2;
        animationListener = this.f7800a.f7796d;
        if (animationListener != null) {
            animationListener2 = this.f7800a.f7796d;
            animationListener2.onAnimationStart();
        }
    }
}
