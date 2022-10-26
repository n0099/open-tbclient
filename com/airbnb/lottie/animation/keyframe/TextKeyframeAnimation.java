package com.airbnb.lottie.animation.keyframe;

import com.airbnb.lottie.model.DocumentData;
import com.airbnb.lottie.value.Keyframe;
import java.util.List;
/* loaded from: classes.dex */
public class TextKeyframeAnimation extends KeyframeAnimation {
    public TextKeyframeAnimation(List list) {
        super(list);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    public DocumentData getValue(Keyframe keyframe, float f) {
        return (DocumentData) keyframe.startValue;
    }
}
