package com.airbnb.lottie.value;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import com.airbnb.lottie.utils.MiscUtils;
/* loaded from: classes9.dex */
public class LottieInterpolatedPointValue extends LottieInterpolatedValue<PointF> {
    public final PointF point;

    public LottieInterpolatedPointValue(PointF pointF, PointF pointF2) {
        super(pointF, pointF2);
        this.point = new PointF();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.airbnb.lottie.value.LottieInterpolatedValue
    public PointF interpolateValue(PointF pointF, PointF pointF2, float f2) {
        this.point.set(MiscUtils.lerp(pointF.x, pointF2.x, f2), MiscUtils.lerp(pointF.y, pointF2.y, f2));
        return this.point;
    }

    public LottieInterpolatedPointValue(PointF pointF, PointF pointF2, Interpolator interpolator) {
        super(pointF, pointF2, interpolator);
        this.point = new PointF();
    }
}
