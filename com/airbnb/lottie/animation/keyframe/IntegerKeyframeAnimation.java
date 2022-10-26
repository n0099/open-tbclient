package com.airbnb.lottie.animation.keyframe;

import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.Keyframe;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.List;
/* loaded from: classes.dex */
public class IntegerKeyframeAnimation extends KeyframeAnimation {
    public IntegerKeyframeAnimation(List list) {
        super(list);
    }

    public int getIntValue() {
        return getIntValue(getCurrentKeyframe(), getInterpolatedCurrentKeyframeProgress());
    }

    public int getIntValue(Keyframe keyframe, float f) {
        Integer num;
        if (keyframe.startValue != null && keyframe.endValue != null) {
            LottieValueCallback lottieValueCallback = this.valueCallback;
            if (lottieValueCallback != null && (num = (Integer) lottieValueCallback.getValueInternal(keyframe.startFrame, keyframe.endFrame.floatValue(), keyframe.startValue, keyframe.endValue, f, getLinearCurrentKeyframeProgress(), getProgress())) != null) {
                return num.intValue();
            }
            return MiscUtils.lerp(keyframe.getStartValueInt(), keyframe.getEndValueInt(), f);
        }
        throw new IllegalStateException("Missing values for keyframe.");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    public Integer getValue(Keyframe keyframe, float f) {
        return Integer.valueOf(getIntValue(keyframe, f));
    }
}
