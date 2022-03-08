package c.a.p0.a.d2;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.v0.e.b;
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
    public static volatile boolean f4875b;

    /* renamed from: c  reason: collision with root package name */
    public static volatile boolean f4876c;

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f4877d;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(815372732, "Lc/a/p0/a/d2/i;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(815372732, "Lc/a/p0/a/d2/i;");
                return;
            }
        }
        a = c.a.p0.a.a.a;
        f4875b = false;
        f4876c = false;
        c.a.p0.a.s0.a.g0().getSwitch("swan_app_use_route_statistic", false);
        f4877d = false;
    }

    public static boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (a) {
                String str = "mIsStartByApi = " + f4876c;
            }
            boolean z = f4876c;
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
                String str = "mIsStartFirstPage = " + f4875b;
            }
            boolean z = f4875b;
            l(false);
            return z;
        }
        return invokeV.booleanValue;
    }

    public static boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? f4875b : invokeV.booleanValue;
    }

    public static void d(c.a.p0.a.c1.b bVar, String str, c.a.p0.a.f.e.j.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, bVar, str, dVar) == null) {
            e(bVar, str, dVar, null);
        }
    }

    public static void e(c.a.p0.a.c1.b bVar, String str, c.a.p0.a.f.e.j.d dVar, String str2) {
        c.a.p0.a.t1.e a0;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(65541, null, bVar, str, dVar, str2) == null) && f4877d && (a0 = c.a.p0.a.t1.e.a0()) != null) {
            b.a V = a0.V();
            c.a.p0.a.d2.s.f fVar = new c.a.p0.a.d2.s.f();
            fVar.a = n.n(V.G());
            fVar.f4951f = V.H();
            if (c.a.p0.a.u.f.e.e.d()) {
                fVar.f4948c = "remote-debug";
            } else if (c.a.p0.a.n1.a.a.D()) {
                fVar.f4948c = "local-debug";
            } else {
                fVar.f4948c = V.T();
            }
            fVar.f4947b = "pageshow";
            if (!TextUtils.isEmpty(str)) {
                fVar.f4950e = str;
            }
            if (bVar != null) {
                fVar.a("path", bVar.f4642e);
                fVar.a("routeType", bVar.f4646i);
                fVar.a("routeid", bVar.f4647j);
            }
            if (!TextUtils.isEmpty(str2)) {
                fVar.a("errcode", str2);
            }
            if (dVar != null && dVar.f5130c > 0) {
                fVar.a("valuetype", dVar.f5134g);
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

    public static c.a.p0.a.c1.b f(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65542, null, str, i2)) == null) {
            c.a.p0.a.x.g.g V = c.a.p0.a.w0.f.U().V();
            c.a.p0.a.c1.b bVar = null;
            if (V == null) {
                return null;
            }
            c.a.p0.a.x.g.d j2 = V.j((V.k() - i2) - 1);
            if (j2 instanceof c.a.p0.a.x.g.f) {
                bVar = ((c.a.p0.a.x.g.f) j2).g3();
                bVar.f4646i = "1";
                bVar.f4647j = str;
            }
            g(bVar);
            return bVar;
        }
        return (c.a.p0.a.c1.b) invokeLI.objValue;
    }

    public static void g(c.a.p0.a.c1.b bVar) {
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

    public static void h(c.a.p0.a.c1.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, bVar) == null) {
            boolean z = a;
            d(bVar, null, null);
        }
    }

    public static void i(c.a.p0.a.c1.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, bVar) == null) {
            j(bVar, null);
        }
    }

    public static void j(c.a.p0.a.c1.b bVar, c.a.p0.a.k2.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65546, null, bVar, aVar) == null) {
            if (a) {
                String str = "recordRouteFailByApi - pageParam=" + bVar + " errCode=" + aVar;
            }
            if (f4876c) {
                if (aVar == null) {
                    aVar = new c.a.p0.a.k2.a();
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
                f4876c = z;
            }
        }
    }

    public static synchronized void l(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65548, null, z) == null) {
            synchronized (i.class) {
                f4875b = z;
            }
        }
    }
}
