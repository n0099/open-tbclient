package com.airbnb.lottie.animation.keyframe;

import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.Keyframe;
import com.airbnb.lottie.value.LottieValueCallback;
import com.airbnb.lottie.value.ScaleXY;
import java.util.List;
/* loaded from: classes.dex */
public class ScaleKeyframeAnimation extends KeyframeAnimation {
    public final ScaleXY scaleXY;

    public ScaleKeyframeAnimation(List list) {
        super(list);
        this.scaleXY = new ScaleXY();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    public ScaleXY getValue(Keyframe keyframe, float f) {
        Object obj;
        ScaleXY scaleXY;
        Object obj2 = keyframe.startValue;
        if (obj2 != null && (obj = keyframe.endValue) != null) {
            ScaleXY scaleXY2 = (ScaleXY) obj2;
            ScaleXY scaleXY3 = (ScaleXY) obj;
            LottieValueCallback lottieValueCallback = this.valueCallback;
            if (lottieValueCallback != null && (scaleXY = (ScaleXY) lottieValueCallback.getValueInternal(keyframe.startFrame, keyframe.endFrame.floatValue(), scaleXY2, scaleXY3, f, getLinearCurrentKeyframeProgress(), getProgress())) != null) {
                return scaleXY;
            }
            this.scaleXY.set(MiscUtils.lerp(scaleXY2.getScaleX(), scaleXY3.getScaleX(), f), MiscUtils.lerp(scaleXY2.getScaleY(), scaleXY3.getScaleY(), f));
            return this.scaleXY;
        }
        throw new IllegalStateException("Missing values for keyframe.");
    }
}
