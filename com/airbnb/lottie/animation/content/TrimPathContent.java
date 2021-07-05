package com.airbnb.lottie.animation.content;

import androidx.core.view.InputDeviceCompat;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class TrimPathContent implements Content, BaseKeyframeAnimation.AnimationListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final BaseKeyframeAnimation<?, Float> endAnimation;
    public final boolean hidden;
    public final List<BaseKeyframeAnimation.AnimationListener> listeners;
    public final String name;
    public final BaseKeyframeAnimation<?, Float> offsetAnimation;
    public final BaseKeyframeAnimation<?, Float> startAnimation;
    public final ShapeTrimPath.Type type;

    public TrimPathContent(BaseLayer baseLayer, ShapeTrimPath shapeTrimPath) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseLayer, shapeTrimPath};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.listeners = new ArrayList();
        this.name = shapeTrimPath.getName();
        this.hidden = shapeTrimPath.isHidden();
        this.type = shapeTrimPath.getType();
        this.startAnimation = shapeTrimPath.getStart().createAnimation();
        this.endAnimation = shapeTrimPath.getEnd().createAnimation();
        this.offsetAnimation = shapeTrimPath.getOffset().createAnimation();
        baseLayer.addAnimation(this.startAnimation);
        baseLayer.addAnimation(this.endAnimation);
        baseLayer.addAnimation(this.offsetAnimation);
        this.startAnimation.addUpdateListener(this);
        this.endAnimation.addUpdateListener(this);
        this.offsetAnimation.addUpdateListener(this);
    }

    public void addListener(BaseKeyframeAnimation.AnimationListener animationListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, animationListener) == null) {
            this.listeners.add(animationListener);
        }
    }

    public BaseKeyframeAnimation<?, Float> getEnd() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.endAnimation : (BaseKeyframeAnimation) invokeV.objValue;
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public String getName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.name : (String) invokeV.objValue;
    }

    public BaseKeyframeAnimation<?, Float> getOffset() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.offsetAnimation : (BaseKeyframeAnimation) invokeV.objValue;
    }

    public BaseKeyframeAnimation<?, Float> getStart() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.startAnimation : (BaseKeyframeAnimation) invokeV.objValue;
    }

    public ShapeTrimPath.Type getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.type : (ShapeTrimPath.Type) invokeV.objValue;
    }

    public boolean isHidden() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.hidden : invokeV.booleanValue;
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener
    public void onValueChanged() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            for (int i2 = 0; i2 < this.listeners.size(); i2++) {
                this.listeners.get(i2).onValueChanged();
            }
        }
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public void setContents(List<Content> list, List<Content> list2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, list, list2) == null) {
        }
    }
}
