package com.airbnb.lottie.animation.keyframe;

import com.airbnb.lottie.model.content.GradientColor;
import com.airbnb.lottie.value.Keyframe;
import java.util.List;
/* loaded from: classes.dex */
public class GradientColorKeyframeAnimation extends KeyframeAnimation {
    public final GradientColor gradientColor;

    public GradientColorKeyframeAnimation(List list) {
        super(list);
        GradientColor gradientColor = (GradientColor) ((Keyframe) list.get(0)).startValue;
        int size = gradientColor != null ? gradientColor.getSize() : 0;
        this.gradientColor = new GradientColor(new float[size], new int[size]);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    public GradientColor getValue(Keyframe keyframe, float f) {
        this.gradientColor.lerp((GradientColor) keyframe.startValue, (GradientColor) keyframe.endValue, f);
        return this.gradientColor;
    }
}
