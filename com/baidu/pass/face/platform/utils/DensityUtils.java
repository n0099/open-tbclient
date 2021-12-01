package com.baidu.pass.face.platform.utils;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public final class DensityUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String[] BUILD_MODELS;
    public static final float DOT_FIVE = 0.5f;
    public static final int PORTRAIT_DEGREE_270 = 270;
    public static final int PORTRAIT_DEGREE_90 = 90;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1137025178, "Lcom/baidu/pass/face/platform/utils/DensityUtils;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1137025178, "Lcom/baidu/pass/face/platform/utils/DensityUtils;");
                return;
            }
        }
        BUILD_MODELS = new String[]{"i700v", "A862W", "V8526"};
    }

    public DensityUtils() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static int dip2px(Context context, float f2) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLF = interceptable.invokeLF(65538, null, context, f2)) == null) ? (int) ((f2 * getDensity(context)) + 0.5f) : invokeLF.intValue;
    }

    public static float getDensity(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) ? context.getResources().getDisplayMetrics().density : invokeL.floatValue;
    }

    public static int getDensityDpi(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) ? context.getResources().getDisplayMetrics().densityDpi : invokeL.intValue;
    }

    public static int getDisplayHeight(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) ? context.getResources().getDisplayMetrics().heightPixels : invokeL.intValue;
    }

    public static int getDisplayWidth(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65542, null, context)) == null) ? context.getResources().getDisplayMetrics().widthPixels : invokeL.intValue;
    }

    public static int getPortraitDegree() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            for (String str : BUILD_MODELS) {
                if (TextUtils.equals(str, Build.MODEL)) {
                    return 270;
                }
            }
            return 90;
        }
        return invokeV.intValue;
    }

    public static int px2dip(Context context, float f2) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLF = interceptable.invokeLF(65544, null, context, f2)) == null) ? (int) ((f2 / getDensity(context)) + 0.5f) : invokeLF.intValue;
    }

    public static int sp2px(Context context, float f2) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLF = interceptable.invokeLF(65545, null, context, f2)) == null) ? (int) ((f2 * context.getResources().getDisplayMetrics().scaledDensity) + 0.5f) : invokeLF.intValue;
    }

    public static boolean supportCameraPortrait() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) ? APIUtils.hasFroyo() && !TextUtils.equals("GT-S5830i", Build.PRODUCT) : invokeV.booleanValue;
    }
}
