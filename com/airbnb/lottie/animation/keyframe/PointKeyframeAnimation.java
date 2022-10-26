package com.airbnb.lottie.animation.keyframe;

import android.graphics.PointF;
import com.airbnb.lottie.value.Keyframe;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.List;
/* loaded from: classes.dex */
public class PointKeyframeAnimation extends KeyframeAnimation {
    public final PointF point;

    public PointKeyframeAnimation(List list) {
        super(list);
        this.point = new PointF();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    public PointF getValue(Keyframe keyframe, float f) {
        Object obj;
        PointF pointF;
        Object obj2 = keyframe.startValue;
        if (obj2 != null && (obj = keyframe.endValue) != null) {
            PointF pointF2 = (PointF) obj2;
            PointF pointF3 = (PointF) obj;
            LottieValueCallback lottieValueCallback = this.valueCallback;
            if (lottieValueCallback != null && (pointF = (PointF) lottieValueCallback.getValueInternal(keyframe.startFrame, keyframe.endFrame.floatValue(), pointF2, pointF3, f, getLinearCurrentKeyframeProgress(), getProgress())) != null) {
                return pointF;
            }
            PointF pointF4 = this.point;
            float f2 = pointF2.x;
            float f3 = pointF2.y;
            pointF4.set(f2 + ((pointF3.x - f2) * f), f3 + (f * (pointF3.y - f3)));
            return this.point;
        }
        throw new IllegalStateException("Missing values for keyframe.");
    }
}
