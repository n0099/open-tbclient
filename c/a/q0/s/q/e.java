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
    public static final Set<String> f14142j;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f14143a;

    /* renamed from: b  reason: collision with root package name */
    public int f14144b;

    /* renamed from: c  reason: collision with root package name */
    public String f14145c;

    /* renamed from: d  reason: collision with root package name */
    public String f14146d;

    /* renamed from: e  reason: collision with root package name */
    public String f14147e;

    /* renamed from: f  reason: collision with root package name */
    public String f14148f;

    /* renamed from: g  reason: collision with root package name */
    public String f14149g;

    /* renamed from: h  reason: collision with root package name */
    public String f14150h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f14151i;

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
        f14142j = new HashSet();
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
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? f14142j.contains(str) : invokeL.booleanValue;
    }

    public static void b(AdvertAppInfo advertAppInfo) {
        e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, null, advertAppInfo) == null) || advertAppInfo == null || (eVar = advertAppInfo.g4) == null || eVar.f14151i || a(eVar.f14150h)) {
            return;
        }
        c.a.r0.y2.l0.c b2 = c.a.r0.y2.l0.g.b(advertAppInfo, 3, eVar.f14144b);
        b2.h(eVar.f14143a);
        b2.a("isCache", eVar.f14145c);
        b2.e(eVar.f14147e);
        b2.f(eVar.f14148f);
        b2.g(eVar.f14146d);
        b2.a("vc", eVar.f14149g);
        b2.t(eVar.f14150h);
        c.a.r0.y2.l0.e.b().d(b2);
        c.a.r0.p1.o.h.c.g(c.a.r0.p1.o.h.c.e(advertAppInfo));
        eVar.f14151i = true;
        f14142j.add(eVar.f14150h);
    }

    public static void c(e eVar, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{eVar, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || eVar == null || eVar.f14151i || a(eVar.f14150h)) {
            return;
        }
        c.a.r0.y2.l0.c g2 = c.a.r0.y2.l0.g.g(z ? 13 : 3, i2, eVar.f14144b);
        g2.h(eVar.f14143a);
        g2.a("isCache", String.valueOf(eVar.f14145c));
        g2.e(eVar.f14147e);
        g2.f(eVar.f14148f);
        g2.g(eVar.f14146d);
        g2.a("vc", eVar.f14149g);
        g2.t(eVar.f14150h);
        c.a.r0.y2.l0.e.b().d(g2);
        eVar.f14151i = true;
        f14142j.add(eVar.f14150h);
    }

    public static void d(c.a.r0.a0.d0.d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, dVar) == null) || dVar == null || dVar.g() == null || dVar.g().g4 == null || dVar.g().g4.f14151i || a(dVar.g().g4.f14150h)) {
            return;
        }
        dVar.g().h4 = dVar.g().g4.f14143a;
        c.a.r0.y2.l0.c c2 = c.a.r0.y2.l0.g.c(dVar.g(), 3, dVar.g().g4.f14144b);
        c2.t(dVar.g().g4.f14150h);
        c.a.r0.y2.l0.e.b().d(c2);
        c.a.r0.p1.o.h.c.g(c.a.r0.p1.o.h.c.e(dVar.g()));
        dVar.g().g4.f14151i = true;
        f14142j.add(dVar.g().g4.f14150h);
    }

    public static void e(e eVar, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(AdIconUtil.BAIDU_LOGO_ID, null, new Object[]{eVar, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || eVar == null || eVar.f14151i || a(eVar.f14150h)) {
            return;
        }
        c.a.r0.y2.l0.c g2 = c.a.r0.y2.l0.g.g(z ? 13 : 3, i2, eVar.f14144b);
        g2.h(eVar.f14143a);
        g2.t(eVar.f14150h);
        c.a.r0.y2.l0.e.b().d(g2);
        eVar.f14151i = true;
        f14142j.add(eVar.f14150h);
    }

    public static void f(c.a.r0.j3.i0.p pVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65543, null, pVar) == null) || pVar == null || pVar.getAdvertAppInfo() == null) {
            return;
        }
        e eVar = pVar.getAdvertAppInfo().g4;
        if (pVar.M0 || !(eVar == null || eVar.f14151i || a(eVar.f14150h))) {
            pVar.G0 = eVar.f14147e;
            pVar.H0 = eVar.f14148f;
            pVar.F0 = eVar.f14146d;
            int i2 = 3;
            if (pVar != null && pVar.H0() != null && pVar.H0().forFree()) {
                i2 = 103;
            }
            c.a.r0.y2.l0.c e2 = c.a.r0.y2.l0.g.e(pVar, i2);
            e2.t(eVar.f14150h);
            c.a.r0.y2.l0.e.b().d(e2);
            if (!pVar.M0) {
                c.a.r0.p1.o.h.c.g(c.a.r0.p1.o.h.c.e(pVar.getAdvertAppInfo()));
            }
            eVar.f14151i = true;
            f14142j.add(eVar.f14150h);
        }
    }

    public static void g(e eVar, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65544, null, new Object[]{eVar, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || eVar == null || eVar.f14151i || a(eVar.f14150h)) {
            return;
        }
        int i3 = z ? 13 : 3;
        c.a.r0.y2.l0.c cVar = new c.a.r0.y2.l0.c();
        cVar.i(i3);
        if ("PB_BANNER".equals(eVar.f14143a)) {
            cVar.d(-1);
            cVar.v(-1);
        } else {
            cVar.d(i2);
            cVar.v(eVar.f14144b);
        }
        cVar.h(eVar.f14143a);
        cVar.e(eVar.f14147e);
        cVar.f(eVar.f14148f);
        cVar.g(eVar.f14146d);
        cVar.a("vc", eVar.f14149g);
        cVar.t(eVar.f14150h);
        c.a.r0.y2.l0.e.b().d(cVar);
        eVar.f14151i = true;
        f14142j.add(eVar.f14150h);
    }

    public static void h(c.a.f.d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65545, null, dVar) == null) || dVar == null || dVar.i() == null || dVar.f3280i || TextUtils.isEmpty(dVar.i().f3283b) || a(dVar.i().f3283b)) {
            return;
        }
        c.a.r0.y2.l0.e.b().d(c.a.r0.y2.l0.g.a(dVar, 3, dVar.k()));
        c.a.r0.p1.o.h.c.g(dVar);
        dVar.f3280i = true;
        f14142j.add(dVar.i().f3283b);
    }
}
