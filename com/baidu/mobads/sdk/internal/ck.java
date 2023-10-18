package com.baidu.mobads.sdk.internal;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class ck {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "9.322";
    public static final String b = "";
    public static final Boolean c;
    public static final Boolean d;
    public static final String e = "9.322";
    public static final int f = 5000;
    public static final Boolean g;
    public static String h = "adserv_0";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1833694695, "Lcom/baidu/mobads/sdk/internal/ck;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1833694695, "Lcom/baidu/mobads/sdk/internal/ck;");
                return;
            }
        }
        c = Boolean.FALSE;
        d = Boolean.TRUE;
        g = Boolean.FALSE;
    }

    public ck() {
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

    public static String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return h;
        }
        return (String) invokeV.objValue;
    }

    public static double b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            try {
                return Double.parseDouble("9.322");
            } catch (Exception unused) {
                return 0.0d;
            }
        }
        return invokeV.doubleValue;
    }

    public static double c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            try {
                return Double.parseDouble("9.322");
            } catch (Exception unused) {
                return 0.0d;
            }
        }
        return invokeV.doubleValue;
    }

    public static int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            try {
                return Integer.valueOf("9.322".split("\\.")[0]).intValue();
            } catch (Exception unused) {
                return 0;
            }
        }
        return invokeV.intValue;
    }
}
