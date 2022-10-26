package com.airbnb.lottie.value;

import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
/* loaded from: classes.dex */
public abstract class LottieInterpolatedValue extends LottieValueCallback {
    public final Object endValue;
    public final Interpolator interpolator;
    public final Object startValue;

    public abstract Object interpolateValue(Object obj, Object obj2, float f);

    public LottieInterpolatedValue(Object obj, Object obj2) {
        this(obj, obj2, new LinearInterpolator());
    }

    public LottieInterpolatedValue(Object obj, Object obj2, Interpolator interpolator) {
        this.startValue = obj;
        this.endValue = obj2;
        this.interpolator = interpolator;
    }

    @Override // com.airbnb.lottie.value.LottieValueCallback
    public Object getValue(LottieFrameInfo lottieFrameInfo) {
        return interpolateValue(this.startValue, this.endValue, this.interpolator.getInterpolation(lottieFrameInfo.getOverallProgress()));
    }
}
