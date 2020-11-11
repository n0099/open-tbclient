package com.baidu.mapapi.map;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
/* loaded from: classes7.dex */
class u extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SwipeDismissTouchListener f2085a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(SwipeDismissTouchListener swipeDismissTouchListener) {
        this.f2085a = swipeDismissTouchListener;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.f2085a.a();
    }
}
