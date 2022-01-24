package c.a.r0.a.n2;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.a.f1.e.b;
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
    public static volatile boolean f8047b;

    /* renamed from: c  reason: collision with root package name */
    public static volatile boolean f8048c;

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f8049d;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(431580932, "Lc/a/r0/a/n2/i;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(431580932, "Lc/a/r0/a/n2/i;");
                return;
            }
        }
        a = c.a.r0.a.k.a;
        f8047b = false;
        f8048c = false;
        c.a.r0.a.c1.a.g0().getSwitch("swan_app_use_route_statistic", false);
        f8049d = false;
    }

    public static boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (a) {
                String str = "mIsStartByApi = " + f8048c;
            }
            boolean z = f8048c;
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
                String str = "mIsStartFirstPage = " + f8047b;
            }
            boolean z = f8047b;
            l(false);
            return z;
        }
        return invokeV.booleanValue;
    }

    public static boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? f8047b : invokeV.booleanValue;
    }

    public static void d(c.a.r0.a.m1.b bVar, String str, c.a.r0.a.p.e.j.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, bVar, str, dVar) == null) {
            e(bVar, str, dVar, null);
        }
    }

    public static void e(c.a.r0.a.m1.b bVar, String str, c.a.r0.a.p.e.j.d dVar, String str2) {
        c.a.r0.a.d2.e a0;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(65541, null, bVar, str, dVar, str2) == null) && f8049d && (a0 = c.a.r0.a.d2.e.a0()) != null) {
            b.a V = a0.V();
            c.a.r0.a.n2.s.f fVar = new c.a.r0.a.n2.s.f();
            fVar.a = n.n(V.G());
            fVar.f8123f = V.H();
            if (c.a.r0.a.e0.f.e.e.d()) {
                fVar.f8120c = "remote-debug";
            } else if (c.a.r0.a.x1.a.a.D()) {
                fVar.f8120c = "local-debug";
            } else {
                fVar.f8120c = V.T();
            }
            fVar.f8119b = "pageshow";
            if (!TextUtils.isEmpty(str)) {
                fVar.f8122e = str;
            }
            if (bVar != null) {
                fVar.a("path", bVar.f7814e);
                fVar.a("routeType", bVar.f7818i);
                fVar.a("routeid", bVar.f7819j);
            }
            if (!TextUtils.isEmpty(str2)) {
                fVar.a("errcode", str2);
            }
            if (dVar != null && dVar.f8302c > 0) {
                fVar.a("valuetype", dVar.f8306g);
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

    public static c.a.r0.a.m1.b f(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65542, null, str, i2)) == null) {
            c.a.r0.a.h0.g.g V = c.a.r0.a.g1.f.U().V();
            c.a.r0.a.m1.b bVar = null;
            if (V == null) {
                return null;
            }
            c.a.r0.a.h0.g.d j2 = V.j((V.k() - i2) - 1);
            if (j2 instanceof c.a.r0.a.h0.g.f) {
                bVar = ((c.a.r0.a.h0.g.f) j2).g3();
                bVar.f7818i = "1";
                bVar.f7819j = str;
            }
            g(bVar);
            return bVar;
        }
        return (c.a.r0.a.m1.b) invokeLI.objValue;
    }

    public static void g(c.a.r0.a.m1.b bVar) {
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

    public static void h(c.a.r0.a.m1.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, bVar) == null) {
            boolean z = a;
            d(bVar, null, null);
        }
    }

    public static void i(c.a.r0.a.m1.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, bVar) == null) {
            j(bVar, null);
        }
    }

    public static void j(c.a.r0.a.m1.b bVar, c.a.r0.a.u2.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65546, null, bVar, aVar) == null) {
            if (a) {
                String str = "recordRouteFailByApi - pageParam=" + bVar + " errCode=" + aVar;
            }
            if (f8048c) {
                if (aVar == null) {
                    aVar = new c.a.r0.a.u2.a();
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
                f8048c = z;
            }
        }
    }

    public static synchronized void l(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65548, null, z) == null) {
            synchronized (i.class) {
                f8047b = z;
            }
        }
    }
}
