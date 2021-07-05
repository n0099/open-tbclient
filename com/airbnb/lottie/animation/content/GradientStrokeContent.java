package com.airbnb.lottie.animation.content;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import androidx.annotation.Nullable;
import androidx.collection.LongSparseArray;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.content.GradientColor;
import com.airbnb.lottie.model.content.GradientStroke;
import com.airbnb.lottie.model.content.GradientType;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.value.LottieValueCallback;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes.dex */
public class GradientStrokeContent extends BaseStrokeContent {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int CACHE_STEPS_MS = 32;
    public transient /* synthetic */ FieldHolder $fh;
    public final RectF boundsRect;
    public final int cacheSteps;
    public final BaseKeyframeAnimation<GradientColor, GradientColor> colorAnimation;
    @Nullable
    public ValueCallbackKeyframeAnimation colorCallbackAnimation;
    public final BaseKeyframeAnimation<PointF, PointF> endPointAnimation;
    public final boolean hidden;
    public final LongSparseArray<LinearGradient> linearGradientCache;
    public final String name;
    public final LongSparseArray<RadialGradient> radialGradientCache;
    public final BaseKeyframeAnimation<PointF, PointF> startPointAnimation;
    public final GradientType type;

    /* JADX DEBUG: Multi-variable search result rejected for r17v0, resolved type: com.airbnb.lottie.animation.content.GradientStrokeContent */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public GradientStrokeContent(LottieDrawable lottieDrawable, BaseLayer baseLayer, GradientStroke gradientStroke) {
        super(lottieDrawable, baseLayer, gradientStroke.getCapType().toPaintCap(), gradientStroke.getJoinType().toPaintJoin(), gradientStroke.getMiterLimit(), gradientStroke.getOpacity(), gradientStroke.getWidth(), gradientStroke.getLineDashPattern(), gradientStroke.getDashOffset());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r4;
            Object[] objArr = {lottieDrawable, baseLayer, gradientStroke};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((LottieDrawable) objArr2[0], (BaseLayer) objArr2[1], (Paint.Cap) objArr2[2], (Paint.Join) objArr2[3], ((Float) objArr2[4]).floatValue(), (AnimatableIntegerValue) objArr2[5], (AnimatableFloatValue) objArr2[6], (List) objArr2[7], (AnimatableFloatValue) objArr2[8]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.linearGradientCache = new LongSparseArray<>();
        this.radialGradientCache = new LongSparseArray<>();
        this.boundsRect = new RectF();
        this.name = gradientStroke.getName();
        this.type = gradientStroke.getGradientType();
        this.hidden = gradientStroke.isHidden();
        lottieDrawable.getComposition().getDuration();
        this.cacheSteps = (int) (this / 32.0f);
        BaseKeyframeAnimation<GradientColor, GradientColor> createAnimation = gradientStroke.getGradientColor().createAnimation();
        this.colorAnimation = createAnimation;
        createAnimation.addUpdateListener(this);
        baseLayer.addAnimation(this.colorAnimation);
        BaseKeyframeAnimation<PointF, PointF> createAnimation2 = gradientStroke.getStartPoint().createAnimation();
        this.startPointAnimation = createAnimation2;
        createAnimation2.addUpdateListener(this);
        baseLayer.addAnimation(this.startPointAnimation);
        BaseKeyframeAnimation<PointF, PointF> createAnimation3 = gradientStroke.getEndPoint().createAnimation();
        this.endPointAnimation = createAnimation3;
        createAnimation3.addUpdateListener(this);
        baseLayer.addAnimation(this.endPointAnimation);
    }

    private int[] applyDynamicColorsIfNeeded(int[] iArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, iArr)) == null) {
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation = this.colorCallbackAnimation;
            if (valueCallbackKeyframeAnimation != null) {
                Integer[] numArr = (Integer[]) valueCallbackKeyframeAnimation.getValue();
                int i2 = 0;
                if (iArr.length == numArr.length) {
                    while (i2 < iArr.length) {
                        iArr[i2] = numArr[i2].intValue();
                        i2++;
                    }
                } else {
                    iArr = new int[numArr.length];
                    while (i2 < numArr.length) {
                        iArr[i2] = numArr[i2].intValue();
                        i2++;
                    }
                }
            }
            return iArr;
        }
        return (int[]) invokeL.objValue;
    }

    private int getGradientHash() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            int round = Math.round(this.startPointAnimation.getProgress() * this.cacheSteps);
            int round2 = Math.round(this.endPointAnimation.getProgress() * this.cacheSteps);
            int round3 = Math.round(this.colorAnimation.getProgress() * this.cacheSteps);
            int i2 = round != 0 ? 527 * round : 17;
            if (round2 != 0) {
                i2 = i2 * 31 * round2;
            }
            return round3 != 0 ? i2 * 31 * round3 : i2;
        }
        return invokeV.intValue;
    }

    private LinearGradient getLinearGradient() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            long gradientHash = getGradientHash();
            LinearGradient linearGradient = this.linearGradientCache.get(gradientHash);
            if (linearGradient != null) {
                return linearGradient;
            }
            PointF value = this.startPointAnimation.getValue();
            PointF value2 = this.endPointAnimation.getValue();
            GradientColor value3 = this.colorAnimation.getValue();
            LinearGradient linearGradient2 = new LinearGradient(value.x, value.y, value2.x, value2.y, applyDynamicColorsIfNeeded(value3.getColors()), value3.getPositions(), Shader.TileMode.CLAMP);
            this.linearGradientCache.put(gradientHash, linearGradient2);
            return linearGradient2;
        }
        return (LinearGradient) invokeV.objValue;
    }

    private RadialGradient getRadialGradient() {
        InterceptResult invokeV;
        float f2;
        float f3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65540, this)) == null) {
            long gradientHash = getGradientHash();
            RadialGradient radialGradient = this.radialGradientCache.get(gradientHash);
            if (radialGradient != null) {
                return radialGradient;
            }
            PointF value = this.startPointAnimation.getValue();
            PointF value2 = this.endPointAnimation.getValue();
            GradientColor value3 = this.colorAnimation.getValue();
            int[] applyDynamicColorsIfNeeded = applyDynamicColorsIfNeeded(value3.getColors());
            float[] positions = value3.getPositions();
            RadialGradient radialGradient2 = new RadialGradient(value.x, value.y, (float) Math.hypot(value2.x - f2, value2.y - f3), applyDynamicColorsIfNeeded, positions, Shader.TileMode.CLAMP);
            this.radialGradientCache.put(gradientHash, radialGradient2);
            return radialGradient2;
        }
        return (RadialGradient) invokeV.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: java.lang.Integer[] */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.airbnb.lottie.animation.content.BaseStrokeContent, com.airbnb.lottie.model.KeyPathElement
    public <T> void addValueCallback(T t, @Nullable LottieValueCallback<T> lottieValueCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, t, lottieValueCallback) == null) {
            super.addValueCallback(t, lottieValueCallback);
            if (t == LottieProperty.GRADIENT_COLOR) {
                ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation = this.colorCallbackAnimation;
                if (valueCallbackKeyframeAnimation != null) {
                    this.layer.removeAnimation(valueCallbackKeyframeAnimation);
                }
                if (lottieValueCallback == null) {
                    this.colorCallbackAnimation = null;
                    return;
                }
                ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation2 = new ValueCallbackKeyframeAnimation(lottieValueCallback);
                this.colorCallbackAnimation = valueCallbackKeyframeAnimation2;
                valueCallbackKeyframeAnimation2.addUpdateListener(this);
                this.layer.addAnimation(this.colorCallbackAnimation);
            }
        }
    }

    @Override // com.airbnb.lottie.animation.content.BaseStrokeContent, com.airbnb.lottie.animation.content.DrawingContent
    public void draw(Canvas canvas, Matrix matrix, int i2) {
        Shader radialGradient;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, canvas, matrix, i2) == null) || this.hidden) {
            return;
        }
        getBounds(this.boundsRect, matrix, false);
        if (this.type == GradientType.LINEAR) {
            radialGradient = getLinearGradient();
        } else {
            radialGradient = getRadialGradient();
        }
        radialGradient.setLocalMatrix(matrix);
        this.paint.setShader(radialGradient);
        super.draw(canvas, matrix, i2);
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public String getName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.name : (String) invokeV.objValue;
    }
}
