package com.baidu.ar.h;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes10.dex */
public final class s {
    public static /* synthetic */ Interceptable $ic = null;
    public static String yj = "https://dusee.baidu.com";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1921143167, "Lcom/baidu/ar/h/s;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1921143167, "Lcom/baidu/ar/h/s;");
        }
    }

    public static String gO() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? "https://aip.baidubce.com/rpc/2.0/brain/v1/ar/launchar" : (String) invokeV.objValue;
    }

    public static String gP() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return yj + "/artrack-bos/content/authentication";
        }
        return (String) invokeV.objValue;
    }

    public static String gQ() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return yj + "/artrack/count_ar";
        }
        return (String) invokeV.objValue;
    }

    public static String gR() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            return yj + "/artrack-bos/performance/infos";
        }
        return (String) invokeV.objValue;
    }

    public static String gS() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            return yj + "/artrack-bos/performance/items";
        }
        return (String) invokeV.objValue;
    }

    public static String gT() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            return yj + "/artrack-bos/content/zipquery";
        }
        return (String) invokeV.objValue;
    }

    public static String gU() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            return yj + "/ar-client/capacity/conf";
        }
        return (String) invokeV.objValue;
    }

    public static String gV() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? "https://mj.baidu.com/child-face" : (String) invokeV.objValue;
    }

    public static String gW() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            return yj + "/xvision/xvision_sync";
        }
        return (String) invokeV.objValue;
    }
}
