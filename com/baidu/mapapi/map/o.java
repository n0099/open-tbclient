package com.baidu.mapapi.map;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
/* loaded from: classes4.dex */
class o extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SwipeDismissTouchListener f2801a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(SwipeDismissTouchListener swipeDismissTouchListener) {
        this.f2801a = swipeDismissTouchListener;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.f2801a.a();
    }
}
