package b.a.p0.a.j2;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.f1.e.b;
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
    public static final boolean f6323a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile boolean f6324b;

    /* renamed from: c  reason: collision with root package name */
    public static volatile boolean f6325c;

    /* renamed from: d  reason: collision with root package name */
    public static volatile String f6326d;

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f6327e;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1326472452, "Lb/a/p0/a/j2/h;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1326472452, "Lb/a/p0/a/j2/h;");
                return;
            }
        }
        f6323a = b.a.p0.a.k.f6397a;
        f6324b = false;
        f6325c = false;
        b.a.p0.a.c1.a.Z().getSwitch("swan_app_use_route_statistic", false);
        f6327e = false;
    }

    public static boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f6323a) {
                String str = "mIsStartByApi = " + f6325c;
            }
            boolean z = f6325c;
            h(false);
            return z;
        }
        return invokeV.booleanValue;
    }

    public static boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f6323a) {
                String str = "mIsStartFirstPage = " + f6324b;
            }
            boolean z = f6324b;
            i(false);
            return z;
        }
        return invokeV.booleanValue;
    }

    public static String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? f6326d : (String) invokeV.objValue;
    }

    public static boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? f6324b : invokeV.booleanValue;
    }

    public static void e(String str, String str2, b.a.p0.a.p.e.j.d dVar, String str3) {
        b.a.p0.a.a2.e P;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(AdIconUtil.AD_TEXT_ID, null, str, str2, dVar, str3) == null) && f6327e && (P = b.a.p0.a.a2.e.P()) != null) {
            b.a K = P.K();
            b.a.p0.a.j2.p.f fVar = new b.a.p0.a.j2.p.f();
            fVar.f6383a = k.m(K.F());
            fVar.f6388f = K.G();
            if (b.a.p0.a.e0.f.e.e.d()) {
                fVar.f6385c = "remote-debug";
            } else if (b.a.p0.a.u1.a.a.C()) {
                fVar.f6385c = "local-debug";
            } else {
                fVar.f6385c = K.S();
            }
            fVar.f6384b = "pageshow";
            if (!TextUtils.isEmpty(str2)) {
                fVar.f6387e = str2;
            }
            fVar.a("path", str);
            fVar.a("routeType", str3);
            if (dVar != null && dVar.f7194c > 0) {
                fVar.a("valuetype", dVar.f7198g);
            }
            Bundle O = K.O();
            if (O != null) {
                fVar.d(O.getString(UBCCloudControlProcessor.UBC_KEY));
            }
            fVar.b(k.k(K.V()));
            if (f6323a) {
                String str4 = "onRouteEvent - " + fVar.f();
            }
            k.onEvent(fVar);
        }
    }

    public static void f(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, str, str2) == null) {
            boolean z = f6323a;
            if (d()) {
                return;
            }
            h(true);
            f6326d = str2;
            e(str, null, null, str2);
        }
    }

    public static void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, str) == null) {
            boolean z = f6323a;
            f6326d = "6";
            e(str, null, null, f6326d);
        }
    }

    public static synchronized void h(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65544, null, z) == null) {
            synchronized (h.class) {
                f6325c = z;
            }
        }
    }

    public static synchronized void i(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65545, null, z) == null) {
            synchronized (h.class) {
                f6324b = z;
            }
        }
    }
}
