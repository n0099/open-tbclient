package com.baidu.mapapi.map;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class q implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ViewGroup.LayoutParams f2809a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ SwipeDismissTouchListener f2810b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(SwipeDismissTouchListener swipeDismissTouchListener, ViewGroup.LayoutParams layoutParams) {
        this.f2810b = swipeDismissTouchListener;
        this.f2809a = layoutParams;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        View view;
        this.f2809a.height = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        view = this.f2810b.e;
        view.setLayoutParams(this.f2809a);
    }
}
