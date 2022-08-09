package com.baidu.live.arch.utils;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.common.param.CommonUrlParamManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class MiniCommonUrlParamUtils {
    public static /* synthetic */ Interceptable $ic;
    public static boolean hasCheck;
    public static boolean isMappingAvailable;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-2054610068, "Lcom/baidu/live/arch/utils/MiniCommonUrlParamUtils;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-2054610068, "Lcom/baidu/live/arch/utils/MiniCommonUrlParamUtils;");
        }
    }

    public MiniCommonUrlParamUtils() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static String appendParam(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return str;
            }
            if (!hasCheck) {
                checkMapping();
            }
            return invokeParamMethod(str);
        }
        return (String) invokeL.objValue;
    }

    public static void checkMapping() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, null) == null) {
            try {
                isMappingAvailable = Class.forName("com.baidu.common.param.CommonUrlParamManager").getMethod("appendParam", String.class, Integer.TYPE) != null;
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e2) {
                e2.printStackTrace();
            }
            hasCheck = true;
        }
    }

    public static String invokeParamMethod(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            if (isMappingAvailable) {
                return CommonUrlParamManager.getInstance().appendParam(str, 1);
            }
            return CommonUrlParamManager.getInstance().processUrl(str);
        }
        return (String) invokeL.objValue;
    }

    public static boolean isMappingAvailable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            if (!hasCheck) {
                checkMapping();
            }
            return isMappingAvailable;
        }
        return invokeV.booleanValue;
    }
}
