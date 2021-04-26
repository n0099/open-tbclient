package com.airbnb.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Build;
import androidx.annotation.CallSuper;
import androidx.annotation.FloatRange;
import androidx.annotation.Nullable;
import com.airbnb.lottie.L;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.LPaint;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.DrawingContent;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.FloatKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.MaskKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.TransformKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.KeyPathElement;
import com.airbnb.lottie.model.content.Mask;
import com.airbnb.lottie.model.content.ShapeData;
import com.airbnb.lottie.model.layer.Layer;
import com.airbnb.lottie.utils.Logger;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
public abstract class BaseLayer implements DrawingContent, BaseKeyframeAnimation.AnimationListener, KeyPathElement {
    public static final int CLIP_SAVE_FLAG = 2;
    public static final int CLIP_TO_LAYER_SAVE_FLAG = 16;
    public static final int MATRIX_SAVE_FLAG = 1;
    public static final int SAVE_FLAGS = 19;
    public final String drawTraceName;
    @Nullable
    public FloatKeyframeAnimation inOutAnimation;
    public final Layer layerModel;
    public final LottieDrawable lottieDrawable;
    @Nullable
    public MaskKeyframeAnimation mask;
    @Nullable
    public BaseLayer matteLayer;
    @Nullable
    public BaseLayer parentLayer;
    public List<BaseLayer> parentLayers;
    public final TransformKeyframeAnimation transform;
    public final Path path = new Path();
    public final Matrix matrix = new Matrix();
    public final Paint contentPaint = new LPaint(1);
    public final Paint dstInPaint = new LPaint(1, PorterDuff.Mode.DST_IN);
    public final Paint dstOutPaint = new LPaint(1, PorterDuff.Mode.DST_OUT);
    public final Paint mattePaint = new LPaint(1);
    public final Paint clearPaint = new LPaint(PorterDuff.Mode.CLEAR);
    public final RectF rect = new RectF();
    public final RectF maskBoundsRect = new RectF();
    public final RectF matteBoundsRect = new RectF();
    public final RectF tempMaskBoundsRect = new RectF();
    public final Matrix boundsMatrix = new Matrix();
    public final List<BaseKeyframeAnimation<?, ?>> animations = new ArrayList();
    public boolean visible = true;

    /* renamed from: com.airbnb.lottie.model.layer.BaseLayer$2  reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass2 {
        public static final /* synthetic */ int[] $SwitchMap$com$airbnb$lottie$model$content$Mask$MaskMode;
        public static final /* synthetic */ int[] $SwitchMap$com$airbnb$lottie$model$layer$Layer$LayerType;

