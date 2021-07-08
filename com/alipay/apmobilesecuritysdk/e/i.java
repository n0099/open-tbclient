package com.alipay.apmobilesecuritysdk.e;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
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

    /* renamed from: a  reason: collision with root package name */
    public static String f1718a = "";

    /* renamed from: b  reason: collision with root package name */
    public static String f1719b = "";

    /* renamed from: c  reason: collision with root package name */
    public static String f1720c = "";

    /* renamed from: d  reason: collision with root package name */
    public static String f1721d = "";

    /* renamed from: e  reason: collision with root package name */
    public static String f1722e = "";

    /* renamed from: f  reason: collision with root package name */
    public static Map<String, String> f1723f;
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
        f1723f = new HashMap();
    }

    public static synchronized String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            synchronized (i.class) {
                String str2 = "apdidTokenCache" + str;
                if (f1723f.containsKey(str2)) {
                    String str3 = f1723f.get(str2);
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
                    f1718a = bVar.f1704a;
                    f1719b = bVar.f1705b;
                    f1720c = bVar.f1706c;
                }
            }
        }
    }

    public static synchronized void a(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, cVar) == null) {
            synchronized (i.class) {
                if (cVar != null) {
                    f1718a = cVar.f1707a;
                    f1719b = cVar.f1708b;
                    f1721d = cVar.f1710d;
                    f1722e = cVar.f1711e;
                    f1720c = cVar.f1709c;
                }
            }
        }
    }

    public static synchronized void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, str, str2) == null) {
            synchronized (i.class) {
                String str3 = "apdidTokenCache" + str;
                if (f1723f.containsKey(str3)) {
                    f1723f.remove(str3);
                }
                f1723f.put(str3, str2);
            }
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[MOVE_EXCEPTION, INVOKE, MOVE_EXCEPTION] complete} */
    public static synchronized boolean a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, context, str)) == null) {
            synchronized (i.class) {
                long j = 86400000;
                try {
                    long a2 = h.a(context);
                    if (a2 >= 0) {
                        j = a2;
                    }
                } catch (Throwable unused) {
                }
                try {
                    if (Math.abs(System.currentTimeMillis() - h.h(context, str)) < j) {
                        return true;
                    }
                } finally {
                    return false;
                }
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public static synchronized String b() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            synchronized (i.class) {
                str = f1718a;
            }
            return str;
        }
        return (String) invokeV.objValue;
    }

    public static void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, str) == null) {
            f1718a = str;
        }
    }

    public static synchronized String c() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            synchronized (i.class) {
                str = f1719b;
            }
            return str;
        }
        return (String) invokeV.objValue;
    }

    public static void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, str) == null) {
            f1719b = str;
        }
    }

    public static synchronized String d() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            synchronized (i.class) {
                str = f1721d;
            }
            return str;
        }
        return (String) invokeV.objValue;
    }

    public static void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, null, str) == null) {
            f1720c = str;
        }
    }

    public static synchronized String e() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) {
            synchronized (i.class) {
                str = f1722e;
            }
            return str;
        }
        return (String) invokeV.objValue;
    }

    public static void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65550, null, str) == null) {
            f1721d = str;
        }
    }

    public static synchronized String f() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) {
            synchronized (i.class) {
                str = f1720c;
            }
            return str;
        }
        return (String) invokeV.objValue;
    }

    public static void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, null, str) == null) {
            f1722e = str;
        }
    }

    public static synchronized c g() {
        InterceptResult invokeV;
        c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65553, null)) == null) {
            synchronized (i.class) {
                cVar = new c(f1718a, f1719b, f1720c, f1721d, f1722e);
            }
            return cVar;
        }
        return (c) invokeV.objValue;
    }

    public static void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65554, null) == null) {
            f1723f.clear();
            f1718a = "";
            f1719b = "";
            f1721d = "";
            f1722e = "";
            f1720c = "";
        }
    }
}
