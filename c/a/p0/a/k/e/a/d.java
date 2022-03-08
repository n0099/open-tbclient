package c.a.p0.a.k.e.a;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.d2.n;
import c.a.p0.a.x1.c.i;
import c.a.p0.a.x1.c.j.b;
import c.a.p0.a.x1.c.j.f;
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
import org.apache.commons.lang3.text.ExtendedMessageFormat;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d extends c.a.p0.a.k.e.a.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f5881f;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements c.a.p0.a.p2.g1.c<i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.t1.e f5882e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Activity f5883f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ JSONObject f5884g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f5885h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f5886i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ String f5887j;
        public final /* synthetic */ d k;

        public a(d dVar, c.a.p0.a.t1.e eVar, Activity activity, JSONObject jSONObject, CallbackHandler callbackHandler, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, eVar, activity, jSONObject, callbackHandler, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.k = dVar;
            this.f5882e = eVar;
            this.f5883f = activity;
            this.f5884g = jSONObject;
            this.f5885h = callbackHandler;
            this.f5886i = str;
            this.f5887j = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.a.p2.g1.c
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (c.a.p0.a.x1.c.d.h(iVar)) {
                    boolean unused = d.f5881f;
                    d.D(this.f5882e, this.f5883f, this.f5884g, this.f5885h, this.f5886i, true, this.f5887j);
                    return;
                }
                if (!this.f5882e.M().e(this.f5883f)) {
                    n.S("check_fail", 1, RetrieveTaskManager.KEY);
                }
                int b2 = iVar.b();
                String f2 = c.a.p0.a.x1.c.d.f(b2);
                d dVar = this.k;
                dVar.p("#login errCode=" + b2 + " errMsg=" + f2, null, false);
                this.k.d(this.f5886i, new c.a.p0.a.k.h.b(b2, c.a.p0.a.x1.c.d.f(b2)));
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b implements c.a.p0.a.p2.g1.c<i<f.d>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f5888e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f5889f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ JSONObject f5890g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ C0338d f5891h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f5892i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ String f5893j;
        public final /* synthetic */ c.a.p0.a.t1.e k;
        public final /* synthetic */ String l;

        public b(boolean z, boolean z2, JSONObject jSONObject, C0338d c0338d, CallbackHandler callbackHandler, String str, c.a.p0.a.t1.e eVar, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Boolean.valueOf(z), Boolean.valueOf(z2), jSONObject, c0338d, callbackHandler, str, eVar, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5888e = z;
            this.f5889f = z2;
            this.f5890g = jSONObject;
            this.f5891h = c0338d;
            this.f5892i = callbackHandler;
            this.f5893j = str;
            this.k = eVar;
            this.l = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.a.p2.g1.c
        /* renamed from: a */
        public void onCallback(i<f.d> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                c.a.p0.a.u.d.k("LoginApi", "#handleLogin errCode=" + iVar.b() + " error=" + iVar.a());
                if (!iVar.c()) {
                    if (!this.f5888e && this.f5889f) {
                        n.S(com.baidu.pass.biometrics.face.liveness.b.a.g0, 1, this.f5890g.optString("invokeFrom"));
                        c.a.p0.a.u.d.k("LoginApi", "Error: login failed from api-invoking.");
                    }
                    int b2 = iVar.b();
                    c.a.p0.a.u.d.o("LoginApi", b2 + " " + this.f5891h.toString());
                    String f2 = c.a.p0.a.x1.c.d.f(b2);
                    this.f5892i.handleSchemeDispatchCallback(this.f5893j, UnitedSchemeUtility.wrapCallbackParams(b2, f2).toString());
                    c.a.p0.a.s0.b.j().f(this.f5892i, UnitedSchemeUtility.wrapCallbackParams(b2, f2).toString());
                    d.J(this.k, 43, b2, f2);
                    String str = "#handleLogin [login failed] errCode=" + b2 + " errMsg=" + f2;
                    c.a.p0.a.u.d.k("LoginApi", str);
                    n.U(this.l, com.baidu.pass.biometrics.face.liveness.b.a.g0, str);
                    return;
                }
                if (!this.f5888e && this.f5889f) {
                    n.S("success", 1, this.f5890g.optString("invokeFrom"));
                    c.a.p0.a.u.d.k("LoginApi", "Success: login success from api-invoking.");
                }
                if (d.G(this.f5890g)) {
                    this.f5892i.handleSchemeDispatchCallback(this.f5893j, UnitedSchemeUtility.wrapCallbackParams(0).toString());
                    c.a.p0.a.u.d.k("LoginApi", "Success: login success from component-invoking.");
                    n.U(this.l, "success", "Success: login success from component-invoking.");
                    return;
                }
                n.T(this.l, "getLoginCodeStart");
                if (TextUtils.isEmpty(iVar.a.a)) {
                    this.f5892i.handleSchemeDispatchCallback(this.f5893j, UnitedSchemeUtility.wrapCallbackParams(1001, "empty code").toString());
                    c.a.p0.a.s0.b.j().f(this.f5892i, UnitedSchemeUtility.wrapCallbackParams(1001, "empty code").toString());
                    d.J(this.k, 43, 1001, "empty code");
                    n.U(this.l, com.baidu.pass.biometrics.face.liveness.b.a.g0, "empty code");
                    return;
                }
                String optString = this.f5890g.optString("__plugin__");
                if (!TextUtils.isEmpty(optString)) {
                    d.E(optString, this.k, this.f5892i, this.f5893j, iVar, this.l);
                } else {
                    d.F(this.k, this.f5892i, this.f5893j, iVar, this.l);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class c implements c.a.p0.a.p2.g1.c<c.a.p0.a.x1.d.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f5894e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f5895f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f5896g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f5897h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.t1.e f5898i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ i f5899j;

        public c(CallbackHandler callbackHandler, String str, String str2, String str3, c.a.p0.a.t1.e eVar, i iVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {callbackHandler, str, str2, str3, eVar, iVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5894e = callbackHandler;
            this.f5895f = str;
            this.f5896g = str2;
            this.f5897h = str3;
            this.f5898i = eVar;
            this.f5899j = iVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.a.p2.g1.c
        /* renamed from: a */
        public void onCallback(c.a.p0.a.x1.d.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                if (aVar != null && aVar.D()) {
                    d.F(this.f5898i, this.f5894e, this.f5895f, this.f5899j, this.f5897h);
                    return;
                }
                this.f5894e.handleSchemeDispatchCallback(this.f5895f, UnitedSchemeUtility.wrapCallbackParams(403, "permission denied").toString());
                String str = "Error: scope snsapi_userinfopermission denied plugin appkey : " + this.f5896g + " from plugin-invoking.";
                c.a.p0.a.u.d.k("LoginApi", str);
                n.U(this.f5897h, com.baidu.pass.biometrics.face.liveness.b.a.g0, str);
            }
        }
    }

    /* renamed from: c.a.p0.a.k.e.a.d$d  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0338d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final boolean a;

        /* renamed from: b  reason: collision with root package name */
        public final long f5900b;

        public C0338d(@NonNull JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jSONObject.has(com.alipay.sdk.data.a.O);
            long optLong = jSONObject.optLong(com.alipay.sdk.data.a.O, 0L);
            this.f5900b = optLong;
            if (optLong < 0) {
                c.a.p0.a.u.d.o("LoginApi", "timeout is a minus：" + toString());
            }
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return "LoginTimeoutConfig{enableTimeout=" + this.a + ", timeoutMills=" + this.f5900b + ExtendedMessageFormat.END_FE;
            }
            return (String) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(874849866, "Lc/a/p0/a/k/e/a/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(874849866, "Lc/a/p0/a/k/e/a/d;");
                return;
            }
        }
        f5881f = c.a.p0.a.a.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(@NonNull c.a.p0.a.k.c.b bVar) {
        super(bVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((c.a.p0.a.k.c.b) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public static void D(c.a.p0.a.t1.e eVar, Activity activity, JSONObject jSONObject, CallbackHandler callbackHandler, String str, boolean z, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{eVar, activity, jSONObject, callbackHandler, str, Boolean.valueOf(z), str2}) == null) {
            String optString = jSONObject.optString("invokeFrom");
            boolean e2 = eVar.M().e(activity);
            if (!e2) {
                n.S("show", 1, optString);
            }
            C0338d c0338d = new C0338d(jSONObject);
            eVar.d0().r(activity, c0338d, null, new b(e2, z, jSONObject, c0338d, callbackHandler, str, eVar, str2), str2);
        }
    }

    public static void E(String str, c.a.p0.a.t1.e eVar, CallbackHandler callbackHandler, String str2, i<f.d> iVar, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65541, null, new Object[]{str, eVar, callbackHandler, str2, iVar, str3}) == null) {
            SwanAppActivity x = eVar.x();
            if (x == null) {
                callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(1001, "swan activity is null").toString());
                c.a.p0.a.u.d.k("LoginApi", "Error: activity is null from plugin-invoking.");
                n.U(str3, com.baidu.pass.biometrics.face.liveness.b.a.g0, "swan activity is null");
                return;
            }
            String f2 = c.a.p0.a.m1.h.b.f(str);
            c.a.p0.a.x1.d.a.B(x, "snsapi_userinfo", f2, false, str3, new c(callbackHandler, str2, f2, str3, eVar, iVar));
        }
    }

    public static void F(c.a.p0.a.t1.e eVar, CallbackHandler callbackHandler, String str, i<f.d> iVar, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65542, null, eVar, callbackHandler, str, iVar, str2) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("code", iVar.a.a);
                c.a.p0.a.u.d.k("LoginApi", "Success: call back msg = " + jSONObject.toString());
                c.a.p0.a.q1.c.f7155c.e();
                callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(jSONObject, iVar.b()).toString());
                n.T(str2, "success");
            } catch (JSONException e2) {
                if (f5881f) {
                    e2.printStackTrace();
                }
                callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(1001, e2.getMessage()).toString());
                c.a.p0.a.s0.b.j().f(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(1001, e2.getMessage()).toString());
                J(eVar, 43, 1001, e2.getMessage());
                String str3 = "Error: exception = " + e2.getMessage() + " stack trace = " + Arrays.toString(e2.getStackTrace());
                c.a.p0.a.u.d.k("LoginApi", str3);
                n.U(str2, com.baidu.pass.biometrics.face.liveness.b.a.g0, str3);
            }
        }
    }

    public static boolean G(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, jSONObject)) == null) ? "component".equals(jSONObject.optString("invokeFrom")) : invokeL.booleanValue;
    }

    public static void J(c.a.p0.a.t1.e eVar, int i2, int i3, String str) {
        int l;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65544, null, new Object[]{eVar, Integer.valueOf(i2), Integer.valueOf(i3), str}) == null) && eVar != null && (l = eVar.l()) == 0) {
            c.a.p0.a.k2.a aVar = new c.a.p0.a.k2.a();
            aVar.k(5L);
            aVar.i(i2);
            c.a.p0.a.d2.s.d dVar = new c.a.p0.a.d2.s.d();
            dVar.p(aVar);
            dVar.r(eVar.X());
            dVar.q(n.n(l));
            dVar.m(c.a.p0.a.t1.e.f0());
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("errorCode", i3);
                jSONObject.put("errorMessage", str);
            } catch (JSONException e2) {
                if (f5881f) {
                    e2.printStackTrace();
                }
            }
            dVar.e(jSONObject);
            n.R(dVar);
        }
    }

    public c.a.p0.a.k.h.b C(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            q("#getLoginCode", false);
            if (f5881f) {
                String str2 = "#getLoginCode params=" + str;
            }
            n.T("getLoginCode", "create");
            CallbackHandler h2 = a().h();
            c.a.p0.a.t1.e a0 = c.a.p0.a.t1.e.a0();
            if (a0 == null) {
                c.a.p0.a.s0.b.j().f(h2, UnitedSchemeUtility.wrapCallbackParams(1001, "swan app is null").toString());
                return new c.a.p0.a.k.h.b(1001, "swan app is null");
            } else if (!a0.M().e(getContext())) {
                n.T("getLoginCode", com.baidu.pass.biometrics.face.liveness.b.a.g0);
                return new c.a.p0.a.k.h.b(10004, "user not logged in");
            } else {
                JSONObject r = c.a.p0.a.k.c.d.r(str);
                if (r == null) {
                    c.a.p0.a.s0.b.j().f(h2, UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams").toString());
                    J(a0, 1, 201, "empty joParams");
                    n.T("getLoginCode", com.baidu.pass.biometrics.face.liveness.b.a.g0);
                    return new c.a.p0.a.k.h.b(201, "empty joParams");
                }
                String optString = r.optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    c.a.p0.a.s0.b.j().f(h2, UnitedSchemeUtility.wrapCallbackParams(201, "cb is empty").toString());
                    J(a0, 1, 201, "cb is empty");
                    n.T("getLoginCode", com.baidu.pass.biometrics.face.liveness.b.a.g0);
                    return new c.a.p0.a.k.h.b(201, "cb is empty");
                }
                Context context = getContext();
                if (!(context instanceof Activity) && (context = a0.x()) == null) {
                    n.T("getLoginCode", com.baidu.pass.biometrics.face.liveness.b.a.g0);
                    return new c.a.p0.a.k.h.b(1001, "the context is not an activity");
                }
                Activity activity = (Activity) context;
                if (!c.a.p0.a.t1.d.J().r().M().e(context)) {
                    n.T("getLoginCode", "passLogin");
                }
                D(a0, activity, r, h2, optString, false, "getLoginCode");
                return c.a.p0.a.k.h.b.f();
            }
        }
        return (c.a.p0.a.k.h.b) invokeL.objValue;
    }

    public c.a.p0.a.k.h.b H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            q("#isLoginSync", false);
            c.a.p0.a.t1.e a0 = c.a.p0.a.t1.e.a0();
            if (a0 == null) {
                c.a.p0.a.u.d.c("LoginApi", "swan app is null");
                return new c.a.p0.a.k.h.b(202, "swan app is null");
            }
            JSONObject d2 = c.a.p0.a.k1.k.g.a.c().d("isLoginSync");
            if (d2 == null) {
                try {
                    d2 = new JSONObject();
                    d2.put("isLogin", a0.M().e(getContext()));
                    c.a.p0.a.k1.k.g.a.c().h("isLoginSync", d2);
                } catch (JSONException unused) {
                    c.a.p0.a.u.d.c("LoginApi", "json put data fail");
                    return new c.a.p0.a.k.h.b(1001);
                }
            }
            return new c.a.p0.a.k.h.b(0, d2);
        }
        return (c.a.p0.a.k.h.b) invokeV.objValue;
    }

    public c.a.p0.a.k.h.b I(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            q("#login params=" + str, false);
            c.a.p0.a.t1.e a0 = c.a.p0.a.t1.e.a0();
            CallbackHandler h2 = a().h();
            if (a0 == null) {
                c.a.p0.a.s0.b.j().f(h2, UnitedSchemeUtility.wrapCallbackParams(1001, "swan app is null").toString());
                c.a.p0.a.u.d.k("LoginApi", "Error: swan app is null");
                return new c.a.p0.a.k.h.b(1001, "swan app is null");
            }
            JSONObject r = c.a.p0.a.k.c.d.r(str);
            if (r == null) {
                c.a.p0.a.s0.b.j().f(h2, UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams").toString());
                J(a0, 1, 201, "empty joParams");
                p("Error: empty joParams", null, true);
                return new c.a.p0.a.k.h.b(201, "empty joParams");
            }
            String str2 = r.optString("invokeFrom").equals("component") ? "loginButton" : "loginApi";
            n.T(str2, "create");
            String optString = r.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                c.a.p0.a.s0.b.j().f(h2, UnitedSchemeUtility.wrapCallbackParams(201, "cb is empty").toString());
                J(a0, 1, 201, "cb is empty");
                p("Error: cb is empty", null, true);
                return new c.a.p0.a.k.h.b(201, "cb is empty");
            } else if (!r.optBoolean(TTDownloadField.TT_FORCE, true) && !a0.M().e(getContext())) {
                h2.handleSchemeDispatchCallback(optString, UnitedSchemeUtility.wrapCallbackParams(10004, "user not logged in").toString());
                c.a.p0.a.s0.b.j().f(h2, UnitedSchemeUtility.wrapCallbackParams(10004, "user not logged in").toString());
                J(a0, 43, 10004, "user not logged in");
                q("Success: force login is false, will not force execute login.", false);
                return new c.a.p0.a.k.h.b(0);
            } else {
                Context context = getContext();
                if (!(context instanceof Activity) && (context = a0.x()) == null) {
                    p("Error: context is not an activity", null, false);
                    return new c.a.p0.a.k.h.b(1001, "the context is not an activity");
                }
                Activity activity = (Activity) context;
                if (!c.a.p0.a.t1.d.J().r().M().e(context)) {
                    n.T(str2, "passLogin");
                }
                String optString2 = r.optString("__plugin__");
                if (!TextUtils.isEmpty(optString2)) {
                    p("handleLogin by plugin: " + optString2, null, false);
                    D(a0, activity, r, h2, optString, true, str2);
                    return new c.a.p0.a.k.h.b(0);
                }
                if (!c.a.p0.a.x1.c.d.i(r)) {
                    D(a0, activity, r, h2, optString, true, str2);
                } else {
                    c.a.p0.a.t1.d.J().r().d0().g(getContext(), "scope_login_api", new a(this, a0, activity, r, h2, optString, str2));
                }
                return c.a.p0.a.k.h.b.f();
            }
        }
        return (c.a.p0.a.k.h.b) invokeL.objValue;
    }

    @Override // c.a.p0.a.k.c.d
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? "LoginApi" : (String) invokeV.objValue;
    }
}
