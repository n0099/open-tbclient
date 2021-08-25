package c.a.p0.s.q;

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
/* loaded from: classes3.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: j  reason: collision with root package name */
    public static final Set<String> f14191j;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f14192a;

    /* renamed from: b  reason: collision with root package name */
    public int f14193b;

    /* renamed from: c  reason: collision with root package name */
    public String f14194c;

    /* renamed from: d  reason: collision with root package name */
    public String f14195d;

    /* renamed from: e  reason: collision with root package name */
    public String f14196e;

    /* renamed from: f  reason: collision with root package name */
    public String f14197f;

    /* renamed from: g  reason: collision with root package name */
    public String f14198g;

    /* renamed from: h  reason: collision with root package name */
    public String f14199h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f14200i;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-843460231, "Lc/a/p0/s/q/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-843460231, "Lc/a/p0/s/q/e;");
                return;
            }
        }
        f14191j = new HashSet();
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
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? f14191j.contains(str) : invokeL.booleanValue;
    }

    public static void b(AdvertAppInfo advertAppInfo) {
        e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, null, advertAppInfo) == null) || advertAppInfo == null || (eVar = advertAppInfo.c4) == null || eVar.f14200i || a(eVar.f14199h)) {
            return;
        }
        c.a.q0.x2.l0.c b2 = c.a.q0.x2.l0.g.b(advertAppInfo, 3, eVar.f14193b);
        b2.h(eVar.f14192a);
        b2.a("isCache", eVar.f14194c);
        b2.e(eVar.f14196e);
        b2.f(eVar.f14197f);
        b2.g(eVar.f14195d);
        b2.a("vc", eVar.f14198g);
        b2.t(eVar.f14199h);
        c.a.q0.x2.l0.e.b().d(b2);
        c.a.q0.o1.o.h.c.g(c.a.q0.o1.o.h.c.e(advertAppInfo));
        eVar.f14200i = true;
        f14191j.add(eVar.f14199h);
    }

    public static void c(e eVar, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{eVar, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || eVar == null || eVar.f14200i || a(eVar.f14199h)) {
            return;
        }
        c.a.q0.x2.l0.c g2 = c.a.q0.x2.l0.g.g(z ? 13 : 3, i2, eVar.f14193b);
        g2.h(eVar.f14192a);
        g2.a("isCache", String.valueOf(eVar.f14194c));
        g2.e(eVar.f14196e);
        g2.f(eVar.f14197f);
        g2.g(eVar.f14195d);
        g2.a("vc", eVar.f14198g);
        g2.t(eVar.f14199h);
        c.a.q0.x2.l0.e.b().d(g2);
        eVar.f14200i = true;
        f14191j.add(eVar.f14199h);
    }

    public static void d(c.a.q0.a0.d0.d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, dVar) == null) || dVar == null || dVar.g() == null || dVar.g().c4 == null || dVar.g().c4.f14200i || a(dVar.g().c4.f14199h)) {
            return;
        }
        dVar.g().d4 = dVar.g().c4.f14192a;
        c.a.q0.x2.l0.c c2 = c.a.q0.x2.l0.g.c(dVar.g(), 3, dVar.g().c4.f14193b);
        c2.t(dVar.g().c4.f14199h);
        c.a.q0.x2.l0.e.b().d(c2);
        c.a.q0.o1.o.h.c.g(c.a.q0.o1.o.h.c.e(dVar.g()));
        dVar.g().c4.f14200i = true;
        f14191j.add(dVar.g().c4.f14199h);
    }

    public static void e(e eVar, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(AdIconUtil.BAIDU_LOGO_ID, null, new Object[]{eVar, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || eVar == null || eVar.f14200i || a(eVar.f14199h)) {
            return;
        }
        c.a.q0.x2.l0.c g2 = c.a.q0.x2.l0.g.g(z ? 13 : 3, i2, eVar.f14193b);
        g2.h(eVar.f14192a);
        g2.t(eVar.f14199h);
        c.a.q0.x2.l0.e.b().d(g2);
        eVar.f14200i = true;
        f14191j.add(eVar.f14199h);
    }

    public static void f(c.a.q0.i3.i0.p pVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65543, null, pVar) == null) || pVar == null || pVar.getAdvertAppInfo() == null) {
            return;
        }
        e eVar = pVar.getAdvertAppInfo().c4;
        if (pVar.M0 || !(eVar == null || eVar.f14200i || a(eVar.f14199h))) {
            pVar.G0 = eVar.f14196e;
            pVar.H0 = eVar.f14197f;
            pVar.F0 = eVar.f14195d;
            int i2 = 3;
            if (pVar != null && pVar.F0() != null && pVar.F0().forFree()) {
                i2 = 103;
            }
            c.a.q0.x2.l0.c e2 = c.a.q0.x2.l0.g.e(pVar, i2);
            e2.t(eVar.f14199h);
            c.a.q0.x2.l0.e.b().d(e2);
            if (!pVar.M0) {
                c.a.q0.o1.o.h.c.g(c.a.q0.o1.o.h.c.e(pVar.getAdvertAppInfo()));
            }
            eVar.f14200i = true;
            f14191j.add(eVar.f14199h);
        }
    }

    public static void g(e eVar, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65544, null, new Object[]{eVar, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || eVar == null || eVar.f14200i || a(eVar.f14199h)) {
            return;
        }
        int i3 = z ? 13 : 3;
        c.a.q0.x2.l0.c cVar = new c.a.q0.x2.l0.c();
        cVar.i(i3);
        if ("PB_BANNER".equals(eVar.f14192a)) {
            cVar.d(-1);
            cVar.v(-1);
        } else {
            cVar.d(i2);
            cVar.v(eVar.f14193b);
        }
        cVar.h(eVar.f14192a);
        cVar.e(eVar.f14196e);
        cVar.f(eVar.f14197f);
        cVar.g(eVar.f14195d);
        cVar.a("vc", eVar.f14198g);
        cVar.t(eVar.f14199h);
        c.a.q0.x2.l0.e.b().d(cVar);
        eVar.f14200i = true;
        f14191j.add(eVar.f14199h);
    }

    public static void h(c.a.f.d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65545, null, dVar) == null) || dVar == null || dVar.i() == null || dVar.f3288i || TextUtils.isEmpty(dVar.i().f3291b) || a(dVar.i().f3291b)) {
            return;
        }
        c.a.q0.x2.l0.e.b().d(c.a.q0.x2.l0.g.a(dVar, 3, dVar.k()));
        c.a.q0.o1.o.h.c.g(dVar);
        dVar.f3288i = true;
        f14191j.add(dVar.i().f3291b);
    }
}
