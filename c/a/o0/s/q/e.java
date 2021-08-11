package c.a.o0.s.q;

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
    public static final Set<String> f13885j;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f13886a;

    /* renamed from: b  reason: collision with root package name */
    public int f13887b;

    /* renamed from: c  reason: collision with root package name */
    public String f13888c;

    /* renamed from: d  reason: collision with root package name */
    public String f13889d;

    /* renamed from: e  reason: collision with root package name */
    public String f13890e;

    /* renamed from: f  reason: collision with root package name */
    public String f13891f;

    /* renamed from: g  reason: collision with root package name */
    public String f13892g;

    /* renamed from: h  reason: collision with root package name */
    public String f13893h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f13894i;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(963994232, "Lc/a/o0/s/q/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(963994232, "Lc/a/o0/s/q/e;");
                return;
            }
        }
        f13885j = new HashSet();
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
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? f13885j.contains(str) : invokeL.booleanValue;
    }

    public static void b(AdvertAppInfo advertAppInfo) {
        e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, null, advertAppInfo) == null) || advertAppInfo == null || (eVar = advertAppInfo.c4) == null || eVar.f13894i || a(eVar.f13893h)) {
            return;
        }
        c.a.p0.x2.l0.c b2 = c.a.p0.x2.l0.g.b(advertAppInfo, 3, eVar.f13887b);
        b2.h(eVar.f13886a);
        b2.a("isCache", eVar.f13888c);
        b2.e(eVar.f13890e);
        b2.f(eVar.f13891f);
        b2.g(eVar.f13889d);
        b2.a("vc", eVar.f13892g);
        b2.t(eVar.f13893h);
        c.a.p0.x2.l0.e.b().d(b2);
        c.a.p0.o1.o.h.c.g(c.a.p0.o1.o.h.c.e(advertAppInfo));
        eVar.f13894i = true;
        f13885j.add(eVar.f13893h);
    }

    public static void c(e eVar, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{eVar, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || eVar == null || eVar.f13894i || a(eVar.f13893h)) {
            return;
        }
        c.a.p0.x2.l0.c g2 = c.a.p0.x2.l0.g.g(z ? 13 : 3, i2, eVar.f13887b);
        g2.h(eVar.f13886a);
        g2.a("isCache", String.valueOf(eVar.f13888c));
        g2.e(eVar.f13890e);
        g2.f(eVar.f13891f);
        g2.g(eVar.f13889d);
        g2.a("vc", eVar.f13892g);
        g2.t(eVar.f13893h);
        c.a.p0.x2.l0.e.b().d(g2);
        eVar.f13894i = true;
        f13885j.add(eVar.f13893h);
    }

    public static void d(c.a.p0.a0.d0.d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, dVar) == null) || dVar == null || dVar.g() == null || dVar.g().c4 == null || dVar.g().c4.f13894i || a(dVar.g().c4.f13893h)) {
            return;
        }
        dVar.g().d4 = dVar.g().c4.f13886a;
        c.a.p0.x2.l0.c c2 = c.a.p0.x2.l0.g.c(dVar.g(), 3, dVar.g().c4.f13887b);
        c2.t(dVar.g().c4.f13893h);
        c.a.p0.x2.l0.e.b().d(c2);
        c.a.p0.o1.o.h.c.g(c.a.p0.o1.o.h.c.e(dVar.g()));
        dVar.g().c4.f13894i = true;
        f13885j.add(dVar.g().c4.f13893h);
    }

    public static void e(e eVar, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(AdIconUtil.BAIDU_LOGO_ID, null, new Object[]{eVar, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || eVar == null || eVar.f13894i || a(eVar.f13893h)) {
            return;
        }
        c.a.p0.x2.l0.c g2 = c.a.p0.x2.l0.g.g(z ? 13 : 3, i2, eVar.f13887b);
        g2.h(eVar.f13886a);
        g2.t(eVar.f13893h);
        c.a.p0.x2.l0.e.b().d(g2);
        eVar.f13894i = true;
        f13885j.add(eVar.f13893h);
    }

    public static void f(c.a.p0.i3.h0.p pVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65543, null, pVar) == null) || pVar == null || pVar.getAdvertAppInfo() == null) {
            return;
        }
        e eVar = pVar.getAdvertAppInfo().c4;
        if (pVar.M0 || !(eVar == null || eVar.f13894i || a(eVar.f13893h))) {
            pVar.G0 = eVar.f13890e;
            pVar.H0 = eVar.f13891f;
            pVar.F0 = eVar.f13889d;
            int i2 = 3;
            if (pVar != null && pVar.F0() != null && pVar.F0().forFree()) {
                i2 = 103;
            }
            c.a.p0.x2.l0.c e2 = c.a.p0.x2.l0.g.e(pVar, i2);
            e2.t(eVar.f13893h);
            c.a.p0.x2.l0.e.b().d(e2);
            if (!pVar.M0) {
                c.a.p0.o1.o.h.c.g(c.a.p0.o1.o.h.c.e(pVar.getAdvertAppInfo()));
            }
            eVar.f13894i = true;
            f13885j.add(eVar.f13893h);
        }
    }

    public static void g(e eVar, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65544, null, new Object[]{eVar, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || eVar == null || eVar.f13894i || a(eVar.f13893h)) {
            return;
        }
        int i3 = z ? 13 : 3;
        c.a.p0.x2.l0.c cVar = new c.a.p0.x2.l0.c();
        cVar.i(i3);
        if ("PB_BANNER".equals(eVar.f13886a)) {
            cVar.d(-1);
            cVar.v(-1);
        } else {
            cVar.d(i2);
            cVar.v(eVar.f13887b);
        }
        cVar.h(eVar.f13886a);
        cVar.e(eVar.f13890e);
        cVar.f(eVar.f13891f);
        cVar.g(eVar.f13889d);
        cVar.a("vc", eVar.f13892g);
        cVar.t(eVar.f13893h);
        c.a.p0.x2.l0.e.b().d(cVar);
        eVar.f13894i = true;
        f13885j.add(eVar.f13893h);
    }

    public static void h(c.a.f.d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65545, null, dVar) == null) || dVar == null || dVar.i() == null || dVar.f3168i || TextUtils.isEmpty(dVar.i().f3171b) || a(dVar.i().f3171b)) {
            return;
        }
        c.a.p0.x2.l0.e.b().d(c.a.p0.x2.l0.g.a(dVar, 3, dVar.k()));
        c.a.p0.o1.o.h.c.g(dVar);
        dVar.f3168i = true;
        f13885j.add(dVar.i().f3171b);
    }
}
