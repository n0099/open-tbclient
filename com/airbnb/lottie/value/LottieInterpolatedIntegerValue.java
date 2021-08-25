package com.airbnb.lottie.value;

import android.view.animation.Interpolator;
import com.airbnb.lottie.utils.MiscUtils;
/* loaded from: classes4.dex */
public class LottieInterpolatedIntegerValue extends LottieInterpolatedValue<Integer> {
    public LottieInterpolatedIntegerValue(Integer num, Integer num2) {
        super(num, num2);
    }

    public LottieInterpolatedIntegerValue(Integer num, Integer num2, Interpolator interpolator) {
        super(num, num2, interpolator);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.airbnb.lottie.value.LottieInterpolatedValue
    public Integer interpolateValue(Integer num, Integer num2, float f2) {
        return Integer.valueOf(MiscUtils.lerp(num.intValue(), num2.intValue(), f2));
    }
}
