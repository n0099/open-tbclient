package com.baidu.mapsdkplatform.comapi.a;

import android.animation.Animator;
import com.baidu.mapapi.animation.Animation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes15.dex */
public class i implements Animator.AnimatorListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ h f3130a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.f3130a = hVar;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        Animation.AnimationListener animationListener;
        Animation.AnimationListener animationListener2;
        animationListener = this.f3130a.d;
        if (animationListener != null) {
            animationListener2 = this.f3130a.d;
            animationListener2.onAnimationCancel();
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        Animation.AnimationListener animationListener;
        Animation.AnimationListener animationListener2;
        animationListener = this.f3130a.d;
        if (animationListener != null) {
            animationListener2 = this.f3130a.d;
            animationListener2.onAnimationEnd();
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
        Animation.AnimationListener animationListener;
        Animation.AnimationListener animationListener2;
        animationListener = this.f3130a.d;
        if (animationListener != null) {
            animationListener2 = this.f3130a.d;
            animationListener2.onAnimationRepeat();
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        Animation.AnimationListener animationListener;
        Animation.AnimationListener animationListener2;
        animationListener = this.f3130a.d;
        if (animationListener != null) {
            animationListener2 = this.f3130a.d;
            animationListener2.onAnimationStart();
        }
    }
}
