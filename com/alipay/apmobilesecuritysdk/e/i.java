package com.alipay.apmobilesecuritysdk.e;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public final class i {
    public static /* synthetic */ Interceptable $ic = null;
    public static String a = "";
    public static String b = "";
    public static String c = "";
    public static String d = "";
    public static String e = "";
    public static Map<String, String> f;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1454246355, "Lcom/alipay/apmobilesecuritysdk/e/i;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1454246355, "Lcom/alipay/apmobilesecuritysdk/e/i;");
                return;
            }
        }
        f = new HashMap();
    }

    public static synchronized String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            synchronized (i.class) {
                String str2 = "apdidTokenCache" + str;
                if (f.containsKey(str2)) {
                    String str3 = f.get(str2);
                    if (com.alipay.security.mobile.module.a.a.b(str3)) {
                        return str3;
                    }
                }
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static synchronized void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, null) == null) {
            synchronized (i.class) {
            }
        }
    }

    public static synchronized void a(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, bVar) == null) {
            synchronized (i.class) {
                if (bVar != null) {
                    a = bVar.a;
                    b = bVar.b;
                    c = bVar.c;
                }
            }
        }
    }

    public static synchronized void a(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, cVar) == null) {
            synchronized (i.class) {
                if (cVar != null) {
                    a = cVar.a;
                    b = cVar.b;
                    d = cVar.d;
                    e = cVar.e;
                    c = cVar.c;
                }
            }
        }
    }

    public static synchronized void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, str, str2) == null) {
            synchronized (i.class) {
                String str3 = "apdidTokenCache" + str;
                if (f.containsKey(str3)) {
                    f.remove(str3);
                }
                f.put(str3, str2);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x000f, code lost:
        if (r1 < 0) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized boolean a(Context context, String str) {
        InterceptResult invokeLL;
        long j;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, context, str)) == null) {
            synchronized (i.class) {
                try {
                    j = h.a(context);
                } catch (Throwable unused) {
                }
            }
            return z;
        }
        return invokeLL.booleanValue;
        j = 86400000;
        try {
        } catch (Throwable th) {
            com.alipay.apmobilesecuritysdk.c.a.a(th);
        }
        if (Math.abs(System.currentTimeMillis() - h.h(context, str)) < j) {
            z = true;
            return z;
        }
        z = false;
        return z;
        z = false;
        return z;
    }

    public static synchronized String b() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            synchronized (i.class) {
                str = a;
            }
            return str;
        }
        return (String) invokeV.objValue;
    }

    public static void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, str) == null) {
            a = str;
        }
    }

    public static synchronized String c() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            synchronized (i.class) {
                str = b;
            }
            return str;
        }
        return (String) invokeV.objValue;
    }

    public static void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, str) == null) {
            b = str;
        }
    }

    public static synchronized String d() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            synchronized (i.class) {
                str = d;
            }
            return str;
        }
        return (String) invokeV.objValue;
    }

    public static void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, null, str) == null) {
            c = str;
        }
    }

    public static synchronized String e() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) {
            synchronized (i.class) {
                str = e;
            }
            return str;
        }
        return (String) invokeV.objValue;
    }

    public static void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65550, null, str) == null) {
            d = str;
        }
    }

    public static synchronized String f() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) {
            synchronized (i.class) {
                str = c;
            }
            return str;
        }
        return (String) invokeV.objValue;
    }

    public static void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, null, str) == null) {
            e = str;
        }
    }

    public static synchronized c g() {
        InterceptResult invokeV;
        c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65553, null)) == null) {
            synchronized (i.class) {
                cVar = new c(a, b, c, d, e);
            }
            return cVar;
        }
        return (c) invokeV.objValue;
    }

    public static void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65554, null) == null) {
            f.clear();
            a = "";
            b = "";
            d = "";
            e = "";
            c = "";
        }
    }
}
