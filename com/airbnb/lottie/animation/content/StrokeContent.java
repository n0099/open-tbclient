package com.airbnb.lottie.animation.content;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ColorKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.content.ShapeStroke;
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
public class StrokeContent extends BaseStrokeContent {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final BaseKeyframeAnimation<Integer, Integer> colorAnimation;
    @Nullable
    public BaseKeyframeAnimation<ColorFilter, ColorFilter> colorFilterAnimation;
    public final boolean hidden;
    public final BaseLayer layer;
    public final String name;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StrokeContent(LottieDrawable lottieDrawable, BaseLayer baseLayer, ShapeStroke shapeStroke) {
        super(lottieDrawable, baseLayer, shapeStroke.getCapType().toPaintCap(), shapeStroke.getJoinType().toPaintJoin(), shapeStroke.getMiterLimit(), shapeStroke.getOpacity(), shapeStroke.getWidth(), shapeStroke.getLineDashPattern(), shapeStroke.getDashOffset());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r4;
            Object[] objArr = {lottieDrawable, baseLayer, shapeStroke};
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
        this.layer = baseLayer;
        this.name = shapeStroke.getName();
        this.hidden = shapeStroke.isHidden();
        BaseKeyframeAnimation<Integer, Integer> createAnimation = shapeStroke.getColor().createAnimation();
        this.colorAnimation = createAnimation;
        createAnimation.addUpdateListener(this);
        baseLayer.addAnimation(this.colorAnimation);
    }

    @Override // com.airbnb.lottie.animation.content.BaseStrokeContent, com.airbnb.lottie.model.KeyPathElement
    public <T> void addValueCallback(T t, @Nullable LottieValueCallback<T> lottieValueCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, t, lottieValueCallback) == null) {
            super.addValueCallback(t, lottieValueCallback);
            if (t == LottieProperty.STROKE_COLOR) {
                this.colorAnimation.setValueCallback(lottieValueCallback);
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
                this.layer.addAnimation(this.colorAnimation);
            }
        }
    }

    @Override // com.airbnb.lottie.animation.content.BaseStrokeContent, com.airbnb.lottie.animation.content.DrawingContent
    public void draw(Canvas canvas, Matrix matrix, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, canvas, matrix, i2) == null) || this.hidden) {
            return;
        }
        this.paint.setColor(((ColorKeyframeAnimation) this.colorAnimation).getIntValue());
        BaseKeyframeAnimation<ColorFilter, ColorFilter> baseKeyframeAnimation = this.colorFilterAnimation;
        if (baseKeyframeAnimation != null) {
            this.paint.setColorFilter(baseKeyframeAnimation.getValue());
        }
        super.draw(canvas, matrix, i2);
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public String getName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.name : (String) invokeV.objValue;
    }
}
