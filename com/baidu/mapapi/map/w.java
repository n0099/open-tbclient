package com.baidu.mapapi.map;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class w implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ViewGroup.LayoutParams f2087a;
    final /* synthetic */ SwipeDismissTouchListener b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(SwipeDismissTouchListener swipeDismissTouchListener, ViewGroup.LayoutParams layoutParams) {
        this.b = swipeDismissTouchListener;
        this.f2087a = layoutParams;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        View view;
        this.f2087a.height = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        view = this.b.e;
        view.setLayoutParams(this.f2087a);
    }
}
