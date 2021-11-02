package b.a.p0.a.u.e.l;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.e2.c.i;
import b.a.p0.a.e2.c.j.b;
import b.a.p0.a.f1.e.b;
import b.a.p0.a.j2.k;
import b.a.p0.a.u.c.c;
import b.a.p0.a.u.c.d;
import b.a.p0.a.v2.q0;
import b.a.p0.a.v2.w;
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
public class b extends b.a.p0.a.u.c.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a extends b.a.p0.a.u.c.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ JSONObject f8308d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f8309e;

        /* renamed from: b.a.p0.a.u.e.l.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0407a implements b.a.p0.a.v2.e1.b<i<JSONObject>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.b f8310e;

            public C0407a(a aVar, c.b bVar) {
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
                this.f8310e = bVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // b.a.p0.a.v2.e1.b
            /* renamed from: a */
            public void onCallback(i<JSONObject> iVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                    if (iVar.c() && iVar.f4946a != null) {
                        this.f8310e.a(new b.a.p0.a.u.h.b(0, iVar.f4946a));
                        b.a.p0.a.a2.e r = b.a.p0.a.a2.d.g().r();
                        r.S().B(h.a(r), iVar.f4946a.toString());
                        b.a.p0.a.e0.d.g("Api-Setting", "getSwanId success");
                        return;
                    }
                    this.f8310e.a(new b.a.p0.a.u.h.b(10001, "getSwanId failed: internal_error"));
                    b.a.p0.a.e0.d.b("Api-Setting", "getSwanId failed: internal_error");
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
            this.f8309e = bVar;
            this.f8308d = jSONObject;
        }

        @Override // b.a.p0.a.u.c.c
        @NonNull
        public b.a.p0.a.u.h.b d(@NonNull JSONObject jSONObject, @NonNull c.b bVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, jSONObject, bVar)) == null) {
                if (b.a.p0.a.r1.l.b.j() && this.f8309e.v(this.f8308d)) {
                    bVar.a(new b.a.p0.a.u.h.b(0, this.f8308d));
                    return new b.a.p0.a.u.h.b(0);
                }
                b.a.p0.a.e0.d.g("Api-Setting", "getSwanId start");
                if (SwanAppNetworkUtils.i(this.f8309e.getContext())) {
                    b.a.p0.a.e2.c.j.e e2 = b.a.p0.a.a2.d.g().y().a().b().e(this.f8309e.getContext());
                    e2.o(new C0407a(this, bVar));
                    e2.call();
                    return new b.a.p0.a.u.h.b(0);
                }
                b.a.p0.a.e0.d.b("Api-Setting", "network_error");
                return new b.a.p0.a.u.h.b(10002, "network_error");
            }
            return (b.a.p0.a.u.h.b) invokeLL.objValue;
        }

        @Override // b.a.p0.a.u.c.c
        @NonNull
        public b.a.p0.a.u.h.b e(@NonNull JSONObject jSONObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject)) == null) ? new b.a.p0.a.u.h.b(0, this.f8308d) : (b.a.p0.a.u.h.b) invokeL.objValue;
        }

        @Override // b.a.p0.a.u.c.c
        public boolean i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                if (b.a.p0.a.r1.l.b.j()) {
                    return this.f8309e.v(this.f8308d);
                }
                return false;
            }
            return invokeV.booleanValue;
        }
    }

    /* renamed from: b.a.p0.a.u.e.l.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0408b implements d.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f8311a;

        public C0408b(b bVar) {
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
            this.f8311a = bVar;
        }

        @Override // b.a.p0.a.u.c.d.b
        public b.a.p0.a.u.h.b a(b.a.p0.a.a2.e eVar, JSONObject jSONObject, @Nullable String str) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, eVar, jSONObject, str)) == null) {
                if (TextUtils.isEmpty(str)) {
                    str = "";
                }
                b.E(this.f8311a.a().g(), str);
                return new b.a.p0.a.u.h.b(0);
            }
            return (b.a.p0.a.u.h.b) invokeLLL.objValue;
        }
    }

    /* loaded from: classes.dex */
    public static class c implements b.a.p0.a.v2.e1.b<Map<String, b.a.p0.a.e2.c.f>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f8312e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f8313f;

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
            this.f8312e = callbackHandler;
            this.f8313f = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(Map<String, b.a.p0.a.e2.c.f> map) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, map) == null) {
                if (map == null) {
                    this.f8312e.handleSchemeDispatchCallback(this.f8313f, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
                    return;
                }
                try {
                    JSONObject jSONObject = new JSONObject();
                    for (Map.Entry<String, b.a.p0.a.e2.c.f> entry : map.entrySet()) {
                        String key = entry.getKey();
                        b.a.p0.a.e2.c.f value = entry.getValue();
                        if (!TextUtils.isEmpty(key) && value != null && value.b() && !value.f4907d && TextUtils.equals("2", value.f4908e)) {
                            jSONObject.put(key, value.a() ? "1" : "0");
                        }
                    }
                    this.f8312e.handleSchemeDispatchCallback(this.f8313f, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString());
                } catch (JSONException unused) {
                    this.f8312e.handleSchemeDispatchCallback(this.f8313f, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements b.a.p0.a.v2.e1.b<b.a.p0.a.e2.d.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8314e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f8315f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ b f8316g;

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
            this.f8316g = bVar;
            this.f8314e = str;
            this.f8315f = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(b.a.p0.a.e2.d.a aVar) {
            b.a.p0.a.u.h.b bVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                b.a.p0.a.e0.d.a("OpenData", "onOpenDataCallback:: ", aVar);
                if (aVar.F()) {
                    bVar = new b.a.p0.a.u.h.b(0, aVar.f4981g);
                    k.N(this.f8314e, "success");
                } else {
                    int a2 = (int) aVar.j.a();
                    String f2 = b.a.p0.a.e2.c.d.f(a2);
                    b.a.p0.a.u.h.b bVar2 = new b.a.p0.a.u.h.b(a2, f2);
                    b.a.p0.a.c1.b.j().c(this.f8316g.a().g(), bVar2.a());
                    k.O(this.f8314e, com.baidu.pass.biometrics.face.liveness.b.a.g0, f2);
                    bVar = bVar2;
                }
                this.f8316g.d(this.f8315f, bVar);
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements b.a.p0.a.v2.e1.b<i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8317e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f8318f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f8319g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f8320h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ b f8321i;

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
            this.f8321i = bVar;
            this.f8317e = str;
            this.f8318f = str2;
            this.f8319g = str3;
            this.f8320h = str4;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (b.a.p0.a.e2.c.d.h(iVar)) {
                    if (b.a.p0.a.u.c.d.f8000c) {
                        b.a.p0.a.e0.d.h("Api-Setting", "onCallback: has permission scope_userinfo_api");
                    }
                    this.f8321i.x(this.f8317e, this.f8318f, this.f8319g, this.f8320h);
                    return;
                }
                b.a.p0.a.e0.d.h("Api-Setting", "onCallback: no permission scope_userinfo_api");
                this.f8321i.d(this.f8318f, new b.a.p0.a.u.h.b(402));
            }
        }
    }

    /* loaded from: classes.dex */
    public class f implements b.a.p0.a.m.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8322e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f8323f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f8324g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Activity f8325h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f8326i;
        public final /* synthetic */ b j;

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
            this.j = bVar;
            this.f8322e = str;
            this.f8323f = str2;
            this.f8324g = str3;
            this.f8325h = activity;
            this.f8326i = str4;
        }

        @Override // b.a.p0.a.m.a
        public void onResult(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                if (i2 != 0) {
                    k.M(com.baidu.pass.biometrics.face.liveness.b.a.g0, 3, this.f8322e);
                    k.O(this.f8323f, com.baidu.pass.biometrics.face.liveness.b.a.g0, "login failed");
                    this.j.d(this.f8324g, new b.a.p0.a.u.h.b(10004, "user not logged in"));
                    return;
                }
                k.M("success", 3, this.f8322e);
                this.j.D(false, this.f8324g, this.f8325h, this.f8326i, "snsapi_userinfo", this.f8323f);
            }
        }
    }

    /* loaded from: classes.dex */
    public class g implements b.a.p0.a.m.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8327e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f8328f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f8329g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ boolean f8330h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Activity f8331i;
        public final /* synthetic */ String j;
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
            this.f8327e = str;
            this.f8328f = str2;
            this.f8329g = str3;
            this.f8330h = z;
            this.f8331i = activity;
            this.j = str4;
        }

        @Override // b.a.p0.a.m.a
        public void onResult(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                if (i2 != 0) {
                    k.M(com.baidu.pass.biometrics.face.liveness.b.a.g0, 3, this.f8327e);
                    k.O(this.f8328f, com.baidu.pass.biometrics.face.liveness.b.a.g0, "result code = " + i2);
                    this.k.d(this.f8329g, new b.a.p0.a.u.h.b(10004, "user not logged in"));
                    return;
                }
                k.M("success", 3, this.f8327e);
                this.k.D(this.f8330h, this.f8329g, this.f8331i, this.j, "snsapi_userinfo", this.f8328f);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static String a(b.a.p0.a.a2.e eVar) {
            InterceptResult invokeL;
            String k;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, eVar)) == null) {
                if (eVar == null) {
                    k = b.a.p0.a.a2.d.g().r().k();
                } else {
                    k = eVar.k();
                }
                return "aiapp_" + k + "getSwanId";
            }
            return (String) invokeL.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@NonNull b.a.p0.a.u.c.b bVar) {
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
                super((b.a.p0.a.u.c.b) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static void E(CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, callbackHandler, str) == null) {
            b.a.p0.a.n1.q.c.a.h(new c(callbackHandler, str));
        }
    }

    public static JSONObject w(b.a.p0.a.a2.e eVar, Context context) throws JSONException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, eVar, context)) == null) {
            b.a K = eVar.K();
            String S = K.S();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("appid", K.G());
            jSONObject.put("appname", K.J());
            if (!TextUtils.isEmpty(K.P())) {
                jSONObject.put("iconUrl", K.P());
            }
            if (!TextUtils.isEmpty(K.V())) {
                jSONObject.put("appLaunchScheme", K.V());
            } else {
                jSONObject.put("appLaunchScheme", "");
            }
            PMSAppInfo e0 = K.e0();
            if (e0 != null) {
                String str = e0.description;
                if (!TextUtils.isEmpty(str)) {
                    jSONObject.put("appDesc", str);
                }
                String str2 = e0.paNumber;
                if (!TextUtils.isEmpty(str2)) {
                    jSONObject.put(com.alipay.sdk.cons.b.k, str2);
                }
                jSONObject.put("isOpenCustomerService", q0.P());
            }
            String i2 = b.a.p0.a.c1.a.a0().i(context);
            jSONObject.put("cuid", i2);
            jSONObject.put("mtjCuid", i2);
            jSONObject.put("clkid", K.K());
            jSONObject.put("scene", S);
            jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, K.G());
            Bundle O = K.O();
            if (O != null) {
                String string = O.getString(PrefetchEvent.EVENT_DATA_EXTRA_DATA);
                if (!TextUtils.isEmpty(string)) {
                    jSONObject.put(PrefetchEvent.EVENT_DATA_EXTRA_DATA, new JSONObject(string));
                }
                if (!TextUtils.isEmpty(O.getString("srcAppId"))) {
                    jSONObject.put("srcAppId", O.getString("srcAppId"));
                }
                if (!TextUtils.isEmpty(O.getString("srcAppPage"))) {
                    jSONObject.put("srcAppPage", O.getString("srcAppPage"));
                }
                if (TextUtils.isEmpty(S)) {
                    S = AdParamInfo.AdClickActionString.AD_CLICK_ACTION_NA;
                }
                String string2 = O.getString(UBCCloudControlProcessor.UBC_KEY);
                if (!TextUtils.isEmpty(string2)) {
                    jSONObject.put("rootSource", b.a.p0.t.c.a(new JSONObject(string2), "pre_source", S));
                }
                SwanAppActivity activity = b.a.p0.a.g1.f.T().getActivity();
                String showBy = activity != null ? activity.getShowBy() : "sys";
                String str3 = TextUtils.isEmpty(showBy) ? "sys" : showBy;
                if (b.a.p0.a.u.c.d.f8000c) {
                    String str4 = "showBy: " + str3;
                }
                jSONObject.put("showBy", str3);
            }
            return jSONObject;
        }
        return (JSONObject) invokeLL.objValue;
    }

    public b.a.p0.a.u.h.b A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            boolean z = b.a.p0.a.u.c.d.f8000c;
            String containerId = a().f().getContainerId();
            if (TextUtils.isEmpty(containerId)) {
                return new b.a.p0.a.u.h.b(1001);
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("slaveId", containerId);
                return new b.a.p0.a.u.h.b(0, jSONObject);
            } catch (JSONException e2) {
                if (b.a.p0.a.u.c.d.f8000c) {
                    Log.getStackTraceString(e2);
                }
                return new b.a.p0.a.u.h.b(1001);
            }
        }
        return (b.a.p0.a.u.h.b) invokeV.objValue;
    }

    public b.a.p0.a.u.h.b B(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            b.a.p0.a.a2.e r = b.a.p0.a.a2.d.g().r();
            return j(str, new a(this, "getSwanId", w.d(r.S().q(h.a(r), null))));
        }
        return (b.a.p0.a.u.h.b) invokeL.objValue;
    }

    public b.a.p0.a.u.h.b C(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            boolean z = b.a.p0.a.u.c.d.f8000c;
            b.a.p0.a.p.b.a.h j = b.a.p0.a.c1.b.j();
            b.a.p0.a.a2.e r = b.a.p0.a.a2.d.g().r();
            CallbackHandler g2 = a().g();
            if (r == null) {
                j.c(g2, UnitedSchemeUtility.wrapCallbackParams(1001, "empty swanApp").toString());
                return new b.a.p0.a.u.h.b(1001, "empty swanApp");
            } else if (TextUtils.isEmpty(r.k())) {
                j.c(g2, UnitedSchemeUtility.wrapCallbackParams(1001, "empty clientId").toString());
                return new b.a.p0.a.u.h.b(1001, "empty clientId");
            } else {
                JSONObject l = b.a.p0.a.u.c.d.l(str);
                if (l == null) {
                    j.c(g2, UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams").toString());
                    return new b.a.p0.a.u.h.b(201, "empty joParams");
                }
                String f2 = b.a.p0.a.t1.g.b.f(l.optString("__plugin__", null));
                boolean z2 = !TextUtils.isEmpty(f2);
                boolean i2 = b.a.p0.a.e2.c.d.i(l);
                String str2 = (i2 || z2) ? "getUserInfoButton" : "getUserInfoApi";
                k.N(str2, "create");
                String optString = l.optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    j.c(g2, UnitedSchemeUtility.wrapCallbackParams(201, "empty cb").toString());
                    k.O(str2, com.baidu.pass.biometrics.face.liveness.b.a.g0, "empty cb");
                    return new b.a.p0.a.u.h.b(201, "empty cb");
                }
                SwanAppActivity x = r.x();
                if (x == null) {
                    j.c(g2, UnitedSchemeUtility.wrapCallbackParams(1001, "the context is not an activity").toString());
                    k.O(str2, com.baidu.pass.biometrics.face.liveness.b.a.g0, "the context is not an activity");
                    return new b.a.p0.a.u.h.b(1001, "the context is not an activity");
                }
                String optString2 = l.optString("invokeFrom");
                if (!r.j().e(x)) {
                    k.M("show", 3, optString2);
                }
                if (!i2 && !z2) {
                    F(f2, optString, optString2, str2);
                } else {
                    G(f2, i2, optString, optString2, str2);
                }
                return new b.a.p0.a.u.h.b(0);
            }
        }
        return (b.a.p0.a.u.h.b) invokeL.objValue;
    }

    public final void D(boolean z, String str, Activity activity, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Boolean.valueOf(z), str, activity, str2, str3, str4}) == null) {
            k.N(str4, "requestOpenData");
            k.N(str4, "checkScope");
            b.a.p0.a.e2.d.a.C(activity, str3, str2, z, str4, new d(this, str4, str));
        }
    }

    public final void F(String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048580, this, str, str2, str3, str4) == null) {
            k.N(str4, "checkScope");
            b.a.p0.a.a2.d.g().r().S().g(getContext(), "scope_userinfo_api", new e(this, str, str2, str3, str4));
        }
    }

    public final void G(String str, boolean z, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{str, Boolean.valueOf(z), str2, str3, str4}) == null) {
            b.a.p0.a.a2.e r = b.a.p0.a.a2.d.g().r();
            SwanAppActivity x = r.x();
            b.a.p0.a.m.b j = r.j();
            if (j.e(x)) {
                D(z, str2, x, str, "snsapi_userinfo", str4);
                return;
            }
            k.N(str4, "getUserInfoLogin");
            j.f(x, null, new g(this, str3, str4, str2, z, x, str));
        }
    }

    public final boolean v(JSONObject jSONObject) {
        InterceptResult invokeL;
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, jSONObject)) == null) {
            if (jSONObject == null || (optJSONObject = jSONObject.optJSONObject("data")) == null) {
                return false;
            }
            String optString = optJSONObject.optString("swanid");
            return (TextUtils.isEmpty(optString) || TextUtils.equals(StringUtil.NULL_STRING, optString)) ? false : true;
        }
        return invokeL.booleanValue;
    }

    public final void x(String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048583, this, str, str2, str3, str4) == null) {
            b.a.p0.a.a2.e r = b.a.p0.a.a2.d.g().r();
            SwanAppActivity x = r.x();
            b.a.p0.a.m.b j = r.j();
            if (j.e(x)) {
                D(false, str2, x, str, "snsapi_userinfo", str4);
                return;
            }
            k.N(str4, "getUserInfoLogin");
            j.f(x, null, new f(this, str3, str4, str2, x, str));
        }
    }

    public b.a.p0.a.u.h.b y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            b.a.p0.a.e0.d.a("Api-Setting", "start get app info sync");
            b.a.p0.a.a2.e P = b.a.p0.a.a2.e.P();
            if (P == null) {
                b.a.p0.a.e0.d.a("Api-Setting", "illegal swanApp");
                return new b.a.p0.a.u.h.b(1001, "illegal swanApp");
            }
            JSONObject d2 = b.a.p0.a.r1.k.g.a.c().d("getAppInfoSync");
            if (d2 == null) {
                try {
                    d2 = w(P, getContext());
                    b.a.p0.a.r1.k.g.a.c().h("getAppInfoSync", d2);
                } catch (JSONException e2) {
                    b.a.p0.a.e0.d.b("Api-Setting", Log.getStackTraceString(e2));
                    return new b.a.p0.a.u.h.b(1001);
                }
            }
            if (b.a.p0.a.u.c.d.f8000c && d2 != null) {
                String str = "data: " + d2.toString();
            }
            return new b.a.p0.a.u.h.b(0, d2);
        }
        return (b.a.p0.a.u.h.b) invokeV.objValue;
    }

    public b.a.p0.a.u.h.b z(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            boolean z = b.a.p0.a.u.c.d.f8000c;
            return i(str, true, new C0408b(this));
        }
        return (b.a.p0.a.u.h.b) invokeL.objValue;
    }
}
