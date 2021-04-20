package com.baidu.mapapi.map;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes2.dex */
public class q implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ViewGroup.LayoutParams f7129a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SwipeDismissTouchListener f7130b;

    public q(SwipeDismissTouchListener swipeDismissTouchListener, ViewGroup.LayoutParams layoutParams) {
        this.f7130b = swipeDismissTouchListener;
        this.f7129a = layoutParams;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        View view;
        this.f7129a.height = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        view = this.f7130b.f7034e;
        view.setLayoutParams(this.f7129a);
    }
}
