package c.a.n0.a.j2;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.n0.a.f1.e.b;
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
    public static final boolean f6726a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile boolean f6727b;

    /* renamed from: c  reason: collision with root package name */
    public static volatile boolean f6728c;

    /* renamed from: d  reason: collision with root package name */
    public static volatile String f6729d;

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f6730e;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1213940837, "Lc/a/n0/a/j2/h;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1213940837, "Lc/a/n0/a/j2/h;");
                return;
            }
        }
        f6726a = c.a.n0.a.k.f6803a;
        f6727b = false;
        f6728c = false;
        c.a.n0.a.c1.a.Z().getSwitch("swan_app_use_route_statistic", false);
        f6730e = false;
    }

    public static boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f6726a) {
                String str = "mIsStartByApi = " + f6728c;
            }
            boolean z = f6728c;
            h(false);
            return z;
        }
        return invokeV.booleanValue;
    }

    public static boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f6726a) {
                String str = "mIsStartFirstPage = " + f6727b;
            }
            boolean z = f6727b;
            i(false);
            return z;
        }
        return invokeV.booleanValue;
    }

    public static String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? f6729d : (String) invokeV.objValue;
    }

    public static boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? f6727b : invokeV.booleanValue;
    }

    public static void e(String str, String str2, c.a.n0.a.p.e.j.d dVar, String str3) {
        c.a.n0.a.a2.e Q;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(AdIconUtil.AD_TEXT_ID, null, str, str2, dVar, str3) == null) && f6730e && (Q = c.a.n0.a.a2.e.Q()) != null) {
            b.a L = Q.L();
            c.a.n0.a.j2.p.f fVar = new c.a.n0.a.j2.p.f();
            fVar.f6789a = k.m(L.G());
            fVar.f6794f = L.H();
            if (c.a.n0.a.e0.f.e.e.d()) {
                fVar.f6791c = "remote-debug";
            } else if (c.a.n0.a.u1.a.a.C()) {
                fVar.f6791c = "local-debug";
            } else {
                fVar.f6791c = L.T();
            }
            fVar.f6790b = "pageshow";
            if (!TextUtils.isEmpty(str2)) {
                fVar.f6793e = str2;
            }
            fVar.a("path", str);
            fVar.a("routeType", str3);
            if (dVar != null && dVar.f7619c > 0) {
                fVar.a("valuetype", dVar.f7623g);
            }
            Bundle P = L.P();
            if (P != null) {
                fVar.d(P.getString(UBCCloudControlProcessor.UBC_KEY));
            }
            fVar.b(k.k(L.W()));
            if (f6726a) {
                String str4 = "onRouteEvent - " + fVar.f();
            }
            k.onEvent(fVar);
        }
    }

    public static void f(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, str, str2) == null) {
            boolean z = f6726a;
            if (d()) {
                return;
            }
            h(true);
            f6729d = str2;
            e(str, null, null, str2);
        }
    }

    public static void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, str) == null) {
            boolean z = f6726a;
            f6729d = "6";
            e(str, null, null, f6729d);
        }
    }

    public static synchronized void h(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65544, null, z) == null) {
            synchronized (h.class) {
                f6728c = z;
            }
        }
    }

    public static synchronized void i(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65545, null, z) == null) {
            synchronized (h.class) {
                f6727b = z;
            }
        }
    }
}
