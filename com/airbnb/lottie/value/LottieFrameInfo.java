package com.airbnb.lottie.value;

import androidx.annotation.RestrictTo;
/* loaded from: classes.dex */
public class LottieFrameInfo<T> {
    public float endFrame;
    public T endValue;
    public float interpolatedKeyframeProgress;
    public float linearKeyframeProgress;
    public float overallProgress;
    public float startFrame;
    public T startValue;

    public float getEndFrame() {
        return this.endFrame;
    }

    public T getEndValue() {
        return this.endValue;
    }

    public float getInterpolatedKeyframeProgress() {
        return this.interpolatedKeyframeProgress;
    }

    public float getLinearKeyframeProgress() {
        return this.linearKeyframeProgress;
    }

    public float getOverallProgress() {
        return this.overallProgress;
    }

    public float getStartFrame() {
        return this.startFrame;
    }

    public T getStartValue() {
        return this.startValue;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public LottieFrameInfo<T> set(float f, float f2, T t, T t2, float f3, float f4, float f5) {
        this.startFrame = f;
        this.endFrame = f2;
        this.startValue = t;
        this.endValue = t2;
        this.linearKeyframeProgress = f3;
        this.interpolatedKeyframeProgress = f4;
        this.overallProgress = f5;
        return this;
    }
}
