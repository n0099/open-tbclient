package com.baidu.mapapi.map;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes15.dex */
public class w implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ViewGroup.LayoutParams f2937a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ SwipeDismissTouchListener f2938b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(SwipeDismissTouchListener swipeDismissTouchListener, ViewGroup.LayoutParams layoutParams) {
        this.f2938b = swipeDismissTouchListener;
        this.f2937a = layoutParams;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        View view;
        this.f2937a.height = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        view = this.f2938b.e;
        view.setLayoutParams(this.f2937a);
    }
}
