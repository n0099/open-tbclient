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
import androidx.core.view.InputDeviceCompat;
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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes4.dex */
public abstract class BaseLayer implements DrawingContent, BaseKeyframeAnimation.AnimationListener, KeyPathElement {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int CLIP_SAVE_FLAG = 2;
    public static final int CLIP_TO_LAYER_SAVE_FLAG = 16;
    public static final int MATRIX_SAVE_FLAG = 1;
    public static final int SAVE_FLAGS = 19;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<BaseKeyframeAnimation<?, ?>> animations;
    public final Matrix boundsMatrix;
    public final Paint clearPaint;
    public final Paint contentPaint;
    public final String drawTraceName;
    public final Paint dstInPaint;
    public final Paint dstOutPaint;
    @Nullable
    public FloatKeyframeAnimation inOutAnimation;
    public final Layer layerModel;
    public final LottieDrawable lottieDrawable;
    @Nullable
    public MaskKeyframeAnimation mask;
    public final RectF maskBoundsRect;
    public final Matrix matrix;
    public final RectF matteBoundsRect;
    @Nullable
    public BaseLayer matteLayer;
    public final Paint mattePaint;
    @Nullable
    public BaseLayer parentLayer;
    public List<BaseLayer> parentLayers;
    public final Path path;
    public final RectF rect;
    public final RectF tempMaskBoundsRect;
    public final TransformKeyframeAnimation transform;
    public boolean visible;

