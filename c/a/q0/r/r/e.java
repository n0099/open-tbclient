package c.a.q0.r.r;

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

    /* renamed from: j  reason: collision with root package name */
    public static final Set<String> f13235j;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public int f13236b;

    /* renamed from: c  reason: collision with root package name */
    public String f13237c;

    /* renamed from: d  reason: collision with root package name */
    public String f13238d;

    /* renamed from: e  reason: collision with root package name */
    public String f13239e;

    /* renamed from: f  reason: collision with root package name */
    public String f13240f;

    /* renamed from: g  reason: collision with root package name */
    public String f13241g;

    /* renamed from: h  reason: collision with root package name */
    public String f13242h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f13243i;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1615453242, "Lc/a/q0/r/r/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1615453242, "Lc/a/q0/r/r/e;");
                return;
            }
        }
        f13235j = new HashSet();
    }

    public e() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? f13235j.contains(str) : invokeL.booleanValue;
    }

    public static void b(AdvertAppInfo advertAppInfo) {
        e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, null, advertAppInfo) == null) || advertAppInfo == null || (eVar = advertAppInfo.p4) == null || eVar.f13243i || a(eVar.f13242h)) {
            return;
        }
        c.a.r0.j3.m0.c b2 = c.a.r0.j3.m0.g.b(advertAppInfo, 3, eVar.f13236b);
        b2.h(eVar.a);
        b2.a("isCache", eVar.f13237c);
        b2.e(eVar.f13239e);
        b2.f(eVar.f13240f);
        b2.g(eVar.f13238d);
        b2.a("vc", eVar.f13241g);
        b2.v(eVar.f13242h);
        c.a.r0.j3.m0.e.b().d(b2);
        c.a.r0.z1.o.h.c.g(c.a.r0.z1.o.h.c.e(advertAppInfo));
        eVar.f13243i = true;
        f13235j.add(eVar.f13242h);
    }

    public static void c(e eVar, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{eVar, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || eVar == null || eVar.f13243i || a(eVar.f13242h)) {
            return;
        }
        c.a.r0.j3.m0.c g2 = c.a.r0.j3.m0.g.g(z ? 13 : 3, i2, eVar.f13236b);
        g2.h(eVar.a);
        g2.a("isCache", String.valueOf(eVar.f13237c));
        g2.e(eVar.f13239e);
        g2.f(eVar.f13240f);
        g2.g(eVar.f13238d);
        g2.a("vc", eVar.f13241g);
        g2.v(eVar.f13242h);
        c.a.r0.j3.m0.e.b().d(g2);
        eVar.f13243i = true;
        f13235j.add(eVar.f13242h);
    }

    public static void d(c.a.r0.f0.d0.d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65541, null, dVar) == null) || dVar == null || dVar.g() == null || dVar.g().p4 == null || dVar.g().p4.f13243i || a(dVar.g().p4.f13242h)) {
            return;
        }
        dVar.g().q4 = dVar.g().p4.a;
        c.a.r0.j3.m0.c c2 = c.a.r0.j3.m0.g.c(dVar.g(), 3, dVar.g().p4.f13236b);
        c2.v(dVar.g().p4.f13242h);
        c.a.r0.j3.m0.e.b().d(c2);
        c.a.r0.z1.o.h.c.g(c.a.r0.z1.o.h.c.e(dVar.g()));
        dVar.g().p4.f13243i = true;
        f13235j.add(dVar.g().p4.f13242h);
    }

    public static void e(e eVar, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65542, null, new Object[]{eVar, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || eVar == null || eVar.f13243i || a(eVar.f13242h)) {
            return;
        }
        c.a.r0.j3.m0.c g2 = c.a.r0.j3.m0.g.g(z ? 13 : 3, i2, eVar.f13236b);
        g2.h(eVar.a);
        g2.v(eVar.f13242h);
        c.a.r0.j3.m0.e.b().d(g2);
        eVar.f13243i = true;
        f13235j.add(eVar.f13242h);
    }

    public static void f(c.a.r0.y3.k0.o oVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65543, null, oVar) == null) || oVar == null || oVar.getAdvertAppInfo() == null) {
            return;
        }
        e eVar = oVar.getAdvertAppInfo().p4;
        if (oVar.R0 || !(eVar == null || eVar.f13243i || a(eVar.f13242h))) {
            oVar.L0 = eVar.f13239e;
            oVar.M0 = eVar.f13240f;
            oVar.K0 = eVar.f13238d;
            int i2 = 3;
            if (oVar != null && oVar.M0() != null && oVar.M0().forFree()) {
                i2 = 103;
            }
            c.a.r0.j3.m0.c e2 = c.a.r0.j3.m0.g.e(oVar, i2);
            e2.v(eVar.f13242h);
            c.a.r0.j3.m0.e.b().d(e2);
            if (!oVar.R0) {
                c.a.r0.z1.o.h.c.g(c.a.r0.z1.o.h.c.e(oVar.getAdvertAppInfo()));
            }
            eVar.f13243i = true;
            f13235j.add(eVar.f13242h);
        }
    }

    public static void g(e eVar, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65544, null, new Object[]{eVar, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || eVar == null || eVar.f13243i || a(eVar.f13242h)) {
            return;
        }
        int i3 = z ? 13 : 3;
        c.a.r0.j3.m0.c cVar = new c.a.r0.j3.m0.c();
        cVar.i(i3);
        if ("PB_BANNER".equals(eVar.a)) {
            cVar.d(-1);
            cVar.x(-1);
        } else {
            cVar.d(i2);
            cVar.x(eVar.f13236b);
        }
        cVar.h(eVar.a);
        cVar.e(eVar.f13239e);
        cVar.f(eVar.f13240f);
        cVar.g(eVar.f13238d);
        cVar.a("vc", eVar.f13241g);
        cVar.v(eVar.f13242h);
        c.a.r0.j3.m0.e.b().d(cVar);
        eVar.f13243i = true;
        f13235j.add(eVar.f13242h);
    }

    public static void h(c.a.e.d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65545, null, dVar) == null) || dVar == null || dVar.i() == null || dVar.f3205i || TextUtils.isEmpty(dVar.i().f3207b) || a(dVar.i().f3207b)) {
            return;
        }
        c.a.r0.j3.m0.e.b().d(c.a.r0.j3.m0.g.a(dVar, 3, dVar.k()));
        c.a.r0.z1.o.h.c.g(dVar);
        dVar.f3205i = true;
        f13235j.add(dVar.i().f3207b);
    }
}
