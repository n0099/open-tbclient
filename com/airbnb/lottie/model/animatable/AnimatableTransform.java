package com.airbnb.lottie.model.animatable;

import android.graphics.PointF;
import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.ModifierContent;
import com.airbnb.lottie.animation.keyframe.TransformKeyframeAnimation;
import com.airbnb.lottie.model.content.ContentModel;
import com.airbnb.lottie.model.layer.BaseLayer;
/* loaded from: classes7.dex */
public class AnimatableTransform implements ModifierContent, ContentModel {
    @Nullable
    public final AnimatablePathValue anchorPoint;
    @Nullable
    public final AnimatableFloatValue endOpacity;
    @Nullable
    public final AnimatableIntegerValue opacity;
    @Nullable
    public final AnimatableValue<PointF, PointF> position;
    @Nullable
    public final AnimatableFloatValue rotation;
    @Nullable
    public final AnimatableScaleValue scale;
    @Nullable
    public final AnimatableFloatValue skew;
    @Nullable
    public final AnimatableFloatValue skewAngle;
    @Nullable
    public final AnimatableFloatValue startOpacity;

    public AnimatableTransform() {
        this(null, null, null, null, null, null, null, null, null);
    }

    public TransformKeyframeAnimation createAnimation() {
        return new TransformKeyframeAnimation(this);
    }

    @Nullable
    public AnimatablePathValue getAnchorPoint() {
        return this.anchorPoint;
    }

    @Nullable
    public AnimatableFloatValue getEndOpacity() {
        return this.endOpacity;
    }

    @Nullable
    public AnimatableIntegerValue getOpacity() {
        return this.opacity;
    }

    @Nullable
    public AnimatableValue<PointF, PointF> getPosition() {
        return this.position;
    }

    @Nullable
    public AnimatableFloatValue getRotation() {
        return this.rotation;
    }

    @Nullable
    public AnimatableScaleValue getScale() {
        return this.scale;
    }

    @Nullable
    public AnimatableFloatValue getSkew() {
        return this.skew;
    }

    @Nullable
    public AnimatableFloatValue getSkewAngle() {
        return this.skewAngle;
    }

    @Nullable
    public AnimatableFloatValue getStartOpacity() {
        return this.startOpacity;
    }

    @Override // com.airbnb.lottie.model.content.ContentModel
    @Nullable
    public Content toContent(LottieDrawable lottieDrawable, BaseLayer baseLayer) {
        return null;
    }

    public AnimatableTransform(@Nullable AnimatablePathValue animatablePathValue, @Nullable AnimatableValue<PointF, PointF> animatableValue, @Nullable AnimatableScaleValue animatableScaleValue, @Nullable AnimatableFloatValue animatableFloatValue, @Nullable AnimatableIntegerValue animatableIntegerValue, @Nullable AnimatableFloatValue animatableFloatValue2, @Nullable AnimatableFloatValue animatableFloatValue3, @Nullable AnimatableFloatValue animatableFloatValue4, @Nullable AnimatableFloatValue animatableFloatValue5) {
        this.anchorPoint = animatablePathValue;
        this.position = animatableValue;
        this.scale = animatableScaleValue;
        this.rotation = animatableFloatValue;
        this.opacity = animatableIntegerValue;
        this.startOpacity = animatableFloatValue2;
        this.endOpacity = animatableFloatValue3;
        this.skew = animatableFloatValue4;
        this.skewAngle = animatableFloatValue5;
    }
}
