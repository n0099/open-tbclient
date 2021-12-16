package c.a.r0.s.r;

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
/* loaded from: classes6.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: j  reason: collision with root package name */
    public static final Set<String> f13288j;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public int f13289b;

    /* renamed from: c  reason: collision with root package name */
    public String f13290c;

    /* renamed from: d  reason: collision with root package name */
    public String f13291d;

    /* renamed from: e  reason: collision with root package name */
    public String f13292e;

    /* renamed from: f  reason: collision with root package name */
    public String f13293f;

    /* renamed from: g  reason: collision with root package name */
    public String f13294g;

    /* renamed from: h  reason: collision with root package name */
    public String f13295h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f13296i;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-163372070, "Lc/a/r0/s/r/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-163372070, "Lc/a/r0/s/r/e;");
                return;
            }
        }
        f13288j = new HashSet();
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
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? f13288j.contains(str) : invokeL.booleanValue;
    }

    public static void b(AdvertAppInfo advertAppInfo) {
        e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, null, advertAppInfo) == null) || advertAppInfo == null || (eVar = advertAppInfo.m4) == null || eVar.f13296i || a(eVar.f13295h)) {
            return;
        }
        c.a.s0.j3.l0.c b2 = c.a.s0.j3.l0.g.b(advertAppInfo, 3, eVar.f13289b);
        b2.h(eVar.a);
        b2.a("isCache", eVar.f13290c);
        b2.e(eVar.f13292e);
        b2.f(eVar.f13293f);
        b2.g(eVar.f13291d);
        b2.a("vc", eVar.f13294g);
        b2.v(eVar.f13295h);
        c.a.s0.j3.l0.e.b().d(b2);
        c.a.s0.x1.o.h.c.g(c.a.s0.x1.o.h.c.e(advertAppInfo));
        eVar.f13296i = true;
        f13288j.add(eVar.f13295h);
    }

    public static void c(e eVar, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{eVar, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || eVar == null || eVar.f13296i || a(eVar.f13295h)) {
            return;
        }
        c.a.s0.j3.l0.c g2 = c.a.s0.j3.l0.g.g(z ? 13 : 3, i2, eVar.f13289b);
        g2.h(eVar.a);
        g2.a("isCache", String.valueOf(eVar.f13290c));
        g2.e(eVar.f13292e);
        g2.f(eVar.f13293f);
        g2.g(eVar.f13291d);
        g2.a("vc", eVar.f13294g);
        g2.v(eVar.f13295h);
        c.a.s0.j3.l0.e.b().d(g2);
        eVar.f13296i = true;
        f13288j.add(eVar.f13295h);
    }

    public static void d(c.a.s0.g0.f0.d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65541, null, dVar) == null) || dVar == null || dVar.g() == null || dVar.g().m4 == null || dVar.g().m4.f13296i || a(dVar.g().m4.f13295h)) {
            return;
        }
        dVar.g().n4 = dVar.g().m4.a;
        c.a.s0.j3.l0.c c2 = c.a.s0.j3.l0.g.c(dVar.g(), 3, dVar.g().m4.f13289b);
        c2.v(dVar.g().m4.f13295h);
        c.a.s0.j3.l0.e.b().d(c2);
        c.a.s0.x1.o.h.c.g(c.a.s0.x1.o.h.c.e(dVar.g()));
        dVar.g().m4.f13296i = true;
        f13288j.add(dVar.g().m4.f13295h);
    }

    public static void e(e eVar, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65542, null, new Object[]{eVar, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || eVar == null || eVar.f13296i || a(eVar.f13295h)) {
            return;
        }
        c.a.s0.j3.l0.c g2 = c.a.s0.j3.l0.g.g(z ? 13 : 3, i2, eVar.f13289b);
        g2.h(eVar.a);
        g2.v(eVar.f13295h);
        c.a.s0.j3.l0.e.b().d(g2);
        eVar.f13296i = true;
        f13288j.add(eVar.f13295h);
    }

    public static void f(c.a.s0.v3.j0.p pVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65543, null, pVar) == null) || pVar == null || pVar.getAdvertAppInfo() == null) {
            return;
        }
        e eVar = pVar.getAdvertAppInfo().m4;
        if (pVar.Q0 || !(eVar == null || eVar.f13296i || a(eVar.f13295h))) {
            pVar.K0 = eVar.f13292e;
            pVar.L0 = eVar.f13293f;
            pVar.J0 = eVar.f13291d;
            int i2 = 3;
            if (pVar != null && pVar.L0() != null && pVar.L0().forFree()) {
                i2 = 103;
            }
            c.a.s0.j3.l0.c e2 = c.a.s0.j3.l0.g.e(pVar, i2);
            e2.v(eVar.f13295h);
            c.a.s0.j3.l0.e.b().d(e2);
            if (!pVar.Q0) {
                c.a.s0.x1.o.h.c.g(c.a.s0.x1.o.h.c.e(pVar.getAdvertAppInfo()));
            }
            eVar.f13296i = true;
            f13288j.add(eVar.f13295h);
        }
    }

    public static void g(e eVar, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65544, null, new Object[]{eVar, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || eVar == null || eVar.f13296i || a(eVar.f13295h)) {
            return;
        }
        int i3 = z ? 13 : 3;
        c.a.s0.j3.l0.c cVar = new c.a.s0.j3.l0.c();
        cVar.i(i3);
        if ("PB_BANNER".equals(eVar.a)) {
            cVar.d(-1);
            cVar.x(-1);
        } else {
            cVar.d(i2);
            cVar.x(eVar.f13289b);
        }
        cVar.h(eVar.a);
        cVar.e(eVar.f13292e);
        cVar.f(eVar.f13293f);
        cVar.g(eVar.f13291d);
        cVar.a("vc", eVar.f13294g);
        cVar.v(eVar.f13295h);
        c.a.s0.j3.l0.e.b().d(cVar);
        eVar.f13296i = true;
        f13288j.add(eVar.f13295h);
    }

    public static void h(c.a.e.d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65545, null, dVar) == null) || dVar == null || dVar.i() == null || dVar.f3056i || TextUtils.isEmpty(dVar.i().f3059b) || a(dVar.i().f3059b)) {
            return;
        }
        c.a.s0.j3.l0.e.b().d(c.a.s0.j3.l0.g.a(dVar, 3, dVar.k()));
        c.a.s0.x1.o.h.c.g(dVar);
        dVar.f3056i = true;
        f13288j.add(dVar.i().f3059b);
    }
}
