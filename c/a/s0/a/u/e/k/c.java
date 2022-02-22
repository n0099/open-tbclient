package c.a.s0.a.u.e.k;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.s0.a.f1.e.b;
import c.a.s0.a.h2.c.i;
import c.a.s0.a.h2.c.j.b;
import c.a.s0.a.n2.n;
import c.a.s0.a.u.c.c;
import c.a.s0.a.u.c.d;
import c.a.s0.a.z2.l0;
import c.a.s0.a.z2.q0;
import c.a.s0.a.z2.w;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.searchbox.ubcprocessor.UBCCloudControlProcessor;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c extends c.a.s0.a.u.e.k.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a extends c.a.s0.a.u.c.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ JSONObject f9434d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f9435e;

        /* renamed from: c.a.s0.a.u.e.k.c$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0603a implements c.a.s0.a.z2.g1.c<i<JSONObject>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.b f9436e;

            public C0603a(a aVar, c.b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f9436e = bVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // c.a.s0.a.z2.g1.c
            /* renamed from: a */
            public void onCallback(i<JSONObject> iVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                    if (iVar.c() && iVar.a != null) {
                        this.f9436e.a(new c.a.s0.a.u.h.b(0, iVar.a));
                        c.a.s0.a.d2.e r = c.a.s0.a.d2.d.J().r();
                        r.d0().B(h.a(r), iVar.a.toString());
                        c.a.s0.a.e0.d.i("SettingApi", "getSwanId success");
                        return;
                    }
                    this.f9436e.a(new c.a.s0.a.u.h.b(10001, "getSwanId failed: internal_error"));
                    c.a.s0.a.e0.d.c("SettingApi", "getSwanId failed: internal_error");
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(c cVar, String str, JSONObject jSONObject) {
            super(str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, str, jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((String) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9435e = cVar;
            this.f9434d = jSONObject;
        }

        @Override // c.a.s0.a.u.c.c
        @NonNull
        public c.a.s0.a.u.h.b d(@NonNull JSONObject jSONObject, @NonNull c.b bVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, jSONObject, bVar)) == null) {
                if (c.a.s0.a.u1.l.b.e() && this.f9435e.C(this.f9434d)) {
                    bVar.a(new c.a.s0.a.u.h.b(0, this.f9434d));
                    return new c.a.s0.a.u.h.b(0);
                }
                c.a.s0.a.e0.d.i("SettingApi", "getSwanId start");
                if (SwanAppNetworkUtils.i(this.f9435e.getContext())) {
                    c.a.s0.a.h2.c.j.e e2 = c.a.s0.a.d2.d.J().y().a().b().e(this.f9435e.getContext());
                    e2.o(new C0603a(this, bVar));
                    e2.call();
                    return new c.a.s0.a.u.h.b(0);
                }
                c.a.s0.a.e0.d.c("SettingApi", "network_error");
                return new c.a.s0.a.u.h.b(10002, "network_error");
            }
            return (c.a.s0.a.u.h.b) invokeLL.objValue;
        }

        @Override // c.a.s0.a.u.c.c
        @NonNull
        public c.a.s0.a.u.h.b e(@NonNull JSONObject jSONObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject)) == null) ? new c.a.s0.a.u.h.b(0, this.f9434d) : (c.a.s0.a.u.h.b) invokeL.objValue;
        }

        @Override // c.a.s0.a.u.c.c
        public boolean i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                if (c.a.s0.a.u1.l.b.e()) {
                    return this.f9435e.C(this.f9434d);
                }
                return false;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes.dex */
    public class b implements d.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        public b(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        @Override // c.a.s0.a.u.c.d.a
        public c.a.s0.a.u.h.b a(c.a.s0.a.d2.e eVar, JSONObject jSONObject, @Nullable String str) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, eVar, jSONObject, str)) == null) {
                if (TextUtils.isEmpty(str)) {
                    str = "";
                }
                c.L(this.a.a().h(), str);
                return c.a.s0.a.u.h.b.f();
            }
            return (c.a.s0.a.u.h.b) invokeLLL.objValue;
        }
    }

    /* renamed from: c.a.s0.a.u.e.k.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0604c implements c.a.s0.a.z2.g1.c<Map<String, c.a.s0.a.h2.c.f>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f9437e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f9438f;

        public C0604c(CallbackHandler callbackHandler, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {callbackHandler, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9437e = callbackHandler;
            this.f9438f = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.s0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(Map<String, c.a.s0.a.h2.c.f> map) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, map) == null) {
                if (map == null) {
                    this.f9437e.handleSchemeDispatchCallback(this.f9438f, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
                    return;
                }
                try {
                    JSONObject jSONObject = new JSONObject();
                    for (Map.Entry<String, c.a.s0.a.h2.c.f> entry : map.entrySet()) {
                        String d2 = c.a.s0.a.h2.c.f.d(entry.getKey());
                        c.a.s0.a.h2.c.f value = entry.getValue();
                        if (!TextUtils.isEmpty(d2) && value != null && value.b() && !value.f7367d && TextUtils.equals("2", value.f7368e)) {
                            if (l0.f("3.320.0")) {
                                jSONObject.put(d2, value.a() ? "1" : "0");
                            } else {
                                jSONObject.put(d2, value.a());
                            }
                        }
                    }
                    if (l0.f("3.320.0")) {
                        this.f9437e.handleSchemeDispatchCallback(this.f9438f, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString());
                        return;
                    }
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("authSetting", jSONObject);
                    this.f9437e.handleSchemeDispatchCallback(this.f9438f, UnitedSchemeUtility.wrapCallbackParams(jSONObject2, 0).toString());
                } catch (JSONException unused) {
                    this.f9437e.handleSchemeDispatchCallback(this.f9438f, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements c.a.s0.a.z2.g1.c<c.a.s0.a.h2.d.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f9439e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f9440f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c f9441g;

        public d(c cVar, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9441g = cVar;
            this.f9439e = str;
            this.f9440f = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.s0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(c.a.s0.a.h2.d.a aVar) {
            c.a.s0.a.u.h.b bVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                c.a.s0.a.e0.d.b("OpenData", "onOpenDataCallback:: ", aVar);
                if (aVar.E()) {
                    bVar = new c.a.s0.a.u.h.b(0, aVar.f7432g);
                    n.T(this.f9439e, "success");
                } else {
                    int a = (int) aVar.f7435j.a();
                    String f2 = c.a.s0.a.h2.c.d.f(a);
                    c.a.s0.a.u.h.b bVar2 = new c.a.s0.a.u.h.b(a, f2);
                    c.a.s0.a.c1.b.j().c(this.f9441g.a().h(), bVar2.a());
                    n.U(this.f9439e, com.baidu.pass.biometrics.face.liveness.b.a.g0, f2);
                    bVar = bVar2;
                }
                this.f9441g.d(this.f9440f, bVar);
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements c.a.s0.a.z2.g1.c<i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f9442e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f9443f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f9444g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f9445h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ c f9446i;

        public e(c cVar, String str, String str2, String str3, String str4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, str, str2, str3, str4};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9446i = cVar;
            this.f9442e = str;
            this.f9443f = str2;
            this.f9444g = str3;
            this.f9445h = str4;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.s0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (c.a.s0.a.h2.c.d.h(iVar)) {
                    this.f9446i.E(this.f9442e, this.f9443f, this.f9444g, this.f9445h);
                    return;
                }
                c.a.s0.a.e0.d.k("SettingApi", "onCallback: no permission scope_userinfo_api");
                this.f9446i.d(this.f9443f, new c.a.s0.a.u.h.b(402));
            }
        }
    }

    /* loaded from: classes.dex */
    public class f implements c.a.s0.a.m.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f9447e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f9448f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f9449g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Activity f9450h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f9451i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ c f9452j;

        public f(c cVar, String str, String str2, String str3, Activity activity, String str4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, str, str2, str3, activity, str4};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9452j = cVar;
            this.f9447e = str;
            this.f9448f = str2;
            this.f9449g = str3;
            this.f9450h = activity;
            this.f9451i = str4;
        }

        @Override // c.a.s0.a.m.a
        public void onResult(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                if (i2 != 0) {
                    n.S(com.baidu.pass.biometrics.face.liveness.b.a.g0, 3, this.f9447e);
                    n.U(this.f9448f, com.baidu.pass.biometrics.face.liveness.b.a.g0, "login failed");
                    this.f9452j.d(this.f9449g, new c.a.s0.a.u.h.b(10004, "user not logged in"));
                    return;
                }
                n.S("success", 3, this.f9447e);
                this.f9452j.K(false, this.f9449g, this.f9450h, this.f9451i, "snsapi_userinfo", this.f9448f);
            }
        }
    }

    /* loaded from: classes.dex */
    public class g implements c.a.s0.a.m.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f9453e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f9454f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f9455g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ boolean f9456h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Activity f9457i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ String f9458j;
        public final /* synthetic */ c k;

        public g(c cVar, String str, String str2, String str3, boolean z, Activity activity, String str4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, str, str2, str3, Boolean.valueOf(z), activity, str4};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.k = cVar;
            this.f9453e = str;
            this.f9454f = str2;
            this.f9455g = str3;
            this.f9456h = z;
            this.f9457i = activity;
            this.f9458j = str4;
        }

        @Override // c.a.s0.a.m.a
        public void onResult(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                if (i2 != 0) {
                    n.S(com.baidu.pass.biometrics.face.liveness.b.a.g0, 3, this.f9453e);
                    n.U(this.f9454f, com.baidu.pass.biometrics.face.liveness.b.a.g0, "result code = " + i2);
                    this.k.d(this.f9455g, new c.a.s0.a.u.h.b(10004, "user not logged in"));
                    return;
                }
                n.S("success", 3, this.f9453e);
                this.k.K(this.f9456h, this.f9455g, this.f9457i, this.f9458j, "snsapi_userinfo", this.f9454f);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static String a(c.a.s0.a.d2.e eVar) {
            InterceptResult invokeL;
            String N;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, eVar)) == null) {
                if (eVar == null) {
                    N = c.a.s0.a.d2.d.J().r().N();
                } else {
                    N = eVar.N();
                }
                return "aiapp_" + N + "getSwanId";
            }
            return (String) invokeL.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(@NonNull c.a.s0.a.u.c.b bVar) {
        super(bVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((c.a.s0.a.u.c.b) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static JSONObject D(c.a.s0.a.d2.e eVar, Context context) throws JSONException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, eVar, context)) == null) {
            b.a V = eVar.V();
            String T = V.T();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("appid", V.H());
            jSONObject.put("appname", V.K());
            if (!TextUtils.isEmpty(V.Q())) {
                jSONObject.put("iconUrl", V.Q());
            }
            if (!TextUtils.isEmpty(V.W())) {
                jSONObject.put("appLaunchScheme", V.W());
            } else {
                jSONObject.put("appLaunchScheme", "");
            }
            PMSAppInfo f0 = V.f0();
            if (f0 != null) {
                String str = f0.description;
                if (!TextUtils.isEmpty(str)) {
                    jSONObject.put("appDesc", str);
                }
                String str2 = f0.paNumber;
                if (!TextUtils.isEmpty(str2)) {
                    jSONObject.put(com.alipay.sdk.cons.b.k, str2);
                }
                jSONObject.put("isOpenCustomerService", q0.Q());
            }
            String i2 = c.a.s0.a.c1.a.h0().i(context);
            jSONObject.put("cuid", i2);
            jSONObject.put("mtjCuid", i2);
            jSONObject.put("clkid", V.L());
            jSONObject.put("scene", T);
            jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, V.H());
            jSONObject.put("appKey", V.I());
            jSONObject.put("pkgType", V.getType());
            jSONObject.put("bundleId", V.H());
            Bundle P = V.P();
            if (P != null) {
                String string = P.getString(PrefetchEvent.EVENT_DATA_EXTRA_DATA);
                if (!TextUtils.isEmpty(string)) {
                    jSONObject.put(PrefetchEvent.EVENT_DATA_EXTRA_DATA, new JSONObject(string));
                }
                String string2 = P.getString("srcAppId");
                if (!TextUtils.isEmpty(string2)) {
                    jSONObject.put("srcAppId", string2);
                }
                String string3 = P.getString("srcAppPage");
                if (!TextUtils.isEmpty(string3)) {
                    jSONObject.put("srcAppPage", string3);
                }
                String string4 = P.getString("srcAppKey");
                if (!TextUtils.isEmpty(string4)) {
                    jSONObject.put("srcAppKey", string4);
                }
                jSONObject.put("srcPkgType", P.getInt("srcPkgType"));
                if (TextUtils.isEmpty(T)) {
                    T = "NA";
                }
                String string5 = P.getString(UBCCloudControlProcessor.UBC_KEY);
                if (!TextUtils.isEmpty(string5)) {
                    jSONObject.put("rootSource", c.a.s0.w.c.a(new JSONObject(string5), "pre_source", T));
                }
                SwanAppActivity activity = c.a.s0.a.g1.f.U().getActivity();
                String showBy = activity != null ? activity.getShowBy() : "sys";
                jSONObject.put("showBy", TextUtils.isEmpty(showBy) ? "sys" : showBy);
            }
            return jSONObject;
        }
        return (JSONObject) invokeLL.objValue;
    }

    public static void L(CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, callbackHandler, str) == null) {
            c.a.s0.a.p1.r.c.a.h(new C0604c(callbackHandler, str));
        }
    }

    public final boolean C(JSONObject jSONObject) {
        InterceptResult invokeL;
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jSONObject)) == null) {
            if (jSONObject == null || (optJSONObject = jSONObject.optJSONObject("data")) == null) {
                return false;
            }
            String optString = optJSONObject.optString("swanid");
            return (TextUtils.isEmpty(optString) || TextUtils.equals(StringUtil.NULL_STRING, optString)) ? false : true;
        }
        return invokeL.booleanValue;
    }

    public final void E(String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, str3, str4) == null) {
            c.a.s0.a.d2.e r = c.a.s0.a.d2.d.J().r();
            SwanAppActivity x = r.x();
            c.a.s0.a.m.b M = r.M();
            if (M.e(x)) {
                K(false, str2, x, str, "snsapi_userinfo", str4);
                return;
            }
            n.T(str4, "getUserInfoLogin");
            M.f(x, null, new f(this, str3, str4, str2, x, str));
        }
    }

    public c.a.s0.a.u.h.b F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            q("#getAppInfoSync", false);
            c.a.s0.a.d2.e a0 = c.a.s0.a.d2.e.a0();
            if (a0 == null) {
                c.a.s0.a.e0.d.b("SettingApi", "illegal swanApp");
                return new c.a.s0.a.u.h.b(1001, "illegal swanApp");
            }
            JSONObject d2 = c.a.s0.a.u1.k.g.a.c().d("getAppInfoSync");
            if (d2 == null) {
                try {
                    d2 = D(a0, getContext());
                    c.a.s0.a.u1.k.g.a.c().h("getAppInfoSync", d2);
                } catch (JSONException e2) {
                    c.a.s0.a.e0.d.c("SettingApi", Log.getStackTraceString(e2));
                    return new c.a.s0.a.u.h.b(1001);
                }
            }
            return new c.a.s0.a.u.h.b(0, d2);
        }
        return (c.a.s0.a.u.h.b) invokeV.objValue;
    }

    public c.a.s0.a.u.h.b G(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            q("#getSetting", false);
            return l(str, true, new b(this));
        }
        return (c.a.s0.a.u.h.b) invokeL.objValue;
    }

    public c.a.s0.a.u.h.b H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            q("#getSlaveIdSync", false);
            String containerId = a().g().getContainerId();
            if (TextUtils.isEmpty(containerId)) {
                return new c.a.s0.a.u.h.b(1001);
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("slaveId", containerId);
                return new c.a.s0.a.u.h.b(0, jSONObject);
            } catch (JSONException unused) {
                return new c.a.s0.a.u.h.b(1001);
            }
        }
        return (c.a.s0.a.u.h.b) invokeV.objValue;
    }

    public c.a.s0.a.u.h.b I(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            q("#getSwanId", false);
            c.a.s0.a.d2.e r = c.a.s0.a.d2.d.J().r();
            return m(str, new a(this, "getSwanId", w.d(r.d0().q(h.a(r), null))));
        }
        return (c.a.s0.a.u.h.b) invokeL.objValue;
    }

    public c.a.s0.a.u.h.b J(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            q("#getUserInfo", false);
            c.a.s0.a.p.b.a.h j2 = c.a.s0.a.c1.b.j();
            c.a.s0.a.d2.e r = c.a.s0.a.d2.d.J().r();
            CallbackHandler h2 = a().h();
            if (r == null) {
                j2.c(h2, UnitedSchemeUtility.wrapCallbackParams(1001, "empty swanApp").toString());
                return new c.a.s0.a.u.h.b(1001, "empty swanApp");
            } else if (TextUtils.isEmpty(r.N())) {
                j2.c(h2, UnitedSchemeUtility.wrapCallbackParams(1001, "empty clientId").toString());
                return new c.a.s0.a.u.h.b(1001, "empty clientId");
            } else {
                JSONObject r2 = c.a.s0.a.u.c.d.r(str);
                if (r2 == null) {
                    j2.c(h2, UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams").toString());
                    return new c.a.s0.a.u.h.b(201, "empty joParams");
                }
                String f2 = c.a.s0.a.w1.h.b.f(r2.optString("__plugin__", null));
                boolean z = !TextUtils.isEmpty(f2);
                boolean j3 = c.a.s0.a.h2.c.d.j(r2);
                String str2 = (j3 || z) ? "getUserInfoButton" : "getUserInfoApi";
                n.T(str2, "create");
                String optString = r2.optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    j2.c(h2, UnitedSchemeUtility.wrapCallbackParams(201, "empty cb").toString());
                    n.U(str2, com.baidu.pass.biometrics.face.liveness.b.a.g0, "empty cb");
                    return new c.a.s0.a.u.h.b(201, "empty cb");
                }
                SwanAppActivity x = r.x();
                if (x == null) {
                    j2.c(h2, UnitedSchemeUtility.wrapCallbackParams(1001, "the context is not an activity").toString());
                    n.U(str2, com.baidu.pass.biometrics.face.liveness.b.a.g0, "the context is not an activity");
                    return new c.a.s0.a.u.h.b(1001, "the context is not an activity");
                }
                String optString2 = r2.optString("invokeFrom");
                if (!r.M().e(x)) {
                    n.S("show", 3, optString2);
                }
                if (!j3 && !z) {
                    M(f2, optString, optString2, str2);
                } else {
                    N(f2, j3, optString, optString2, str2);
                }
                return new c.a.s0.a.u.h.b(0);
            }
        }
        return (c.a.s0.a.u.h.b) invokeL.objValue;
    }

    public final void K(boolean z, String str, Activity activity, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Boolean.valueOf(z), str, activity, str2, str3, str4}) == null) {
            n.T(str4, "requestOpenData");
            n.T(str4, "checkScope");
            c.a.s0.a.h2.d.a.B(activity, str3, str2, z, str4, new d(this, str4, str));
        }
    }

    public final void M(String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2, str3, str4) == null) {
            n.T(str4, "checkScope");
            c.a.s0.a.d2.d.J().r().d0().g(getContext(), "scope_userinfo_api", new e(this, str, str2, str3, str4));
        }
    }

    public final void N(String str, boolean z, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{str, Boolean.valueOf(z), str2, str3, str4}) == null) {
            c.a.s0.a.d2.e r = c.a.s0.a.d2.d.J().r();
            SwanAppActivity x = r.x();
            c.a.s0.a.m.b M = r.M();
            if (M.e(x)) {
                K(z, str2, x, str, "snsapi_userinfo", str4);
                return;
            }
            n.T(str4, "getUserInfoLogin");
            M.f(x, null, new g(this, str3, str4, str2, z, x, str));
        }
    }

    @Override // c.a.s0.a.u.c.d
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? "SettingApi" : (String) invokeV.objValue;
    }
}
