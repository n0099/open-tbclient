package com.airbnb.lottie.animation.content;

import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.FloatKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.content.RectangleShape;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.List;
/* loaded from: classes.dex */
public class RectangleContent implements BaseKeyframeAnimation.AnimationListener, KeyPathElementContent, PathContent {
    public final BaseKeyframeAnimation cornerRadiusAnimation;
    public final boolean hidden;
    public boolean isPathValid;
    public final LottieDrawable lottieDrawable;
    public final String name;
    public final BaseKeyframeAnimation positionAnimation;
    public final BaseKeyframeAnimation sizeAnimation;
    public final Path path = new Path();
    public final RectF rect = new RectF();
    public CompoundTrimPathContent trimPaths = new CompoundTrimPathContent();

    public RectangleContent(LottieDrawable lottieDrawable, BaseLayer baseLayer, RectangleShape rectangleShape) {
        this.name = rectangleShape.getName();
        this.hidden = rectangleShape.isHidden();
        this.lottieDrawable = lottieDrawable;
        this.positionAnimation = rectangleShape.getPosition().createAnimation();
        this.sizeAnimation = rectangleShape.getSize().createAnimation();
        this.cornerRadiusAnimation = rectangleShape.getCornerRadius().createAnimation();
        baseLayer.addAnimation(this.positionAnimation);
        baseLayer.addAnimation(this.sizeAnimation);
        baseLayer.addAnimation(this.cornerRadiusAnimation);
        this.positionAnimation.addUpdateListener(this);
        this.sizeAnimation.addUpdateListener(this);
        this.cornerRadiusAnimation.addUpdateListener(this);
    }

    private void invalidate() {
        this.isPathValid = false;
        this.lottieDrawable.invalidateSelf();
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public String getName() {
        return this.name;
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener
    public void onValueChanged() {
        invalidate();
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public void addValueCallback(Object obj, LottieValueCallback lottieValueCallback) {
        if (obj == LottieProperty.RECTANGLE_SIZE) {
            this.sizeAnimation.setValueCallback(lottieValueCallback);
        } else if (obj == LottieProperty.POSITION) {
            this.positionAnimation.setValueCallback(lottieValueCallback);
        } else if (obj == LottieProperty.CORNER_RADIUS) {
            this.cornerRadiusAnimation.setValueCallback(lottieValueCallback);
        }
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public void setContents(List list, List list2) {
        for (int i = 0; i < list.size(); i++) {
            Content content = (Content) list.get(i);
            if (content instanceof TrimPathContent) {
                TrimPathContent trimPathContent = (TrimPathContent) content;
                if (trimPathContent.getType() == ShapeTrimPath.Type.SIMULTANEOUSLY) {
                    this.trimPaths.addTrimPath(trimPathContent);
                    trimPathContent.addListener(this);
                }
            }
        }
    }

    @Override // com.airbnb.lottie.animation.content.PathContent
    public Path getPath() {
        float floatValue;
        if (this.isPathValid) {
            return this.path;
        }
        this.path.reset();
        if (this.hidden) {
            this.isPathValid = true;
            return this.path;
        }
        PointF pointF = (PointF) this.sizeAnimation.getValue();
        float f = pointF.x / 2.0f;
        float f2 = pointF.y / 2.0f;
        BaseKeyframeAnimation baseKeyframeAnimation = this.cornerRadiusAnimation;
        if (baseKeyframeAnimation == null) {
            floatValue = 0.0f;
        } else {
            floatValue = ((FloatKeyframeAnimation) baseKeyframeAnimation).getFloatValue();
        }
        float min = Math.min(f, f2);
        if (floatValue > min) {
            floatValue = min;
        }
        PointF pointF2 = (PointF) this.positionAnimation.getValue();
        this.path.moveTo(pointF2.x + f, (pointF2.y - f2) + floatValue);
        this.path.lineTo(pointF2.x + f, (pointF2.y + f2) - floatValue);
        int i = (floatValue > 0.0f ? 1 : (floatValue == 0.0f ? 0 : -1));
        if (i > 0) {
            RectF rectF = this.rect;
            float f3 = pointF2.x;
            float f4 = floatValue * 2.0f;
            float f5 = pointF2.y;
            rectF.set((f3 + f) - f4, (f5 + f2) - f4, f3 + f, f5 + f2);
            this.path.arcTo(this.rect, 0.0f, 90.0f, false);
        }
        this.path.lineTo((pointF2.x - f) + floatValue, pointF2.y + f2);
        if (i > 0) {
            RectF rectF2 = this.rect;
            float f6 = pointF2.x;
            float f7 = pointF2.y;
            float f8 = floatValue * 2.0f;
            rectF2.set(f6 - f, (f7 + f2) - f8, (f6 - f) + f8, f7 + f2);
            this.path.arcTo(this.rect, 90.0f, 90.0f, false);
        }
        this.path.lineTo(pointF2.x - f, (pointF2.y - f2) + floatValue);
        if (i > 0) {
            RectF rectF3 = this.rect;
            float f9 = pointF2.x;
            float f10 = pointF2.y;
            float f11 = floatValue * 2.0f;
            rectF3.set(f9 - f, f10 - f2, (f9 - f) + f11, (f10 - f2) + f11);
            this.path.arcTo(this.rect, 180.0f, 90.0f, false);
        }
        this.path.lineTo((pointF2.x + f) - floatValue, pointF2.y - f2);
        if (i > 0) {
            RectF rectF4 = this.rect;
            float f12 = pointF2.x;
            float f13 = floatValue * 2.0f;
            float f14 = pointF2.y;
            rectF4.set((f12 + f) - f13, f14 - f2, f12 + f, (f14 - f2) + f13);
            this.path.arcTo(this.rect, 270.0f, 90.0f, false);
        }
        this.path.close();
        this.trimPaths.apply(this.path);
        this.isPathValid = true;
        return this.path;
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public void resolveKeyPath(KeyPath keyPath, int i, List list, KeyPath keyPath2) {
        MiscUtils.resolveKeyPath(keyPath, i, list, keyPath2, this);
    }
}
