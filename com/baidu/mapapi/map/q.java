package com.baidu.mapapi.map;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class q implements ValueAnimator.AnimatorUpdateListener {
    final /* synthetic */ ViewGroup.LayoutParams a;
    final /* synthetic */ SwipeDismissTouchListener b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(SwipeDismissTouchListener swipeDismissTouchListener, ViewGroup.LayoutParams layoutParams) {
        this.b = swipeDismissTouchListener;
        this.a = layoutParams;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        View view;
        this.a.height = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        view = this.b.e;
        view.setLayoutParams(this.a);
    }
}
