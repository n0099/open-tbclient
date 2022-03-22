package com.baidu.ar.h;

import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic = null;
    public static int xT = 5;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1921142640, "Lcom/baidu/ar/h/b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1921142640, "Lcom/baidu/ar/h/b;");
        }
    }

    public static void T(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65537, null, z) == null) {
            xT = z ? 2 : 6;
        }
    }

    public static void aQ(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, str) == null) {
            c("ARLOG", gw() + " " + str);
        }
    }

    public static void aR(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, str) == null) {
            k("ARLOG", gw() + " " + str);
        }
    }

    public static void aS(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str) == null) {
            b("ARLOG", gw() + " " + str);
        }
    }

    public static void b(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65541, null, str, str2) == null) || xT > 6) {
            return;
        }
        Log.e(str, str2);
    }

    public static void c(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65542, null, str, str2) == null) || xT > 3) {
            return;
        }
        Log.d(str, str2);
    }

    public static String gw() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            StackTraceElement stackTraceElement = new Exception().getStackTrace()[2];
            StringBuffer stringBuffer = new StringBuffer(PreferencesUtil.LEFT_MOUNT);
            stringBuffer.append(stackTraceElement.getFileName());
            stringBuffer.append(" | ");
            stringBuffer.append(stackTraceElement.getLineNumber());
            stringBuffer.append(" | ");
            stringBuffer.append(stackTraceElement.getMethodName());
            stringBuffer.append(PreferencesUtil.RIGHT_MOUNT);
            return stringBuffer.toString();
        }
        return (String) invokeV.objValue;
    }

    public static void j(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65544, null, str, str2) == null) || xT > 2) {
            return;
        }
        Log.v(str, str2);
    }

    public static void k(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65545, null, str, str2) == null) || xT > 4) {
            return;
        }
        Log.i(str, str2);
    }

    public static void l(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65546, null, str, str2) == null) || xT > 5) {
            return;
        }
        Log.w(str, str2);
    }
}
