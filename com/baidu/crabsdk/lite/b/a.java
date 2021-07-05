package com.baidu.crabsdk.lite.b;

import android.util.Log;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.HashMap;
/* loaded from: classes3.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static String f4720a = "CRABLITE";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1349384661, "Lcom/baidu/crabsdk/lite/b/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1349384661, "Lcom/baidu/crabsdk/lite/b/a;");
        }
    }

    public static boolean a(String str) {
        InterceptResult invokeL;
        HashMap<String, Object> hashMap;
        Object obj;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if (str == null || (hashMap = com.baidu.crabsdk.lite.a.f4688a.get(str)) == null || (obj = hashMap.get("sdk_log")) == null) {
                return true;
            }
            return ((Boolean) obj).booleanValue();
        }
        return invokeL.booleanValue;
    }

    public static String b(String str) {
        InterceptResult invokeL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            if (stackTrace != null) {
                for (StackTraceElement stackTraceElement : stackTrace) {
                    if (!stackTraceElement.isNativeMethod() && !stackTraceElement.getClassName().equals(Thread.class.getName()) && !stackTraceElement.getClassName().equals("com.baidu.crabsdk.util.BLog")) {
                        str2 = PreferencesUtil.LEFT_MOUNT + Thread.currentThread().getName() + "(" + Thread.currentThread().getId() + "): " + stackTraceElement.getFileName() + ":" + stackTraceElement.getLineNumber() + PreferencesUtil.RIGHT_MOUNT;
                        break;
                    }
                }
            }
            str2 = null;
            if (str2 == null) {
                return str;
            }
            return str2 + " - " + str;
        }
        return (String) invokeL.objValue;
    }

    public static int c(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, str2)) == null) {
            if (a(str)) {
                return Log.d(f4720a, b(str2));
            }
            return -1;
        }
        return invokeLL.intValue;
    }

    public static int d(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65540, null, str, str2)) == null) {
            if (a(str)) {
                return Log.e(f4720a, b(str2));
            }
            return -1;
        }
        return invokeLL.intValue;
    }

    public static int e(String str, String str2, Throwable th) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(AdIconUtil.AD_TEXT_ID, null, str, str2, th)) == null) {
            if (a(str)) {
                return Log.e(f4720a, b(str2), th);
            }
            return -1;
        }
        return invokeLLL.intValue;
    }

    public static int f(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, str, str2)) == null) {
            if (a(str)) {
                return Log.i(f4720a, b(str2));
            }
            return -1;
        }
        return invokeLL.intValue;
    }

    public static int g(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, str, str2)) == null) {
            if (a(str)) {
                return Log.w(f4720a, b(str2));
            }
            return -1;
        }
        return invokeLL.intValue;
    }
}
