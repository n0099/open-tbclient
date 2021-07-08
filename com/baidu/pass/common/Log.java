package com.baidu.pass.common;

import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class Log implements com.baidu.pass.a {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "PASSPORT";
    public static boolean enabled;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-2040319669, "Lcom/baidu/pass/common/Log;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-2040319669, "Lcom/baidu/pass/common/Log;");
        }
    }

    public Log() {
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

    public static String a(String str, Object[] objArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, objArr)) == null) {
            if (objArr != null) {
                try {
                    if (objArr.length == 0) {
                        return "";
                    }
                    StringBuffer stringBuffer = new StringBuffer();
                    int length = objArr.length;
                    for (int i2 = 0; i2 < length; i2++) {
                        Object obj = objArr[i2];
                        if (obj != null) {
                            if (i2 != 0) {
                                stringBuffer.append("|");
                            }
                            try {
                                if (obj instanceof Throwable) {
                                    stringBuffer.append(android.util.Log.getStackTraceString((Throwable) obj));
                                } else {
                                    stringBuffer.append(obj.toString());
                                }
                            } catch (Exception unused) {
                            }
                        }
                    }
                    return stringBuffer.toString();
                } catch (Throwable th) {
                    android.util.Log.e(str, "converArrayToString t: " + th.toString());
                    return "converArrayToString null";
                }
            }
            return "";
        }
        return (String) invokeLL.objValue;
    }

    public static void d(String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65539, null, str, objArr) == null) && enabled) {
            android.util.Log.d(str, a(str, objArr));
        }
    }

    public static void e(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, th) == null) {
            e(TAG, th);
        }
    }

    public static void enable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65544, null, z) == null) {
            enabled = z;
        }
    }

    public static void i(String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65545, null, str, objArr) == null) && enabled) {
            android.util.Log.i(str, a(str, objArr));
        }
    }

    public static void w(String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65547, null, str, objArr) == null) && enabled) {
            android.util.Log.w(str, a(str, objArr));
        }
    }

    public static void e(String str, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, str, th) == null) {
            e(str, th);
        }
    }

    public static void d(Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, objArr) == null) {
            d(TAG, objArr);
        }
    }

    public static void e(String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, str, objArr) == null) && enabled) {
            android.util.Log.e(str, a(str, objArr));
        }
    }

    public static void i(Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, objArr) == null) {
            i(TAG, objArr);
        }
    }

    public static void w(Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, null, objArr) == null) {
            w(TAG, objArr);
        }
    }
}
