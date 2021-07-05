package com.airbnb.lottie.utils;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class GammaEvaluator {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public GammaEvaluator() {
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

    public static float EOCF_sRGB(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeF = interceptable.invokeF(65537, null, f2)) == null) ? f2 <= 0.04045f ? f2 / 12.92f : (float) Math.pow((f2 + 0.055f) / 1.055f, 2.4000000953674316d) : invokeF.floatValue;
    }

    public static float OECF_sRGB(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeF = interceptable.invokeF(65538, null, f2)) == null) ? f2 <= 0.0031308f ? f2 * 12.92f : (float) ((Math.pow(f2, 0.4166666567325592d) * 1.0549999475479126d) - 0.054999999701976776d) : invokeF.floatValue;
    }

    public static int evaluate(float f2, int i2, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{Float.valueOf(f2), Integer.valueOf(i2), Integer.valueOf(i3)})) == null) {
            if (i2 == i3) {
                return i2;
            }
            float f3 = ((i2 >> 24) & 255) / 255.0f;
            float EOCF_sRGB = EOCF_sRGB(((i2 >> 16) & 255) / 255.0f);
            float EOCF_sRGB2 = EOCF_sRGB(((i2 >> 8) & 255) / 255.0f);
            float EOCF_sRGB3 = EOCF_sRGB((i2 & 255) / 255.0f);
            return (Math.round(OECF_sRGB(EOCF_sRGB + ((EOCF_sRGB(((i3 >> 16) & 255) / 255.0f) - EOCF_sRGB) * f2)) * 255.0f) << 16) | (Math.round((f3 + (((((i3 >> 24) & 255) / 255.0f) - f3) * f2)) * 255.0f) << 24) | (Math.round(OECF_sRGB(EOCF_sRGB2 + ((EOCF_sRGB(((i3 >> 8) & 255) / 255.0f) - EOCF_sRGB2) * f2)) * 255.0f) << 8) | Math.round(OECF_sRGB(EOCF_sRGB3 + (f2 * (EOCF_sRGB((i3 & 255) / 255.0f) - EOCF_sRGB3))) * 255.0f);
        }
        return invokeCommon.intValue;
    }
}
