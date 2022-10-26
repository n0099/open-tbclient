package com.airbnb.lottie.value;

import android.graphics.PointF;
import com.airbnb.lottie.utils.MiscUtils;
/* loaded from: classes.dex */
public class LottieRelativePointValueCallback extends LottieValueCallback {
    public final PointF point;

    public LottieRelativePointValueCallback() {
        this.point = new PointF();
    }

    public LottieRelativePointValueCallback(PointF pointF) {
        super(pointF);
        this.point = new PointF();
    }

    public PointF getOffset(LottieFrameInfo lottieFrameInfo) {
        Object obj = this.value;
        if (obj != null) {
            return (PointF) obj;
        }
        throw new IllegalArgumentException("You must provide a static value in the constructor , call setValue, or override getValue.");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.airbnb.lottie.value.LottieValueCallback
    public final PointF getValue(LottieFrameInfo lottieFrameInfo) {
        this.point.set(MiscUtils.lerp(((PointF) lottieFrameInfo.getStartValue()).x, ((PointF) lottieFrameInfo.getEndValue()).x, lottieFrameInfo.getInterpolatedKeyframeProgress()), MiscUtils.lerp(((PointF) lottieFrameInfo.getStartValue()).y, ((PointF) lottieFrameInfo.getEndValue()).y, lottieFrameInfo.getInterpolatedKeyframeProgress()));
        PointF offset = getOffset(lottieFrameInfo);
        this.point.offset(offset.x, offset.y);
        return this.point;
    }
}