        static {
            int[] iArr = new int[Mask.MaskMode.values().length];
            $SwitchMap$com$airbnb$lottie$model$content$Mask$MaskMode = iArr;
            try {
                iArr[Mask.MaskMode.MASK_MODE_NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$airbnb$lottie$model$content$Mask$MaskMode[Mask.MaskMode.MASK_MODE_SUBTRACT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$airbnb$lottie$model$content$Mask$MaskMode[Mask.MaskMode.MASK_MODE_INTERSECT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$airbnb$lottie$model$content$Mask$MaskMode[Mask.MaskMode.MASK_MODE_ADD.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[Layer.LayerType.values().length];
            $SwitchMap$com$airbnb$lottie$model$layer$Layer$LayerType = iArr2;
            try {
                iArr2[Layer.LayerType.SHAPE.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$airbnb$lottie$model$layer$Layer$LayerType[Layer.LayerType.PRE_COMP.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$airbnb$lottie$model$layer$Layer$LayerType[Layer.LayerType.SOLID.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$airbnb$lottie$model$layer$Layer$LayerType[Layer.LayerType.IMAGE.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$airbnb$lottie$model$layer$Layer$LayerType[Layer.LayerType.NULL.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$airbnb$lottie$model$layer$Layer$LayerType[Layer.LayerType.TEXT.ordinal()] = 6;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$airbnb$lottie$model$layer$Layer$LayerType[Layer.LayerType.UNKNOWN.ordinal()] = 7;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }

    public BaseLayer(LottieDrawable lottieDrawable, Layer layer) {
        this.lottieDrawable = lottieDrawable;
        this.layerModel = layer;
        this.drawTraceName = layer.getName() + "#draw";
        if (layer.getMatteType() == Layer.MatteType.INVERT) {
            this.mattePaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        } else {
            this.mattePaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        }
        TransformKeyframeAnimation createAnimation = layer.getTransform().createAnimation();
        this.transform = createAnimation;
        createAnimation.addListener(this);
        if (layer.getMasks() != null && !layer.getMasks().isEmpty()) {
            MaskKeyframeAnimation maskKeyframeAnimation = new MaskKeyframeAnimation(layer.getMasks());
            this.mask = maskKeyframeAnimation;
            for (BaseKeyframeAnimation<ShapeData, Path> baseKeyframeAnimation : maskKeyframeAnimation.getMaskAnimations()) {
                baseKeyframeAnimation.addUpdateListener(this);
            }
            for (BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation2 : this.mask.getOpacityAnimations()) {
                addAnimation(baseKeyframeAnimation2);
                baseKeyframeAnimation2.addUpdateListener(this);
            }
        }
        setupInOutAnimations();
    }

    private void applyAddMask(Canvas canvas, Matrix matrix, Mask mask, BaseKeyframeAnimation<ShapeData, Path> baseKeyframeAnimation, BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation2) {
        this.path.set(baseKeyframeAnimation.getValue());
        this.path.transform(matrix);
        this.contentPaint.setAlpha((int) (baseKeyframeAnimation2.getValue().intValue() * 2.55f));
        canvas.drawPath(this.path, this.contentPaint);
    }

    private void applyIntersectMask(Canvas canvas, Matrix matrix, Mask mask, BaseKeyframeAnimation<ShapeData, Path> baseKeyframeAnimation, BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation2) {
        Utils.saveLayerCompat(canvas, this.rect, this.dstInPaint);
        this.path.set(baseKeyframeAnimation.getValue());
        this.path.transform(matrix);
        this.contentPaint.setAlpha((int) (baseKeyframeAnimation2.getValue().intValue() * 2.55f));
        canvas.drawPath(this.path, this.contentPaint);
        canvas.restore();
    }

    private void applyInvertedAddMask(Canvas canvas, Matrix matrix, Mask mask, BaseKeyframeAnimation<ShapeData, Path> baseKeyframeAnimation, BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation2) {
        Utils.saveLayerCompat(canvas, this.rect, this.contentPaint);
        canvas.drawRect(this.rect, this.contentPaint);
        this.path.set(baseKeyframeAnimation.getValue());
        this.path.transform(matrix);
        this.contentPaint.setAlpha((int) (baseKeyframeAnimation2.getValue().intValue() * 2.55f));
        canvas.drawPath(this.path, this.dstOutPaint);
        canvas.restore();
    }

    private void applyInvertedIntersectMask(Canvas canvas, Matrix matrix, Mask mask, BaseKeyframeAnimation<ShapeData, Path> baseKeyframeAnimation, BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation2) {
        Utils.saveLayerCompat(canvas, this.rect, this.dstInPaint);
        canvas.drawRect(this.rect, this.contentPaint);
        this.dstOutPaint.setAlpha((int) (baseKeyframeAnimation2.getValue().intValue() * 2.55f));
        this.path.set(baseKeyframeAnimation.getValue());
        this.path.transform(matrix);
        canvas.drawPath(this.path, this.dstOutPaint);
        canvas.restore();
    }

    private void applyInvertedSubtractMask(Canvas canvas, Matrix matrix, Mask mask, BaseKeyframeAnimation<ShapeData, Path> baseKeyframeAnimation, BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation2) {
        Utils.saveLayerCompat(canvas, this.rect, this.dstOutPaint);
        canvas.drawRect(this.rect, this.contentPaint);
        this.dstOutPaint.setAlpha((int) (baseKeyframeAnimation2.getValue().intValue() * 2.55f));
        this.path.set(baseKeyframeAnimation.getValue());
        this.path.transform(matrix);
        canvas.drawPath(this.path, this.dstOutPaint);
        canvas.restore();
    }

    private void applyMasks(Canvas canvas, Matrix matrix) {
        L.beginSection("Layer#saveLayer");
        Utils.saveLayerCompat(canvas, this.rect, this.dstInPaint, 19);
        if (Build.VERSION.SDK_INT < 28) {
            clearCanvas(canvas);
        }
        L.endSection("Layer#saveLayer");
        for (int i2 = 0; i2 < this.mask.getMasks().size(); i2++) {
            Mask mask = this.mask.getMasks().get(i2);
            BaseKeyframeAnimation<ShapeData, Path> baseKeyframeAnimation = this.mask.getMaskAnimations().get(i2);
            BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation2 = this.mask.getOpacityAnimations().get(i2);
            int i3 = AnonymousClass2.$SwitchMap$com$airbnb$lottie$model$content$Mask$MaskMode[mask.getMaskMode().ordinal()];
            if (i3 != 1) {
                if (i3 == 2) {
                    if (i2 == 0) {
                        this.contentPaint.setColor(-16777216);
                        this.contentPaint.setAlpha(255);
                        canvas.drawRect(this.rect, this.contentPaint);
                    }
                    if (mask.isInverted()) {
                        applyInvertedSubtractMask(canvas, matrix, mask, baseKeyframeAnimation, baseKeyframeAnimation2);
                    } else {
                        applySubtractMask(canvas, matrix, mask, baseKeyframeAnimation, baseKeyframeAnimation2);
                    }
                } else if (i3 != 3) {
                    if (i3 == 4) {
                        if (mask.isInverted()) {
                            applyInvertedAddMask(canvas, matrix, mask, baseKeyframeAnimation, baseKeyframeAnimation2);
                        } else {
                            applyAddMask(canvas, matrix, mask, baseKeyframeAnimation, baseKeyframeAnimation2);
                        }
                    }
                } else if (mask.isInverted()) {
                    applyInvertedIntersectMask(canvas, matrix, mask, baseKeyframeAnimation, baseKeyframeAnimation2);
                } else {
                    applyIntersectMask(canvas, matrix, mask, baseKeyframeAnimation, baseKeyframeAnimation2);
                }
            } else if (areAllMasksNone()) {
                this.contentPaint.setAlpha(255);
                canvas.drawRect(this.rect, this.contentPaint);
            }
        }
        L.beginSection("Layer#restoreLayer");
        canvas.restore();
        L.endSection("Layer#restoreLayer");
    }

    private void applySubtractMask(Canvas canvas, Matrix matrix, Mask mask, BaseKeyframeAnimation<ShapeData, Path> baseKeyframeAnimation, BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation2) {
        this.path.set(baseKeyframeAnimation.getValue());
        this.path.transform(matrix);
        canvas.drawPath(this.path, this.dstOutPaint);
    }

    private boolean areAllMasksNone() {
        if (this.mask.getMaskAnimations().isEmpty()) {
            return false;
        }
        for (int i2 = 0; i2 < this.mask.getMasks().size(); i2++) {
            if (this.mask.getMasks().get(i2).getMaskMode() != Mask.MaskMode.MASK_MODE_NONE) {
                return false;
            }
        }
        return true;
    }

    private void buildParentLayerListIfNeeded() {
        if (this.parentLayers != null) {
            return;
        }
        if (this.parentLayer == null) {
            this.parentLayers = Collections.emptyList();
            return;
        }
        this.parentLayers = new ArrayList();
        for (BaseLayer baseLayer = this.parentLayer; baseLayer != null; baseLayer = baseLayer.parentLayer) {
            this.parentLayers.add(baseLayer);
        }
    }

    private void clearCanvas(Canvas canvas) {
        L.beginSection("Layer#clearLayer");
        RectF rectF = this.rect;
        canvas.drawRect(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f, this.clearPaint);
        L.endSection("Layer#clearLayer");
    }

    @Nullable
    public static BaseLayer forModel(Layer layer, LottieDrawable lottieDrawable, LottieComposition lottieComposition) {
        switch (AnonymousClass2.$SwitchMap$com$airbnb$lottie$model$layer$Layer$LayerType[layer.getLayerType().ordinal()]) {
            case 1:
                return new ShapeLayer(lottieDrawable, layer);
            case 2:
                return new CompositionLayer(lottieDrawable, layer, lottieComposition.getPrecomps(layer.getRefId()), lottieComposition);
            case 3:
                return new SolidLayer(lottieDrawable, layer);
            case 4:
                return new ImageLayer(lottieDrawable, layer);
            case 5:
                return new NullLayer(lottieDrawable, layer);
            case 6:
                return new TextLayer(lottieDrawable, layer);
            default:
                Logger.warning("Unknown layer type " + layer.getLayerType());
                return null;
        }
    }

    private void intersectBoundsWithMask(RectF rectF, Matrix matrix) {
        this.maskBoundsRect.set(0.0f, 0.0f, 0.0f, 0.0f);
        if (hasMasksOnThisLayer()) {
            int size = this.mask.getMasks().size();
            for (int i2 = 0; i2 < size; i2++) {
                Mask mask = this.mask.getMasks().get(i2);
                this.path.set(this.mask.getMaskAnimations().get(i2).getValue());
                this.path.transform(matrix);
                int i3 = AnonymousClass2.$SwitchMap$com$airbnb$lottie$model$content$Mask$MaskMode[mask.getMaskMode().ordinal()];
                if (i3 == 1 || i3 == 2) {
                    return;
                }
                if ((i3 == 3 || i3 == 4) && mask.isInverted()) {
                    return;
                }
                this.path.computeBounds(this.tempMaskBoundsRect, false);
                if (i2 == 0) {
                    this.maskBoundsRect.set(this.tempMaskBoundsRect);
                } else {
                    RectF rectF2 = this.maskBoundsRect;
                    rectF2.set(Math.min(rectF2.left, this.tempMaskBoundsRect.left), Math.min(this.maskBoundsRect.top, this.tempMaskBoundsRect.top), Math.max(this.maskBoundsRect.right, this.tempMaskBoundsRect.right), Math.max(this.maskBoundsRect.bottom, this.tempMaskBoundsRect.bottom));
                }
            }
            if (rectF.intersect(this.maskBoundsRect)) {
                return;
            }
            rectF.set(0.0f, 0.0f, 0.0f, 0.0f);
        }
    }

    private void intersectBoundsWithMatte(RectF rectF, Matrix matrix) {
        if (hasMatteOnThisLayer() && this.layerModel.getMatteType() != Layer.MatteType.INVERT) {
            this.matteBoundsRect.set(0.0f, 0.0f, 0.0f, 0.0f);
            this.matteLayer.getBounds(this.matteBoundsRect, matrix, true);
            if (rectF.intersect(this.matteBoundsRect)) {
                return;
            }
            rectF.set(0.0f, 0.0f, 0.0f, 0.0f);
        }
    }

    private void invalidateSelf() {
        this.lottieDrawable.invalidateSelf();
    }

    private void recordRenderTime(float f2) {
        this.lottieDrawable.getComposition().getPerformanceTracker().recordRenderTime(this.layerModel.getName(), f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVisible(boolean z) {
        if (z != this.visible) {
            this.visible = z;
            invalidateSelf();
        }
    }

    private void setupInOutAnimations() {
        if (!this.layerModel.getInOutKeyframes().isEmpty()) {
            FloatKeyframeAnimation floatKeyframeAnimation = new FloatKeyframeAnimation(this.layerModel.getInOutKeyframes());
            this.inOutAnimation = floatKeyframeAnimation;
            floatKeyframeAnimation.setIsDiscrete();
            this.inOutAnimation.addUpdateListener(new BaseKeyframeAnimation.AnimationListener() { // from class: com.airbnb.lottie.model.layer.BaseLayer.1
                @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener
                public void onValueChanged() {
                    BaseLayer baseLayer = BaseLayer.this;
                    baseLayer.setVisible(baseLayer.inOutAnimation.getFloatValue() == 1.0f);
                }
            });
            setVisible(this.inOutAnimation.getValue().floatValue() == 1.0f);
            addAnimation(this.inOutAnimation);
            return;
        }
        setVisible(true);
    }

    public void addAnimation(@Nullable BaseKeyframeAnimation<?, ?> baseKeyframeAnimation) {
        if (baseKeyframeAnimation == null) {
            return;
        }
        this.animations.add(baseKeyframeAnimation);
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    @CallSuper
    public <T> void addValueCallback(T t, @Nullable LottieValueCallback<T> lottieValueCallback) {
        this.transform.applyValueCallback(t, lottieValueCallback);
    }

    @Override // com.airbnb.lottie.animation.content.DrawingContent
    public void draw(Canvas canvas, Matrix matrix, int i2) {
        L.beginSection(this.drawTraceName);
        if (this.visible && !this.layerModel.isHidden()) {
            buildParentLayerListIfNeeded();
            L.beginSection("Layer#parentMatrix");
            this.matrix.reset();
            this.matrix.set(matrix);
            for (int size = this.parentLayers.size() - 1; size >= 0; size--) {
                this.matrix.preConcat(this.parentLayers.get(size).transform.getMatrix());
            }
            L.endSection("Layer#parentMatrix");
            int intValue = (int) ((((i2 / 255.0f) * (this.transform.getOpacity() == null ? 100 : this.transform.getOpacity().getValue().intValue())) / 100.0f) * 255.0f);
            if (!hasMatteOnThisLayer() && !hasMasksOnThisLayer()) {
                this.matrix.preConcat(this.transform.getMatrix());
                L.beginSection("Layer#drawLayer");
                drawLayer(canvas, this.matrix, intValue);
                L.endSection("Layer#drawLayer");
                recordRenderTime(L.endSection(this.drawTraceName));
                return;
            }
            L.beginSection("Layer#computeBounds");
            getBounds(this.rect, this.matrix, false);
            intersectBoundsWithMatte(this.rect, matrix);
            this.matrix.preConcat(this.transform.getMatrix());
            intersectBoundsWithMask(this.rect, this.matrix);
            if (!this.rect.intersect(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight())) {
                this.rect.set(0.0f, 0.0f, 0.0f, 0.0f);
            }
            L.endSection("Layer#computeBounds");
            if (!this.rect.isEmpty()) {
                L.beginSection("Layer#saveLayer");
                this.contentPaint.setAlpha(255);
                Utils.saveLayerCompat(canvas, this.rect, this.contentPaint);
                L.endSection("Layer#saveLayer");
                clearCanvas(canvas);
                L.beginSection("Layer#drawLayer");
                drawLayer(canvas, this.matrix, intValue);
                L.endSection("Layer#drawLayer");
                if (hasMasksOnThisLayer()) {
                    applyMasks(canvas, this.matrix);
                }
                if (hasMatteOnThisLayer()) {
                    L.beginSection("Layer#drawMatte");
                    L.beginSection("Layer#saveLayer");
                    Utils.saveLayerCompat(canvas, this.rect, this.mattePaint, 19);
                    L.endSection("Layer#saveLayer");
                    clearCanvas(canvas);
                    this.matteLayer.draw(canvas, matrix, intValue);
                    L.beginSection("Layer#restoreLayer");
                    canvas.restore();
                    L.endSection("Layer#restoreLayer");
                    L.endSection("Layer#drawMatte");
                }
                L.beginSection("Layer#restoreLayer");
                canvas.restore();
                L.endSection("Layer#restoreLayer");
            }
            recordRenderTime(L.endSection(this.drawTraceName));
            return;
        }
        L.endSection(this.drawTraceName);
    }

    public abstract void drawLayer(Canvas canvas, Matrix matrix, int i2);

    @Override // com.airbnb.lottie.animation.content.DrawingContent
    @CallSuper
    public void getBounds(RectF rectF, Matrix matrix, boolean z) {
        this.rect.set(0.0f, 0.0f, 0.0f, 0.0f);
        buildParentLayerListIfNeeded();
        this.boundsMatrix.set(matrix);
        if (z) {
            List<BaseLayer> list = this.parentLayers;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.boundsMatrix.preConcat(this.parentLayers.get(size).transform.getMatrix());
                }
            } else {
                BaseLayer baseLayer = this.parentLayer;
                if (baseLayer != null) {
                    this.boundsMatrix.preConcat(baseLayer.transform.getMatrix());
                }
            }
        }
        this.boundsMatrix.preConcat(this.transform.getMatrix());
    }

    public Layer getLayerModel() {
        return this.layerModel;
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public String getName() {
        return this.layerModel.getName();
    }

    public boolean hasMasksOnThisLayer() {
        MaskKeyframeAnimation maskKeyframeAnimation = this.mask;
        return (maskKeyframeAnimation == null || maskKeyframeAnimation.getMaskAnimations().isEmpty()) ? false : true;
    }

    public boolean hasMatteOnThisLayer() {
        return this.matteLayer != null;
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener
    public void onValueChanged() {
        invalidateSelf();
    }

    public void removeAnimation(BaseKeyframeAnimation<?, ?> baseKeyframeAnimation) {
        this.animations.remove(baseKeyframeAnimation);
    }

    public void resolveChildKeyPath(KeyPath keyPath, int i2, List<KeyPath> list, KeyPath keyPath2) {
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public void resolveKeyPath(KeyPath keyPath, int i2, List<KeyPath> list, KeyPath keyPath2) {
        if (keyPath.matches(getName(), i2)) {
            if (!"__container".equals(getName())) {
                keyPath2 = keyPath2.addKey(getName());
                if (keyPath.fullyResolvesTo(getName(), i2)) {
                    list.add(keyPath2.resolve(this));
                }
            }
            if (keyPath.propagateToChildren(getName(), i2)) {
                resolveChildKeyPath(keyPath, i2 + keyPath.incrementDepthBy(getName(), i2), list, keyPath2);
            }
        }
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public void setContents(List<Content> list, List<Content> list2) {
    }

    public void setMatteLayer(@Nullable BaseLayer baseLayer) {
        this.matteLayer = baseLayer;
    }

    public void setParentLayer(@Nullable BaseLayer baseLayer) {
        this.parentLayer = baseLayer;
    }

    public void setProgress(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        this.transform.setProgress(f2);
        if (this.mask != null) {
            for (int i2 = 0; i2 < this.mask.getMaskAnimations().size(); i2++) {
                this.mask.getMaskAnimations().get(i2).setProgress(f2);
            }
        }
        if (this.layerModel.getTimeStretch() != 0.0f) {
            f2 /= this.layerModel.getTimeStretch();
        }
        FloatKeyframeAnimation floatKeyframeAnimation = this.inOutAnimation;
        if (floatKeyframeAnimation != null) {
            floatKeyframeAnimation.setProgress(f2 / this.layerModel.getTimeStretch());
        }
        BaseLayer baseLayer = this.matteLayer;
        if (baseLayer != null) {
            this.matteLayer.setProgress(baseLayer.layerModel.getTimeStretch() * f2);
        }
        for (int i3 = 0; i3 < this.animations.size(); i3++) {
            this.animations.get(i3).setProgress(f2);
        }
    }
}
