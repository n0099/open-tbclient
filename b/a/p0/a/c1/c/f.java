package b.a.p0.a.c1.c;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.z2.q0;
import b.a.p0.a.z2.v0;
import b.a.p0.q.j.a;
import b.a.p0.q.j.m.c;
import b.a.p0.u.n;
import b.a.p0.u.q;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.http.cookie.CookieManager;
import com.baidu.swan.pms.model.PMSAppInfo;
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
public class f implements b.a.p0.q.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Set f4292e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.q.k.i.k f4293f;

        /* renamed from: b.a.p0.a.c1.c.f$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0134a extends b.a.p0.a.h0.m.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ AtomicInteger f4294a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ a f4295b;

            public C0134a(a aVar, AtomicInteger atomicInteger) {
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
                this.f4295b = aVar;
                this.f4294a = atomicInteger;
            }

            @Override // b.a.p0.a.h0.m.a
            public void d() {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f4294a.get() == 0) {
                    b.a.p0.q.k.i.l.a().c(this.f4295b.f4293f);
                }
            }

            @Override // b.a.p0.a.h0.m.a
            public void f(b.a.p0.q.i.b bVar) {
                int i2;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
                    super.f(bVar);
                    if (bVar == null || (i2 = bVar.f11762a) == 1010 || i2 == 1015) {
                        return;
                    }
                    this.f4294a.incrementAndGet();
                }
            }

            @Override // b.a.p0.a.h0.m.a
            public void h() {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.f4294a.get() == 0) {
                    b.a.p0.q.k.i.l.a().c(this.f4295b.f4293f);
                }
            }
        }

        public a(f fVar, Set set, b.a.p0.q.k.i.k kVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, set, kVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4292e = set;
            this.f4293f = kVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ArrayList arrayList = new ArrayList();
                AtomicInteger atomicInteger = new AtomicInteger(0);
                for (String str : this.f4292e) {
                    if (!TextUtils.isEmpty(str)) {
                        arrayList.add(new c.a(str, 0));
                    }
                }
                if (arrayList.isEmpty()) {
                    return;
                }
                b.a.p0.a.h0.c.a.b.b(arrayList, "3", new C0134a(this, atomicInteger));
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.o2.g.b f4296e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ JSONObject f4297f;

        public b(f fVar, b.a.p0.a.o2.g.b bVar, JSONObject jSONObject) {
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
            this.f4296e = bVar;
            this.f4297f = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b.a.p0.a.p1.r.a.g().q(this.f4296e, this.f4297f);
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements b.a.p0.a.h0.j.b<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.q.i.i f4298a;

        public c(f fVar, b.a.p0.q.i.i iVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, iVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4298a = iVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.a.h0.j.b
        /* renamed from: b */
        public void a(Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bool) == null) {
                b.a.p0.a.w1.e.a.b("download plugin result = " + bool);
                b.a.p0.a.w1.f.a.b(this.f4298a.f11774g);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1483361868, "Lb/a/p0/a/c1/c/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1483361868, "Lb/a/p0/a/c1/c/f;");
                return;
            }
        }
        boolean z = b.a.p0.a.k.f6863a;
    }

    public f() {
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

    @Override // b.a.p0.q.a
    public b.a.p0.q.j.j.b A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? b.a.p0.a.c1.a.r0() : (b.a.p0.q.j.j.b) invokeV.objValue;
    }

    @Override // b.a.p0.q.a
    public int B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? b.a.p0.a.x1.a.a.t() : invokeV.intValue;
    }

    @Override // b.a.p0.q.a
    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            v0.j().l();
        }
    }

    @Override // b.a.p0.q.a
    public void D(b.a.p0.q.k.h.a aVar) {
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
            if (b.a.p0.a.d2.e.z) {
                String str = "ceres adapted config " + jSONObject;
            }
            q qVar = new q("0", jSONObject);
            qVar.e();
            n.f().o(qVar);
        } catch (JSONException e2) {
            if (b.a.p0.a.d2.e.z) {
                e2.printStackTrace();
            }
        }
    }

    @Override // b.a.p0.q.a
    public String E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? b.a.p0.a.c1.a.o().q() : (String) invokeV.objValue;
    }

    @Override // b.a.p0.q.a
    public int F(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048581, this, str, i2)) == null) {
            b.a.p0.a.c1.a.g0().getSwitch(str, i2);
            return i2;
        }
        return invokeLI.intValue;
    }

    @Override // b.a.p0.q.a
    public void G(String str, String str2, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048582, this, str, str2, th) == null) {
            b.a.p0.a.e0.d.l(str, str2, th);
        }
    }

    @Override // b.a.p0.q.a
    public void H(b.a.p0.q.k.i.k kVar) {
        Set<String> b2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, kVar) == null) || kVar == null || (b2 = kVar.b()) == null || b2.size() <= 0) {
            return;
        }
        ExecutorUtilsExt.postOnElastic(new a(this, b2, kVar), "preloadPkg", 2);
    }

    @Override // b.a.p0.q.a
    public String I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? b.a.p0.a.d0.c.m() : (String) invokeV.objValue;
    }

    @Override // b.a.p0.q.a
    public String J(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i2)) == null) ? b.a.p0.a.q2.b.h(i2) : (String) invokeI.objValue;
    }

    @Override // b.a.p0.q.a
    public void K(String str, String str2, String str3, int i2, JSONObject jSONObject, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{str, str2, str3, Integer.valueOf(i2), jSONObject, Boolean.valueOf(z)}) == null) {
            b.a.p0.a.n2.t.a.d(str, str2, str3, i2, jSONObject, z);
        }
    }

    @Override // b.a.p0.q.a
    public void L(String str, String str2, String str3, @Nullable Throwable th, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{str, str2, str3, th, Boolean.valueOf(z)}) == null) {
            b.a.p0.a.e0.d.e(str, str2, str3, th, z);
        }
    }

    @Override // b.a.p0.q.a
    public b.a.p0.q.j.g M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? b.a.p0.a.d2.d.J().M() : (b.a.p0.q.j.g) invokeV.objValue;
    }

    @Override // b.a.p0.q.a
    public float a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? b.a.p0.a.c1.a.m().a() : invokeV.floatValue;
    }

    @Override // b.a.p0.q.a
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? b.a.p0.a.l.a() : (String) invokeV.objValue;
    }

    @Override // b.a.p0.q.a
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? b.a.p0.a.c1.a.n().a() : (String) invokeV.objValue;
    }

    @Override // b.a.p0.q.a
    public void d(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, bArr) == null) {
            b.a.p0.a.c1.a.e().d(bArr);
        }
    }

    @Override // b.a.p0.q.a
    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? b.a.p0.x.b.b(AppRuntime.getAppContext()).a() : (String) invokeV.objValue;
    }

    @Override // b.a.p0.q.a
    public CookieManager f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? b.a.p0.a.c1.a.q().a() : (CookieManager) invokeV.objValue;
    }

    @Override // b.a.p0.q.a
    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? b.a.p0.a.c1.a.h0().i(AppRuntime.getAppContext()) : (String) invokeV.objValue;
    }

    @Override // b.a.p0.q.a
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? q0.D() : (String) invokeV.objValue;
    }

    @Override // b.a.p0.q.a
    public b.a.p0.w.b i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? b.a.p0.a.o2.g.h.b("swan_app_pms_sp") : (b.a.p0.w.b) invokeV.objValue;
    }

    @Override // b.a.p0.q.a
    public long j(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048598, this, i2)) == null) ? b.a.p0.a.p0.b.d(i2) : invokeI.longValue;
    }

    @Override // b.a.p0.q.a
    public void k(JSONArray jSONArray, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048599, this, jSONArray, str, str2) == null) {
            b.a.p0.a.f2.f.f0.d.b().n(jSONArray, str, str2);
        }
    }

    @Override // b.a.p0.q.a
    public List<b.a.p0.q.i.a> l(String str, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048600, this, str, j)) == null) ? b.a.p0.a.w1.c.a.e(str, j) : (List) invokeLJ.objValue;
    }

    @Override // b.a.p0.q.a
    public void m(String str, String str2, a.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048601, this, str, str2, cVar) == null) {
            b.a.p0.a.c1.a.e().f(str, str2, cVar);
        }
    }

    @Override // b.a.p0.q.a
    public b.a.p0.q.j.g n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? new b.a.p0.a.h0.m.q.c(b.a.p0.a.d2.d.J()) : (b.a.p0.q.j.g) invokeV.objValue;
    }

    @Override // b.a.p0.q.a
    public boolean o(boolean z, @NonNull JSONArray jSONArray) {
        InterceptResult invokeZL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeZL = interceptable.invokeZL(1048603, this, z, jSONArray)) == null) ? new b.a.p0.a.z2.d1.b.a(z).c(jSONArray) : invokeZL.booleanValue;
    }

    @Override // b.a.p0.q.a
    public void p(String str, JSONObject jSONObject, b.a.p0.q.i.g gVar, List<b.a.p0.q.i.h> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048604, this, str, jSONObject, gVar, list) == null) {
            b.a.p0.a.m1.d.c.g(str, jSONObject, gVar, list);
        }
    }

    @Override // b.a.p0.q.a
    public String q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? b.a.p0.a.c1.a.g0().k() : (String) invokeV.objValue;
    }

    @Override // b.a.p0.q.a
    public boolean r(@Nullable b.a.p0.q.i.i iVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048606, this, iVar)) == null) {
            File g2 = b.a.p0.a.w1.c.a.g(iVar);
            return g2 != null && g2.exists();
        }
        return invokeL.booleanValue;
    }

    @Override // b.a.p0.q.a
    public void s(PMSAppInfo pMSAppInfo, JSONObject jSONObject, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048607, this, pMSAppInfo, jSONObject, z) == null) {
            if (pMSAppInfo == null) {
                boolean z2 = b.a.p0.a.d2.e.z;
                return;
            }
            String str = pMSAppInfo.appKey;
            if (!TextUtils.isEmpty(str) && jSONObject != null) {
                int i2 = pMSAppInfo.type;
                b.a.p0.a.o2.g.b b2 = b.a.p0.a.o2.g.h.b(b.a.p0.a.o2.b.u(str, i2));
                b2.putBoolean("swan_service_update_degraded", z);
                b.a.p0.a.e0.d.k("SwanAppUpdateManager", "update async appKey = " + str + " ; type = " + i2 + " ; serviceDegraded = " + z);
                b.a.p0.a.z2.q.l(new b(this, b2, jSONObject), "parseAccreditList");
            } else if (b.a.p0.a.d2.e.z) {
                String str2 = "appKey = " + str + " is empty or accredit list is null";
            }
        }
    }

    @Override // b.a.p0.q.a
    public void t(b.a.p0.q.k.k.a aVar, b.a.p0.q.p.g gVar) {
        Collection<b.a.p0.q.i.i> collection;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048608, this, aVar, gVar) == null) || aVar == null || (collection = aVar.f11960e) == null || gVar == null) {
            return;
        }
        for (b.a.p0.q.i.i iVar : collection) {
            b.a.p0.a.w1.b.a aVar2 = new b.a.p0.a.w1.b.a(iVar.f11774g, iVar.j, iVar.f11776i, new c(this, iVar));
            b.a.p0.q.k.k.a aVar3 = new b.a.p0.q.k.k.a();
            aVar3.f11960e = new ArrayList();
            b.a.p0.q.p.g gVar2 = new b.a.p0.q.p.g();
            b.a.p0.q.k.k.b.b(iVar, gVar2);
            aVar2.G(gVar2);
            aVar3.f11960e.clear();
            aVar3.f11960e.add(iVar);
            b.a.p0.q.j.i.a.e(aVar3, aVar2);
        }
    }

    @Override // b.a.p0.q.a
    public String u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? b.a.p0.a.u1.l.d.b() : (String) invokeV.objValue;
    }

    @Override // b.a.p0.q.a
    public String v(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048610, this, i2)) == null) ? b.a.p0.a.p0.b.e(i2) : (String) invokeI.objValue;
    }

    @Override // b.a.p0.q.a
    public long w(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048611, this, i2)) == null) ? b.a.p0.a.q2.b.f(i2) : invokeI.longValue;
    }

    @Override // b.a.p0.q.a
    public boolean x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            b.a.p0.a.w1.e.a.c("线下调试需要禁用BDTLS");
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // b.a.p0.q.a
    public void y(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048613, this, str, str2) == null) {
            b.a.p0.a.e0.d.k(str, str2);
        }
    }

    @Override // b.a.p0.q.a
    public void z(String str, String str2, String str3, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048614, this, new Object[]{str, str2, str3, Boolean.valueOf(z)}) == null) {
            b.a.p0.a.e0.d.j(str, str2, str3, z);
        }
    }
}
