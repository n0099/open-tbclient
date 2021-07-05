package com.airbnb.lottie.value;

import androidx.annotation.RestrictTo;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class LottieFrameInfo<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public float endFrame;
    public T endValue;
    public float interpolatedKeyframeProgress;
    public float linearKeyframeProgress;
    public float overallProgress;
    public float startFrame;
    public T startValue;

    public LottieFrameInfo() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public float getEndFrame() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.endFrame : invokeV.floatValue;
    }

    public T getEndValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.endValue : (T) invokeV.objValue;
    }

    public float getInterpolatedKeyframeProgress() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.interpolatedKeyframeProgress : invokeV.floatValue;
    }

    public float getLinearKeyframeProgress() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.linearKeyframeProgress : invokeV.floatValue;
    }

    public float getOverallProgress() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.overallProgress : invokeV.floatValue;
    }

    public float getStartFrame() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.startFrame : invokeV.floatValue;
    }

    public T getStartValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.startValue : (T) invokeV.objValue;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public LottieFrameInfo<T> set(float f2, float f3, T t, T t2, float f4, float f5, float f6) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), t, t2, Float.valueOf(f4), Float.valueOf(f5), Float.valueOf(f6)})) == null) {
            this.startFrame = f2;
            this.endFrame = f3;
            this.startValue = t;
            this.endValue = t2;
            this.linearKeyframeProgress = f4;
            this.interpolatedKeyframeProgress = f5;
            this.overallProgress = f6;
            return this;
        }
        return (LottieFrameInfo) invokeCommon.objValue;
    }
}
