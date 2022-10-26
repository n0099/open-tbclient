package com.airbnb.lottie.value;

import com.airbnb.lottie.utils.MiscUtils;
/* loaded from: classes.dex */
public class LottieRelativeIntegerValueCallback extends LottieValueCallback {
    public Integer getOffset(LottieFrameInfo lottieFrameInfo) {
        Object obj = this.value;
        if (obj != null) {
            return (Integer) obj;
        }
        throw new IllegalArgumentException("You must provide a static value in the constructor , call setValue, or override getValue.");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.airbnb.lottie.value.LottieValueCallback
    public Integer getValue(LottieFrameInfo lottieFrameInfo) {
        return Integer.valueOf(MiscUtils.lerp(((Integer) lottieFrameInfo.getStartValue()).intValue(), ((Integer) lottieFrameInfo.getEndValue()).intValue(), lottieFrameInfo.getInterpolatedKeyframeProgress()) + getOffset(lottieFrameInfo).intValue());
    }
}
