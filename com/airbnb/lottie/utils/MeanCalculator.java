package com.airbnb.lottie.utils;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class MeanCalculator {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int n;
    public float sum;

    public MeanCalculator() {
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

    public void add(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048576, this, f2) == null) {
            float f3 = this.sum + f2;
            this.sum = f3;
            int i2 = this.n + 1;
            this.n = i2;
            if (i2 == Integer.MAX_VALUE) {
                this.sum = f3 / 2.0f;
                this.n = i2 / 2;
            }
        }
    }

    public float getMean() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            int i2 = this.n;
            if (i2 == 0) {
                return 0.0f;
            }
            return this.sum / i2;
        }
        return invokeV.floatValue;
    }
}
