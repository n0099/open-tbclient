package com.airbnb.lottie.model.content;

import android.graphics.PointF;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.RectangleContent;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatablePointValue;
import com.airbnb.lottie.model.animatable.AnimatableValue;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class RectangleShape implements ContentModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final AnimatableFloatValue cornerRadius;
    public final boolean hidden;
    public final String name;
    public final AnimatableValue<PointF, PointF> position;
    public final AnimatablePointValue size;

    public RectangleShape(String str, AnimatableValue<PointF, PointF> animatableValue, AnimatablePointValue animatablePointValue, AnimatableFloatValue animatableFloatValue, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, animatableValue, animatablePointValue, animatableFloatValue, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.name = str;
        this.position = animatableValue;
        this.size = animatablePointValue;
        this.cornerRadius = animatableFloatValue;
        this.hidden = z;
    }

    public AnimatableFloatValue getCornerRadius() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.cornerRadius : (AnimatableFloatValue) invokeV.objValue;
    }

    public String getName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.name : (String) invokeV.objValue;
    }

    public AnimatableValue<PointF, PointF> getPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.position : (AnimatableValue) invokeV.objValue;
    }

    public AnimatablePointValue getSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.size : (AnimatablePointValue) invokeV.objValue;
    }

    public boolean isHidden() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.hidden : invokeV.booleanValue;
    }

    @Override // com.airbnb.lottie.model.content.ContentModel
    public Content toContent(LottieDrawable lottieDrawable, BaseLayer baseLayer) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, lottieDrawable, baseLayer)) == null) ? new RectangleContent(lottieDrawable, baseLayer, this) : (Content) invokeLL.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return "RectangleShape{position=" + this.position + ", size=" + this.size + '}';
        }
        return (String) invokeV.objValue;
    }
}
