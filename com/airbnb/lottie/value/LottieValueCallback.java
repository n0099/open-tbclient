package com.airbnb.lottie.value;

import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
/* loaded from: classes.dex */
public class LottieValueCallback {
    public BaseKeyframeAnimation animation;
    public final LottieFrameInfo frameInfo;
    public Object value;

    public LottieValueCallback() {
        this.frameInfo = new LottieFrameInfo();
        this.value = null;
    }

    public LottieValueCallback(Object obj) {
        this.frameInfo = new LottieFrameInfo();
        this.value = null;
        this.value = obj;
    }

    public Object getValue(LottieFrameInfo lottieFrameInfo) {
        return this.value;
    }

    public final void setAnimation(BaseKeyframeAnimation baseKeyframeAnimation) {
        this.animation = baseKeyframeAnimation;
    }

    public final void setValue(Object obj) {
        this.value = obj;
        BaseKeyframeAnimation baseKeyframeAnimation = this.animation;
        if (baseKeyframeAnimation != null) {
            baseKeyframeAnimation.notifyListeners();
        }
    }

    public final Object getValueInternal(float f, float f2, Object obj, Object obj2, float f3, float f4, float f5) {
        return getValue(this.frameInfo.set(f, f2, obj, obj2, f3, f4, f5));
    }
}
