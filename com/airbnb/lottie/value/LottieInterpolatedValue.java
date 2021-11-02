package com.airbnb.lottie.value;

import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
/* loaded from: classes6.dex */
public abstract class LottieInterpolatedValue<T> extends LottieValueCallback<T> {
    public final T endValue;
    public final Interpolator interpolator;
    public final T startValue;

    public LottieInterpolatedValue(T t, T t2) {
        this(t, t2, new LinearInterpolator());
    }

    @Override // com.airbnb.lottie.value.LottieValueCallback
    public T getValue(LottieFrameInfo<T> lottieFrameInfo) {
        return interpolateValue(this.startValue, this.endValue, this.interpolator.getInterpolation(lottieFrameInfo.getOverallProgress()));
    }

    public abstract T interpolateValue(T t, T t2, float f2);

    public LottieInterpolatedValue(T t, T t2, Interpolator interpolator) {
        this.startValue = t;
        this.endValue = t2;
        this.interpolator = interpolator;
    }
}
