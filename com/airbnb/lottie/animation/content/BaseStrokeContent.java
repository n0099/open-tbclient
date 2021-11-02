package com.airbnb.lottie.animation.content;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import com.airbnb.lottie.L;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.LPaint;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.FloatKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.IntegerKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public abstract class BaseStrokeContent implements BaseKeyframeAnimation.AnimationListener, KeyPathElementContent, DrawingContent {
    @Nullable
    public BaseKeyframeAnimation<ColorFilter, ColorFilter> colorFilterAnimation;
    public final List<BaseKeyframeAnimation<?, Float>> dashPatternAnimations;
    @Nullable
    public final BaseKeyframeAnimation<?, Float> dashPatternOffsetAnimation;
    public final float[] dashPatternValues;
    public final BaseLayer layer;
    public final LottieDrawable lottieDrawable;
    public final BaseKeyframeAnimation<?, Integer> opacityAnimation;
    public final Paint paint;
    public final BaseKeyframeAnimation<?, Float> widthAnimation;
    public final PathMeasure pm = new PathMeasure();
    public final Path path = new Path();
    public final Path trimPathPath = new Path();
    public final RectF rect = new RectF();
    public final List<PathGroup> pathGroups = new ArrayList();

    /* loaded from: classes6.dex */
    public static final class PathGroup {
        public final List<PathContent> paths;
        @Nullable
        public final TrimPathContent trimPath;

        public PathGroup(@Nullable TrimPathContent trimPathContent) {
            this.paths = new ArrayList();
            this.trimPath = trimPathContent;
        }
    }

    public BaseStrokeContent(LottieDrawable lottieDrawable, BaseLayer baseLayer, Paint.Cap cap, Paint.Join join, float f2, AnimatableIntegerValue animatableIntegerValue, AnimatableFloatValue animatableFloatValue, List<AnimatableFloatValue> list, AnimatableFloatValue animatableFloatValue2) {
        LPaint lPaint = new LPaint(1);
        this.paint = lPaint;
        this.lottieDrawable = lottieDrawable;
        this.layer = baseLayer;
        lPaint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeCap(cap);
        this.paint.setStrokeJoin(join);
        this.paint.setStrokeMiter(f2);
        this.opacityAnimation = animatableIntegerValue.createAnimation();
        this.widthAnimation = animatableFloatValue.createAnimation();
        if (animatableFloatValue2 == null) {
            this.dashPatternOffsetAnimation = null;
        } else {
            this.dashPatternOffsetAnimation = animatableFloatValue2.createAnimation();
        }
        this.dashPatternAnimations = new ArrayList(list.size());
        this.dashPatternValues = new float[list.size()];
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.dashPatternAnimations.add(list.get(i2).createAnimation());
        }
        baseLayer.addAnimation(this.opacityAnimation);
        baseLayer.addAnimation(this.widthAnimation);
        for (int i3 = 0; i3 < this.dashPatternAnimations.size(); i3++) {
            baseLayer.addAnimation(this.dashPatternAnimations.get(i3));
        }
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation = this.dashPatternOffsetAnimation;
        if (baseKeyframeAnimation != null) {
            baseLayer.addAnimation(baseKeyframeAnimation);
        }
        this.opacityAnimation.addUpdateListener(this);
        this.widthAnimation.addUpdateListener(this);
        for (int i4 = 0; i4 < list.size(); i4++) {
            this.dashPatternAnimations.get(i4).addUpdateListener(this);
        }
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation2 = this.dashPatternOffsetAnimation;
        if (baseKeyframeAnimation2 != null) {
            baseKeyframeAnimation2.addUpdateListener(this);
        }
    }

    private void applyDashPatternIfNeeded(Matrix matrix) {
        L.beginSection("StrokeContent#applyDashPattern");
        if (this.dashPatternAnimations.isEmpty()) {
            L.endSection("StrokeContent#applyDashPattern");
            return;
        }
        float scale = Utils.getScale(matrix);
        for (int i2 = 0; i2 < this.dashPatternAnimations.size(); i2++) {
            this.dashPatternValues[i2] = this.dashPatternAnimations.get(i2).getValue().floatValue();
            if (i2 % 2 == 0) {
                float[] fArr = this.dashPatternValues;
                if (fArr[i2] < 1.0f) {
                    fArr[i2] = 1.0f;
                }
            } else {
                float[] fArr2 = this.dashPatternValues;
                if (fArr2[i2] < 0.1f) {
                    fArr2[i2] = 0.1f;
                }
            }
            float[] fArr3 = this.dashPatternValues;
            fArr3[i2] = fArr3[i2] * scale;
        }
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation = this.dashPatternOffsetAnimation;
        this.paint.setPathEffect(new DashPathEffect(this.dashPatternValues, baseKeyframeAnimation == null ? 0.0f : scale * baseKeyframeAnimation.getValue().floatValue()));
        L.endSection("StrokeContent#applyDashPattern");
    }

    private void applyTrimPath(Canvas canvas, PathGroup pathGroup, Matrix matrix) {
        L.beginSection("StrokeContent#applyTrimPath");
        if (pathGroup.trimPath == null) {
            L.endSection("StrokeContent#applyTrimPath");
            return;
        }
        this.path.reset();
        for (int size = pathGroup.paths.size() - 1; size >= 0; size--) {
            this.path.addPath(((PathContent) pathGroup.paths.get(size)).getPath(), matrix);
        }
        this.pm.setPath(this.path, false);
        float length = this.pm.getLength();
        while (this.pm.nextContour()) {
            length += this.pm.getLength();
        }
        float floatValue = (pathGroup.trimPath.getOffset().getValue().floatValue() * length) / 360.0f;
        float floatValue2 = ((pathGroup.trimPath.getStart().getValue().floatValue() * length) / 100.0f) + floatValue;
        float floatValue3 = ((pathGroup.trimPath.getEnd().getValue().floatValue() * length) / 100.0f) + floatValue;
        float f2 = 0.0f;
        for (int size2 = pathGroup.paths.size() - 1; size2 >= 0; size2--) {
            this.trimPathPath.set(((PathContent) pathGroup.paths.get(size2)).getPath());
            this.trimPathPath.transform(matrix);
            this.pm.setPath(this.trimPathPath, false);
            float length2 = this.pm.getLength();
            if (floatValue3 > length) {
                float f3 = floatValue3 - length;
                if (f3 < f2 + length2 && f2 < f3) {
                    Utils.applyTrimPathIfNeeded(this.trimPathPath, floatValue2 > length ? (floatValue2 - length) / length2 : 0.0f, Math.min(f3 / length2, 1.0f), 0.0f);
                    canvas.drawPath(this.trimPathPath, this.paint);
                    f2 += length2;
                }
            }
            float f4 = f2 + length2;
            if (f4 >= floatValue2 && f2 <= floatValue3) {
                if (f4 <= floatValue3 && floatValue2 < f2) {
                    canvas.drawPath(this.trimPathPath, this.paint);
                } else {
                    Utils.applyTrimPathIfNeeded(this.trimPathPath, floatValue2 < f2 ? 0.0f : (floatValue2 - f2) / length2, floatValue3 <= f4 ? (floatValue3 - f2) / length2 : 1.0f, 0.0f);
                    canvas.drawPath(this.trimPathPath, this.paint);
                }
            }
            f2 += length2;
        }
        L.endSection("StrokeContent#applyTrimPath");
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    @CallSuper
    public <T> void addValueCallback(T t, @Nullable LottieValueCallback<T> lottieValueCallback) {
        if (t == LottieProperty.OPACITY) {
            this.opacityAnimation.setValueCallback(lottieValueCallback);
        } else if (t == LottieProperty.STROKE_WIDTH) {
            this.widthAnimation.setValueCallback(lottieValueCallback);
        } else if (t == LottieProperty.COLOR_FILTER) {
            BaseKeyframeAnimation<ColorFilter, ColorFilter> baseKeyframeAnimation = this.colorFilterAnimation;
            if (baseKeyframeAnimation != null) {
                this.layer.removeAnimation(baseKeyframeAnimation);
            }
            if (lottieValueCallback == null) {
                this.colorFilterAnimation = null;
                return;
            }
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation = new ValueCallbackKeyframeAnimation(lottieValueCallback);
            this.colorFilterAnimation = valueCallbackKeyframeAnimation;
            valueCallbackKeyframeAnimation.addUpdateListener(this);
            this.layer.addAnimation(this.colorFilterAnimation);
        }
    }

    @Override // com.airbnb.lottie.animation.content.DrawingContent
    public void draw(Canvas canvas, Matrix matrix, int i2) {
        L.beginSection("StrokeContent#draw");
        if (Utils.hasZeroScaleAxis(matrix)) {
            L.endSection("StrokeContent#draw");
            return;
        }
        this.paint.setAlpha(MiscUtils.clamp((int) ((((i2 / 255.0f) * ((IntegerKeyframeAnimation) this.opacityAnimation).getIntValue()) / 100.0f) * 255.0f), 0, 255));
        this.paint.setStrokeWidth(((FloatKeyframeAnimation) this.widthAnimation).getFloatValue() * Utils.getScale(matrix));
        if (this.paint.getStrokeWidth() <= 0.0f) {
            L.endSection("StrokeContent#draw");
            return;
        }
        applyDashPatternIfNeeded(matrix);
        BaseKeyframeAnimation<ColorFilter, ColorFilter> baseKeyframeAnimation = this.colorFilterAnimation;
        if (baseKeyframeAnimation != null) {
            this.paint.setColorFilter(baseKeyframeAnimation.getValue());
        }
        for (int i3 = 0; i3 < this.pathGroups.size(); i3++) {
            PathGroup pathGroup = this.pathGroups.get(i3);
            if (pathGroup.trimPath != null) {
                applyTrimPath(canvas, pathGroup, matrix);
            } else {
                L.beginSection("StrokeContent#buildPath");
                this.path.reset();
                for (int size = pathGroup.paths.size() - 1; size >= 0; size--) {
                    this.path.addPath(((PathContent) pathGroup.paths.get(size)).getPath(), matrix);
                }
                L.endSection("StrokeContent#buildPath");
                L.beginSection("StrokeContent#drawPath");
                canvas.drawPath(this.path, this.paint);
                L.endSection("StrokeContent#drawPath");
            }
        }
        L.endSection("StrokeContent#draw");
    }

    @Override // com.airbnb.lottie.animation.content.DrawingContent
    public void getBounds(RectF rectF, Matrix matrix, boolean z) {
        L.beginSection("StrokeContent#getBounds");
        this.path.reset();
        for (int i2 = 0; i2 < this.pathGroups.size(); i2++) {
            PathGroup pathGroup = this.pathGroups.get(i2);
            for (int i3 = 0; i3 < pathGroup.paths.size(); i3++) {
                this.path.addPath(((PathContent) pathGroup.paths.get(i3)).getPath(), matrix);
            }
        }
        this.path.computeBounds(this.rect, false);
        float floatValue = ((FloatKeyframeAnimation) this.widthAnimation).getFloatValue();
        RectF rectF2 = this.rect;
        float f2 = floatValue / 2.0f;
        rectF2.set(rectF2.left - f2, rectF2.top - f2, rectF2.right + f2, rectF2.bottom + f2);
        rectF.set(this.rect);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
        L.endSection("StrokeContent#getBounds");
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener
    public void onValueChanged() {
        this.lottieDrawable.invalidateSelf();
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public void resolveKeyPath(KeyPath keyPath, int i2, List<KeyPath> list, KeyPath keyPath2) {
        MiscUtils.resolveKeyPath(keyPath, i2, list, keyPath2, this);
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public void setContents(List<Content> list, List<Content> list2) {
        TrimPathContent trimPathContent = null;
        for (int size = list.size() - 1; size >= 0; size--) {
            Content content = list.get(size);
            if (content instanceof TrimPathContent) {
                TrimPathContent trimPathContent2 = (TrimPathContent) content;
                if (trimPathContent2.getType() == ShapeTrimPath.Type.INDIVIDUALLY) {
                    trimPathContent = trimPathContent2;
                }
            }
        }
        if (trimPathContent != null) {
            trimPathContent.addListener(this);
        }
        PathGroup pathGroup = null;
        for (int size2 = list2.size() - 1; size2 >= 0; size2--) {
            Content content2 = list2.get(size2);
            if (content2 instanceof TrimPathContent) {
                TrimPathContent trimPathContent3 = (TrimPathContent) content2;
                if (trimPathContent3.getType() == ShapeTrimPath.Type.INDIVIDUALLY) {
                    if (pathGroup != null) {
                        this.pathGroups.add(pathGroup);
                    }
                    pathGroup = new PathGroup(trimPathContent3);
                    trimPathContent3.addListener(this);
                }
            }
            if (content2 instanceof PathContent) {
                if (pathGroup == null) {
                    pathGroup = new PathGroup(trimPathContent);
                }
                pathGroup.paths.add((PathContent) content2);
            }
        }
        if (pathGroup != null) {
            this.pathGroups.add(pathGroup);
        }
    }
}
