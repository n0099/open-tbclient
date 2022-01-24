package c.a.r0.a.n2;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.a.f1.e.b;
import c.a.r0.a.z2.q0;
import com.baidu.searchbox.datacollector.growth.utils.GrowthConstant;
import com.baidu.searchbox.ubcprocessor.UBCCloudControlProcessor;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.v8.NodeJS;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class e {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile boolean f8026b;

    /* renamed from: c  reason: collision with root package name */
    public static volatile boolean f8027c;

    /* renamed from: d  reason: collision with root package name */
    public static volatile boolean f8028d;

    /* renamed from: e  reason: collision with root package name */
    public static volatile boolean f8029e;

    /* renamed from: f  reason: collision with root package name */
    public static volatile boolean f8030f;

    /* renamed from: g  reason: collision with root package name */
    public static volatile boolean f8031g;

    /* renamed from: h  reason: collision with root package name */
    public static HashMap<String, String> f8032h;

    /* renamed from: i  reason: collision with root package name */
    public static String f8033i;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Bundle f8034e;

        public a(Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bundle};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8034e = bundle;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f8034e.remove("page_display_flag_for_statistic");
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.n2.s.f f8035e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f8036f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f8037g;

        public b(c.a.r0.a.n2.s.f fVar, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8035e = fVar;
            this.f8036f = str;
            this.f8037g = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f8035e.b(n.k(this.f8036f));
                this.f8035e.d(this.f8037g);
                n.onEvent(this.f8035e);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.n2.s.f f8038e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f8039f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f8040g;

        public c(c.a.r0.a.n2.s.f fVar, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8038e = fVar;
            this.f8039f = str;
            this.f8040g = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f8038e.d(this.f8039f);
                this.f8038e.b(n.k(this.f8040g));
                n.onEvent(this.f8038e);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.n2.s.f f8041e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f8042f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f8043g;

        public d(c.a.r0.a.n2.s.f fVar, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8041e = fVar;
            this.f8042f = str;
            this.f8043g = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f8041e.b(n.k(this.f8042f));
                this.f8041e.d(this.f8043g);
                n.onEvent(this.f8041e);
            }
        }
    }

    /* renamed from: c.a.r0.a.n2.e$e  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0488e implements c.a.r0.a.z2.g1.c<JSONObject> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.n2.s.f f8044e;

        public C0488e(c.a.r0.a.n2.s.f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8044e = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.r0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
                this.f8044e.a(GrowthConstant.UBC_VALUE_TYPE_DEVICE_INFO, jSONObject);
                n.onEvent(this.f8044e);
                c.a.r0.a.e0.d.k("SwanAppLaunchUbc", jSONObject.toString());
                c.a.r0.a.c1.a.p0().flush(false);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(431580808, "Lc/a/r0/a/n2/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(431580808, "Lc/a/r0/a/n2/e;");
                return;
            }
        }
        a = c.a.r0.a.k.a;
        f8026b = false;
        f8027c = false;
        f8028d = false;
        f8029e = false;
        f8030f = false;
        f8031g = false;
    }

    public static synchronized void A(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65537, null, z) == null) {
            synchronized (e.class) {
                f8027c = z;
            }
        }
    }

    public static synchronized void B(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65538, null, z) == null) {
            synchronized (e.class) {
                f8028d = z;
            }
        }
    }

    public static synchronized void C(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65539, null, z) == null) {
            synchronized (e.class) {
                f8026b = z;
            }
        }
    }

    public static void D(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TRACKBALL, null, z) == null) {
            f8030f = z;
        }
    }

    public static void E(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65541, null, z) == null) {
            f8029e = z;
        }
    }

    public static void F(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65542, null, str, str2) == null) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        if (f8032h == null) {
            f8032h = new HashMap<>();
        }
        f8032h.put(str, str2);
    }

    public static void G() {
        c.a.r0.a.h0.g.g V;
        c.a.r0.a.p.e.b i3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65543, null) == null) || (V = c.a.r0.a.g1.f.U().V()) == null) {
            return;
        }
        c.a.r0.a.h0.g.d m = V.m();
        if (!(m instanceof c.a.r0.a.h0.g.f) || (i3 = ((c.a.r0.a.h0.g.f) m).i3()) == null) {
            return;
        }
        f8033i = i3.c();
    }

    public static void H() {
        HybridUbcFlow d2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65544, null) == null) || (d2 = c.a.r0.a.u1.h.d(NodeJS.STARTUP_SCRIPT_NAME)) == null) {
            return;
        }
        if (d2.w() || d2.t()) {
            return;
        }
        d2.E("value", "fe_success");
    }

    public static void a(c.a.r0.a.p.e.j.d dVar) {
        c.a.r0.a.d2.e L;
        b.a V;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65545, null, dVar) == null) || f() || g() || dVar == null || (L = c.a.r0.a.d2.e.L()) == null || (V = L.V()) == null) {
            return;
        }
        boolean z = a;
        A(true);
        B(true);
        c(V, dVar.f8301b, "0", dVar.f8302c, b(dVar.f8306g), false);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static String b(String str) {
        InterceptResult invokeL;
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, str)) == null) {
            switch (str.hashCode()) {
                case 48:
                    if (str.equals("0")) {
                        c2 = 0;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 49:
                    if (str.equals("1")) {
                        c2 = 1;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 50:
                    if (str.equals("2")) {
                        c2 = 2;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 51:
                    if (str.equals("3")) {
                        c2 = 3;
                        break;
                    }
                    c2 = 65535;
                    break;
                default:
                    c2 = 65535;
                    break;
            }
            return c2 != 1 ? c2 != 2 ? c2 != 3 ? "0" : "4" : "3" : "2";
        }
        return (String) invokeL.objValue;
    }

    public static void c(b.a aVar, long j2, String str, long j3, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65547, null, new Object[]{aVar, Long.valueOf(j2), str, Long.valueOf(j3), str2, Boolean.valueOf(z)}) == null) || aVar == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        A(true);
        if (z || j2 > 0) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("valuetype", str);
            } catch (JSONException e2) {
                if (a) {
                    e2.printStackTrace();
                }
            }
            l(aVar, "arrivesuccess", j2, jSONObject);
        }
        if (z || j3 > 0) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("valuetype", str2);
            } catch (JSONException e3) {
                if (a) {
                    e3.printStackTrace();
                }
            }
            l(aVar, "fmparrsuccess", j3, jSONObject2);
        }
    }

    public static void d(@NonNull b.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, null, aVar) == null) {
            E(true);
            c.a.r0.a.n2.s.f fVar = new c.a.r0.a.n2.s.f();
            fVar.a = n.n(0);
            fVar.f8119b = "launch";
            fVar.f8122e = "narendersuccess";
            fVar.h(aVar);
            c.a.r0.a.u1.k.i.c.e().d(new d(fVar, aVar.W(), aVar.s0().getString(UBCCloudControlProcessor.UBC_KEY)), "handleNaRenderSuccess", true);
        }
    }

    public static synchronized boolean e() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) {
            synchronized (e.class) {
                z = f8026b;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public static boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) ? f8027c : invokeV.booleanValue;
    }

    public static boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) ? f8028d : invokeV.booleanValue;
    }

    public static boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65552, null)) == null) ? f8030f : invokeV.booleanValue;
    }

    public static boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65553, null)) == null) ? f8029e : invokeV.booleanValue;
    }

    public static boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65554, null)) == null) ? f8031g : invokeV.booleanValue;
    }

    public static void k(b.a aVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65555, null, aVar, str) == null) {
            l(aVar, str, System.currentTimeMillis(), null);
        }
    }

    public static void l(b.a aVar, String str, long j2, JSONObject jSONObject) {
        String H;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65556, null, new Object[]{aVar, str, Long.valueOf(j2), jSONObject}) == null) || (H = aVar.H()) == null || aVar == null) {
            return;
        }
        long j3 = 0;
        if (j2 != -1) {
            long l = aVar.l("launch_time", 0L);
            if (j2 <= 0) {
                j2 = System.currentTimeMillis();
            }
            j3 = j2 - l;
        }
        c.a.r0.a.n2.s.f fVar = new c.a.r0.a.n2.s.f();
        fVar.a = n.n(aVar.G());
        fVar.f8123f = H;
        if (c.a.r0.a.e0.f.e.e.d()) {
            fVar.f8120c = "remote-debug";
        } else if (c.a.r0.a.x1.a.a.D()) {
            fVar.f8120c = "local-debug";
        } else {
            fVar.f8120c = aVar.T();
        }
        fVar.f8119b = "launch";
        fVar.f8122e = str;
        fVar.a("arrivetime", String.valueOf(j3));
        if (jSONObject != null) {
            fVar.e(jSONObject);
        }
        Bundle P = aVar.P();
        if (P != null) {
            fVar.d(P.getString(UBCCloudControlProcessor.UBC_KEY));
        }
        fVar.b(n.k(aVar.W()));
        if (a) {
            StringBuilder sb = new StringBuilder();
            sb.append("handle record arrival event, arrivalValue ");
            sb.append(str);
            sb.append(" arrive time : ");
            sb.append(j3);
            sb.append(" extJson :");
            sb.append(jSONObject == null ? "" : jSONObject.toString());
            sb.toString();
        }
        n.onEvent(fVar);
    }

    public static void m(@NonNull c.a.r0.a.f1.e.b bVar, int i2, @NonNull c.a.r0.a.u2.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65557, null, bVar, i2, aVar) == null) {
            c.a.r0.a.n2.s.f fVar = new c.a.r0.a.n2.s.f();
            fVar.a = n.n(i2);
            fVar.f8119b = "launch";
            fVar.f8122e = com.baidu.pass.biometrics.face.liveness.b.a.g0;
            fVar.a("errcode", String.valueOf(aVar.a()));
            fVar.a("msg", aVar.g().toString());
            fVar.h(bVar);
            fVar.d(bVar.s0().getString(UBCCloudControlProcessor.UBC_KEY));
            fVar.b(n.k(bVar.W()));
            c.a.r0.a.z2.m.d(bVar, new C0488e(fVar));
        }
    }

    public static void n(c.a.r0.a.n2.s.f fVar, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65558, null, fVar, str, str2) == null) {
            c.a.r0.a.u1.k.i.c.e().d(new c(fVar, str2, str), "onLaunchSuccessUBC", true);
        }
    }

    public static void o(b.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65559, null, aVar) == null) || aVar == null || f8030f) {
            return;
        }
        D(true);
        k(aVar, "naarrsuccess");
    }

    public static void p(b.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65560, null, aVar) == null) {
            boolean z = a;
            c.a.r0.a.n1.g.e(f8033i);
            if (!i()) {
                d(aVar);
            }
            if (f() || g()) {
                return;
            }
            c(aVar, -1L, "1", -1L, "1", true);
        }
    }

    public static void q(b.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65561, null, aVar) == null) || aVar == null || g()) {
            return;
        }
        B(true);
        k(aVar, "arrivecancel");
    }

    public static void r() {
        c.a.r0.a.d2.e L;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65562, null) == null) || (L = c.a.r0.a.d2.e.L()) == null) {
            return;
        }
        s(L.V());
    }

    public static void s(c.a.r0.a.f1.e.b bVar) {
        Bundle P;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65563, null, bVar) == null) || bVar == null || !e() || (P = bVar.P()) == null) {
            return;
        }
        long j2 = P.getLong("page_display_flag_for_statistic");
        long l = bVar.l("launch_time", 0L);
        long currentTimeMillis = System.currentTimeMillis();
        if (j2 > 0) {
            c.a.r0.a.n2.s.f fVar = new c.a.r0.a.n2.s.f();
            fVar.a = n.n(bVar.G());
            fVar.f8123f = bVar.H();
            fVar.f8120c = bVar.T();
            fVar.f8119b = "launch";
            fVar.f8122e = "realsuccess";
            fVar.r = String.valueOf(currentTimeMillis - l);
            fVar.d(P.getString(UBCCloudControlProcessor.UBC_KEY));
            n.onEvent(fVar);
            q0.e0(new a(P));
            H();
        }
    }

    public static void t(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65564, null, str) == null) && f8031g) {
            c.a.r0.a.n1.g.e(str);
            f8031g = false;
        }
    }

    public static void u(String str, b.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65565, null, str, aVar) == null) {
            HashMap<String, String> hashMap = f8032h;
            String str2 = hashMap != null ? hashMap.get(f8033i) : "";
            if (a) {
                StringBuilder sb = new StringBuilder();
                sb.append("handle relaunch , launchPage : ");
                sb.append(str);
                sb.append(" lastSlavePath ：");
                sb.append(str2 != null ? str2 : "");
                sb.toString();
            }
            if (TextUtils.equals(str, str2)) {
                p(aVar);
                return;
            }
            x();
            f8031g = true;
        }
    }

    public static void v(@NonNull c.a.r0.a.f1.e.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65566, null, bVar) == null) {
            c.a.r0.a.n2.s.f fVar = new c.a.r0.a.n2.s.f();
            fVar.a = n.n(0);
            fVar.f8123f = bVar.H();
            fVar.f8120c = bVar.T();
            fVar.f8119b = "show";
            c.a.r0.a.u1.k.i.c.e().d(new b(fVar, bVar.W(), bVar.s0().getString(UBCCloudControlProcessor.UBC_KEY)), "onShow606", true);
        }
    }

    public static void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65567, null) == null) {
            B(false);
        }
    }

    public static void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65568, null) == null) {
            A(false);
        }
    }

    public static void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65569, null) == null) {
            C(false);
        }
    }

    public static void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65570, null) == null) {
            y();
            D(false);
            x();
            w();
            E(false);
        }
    }
}
