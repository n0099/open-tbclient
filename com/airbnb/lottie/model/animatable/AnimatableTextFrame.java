package com.airbnb.lottie.model.animatable;

import com.airbnb.lottie.animation.keyframe.TextKeyframeAnimation;
import java.util.List;
/* loaded from: classes.dex */
public class AnimatableTextFrame extends BaseAnimatableValue {
    public AnimatableTextFrame(List list) {
        super(list);
    }

    @Override // com.airbnb.lottie.model.animatable.BaseAnimatableValue, com.airbnb.lottie.model.animatable.AnimatableValue
    public /* bridge */ /* synthetic */ List getKeyframes() {
        return super.getKeyframes();
    }

    @Override // com.airbnb.lottie.model.animatable.BaseAnimatableValue, com.airbnb.lottie.model.animatable.AnimatableValue
    public /* bridge */ /* synthetic */ boolean isStatic() {
        return super.isStatic();
    }

    @Override // com.airbnb.lottie.model.animatable.BaseAnimatableValue
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.airbnb.lottie.model.animatable.AnimatableValue
    public TextKeyframeAnimation createAnimation() {
        return new TextKeyframeAnimation(this.keyframes);
    }
}
