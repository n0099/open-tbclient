package com.baidu.mapapi.map;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes2.dex */
public class r implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ViewGroup.LayoutParams f7146a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SwipeDismissTouchListener f7147b;

    public r(SwipeDismissTouchListener swipeDismissTouchListener, ViewGroup.LayoutParams layoutParams) {
        this.f7147b = swipeDismissTouchListener;
        this.f7146a = layoutParams;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        View view;
        this.f7146a.height = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        view = this.f7147b.f7042e;
        view.setLayoutParams(this.f7146a);
    }
}
