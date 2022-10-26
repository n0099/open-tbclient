package com.airbnb.lottie.animation.keyframe;

import android.graphics.PointF;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.value.Keyframe;
import java.util.Collections;
/* loaded from: classes.dex */
public class SplitDimensionPathKeyframeAnimation extends BaseKeyframeAnimation {
    public final PointF point;
    public final BaseKeyframeAnimation xAnimation;
    public final BaseKeyframeAnimation yAnimation;

    public SplitDimensionPathKeyframeAnimation(BaseKeyframeAnimation baseKeyframeAnimation, BaseKeyframeAnimation baseKeyframeAnimation2) {
        super(Collections.emptyList());
        this.point = new PointF();
        this.xAnimation = baseKeyframeAnimation;
        this.yAnimation = baseKeyframeAnimation2;
        setProgress(getProgress());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    public PointF getValue(Keyframe keyframe, float f) {
        return this.point;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    public PointF getValue() {
        return getValue((Keyframe) null, 0.0f);
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    public void setProgress(float f) {
        this.xAnimation.setProgress(f);
        this.yAnimation.setProgress(f);
        this.point.set(((Float) this.xAnimation.getValue()).floatValue(), ((Float) this.yAnimation.getValue()).floatValue());
        for (int i = 0; i < this.listeners.size(); i++) {
            ((BaseKeyframeAnimation.AnimationListener) this.listeners.get(i)).onValueChanged();
        }
    }
}
