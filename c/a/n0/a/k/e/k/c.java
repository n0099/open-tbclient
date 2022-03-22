package c.a.n0.a.k.e.k;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.n0.a.d2.n;
import c.a.n0.a.k.c.c;
import c.a.n0.a.k.c.d;
import c.a.n0.a.p2.l0;
import c.a.n0.a.p2.q0;
import c.a.n0.a.p2.w;
import c.a.n0.a.v0.e.b;
import c.a.n0.a.x1.c.i;
import c.a.n0.a.x1.c.j.b;
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
public class c extends c.a.n0.a.k.e.k.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a extends c.a.n0.a.k.c.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ JSONObject f5186d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f5187e;

        /* renamed from: c.a.n0.a.k.e.k.c$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0348a implements c.a.n0.a.p2.g1.c<i<JSONObject>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c.b a;

            public C0348a(a aVar, c.b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, bVar};
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
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // c.a.n0.a.p2.g1.c
            /* renamed from: a */
            public void onCallback(i<JSONObject> iVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                    if (iVar.c() && iVar.a != null) {
                        this.a.a(new c.a.n0.a.k.h.b(0, iVar.a));
                        c.a.n0.a.t1.e r = c.a.n0.a.t1.d.J().r();
                        r.d0().B(h.a(r), iVar.a.toString());
                        c.a.n0.a.u.d.i("SettingApi", "getSwanId success");
                        return;
                    }
                    this.a.a(new c.a.n0.a.k.h.b(10001, "getSwanId failed: internal_error"));
                    c.a.n0.a.u.d.c("SettingApi", "getSwanId failed: internal_error");
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((String) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5187e = cVar;
            this.f5186d = jSONObject;
        }

        @Override // c.a.n0.a.k.c.c
        @NonNull
        public c.a.n0.a.k.h.b d(@NonNull JSONObject jSONObject, @NonNull c.b bVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, jSONObject, bVar)) == null) {
                if (c.a.n0.a.k1.l.b.e() && this.f5187e.C(this.f5186d)) {
                    bVar.a(new c.a.n0.a.k.h.b(0, this.f5186d));
                    return new c.a.n0.a.k.h.b(0);
                }
                c.a.n0.a.u.d.i("SettingApi", "getSwanId start");
                if (SwanAppNetworkUtils.i(this.f5187e.getContext())) {
                    c.a.n0.a.x1.c.j.e e2 = c.a.n0.a.t1.d.J().y().a().b().e(this.f5187e.getContext());
                    e2.o(new C0348a(this, bVar));
                    e2.call();
                    return new c.a.n0.a.k.h.b(0);
                }
                c.a.n0.a.u.d.c("SettingApi", "network_error");
                return new c.a.n0.a.k.h.b(10002, "network_error");
            }
            return (c.a.n0.a.k.h.b) invokeLL.objValue;
        }

        @Override // c.a.n0.a.k.c.c
        @NonNull
        public c.a.n0.a.k.h.b e(@NonNull JSONObject jSONObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject)) == null) ? new c.a.n0.a.k.h.b(0, this.f5186d) : (c.a.n0.a.k.h.b) invokeL.objValue;
        }

        @Override // c.a.n0.a.k.c.c
        public boolean i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                if (c.a.n0.a.k1.l.b.e()) {
                    return this.f5187e.C(this.f5186d);
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        @Override // c.a.n0.a.k.c.d.a
        public c.a.n0.a.k.h.b a(c.a.n0.a.t1.e eVar, JSONObject jSONObject, @Nullable String str) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, eVar, jSONObject, str)) == null) {
                if (TextUtils.isEmpty(str)) {
                    str = "";
                }
                c.L(this.a.a().i(), str);
                return c.a.n0.a.k.h.b.f();
            }
            return (c.a.n0.a.k.h.b) invokeLLL.objValue;
        }
    }

    /* renamed from: c.a.n0.a.k.e.k.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0349c implements c.a.n0.a.p2.g1.c<Map<String, c.a.n0.a.x1.c.f>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f5188b;

        public C0349c(CallbackHandler callbackHandler, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {callbackHandler, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = callbackHandler;
            this.f5188b = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.n0.a.p2.g1.c
        /* renamed from: a */
        public void onCallback(Map<String, c.a.n0.a.x1.c.f> map) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, map) == null) {
                if (map == null) {
                    this.a.handleSchemeDispatchCallback(this.f5188b, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
                    return;
                }
                try {
                    JSONObject jSONObject = new JSONObject();
                    for (Map.Entry<String, c.a.n0.a.x1.c.f> entry : map.entrySet()) {
                        String d2 = c.a.n0.a.x1.c.f.d(entry.getKey());
                        c.a.n0.a.x1.c.f value = entry.getValue();
                        if (!TextUtils.isEmpty(d2) && value != null && value.b() && !value.f7640d && TextUtils.equals("2", value.f7641e)) {
                            if (l0.f("3.320.0")) {
                                jSONObject.put(d2, value.a() ? "1" : "0");
                            } else {
                                jSONObject.put(d2, value.a());
                            }
                        }
                    }
                    if (l0.f("3.320.0")) {
                        this.a.handleSchemeDispatchCallback(this.f5188b, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString());
                        return;
                    }
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("authSetting", jSONObject);
                    this.a.handleSchemeDispatchCallback(this.f5188b, UnitedSchemeUtility.wrapCallbackParams(jSONObject2, 0).toString());
                } catch (JSONException unused) {
                    this.a.handleSchemeDispatchCallback(this.f5188b, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements c.a.n0.a.p2.g1.c<c.a.n0.a.x1.d.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f5189b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c f5190c;

        public d(c cVar, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5190c = cVar;
            this.a = str;
            this.f5189b = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.n0.a.p2.g1.c
        /* renamed from: a */
        public void onCallback(c.a.n0.a.x1.d.a aVar) {
            c.a.n0.a.k.h.b bVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                c.a.n0.a.u.d.b("OpenData", "onOpenDataCallback:: ", aVar);
                if (aVar.E()) {
                    bVar = new c.a.n0.a.k.h.b(0, aVar.f7690g);
                    n.T(this.a, "success");
                } else {
                    int a = (int) aVar.j.a();
                    String f2 = c.a.n0.a.x1.c.d.f(a);
                    c.a.n0.a.k.h.b bVar2 = new c.a.n0.a.k.h.b(a, f2);
                    c.a.n0.a.s0.b.j().c(this.f5190c.a().i(), bVar2.a());
                    n.U(this.a, com.baidu.pass.biometrics.face.liveness.b.a.g0, f2);
                    bVar = bVar2;
                }
                this.f5190c.d(this.f5189b, bVar);
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements c.a.n0.a.p2.g1.c<i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f5191b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f5192c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f5193d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f5194e;

        public e(c cVar, String str, String str2, String str3, String str4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, str, str2, str3, str4};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5194e = cVar;
            this.a = str;
            this.f5191b = str2;
            this.f5192c = str3;
            this.f5193d = str4;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.n0.a.p2.g1.c
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (c.a.n0.a.x1.c.d.h(iVar)) {
                    this.f5194e.E(this.a, this.f5191b, this.f5192c, this.f5193d);
                    return;
                }
                c.a.n0.a.u.d.k("SettingApi", "onCallback: no permission scope_userinfo_api");
                this.f5194e.d(this.f5191b, new c.a.n0.a.k.h.b(402));
            }
        }
    }

    /* loaded from: classes.dex */
    public class f implements c.a.n0.a.c.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f5195b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f5196c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ Activity f5197d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f5198e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c f5199f;

        public f(c cVar, String str, String str2, String str3, Activity activity, String str4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, str, str2, str3, activity, str4};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5199f = cVar;
            this.a = str;
            this.f5195b = str2;
            this.f5196c = str3;
            this.f5197d = activity;
            this.f5198e = str4;
        }

        @Override // c.a.n0.a.c.a
        public void onResult(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                if (i != 0) {
                    n.S(com.baidu.pass.biometrics.face.liveness.b.a.g0, 3, this.a);
                    n.U(this.f5195b, com.baidu.pass.biometrics.face.liveness.b.a.g0, "login failed");
                    this.f5199f.d(this.f5196c, new c.a.n0.a.k.h.b(10004, "user not logged in"));
                    return;
                }
                n.S("success", 3, this.a);
                this.f5199f.K(false, this.f5196c, this.f5197d, this.f5198e, "snsapi_userinfo", this.f5195b);
            }
        }
    }

    /* loaded from: classes.dex */
    public class g implements c.a.n0.a.c.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f5200b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f5201c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ boolean f5202d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f5203e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f5204f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c f5205g;

        public g(c cVar, String str, String str2, String str3, boolean z, Activity activity, String str4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, str, str2, str3, Boolean.valueOf(z), activity, str4};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5205g = cVar;
            this.a = str;
            this.f5200b = str2;
            this.f5201c = str3;
            this.f5202d = z;
            this.f5203e = activity;
            this.f5204f = str4;
        }

        @Override // c.a.n0.a.c.a
        public void onResult(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                if (i != 0) {
                    n.S(com.baidu.pass.biometrics.face.liveness.b.a.g0, 3, this.a);
                    n.U(this.f5200b, com.baidu.pass.biometrics.face.liveness.b.a.g0, "result code = " + i);
                    this.f5205g.d(this.f5201c, new c.a.n0.a.k.h.b(10004, "user not logged in"));
                    return;
                }
                n.S("success", 3, this.a);
                this.f5205g.K(this.f5202d, this.f5201c, this.f5203e, this.f5204f, "snsapi_userinfo", this.f5200b);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static String a(c.a.n0.a.t1.e eVar) {
            InterceptResult invokeL;
            String N;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, eVar)) == null) {
                if (eVar == null) {
                    N = c.a.n0.a.t1.d.J().r().N();
                } else {
                    N = eVar.N();
                }
                return "aiapp_" + N + "getSwanId";
            }
            return (String) invokeL.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(@NonNull c.a.n0.a.k.c.b bVar) {
        super(bVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((c.a.n0.a.k.c.b) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static JSONObject D(c.a.n0.a.t1.e eVar, Context context) throws JSONException {
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
                    jSONObject.put("pa", str2);
                }
                jSONObject.put("isOpenCustomerService", q0.Q());
            }
            String i = c.a.n0.a.s0.a.h0().i(context);
            jSONObject.put("cuid", i);
            jSONObject.put("mtjCuid", i);
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
                    jSONObject.put("rootSource", c.a.n0.w.c.a(new JSONObject(string5), "pre_source", T));
                }
                SwanAppActivity activity = c.a.n0.a.w0.f.U().getActivity();
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
            c.a.n0.a.f1.r.c.a.h(new C0349c(callbackHandler, str));
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
            c.a.n0.a.t1.e r = c.a.n0.a.t1.d.J().r();
            SwanAppActivity x = r.x();
            c.a.n0.a.c.b M = r.M();
            if (M.e(x)) {
                K(false, str2, x, str, "snsapi_userinfo", str4);
                return;
            }
            n.T(str4, "getUserInfoLogin");
            M.f(x, null, new f(this, str3, str4, str2, x, str));
        }
    }

    public c.a.n0.a.k.h.b F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            q("#getAppInfoSync", false);
            c.a.n0.a.t1.e a0 = c.a.n0.a.t1.e.a0();
            if (a0 == null) {
                c.a.n0.a.u.d.b("SettingApi", "illegal swanApp");
                return new c.a.n0.a.k.h.b(1001, "illegal swanApp");
            }
            JSONObject d2 = c.a.n0.a.k1.k.g.a.c().d("getAppInfoSync");
            if (d2 == null) {
                try {
                    d2 = D(a0, getContext());
                    c.a.n0.a.k1.k.g.a.c().h("getAppInfoSync", d2);
                } catch (JSONException e2) {
                    c.a.n0.a.u.d.c("SettingApi", Log.getStackTraceString(e2));
                    return new c.a.n0.a.k.h.b(1001);
                }
            }
            return new c.a.n0.a.k.h.b(0, d2);
        }
        return (c.a.n0.a.k.h.b) invokeV.objValue;
    }

    public c.a.n0.a.k.h.b G(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            q("#getSetting", false);
            return l(str, true, new b(this));
        }
        return (c.a.n0.a.k.h.b) invokeL.objValue;
    }

    public c.a.n0.a.k.h.b H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            q("#getSlaveIdSync", false);
            String containerId = a().h().getContainerId();
            if (TextUtils.isEmpty(containerId)) {
                return new c.a.n0.a.k.h.b(1001);
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("slaveId", containerId);
                return new c.a.n0.a.k.h.b(0, jSONObject);
            } catch (JSONException unused) {
                return new c.a.n0.a.k.h.b(1001);
            }
        }
        return (c.a.n0.a.k.h.b) invokeV.objValue;
    }

    public c.a.n0.a.k.h.b I(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            q("#getSwanId", false);
            c.a.n0.a.t1.e r = c.a.n0.a.t1.d.J().r();
            return m(str, new a(this, "getSwanId", w.d(r.d0().q(h.a(r), null))));
        }
        return (c.a.n0.a.k.h.b) invokeL.objValue;
    }

    public c.a.n0.a.k.h.b J(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            q("#getUserInfo", false);
            c.a.n0.a.f.b.a.h j = c.a.n0.a.s0.b.j();
            c.a.n0.a.t1.e r = c.a.n0.a.t1.d.J().r();
            CallbackHandler i = a().i();
            if (r == null) {
                j.c(i, UnitedSchemeUtility.wrapCallbackParams(1001, "empty swanApp").toString());
                return new c.a.n0.a.k.h.b(1001, "empty swanApp");
            } else if (TextUtils.isEmpty(r.N())) {
                j.c(i, UnitedSchemeUtility.wrapCallbackParams(1001, "empty clientId").toString());
                return new c.a.n0.a.k.h.b(1001, "empty clientId");
            } else {
                JSONObject r2 = c.a.n0.a.k.c.d.r(str);
                if (r2 == null) {
                    j.c(i, UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams").toString());
                    return new c.a.n0.a.k.h.b(201, "empty joParams");
                }
                String f2 = c.a.n0.a.m1.h.b.f(r2.optString("__plugin__", null));
                boolean z = !TextUtils.isEmpty(f2);
                boolean j2 = c.a.n0.a.x1.c.d.j(r2);
                String str2 = (j2 || z) ? "getUserInfoButton" : "getUserInfoApi";
                n.T(str2, "create");
                String optString = r2.optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    j.c(i, UnitedSchemeUtility.wrapCallbackParams(201, "empty cb").toString());
                    n.U(str2, com.baidu.pass.biometrics.face.liveness.b.a.g0, "empty cb");
                    return new c.a.n0.a.k.h.b(201, "empty cb");
                }
                SwanAppActivity x = r.x();
                if (x == null) {
                    j.c(i, UnitedSchemeUtility.wrapCallbackParams(1001, "the context is not an activity").toString());
                    n.U(str2, com.baidu.pass.biometrics.face.liveness.b.a.g0, "the context is not an activity");
                    return new c.a.n0.a.k.h.b(1001, "the context is not an activity");
                }
                String optString2 = r2.optString("invokeFrom");
                if (!r.M().e(x)) {
                    n.S("show", 3, optString2);
                }
                if (!j2 && !z) {
                    M(f2, optString, optString2, str2);
                } else {
                    N(f2, j2, optString, optString2, str2);
                }
                return new c.a.n0.a.k.h.b(0);
            }
        }
        return (c.a.n0.a.k.h.b) invokeL.objValue;
    }

    public final void K(boolean z, String str, Activity activity, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Boolean.valueOf(z), str, activity, str2, str3, str4}) == null) {
            n.T(str4, "requestOpenData");
            n.T(str4, "checkScope");
            c.a.n0.a.x1.d.a.B(activity, str3, str2, z, str4, new d(this, str4, str));
        }
    }

    public final void M(String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2, str3, str4) == null) {
            n.T(str4, "checkScope");
            c.a.n0.a.t1.d.J().r().d0().g(getContext(), "scope_userinfo_api", new e(this, str, str2, str3, str4));
        }
    }

    public final void N(String str, boolean z, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{str, Boolean.valueOf(z), str2, str3, str4}) == null) {
            c.a.n0.a.t1.e r = c.a.n0.a.t1.d.J().r();
            SwanAppActivity x = r.x();
            c.a.n0.a.c.b M = r.M();
            if (M.e(x)) {
                K(z, str2, x, str, "snsapi_userinfo", str4);
                return;
            }
            n.T(str4, "getUserInfoLogin");
            M.f(x, null, new g(this, str3, str4, str2, z, x, str));
        }
    }

    @Override // c.a.n0.a.k.c.d
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? "SettingApi" : (String) invokeV.objValue;
    }
}
