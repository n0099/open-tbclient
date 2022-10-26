package com.airbnb.lottie.animation.keyframe;

import com.airbnb.lottie.utils.GammaEvaluator;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.Keyframe;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.List;
/* loaded from: classes.dex */
public class ColorKeyframeAnimation extends KeyframeAnimation {
    public ColorKeyframeAnimation(List list) {
        super(list);
    }

    public int getIntValue() {
        return getIntValue(getCurrentKeyframe(), getInterpolatedCurrentKeyframeProgress());
    }

    public int getIntValue(Keyframe keyframe, float f) {
        Integer num;
        Object obj = keyframe.startValue;
        if (obj != null && keyframe.endValue != null) {
            int intValue = ((Integer) obj).intValue();
            int intValue2 = ((Integer) keyframe.endValue).intValue();
            LottieValueCallback lottieValueCallback = this.valueCallback;
            if (lottieValueCallback != null && (num = (Integer) lottieValueCallback.getValueInternal(keyframe.startFrame, keyframe.endFrame.floatValue(), Integer.valueOf(intValue), Integer.valueOf(intValue2), f, getLinearCurrentKeyframeProgress(), getProgress())) != null) {
                return num.intValue();
            }
            return GammaEvaluator.evaluate(MiscUtils.clamp(f, 0.0f, 1.0f), intValue, intValue2);
        }
        throw new IllegalStateException("Missing values for keyframe.");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    public Integer getValue(Keyframe keyframe, float f) {
        return Integer.valueOf(getIntValue(keyframe, f));
    }
}
