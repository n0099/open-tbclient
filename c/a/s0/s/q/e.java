package c.a.s0.s.q;

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
    public static final Set<String> f13664j;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public int f13665b;

    /* renamed from: c  reason: collision with root package name */
    public String f13666c;

    /* renamed from: d  reason: collision with root package name */
    public String f13667d;

    /* renamed from: e  reason: collision with root package name */
    public String f13668e;

    /* renamed from: f  reason: collision with root package name */
    public String f13669f;

    /* renamed from: g  reason: collision with root package name */
    public String f13670g;

    /* renamed from: h  reason: collision with root package name */
    public String f13671h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f13672i;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1970856324, "Lc/a/s0/s/q/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1970856324, "Lc/a/s0/s/q/e;");
                return;
            }
        }
        f13664j = new HashSet();
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
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? f13664j.contains(str) : invokeL.booleanValue;
    }

    public static void b(AdvertAppInfo advertAppInfo) {
        e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, null, advertAppInfo) == null) || advertAppInfo == null || (eVar = advertAppInfo.o4) == null || eVar.f13672i || a(eVar.f13671h)) {
            return;
        }
        c.a.t0.j3.l0.c b2 = c.a.t0.j3.l0.g.b(advertAppInfo, 3, eVar.f13665b);
        b2.h(eVar.a);
        b2.a("isCache", eVar.f13666c);
        b2.e(eVar.f13668e);
        b2.f(eVar.f13669f);
        b2.g(eVar.f13667d);
        b2.a("vc", eVar.f13670g);
        b2.v(eVar.f13671h);
        c.a.t0.j3.l0.e.b().d(b2);
        c.a.t0.x1.o.h.c.g(c.a.t0.x1.o.h.c.e(advertAppInfo));
        eVar.f13672i = true;
        f13664j.add(eVar.f13671h);
    }

    public static void c(e eVar, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{eVar, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || eVar == null || eVar.f13672i || a(eVar.f13671h)) {
            return;
        }
        c.a.t0.j3.l0.c g2 = c.a.t0.j3.l0.g.g(z ? 13 : 3, i2, eVar.f13665b);
        g2.h(eVar.a);
        g2.a("isCache", String.valueOf(eVar.f13666c));
        g2.e(eVar.f13668e);
        g2.f(eVar.f13669f);
        g2.g(eVar.f13667d);
        g2.a("vc", eVar.f13670g);
        g2.v(eVar.f13671h);
        c.a.t0.j3.l0.e.b().d(g2);
        eVar.f13672i = true;
        f13664j.add(eVar.f13671h);
    }

    public static void d(c.a.t0.g0.f0.d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65541, null, dVar) == null) || dVar == null || dVar.g() == null || dVar.g().o4 == null || dVar.g().o4.f13672i || a(dVar.g().o4.f13671h)) {
            return;
        }
        dVar.g().p4 = dVar.g().o4.a;
        c.a.t0.j3.l0.c c2 = c.a.t0.j3.l0.g.c(dVar.g(), 3, dVar.g().o4.f13665b);
        c2.v(dVar.g().o4.f13671h);
        c.a.t0.j3.l0.e.b().d(c2);
        c.a.t0.x1.o.h.c.g(c.a.t0.x1.o.h.c.e(dVar.g()));
        dVar.g().o4.f13672i = true;
        f13664j.add(dVar.g().o4.f13671h);
    }

    public static void e(e eVar, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65542, null, new Object[]{eVar, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || eVar == null || eVar.f13672i || a(eVar.f13671h)) {
            return;
        }
        c.a.t0.j3.l0.c g2 = c.a.t0.j3.l0.g.g(z ? 13 : 3, i2, eVar.f13665b);
        g2.h(eVar.a);
        g2.v(eVar.f13671h);
        c.a.t0.j3.l0.e.b().d(g2);
        eVar.f13672i = true;
        f13664j.add(eVar.f13671h);
    }

    public static void f(c.a.t0.w3.j0.p pVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65543, null, pVar) == null) || pVar == null || pVar.getAdvertAppInfo() == null) {
            return;
        }
        e eVar = pVar.getAdvertAppInfo().o4;
        if (pVar.R0 || !(eVar == null || eVar.f13672i || a(eVar.f13671h))) {
            pVar.L0 = eVar.f13668e;
            pVar.M0 = eVar.f13669f;
            pVar.K0 = eVar.f13667d;
            int i2 = 3;
            if (pVar != null && pVar.M0() != null && pVar.M0().forFree()) {
                i2 = 103;
            }
            c.a.t0.j3.l0.c e2 = c.a.t0.j3.l0.g.e(pVar, i2);
            e2.v(eVar.f13671h);
            c.a.t0.j3.l0.e.b().d(e2);
            if (!pVar.R0) {
                c.a.t0.x1.o.h.c.g(c.a.t0.x1.o.h.c.e(pVar.getAdvertAppInfo()));
            }
            eVar.f13672i = true;
            f13664j.add(eVar.f13671h);
        }
    }

    public static void g(e eVar, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65544, null, new Object[]{eVar, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || eVar == null || eVar.f13672i || a(eVar.f13671h)) {
            return;
        }
        int i3 = z ? 13 : 3;
        c.a.t0.j3.l0.c cVar = new c.a.t0.j3.l0.c();
        cVar.i(i3);
        if ("PB_BANNER".equals(eVar.a)) {
            cVar.d(-1);
            cVar.x(-1);
        } else {
            cVar.d(i2);
            cVar.x(eVar.f13665b);
        }
        cVar.h(eVar.a);
        cVar.e(eVar.f13668e);
        cVar.f(eVar.f13669f);
        cVar.g(eVar.f13667d);
        cVar.a("vc", eVar.f13670g);
        cVar.v(eVar.f13671h);
        c.a.t0.j3.l0.e.b().d(cVar);
        eVar.f13672i = true;
        f13664j.add(eVar.f13671h);
    }

    public static void h(c.a.e.d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65545, null, dVar) == null) || dVar == null || dVar.i() == null || dVar.f3484i || TextUtils.isEmpty(dVar.i().f3487b) || a(dVar.i().f3487b)) {
            return;
        }
        c.a.t0.j3.l0.e.b().d(c.a.t0.j3.l0.g.a(dVar, 3, dVar.k()));
        c.a.t0.x1.o.h.c.g(dVar);
        dVar.f3484i = true;
        f13664j.add(dVar.i().f3487b);
    }
}
