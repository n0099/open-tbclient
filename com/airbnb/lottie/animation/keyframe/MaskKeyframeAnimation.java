package com.airbnb.lottie.animation.keyframe;

import android.graphics.Path;
import com.airbnb.lottie.model.content.Mask;
import com.airbnb.lottie.model.content.ShapeData;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class MaskKeyframeAnimation {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<BaseKeyframeAnimation<ShapeData, Path>> maskAnimations;
    public final List<Mask> masks;
    public final List<BaseKeyframeAnimation<Integer, Integer>> opacityAnimations;

    public MaskKeyframeAnimation(List<Mask> list) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.masks = list;
        this.maskAnimations = new ArrayList(list.size());
        this.opacityAnimations = new ArrayList(list.size());
        for (int i4 = 0; i4 < list.size(); i4++) {
            this.maskAnimations.add(list.get(i4).getMaskPath().createAnimation());
            this.opacityAnimations.add(list.get(i4).getOpacity().createAnimation());
        }
    }

    public List<BaseKeyframeAnimation<ShapeData, Path>> getMaskAnimations() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.maskAnimations : (List) invokeV.objValue;
    }

    public List<Mask> getMasks() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.masks : (List) invokeV.objValue;
    }

    public List<BaseKeyframeAnimation<Integer, Integer>> getOpacityAnimations() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.opacityAnimations : (List) invokeV.objValue;
    }
}
