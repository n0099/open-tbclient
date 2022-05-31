package com.baidu.lbsapi.auth;

import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.yy.hiidostatis.defs.obj.ParamableElem;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic = null;
    public static boolean a = false;
    public static String b = "BaiduApiAuth";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-615677059, "Lcom/baidu/lbsapi/auth/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-615677059, "Lcom/baidu/lbsapi/auth/a;");
        }
    }

    public static String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            StackTraceElement stackTraceElement = new Throwable().getStackTrace()[2];
            return stackTraceElement.getFileName() + PreferencesUtil.LEFT_MOUNT + stackTraceElement.getLineNumber() + PreferencesUtil.RIGHT_MOUNT;
        }
        return (String) invokeV.objValue;
    }

    public static void a(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65538, null, str) == null) && a && Thread.currentThread().getStackTrace().length != 0) {
            String str2 = b;
            Log.d(str2, a() + ParamableElem.DIVIDE_PARAM + str);
        }
    }

    public static void b(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, null, str) == null) || Thread.currentThread().getStackTrace().length == 0) {
            return;
        }
        Log.i(b, str);
    }

    public static void c(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str) == null) && a && Thread.currentThread().getStackTrace().length != 0) {
            String str2 = b;
            Log.e(str2, a() + ParamableElem.DIVIDE_PARAM + str);
        }
    }
}
