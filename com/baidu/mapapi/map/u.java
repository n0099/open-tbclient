package com.baidu.mapapi.map;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
/* loaded from: classes3.dex */
class u extends AnimatorListenerAdapter {
    final /* synthetic */ SwipeDismissTouchListener a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(SwipeDismissTouchListener swipeDismissTouchListener) {
        this.a = swipeDismissTouchListener;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.a.a();
    }
}
