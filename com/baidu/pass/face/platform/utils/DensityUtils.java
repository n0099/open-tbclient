package com.baidu.pass.face.platform.utils;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public final class DensityUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final float DOT_FIVE = 0.5f;
    public static final int PORTRAIT_DEGREE_270 = 270;
    public static final int PORTRAIT_DEGREE_90 = 90;
    public transient /* synthetic */ FieldHolder $fh;

    public DensityUtils() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static int dip2px(Context context, float f2) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLF = interceptable.invokeLF(65537, null, context, f2)) == null) ? (int) ((f2 * getDensity(context)) + 0.5f) : invokeLF.intValue;
    }

    public static float getDensity(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) ? context.getResources().getDisplayMetrics().density : invokeL.floatValue;
    }

    public static int getDensityDpi(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) ? context.getResources().getDisplayMetrics().densityDpi : invokeL.intValue;
    }

    public static int getDisplayHeight(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) ? context.getResources().getDisplayMetrics().heightPixels : invokeL.intValue;
    }

    public static int getDisplayWidth(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) ? context.getResources().getDisplayMetrics().widthPixels : invokeL.intValue;
    }

    public static int px2dip(Context context, float f2) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLF = interceptable.invokeLF(65542, null, context, f2)) == null) ? (int) ((f2 / getDensity(context)) + 0.5f) : invokeLF.intValue;
    }

    public static int sp2px(Context context, float f2) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLF = interceptable.invokeLF(65543, null, context, f2)) == null) ? (int) ((f2 * context.getResources().getDisplayMetrics().scaledDensity) + 0.5f) : invokeLF.intValue;
    }
}
