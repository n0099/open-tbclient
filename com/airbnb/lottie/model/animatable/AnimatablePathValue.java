package com.airbnb.lottie.model.animatable;

import android.graphics.PointF;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.PathKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.PointKeyframeAnimation;
import com.airbnb.lottie.value.Keyframe;
import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
public class AnimatablePathValue implements AnimatableValue {
    public final List keyframes;

    public AnimatablePathValue() {
        this.keyframes = Collections.singletonList(new Keyframe(new PointF(0.0f, 0.0f)));
    }

    @Override // com.airbnb.lottie.model.animatable.AnimatableValue
    public BaseKeyframeAnimation createAnimation() {
        if (((Keyframe) this.keyframes.get(0)).isStatic()) {
            return new PointKeyframeAnimation(this.keyframes);
        }
        return new PathKeyframeAnimation(this.keyframes);
    }

    @Override // com.airbnb.lottie.model.animatable.AnimatableValue
    public List getKeyframes() {
        return this.keyframes;
    }

    @Override // com.airbnb.lottie.model.animatable.AnimatableValue
    public boolean isStatic() {
        if (this.keyframes.size() != 1 || !((Keyframe) this.keyframes.get(0)).isStatic()) {
            return false;
        }
        return true;
    }

    public AnimatablePathValue(List list) {
        this.keyframes = list;
    }
}
