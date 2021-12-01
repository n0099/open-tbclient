package com.airbnb.lottie.animation.keyframe;

import com.airbnb.lottie.model.content.GradientColor;
import com.airbnb.lottie.value.Keyframe;
import java.util.List;
/* loaded from: classes7.dex */
public class GradientColorKeyframeAnimation extends KeyframeAnimation<GradientColor> {
    public final GradientColor gradientColor;

    public GradientColorKeyframeAnimation(List<Keyframe<GradientColor>> list) {
        super(list);
        GradientColor gradientColor = list.get(0).startValue;
        int size = gradientColor != null ? gradientColor.getSize() : 0;
        this.gradientColor = new GradientColor(new float[size], new int[size]);
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    public /* bridge */ /* synthetic */ Object getValue(Keyframe keyframe, float f2) {
        return getValue((Keyframe<GradientColor>) keyframe, f2);
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    public GradientColor getValue(Keyframe<GradientColor> keyframe, float f2) {
        this.gradientColor.lerp(keyframe.startValue, keyframe.endValue, f2);
        return this.gradientColor;
    }
}
