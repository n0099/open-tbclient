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
    public String f14056a;

    /* renamed from: b  reason: collision with root package name */
    public int f14057b;

    /* renamed from: c  reason: collision with root package name */
    public String f14058c;

    /* renamed from: d  reason: collision with root package name */
    public String f14059d;

    /* renamed from: e  reason: collision with root package name */
    public String f14060e;

    /* renamed from: f  reason: collision with root package name */
    public String f14061f;

    /* renamed from: g  reason: collision with root package name */
    public String f14062g;

    /* renamed from: h  reason: collision with root package name */
    public String f14063h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f14064i;

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
        if (!(interceptable == null || interceptable.invokeL(65539, null, advertAppInfo) == null) || advertAppInfo == null || (eVar = advertAppInfo.h4) == null || eVar.f14064i || a(eVar.f14063h)) {
            return;
        }
        b.a.r0.a3.l0.c b2 = b.a.r0.a3.l0.g.b(advertAppInfo, 3, eVar.f14057b);
        b2.h(eVar.f14056a);
        b2.a("isCache", eVar.f14058c);
        b2.e(eVar.f14060e);
        b2.f(eVar.f14061f);
        b2.g(eVar.f14059d);
        b2.a("vc", eVar.f14062g);
        b2.v(eVar.f14063h);
        b.a.r0.a3.l0.e.b().d(b2);
        b.a.r0.q1.o.h.c.g(b.a.r0.q1.o.h.c.e(advertAppInfo));
        eVar.f14064i = true;
        j.add(eVar.f14063h);
    }

    public static void c(e eVar, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{eVar, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || eVar == null || eVar.f14064i || a(eVar.f14063h)) {
            return;
        }
        b.a.r0.a3.l0.c g2 = b.a.r0.a3.l0.g.g(z ? 13 : 3, i2, eVar.f14057b);
        g2.h(eVar.f14056a);
        g2.a("isCache", String.valueOf(eVar.f14058c));
        g2.e(eVar.f14060e);
        g2.f(eVar.f14061f);
        g2.g(eVar.f14059d);
        g2.a("vc", eVar.f14062g);
        g2.v(eVar.f14063h);
        b.a.r0.a3.l0.e.b().d(g2);
        eVar.f14064i = true;
        j.add(eVar.f14063h);
    }

    public static void d(b.a.r0.b0.f0.d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, dVar) == null) || dVar == null || dVar.g() == null || dVar.g().h4 == null || dVar.g().h4.f14064i || a(dVar.g().h4.f14063h)) {
            return;
        }
        dVar.g().i4 = dVar.g().h4.f14056a;
        b.a.r0.a3.l0.c c2 = b.a.r0.a3.l0.g.c(dVar.g(), 3, dVar.g().h4.f14057b);
        c2.v(dVar.g().h4.f14063h);
        b.a.r0.a3.l0.e.b().d(c2);
        b.a.r0.q1.o.h.c.g(b.a.r0.q1.o.h.c.e(dVar.g()));
        dVar.g().h4.f14064i = true;
        j.add(dVar.g().h4.f14063h);
    }

    public static void e(e eVar, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(AdIconUtil.BAIDU_LOGO_ID, null, new Object[]{eVar, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || eVar == null || eVar.f14064i || a(eVar.f14063h)) {
            return;
        }
        b.a.r0.a3.l0.c g2 = b.a.r0.a3.l0.g.g(z ? 13 : 3, i2, eVar.f14057b);
        g2.h(eVar.f14056a);
        g2.v(eVar.f14063h);
        b.a.r0.a3.l0.e.b().d(g2);
        eVar.f14064i = true;
        j.add(eVar.f14063h);
    }

    public static void f(b.a.r0.m3.j0.p pVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65543, null, pVar) == null) || pVar == null || pVar.getAdvertAppInfo() == null) {
            return;
        }
        e eVar = pVar.getAdvertAppInfo().h4;
        if (pVar.P0 || !(eVar == null || eVar.f14064i || a(eVar.f14063h))) {
            pVar.J0 = eVar.f14060e;
            pVar.K0 = eVar.f14061f;
            pVar.I0 = eVar.f14059d;
            int i2 = 3;
            if (pVar != null && pVar.L0() != null && pVar.L0().forFree()) {
                i2 = 103;
            }
            b.a.r0.a3.l0.c e2 = b.a.r0.a3.l0.g.e(pVar, i2);
            e2.v(eVar.f14063h);
            b.a.r0.a3.l0.e.b().d(e2);
            if (!pVar.P0) {
                b.a.r0.q1.o.h.c.g(b.a.r0.q1.o.h.c.e(pVar.getAdvertAppInfo()));
            }
            eVar.f14064i = true;
            j.add(eVar.f14063h);
        }
    }

    public static void g(e eVar, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65544, null, new Object[]{eVar, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || eVar == null || eVar.f14064i || a(eVar.f14063h)) {
            return;
        }
        int i3 = z ? 13 : 3;
        b.a.r0.a3.l0.c cVar = new b.a.r0.a3.l0.c();
        cVar.i(i3);
        if ("PB_BANNER".equals(eVar.f14056a)) {
            cVar.d(-1);
            cVar.x(-1);
        } else {
            cVar.d(i2);
            cVar.x(eVar.f14057b);
        }
        cVar.h(eVar.f14056a);
        cVar.e(eVar.f14060e);
        cVar.f(eVar.f14061f);
        cVar.g(eVar.f14059d);
        cVar.a("vc", eVar.f14062g);
        cVar.v(eVar.f14063h);
        b.a.r0.a3.l0.e.b().d(cVar);
        eVar.f14064i = true;
        j.add(eVar.f14063h);
    }

    public static void h(b.a.f.d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65545, null, dVar) == null) || dVar == null || dVar.i() == null || dVar.f2820i || TextUtils.isEmpty(dVar.i().f2822b) || a(dVar.i().f2822b)) {
            return;
        }
        b.a.r0.a3.l0.e.b().d(b.a.r0.a3.l0.g.a(dVar, 3, dVar.k()));
        b.a.r0.q1.o.h.c.g(dVar);
        dVar.f2820i = true;
        j.add(dVar.i().f2822b);
    }
}
