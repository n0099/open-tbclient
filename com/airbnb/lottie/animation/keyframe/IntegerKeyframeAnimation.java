package com.airbnb.lottie.animation.keyframe;

import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.Keyframe;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.List;
/* loaded from: classes7.dex */
public class IntegerKeyframeAnimation extends KeyframeAnimation<Integer> {
    public IntegerKeyframeAnimation(List<Keyframe<Integer>> list) {
        super(list);
    }

    public int getIntValue(Keyframe<Integer> keyframe, float f2) {
        Integer num;
        if (keyframe.startValue != null && keyframe.endValue != null) {
            LottieValueCallback<A> lottieValueCallback = this.valueCallback;
            if (lottieValueCallback != 0 && (num = (Integer) lottieValueCallback.getValueInternal(keyframe.startFrame, keyframe.endFrame.floatValue(), keyframe.startValue, keyframe.endValue, f2, getLinearCurrentKeyframeProgress(), getProgress())) != null) {
                return num.intValue();
            }
            return MiscUtils.lerp(keyframe.getStartValueInt(), keyframe.getEndValueInt(), f2);
        }
        throw new IllegalStateException("Missing values for keyframe.");
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    public /* bridge */ /* synthetic */ Object getValue(Keyframe keyframe, float f2) {
        return getValue((Keyframe<Integer>) keyframe, f2);
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    public Integer getValue(Keyframe<Integer> keyframe, float f2) {
        return Integer.valueOf(getIntValue(keyframe, f2));
    }

    public int getIntValue() {
        return getIntValue(getCurrentKeyframe(), getInterpolatedCurrentKeyframeProgress());
    }
}
