package com.baidu.mapapi.map;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
/* loaded from: classes4.dex */
class m extends AnimatorListenerAdapter {
    final /* synthetic */ SwipeDismissTouchListener a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(SwipeDismissTouchListener swipeDismissTouchListener) {
        this.a = swipeDismissTouchListener;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.a.a();
    }
}
