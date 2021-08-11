package com.airbnb.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import androidx.annotation.FloatRange;
import androidx.annotation.Nullable;
import androidx.collection.LongSparseArray;
import com.airbnb.lottie.L;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.layer.Layer;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.LottieValueCallback;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class CompositionLayer extends BaseLayer {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public Boolean hasMasks;
    @Nullable
    public Boolean hasMatte;
    public Paint layerPaint;
    public final List<BaseLayer> layers;
    public final RectF newClipRect;
    public final RectF rect;
    @Nullable
    public BaseKeyframeAnimation<Float, Float> timeRemapping;

    /* renamed from: com.airbnb.lottie.model.layer.CompositionLayer$1  reason: invalid class name */
    /* loaded from: classes4.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$airbnb$lottie$model$layer$Layer$MatteType;
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(188378876, "Lcom/airbnb/lottie/model/layer/CompositionLayer$1;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(188378876, "Lcom/airbnb/lottie/model/layer/CompositionLayer$1;");
                    return;
                }
            }
            int[] iArr = new int[Layer.MatteType.values().length];
            $SwitchMap$com$airbnb$lottie$model$layer$Layer$MatteType = iArr;
            try {
                iArr[Layer.MatteType.ADD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$airbnb$lottie$model$layer$Layer$MatteType[Layer.MatteType.INVERT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CompositionLayer(LottieDrawable lottieDrawable, Layer layer, List<Layer> list, LottieComposition lottieComposition) {
        super(lottieDrawable, layer);
        int i2;
        BaseLayer baseLayer;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {lottieDrawable, layer, list, lottieComposition};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((LottieDrawable) objArr2[0], (Layer) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.layers = new ArrayList();
        this.rect = new RectF();
        this.newClipRect = new RectF();
        this.layerPaint = new Paint();
        AnimatableFloatValue timeRemapping = layer.getTimeRemapping();
        if (timeRemapping != null) {
            BaseKeyframeAnimation<Float, Float> createAnimation = timeRemapping.createAnimation();
            this.timeRemapping = createAnimation;
            addAnimation(createAnimation);
            this.timeRemapping.addUpdateListener(this);
        } else {
            this.timeRemapping = null;
        }
        LongSparseArray longSparseArray = new LongSparseArray(lottieComposition.getLayers().size());
        int size = list.size() - 1;
        BaseLayer baseLayer2 = null;
        while (true) {
            if (size < 0) {
                break;
            }
            Layer layer2 = list.get(size);
            BaseLayer forModel = BaseLayer.forModel(layer2, lottieDrawable, lottieComposition);
            if (forModel != null) {
                longSparseArray.put(forModel.getLayerModel().getId(), forModel);
                if (baseLayer2 != null) {
                    baseLayer2.setMatteLayer(forModel);
                    baseLayer2 = null;
                } else {
                    this.layers.add(0, forModel);
                    int i5 = AnonymousClass1.$SwitchMap$com$airbnb$lottie$model$layer$Layer$MatteType[layer2.getMatteType().ordinal()];
                    if (i5 == 1 || i5 == 2) {
                        baseLayer2 = forModel;
                    }
                }
            }
            size--;
        }
        for (i2 = 0; i2 < longSparseArray.size(); i2++) {
            BaseLayer baseLayer3 = (BaseLayer) longSparseArray.get(longSparseArray.keyAt(i2));
            if (baseLayer3 != null && (baseLayer = (BaseLayer) longSparseArray.get(baseLayer3.getLayerModel().getParentId())) != null) {
                baseLayer3.setParentLayer(baseLayer);
            }
        }
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer, com.airbnb.lottie.model.KeyPathElement
    public <T> void addValueCallback(T t, @Nullable LottieValueCallback<T> lottieValueCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, t, lottieValueCallback) == null) {
            super.addValueCallback(t, lottieValueCallback);
            if (t == LottieProperty.TIME_REMAP) {
                if (lottieValueCallback == null) {
                    BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation = this.timeRemapping;
                    if (baseKeyframeAnimation != null) {
                        baseKeyframeAnimation.setValueCallback(null);
                        return;
                    }
                    return;
                }
                ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation = new ValueCallbackKeyframeAnimation(lottieValueCallback);
                this.timeRemapping = valueCallbackKeyframeAnimation;
                valueCallbackKeyframeAnimation.addUpdateListener(this);
                addAnimation(this.timeRemapping);
            }
        }
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer
    public void drawLayer(Canvas canvas, Matrix matrix, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, canvas, matrix, i2) == null) {
            L.beginSection("CompositionLayer#draw");
            this.newClipRect.set(0.0f, 0.0f, this.layerModel.getPreCompWidth(), this.layerModel.getPreCompHeight());
            matrix.mapRect(this.newClipRect);
            boolean z = this.lottieDrawable.isApplyingOpacityToLayersEnabled() && this.layers.size() > 1 && i2 != 255;
            if (z) {
                this.layerPaint.setAlpha(i2);
                Utils.saveLayerCompat(canvas, this.newClipRect, this.layerPaint);
            } else {
                canvas.save();
            }
            if (z) {
                i2 = 255;
            }
            for (int size = this.layers.size() - 1; size >= 0; size--) {
                if (!this.newClipRect.isEmpty() ? canvas.clipRect(this.newClipRect) : true) {
                    this.layers.get(size).draw(canvas, matrix, i2);
                }
            }
            canvas.restore();
            L.endSection("CompositionLayer#draw");
        }
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer, com.airbnb.lottie.animation.content.DrawingContent
    public void getBounds(RectF rectF, Matrix matrix, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(Constants.METHOD_SEND_USER_MSG, this, rectF, matrix, z) == null) {
            super.getBounds(rectF, matrix, z);
            for (int size = this.layers.size() - 1; size >= 0; size--) {
                this.rect.set(0.0f, 0.0f, 0.0f, 0.0f);
                this.layers.get(size).getBounds(this.rect, this.boundsMatrix, true);
                rectF.union(this.rect);
            }
        }
    }

    public boolean hasMasks() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.hasMasks == null) {
                for (int size = this.layers.size() - 1; size >= 0; size--) {
                    BaseLayer baseLayer = this.layers.get(size);
                    if (baseLayer instanceof ShapeLayer) {
                        if (baseLayer.hasMasksOnThisLayer()) {
                            this.hasMasks = Boolean.TRUE;
                            return true;
                        }
                    } else if ((baseLayer instanceof CompositionLayer) && ((CompositionLayer) baseLayer).hasMasks()) {
                        this.hasMasks = Boolean.TRUE;
                        return true;
                    }
                }
                this.hasMasks = Boolean.FALSE;
            }
            return this.hasMasks.booleanValue();
        }
        return invokeV.booleanValue;
    }

    public boolean hasMatte() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.hasMatte == null) {
                if (hasMatteOnThisLayer()) {
                    this.hasMatte = Boolean.TRUE;
                    return true;
                }
                for (int size = this.layers.size() - 1; size >= 0; size--) {
                    if (this.layers.get(size).hasMatteOnThisLayer()) {
                        this.hasMatte = Boolean.TRUE;
                        return true;
                    }
                }
                this.hasMatte = Boolean.FALSE;
            }
            return this.hasMatte.booleanValue();
        }
        return invokeV.booleanValue;
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer
    public void resolveChildKeyPath(KeyPath keyPath, int i2, List<KeyPath> list, KeyPath keyPath2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(1048581, this, keyPath, i2, list, keyPath2) == null) {
            for (int i3 = 0; i3 < this.layers.size(); i3++) {
                this.layers.get(i3).resolveKeyPath(keyPath, i2, list, keyPath2);
            }
        }
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer
    public void setProgress(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048582, this, f2) == null) {
            super.setProgress(f2);
            if (this.timeRemapping != null) {
                f2 = ((this.timeRemapping.getValue().floatValue() * this.layerModel.getComposition().getFrameRate()) - this.layerModel.getComposition().getStartFrame()) / (this.lottieDrawable.getComposition().getDurationFrames() + 0.01f);
            }
            if (this.timeRemapping == null) {
                f2 -= this.layerModel.getStartProgress();
            }
            if (this.layerModel.getTimeStretch() != 0.0f) {
                f2 /= this.layerModel.getTimeStretch();
            }
            for (int size = this.layers.size() - 1; size >= 0; size--) {
                this.layers.get(size).setProgress(f2);
            }
        }
    }
}
