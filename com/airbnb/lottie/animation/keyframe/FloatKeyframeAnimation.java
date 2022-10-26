package com.airbnb.lottie.animation.keyframe;

import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.Keyframe;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.List;
/* loaded from: classes.dex */
public class FloatKeyframeAnimation extends KeyframeAnimation {
    public FloatKeyframeAnimation(List list) {
        super(list);
    }

    public float getFloatValue() {
        return getFloatValue(getCurrentKeyframe(), getInterpolatedCurrentKeyframeProgress());
    }

    public float getFloatValue(Keyframe keyframe, float f) {
        Float f2;
        if (keyframe.startValue != null && keyframe.endValue != null) {
            LottieValueCallback lottieValueCallback = this.valueCallback;
            if (lottieValueCallback != null && (f2 = (Float) lottieValueCallback.getValueInternal(keyframe.startFrame, keyframe.endFrame.floatValue(), keyframe.startValue, keyframe.endValue, f, getLinearCurrentKeyframeProgress(), getProgress())) != null) {
                return f2.floatValue();
            }
            return MiscUtils.lerp(keyframe.getStartValueFloat(), keyframe.getEndValueFloat(), f);
        }
        throw new IllegalStateException("Missing values for keyframe.");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    public Float getValue(Keyframe keyframe, float f) {
        return Float.valueOf(getFloatValue(keyframe, f));
    }
}
