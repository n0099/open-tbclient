package com.baidu.mapapi.map;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
/* loaded from: classes26.dex */
class u extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SwipeDismissTouchListener f2087a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(SwipeDismissTouchListener swipeDismissTouchListener) {
        this.f2087a = swipeDismissTouchListener;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.f2087a.a();
    }
}
