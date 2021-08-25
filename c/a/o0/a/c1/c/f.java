package c.a.o0.a.c1.c;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.o0.a.l;
import c.a.o0.a.v2.q0;
import c.a.o0.a.v2.u0;
import c.a.o0.n.i.a;
import c.a.o0.n.i.m.b;
import c.a.o0.r.n;
import c.a.o0.r.q;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.http.cookie.CookieManager;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
@Singleton
@Service
/* loaded from: classes.dex */
public class f implements c.a.o0.n.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Set f4725e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.n.j.i.j f4726f;

        /* renamed from: c.a.o0.a.c1.c.f$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0129a extends c.a.o0.a.h0.m.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ AtomicInteger f4727a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ a f4728b;

            public C0129a(a aVar, AtomicInteger atomicInteger) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, atomicInteger};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f4728b = aVar;
                this.f4727a = atomicInteger;
            }

            @Override // c.a.o0.a.h0.m.a
            public void d() {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f4727a.get() == 0) {
                    c.a.o0.n.j.i.k.a().c(this.f4728b.f4726f);
                }
            }

            @Override // c.a.o0.a.h0.m.a
            public void e(c.a.o0.n.h.a aVar) {
                int i2;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                    super.e(aVar);
                    if (aVar == null || (i2 = aVar.f11847a) == 1010 || i2 == 1015) {
                        return;
                    }
                    this.f4727a.incrementAndGet();
                }
            }

            @Override // c.a.o0.a.h0.m.a
            public void g() {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.f4727a.get() == 0) {
                    c.a.o0.n.j.i.k.a().c(this.f4728b.f4726f);
                }
            }
        }

        public a(f fVar, Set set, c.a.o0.n.j.i.j jVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, set, jVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4725e = set;
            this.f4726f = jVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ArrayList arrayList = new ArrayList();
                AtomicInteger atomicInteger = new AtomicInteger(0);
                for (String str : this.f4725e) {
                    if (!TextUtils.isEmpty(str)) {
                        arrayList.add(new b.a(str, 0));
                    }
                }
                if (arrayList.isEmpty()) {
                    return;
                }
                c.a.o0.a.h0.c.a.b.b(arrayList, "3", new C0129a(this, atomicInteger));
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.a.k2.g.b f4729e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ JSONObject f4730f;

        public b(f fVar, c.a.o0.a.k2.g.b bVar, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, bVar, jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4729e = bVar;
            this.f4730f = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.o0.a.n1.q.a.g().q(this.f4729e, this.f4730f);
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements c.a.o0.a.h0.j.b<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.n.h.h f4731a;

        public c(f fVar, c.a.o0.n.h.h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4731a = hVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.o0.a.h0.j.b
        /* renamed from: b */
        public void a(Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bool) == null) {
                c.a.o0.a.t1.d.a.a("download plugin result = " + bool);
                c.a.o0.a.t1.e.a.b(this.f4731a.f11857g);
            }
        }
    }

    public f() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // c.a.o0.n.a
    public void A(c.a.o0.n.j.h.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || aVar == null) {
            return;
        }
        try {
            JSONObject b2 = aVar.b();
            JSONArray a2 = aVar.a();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("threshold", b2.optInt("threshold"));
            jSONObject.put("timeup", b2.optInt("timeup"));
            jSONObject.put("item", a2.toString());
            if (c.a.o0.a.a2.e.y) {
                String str = "ceres adapted config " + jSONObject;
            }
            q qVar = new q("0", jSONObject);
            qVar.e();
            n.f().o(qVar);
        } catch (JSONException e2) {
            if (c.a.o0.a.a2.e.y) {
                e2.printStackTrace();
            }
        }
    }

    @Override // c.a.o0.n.a
    public String B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? c.a.o0.a.c1.a.n().p() : (String) invokeV.objValue;
    }

    @Override // c.a.o0.n.a
    public int C(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, str, i2)) == null) {
            c.a.o0.a.c1.a.Z().getSwitch(str, i2);
            return i2;
        }
        return invokeLI.intValue;
    }

    @Override // c.a.o0.n.a
    public void D(c.a.o0.n.j.i.j jVar) {
        Set<String> b2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, jVar) == null) || jVar == null || (b2 = jVar.b()) == null || b2.size() <= 0) {
            return;
        }
        ExecutorUtilsExt.postOnElastic(new a(this, b2, jVar), "preloadPkg", 2);
    }

    @Override // c.a.o0.n.a
    public String E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? c.a.o0.a.d0.c.m() : (String) invokeV.objValue;
    }

    @Override // c.a.o0.n.a
    public String F(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) ? c.a.o0.a.m2.b.h(i2) : (String) invokeI.objValue;
    }

    @Override // c.a.o0.n.a
    public void G(String str, String str2, String str3, int i2, JSONObject jSONObject, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{str, str2, str3, Integer.valueOf(i2), jSONObject, Boolean.valueOf(z)}) == null) {
            c.a.o0.a.j2.q.a.d(str, str2, str3, i2, jSONObject, z);
        }
    }

    @Override // c.a.o0.n.a
    public c.a.o0.n.i.g H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? c.a.o0.a.a2.d.g().j() : (c.a.o0.n.i.g) invokeV.objValue;
    }

    @Override // c.a.o0.n.a
    public boolean I(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, z)) == null) {
            c.a.o0.a.c1.a.Z().getSwitch(str, z);
            return z;
        }
        return invokeLZ.booleanValue;
    }

    @Override // c.a.o0.n.a
    public float a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? c.a.o0.a.c1.a.l().a() : invokeV.floatValue;
    }

    @Override // c.a.o0.n.a
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? l.a() : (String) invokeV.objValue;
    }

    @Override // c.a.o0.n.a
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? c.a.o0.a.c1.a.m().a() : (String) invokeV.objValue;
    }

    @Override // c.a.o0.n.a
    public void d(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, bArr) == null) {
            c.a.o0.a.c1.a.d().d(bArr);
        }
    }

    @Override // c.a.o0.n.a
    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? c.a.o0.u.b.b(AppRuntime.getAppContext()).a() : (String) invokeV.objValue;
    }

    @Override // c.a.o0.n.a
    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? c.a.o0.a.c1.a.w().f() : invokeV.booleanValue;
    }

    @Override // c.a.o0.n.a
    public CookieManager g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? c.a.o0.a.c1.a.p().a() : (CookieManager) invokeV.objValue;
    }

    @Override // c.a.o0.n.a
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? c.a.o0.a.c1.a.a0().i(AppRuntime.getAppContext()) : (String) invokeV.objValue;
    }

    @Override // c.a.o0.n.a
    public String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? q0.D() : (String) invokeV.objValue;
    }

    @Override // c.a.o0.n.a
    public boolean isDebug() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? c.a.o0.a.k.f7049a : invokeV.booleanValue;
    }

    @Override // c.a.o0.n.a
    public c.a.o0.t.b j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? c.a.o0.a.k2.g.h.b("swan_app_pms_sp") : (c.a.o0.t.b) invokeV.objValue;
    }

    @Override // c.a.o0.n.a
    public long k(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048596, this, i2)) == null) ? c.a.o0.a.p0.b.d(i2) : invokeI.longValue;
    }

    @Override // c.a.o0.n.a
    public void l(JSONArray jSONArray, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048597, this, jSONArray, str, str2) == null) {
            c.a.o0.a.c2.f.g0.d.b().n(jSONArray, str, str2);
        }
    }

    @Override // c.a.o0.n.a
    public void m(String str, String str2, a.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048598, this, str, str2, cVar) == null) {
            c.a.o0.a.c1.a.d().f(str, str2, cVar);
        }
    }

    @Override // c.a.o0.n.a
    public c.a.o0.n.i.g n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? new c.a.o0.a.h0.m.n.c(c.a.o0.a.a2.d.g()) : (c.a.o0.n.i.g) invokeV.objValue;
    }

    @Override // c.a.o0.n.a
    public boolean o(boolean z, @NonNull JSONArray jSONArray) {
        InterceptResult invokeZL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeZL = interceptable.invokeZL(1048600, this, z, jSONArray)) == null) ? new c.a.o0.a.v2.b1.b.a(z).c(jSONArray) : invokeZL.booleanValue;
    }

    @Override // c.a.o0.n.a
    public void p(String str, JSONObject jSONObject, c.a.o0.n.h.f fVar, List<c.a.o0.n.h.g> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048601, this, str, jSONObject, fVar, list) == null) {
            c.a.o0.a.l1.d.c.g(str, jSONObject, fVar, list);
        }
    }

    @Override // c.a.o0.n.a
    public String q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? c.a.o0.a.c1.a.Z().k() : (String) invokeV.objValue;
    }

    @Override // c.a.o0.n.a
    public void r(PMSAppInfo pMSAppInfo, JSONObject jSONObject, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048603, this, pMSAppInfo, jSONObject, z) == null) {
            if (pMSAppInfo == null) {
                boolean z2 = c.a.o0.a.a2.e.y;
                return;
            }
            String str = pMSAppInfo.appKey;
            if (!TextUtils.isEmpty(str) && jSONObject != null) {
                int i2 = pMSAppInfo.type;
                c.a.o0.a.k2.g.b b2 = c.a.o0.a.k2.g.h.b(c.a.o0.a.k2.b.u(str, i2));
                b2.putBoolean("swan_service_update_degraded", z);
                c.a.o0.a.e0.d.h("SwanAppUpdateManager", "update async appKey = " + str + " ; type = " + i2 + " ; serviceDegraded = " + z);
                c.a.o0.a.v2.q.k(new b(this, b2, jSONObject), "parseAccreditList");
            } else if (c.a.o0.a.a2.e.y) {
                String str2 = "appKey = " + str + " is empty or accredit list is null";
            }
        }
    }

    @Override // c.a.o0.n.a
    public void s(c.a.o0.n.j.k.a aVar, c.a.o0.n.o.f fVar) {
        Collection<c.a.o0.n.h.h> collection;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048604, this, aVar, fVar) == null) || aVar == null || (collection = aVar.f12024e) == null || fVar == null) {
            return;
        }
        for (c.a.o0.n.h.h hVar : collection) {
            c.a.o0.a.t1.a.a aVar2 = new c.a.o0.a.t1.a.a(hVar.f11857g, hVar.f11860j, hVar.f11859i, new c(this, hVar));
            c.a.o0.n.j.k.a aVar3 = new c.a.o0.n.j.k.a();
            aVar3.f12024e = new ArrayList();
            c.a.o0.n.o.f fVar2 = new c.a.o0.n.o.f();
            c.a.o0.n.j.k.b.b(hVar, fVar2);
            aVar2.F(fVar2);
            aVar3.f12024e.clear();
            aVar3.f12024e.add(hVar);
            c.a.o0.n.i.i.a.e(aVar3, aVar2);
        }
    }

    @Override // c.a.o0.n.a
    public String t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? c.a.o0.a.r1.l.d.a() : (String) invokeV.objValue;
    }

    @Override // c.a.o0.n.a
    public String u(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048606, this, i2)) == null) ? c.a.o0.a.p0.b.e(i2) : (String) invokeI.objValue;
    }

    @Override // c.a.o0.n.a
    public String v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? ProcessUtils.getCurProcessName() : (String) invokeV.objValue;
    }

    @Override // c.a.o0.n.a
    public long w(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048608, this, i2)) == null) ? c.a.o0.a.m2.b.f(i2) : invokeI.longValue;
    }

    @Override // c.a.o0.n.a
    public void x(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048609, this, str, str2) == null) {
            c.a.o0.a.e0.d.h(str, str2);
        }
    }

    @Override // c.a.o0.n.a
    public c.a.o0.n.i.j.b y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? c.a.o0.a.c1.a.i0() : (c.a.o0.n.i.j.b) invokeV.objValue;
    }

    @Override // c.a.o0.n.a
    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            u0.j().l();
        }
    }
}
