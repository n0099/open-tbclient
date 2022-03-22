package c.a.n0.a.k.e.a;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.n0.a.d2.n;
import c.a.n0.a.x1.c.i;
import c.a.n0.a.x1.c.j.b;
import c.a.n0.a.x1.c.j.f;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.retrieve.RetrieveTaskManager;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d extends c.a.n0.a.k.e.a.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f4960f;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements c.a.n0.a.p2.g1.c<i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.n0.a.t1.e a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Activity f4961b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ JSONObject f4962c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f4963d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f4964e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f4965f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d f4966g;

        public a(d dVar, c.a.n0.a.t1.e eVar, Activity activity, JSONObject jSONObject, CallbackHandler callbackHandler, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, eVar, activity, jSONObject, callbackHandler, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4966g = dVar;
            this.a = eVar;
            this.f4961b = activity;
            this.f4962c = jSONObject;
            this.f4963d = callbackHandler;
            this.f4964e = str;
            this.f4965f = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.n0.a.p2.g1.c
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (c.a.n0.a.x1.c.d.h(iVar)) {
                    if (d.f4960f) {
                        Log.i("LoginApi", "onCallback: has permissionscope_login_api");
                    }
                    d.D(this.a, this.f4961b, this.f4962c, this.f4963d, this.f4964e, true, this.f4965f);
                    return;
                }
                if (!this.a.M().e(this.f4961b)) {
                    n.S("check_fail", 1, RetrieveTaskManager.KEY);
                }
                int b2 = iVar.b();
                String f2 = c.a.n0.a.x1.c.d.f(b2);
                d dVar = this.f4966g;
                dVar.p("#login errCode=" + b2 + " errMsg=" + f2, null, false);
                this.f4966g.d(this.f4964e, new c.a.n0.a.k.h.b(b2, c.a.n0.a.x1.c.d.f(b2)));
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b implements c.a.n0.a.p2.g1.c<i<f.d>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f4967b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ JSONObject f4968c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ C0326d f4969d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f4970e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f4971f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.t1.e f4972g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f4973h;

        public b(boolean z, boolean z2, JSONObject jSONObject, C0326d c0326d, CallbackHandler callbackHandler, String str, c.a.n0.a.t1.e eVar, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Boolean.valueOf(z), Boolean.valueOf(z2), jSONObject, c0326d, callbackHandler, str, eVar, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = z;
            this.f4967b = z2;
            this.f4968c = jSONObject;
            this.f4969d = c0326d;
            this.f4970e = callbackHandler;
            this.f4971f = str;
            this.f4972g = eVar;
            this.f4973h = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.n0.a.p2.g1.c
        /* renamed from: a */
        public void onCallback(i<f.d> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                c.a.n0.a.u.d.k("LoginApi", "#handleLogin errCode=" + iVar.b() + " error=" + iVar.a());
                if (!iVar.c()) {
                    if (!this.a && this.f4967b) {
                        n.S(com.baidu.pass.biometrics.face.liveness.b.a.g0, 1, this.f4968c.optString("invokeFrom"));
                        c.a.n0.a.u.d.k("LoginApi", "Error: login failed from api-invoking.");
                    }
                    int b2 = iVar.b();
                    c.a.n0.a.u.d.o("LoginApi", b2 + " " + this.f4969d.toString());
                    String f2 = c.a.n0.a.x1.c.d.f(b2);
                    this.f4970e.handleSchemeDispatchCallback(this.f4971f, UnitedSchemeUtility.wrapCallbackParams(b2, f2).toString());
                    c.a.n0.a.s0.b.j().f(this.f4970e, UnitedSchemeUtility.wrapCallbackParams(b2, f2).toString());
                    d.J(this.f4972g, 43, b2, f2);
                    String str = "#handleLogin [login failed] errCode=" + b2 + " errMsg=" + f2;
                    c.a.n0.a.u.d.k("LoginApi", str);
                    n.U(this.f4973h, com.baidu.pass.biometrics.face.liveness.b.a.g0, str);
                    return;
                }
                if (!this.a && this.f4967b) {
                    n.S("success", 1, this.f4968c.optString("invokeFrom"));
                    c.a.n0.a.u.d.k("LoginApi", "Success: login success from api-invoking.");
                }
                if (d.G(this.f4968c)) {
                    this.f4970e.handleSchemeDispatchCallback(this.f4971f, UnitedSchemeUtility.wrapCallbackParams(0).toString());
                    c.a.n0.a.u.d.k("LoginApi", "Success: login success from component-invoking.");
                    n.U(this.f4973h, "success", "Success: login success from component-invoking.");
                    return;
                }
                n.T(this.f4973h, "getLoginCodeStart");
                if (TextUtils.isEmpty(iVar.a.a)) {
                    this.f4970e.handleSchemeDispatchCallback(this.f4971f, UnitedSchemeUtility.wrapCallbackParams(1001, "empty code").toString());
                    c.a.n0.a.s0.b.j().f(this.f4970e, UnitedSchemeUtility.wrapCallbackParams(1001, "empty code").toString());
                    d.J(this.f4972g, 43, 1001, "empty code");
                    n.U(this.f4973h, com.baidu.pass.biometrics.face.liveness.b.a.g0, "empty code");
                    return;
                }
                String optString = this.f4968c.optString("__plugin__");
                if (!TextUtils.isEmpty(optString)) {
                    d.E(optString, this.f4972g, this.f4970e, this.f4971f, iVar, this.f4973h);
                } else {
                    d.F(this.f4972g, this.f4970e, this.f4971f, iVar, this.f4973h);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class c implements c.a.n0.a.p2.g1.c<c.a.n0.a.x1.d.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f4974b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f4975c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f4976d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.t1.e f4977e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ i f4978f;

        public c(CallbackHandler callbackHandler, String str, String str2, String str3, c.a.n0.a.t1.e eVar, i iVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {callbackHandler, str, str2, str3, eVar, iVar};
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
            this.f4974b = str;
            this.f4975c = str2;
            this.f4976d = str3;
            this.f4977e = eVar;
            this.f4978f = iVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.n0.a.p2.g1.c
        /* renamed from: a */
        public void onCallback(c.a.n0.a.x1.d.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                if (aVar != null && aVar.D()) {
                    d.F(this.f4977e, this.a, this.f4974b, this.f4978f, this.f4976d);
                    return;
                }
                this.a.handleSchemeDispatchCallback(this.f4974b, UnitedSchemeUtility.wrapCallbackParams(403, "permission denied").toString());
                String str = "Error: scope snsapi_userinfopermission denied plugin appkey : " + this.f4975c + " from plugin-invoking.";
                c.a.n0.a.u.d.k("LoginApi", str);
                n.U(this.f4976d, com.baidu.pass.biometrics.face.liveness.b.a.g0, str);
            }
        }
    }

    /* renamed from: c.a.n0.a.k.e.a.d$d  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0326d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final boolean a;

        /* renamed from: b  reason: collision with root package name */
        public final long f4979b;

        public C0326d(@NonNull JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jSONObject.has("timeout");
            long optLong = jSONObject.optLong("timeout", 0L);
            this.f4979b = optLong;
            if (optLong < 0) {
                c.a.n0.a.u.d.o("LoginApi", "timeout is a minus：" + toString());
            }
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return "LoginTimeoutConfig{enableTimeout=" + this.a + ", timeoutMills=" + this.f4979b + '}';
            }
            return (String) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1461655880, "Lc/a/n0/a/k/e/a/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1461655880, "Lc/a/n0/a/k/e/a/d;");
                return;
            }
        }
        f4960f = c.a.n0.a.a.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(@NonNull c.a.n0.a.k.c.b bVar) {
        super(bVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((c.a.n0.a.k.c.b) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public static void D(c.a.n0.a.t1.e eVar, Activity activity, JSONObject jSONObject, CallbackHandler callbackHandler, String str, boolean z, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{eVar, activity, jSONObject, callbackHandler, str, Boolean.valueOf(z), str2}) == null) {
            String optString = jSONObject.optString("invokeFrom");
            boolean e2 = eVar.M().e(activity);
            if (!e2) {
                n.S("show", 1, optString);
            }
            C0326d c0326d = new C0326d(jSONObject);
            eVar.d0().r(activity, c0326d, null, new b(e2, z, jSONObject, c0326d, callbackHandler, str, eVar, str2), str2);
        }
    }

    public static void E(String str, c.a.n0.a.t1.e eVar, CallbackHandler callbackHandler, String str2, i<f.d> iVar, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65541, null, new Object[]{str, eVar, callbackHandler, str2, iVar, str3}) == null) {
            SwanAppActivity x = eVar.x();
            if (x == null) {
                callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(1001, "swan activity is null").toString());
                c.a.n0.a.u.d.k("LoginApi", "Error: activity is null from plugin-invoking.");
                n.U(str3, com.baidu.pass.biometrics.face.liveness.b.a.g0, "swan activity is null");
                return;
            }
            String f2 = c.a.n0.a.m1.h.b.f(str);
            c.a.n0.a.x1.d.a.B(x, "snsapi_userinfo", f2, false, str3, new c(callbackHandler, str2, f2, str3, eVar, iVar));
        }
    }

    public static void F(c.a.n0.a.t1.e eVar, CallbackHandler callbackHandler, String str, i<f.d> iVar, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65542, null, eVar, callbackHandler, str, iVar, str2) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("code", iVar.a.a);
                c.a.n0.a.u.d.k("LoginApi", "Success: call back msg = " + jSONObject.toString());
                c.a.n0.a.q1.c.f5996c.e();
                callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(jSONObject, iVar.b()).toString());
                n.T(str2, "success");
            } catch (JSONException e2) {
                if (f4960f) {
                    e2.printStackTrace();
                }
                callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(1001, e2.getMessage()).toString());
                c.a.n0.a.s0.b.j().f(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(1001, e2.getMessage()).toString());
                J(eVar, 43, 1001, e2.getMessage());
                String str3 = "Error: exception = " + e2.getMessage() + " stack trace = " + Arrays.toString(e2.getStackTrace());
                c.a.n0.a.u.d.k("LoginApi", str3);
                n.U(str2, com.baidu.pass.biometrics.face.liveness.b.a.g0, str3);
            }
        }
    }

    public static boolean G(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, jSONObject)) == null) ? "component".equals(jSONObject.optString("invokeFrom")) : invokeL.booleanValue;
    }

    public static void J(c.a.n0.a.t1.e eVar, int i, int i2, String str) {
        int l;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65544, null, new Object[]{eVar, Integer.valueOf(i), Integer.valueOf(i2), str}) == null) && eVar != null && (l = eVar.l()) == 0) {
            c.a.n0.a.k2.a aVar = new c.a.n0.a.k2.a();
            aVar.k(5L);
            aVar.i(i);
            c.a.n0.a.d2.s.d dVar = new c.a.n0.a.d2.s.d();
            dVar.p(aVar);
            dVar.r(eVar.X());
            dVar.q(n.n(l));
            dVar.m(c.a.n0.a.t1.e.f0());
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("errorCode", i2);
                jSONObject.put("errorMessage", str);
            } catch (JSONException e2) {
                if (f4960f) {
                    e2.printStackTrace();
                }
            }
            dVar.e(jSONObject);
            n.R(dVar);
        }
    }

    public c.a.n0.a.k.h.b C(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            q("#getLoginCode", false);
            if (f4960f) {
                Log.d("LoginApi", "#getLoginCode params=" + str);
            }
            n.T("getLoginCode", "create");
            CallbackHandler i = a().i();
            c.a.n0.a.t1.e a0 = c.a.n0.a.t1.e.a0();
            if (a0 == null) {
                c.a.n0.a.s0.b.j().f(i, UnitedSchemeUtility.wrapCallbackParams(1001, "swan app is null").toString());
                return new c.a.n0.a.k.h.b(1001, "swan app is null");
            } else if (!a0.M().e(getContext())) {
                n.T("getLoginCode", com.baidu.pass.biometrics.face.liveness.b.a.g0);
                return new c.a.n0.a.k.h.b(10004, "user not logged in");
            } else {
                JSONObject r = c.a.n0.a.k.c.d.r(str);
                if (r == null) {
                    c.a.n0.a.s0.b.j().f(i, UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams").toString());
                    J(a0, 1, 201, "empty joParams");
                    n.T("getLoginCode", com.baidu.pass.biometrics.face.liveness.b.a.g0);
                    return new c.a.n0.a.k.h.b(201, "empty joParams");
                }
                String optString = r.optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    c.a.n0.a.s0.b.j().f(i, UnitedSchemeUtility.wrapCallbackParams(201, "cb is empty").toString());
                    J(a0, 1, 201, "cb is empty");
                    n.T("getLoginCode", com.baidu.pass.biometrics.face.liveness.b.a.g0);
                    return new c.a.n0.a.k.h.b(201, "cb is empty");
                }
                Context context = getContext();
                if (!(context instanceof Activity) && (context = a0.x()) == null) {
                    n.T("getLoginCode", com.baidu.pass.biometrics.face.liveness.b.a.g0);
                    return new c.a.n0.a.k.h.b(1001, "the context is not an activity");
                }
                Activity activity = (Activity) context;
                if (!c.a.n0.a.t1.d.J().r().M().e(context)) {
                    n.T("getLoginCode", "passLogin");
                }
                D(a0, activity, r, i, optString, false, "getLoginCode");
                return c.a.n0.a.k.h.b.f();
            }
        }
        return (c.a.n0.a.k.h.b) invokeL.objValue;
    }

    public c.a.n0.a.k.h.b H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            q("#isLoginSync", false);
            c.a.n0.a.t1.e a0 = c.a.n0.a.t1.e.a0();
            if (a0 == null) {
                c.a.n0.a.u.d.c("LoginApi", "swan app is null");
                return new c.a.n0.a.k.h.b(202, "swan app is null");
            }
            JSONObject d2 = c.a.n0.a.k1.k.g.a.c().d("isLoginSync");
            if (d2 == null) {
                try {
                    d2 = new JSONObject();
                    d2.put("isLogin", a0.M().e(getContext()));
                    c.a.n0.a.k1.k.g.a.c().h("isLoginSync", d2);
                } catch (JSONException unused) {
                    c.a.n0.a.u.d.c("LoginApi", "json put data fail");
                    return new c.a.n0.a.k.h.b(1001);
                }
            }
            return new c.a.n0.a.k.h.b(0, d2);
        }
        return (c.a.n0.a.k.h.b) invokeV.objValue;
    }

    public c.a.n0.a.k.h.b I(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            q("#login params=" + str, false);
            c.a.n0.a.t1.e a0 = c.a.n0.a.t1.e.a0();
            CallbackHandler i = a().i();
            if (a0 == null) {
                c.a.n0.a.s0.b.j().f(i, UnitedSchemeUtility.wrapCallbackParams(1001, "swan app is null").toString());
                c.a.n0.a.u.d.k("LoginApi", "Error: swan app is null");
                return new c.a.n0.a.k.h.b(1001, "swan app is null");
            }
            JSONObject r = c.a.n0.a.k.c.d.r(str);
            if (r == null) {
                c.a.n0.a.s0.b.j().f(i, UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams").toString());
                J(a0, 1, 201, "empty joParams");
                p("Error: empty joParams", null, true);
                return new c.a.n0.a.k.h.b(201, "empty joParams");
            }
            String str2 = r.optString("invokeFrom").equals("component") ? "loginButton" : "loginApi";
            n.T(str2, "create");
            String optString = r.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                c.a.n0.a.s0.b.j().f(i, UnitedSchemeUtility.wrapCallbackParams(201, "cb is empty").toString());
                J(a0, 1, 201, "cb is empty");
                p("Error: cb is empty", null, true);
                return new c.a.n0.a.k.h.b(201, "cb is empty");
            } else if (!r.optBoolean(TTDownloadField.TT_FORCE, true) && !a0.M().e(getContext())) {
                i.handleSchemeDispatchCallback(optString, UnitedSchemeUtility.wrapCallbackParams(10004, "user not logged in").toString());
                c.a.n0.a.s0.b.j().f(i, UnitedSchemeUtility.wrapCallbackParams(10004, "user not logged in").toString());
                J(a0, 43, 10004, "user not logged in");
                q("Success: force login is false, will not force execute login.", false);
                return new c.a.n0.a.k.h.b(0);
            } else {
                Context context = getContext();
                if (!(context instanceof Activity) && (context = a0.x()) == null) {
                    p("Error: context is not an activity", null, false);
                    return new c.a.n0.a.k.h.b(1001, "the context is not an activity");
                }
                Activity activity = (Activity) context;
                if (!c.a.n0.a.t1.d.J().r().M().e(context)) {
                    n.T(str2, "passLogin");
                }
                String optString2 = r.optString("__plugin__");
                if (!TextUtils.isEmpty(optString2)) {
                    p("handleLogin by plugin: " + optString2, null, false);
                    D(a0, activity, r, i, optString, true, str2);
                    return new c.a.n0.a.k.h.b(0);
                }
                if (!c.a.n0.a.x1.c.d.i(r)) {
                    D(a0, activity, r, i, optString, true, str2);
                } else {
                    c.a.n0.a.t1.d.J().r().d0().g(getContext(), "scope_login_api", new a(this, a0, activity, r, i, optString, str2));
                }
                return c.a.n0.a.k.h.b.f();
            }
        }
        return (c.a.n0.a.k.h.b) invokeL.objValue;
    }

    @Override // c.a.n0.a.k.c.d
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? "LoginApi" : (String) invokeV.objValue;
    }
}
