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
/* loaded from: classes4.dex */
public final class i {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static String f35825a = "";

    /* renamed from: b  reason: collision with root package name */
    public static String f35826b = "";

    /* renamed from: c  reason: collision with root package name */
    public static String f35827c = "";

    /* renamed from: d  reason: collision with root package name */
    public static String f35828d = "";

    /* renamed from: e  reason: collision with root package name */
    public static String f35829e = "";

    /* renamed from: f  reason: collision with root package name */
    public static Map<String, String> f35830f;
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
        f35830f = new HashMap();
    }

    public static synchronized String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            synchronized (i.class) {
                String str2 = "apdidTokenCache" + str;
                if (f35830f.containsKey(str2)) {
                    String str3 = f35830f.get(str2);
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
                    f35825a = bVar.f35811a;
                    f35826b = bVar.f35812b;
                    f35827c = bVar.f35813c;
                }
            }
        }
    }

    public static synchronized void a(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, cVar) == null) {
            synchronized (i.class) {
                if (cVar != null) {
                    f35825a = cVar.f35814a;
                    f35826b = cVar.f35815b;
                    f35828d = cVar.f35817d;
                    f35829e = cVar.f35818e;
                    f35827c = cVar.f35816c;
                }
            }
        }
    }

    public static synchronized void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, str, str2) == null) {
            synchronized (i.class) {
                String str3 = "apdidTokenCache" + str;
                if (f35830f.containsKey(str3)) {
                    f35830f.remove(str3);
                }
                f35830f.put(str3, str2);
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
        long j2;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, context, str)) == null) {
            synchronized (i.class) {
                try {
                    j2 = h.a(context);
                } catch (Throwable unused) {
                }
            }
            return z;
        }
        return invokeLL.booleanValue;
        j2 = 86400000;
        try {
        } catch (Throwable th) {
            com.alipay.apmobilesecuritysdk.c.a.a(th);
        }
        if (Math.abs(System.currentTimeMillis() - h.h(context, str)) < j2) {
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
                str = f35825a;
            }
            return str;
        }
        return (String) invokeV.objValue;
    }

    public static void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, str) == null) {
            f35825a = str;
        }
    }

    public static synchronized String c() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            synchronized (i.class) {
                str = f35826b;
            }
            return str;
        }
        return (String) invokeV.objValue;
    }

    public static void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, str) == null) {
            f35826b = str;
        }
    }

    public static synchronized String d() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            synchronized (i.class) {
                str = f35828d;
            }
            return str;
        }
        return (String) invokeV.objValue;
    }

    public static void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, null, str) == null) {
            f35827c = str;
        }
    }

    public static synchronized String e() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) {
            synchronized (i.class) {
                str = f35829e;
            }
            return str;
        }
        return (String) invokeV.objValue;
    }

    public static void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65550, null, str) == null) {
            f35828d = str;
        }
    }

    public static synchronized String f() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) {
            synchronized (i.class) {
                str = f35827c;
            }
            return str;
        }
        return (String) invokeV.objValue;
    }

    public static void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, null, str) == null) {
            f35829e = str;
        }
    }

    public static synchronized c g() {
        InterceptResult invokeV;
        c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65553, null)) == null) {
            synchronized (i.class) {
                cVar = new c(f35825a, f35826b, f35827c, f35828d, f35829e);
            }
            return cVar;
        }
        return (c) invokeV.objValue;
    }

    public static void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65554, null) == null) {
            f35830f.clear();
            f35825a = "";
            f35826b = "";
            f35828d = "";
            f35829e = "";
            f35827c = "";
        }
    }
}
