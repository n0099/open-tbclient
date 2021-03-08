package com.baidu.mapapi.map;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class q implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ViewGroup.LayoutParams f2076a;
    final /* synthetic */ SwipeDismissTouchListener b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(SwipeDismissTouchListener swipeDismissTouchListener, ViewGroup.LayoutParams layoutParams) {
        this.b = swipeDismissTouchListener;
        this.f2076a = layoutParams;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        View view;
        this.f2076a.height = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        view = this.b.e;
        view.setLayoutParams(this.f2076a);
    }
}
