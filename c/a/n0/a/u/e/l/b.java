package c.a.n0.a.u.e.l;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.n0.a.e2.c.i;
import c.a.n0.a.e2.c.j.b;
import c.a.n0.a.f1.e.b;
import c.a.n0.a.j2.k;
import c.a.n0.a.u.c.c;
import c.a.n0.a.u.c.d;
import c.a.n0.a.v2.q0;
import c.a.n0.a.v2.w;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.adrequest.AdParamInfo;
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
public class b extends c.a.n0.a.u.c.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a extends c.a.n0.a.u.c.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ JSONObject f8772d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f8773e;

        /* renamed from: c.a.n0.a.u.e.l.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0402a implements c.a.n0.a.v2.e1.b<i<JSONObject>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.b f8774e;

            public C0402a(a aVar, c.b bVar) {
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
                this.f8774e = bVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // c.a.n0.a.v2.e1.b
            /* renamed from: a */
            public void onCallback(i<JSONObject> iVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                    if (iVar.c() && iVar.f5308a != null) {
                        this.f8774e.a(new c.a.n0.a.u.h.b(0, iVar.f5308a));
                        c.a.n0.a.a2.e r = c.a.n0.a.a2.d.g().r();
                        r.T().B(h.a(r), iVar.f5308a.toString());
                        c.a.n0.a.e0.d.g("Api-Setting", "getSwanId success");
                        return;
                    }
                    this.f8774e.a(new c.a.n0.a.u.h.b(10001, "getSwanId failed: internal_error"));
                    c.a.n0.a.e0.d.b("Api-Setting", "getSwanId failed: internal_error");
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(b bVar, String str, JSONObject jSONObject) {
            super(str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, str, jSONObject};
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
            this.f8773e = bVar;
            this.f8772d = jSONObject;
        }

        @Override // c.a.n0.a.u.c.c
        @NonNull
        public c.a.n0.a.u.h.b d(@NonNull JSONObject jSONObject, @NonNull c.b bVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, jSONObject, bVar)) == null) {
                if (c.a.n0.a.r1.l.b.j() && this.f8773e.w(this.f8772d)) {
                    bVar.a(new c.a.n0.a.u.h.b(0, this.f8772d));
                    return new c.a.n0.a.u.h.b(0);
                }
                c.a.n0.a.e0.d.g("Api-Setting", "getSwanId start");
                if (SwanAppNetworkUtils.i(this.f8773e.i())) {
                    c.a.n0.a.e2.c.j.e e2 = c.a.n0.a.a2.d.g().y().a().b().e(this.f8773e.i());
                    e2.p(new C0402a(this, bVar));
                    e2.a();
                    return new c.a.n0.a.u.h.b(0);
                }
                c.a.n0.a.e0.d.b("Api-Setting", "network_error");
                return new c.a.n0.a.u.h.b(10002, "network_error");
            }
            return (c.a.n0.a.u.h.b) invokeLL.objValue;
        }

        @Override // c.a.n0.a.u.c.c
        @NonNull
        public c.a.n0.a.u.h.b e(@NonNull JSONObject jSONObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject)) == null) ? new c.a.n0.a.u.h.b(0, this.f8772d) : (c.a.n0.a.u.h.b) invokeL.objValue;
        }

        @Override // c.a.n0.a.u.c.c
        public boolean i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                if (c.a.n0.a.r1.l.b.j()) {
                    return this.f8773e.w(this.f8772d);
                }
                return false;
            }
            return invokeV.booleanValue;
        }
    }

    /* renamed from: c.a.n0.a.u.e.l.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0403b implements d.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f8775a;

        public C0403b(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8775a = bVar;
        }

        @Override // c.a.n0.a.u.c.d.b
        public c.a.n0.a.u.h.b a(c.a.n0.a.a2.e eVar, JSONObject jSONObject, @Nullable String str) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, eVar, jSONObject, str)) == null) {
                if (TextUtils.isEmpty(str)) {
                    str = "";
                }
                b.F(this.f8775a.a().h(), str);
                return new c.a.n0.a.u.h.b(0);
            }
            return (c.a.n0.a.u.h.b) invokeLLL.objValue;
        }
    }

    /* loaded from: classes.dex */
    public static class c implements c.a.n0.a.v2.e1.b<Map<String, c.a.n0.a.e2.c.f>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f8776e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f8777f;

        public c(CallbackHandler callbackHandler, String str) {
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
            this.f8776e = callbackHandler;
            this.f8777f = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.n0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(Map<String, c.a.n0.a.e2.c.f> map) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, map) == null) {
                if (map == null) {
                    this.f8776e.handleSchemeDispatchCallback(this.f8777f, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
                    return;
                }
                try {
                    JSONObject jSONObject = new JSONObject();
                    for (Map.Entry<String, c.a.n0.a.e2.c.f> entry : map.entrySet()) {
                        String key = entry.getKey();
                        c.a.n0.a.e2.c.f value = entry.getValue();
                        if (!TextUtils.isEmpty(key) && value != null && value.b() && !value.f5267d && TextUtils.equals("2", value.f5268e)) {
                            jSONObject.put(key, value.a() ? "1" : "0");
                        }
                    }
                    this.f8776e.handleSchemeDispatchCallback(this.f8777f, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString());
                } catch (JSONException unused) {
                    this.f8776e.handleSchemeDispatchCallback(this.f8777f, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements c.a.n0.a.v2.e1.b<c.a.n0.a.e2.d.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8778e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f8779f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ b f8780g;

        public d(b bVar, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8780g = bVar;
            this.f8778e = str;
            this.f8779f = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.n0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(c.a.n0.a.e2.d.a aVar) {
            c.a.n0.a.u.h.b bVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                c.a.n0.a.e0.d.a("OpenData", "onOpenDataCallback:: ", aVar);
                if (aVar.F()) {
                    bVar = new c.a.n0.a.u.h.b(0, aVar.f5344g);
                    k.N(this.f8778e, "success");
                } else {
                    int a2 = (int) aVar.f5347j.a();
                    String f2 = c.a.n0.a.e2.c.d.f(a2);
                    c.a.n0.a.u.h.b bVar2 = new c.a.n0.a.u.h.b(a2, f2);
                    c.a.n0.a.c1.b.j().c(this.f8780g.a().h(), bVar2.a());
                    k.O(this.f8778e, com.baidu.pass.biometrics.face.liveness.b.a.g0, f2);
                    bVar = bVar2;
                }
                this.f8780g.d(this.f8779f, bVar);
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements c.a.n0.a.v2.e1.b<i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8781e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f8782f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f8783g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f8784h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ b f8785i;

        public e(b bVar, String str, String str2, String str3, String str4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, str, str2, str3, str4};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8785i = bVar;
            this.f8781e = str;
            this.f8782f = str2;
            this.f8783g = str3;
            this.f8784h = str4;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.n0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (c.a.n0.a.e2.c.d.h(iVar)) {
                    if (c.a.n0.a.u.c.d.f8453c) {
                        c.a.n0.a.e0.d.h("Api-Setting", "onCallback: has permission scope_userinfo_api");
                    }
                    this.f8785i.y(this.f8781e, this.f8782f, this.f8783g, this.f8784h);
                    return;
                }
                c.a.n0.a.e0.d.h("Api-Setting", "onCallback: no permission scope_userinfo_api");
                this.f8785i.d(this.f8782f, new c.a.n0.a.u.h.b(402));
            }
        }
    }

    /* loaded from: classes.dex */
    public class f implements c.a.n0.a.m.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8786e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f8787f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f8788g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Activity f8789h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f8790i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ b f8791j;

        public f(b bVar, String str, String str2, String str3, Activity activity, String str4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, str, str2, str3, activity, str4};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8791j = bVar;
            this.f8786e = str;
            this.f8787f = str2;
            this.f8788g = str3;
            this.f8789h = activity;
            this.f8790i = str4;
        }

        @Override // c.a.n0.a.m.a
        public void onResult(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                if (i2 != 0) {
                    k.M(com.baidu.pass.biometrics.face.liveness.b.a.g0, 3, this.f8786e);
                    k.O(this.f8787f, com.baidu.pass.biometrics.face.liveness.b.a.g0, "login failed");
                    this.f8791j.d(this.f8788g, new c.a.n0.a.u.h.b(10004, "user not logged in"));
                    return;
                }
                k.M("success", 3, this.f8786e);
                this.f8791j.E(false, this.f8788g, this.f8789h, this.f8790i, "snsapi_userinfo", this.f8787f);
            }
        }
    }

    /* loaded from: classes.dex */
    public class g implements c.a.n0.a.m.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8792e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f8793f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f8794g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ boolean f8795h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Activity f8796i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ String f8797j;
        public final /* synthetic */ b k;

        public g(b bVar, String str, String str2, String str3, boolean z, Activity activity, String str4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, str, str2, str3, Boolean.valueOf(z), activity, str4};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.k = bVar;
            this.f8792e = str;
            this.f8793f = str2;
            this.f8794g = str3;
            this.f8795h = z;
            this.f8796i = activity;
            this.f8797j = str4;
        }

        @Override // c.a.n0.a.m.a
        public void onResult(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                if (i2 != 0) {
                    k.M(com.baidu.pass.biometrics.face.liveness.b.a.g0, 3, this.f8792e);
                    k.O(this.f8793f, com.baidu.pass.biometrics.face.liveness.b.a.g0, "result code = " + i2);
                    this.k.d(this.f8794g, new c.a.n0.a.u.h.b(10004, "user not logged in"));
                    return;
                }
                k.M("success", 3, this.f8792e);
                this.k.E(this.f8795h, this.f8794g, this.f8796i, this.f8797j, "snsapi_userinfo", this.f8793f);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static String a(c.a.n0.a.a2.e eVar) {
            InterceptResult invokeL;
            String D;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, eVar)) == null) {
                if (eVar == null) {
                    D = c.a.n0.a.a2.d.g().r().D();
                } else {
                    D = eVar.D();
                }
                return "aiapp_" + D + "getSwanId";
            }
            return (String) invokeL.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@NonNull c.a.n0.a.u.c.b bVar) {
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
                super((c.a.n0.a.u.c.b) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static void F(CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, callbackHandler, str) == null) {
            c.a.n0.a.n1.q.c.a.h(new c(callbackHandler, str));
        }
    }

    public static JSONObject x(c.a.n0.a.a2.e eVar, Context context) throws JSONException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, eVar, context)) == null) {
            b.a L = eVar.L();
            String T = L.T();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("appid", L.H());
            jSONObject.put("appname", L.K());
            if (!TextUtils.isEmpty(L.Q())) {
                jSONObject.put("iconUrl", L.Q());
            }
            if (!TextUtils.isEmpty(L.W())) {
                jSONObject.put("appLaunchScheme", L.W());
            } else {
                jSONObject.put("appLaunchScheme", "");
            }
            PMSAppInfo f0 = L.f0();
            if (f0 != null) {
                String str = f0.description;
                if (!TextUtils.isEmpty(str)) {
                    jSONObject.put("appDesc", str);
                }
                String str2 = f0.paNumber;
                if (!TextUtils.isEmpty(str2)) {
                    jSONObject.put(com.alipay.sdk.cons.b.k, str2);
                }
                jSONObject.put("isOpenCustomerService", q0.P());
            }
            String i2 = c.a.n0.a.c1.a.a0().i(context);
            jSONObject.put("cuid", i2);
            jSONObject.put("mtjCuid", i2);
            jSONObject.put("clkid", L.L());
            jSONObject.put("scene", T);
            jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, L.H());
            Bundle P = L.P();
            if (P != null) {
                String string = P.getString(PrefetchEvent.EVENT_DATA_EXTRA_DATA);
                if (!TextUtils.isEmpty(string)) {
                    jSONObject.put(PrefetchEvent.EVENT_DATA_EXTRA_DATA, new JSONObject(string));
                }
                if (!TextUtils.isEmpty(P.getString("srcAppId"))) {
                    jSONObject.put("srcAppId", P.getString("srcAppId"));
                }
                if (!TextUtils.isEmpty(P.getString("srcAppPage"))) {
                    jSONObject.put("srcAppPage", P.getString("srcAppPage"));
                }
                if (TextUtils.isEmpty(T)) {
                    T = AdParamInfo.AdClickActionString.AD_CLICK_ACTION_NA;
                }
                String string2 = P.getString(UBCCloudControlProcessor.UBC_KEY);
                if (!TextUtils.isEmpty(string2)) {
                    jSONObject.put("rootSource", c.a.n0.t.c.a(new JSONObject(string2), "pre_source", T));
                }
                SwanAppActivity activity = c.a.n0.a.g1.f.V().getActivity();
                String showBy = activity != null ? activity.getShowBy() : "sys";
                String str3 = TextUtils.isEmpty(showBy) ? "sys" : showBy;
                if (c.a.n0.a.u.c.d.f8453c) {
                    String str4 = "showBy: " + str3;
                }
                jSONObject.put("showBy", str3);
            }
            return jSONObject;
        }
        return (JSONObject) invokeLL.objValue;
    }

    public c.a.n0.a.u.h.b A(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            boolean z = c.a.n0.a.u.c.d.f8453c;
            return j(str, true, new C0403b(this));
        }
        return (c.a.n0.a.u.h.b) invokeL.objValue;
    }

    public c.a.n0.a.u.h.b B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            boolean z = c.a.n0.a.u.c.d.f8453c;
            String containerId = a().g().getContainerId();
            if (TextUtils.isEmpty(containerId)) {
                return new c.a.n0.a.u.h.b(1001);
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("slaveId", containerId);
                return new c.a.n0.a.u.h.b(0, jSONObject);
            } catch (JSONException e2) {
                if (c.a.n0.a.u.c.d.f8453c) {
                    Log.getStackTraceString(e2);
                }
                return new c.a.n0.a.u.h.b(1001);
            }
        }
        return (c.a.n0.a.u.h.b) invokeV.objValue;
    }

    public c.a.n0.a.u.h.b C(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            c.a.n0.a.a2.e r = c.a.n0.a.a2.d.g().r();
            return k(str, new a(this, "getSwanId", w.d(r.T().q(h.a(r), null))));
        }
        return (c.a.n0.a.u.h.b) invokeL.objValue;
    }

    public c.a.n0.a.u.h.b D(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            boolean z = c.a.n0.a.u.c.d.f8453c;
            c.a.n0.a.p.b.a.h j2 = c.a.n0.a.c1.b.j();
            c.a.n0.a.a2.e r = c.a.n0.a.a2.d.g().r();
            CallbackHandler h2 = a().h();
            if (r == null) {
                j2.c(h2, UnitedSchemeUtility.wrapCallbackParams(1001, "empty swanApp").toString());
                return new c.a.n0.a.u.h.b(1001, "empty swanApp");
            } else if (TextUtils.isEmpty(r.D())) {
                j2.c(h2, UnitedSchemeUtility.wrapCallbackParams(1001, "empty clientId").toString());
                return new c.a.n0.a.u.h.b(1001, "empty clientId");
            } else {
                JSONObject m = c.a.n0.a.u.c.d.m(str);
                if (m == null) {
                    j2.c(h2, UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams").toString());
                    return new c.a.n0.a.u.h.b(201, "empty joParams");
                }
                String f2 = c.a.n0.a.t1.g.b.f(m.optString("__plugin__", null));
                boolean z2 = !TextUtils.isEmpty(f2);
                boolean i2 = c.a.n0.a.e2.c.d.i(m);
                String str2 = (i2 || z2) ? "getUserInfoButton" : "getUserInfoApi";
                k.N(str2, "create");
                String optString = m.optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    j2.c(h2, UnitedSchemeUtility.wrapCallbackParams(201, "empty cb").toString());
                    k.O(str2, com.baidu.pass.biometrics.face.liveness.b.a.g0, "empty cb");
                    return new c.a.n0.a.u.h.b(201, "empty cb");
                }
                SwanAppActivity x = r.x();
                if (x == null) {
                    j2.c(h2, UnitedSchemeUtility.wrapCallbackParams(1001, "the context is not an activity").toString());
                    k.O(str2, com.baidu.pass.biometrics.face.liveness.b.a.g0, "the context is not an activity");
                    return new c.a.n0.a.u.h.b(1001, "the context is not an activity");
                }
                String optString2 = m.optString("invokeFrom");
                if (!r.j().e(x)) {
                    k.M("show", 3, optString2);
                }
                if (!i2 && !z2) {
                    G(f2, optString, optString2, str2);
                } else {
                    H(f2, i2, optString, optString2, str2);
                }
                return new c.a.n0.a.u.h.b(0);
            }
        }
        return (c.a.n0.a.u.h.b) invokeL.objValue;
    }

    public final void E(boolean z, String str, Activity activity, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Boolean.valueOf(z), str, activity, str2, str3, str4}) == null) {
            k.N(str4, "requestOpenData");
            k.N(str4, "checkScope");
            c.a.n0.a.e2.d.a.C(activity, str3, str2, z, str4, new d(this, str4, str));
        }
    }

    public final void G(String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048581, this, str, str2, str3, str4) == null) {
            k.N(str4, "checkScope");
            c.a.n0.a.a2.d.g().r().T().g(i(), "scope_userinfo_api", new e(this, str, str2, str3, str4));
        }
    }

    public final void H(String str, boolean z, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{str, Boolean.valueOf(z), str2, str3, str4}) == null) {
            c.a.n0.a.a2.e r = c.a.n0.a.a2.d.g().r();
            SwanAppActivity x = r.x();
            c.a.n0.a.m.b j2 = r.j();
            if (j2.e(x)) {
                E(z, str2, x, str, "snsapi_userinfo", str4);
                return;
            }
            k.N(str4, "getUserInfoLogin");
            j2.f(x, null, new g(this, str3, str4, str2, z, x, str));
        }
    }

    public final boolean w(JSONObject jSONObject) {
        InterceptResult invokeL;
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, jSONObject)) == null) {
            if (jSONObject == null || (optJSONObject = jSONObject.optJSONObject("data")) == null) {
                return false;
            }
            String optString = optJSONObject.optString("swanid");
            return (TextUtils.isEmpty(optString) || TextUtils.equals(StringUtil.NULL_STRING, optString)) ? false : true;
        }
        return invokeL.booleanValue;
    }

    public final void y(String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2, str3, str4) == null) {
            c.a.n0.a.a2.e r = c.a.n0.a.a2.d.g().r();
            SwanAppActivity x = r.x();
            c.a.n0.a.m.b j2 = r.j();
            if (j2.e(x)) {
                E(false, str2, x, str, "snsapi_userinfo", str4);
                return;
            }
            k.N(str4, "getUserInfoLogin");
            j2.f(x, null, new f(this, str3, str4, str2, x, str));
        }
    }

    public c.a.n0.a.u.h.b z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            c.a.n0.a.e0.d.a("Api-Setting", "start get app info sync");
            c.a.n0.a.a2.e Q = c.a.n0.a.a2.e.Q();
            if (Q == null) {
                c.a.n0.a.e0.d.a("Api-Setting", "illegal swanApp");
                return new c.a.n0.a.u.h.b(1001, "illegal swanApp");
            }
            JSONObject d2 = c.a.n0.a.r1.k.g.a.c().d("getAppInfoSync");
            if (d2 == null) {
                try {
                    d2 = x(Q, i());
                    c.a.n0.a.r1.k.g.a.c().h("getAppInfoSync", d2);
                } catch (JSONException e2) {
                    c.a.n0.a.e0.d.b("Api-Setting", Log.getStackTraceString(e2));
                    return new c.a.n0.a.u.h.b(1001);
                }
            }
            if (c.a.n0.a.u.c.d.f8453c && d2 != null) {
                String str = "data: " + d2.toString();
            }
            return new c.a.n0.a.u.h.b(0, d2);
        }
        return (c.a.n0.a.u.h.b) invokeV.objValue;
    }
}
