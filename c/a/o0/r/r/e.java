package c.a.o0.r.r;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes2.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public static final Set<String> j;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public int f10837b;

    /* renamed from: c  reason: collision with root package name */
    public String f10838c;

    /* renamed from: d  reason: collision with root package name */
    public String f10839d;

    /* renamed from: e  reason: collision with root package name */
    public String f10840e;

    /* renamed from: f  reason: collision with root package name */
    public String f10841f;

    /* renamed from: g  reason: collision with root package name */
    public String f10842g;

    /* renamed from: h  reason: collision with root package name */
    public String f10843h;
    public boolean i;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(935394872, "Lc/a/o0/r/r/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(935394872, "Lc/a/o0/r/r/e;");
                return;
            }
        }
        j = new HashSet();
    }

    public e() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? j.contains(str) : invokeL.booleanValue;
    }

    public static void b(AdvertAppInfo advertAppInfo) {
        e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, null, advertAppInfo) == null) || advertAppInfo == null || (eVar = advertAppInfo.j) == null || eVar.i || a(eVar.f10843h)) {
            return;
        }
        c.a.p0.l3.m0.c b2 = c.a.p0.l3.m0.g.b(advertAppInfo, 3, eVar.f10837b);
        b2.h(eVar.a);
        b2.a("isCache", eVar.f10838c);
        b2.e(eVar.f10840e);
        b2.f(eVar.f10841f);
        b2.g(eVar.f10839d);
        b2.a("vc", eVar.f10842g);
        b2.v(eVar.f10843h);
        c.a.p0.l3.m0.e.b().d(b2);
        c.a.p0.b2.o.h.c.g(c.a.p0.b2.o.h.c.e(advertAppInfo));
        eVar.i = true;
        j.add(eVar.f10843h);
    }

    public static void c(e eVar, int i, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{eVar, Integer.valueOf(i), Boolean.valueOf(z)}) == null) || eVar == null || eVar.i || a(eVar.f10843h)) {
            return;
        }
        c.a.p0.l3.m0.c g2 = c.a.p0.l3.m0.g.g(z ? 13 : 3, i, eVar.f10837b);
        g2.h(eVar.a);
        g2.a("isCache", String.valueOf(eVar.f10838c));
        g2.e(eVar.f10840e);
        g2.f(eVar.f10841f);
        g2.g(eVar.f10839d);
        g2.a("vc", eVar.f10842g);
        g2.v(eVar.f10843h);
        c.a.p0.l3.m0.e.b().d(g2);
        eVar.i = true;
        j.add(eVar.f10843h);
    }

    public static void d(c.a.p0.h0.e0.d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65541, null, dVar) == null) || dVar == null || dVar.e() == null || dVar.e().j == null || dVar.e().j.i || a(dVar.e().j.f10843h)) {
            return;
        }
        dVar.e().k = dVar.e().j.a;
        c.a.p0.l3.m0.c c2 = c.a.p0.l3.m0.g.c(dVar.e(), 3, dVar.e().j.f10837b);
        c2.v(dVar.e().j.f10843h);
        c.a.p0.l3.m0.e.b().d(c2);
        c.a.p0.b2.o.h.c.g(c.a.p0.b2.o.h.c.e(dVar.e()));
        dVar.e().j.i = true;
        j.add(dVar.e().j.f10843h);
    }

    public static void e(e eVar, int i, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65542, null, new Object[]{eVar, Integer.valueOf(i), Boolean.valueOf(z)}) == null) || eVar == null || eVar.i || a(eVar.f10843h)) {
            return;
        }
        c.a.p0.l3.m0.c g2 = c.a.p0.l3.m0.g.g(z ? 13 : 3, i, eVar.f10837b);
        g2.h(eVar.a);
        g2.v(eVar.f10843h);
        c.a.p0.l3.m0.e.b().d(g2);
        eVar.i = true;
        j.add(eVar.f10843h);
    }

    public static void f(c.a.p0.a4.k0.o oVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65543, null, oVar) == null) || oVar == null || oVar.getAdvertAppInfo() == null) {
            return;
        }
        e eVar = oVar.getAdvertAppInfo().j;
        if (oVar.N0 || !(eVar == null || eVar.i || a(eVar.f10843h))) {
            oVar.H0 = eVar.f10840e;
            oVar.I0 = eVar.f10841f;
            oVar.G0 = eVar.f10839d;
            int i = 3;
            if (oVar != null && oVar.M0() != null && oVar.M0().forFree()) {
                i = 103;
            }
            c.a.p0.l3.m0.c e2 = c.a.p0.l3.m0.g.e(oVar, i);
            e2.v(eVar.f10843h);
            c.a.p0.l3.m0.e.b().d(e2);
            if (!oVar.N0) {
                c.a.p0.b2.o.h.c.g(c.a.p0.b2.o.h.c.e(oVar.getAdvertAppInfo()));
            }
            eVar.i = true;
            j.add(eVar.f10843h);
        }
    }

    public static void g(e eVar, int i, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65544, null, new Object[]{eVar, Integer.valueOf(i), Boolean.valueOf(z)}) == null) || eVar == null || eVar.i || a(eVar.f10843h)) {
            return;
        }
        int i2 = z ? 13 : 3;
        c.a.p0.l3.m0.c cVar = new c.a.p0.l3.m0.c();
        cVar.i(i2);
        if ("PB_BANNER".equals(eVar.a)) {
            cVar.d(-1);
            cVar.x(-1);
        } else {
            cVar.d(i);
            cVar.x(eVar.f10837b);
        }
        cVar.h(eVar.a);
        cVar.e(eVar.f10840e);
        cVar.f(eVar.f10841f);
        cVar.g(eVar.f10839d);
        cVar.a("vc", eVar.f10842g);
        cVar.v(eVar.f10843h);
        c.a.p0.l3.m0.e.b().d(cVar);
        eVar.i = true;
        j.add(eVar.f10843h);
    }

    public static void h(c.a.e.d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65545, null, dVar) == null) || dVar == null || dVar.g() == null || dVar.f2671e || TextUtils.isEmpty(dVar.g().f2674b) || a(dVar.g().f2674b)) {
            return;
        }
        c.a.p0.l3.m0.e.b().d(c.a.p0.l3.m0.g.a(dVar, 3, dVar.i()));
        c.a.p0.b2.o.h.c.g(dVar);
        dVar.f2671e = true;
        j.add(dVar.g().f2674b);
    }
}
