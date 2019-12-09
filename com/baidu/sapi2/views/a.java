package com.baidu.sapi2.views;

import android.animation.ValueAnimator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class a implements ValueAnimator.AnimatorUpdateListener {
    final /* synthetic */ ClipBoxView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(ClipBoxView clipBoxView) {
        this.a = clipBoxView;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.a.G = Float.parseFloat(String.valueOf(valueAnimator.getAnimatedValue()));
        this.a.invalidate();
        this.a.c();
    }
}
