package b.a.p0.a.n2;

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
public class i {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f7303a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile boolean f7304b;

    /* renamed from: c  reason: collision with root package name */
    public static volatile boolean f7305c;

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f7306d;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1330166567, "Lb/a/p0/a/n2/i;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1330166567, "Lb/a/p0/a/n2/i;");
                return;
            }
        }
        f7303a = b.a.p0.a.k.f6863a;
        f7304b = false;
        f7305c = false;
        b.a.p0.a.c1.a.g0().getSwitch("swan_app_use_route_statistic", false);
        f7306d = false;
    }

    public static boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f7303a) {
                String str = "mIsStartByApi = " + f7305c;
            }
            boolean z = f7305c;
            k(false);
            return z;
        }
        return invokeV.booleanValue;
    }

    public static boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f7303a) {
                String str = "mIsStartFirstPage = " + f7304b;
            }
            boolean z = f7304b;
            l(false);
            return z;
        }
        return invokeV.booleanValue;
    }

    public static boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? f7304b : invokeV.booleanValue;
    }

    public static void d(b.a.p0.a.m1.b bVar, String str, b.a.p0.a.p.e.j.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, bVar, str, dVar) == null) {
            e(bVar, str, dVar, null);
        }
    }

    public static void e(b.a.p0.a.m1.b bVar, String str, b.a.p0.a.p.e.j.d dVar, String str2) {
        b.a.p0.a.d2.e a0;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(AdIconUtil.AD_TEXT_ID, null, bVar, str, dVar, str2) == null) && f7306d && (a0 = b.a.p0.a.d2.e.a0()) != null) {
            b.a V = a0.V();
            b.a.p0.a.n2.s.f fVar = new b.a.p0.a.n2.s.f();
            fVar.f7379a = n.n(V.G());
            fVar.f7384f = V.H();
            if (b.a.p0.a.e0.f.e.e.d()) {
                fVar.f7381c = "remote-debug";
            } else if (b.a.p0.a.x1.a.a.D()) {
                fVar.f7381c = "local-debug";
            } else {
                fVar.f7381c = V.T();
            }
            fVar.f7380b = "pageshow";
            if (!TextUtils.isEmpty(str)) {
                fVar.f7383e = str;
            }
            if (bVar != null) {
                fVar.a("path", bVar.f7014e);
                fVar.a("routeType", bVar.f7018i);
                fVar.a("routeid", bVar.j);
            }
            if (!TextUtils.isEmpty(str2)) {
                fVar.a("errcode", str2);
            }
            if (dVar != null && dVar.f7609c > 0) {
                fVar.a("valuetype", dVar.f7613g);
            }
            Bundle P = V.P();
            if (P != null) {
                fVar.d(P.getString(UBCCloudControlProcessor.UBC_KEY));
            }
            fVar.b(n.k(V.W()));
            if (f7303a) {
                String str3 = "onRouteEvent - " + fVar.f();
            }
            n.onEvent(fVar);
        }
    }

    public static b.a.p0.a.m1.b f(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(AdIconUtil.BAIDU_LOGO_ID, null, str, i2)) == null) {
            b.a.p0.a.h0.g.g V = b.a.p0.a.g1.f.U().V();
            b.a.p0.a.m1.b bVar = null;
            if (V == null) {
                return null;
            }
            b.a.p0.a.h0.g.d j = V.j((V.k() - i2) - 1);
            if (j instanceof b.a.p0.a.h0.g.f) {
                bVar = ((b.a.p0.a.h0.g.f) j).j3();
                bVar.f7018i = "1";
                bVar.j = str;
            }
            g(bVar);
            return bVar;
        }
        return (b.a.p0.a.m1.b) invokeLI.objValue;
    }

    public static void g(b.a.p0.a.m1.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, bVar) == null) {
            boolean z = f7303a;
            if (c()) {
                return;
            }
            k(true);
            d(bVar, null, null);
        }
    }

    public static void h(b.a.p0.a.m1.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, bVar) == null) {
            boolean z = f7303a;
            d(bVar, null, null);
        }
    }

    public static void i(b.a.p0.a.m1.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, bVar) == null) {
            j(bVar, null);
        }
    }

    public static void j(b.a.p0.a.m1.b bVar, b.a.p0.a.u2.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65546, null, bVar, aVar) == null) {
            if (f7303a) {
                String str = "recordRouteFailByApi - pageParam=" + bVar + " errCode=" + aVar;
            }
            if (f7305c) {
                if (aVar == null) {
                    aVar = new b.a.p0.a.u2.a();
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
                f7305c = z;
            }
        }
    }

    public static synchronized void l(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65548, null, z) == null) {
            synchronized (i.class) {
                f7304b = z;
            }
        }
    }
}
