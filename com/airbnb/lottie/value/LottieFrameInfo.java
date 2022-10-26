package com.airbnb.lottie.value;
/* loaded from: classes.dex */
public class LottieFrameInfo {
    public float endFrame;
    public Object endValue;
    public float interpolatedKeyframeProgress;
    public float linearKeyframeProgress;
    public float overallProgress;
    public float startFrame;
    public Object startValue;

    public float getEndFrame() {
        return this.endFrame;
    }

    public Object getEndValue() {
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

    public Object getStartValue() {
        return this.startValue;
    }

    public LottieFrameInfo set(float f, float f2, Object obj, Object obj2, float f3, float f4, float f5) {
        this.startFrame = f;
        this.endFrame = f2;
        this.startValue = obj;
        this.endValue = obj2;
        this.linearKeyframeProgress = f3;
        this.interpolatedKeyframeProgress = f4;
        this.overallProgress = f5;
        return this;
    }
}
