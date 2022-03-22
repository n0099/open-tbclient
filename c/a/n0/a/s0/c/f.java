package c.a.n0.a.s0.c;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.n0.a.p2.q0;
import c.a.n0.a.p2.v0;
import c.a.n0.q.i.a;
import c.a.n0.q.i.m.c;
import c.a.n0.u.n;
import c.a.n0.u.q;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.http.cookie.CookieManager;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.swan.pms.node.Node;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
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
public class f implements c.a.n0.q.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Set a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.q.j.i.k f6152b;

        /* renamed from: c.a.n0.a.s0.c.f$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0445a extends c.a.n0.a.x.m.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ AtomicInteger a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ a f6153b;

            public C0445a(a aVar, AtomicInteger atomicInteger) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, atomicInteger};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f6153b = aVar;
                this.a = atomicInteger;
            }

            @Override // c.a.n0.a.x.m.a
            public void d() {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.get() == 0) {
                    c.a.n0.q.j.i.l.a().c(this.f6153b.f6152b);
                }
            }

            @Override // c.a.n0.a.x.m.a
            public void f(c.a.n0.q.h.b bVar) {
                int i;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
                    super.f(bVar);
                    if (bVar == null || (i = bVar.a) == 1010 || i == 1015) {
                        return;
                    }
                    this.a.incrementAndGet();
                }
            }

            @Override // c.a.n0.a.x.m.a
            public void h() {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.a.get() == 0) {
                    c.a.n0.q.j.i.l.a().c(this.f6153b.f6152b);
                }
            }
        }

        public a(f fVar, Set set, c.a.n0.q.j.i.k kVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, set, kVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = set;
            this.f6152b = kVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ArrayList arrayList = new ArrayList();
                AtomicInteger atomicInteger = new AtomicInteger(0);
                for (String str : this.a) {
                    if (!TextUtils.isEmpty(str)) {
                        arrayList.add(new c.a(str, 0));
                    }
                }
                if (arrayList.isEmpty()) {
                    return;
                }
                c.a.n0.a.x.c.a.b.b(arrayList, "3", new C0445a(this, atomicInteger));
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.n0.a.e2.g.b a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ JSONObject f6154b;

        public b(f fVar, c.a.n0.a.e2.g.b bVar, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, bVar, jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
            this.f6154b = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.n0.a.f1.r.a.g().q(this.a, this.f6154b);
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements c.a.n0.a.x.j.b<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.n0.q.h.i a;

        public c(f fVar, c.a.n0.q.h.i iVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, iVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = iVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.n0.a.x.j.b
        /* renamed from: b */
        public void a(Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bool) == null) {
                c.a.n0.a.m1.e.a.b("download plugin result = " + bool);
                c.a.n0.a.m1.f.a.b(this.a.f9145g);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2001190110, "Lc/a/n0/a/s0/c/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2001190110, "Lc/a/n0/a/s0/c/f;");
                return;
            }
        }
        boolean z = c.a.n0.a.a.a;
    }

    public f() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @Override // c.a.n0.q.a
    public c.a.n0.q.i.j.b A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? c.a.n0.a.s0.a.r0() : (c.a.n0.q.i.j.b) invokeV.objValue;
    }

    @Override // c.a.n0.q.a
    public int B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? c.a.n0.a.n1.a.a.t() : invokeV.intValue;
    }

    @Override // c.a.n0.q.a
    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            v0.j().l();
        }
    }

    @Override // c.a.n0.q.a
    public void D(c.a.n0.q.j.h.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) || aVar == null) {
            return;
        }
        try {
            JSONObject b2 = aVar.b();
            JSONArray a2 = aVar.a();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("threshold", b2.optInt("threshold"));
            jSONObject.put("timeup", b2.optInt("timeup"));
            jSONObject.put("item", a2.toString());
            if (c.a.n0.a.t1.e.v) {
                Log.d(Node.TAG, "ceres adapted config " + jSONObject);
            }
            q qVar = new q("0", jSONObject);
            qVar.e();
            n.f().o(qVar);
        } catch (JSONException e2) {
            if (c.a.n0.a.t1.e.v) {
                e2.printStackTrace();
            }
        }
    }

    @Override // c.a.n0.q.a
    public String E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? c.a.n0.a.s0.a.o().q() : (String) invokeV.objValue;
    }

    @Override // c.a.n0.q.a
    public int F(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048581, this, str, i)) == null) {
            c.a.n0.a.s0.a.g0().getSwitch(str, i);
            return i;
        }
        return invokeLI.intValue;
    }

    @Override // c.a.n0.q.a
    public void G(String str, String str2, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048582, this, str, str2, th) == null) {
            c.a.n0.a.u.d.l(str, str2, th);
        }
    }

    @Override // c.a.n0.q.a
    public void H(c.a.n0.q.j.i.k kVar) {
        Set<String> b2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, kVar) == null) || kVar == null || (b2 = kVar.b()) == null || b2.size() <= 0) {
            return;
        }
        ExecutorUtilsExt.postOnElastic(new a(this, b2, kVar), "preloadPkg", 2);
    }

    @Override // c.a.n0.q.a
    public String I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? c.a.n0.a.t.c.m() : (String) invokeV.objValue;
    }

    @Override // c.a.n0.q.a
    public String J(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i)) == null) ? c.a.n0.a.g2.b.h(i) : (String) invokeI.objValue;
    }

    @Override // c.a.n0.q.a
    public void K(String str, String str2, String str3, int i, JSONObject jSONObject, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{str, str2, str3, Integer.valueOf(i), jSONObject, Boolean.valueOf(z)}) == null) {
            c.a.n0.a.d2.t.a.d(str, str2, str3, i, jSONObject, z);
        }
    }

    @Override // c.a.n0.q.a
    public void L(String str, String str2, String str3, @Nullable Throwable th, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{str, str2, str3, th, Boolean.valueOf(z)}) == null) {
            c.a.n0.a.u.d.e(str, str2, str3, th, z);
        }
    }

    @Override // c.a.n0.q.a
    public c.a.n0.q.i.g M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? c.a.n0.a.t1.d.J().M() : (c.a.n0.q.i.g) invokeV.objValue;
    }

    @Override // c.a.n0.q.a
    public float a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? c.a.n0.a.s0.a.m().a() : invokeV.floatValue;
    }

    @Override // c.a.n0.q.a
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? c.a.n0.a.b.a() : (String) invokeV.objValue;
    }

    @Override // c.a.n0.q.a
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? c.a.n0.a.s0.a.n().a() : (String) invokeV.objValue;
    }

    @Override // c.a.n0.q.a
    public void d(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, bArr) == null) {
            c.a.n0.a.s0.a.e().d(bArr);
        }
    }

    @Override // c.a.n0.q.a
    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? c.a.n0.x.b.b(AppRuntime.getAppContext()).a() : (String) invokeV.objValue;
    }

    @Override // c.a.n0.q.a
    public CookieManager f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? c.a.n0.a.s0.a.q().a() : (CookieManager) invokeV.objValue;
    }

    @Override // c.a.n0.q.a
    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? c.a.n0.a.s0.a.h0().i(AppRuntime.getAppContext()) : (String) invokeV.objValue;
    }

    @Override // c.a.n0.q.a
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? q0.D() : (String) invokeV.objValue;
    }

    @Override // c.a.n0.q.a
    public c.a.n0.w.b i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? c.a.n0.a.e2.g.h.b("swan_app_pms_sp") : (c.a.n0.w.b) invokeV.objValue;
    }

    @Override // c.a.n0.q.a
    public long j(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048598, this, i)) == null) ? c.a.n0.a.f0.b.d(i) : invokeI.longValue;
    }

    @Override // c.a.n0.q.a
    public void k(JSONArray jSONArray, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048599, this, jSONArray, str, str2) == null) {
            c.a.n0.a.v1.f.f0.d.b().n(jSONArray, str, str2);
        }
    }

    @Override // c.a.n0.q.a
    public List<c.a.n0.q.h.a> l(String str, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048600, this, str, j)) == null) ? c.a.n0.a.m1.c.a.e(str, j) : (List) invokeLJ.objValue;
    }

    @Override // c.a.n0.q.a
    public void m(String str, String str2, a.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048601, this, str, str2, cVar) == null) {
            c.a.n0.a.s0.a.e().f(str, str2, cVar);
        }
    }

    @Override // c.a.n0.q.a
    public c.a.n0.q.i.g n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? new c.a.n0.a.x.m.q.c(c.a.n0.a.t1.d.J()) : (c.a.n0.q.i.g) invokeV.objValue;
    }

    @Override // c.a.n0.q.a
    public boolean o(boolean z, @NonNull JSONArray jSONArray) {
        InterceptResult invokeZL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeZL = interceptable.invokeZL(1048603, this, z, jSONArray)) == null) ? new c.a.n0.a.p2.d1.b.a(z).c(jSONArray) : invokeZL.booleanValue;
    }

    @Override // c.a.n0.q.a
    public void p(String str, JSONObject jSONObject, c.a.n0.q.h.g gVar, List<c.a.n0.q.h.h> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048604, this, str, jSONObject, gVar, list) == null) {
            c.a.n0.a.c1.d.c.g(str, jSONObject, gVar, list);
        }
    }

    @Override // c.a.n0.q.a
    public String q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? c.a.n0.a.s0.a.g0().k() : (String) invokeV.objValue;
    }

    @Override // c.a.n0.q.a
    public boolean r(@Nullable c.a.n0.q.h.i iVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048606, this, iVar)) == null) {
            File g2 = c.a.n0.a.m1.c.a.g(iVar);
            return g2 != null && g2.exists();
        }
        return invokeL.booleanValue;
    }

    @Override // c.a.n0.q.a
    public void s(PMSAppInfo pMSAppInfo, JSONObject jSONObject, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048607, this, pMSAppInfo, jSONObject, z) == null) {
            if (pMSAppInfo == null) {
                if (c.a.n0.a.t1.e.v) {
                    Log.e("SwanAppUpdateManager", "pms app info is null");
                    return;
                }
                return;
            }
            String str = pMSAppInfo.appKey;
            if (!TextUtils.isEmpty(str) && jSONObject != null) {
                int i = pMSAppInfo.type;
                c.a.n0.a.e2.g.b b2 = c.a.n0.a.e2.g.h.b(c.a.n0.a.e2.b.u(str, i));
                b2.putBoolean("swan_service_update_degraded", z);
                c.a.n0.a.u.d.k("SwanAppUpdateManager", "update async appKey = " + str + " ; type = " + i + " ; serviceDegraded = " + z);
                c.a.n0.a.p2.q.l(new b(this, b2, jSONObject), "parseAccreditList");
            } else if (c.a.n0.a.t1.e.v) {
                Log.e("SwanAppUpdateManager", "appKey = " + str + " is empty or accredit list is null");
            }
        }
    }

    @Override // c.a.n0.q.a
    public void t(c.a.n0.q.j.k.a aVar, c.a.n0.q.o.g gVar) {
        Collection<c.a.n0.q.h.i> collection;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048608, this, aVar, gVar) == null) || aVar == null || (collection = aVar.f9273e) == null || gVar == null) {
            return;
        }
        for (c.a.n0.q.h.i iVar : collection) {
            c.a.n0.a.m1.b.a aVar2 = new c.a.n0.a.m1.b.a(iVar.f9145g, iVar.j, iVar.i, new c(this, iVar));
            c.a.n0.q.j.k.a aVar3 = new c.a.n0.q.j.k.a();
            aVar3.f9273e = new ArrayList();
            c.a.n0.q.o.g gVar2 = new c.a.n0.q.o.g();
            c.a.n0.q.j.k.b.b(iVar, gVar2);
            aVar2.H(gVar2);
            aVar3.f9273e.clear();
            aVar3.f9273e.add(iVar);
            c.a.n0.q.i.i.a.e(aVar3, aVar2);
        }
    }

    @Override // c.a.n0.q.a
    public String u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? c.a.n0.a.k1.l.d.b() : (String) invokeV.objValue;
    }

    @Override // c.a.n0.q.a
    public String v(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048610, this, i)) == null) ? c.a.n0.a.f0.b.e(i) : (String) invokeI.objValue;
    }

    @Override // c.a.n0.q.a
    public long w(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048611, this, i)) == null) ? c.a.n0.a.g2.b.f(i) : invokeI.longValue;
    }

    @Override // c.a.n0.q.a
    public boolean x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            c.a.n0.a.m1.e.a.c("线下调试需要禁用BDTLS");
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.n0.q.a
    public void y(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048613, this, str, str2) == null) {
            c.a.n0.a.u.d.k(str, str2);
        }
    }

    @Override // c.a.n0.q.a
    public void z(String str, String str2, String str3, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048614, this, new Object[]{str, str2, str3, Boolean.valueOf(z)}) == null) {
            c.a.n0.a.u.d.j(str, str2, str3, z);
        }
    }
}
