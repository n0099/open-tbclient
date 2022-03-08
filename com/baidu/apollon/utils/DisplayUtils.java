package com.baidu.apollon.utils;

import android.content.Context;
import android.util.DisplayMetrics;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public final class DisplayUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final float a = 0.5f;

    /* renamed from: b  reason: collision with root package name */
    public static DisplayMetrics f31338b;
    public transient /* synthetic */ FieldHolder $fh;

    public DisplayUtils() {
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

    public static void a(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65537, null, context) == null) && f31338b == null) {
            f31338b = context.getResources().getDisplayMetrics();
        }
    }

    public static int dip2px(Context context, float f2) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLF = interceptable.invokeLF(65538, null, context, f2)) == null) ? (int) ((f2 * context.getResources().getDisplayMetrics().density) + 0.5f) : invokeLF.intValue;
    }

    public static int getDisplayHeight(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            a(context);
            return f31338b.heightPixels;
        }
        return invokeL.intValue;
    }

    public static int getDisplayWidth(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            a(context);
            return f31338b.widthPixels;
        }
        return invokeL.intValue;
    }

    public static int px2dip(Context context, float f2) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLF = interceptable.invokeLF(65541, null, context, f2)) == null) ? (int) ((f2 / context.getResources().getDisplayMetrics().density) + 0.5f) : invokeLF.intValue;
    }

    public static int px2sp(float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65542, null, new Object[]{Float.valueOf(f2), Float.valueOf(f3)})) == null) ? (int) ((f2 / f3) + 0.5f) : invokeCommon.intValue;
    }

    public static int sp2px(float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, null, new Object[]{Float.valueOf(f2), Float.valueOf(f3)})) == null) ? (int) ((f2 * f3) + 0.5f) : invokeCommon.intValue;
    }
}
