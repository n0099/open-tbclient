package b.a.p0.a.j2;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.f1.e.b;
import b.a.p0.a.v2.q0;
import com.baidu.mobads.container.util.AdIconUtil;
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
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class e {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f6301a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile boolean f6302b;

    /* renamed from: c  reason: collision with root package name */
    public static volatile boolean f6303c;

    /* renamed from: d  reason: collision with root package name */
    public static volatile boolean f6304d;

    /* renamed from: e  reason: collision with root package name */
    public static volatile boolean f6305e;

    /* renamed from: f  reason: collision with root package name */
    public static volatile boolean f6306f;

    /* renamed from: g  reason: collision with root package name */
    public static volatile boolean f6307g;

    /* renamed from: h  reason: collision with root package name */
    public static HashMap<String, String> f6308h;

    /* renamed from: i  reason: collision with root package name */
    public static String f6309i;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Bundle f6310e;

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
            this.f6310e = bundle;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f6310e.remove("page_display_flag_for_statistic");
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.j2.p.f f6311e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f6312f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f6313g;

        public b(b.a.p0.a.j2.p.f fVar, String str, String str2) {
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
            this.f6311e = fVar;
            this.f6312f = str;
            this.f6313g = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f6311e.b(k.k(this.f6312f));
                this.f6311e.d(this.f6313g);
                k.onEvent(this.f6311e);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.j2.p.f f6314e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f6315f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f6316g;

        public c(b.a.p0.a.j2.p.f fVar, String str, String str2) {
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
            this.f6314e = fVar;
            this.f6315f = str;
            this.f6316g = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f6314e.d(this.f6315f);
                this.f6314e.b(k.k(this.f6316g));
                k.onEvent(this.f6314e);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.j2.p.f f6317e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f6318f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f6319g;

        public d(b.a.p0.a.j2.p.f fVar, String str, String str2) {
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
            this.f6317e = fVar;
            this.f6318f = str;
            this.f6319g = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f6317e.b(k.k(this.f6318f));
                this.f6317e.d(this.f6319g);
                k.onEvent(this.f6317e);
            }
        }
    }

    /* renamed from: b.a.p0.a.j2.e$e  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0270e implements b.a.p0.a.v2.e1.b<JSONObject> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.j2.p.f f6320e;

        public C0270e(b.a.p0.a.j2.p.f fVar) {
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
            this.f6320e = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
                this.f6320e.a(GrowthConstant.UBC_VALUE_TYPE_DEVICE_INFO, jSONObject);
                k.onEvent(this.f6320e);
                b.a.p0.a.e0.d.h("SwanAppLaunchUbc", jSONObject.toString());
                b.a.p0.a.c1.a.g0().flush(false);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1326472359, "Lb/a/p0/a/j2/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1326472359, "Lb/a/p0/a/j2/e;");
                return;
            }
        }
        f6301a = b.a.p0.a.k.f6397a;
        f6302b = false;
        f6303c = false;
        f6304d = false;
        f6305e = false;
        f6306f = false;
        f6307g = false;
    }

    public static synchronized void A(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65537, null, z) == null) {
            synchronized (e.class) {
                f6303c = z;
            }
        }
    }

    public static synchronized void B(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65538, null, z) == null) {
            synchronized (e.class) {
                f6304d = z;
            }
        }
    }

    public static synchronized void C(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65539, null, z) == null) {
            synchronized (e.class) {
                f6302b = z;
            }
        }
    }

    public static void D(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TRACKBALL, null, z) == null) {
            f6306f = z;
        }
    }

    public static void E(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(AdIconUtil.AD_TEXT_ID, null, z) == null) {
            f6305e = z;
        }
    }

    public static void F(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, str, str2) == null) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        if (f6308h == null) {
            f6308h = new HashMap<>();
        }
        f6308h.put(str, str2);
    }

    public static void G() {
        b.a.p0.a.h0.g.g U;
        b.a.p0.a.p.e.b V2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65543, null) == null) || (U = b.a.p0.a.g1.f.T().U()) == null) {
            return;
        }
        b.a.p0.a.h0.g.d m = U.m();
        if (!(m instanceof b.a.p0.a.h0.g.f) || (V2 = ((b.a.p0.a.h0.g.f) m).V2()) == null) {
            return;
        }
        f6309i = V2.b();
    }

    public static void H() {
        HybridUbcFlow d2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65544, null) == null) || (d2 = b.a.p0.a.r1.h.d("startup")) == null) {
            return;
        }
        if (d2.t() || d2.r()) {
            return;
        }
        d2.B("value", "fe_success");
    }

    public static void a(b.a.p0.a.p.e.j.d dVar) {
        b.a.p0.a.a2.e i2;
        b.a K;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65545, null, dVar) == null) || f() || g() || dVar == null || (i2 = b.a.p0.a.a2.e.i()) == null || (K = i2.K()) == null) {
            return;
        }
        boolean z = f6301a;
        A(true);
        B(true);
        c(K, dVar.f7193b, "0", dVar.f7194c, b(dVar.f7198g), false);
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

    public static void c(b.a aVar, long j, String str, long j2, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65547, null, new Object[]{aVar, Long.valueOf(j), str, Long.valueOf(j2), str2, Boolean.valueOf(z)}) == null) || aVar == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        A(true);
        if (z || j > 0) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("valuetype", str);
            } catch (JSONException e2) {
                if (f6301a) {
                    e2.printStackTrace();
                }
            }
            l(aVar, "arrivesuccess", j, jSONObject);
        }
        if (z || j2 > 0) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("valuetype", str2);
            } catch (JSONException e3) {
                if (f6301a) {
                    e3.printStackTrace();
                }
            }
            l(aVar, "fmparrsuccess", j2, jSONObject2);
        }
    }

    public static void d(@NonNull b.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, null, aVar) == null) {
            E(true);
            b.a.p0.a.j2.p.f fVar = new b.a.p0.a.j2.p.f();
            fVar.f6383a = k.m(0);
            fVar.f6384b = "launch";
            fVar.f6387e = "narendersuccess";
            fVar.h(aVar);
            b.a.p0.a.r1.k.i.c.f().e(new d(fVar, aVar.V(), aVar.q0().getString(UBCCloudControlProcessor.UBC_KEY)), "handleNaRenderSuccess");
        }
    }

    public static synchronized boolean e() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) {
            synchronized (e.class) {
                z = f6302b;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public static boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) ? f6303c : invokeV.booleanValue;
    }

    public static boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) ? f6304d : invokeV.booleanValue;
    }

    public static boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65552, null)) == null) ? f6306f : invokeV.booleanValue;
    }

    public static boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65553, null)) == null) ? f6305e : invokeV.booleanValue;
    }

    public static boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65554, null)) == null) ? f6307g : invokeV.booleanValue;
    }

    public static void k(b.a aVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65555, null, aVar, str) == null) {
            l(aVar, str, System.currentTimeMillis(), null);
        }
    }

    public static void l(b.a aVar, String str, long j, JSONObject jSONObject) {
        String G;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65556, null, new Object[]{aVar, str, Long.valueOf(j), jSONObject}) == null) || (G = aVar.G()) == null || aVar == null) {
            return;
        }
        long j2 = 0;
        if (j != -1) {
            long l = aVar.l("launch_time", 0L);
            if (j <= 0) {
                j = System.currentTimeMillis();
            }
            j2 = j - l;
        }
        b.a.p0.a.j2.p.f fVar = new b.a.p0.a.j2.p.f();
        fVar.f6383a = k.m(aVar.F());
        fVar.f6388f = G;
        if (b.a.p0.a.e0.f.e.e.d()) {
            fVar.f6385c = "remote-debug";
        } else if (b.a.p0.a.u1.a.a.C()) {
            fVar.f6385c = "local-debug";
        } else {
            fVar.f6385c = aVar.S();
        }
        fVar.f6384b = "launch";
        fVar.f6387e = str;
        fVar.a("arrivetime", String.valueOf(j2));
        if (jSONObject != null) {
            fVar.e(jSONObject);
        }
        Bundle O = aVar.O();
        if (O != null) {
            fVar.d(O.getString(UBCCloudControlProcessor.UBC_KEY));
        }
        fVar.b(k.k(aVar.V()));
        if (f6301a) {
            StringBuilder sb = new StringBuilder();
            sb.append("handle record arrival event, arrivalValue ");
            sb.append(str);
            sb.append(" arrive time : ");
            sb.append(j2);
            sb.append(" extJson :");
            sb.append(jSONObject == null ? "" : jSONObject.toString());
            sb.toString();
        }
        k.onEvent(fVar);
    }

    public static void m(@NonNull b.a.p0.a.f1.e.b bVar, int i2, @NonNull b.a.p0.a.q2.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65557, null, bVar, i2, aVar) == null) {
            b.a.p0.a.j2.p.f fVar = new b.a.p0.a.j2.p.f();
            fVar.f6383a = k.m(i2);
            fVar.f6384b = "launch";
            fVar.f6387e = com.baidu.pass.biometrics.face.liveness.b.a.g0;
            fVar.a("errcode", String.valueOf(aVar.a()));
            fVar.a("msg", aVar.f().toString());
            fVar.h(bVar);
            fVar.d(bVar.q0().getString(UBCCloudControlProcessor.UBC_KEY));
            fVar.b(k.k(bVar.V()));
            b.a.p0.a.v2.m.d(bVar, new C0270e(fVar));
        }
    }

    public static void n(b.a.p0.a.j2.p.f fVar, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65558, null, fVar, str, str2) == null) {
            b.a.p0.a.r1.k.i.c.f().e(new c(fVar, str2, str), "onLaunchSuccessUBC");
        }
    }

    public static void o(b.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65559, null, aVar) == null) || aVar == null || f6306f) {
            return;
        }
        D(true);
        k(aVar, "naarrsuccess");
    }

    public static void p(b.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65560, null, aVar) == null) {
            boolean z = f6301a;
            b.a.p0.a.m1.f.e(f6309i);
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
        b.a.p0.a.a2.e i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65562, null) == null) || (i2 = b.a.p0.a.a2.e.i()) == null) {
            return;
        }
        s(i2.K());
    }

    public static void s(b.a.p0.a.f1.e.b bVar) {
        Bundle O;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65563, null, bVar) == null) || bVar == null || !e() || (O = bVar.O()) == null) {
            return;
        }
        long j = O.getLong("page_display_flag_for_statistic");
        long l = bVar.l("launch_time", 0L);
        long currentTimeMillis = System.currentTimeMillis();
        if (j > 0) {
            b.a.p0.a.j2.p.f fVar = new b.a.p0.a.j2.p.f();
            fVar.f6383a = k.m(bVar.F());
            fVar.f6388f = bVar.G();
            fVar.f6385c = bVar.S();
            fVar.f6384b = "launch";
            fVar.f6387e = "realsuccess";
            fVar.r = String.valueOf(currentTimeMillis - l);
            fVar.d(O.getString(UBCCloudControlProcessor.UBC_KEY));
            k.onEvent(fVar);
            q0.b0(new a(O));
            H();
        }
    }

    public static void t(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65564, null, str) == null) && f6307g) {
            b.a.p0.a.m1.f.e(str);
            f6307g = false;
        }
    }

    public static void u(String str, b.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65565, null, str, aVar) == null) {
            HashMap<String, String> hashMap = f6308h;
            String str2 = hashMap != null ? hashMap.get(f6309i) : "";
            if (f6301a) {
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
            f6307g = true;
        }
    }

    public static void v(@NonNull b.a.p0.a.f1.e.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65566, null, bVar) == null) {
            b.a.p0.a.j2.p.f fVar = new b.a.p0.a.j2.p.f();
            fVar.f6383a = k.m(0);
            fVar.f6388f = bVar.G();
            fVar.f6385c = bVar.S();
            fVar.f6384b = "show";
            b.a.p0.a.r1.k.i.c.f().e(new b(fVar, bVar.V(), bVar.q0().getString(UBCCloudControlProcessor.UBC_KEY)), "onShow606");
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
