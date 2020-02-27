package com.baidu.sapi2.views;

import android.animation.ValueAnimator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class g implements ValueAnimator.AnimatorUpdateListener {
    final /* synthetic */ RippleSurfaceView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(RippleSurfaceView rippleSurfaceView) {
        this.a = rippleSurfaceView;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.a.i = Integer.parseInt(String.valueOf(valueAnimator.getAnimatedValue()));
    }
}
