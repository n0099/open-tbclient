package c.a.r0.a.u.e.a;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.a.h2.c.i;
import c.a.r0.a.h2.c.j.b;
import c.a.r0.a.h2.c.j.f;
import c.a.r0.a.k;
import c.a.r0.a.n2.n;
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
public class d extends c.a.r0.a.u.e.a.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f9053f;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements c.a.r0.a.z2.g1.c<i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.d2.e f9054e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Activity f9055f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ JSONObject f9056g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f9057h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f9058i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ String f9059j;
        public final /* synthetic */ d k;

        public a(d dVar, c.a.r0.a.d2.e eVar, Activity activity, JSONObject jSONObject, CallbackHandler callbackHandler, String str, String str2) {
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
            this.f9054e = eVar;
            this.f9055f = activity;
            this.f9056g = jSONObject;
            this.f9057h = callbackHandler;
            this.f9058i = str;
            this.f9059j = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.r0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (c.a.r0.a.h2.c.d.h(iVar)) {
                    boolean unused = d.f9053f;
                    d.D(this.f9054e, this.f9055f, this.f9056g, this.f9057h, this.f9058i, true, this.f9059j);
                    return;
                }
                if (!this.f9054e.M().e(this.f9055f)) {
                    n.S("check_fail", 1, RetrieveTaskManager.KEY);
                }
                int b2 = iVar.b();
                String f2 = c.a.r0.a.h2.c.d.f(b2);
                d dVar = this.k;
                dVar.p("#login errCode=" + b2 + " errMsg=" + f2, null, false);
                this.k.d(this.f9058i, new c.a.r0.a.u.h.b(b2, c.a.r0.a.h2.c.d.f(b2)));
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b implements c.a.r0.a.z2.g1.c<i<f.d>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f9060e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f9061f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ JSONObject f9062g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ C0570d f9063h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f9064i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ String f9065j;
        public final /* synthetic */ c.a.r0.a.d2.e k;
        public final /* synthetic */ String l;

        public b(boolean z, boolean z2, JSONObject jSONObject, C0570d c0570d, CallbackHandler callbackHandler, String str, c.a.r0.a.d2.e eVar, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Boolean.valueOf(z), Boolean.valueOf(z2), jSONObject, c0570d, callbackHandler, str, eVar, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9060e = z;
            this.f9061f = z2;
            this.f9062g = jSONObject;
            this.f9063h = c0570d;
            this.f9064i = callbackHandler;
            this.f9065j = str;
            this.k = eVar;
            this.l = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.r0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(i<f.d> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                c.a.r0.a.e0.d.k("LoginApi", "#handleLogin errCode=" + iVar.b() + " error=" + iVar.a());
                if (!iVar.c()) {
                    if (!this.f9060e && this.f9061f) {
                        n.S(com.baidu.pass.biometrics.face.liveness.b.a.g0, 1, this.f9062g.optString("invokeFrom"));
                        c.a.r0.a.e0.d.k("LoginApi", "Error: login failed from api-invoking.");
                    }
                    int b2 = iVar.b();
                    c.a.r0.a.e0.d.o("LoginApi", b2 + " " + this.f9063h.toString());
                    String f2 = c.a.r0.a.h2.c.d.f(b2);
                    this.f9064i.handleSchemeDispatchCallback(this.f9065j, UnitedSchemeUtility.wrapCallbackParams(b2, f2).toString());
                    c.a.r0.a.c1.b.j().f(this.f9064i, UnitedSchemeUtility.wrapCallbackParams(b2, f2).toString());
                    d.J(this.k, 43, b2, f2);
                    String str = "#handleLogin [login failed] errCode=" + b2 + " errMsg=" + f2;
                    c.a.r0.a.e0.d.k("LoginApi", str);
                    n.U(this.l, com.baidu.pass.biometrics.face.liveness.b.a.g0, str);
                    return;
                }
                if (!this.f9060e && this.f9061f) {
                    n.S("success", 1, this.f9062g.optString("invokeFrom"));
                    c.a.r0.a.e0.d.k("LoginApi", "Success: login success from api-invoking.");
                }
                if (d.G(this.f9062g)) {
                    this.f9064i.handleSchemeDispatchCallback(this.f9065j, UnitedSchemeUtility.wrapCallbackParams(0).toString());
                    c.a.r0.a.e0.d.k("LoginApi", "Success: login success from component-invoking.");
                    n.U(this.l, "success", "Success: login success from component-invoking.");
                    return;
                }
                n.T(this.l, "getLoginCodeStart");
                if (TextUtils.isEmpty(iVar.a.a)) {
                    this.f9064i.handleSchemeDispatchCallback(this.f9065j, UnitedSchemeUtility.wrapCallbackParams(1001, "empty code").toString());
                    c.a.r0.a.c1.b.j().f(this.f9064i, UnitedSchemeUtility.wrapCallbackParams(1001, "empty code").toString());
                    d.J(this.k, 43, 1001, "empty code");
                    n.U(this.l, com.baidu.pass.biometrics.face.liveness.b.a.g0, "empty code");
                    return;
                }
                String optString = this.f9062g.optString("__plugin__");
                if (!TextUtils.isEmpty(optString)) {
                    d.E(optString, this.k, this.f9064i, this.f9065j, iVar, this.l);
                } else {
                    d.F(this.k, this.f9064i, this.f9065j, iVar, this.l);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class c implements c.a.r0.a.z2.g1.c<c.a.r0.a.h2.d.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f9066e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f9067f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f9068g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f9069h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.d2.e f9070i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ i f9071j;

        public c(CallbackHandler callbackHandler, String str, String str2, String str3, c.a.r0.a.d2.e eVar, i iVar) {
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
            this.f9066e = callbackHandler;
            this.f9067f = str;
            this.f9068g = str2;
            this.f9069h = str3;
            this.f9070i = eVar;
            this.f9071j = iVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.r0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(c.a.r0.a.h2.d.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                if (aVar != null && aVar.D()) {
                    d.F(this.f9070i, this.f9066e, this.f9067f, this.f9071j, this.f9069h);
                    return;
                }
                this.f9066e.handleSchemeDispatchCallback(this.f9067f, UnitedSchemeUtility.wrapCallbackParams(403, "permission denied").toString());
                String str = "Error: scope snsapi_userinfopermission denied plugin appkey : " + this.f9068g + " from plugin-invoking.";
                c.a.r0.a.e0.d.k("LoginApi", str);
                n.U(this.f9069h, com.baidu.pass.biometrics.face.liveness.b.a.g0, str);
            }
        }
    }

    /* renamed from: c.a.r0.a.u.e.a.d$d  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0570d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final boolean a;

        /* renamed from: b  reason: collision with root package name */
        public final long f9072b;

        public C0570d(@NonNull JSONObject jSONObject) {
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
            this.f9072b = optLong;
            if (optLong < 0) {
                c.a.r0.a.e0.d.o("LoginApi", "timeout is a minus：" + toString());
            }
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return "LoginTimeoutConfig{enableTimeout=" + this.a + ", timeoutMills=" + this.f9072b + ExtendedMessageFormat.END_FE;
            }
            return (String) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(536278018, "Lc/a/r0/a/u/e/a/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(536278018, "Lc/a/r0/a/u/e/a/d;");
                return;
            }
        }
        f9053f = k.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(@NonNull c.a.r0.a.u.c.b bVar) {
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
                super((c.a.r0.a.u.c.b) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public static void D(c.a.r0.a.d2.e eVar, Activity activity, JSONObject jSONObject, CallbackHandler callbackHandler, String str, boolean z, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{eVar, activity, jSONObject, callbackHandler, str, Boolean.valueOf(z), str2}) == null) {
            String optString = jSONObject.optString("invokeFrom");
            boolean e2 = eVar.M().e(activity);
            if (!e2) {
                n.S("show", 1, optString);
            }
            C0570d c0570d = new C0570d(jSONObject);
            eVar.d0().r(activity, c0570d, null, new b(e2, z, jSONObject, c0570d, callbackHandler, str, eVar, str2), str2);
        }
    }

    public static void E(String str, c.a.r0.a.d2.e eVar, CallbackHandler callbackHandler, String str2, i<f.d> iVar, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65541, null, new Object[]{str, eVar, callbackHandler, str2, iVar, str3}) == null) {
            SwanAppActivity x = eVar.x();
            if (x == null) {
                callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(1001, "swan activity is null").toString());
                c.a.r0.a.e0.d.k("LoginApi", "Error: activity is null from plugin-invoking.");
                n.U(str3, com.baidu.pass.biometrics.face.liveness.b.a.g0, "swan activity is null");
                return;
            }
            String f2 = c.a.r0.a.w1.h.b.f(str);
            c.a.r0.a.h2.d.a.B(x, "snsapi_userinfo", f2, false, str3, new c(callbackHandler, str2, f2, str3, eVar, iVar));
        }
    }

    public static void F(c.a.r0.a.d2.e eVar, CallbackHandler callbackHandler, String str, i<f.d> iVar, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65542, null, eVar, callbackHandler, str, iVar, str2) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("code", iVar.a.a);
                c.a.r0.a.e0.d.k("LoginApi", "Success: call back msg = " + jSONObject.toString());
                c.a.r0.a.a2.c.f5322c.e();
                callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(jSONObject, iVar.b()).toString());
                n.T(str2, "success");
            } catch (JSONException e2) {
                if (f9053f) {
                    e2.printStackTrace();
                }
                callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(1001, e2.getMessage()).toString());
                c.a.r0.a.c1.b.j().f(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(1001, e2.getMessage()).toString());
                J(eVar, 43, 1001, e2.getMessage());
                String str3 = "Error: exception = " + e2.getMessage() + " stack trace = " + Arrays.toString(e2.getStackTrace());
                c.a.r0.a.e0.d.k("LoginApi", str3);
                n.U(str2, com.baidu.pass.biometrics.face.liveness.b.a.g0, str3);
            }
        }
    }

    public static boolean G(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, jSONObject)) == null) ? "component".equals(jSONObject.optString("invokeFrom")) : invokeL.booleanValue;
    }

    public static void J(c.a.r0.a.d2.e eVar, int i2, int i3, String str) {
        int l;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65544, null, new Object[]{eVar, Integer.valueOf(i2), Integer.valueOf(i3), str}) == null) && eVar != null && (l = eVar.l()) == 0) {
            c.a.r0.a.u2.a aVar = new c.a.r0.a.u2.a();
            aVar.k(5L);
            aVar.i(i2);
            c.a.r0.a.n2.s.d dVar = new c.a.r0.a.n2.s.d();
            dVar.p(aVar);
            dVar.r(eVar.X());
            dVar.q(n.n(l));
            dVar.m(c.a.r0.a.d2.e.f0());
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("errorCode", i3);
                jSONObject.put("errorMessage", str);
            } catch (JSONException e2) {
                if (f9053f) {
                    e2.printStackTrace();
                }
            }
            dVar.e(jSONObject);
            n.R(dVar);
        }
    }

    public c.a.r0.a.u.h.b C(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            q("#getLoginCode", false);
            if (f9053f) {
                String str2 = "#getLoginCode params=" + str;
            }
            n.T("getLoginCode", "create");
            CallbackHandler h2 = a().h();
            c.a.r0.a.d2.e a0 = c.a.r0.a.d2.e.a0();
            if (a0 == null) {
                c.a.r0.a.c1.b.j().f(h2, UnitedSchemeUtility.wrapCallbackParams(1001, "swan app is null").toString());
                return new c.a.r0.a.u.h.b(1001, "swan app is null");
            } else if (!a0.M().e(getContext())) {
                n.T("getLoginCode", com.baidu.pass.biometrics.face.liveness.b.a.g0);
                return new c.a.r0.a.u.h.b(10004, "user not logged in");
            } else {
                JSONObject r = c.a.r0.a.u.c.d.r(str);
                if (r == null) {
                    c.a.r0.a.c1.b.j().f(h2, UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams").toString());
                    J(a0, 1, 201, "empty joParams");
                    n.T("getLoginCode", com.baidu.pass.biometrics.face.liveness.b.a.g0);
                    return new c.a.r0.a.u.h.b(201, "empty joParams");
                }
                String optString = r.optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    c.a.r0.a.c1.b.j().f(h2, UnitedSchemeUtility.wrapCallbackParams(201, "cb is empty").toString());
                    J(a0, 1, 201, "cb is empty");
                    n.T("getLoginCode", com.baidu.pass.biometrics.face.liveness.b.a.g0);
                    return new c.a.r0.a.u.h.b(201, "cb is empty");
                }
                Context context = getContext();
                if (!(context instanceof Activity) && (context = a0.x()) == null) {
                    n.T("getLoginCode", com.baidu.pass.biometrics.face.liveness.b.a.g0);
                    return new c.a.r0.a.u.h.b(1001, "the context is not an activity");
                }
                Activity activity = (Activity) context;
                if (!c.a.r0.a.d2.d.J().r().M().e(context)) {
                    n.T("getLoginCode", "passLogin");
                }
                D(a0, activity, r, h2, optString, false, "getLoginCode");
                return c.a.r0.a.u.h.b.f();
            }
        }
        return (c.a.r0.a.u.h.b) invokeL.objValue;
    }

    public c.a.r0.a.u.h.b H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            q("#isLoginSync", false);
            c.a.r0.a.d2.e a0 = c.a.r0.a.d2.e.a0();
            if (a0 == null) {
                c.a.r0.a.e0.d.c("LoginApi", "swan app is null");
                return new c.a.r0.a.u.h.b(202, "swan app is null");
            }
            JSONObject d2 = c.a.r0.a.u1.k.g.a.c().d("isLoginSync");
            if (d2 == null) {
                try {
                    d2 = new JSONObject();
                    d2.put("isLogin", a0.M().e(getContext()));
                    c.a.r0.a.u1.k.g.a.c().h("isLoginSync", d2);
                } catch (JSONException unused) {
                    c.a.r0.a.e0.d.c("LoginApi", "json put data fail");
                    return new c.a.r0.a.u.h.b(1001);
                }
            }
            return new c.a.r0.a.u.h.b(0, d2);
        }
        return (c.a.r0.a.u.h.b) invokeV.objValue;
    }

    public c.a.r0.a.u.h.b I(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            q("#login params=" + str, false);
            c.a.r0.a.d2.e a0 = c.a.r0.a.d2.e.a0();
            CallbackHandler h2 = a().h();
            if (a0 == null) {
                c.a.r0.a.c1.b.j().f(h2, UnitedSchemeUtility.wrapCallbackParams(1001, "swan app is null").toString());
                c.a.r0.a.e0.d.k("LoginApi", "Error: swan app is null");
                return new c.a.r0.a.u.h.b(1001, "swan app is null");
            }
            JSONObject r = c.a.r0.a.u.c.d.r(str);
            if (r == null) {
                c.a.r0.a.c1.b.j().f(h2, UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams").toString());
                J(a0, 1, 201, "empty joParams");
                p("Error: empty joParams", null, true);
                return new c.a.r0.a.u.h.b(201, "empty joParams");
            }
            String str2 = r.optString("invokeFrom").equals("component") ? "loginButton" : "loginApi";
            n.T(str2, "create");
            String optString = r.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                c.a.r0.a.c1.b.j().f(h2, UnitedSchemeUtility.wrapCallbackParams(201, "cb is empty").toString());
                J(a0, 1, 201, "cb is empty");
                p("Error: cb is empty", null, true);
                return new c.a.r0.a.u.h.b(201, "cb is empty");
            } else if (!r.optBoolean(TTDownloadField.TT_FORCE, true) && !a0.M().e(getContext())) {
                h2.handleSchemeDispatchCallback(optString, UnitedSchemeUtility.wrapCallbackParams(10004, "user not logged in").toString());
                c.a.r0.a.c1.b.j().f(h2, UnitedSchemeUtility.wrapCallbackParams(10004, "user not logged in").toString());
                J(a0, 43, 10004, "user not logged in");
                q("Success: force login is false, will not force execute login.", false);
                return new c.a.r0.a.u.h.b(0);
            } else {
                Context context = getContext();
                if (!(context instanceof Activity) && (context = a0.x()) == null) {
                    p("Error: context is not an activity", null, false);
                    return new c.a.r0.a.u.h.b(1001, "the context is not an activity");
                }
                Activity activity = (Activity) context;
                if (!c.a.r0.a.d2.d.J().r().M().e(context)) {
                    n.T(str2, "passLogin");
                }
                String optString2 = r.optString("__plugin__");
                if (!TextUtils.isEmpty(optString2)) {
                    p("handleLogin by plugin: " + optString2, null, false);
                    D(a0, activity, r, h2, optString, true, str2);
                    return new c.a.r0.a.u.h.b(0);
                }
                if (!c.a.r0.a.h2.c.d.i(r)) {
                    D(a0, activity, r, h2, optString, true, str2);
                } else {
                    c.a.r0.a.d2.d.J().r().d0().g(getContext(), "scope_login_api", new a(this, a0, activity, r, h2, optString, str2));
                }
                return c.a.r0.a.u.h.b.f();
            }
        }
        return (c.a.r0.a.u.h.b) invokeL.objValue;
    }

    @Override // c.a.r0.a.u.c.d
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? "LoginApi" : (String) invokeV.objValue;
    }
}
