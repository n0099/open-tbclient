package c.a.p0.a.j2;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.f1.e.b;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.ubcprocessor.UBCCloudControlProcessor;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f7000a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile boolean f7001b;

    /* renamed from: c  reason: collision with root package name */
    public static volatile boolean f7002c;

    /* renamed from: d  reason: collision with root package name */
    public static volatile String f7003d;

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f7004e;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(820913827, "Lc/a/p0/a/j2/h;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(820913827, "Lc/a/p0/a/j2/h;");
                return;
            }
        }
        f7000a = c.a.p0.a.k.f7077a;
        f7001b = false;
        f7002c = false;
        c.a.p0.a.c1.a.Z().getSwitch("swan_app_use_route_statistic", false);
        f7004e = false;
    }

    public static boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f7000a) {
                String str = "mIsStartByApi = " + f7002c;
            }
            boolean z = f7002c;
            h(false);
            return z;
        }
        return invokeV.booleanValue;
    }

    public static boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f7000a) {
                String str = "mIsStartFirstPage = " + f7001b;
            }
            boolean z = f7001b;
            i(false);
            return z;
        }
        return invokeV.booleanValue;
    }

    public static String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? f7003d : (String) invokeV.objValue;
    }

    public static boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? f7001b : invokeV.booleanValue;
    }

    public static void e(String str, String str2, c.a.p0.a.p.e.j.d dVar, String str3) {
        c.a.p0.a.a2.e Q;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(AdIconUtil.AD_TEXT_ID, null, str, str2, dVar, str3) == null) && f7004e && (Q = c.a.p0.a.a2.e.Q()) != null) {
            b.a L = Q.L();
            c.a.p0.a.j2.p.f fVar = new c.a.p0.a.j2.p.f();
            fVar.f7063a = k.m(L.G());
            fVar.f7068f = L.H();
            if (c.a.p0.a.e0.f.e.e.d()) {
                fVar.f7065c = "remote-debug";
            } else if (c.a.p0.a.u1.a.a.C()) {
                fVar.f7065c = "local-debug";
            } else {
                fVar.f7065c = L.T();
            }
            fVar.f7064b = "pageshow";
            if (!TextUtils.isEmpty(str2)) {
                fVar.f7067e = str2;
            }
            fVar.a("path", str);
            fVar.a("routeType", str3);
            if (dVar != null && dVar.f7893c > 0) {
                fVar.a("valuetype", dVar.f7897g);
            }
            Bundle P = L.P();
            if (P != null) {
                fVar.d(P.getString(UBCCloudControlProcessor.UBC_KEY));
            }
            fVar.b(k.k(L.W()));
            if (f7000a) {
                String str4 = "onRouteEvent - " + fVar.f();
            }
            k.onEvent(fVar);
        }
    }

    public static void f(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, str, str2) == null) {
            boolean z = f7000a;
            if (d()) {
                return;
            }
            h(true);
            f7003d = str2;
            e(str, null, null, str2);
        }
    }

    public static void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, str) == null) {
            boolean z = f7000a;
            f7003d = "6";
            e(str, null, null, f7003d);
        }
    }

    public static synchronized void h(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65544, null, z) == null) {
            synchronized (h.class) {
                f7002c = z;
            }
        }
    }

    public static synchronized void i(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65545, null, z) == null) {
            synchronized (h.class) {
                f7001b = z;
            }
        }
    }
}