    /* renamed from: com.airbnb.lottie.model.layer.BaseLayer$2  reason: invalid class name */
    /* loaded from: classes4.dex */
    public static /* synthetic */ class AnonymousClass2 {
        public static final /* synthetic */ int[] $SwitchMap$com$airbnb$lottie$model$content$Mask$MaskMode;
        public static final /* synthetic */ int[] $SwitchMap$com$airbnb$lottie$model$layer$Layer$LayerType;
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1669879496, "Lcom/airbnb/lottie/model/layer/BaseLayer$2;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1669879496, "Lcom/airbnb/lottie/model/layer/BaseLayer$2;");
                    return;
                }
            }
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
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {lottieDrawable, layer};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.path = new Path();
        this.matrix = new Matrix();
        this.contentPaint = new LPaint(1);
        this.dstInPaint = new LPaint(1, PorterDuff.Mode.DST_IN);
        this.dstOutPaint = new LPaint(1, PorterDuff.Mode.DST_OUT);
        this.mattePaint = new LPaint(1);
        this.clearPaint = new LPaint(PorterDuff.Mode.CLEAR);
        this.rect = new RectF();
        this.maskBoundsRect = new RectF();
        this.matteBoundsRect = new RectF();
        this.tempMaskBoundsRect = new RectF();
        this.boundsMatrix = new Matrix();
        this.animations = new ArrayList();
        this.visible = true;
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65539, this, canvas, matrix, mask, baseKeyframeAnimation, baseKeyframeAnimation2) == null) {
            this.path.set(baseKeyframeAnimation.getValue());
            this.path.transform(matrix);
            this.contentPaint.setAlpha((int) (baseKeyframeAnimation2.getValue().intValue() * 2.55f));
            canvas.drawPath(this.path, this.contentPaint);
        }
    }

    private void applyIntersectMask(Canvas canvas, Matrix matrix, Mask mask, BaseKeyframeAnimation<ShapeData, Path> baseKeyframeAnimation, BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(InputDeviceCompat.SOURCE_TRACKBALL, this, canvas, matrix, mask, baseKeyframeAnimation, baseKeyframeAnimation2) == null) {
            Utils.saveLayerCompat(canvas, this.rect, this.dstInPaint);
            this.path.set(baseKeyframeAnimation.getValue());
            this.path.transform(matrix);
            this.contentPaint.setAlpha((int) (baseKeyframeAnimation2.getValue().intValue() * 2.55f));
            canvas.drawPath(this.path, this.contentPaint);
            canvas.restore();
        }
    }

    private void applyInvertedAddMask(Canvas canvas, Matrix matrix, Mask mask, BaseKeyframeAnimation<ShapeData, Path> baseKeyframeAnimation, BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(AdIconUtil.AD_TEXT_ID, this, canvas, matrix, mask, baseKeyframeAnimation, baseKeyframeAnimation2) == null) {
            Utils.saveLayerCompat(canvas, this.rect, this.contentPaint);
            canvas.drawRect(this.rect, this.contentPaint);
            this.path.set(baseKeyframeAnimation.getValue());
            this.path.transform(matrix);
            this.contentPaint.setAlpha((int) (baseKeyframeAnimation2.getValue().intValue() * 2.55f));
            canvas.drawPath(this.path, this.dstOutPaint);
            canvas.restore();
        }
    }

    private void applyInvertedIntersectMask(Canvas canvas, Matrix matrix, Mask mask, BaseKeyframeAnimation<ShapeData, Path> baseKeyframeAnimation, BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(AdIconUtil.BAIDU_LOGO_ID, this, canvas, matrix, mask, baseKeyframeAnimation, baseKeyframeAnimation2) == null) {
            Utils.saveLayerCompat(canvas, this.rect, this.dstInPaint);
            canvas.drawRect(this.rect, this.contentPaint);
            this.dstOutPaint.setAlpha((int) (baseKeyframeAnimation2.getValue().intValue() * 2.55f));
            this.path.set(baseKeyframeAnimation.getValue());
            this.path.transform(matrix);
            canvas.drawPath(this.path, this.dstOutPaint);
            canvas.restore();
        }
    }

    private void applyInvertedSubtractMask(Canvas canvas, Matrix matrix, Mask mask, BaseKeyframeAnimation<ShapeData, Path> baseKeyframeAnimation, BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65543, this, canvas, matrix, mask, baseKeyframeAnimation, baseKeyframeAnimation2) == null) {
            Utils.saveLayerCompat(canvas, this.rect, this.dstOutPaint);
            canvas.drawRect(this.rect, this.contentPaint);
            this.dstOutPaint.setAlpha((int) (baseKeyframeAnimation2.getValue().intValue() * 2.55f));
            this.path.set(baseKeyframeAnimation.getValue());
            this.path.transform(matrix);
            canvas.drawPath(this.path, this.dstOutPaint);
            canvas.restore();
        }
    }

    private void applyMasks(Canvas canvas, Matrix matrix) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, this, canvas, matrix) == null) {
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
    }

    private void applySubtractMask(Canvas canvas, Matrix matrix, Mask mask, BaseKeyframeAnimation<ShapeData, Path> baseKeyframeAnimation, BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65545, this, canvas, matrix, mask, baseKeyframeAnimation, baseKeyframeAnimation2) == null) {
            this.path.set(baseKeyframeAnimation.getValue());
            this.path.transform(matrix);
            canvas.drawPath(this.path, this.dstOutPaint);
        }
    }

    private boolean areAllMasksNone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, this)) == null) {
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
        return invokeV.booleanValue;
    }

    private void buildParentLayerListIfNeeded() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65547, this) == null) && this.parentLayers == null) {
            if (this.parentLayer == null) {
                this.parentLayers = Collections.emptyList();
                return;
            }
            this.parentLayers = new ArrayList();
            for (BaseLayer baseLayer = this.parentLayer; baseLayer != null; baseLayer = baseLayer.parentLayer) {
                this.parentLayers.add(baseLayer);
            }
        }
    }

    private void clearCanvas(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, this, canvas) == null) {
            L.beginSection("Layer#clearLayer");
            RectF rectF = this.rect;
            canvas.drawRect(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f, this.clearPaint);
            L.endSection("Layer#clearLayer");
        }
    }

    @Nullable
    public static BaseLayer forModel(Layer layer, LottieDrawable lottieDrawable, LottieComposition lottieComposition) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65549, null, layer, lottieDrawable, lottieComposition)) == null) {
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
        return (BaseLayer) invokeLLL.objValue;
    }

    private void intersectBoundsWithMask(RectF rectF, Matrix matrix) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65550, this, rectF, matrix) == null) {
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
    }

    private void intersectBoundsWithMatte(RectF rectF, Matrix matrix) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65551, this, rectF, matrix) == null) && hasMatteOnThisLayer() && this.layerModel.getMatteType() != Layer.MatteType.INVERT) {
            this.matteBoundsRect.set(0.0f, 0.0f, 0.0f, 0.0f);
            this.matteLayer.getBounds(this.matteBoundsRect, matrix, true);
            if (rectF.intersect(this.matteBoundsRect)) {
                return;
            }
            rectF.set(0.0f, 0.0f, 0.0f, 0.0f);
        }
    }

    private void invalidateSelf() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65552, this) == null) {
            this.lottieDrawable.invalidateSelf();
        }
    }

    private void recordRenderTime(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(65553, this, f2) == null) {
            this.lottieDrawable.getComposition().getPerformanceTracker().recordRenderTime(this.layerModel.getName(), f2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVisible(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(65554, this, z) == null) || z == this.visible) {
            return;
        }
        this.visible = z;
        invalidateSelf();
    }

    private void setupInOutAnimations() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65555, this) == null) {
            if (!this.layerModel.getInOutKeyframes().isEmpty()) {
                FloatKeyframeAnimation floatKeyframeAnimation = new FloatKeyframeAnimation(this.layerModel.getInOutKeyframes());
                this.inOutAnimation = floatKeyframeAnimation;
                floatKeyframeAnimation.setIsDiscrete();
                this.inOutAnimation.addUpdateListener(new BaseKeyframeAnimation.AnimationListener(this) { // from class: com.airbnb.lottie.model.layer.BaseLayer.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ BaseLayer this$0;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                    }

                    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener
                    public void onValueChanged() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            BaseLayer baseLayer = this.this$0;
                            baseLayer.setVisible(baseLayer.inOutAnimation.getFloatValue() == 1.0f);
                        }
                    }
                });
                setVisible(this.inOutAnimation.getValue().floatValue() == 1.0f);
                addAnimation(this.inOutAnimation);
                return;
            }
            setVisible(true);
        }
    }

    public void addAnimation(@Nullable BaseKeyframeAnimation<?, ?> baseKeyframeAnimation) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, baseKeyframeAnimation) == null) || baseKeyframeAnimation == null) {
            return;
        }
        this.animations.add(baseKeyframeAnimation);
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    @CallSuper
    public <T> void addValueCallback(T t, @Nullable LottieValueCallback<T> lottieValueCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t, lottieValueCallback) == null) {
            this.transform.applyValueCallback(t, lottieValueCallback);
        }
    }

    @Override // com.airbnb.lottie.animation.content.DrawingContent
    public void draw(Canvas canvas, Matrix matrix, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_SEND_USER_MSG, this, canvas, matrix, i2) == null) {
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
    }

    public abstract void drawLayer(Canvas canvas, Matrix matrix, int i2);

    @Override // com.airbnb.lottie.animation.content.DrawingContent
    @CallSuper
    public void getBounds(RectF rectF, Matrix matrix, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048580, this, rectF, matrix, z) == null) {
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
    }

    public Layer getLayerModel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.layerModel : (Layer) invokeV.objValue;
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public String getName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.layerModel.getName() : (String) invokeV.objValue;
    }

    public boolean hasMasksOnThisLayer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            MaskKeyframeAnimation maskKeyframeAnimation = this.mask;
            return (maskKeyframeAnimation == null || maskKeyframeAnimation.getMaskAnimations().isEmpty()) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public boolean hasMatteOnThisLayer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.matteLayer != null : invokeV.booleanValue;
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener
    public void onValueChanged() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            invalidateSelf();
        }
    }

    public void removeAnimation(BaseKeyframeAnimation<?, ?> baseKeyframeAnimation) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, baseKeyframeAnimation) == null) {
            this.animations.remove(baseKeyframeAnimation);
        }
    }

    public void resolveChildKeyPath(KeyPath keyPath, int i2, List<KeyPath> list, KeyPath keyPath2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(1048587, this, keyPath, i2, list, keyPath2) == null) {
        }
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public void resolveKeyPath(KeyPath keyPath, int i2, List<KeyPath> list, KeyPath keyPath2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLILL(1048588, this, keyPath, i2, list, keyPath2) == null) && keyPath.matches(getName(), i2)) {
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, list, list2) == null) {
        }
    }

    public void setMatteLayer(@Nullable BaseLayer baseLayer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, baseLayer) == null) {
            this.matteLayer = baseLayer;
        }
    }

    public void setParentLayer(@Nullable BaseLayer baseLayer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, baseLayer) == null) {
            this.parentLayer = baseLayer;
        }
    }

    public void setProgress(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048592, this, f2) == null) {
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
}
