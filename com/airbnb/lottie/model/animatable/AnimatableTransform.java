package com.airbnb.lottie.model.animatable;

import android.graphics.PointF;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.ModifierContent;
import com.airbnb.lottie.animation.keyframe.TransformKeyframeAnimation;
import com.airbnb.lottie.model.content.ContentModel;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class AnimatableTransform implements ModifierContent, ContentModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
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

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AnimatableTransform() {
        this(null, null, null, null, null, null, null, null, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr = newInitContext.callArgs;
                this((AnimatablePathValue) objArr[0], (AnimatableValue) objArr[1], (AnimatableScaleValue) objArr[2], (AnimatableFloatValue) objArr[3], (AnimatableIntegerValue) objArr[4], (AnimatableFloatValue) objArr[5], (AnimatableFloatValue) objArr[6], (AnimatableFloatValue) objArr[7], (AnimatableFloatValue) objArr[8]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public TransformKeyframeAnimation createAnimation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new TransformKeyframeAnimation(this) : (TransformKeyframeAnimation) invokeV.objValue;
    }

    @Nullable
    public AnimatablePathValue getAnchorPoint() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.anchorPoint : (AnimatablePathValue) invokeV.objValue;
    }

    @Nullable
    public AnimatableFloatValue getEndOpacity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.endOpacity : (AnimatableFloatValue) invokeV.objValue;
    }

    @Nullable
    public AnimatableIntegerValue getOpacity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.opacity : (AnimatableIntegerValue) invokeV.objValue;
    }

    @Nullable
    public AnimatableValue<PointF, PointF> getPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.position : (AnimatableValue) invokeV.objValue;
    }

    @Nullable
    public AnimatableFloatValue getRotation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.rotation : (AnimatableFloatValue) invokeV.objValue;
    }

    @Nullable
    public AnimatableScaleValue getScale() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.scale : (AnimatableScaleValue) invokeV.objValue;
    }

    @Nullable
    public AnimatableFloatValue getSkew() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.skew : (AnimatableFloatValue) invokeV.objValue;
    }

    @Nullable
    public AnimatableFloatValue getSkewAngle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.skewAngle : (AnimatableFloatValue) invokeV.objValue;
    }

    @Nullable
    public AnimatableFloatValue getStartOpacity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.startOpacity : (AnimatableFloatValue) invokeV.objValue;
    }

    @Override // com.airbnb.lottie.model.content.ContentModel
    @Nullable
    public Content toContent(LottieDrawable lottieDrawable, BaseLayer baseLayer) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, lottieDrawable, baseLayer)) == null) {
            return null;
        }
        return (Content) invokeLL.objValue;
    }

    public AnimatableTransform(@Nullable AnimatablePathValue animatablePathValue, @Nullable AnimatableValue<PointF, PointF> animatableValue, @Nullable AnimatableScaleValue animatableScaleValue, @Nullable AnimatableFloatValue animatableFloatValue, @Nullable AnimatableIntegerValue animatableIntegerValue, @Nullable AnimatableFloatValue animatableFloatValue2, @Nullable AnimatableFloatValue animatableFloatValue3, @Nullable AnimatableFloatValue animatableFloatValue4, @Nullable AnimatableFloatValue animatableFloatValue5) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {animatablePathValue, animatableValue, animatableScaleValue, animatableFloatValue, animatableIntegerValue, animatableFloatValue2, animatableFloatValue3, animatableFloatValue4, animatableFloatValue5};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
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
