package b.a.q0.s.q;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
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
/* loaded from: classes4.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public static final Set<String> j;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f13276a;

    /* renamed from: b  reason: collision with root package name */
    public int f13277b;

    /* renamed from: c  reason: collision with root package name */
    public String f13278c;

    /* renamed from: d  reason: collision with root package name */
    public String f13279d;

    /* renamed from: e  reason: collision with root package name */
    public String f13280e;

    /* renamed from: f  reason: collision with root package name */
    public String f13281f;

    /* renamed from: g  reason: collision with root package name */
    public String f13282g;

    /* renamed from: h  reason: collision with root package name */
    public String f13283h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f13284i;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1937455609, "Lb/a/q0/s/q/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1937455609, "Lb/a/q0/s/q/e;");
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
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? j.contains(str) : invokeL.booleanValue;
    }

    public static void b(AdvertAppInfo advertAppInfo) {
        e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, null, advertAppInfo) == null) || advertAppInfo == null || (eVar = advertAppInfo.g4) == null || eVar.f13284i || a(eVar.f13283h)) {
            return;
        }
        b.a.r0.z2.l0.c b2 = b.a.r0.z2.l0.g.b(advertAppInfo, 3, eVar.f13277b);
        b2.h(eVar.f13276a);
        b2.a("isCache", eVar.f13278c);
        b2.e(eVar.f13280e);
        b2.f(eVar.f13281f);
        b2.g(eVar.f13279d);
        b2.a("vc", eVar.f13282g);
        b2.v(eVar.f13283h);
        b.a.r0.z2.l0.e.b().d(b2);
        b.a.r0.q1.o.h.c.g(b.a.r0.q1.o.h.c.e(advertAppInfo));
        eVar.f13284i = true;
        j.add(eVar.f13283h);
    }

    public static void c(e eVar, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{eVar, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || eVar == null || eVar.f13284i || a(eVar.f13283h)) {
            return;
        }
        b.a.r0.z2.l0.c g2 = b.a.r0.z2.l0.g.g(z ? 13 : 3, i2, eVar.f13277b);
        g2.h(eVar.f13276a);
        g2.a("isCache", String.valueOf(eVar.f13278c));
        g2.e(eVar.f13280e);
        g2.f(eVar.f13281f);
        g2.g(eVar.f13279d);
        g2.a("vc", eVar.f13282g);
        g2.v(eVar.f13283h);
        b.a.r0.z2.l0.e.b().d(g2);
        eVar.f13284i = true;
        j.add(eVar.f13283h);
    }

    public static void d(b.a.r0.b0.e0.d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, dVar) == null) || dVar == null || dVar.g() == null || dVar.g().g4 == null || dVar.g().g4.f13284i || a(dVar.g().g4.f13283h)) {
            return;
        }
        dVar.g().h4 = dVar.g().g4.f13276a;
        b.a.r0.z2.l0.c c2 = b.a.r0.z2.l0.g.c(dVar.g(), 3, dVar.g().g4.f13277b);
        c2.v(dVar.g().g4.f13283h);
        b.a.r0.z2.l0.e.b().d(c2);
        b.a.r0.q1.o.h.c.g(b.a.r0.q1.o.h.c.e(dVar.g()));
        dVar.g().g4.f13284i = true;
        j.add(dVar.g().g4.f13283h);
    }

    public static void e(e eVar, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(AdIconUtil.BAIDU_LOGO_ID, null, new Object[]{eVar, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || eVar == null || eVar.f13284i || a(eVar.f13283h)) {
            return;
        }
        b.a.r0.z2.l0.c g2 = b.a.r0.z2.l0.g.g(z ? 13 : 3, i2, eVar.f13277b);
        g2.h(eVar.f13276a);
        g2.v(eVar.f13283h);
        b.a.r0.z2.l0.e.b().d(g2);
        eVar.f13284i = true;
        j.add(eVar.f13283h);
    }

    public static void f(b.a.r0.l3.j0.p pVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65543, null, pVar) == null) || pVar == null || pVar.getAdvertAppInfo() == null) {
            return;
        }
        e eVar = pVar.getAdvertAppInfo().g4;
        if (pVar.P0 || !(eVar == null || eVar.f13284i || a(eVar.f13283h))) {
            pVar.J0 = eVar.f13280e;
            pVar.K0 = eVar.f13281f;
            pVar.I0 = eVar.f13279d;
            int i2 = 3;
            if (pVar != null && pVar.L0() != null && pVar.L0().forFree()) {
                i2 = 103;
            }
            b.a.r0.z2.l0.c e2 = b.a.r0.z2.l0.g.e(pVar, i2);
            e2.v(eVar.f13283h);
            b.a.r0.z2.l0.e.b().d(e2);
            if (!pVar.P0) {
                b.a.r0.q1.o.h.c.g(b.a.r0.q1.o.h.c.e(pVar.getAdvertAppInfo()));
            }
            eVar.f13284i = true;
            j.add(eVar.f13283h);
        }
    }

    public static void g(e eVar, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65544, null, new Object[]{eVar, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || eVar == null || eVar.f13284i || a(eVar.f13283h)) {
            return;
        }
        int i3 = z ? 13 : 3;
        b.a.r0.z2.l0.c cVar = new b.a.r0.z2.l0.c();
        cVar.i(i3);
        if ("PB_BANNER".equals(eVar.f13276a)) {
            cVar.d(-1);
            cVar.x(-1);
        } else {
            cVar.d(i2);
            cVar.x(eVar.f13277b);
        }
        cVar.h(eVar.f13276a);
        cVar.e(eVar.f13280e);
        cVar.f(eVar.f13281f);
        cVar.g(eVar.f13279d);
        cVar.a("vc", eVar.f13282g);
        cVar.v(eVar.f13283h);
        b.a.r0.z2.l0.e.b().d(cVar);
        eVar.f13284i = true;
        j.add(eVar.f13283h);
    }

    public static void h(b.a.f.d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65545, null, dVar) == null) || dVar == null || dVar.i() == null || dVar.f2727i || TextUtils.isEmpty(dVar.i().f2729b) || a(dVar.i().f2729b)) {
            return;
        }
        b.a.r0.z2.l0.e.b().d(b.a.r0.z2.l0.g.a(dVar, 3, dVar.k()));
        b.a.r0.q1.o.h.c.g(dVar);
        dVar.f2727i = true;
        j.add(dVar.i().f2729b);
    }
}
