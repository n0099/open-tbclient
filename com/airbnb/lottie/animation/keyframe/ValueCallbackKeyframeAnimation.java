package com.airbnb.lottie.animation.keyframe;

import com.airbnb.lottie.value.Keyframe;
import com.airbnb.lottie.value.LottieFrameInfo;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.Collections;
/* loaded from: classes.dex */
public class ValueCallbackKeyframeAnimation extends BaseKeyframeAnimation {
    public final LottieFrameInfo frameInfo;
    public final Object valueCallbackValue;

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    public float getEndProgress() {
        return 1.0f;
    }

    public ValueCallbackKeyframeAnimation(LottieValueCallback lottieValueCallback) {
        this(lottieValueCallback, null);
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    public void setProgress(float f) {
        this.progress = f;
    }

    public ValueCallbackKeyframeAnimation(LottieValueCallback lottieValueCallback, Object obj) {
        super(Collections.emptyList());
        this.frameInfo = new LottieFrameInfo();
        setValueCallback(lottieValueCallback);
        this.valueCallbackValue = obj;
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    public Object getValue(Keyframe keyframe, float f) {
        return getValue();
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    public Object getValue() {
        LottieValueCallback lottieValueCallback = this.valueCallback;
        Object obj = this.valueCallbackValue;
        return lottieValueCallback.getValueInternal(0.0f, 0.0f, obj, obj, getProgress(), getProgress(), getProgress());
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    public void notifyListeners() {
        if (this.valueCallback != null) {
            super.notifyListeners();
        }
    }
}
