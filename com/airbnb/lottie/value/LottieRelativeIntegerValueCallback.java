package com.airbnb.lottie.value;

import com.airbnb.lottie.utils.MiscUtils;
/* loaded from: classes.dex */
public class LottieRelativeIntegerValueCallback extends LottieValueCallback<Integer> {
    public Integer getOffset(LottieFrameInfo<Integer> lottieFrameInfo) {
        T t = this.value;
        if (t != 0) {
            return (Integer) t;
        }
        throw new IllegalArgumentException("You must provide a static value in the constructor , call setValue, or override getValue.");
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.airbnb.lottie.value.LottieValueCallback
    public Integer getValue(LottieFrameInfo<Integer> lottieFrameInfo) {
        return Integer.valueOf(MiscUtils.lerp(lottieFrameInfo.getStartValue().intValue(), lottieFrameInfo.getEndValue().intValue(), lottieFrameInfo.getInterpolatedKeyframeProgress()) + getOffset(lottieFrameInfo).intValue());
    }
}
