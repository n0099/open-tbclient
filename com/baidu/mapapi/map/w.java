package com.baidu.mapapi.map;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class w implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ViewGroup.LayoutParams f2938a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ SwipeDismissTouchListener f2939b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(SwipeDismissTouchListener swipeDismissTouchListener, ViewGroup.LayoutParams layoutParams) {
        this.f2939b = swipeDismissTouchListener;
        this.f2938a = layoutParams;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        View view;
        this.f2938a.height = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        view = this.f2939b.e;
        view.setLayoutParams(this.f2938a);
    }
}
