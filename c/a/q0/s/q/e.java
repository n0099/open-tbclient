package c.a.q0.s.q;

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
/* loaded from: classes5.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: j  reason: collision with root package name */
    public static final Set<String> f12908j;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public int f12909b;

    /* renamed from: c  reason: collision with root package name */
    public String f12910c;

    /* renamed from: d  reason: collision with root package name */
    public String f12911d;

    /* renamed from: e  reason: collision with root package name */
    public String f12912e;

    /* renamed from: f  reason: collision with root package name */
    public String f12913f;

    /* renamed from: g  reason: collision with root package name */
    public String f12914g;

    /* renamed from: h  reason: collision with root package name */
    public String f12915h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f12916i;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1644052602, "Lc/a/q0/s/q/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1644052602, "Lc/a/q0/s/q/e;");
                return;
            }
        }
        f12908j = new HashSet();
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
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? f12908j.contains(str) : invokeL.booleanValue;
    }

    public static void b(AdvertAppInfo advertAppInfo) {
        e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, null, advertAppInfo) == null) || advertAppInfo == null || (eVar = advertAppInfo.l4) == null || eVar.f12916i || a(eVar.f12915h)) {
            return;
        }
        c.a.r0.h3.l0.c b2 = c.a.r0.h3.l0.g.b(advertAppInfo, 3, eVar.f12909b);
        b2.h(eVar.a);
        b2.a("isCache", eVar.f12910c);
        b2.e(eVar.f12912e);
        b2.f(eVar.f12913f);
        b2.g(eVar.f12911d);
        b2.a("vc", eVar.f12914g);
        b2.v(eVar.f12915h);
        c.a.r0.h3.l0.e.b().d(b2);
        c.a.r0.w1.o.h.c.g(c.a.r0.w1.o.h.c.e(advertAppInfo));
        eVar.f12916i = true;
        f12908j.add(eVar.f12915h);
    }

    public static void c(e eVar, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{eVar, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || eVar == null || eVar.f12916i || a(eVar.f12915h)) {
            return;
        }
        c.a.r0.h3.l0.c g2 = c.a.r0.h3.l0.g.g(z ? 13 : 3, i2, eVar.f12909b);
        g2.h(eVar.a);
        g2.a("isCache", String.valueOf(eVar.f12910c));
        g2.e(eVar.f12912e);
        g2.f(eVar.f12913f);
        g2.g(eVar.f12911d);
        g2.a("vc", eVar.f12914g);
        g2.v(eVar.f12915h);
        c.a.r0.h3.l0.e.b().d(g2);
        eVar.f12916i = true;
        f12908j.add(eVar.f12915h);
    }

    public static void d(c.a.r0.g0.f0.d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65541, null, dVar) == null) || dVar == null || dVar.g() == null || dVar.g().l4 == null || dVar.g().l4.f12916i || a(dVar.g().l4.f12915h)) {
            return;
        }
        dVar.g().m4 = dVar.g().l4.a;
        c.a.r0.h3.l0.c c2 = c.a.r0.h3.l0.g.c(dVar.g(), 3, dVar.g().l4.f12909b);
        c2.v(dVar.g().l4.f12915h);
        c.a.r0.h3.l0.e.b().d(c2);
        c.a.r0.w1.o.h.c.g(c.a.r0.w1.o.h.c.e(dVar.g()));
        dVar.g().l4.f12916i = true;
        f12908j.add(dVar.g().l4.f12915h);
    }

    public static void e(e eVar, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65542, null, new Object[]{eVar, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || eVar == null || eVar.f12916i || a(eVar.f12915h)) {
            return;
        }
        c.a.r0.h3.l0.c g2 = c.a.r0.h3.l0.g.g(z ? 13 : 3, i2, eVar.f12909b);
        g2.h(eVar.a);
        g2.v(eVar.f12915h);
        c.a.r0.h3.l0.e.b().d(g2);
        eVar.f12916i = true;
        f12908j.add(eVar.f12915h);
    }

    public static void f(c.a.r0.t3.j0.p pVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65543, null, pVar) == null) || pVar == null || pVar.getAdvertAppInfo() == null) {
            return;
        }
        e eVar = pVar.getAdvertAppInfo().l4;
        if (pVar.Q0 || !(eVar == null || eVar.f12916i || a(eVar.f12915h))) {
            pVar.K0 = eVar.f12912e;
            pVar.L0 = eVar.f12913f;
            pVar.J0 = eVar.f12911d;
            int i2 = 3;
            if (pVar != null && pVar.L0() != null && pVar.L0().forFree()) {
                i2 = 103;
            }
            c.a.r0.h3.l0.c e2 = c.a.r0.h3.l0.g.e(pVar, i2);
            e2.v(eVar.f12915h);
            c.a.r0.h3.l0.e.b().d(e2);
            if (!pVar.Q0) {
                c.a.r0.w1.o.h.c.g(c.a.r0.w1.o.h.c.e(pVar.getAdvertAppInfo()));
            }
            eVar.f12916i = true;
            f12908j.add(eVar.f12915h);
        }
    }

    public static void g(e eVar, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65544, null, new Object[]{eVar, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || eVar == null || eVar.f12916i || a(eVar.f12915h)) {
            return;
        }
        int i3 = z ? 13 : 3;
        c.a.r0.h3.l0.c cVar = new c.a.r0.h3.l0.c();
        cVar.i(i3);
        if ("PB_BANNER".equals(eVar.a)) {
            cVar.d(-1);
            cVar.x(-1);
        } else {
            cVar.d(i2);
            cVar.x(eVar.f12909b);
        }
        cVar.h(eVar.a);
        cVar.e(eVar.f12912e);
        cVar.f(eVar.f12913f);
        cVar.g(eVar.f12911d);
        cVar.a("vc", eVar.f12914g);
        cVar.v(eVar.f12915h);
        c.a.r0.h3.l0.e.b().d(cVar);
        eVar.f12916i = true;
        f12908j.add(eVar.f12915h);
    }

    public static void h(c.a.e.d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65545, null, dVar) == null) || dVar == null || dVar.i() == null || dVar.f3041i || TextUtils.isEmpty(dVar.i().f3044b) || a(dVar.i().f3044b)) {
            return;
        }
        c.a.r0.h3.l0.e.b().d(c.a.r0.h3.l0.g.a(dVar, 3, dVar.k()));
        c.a.r0.w1.o.h.c.g(dVar);
        dVar.f3041i = true;
        f12908j.add(dVar.i().f3044b);
    }
}
