package com.airbnb.lottie.animation.keyframe;

import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.Keyframe;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.List;
/* loaded from: classes6.dex */
public class FloatKeyframeAnimation extends KeyframeAnimation<Float> {
    public FloatKeyframeAnimation(List<Keyframe<Float>> list) {
        super(list);
    }

    public float getFloatValue(Keyframe<Float> keyframe, float f2) {
        Float f3;
        if (keyframe.startValue != null && keyframe.endValue != null) {
            LottieValueCallback<A> lottieValueCallback = this.valueCallback;
            if (lottieValueCallback != 0 && (f3 = (Float) lottieValueCallback.getValueInternal(keyframe.startFrame, keyframe.endFrame.floatValue(), keyframe.startValue, keyframe.endValue, f2, getLinearCurrentKeyframeProgress(), getProgress())) != null) {
                return f3.floatValue();
            }
            return MiscUtils.lerp(keyframe.getStartValueFloat(), keyframe.getEndValueFloat(), f2);
        }
        throw new IllegalStateException("Missing values for keyframe.");
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    public /* bridge */ /* synthetic */ Object getValue(Keyframe keyframe, float f2) {
        return getValue((Keyframe<Float>) keyframe, f2);
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    public Float getValue(Keyframe<Float> keyframe, float f2) {
        return Float.valueOf(getFloatValue(keyframe, f2));
    }

    public float getFloatValue() {
        return getFloatValue(getCurrentKeyframe(), getInterpolatedCurrentKeyframeProgress());
    }
}
