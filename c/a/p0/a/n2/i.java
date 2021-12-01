package c.a.p0.a.n2;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.f1.e.b;
import com.baidu.searchbox.ubcprocessor.UBCCloudControlProcessor;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes.dex */
public class i {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile boolean f7038b;

    /* renamed from: c  reason: collision with root package name */
    public static volatile boolean f7039c;

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f7040d;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(824607942, "Lc/a/p0/a/n2/i;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(824607942, "Lc/a/p0/a/n2/i;");
                return;
            }
        }
        a = c.a.p0.a.k.a;
        f7038b = false;
        f7039c = false;
        c.a.p0.a.c1.a.g0().getSwitch("swan_app_use_route_statistic", false);
        f7040d = false;
    }

    public static boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (a) {
                String str = "mIsStartByApi = " + f7039c;
            }
            boolean z = f7039c;
            k(false);
            return z;
        }
        return invokeV.booleanValue;
    }

    public static boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (a) {
                String str = "mIsStartFirstPage = " + f7038b;
            }
            boolean z = f7038b;
            l(false);
            return z;
        }
        return invokeV.booleanValue;
    }

    public static boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? f7038b : invokeV.booleanValue;
    }

    public static void d(c.a.p0.a.m1.b bVar, String str, c.a.p0.a.p.e.j.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, bVar, str, dVar) == null) {
            e(bVar, str, dVar, null);
        }
    }

    public static void e(c.a.p0.a.m1.b bVar, String str, c.a.p0.a.p.e.j.d dVar, String str2) {
        c.a.p0.a.d2.e a0;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(65541, null, bVar, str, dVar, str2) == null) && f7040d && (a0 = c.a.p0.a.d2.e.a0()) != null) {
            b.a V = a0.V();
            c.a.p0.a.n2.s.f fVar = new c.a.p0.a.n2.s.f();
            fVar.a = n.n(V.G());
            fVar.f7117f = V.H();
            if (c.a.p0.a.e0.f.e.e.d()) {
                fVar.f7114c = "remote-debug";
            } else if (c.a.p0.a.x1.a.a.D()) {
                fVar.f7114c = "local-debug";
            } else {
                fVar.f7114c = V.T();
            }
            fVar.f7113b = "pageshow";
            if (!TextUtils.isEmpty(str)) {
                fVar.f7116e = str;
            }
            if (bVar != null) {
                fVar.a("path", bVar.f6799e);
                fVar.a("routeType", bVar.f6803i);
                fVar.a("routeid", bVar.f6804j);
            }
            if (!TextUtils.isEmpty(str2)) {
                fVar.a("errcode", str2);
            }
            if (dVar != null && dVar.f7299c > 0) {
                fVar.a("valuetype", dVar.f7303g);
            }
            Bundle P = V.P();
            if (P != null) {
                fVar.d(P.getString(UBCCloudControlProcessor.UBC_KEY));
            }
            fVar.b(n.k(V.W()));
            if (a) {
                String str3 = "onRouteEvent - " + fVar.f();
            }
            n.onEvent(fVar);
        }
    }

    public static c.a.p0.a.m1.b f(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65542, null, str, i2)) == null) {
            c.a.p0.a.h0.g.g V = c.a.p0.a.g1.f.U().V();
            c.a.p0.a.m1.b bVar = null;
            if (V == null) {
                return null;
            }
            c.a.p0.a.h0.g.d j2 = V.j((V.k() - i2) - 1);
            if (j2 instanceof c.a.p0.a.h0.g.f) {
                bVar = ((c.a.p0.a.h0.g.f) j2).n3();
                bVar.f6803i = "1";
                bVar.f6804j = str;
            }
            g(bVar);
            return bVar;
        }
        return (c.a.p0.a.m1.b) invokeLI.objValue;
    }

    public static void g(c.a.p0.a.m1.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, bVar) == null) {
            boolean z = a;
            if (c()) {
                return;
            }
            k(true);
            d(bVar, null, null);
        }
    }

    public static void h(c.a.p0.a.m1.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, bVar) == null) {
            boolean z = a;
            d(bVar, null, null);
        }
    }

    public static void i(c.a.p0.a.m1.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, bVar) == null) {
            j(bVar, null);
        }
    }

    public static void j(c.a.p0.a.m1.b bVar, c.a.p0.a.u2.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65546, null, bVar, aVar) == null) {
            if (a) {
                String str = "recordRouteFailByApi - pageParam=" + bVar + " errCode=" + aVar;
            }
            if (f7039c) {
                if (aVar == null) {
                    aVar = new c.a.p0.a.u2.a();
                    aVar.k(5L);
                    aVar.i(58L);
                    aVar.d("route check fail");
                }
                e(bVar, com.baidu.pass.biometrics.face.liveness.b.a.g0, null, String.valueOf(aVar.a()));
            }
        }
    }

    public static synchronized void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65547, null, z) == null) {
            synchronized (i.class) {
                f7039c = z;
            }
        }
    }

    public static synchronized void l(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65548, null, z) == null) {
            synchronized (i.class) {
                f7038b = z;
            }
        }
    }
}
