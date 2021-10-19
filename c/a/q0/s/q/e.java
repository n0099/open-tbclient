package c.a.q0.s.q;

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
    public static final Set<String> f14165j;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f14166a;

    /* renamed from: b  reason: collision with root package name */
    public int f14167b;

    /* renamed from: c  reason: collision with root package name */
    public String f14168c;

    /* renamed from: d  reason: collision with root package name */
    public String f14169d;

    /* renamed from: e  reason: collision with root package name */
    public String f14170e;

    /* renamed from: f  reason: collision with root package name */
    public String f14171f;

    /* renamed from: g  reason: collision with root package name */
    public String f14172g;

    /* renamed from: h  reason: collision with root package name */
    public String f14173h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f14174i;

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
        f14165j = new HashSet();
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
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? f14165j.contains(str) : invokeL.booleanValue;
    }

    public static void b(AdvertAppInfo advertAppInfo) {
        e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, null, advertAppInfo) == null) || advertAppInfo == null || (eVar = advertAppInfo.g4) == null || eVar.f14174i || a(eVar.f14173h)) {
            return;
        }
        c.a.r0.z2.l0.c b2 = c.a.r0.z2.l0.g.b(advertAppInfo, 3, eVar.f14167b);
        b2.h(eVar.f14166a);
        b2.a("isCache", eVar.f14168c);
        b2.e(eVar.f14170e);
        b2.f(eVar.f14171f);
        b2.g(eVar.f14169d);
        b2.a("vc", eVar.f14172g);
        b2.t(eVar.f14173h);
        c.a.r0.z2.l0.e.b().d(b2);
        c.a.r0.q1.o.h.c.g(c.a.r0.q1.o.h.c.e(advertAppInfo));
        eVar.f14174i = true;
        f14165j.add(eVar.f14173h);
    }

    public static void c(e eVar, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{eVar, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || eVar == null || eVar.f14174i || a(eVar.f14173h)) {
            return;
        }
        c.a.r0.z2.l0.c g2 = c.a.r0.z2.l0.g.g(z ? 13 : 3, i2, eVar.f14167b);
        g2.h(eVar.f14166a);
        g2.a("isCache", String.valueOf(eVar.f14168c));
        g2.e(eVar.f14170e);
        g2.f(eVar.f14171f);
        g2.g(eVar.f14169d);
        g2.a("vc", eVar.f14172g);
        g2.t(eVar.f14173h);
        c.a.r0.z2.l0.e.b().d(g2);
        eVar.f14174i = true;
        f14165j.add(eVar.f14173h);
    }

    public static void d(c.a.r0.b0.e0.d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, dVar) == null) || dVar == null || dVar.g() == null || dVar.g().g4 == null || dVar.g().g4.f14174i || a(dVar.g().g4.f14173h)) {
            return;
        }
        dVar.g().h4 = dVar.g().g4.f14166a;
        c.a.r0.z2.l0.c c2 = c.a.r0.z2.l0.g.c(dVar.g(), 3, dVar.g().g4.f14167b);
        c2.t(dVar.g().g4.f14173h);
        c.a.r0.z2.l0.e.b().d(c2);
        c.a.r0.q1.o.h.c.g(c.a.r0.q1.o.h.c.e(dVar.g()));
        dVar.g().g4.f14174i = true;
        f14165j.add(dVar.g().g4.f14173h);
    }

    public static void e(e eVar, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(AdIconUtil.BAIDU_LOGO_ID, null, new Object[]{eVar, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || eVar == null || eVar.f14174i || a(eVar.f14173h)) {
            return;
        }
        c.a.r0.z2.l0.c g2 = c.a.r0.z2.l0.g.g(z ? 13 : 3, i2, eVar.f14167b);
        g2.h(eVar.f14166a);
        g2.t(eVar.f14173h);
        c.a.r0.z2.l0.e.b().d(g2);
        eVar.f14174i = true;
        f14165j.add(eVar.f14173h);
    }

    public static void f(c.a.r0.k3.i0.p pVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65543, null, pVar) == null) || pVar == null || pVar.getAdvertAppInfo() == null) {
            return;
        }
        e eVar = pVar.getAdvertAppInfo().g4;
        if (pVar.M0 || !(eVar == null || eVar.f14174i || a(eVar.f14173h))) {
            pVar.G0 = eVar.f14170e;
            pVar.H0 = eVar.f14171f;
            pVar.F0 = eVar.f14169d;
            int i2 = 3;
            if (pVar != null && pVar.H0() != null && pVar.H0().forFree()) {
                i2 = 103;
            }
            c.a.r0.z2.l0.c e2 = c.a.r0.z2.l0.g.e(pVar, i2);
            e2.t(eVar.f14173h);
            c.a.r0.z2.l0.e.b().d(e2);
            if (!pVar.M0) {
                c.a.r0.q1.o.h.c.g(c.a.r0.q1.o.h.c.e(pVar.getAdvertAppInfo()));
            }
            eVar.f14174i = true;
            f14165j.add(eVar.f14173h);
        }
    }

    public static void g(e eVar, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65544, null, new Object[]{eVar, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || eVar == null || eVar.f14174i || a(eVar.f14173h)) {
            return;
        }
        int i3 = z ? 13 : 3;
        c.a.r0.z2.l0.c cVar = new c.a.r0.z2.l0.c();
        cVar.i(i3);
        if ("PB_BANNER".equals(eVar.f14166a)) {
            cVar.d(-1);
            cVar.v(-1);
        } else {
            cVar.d(i2);
            cVar.v(eVar.f14167b);
        }
        cVar.h(eVar.f14166a);
        cVar.e(eVar.f14170e);
        cVar.f(eVar.f14171f);
        cVar.g(eVar.f14169d);
        cVar.a("vc", eVar.f14172g);
        cVar.t(eVar.f14173h);
        c.a.r0.z2.l0.e.b().d(cVar);
        eVar.f14174i = true;
        f14165j.add(eVar.f14173h);
    }

    public static void h(c.a.f.d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65545, null, dVar) == null) || dVar == null || dVar.i() == null || dVar.f3280i || TextUtils.isEmpty(dVar.i().f3283b) || a(dVar.i().f3283b)) {
            return;
        }
        c.a.r0.z2.l0.e.b().d(c.a.r0.z2.l0.g.a(dVar, 3, dVar.k()));
        c.a.r0.q1.o.h.c.g(dVar);
        dVar.f3280i = true;
        f14165j.add(dVar.i().f3283b);
    }
}
