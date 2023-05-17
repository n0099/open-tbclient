package com.baidu.mapapi.map;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes3.dex */
public class y implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ ViewGroup.LayoutParams a;
    public final /* synthetic */ SwipeDismissTouchListener b;

    public y(SwipeDismissTouchListener swipeDismissTouchListener, ViewGroup.LayoutParams layoutParams) {
        this.b = swipeDismissTouchListener;
        this.a = layoutParams;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        View view2;
        this.a.height = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        view2 = this.b.e;
        view2.setLayoutParams(this.a);
    }
}
