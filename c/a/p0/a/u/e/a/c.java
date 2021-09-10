package c.a.p0.a.u.e.a;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import c.a.p0.a.a2.e;
import c.a.p0.a.e2.c.i;
import c.a.p0.a.e2.c.j.f;
import c.a.p0.a.j2.k;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
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
import java.util.Arrays;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c extends c.a.p0.a.u.c.d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f8738d;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static class a implements c.a.p0.a.v2.e1.b<i<f.d>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f8739e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f8740f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ JSONObject f8741g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ C0384c f8742h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f8743i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ String f8744j;
        public final /* synthetic */ e k;
        public final /* synthetic */ String l;

        public a(boolean z, boolean z2, JSONObject jSONObject, C0384c c0384c, CallbackHandler callbackHandler, String str, e eVar, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Boolean.valueOf(z), Boolean.valueOf(z2), jSONObject, c0384c, callbackHandler, str, eVar, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8739e = z;
            this.f8740f = z2;
            this.f8741g = jSONObject;
            this.f8742h = c0384c;
            this.f8743i = callbackHandler;
            this.f8744j = str;
            this.k = eVar;
            this.l = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(i<f.d> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                c.a.p0.a.e0.d.h("Api-Login", "Info: login request error code is  " + iVar.b() + " error info is " + iVar.a());
                if (!iVar.c()) {
                    if (!this.f8739e && this.f8740f) {
                        k.M(com.baidu.pass.biometrics.face.liveness.b.a.g0, 1, this.f8741g.optString("invokeFrom"));
                        c.a.p0.a.e0.d.h("Api-Login", "Error: login failed from api-invoking.");
                    }
                    int b2 = iVar.b();
                    c.a.p0.a.e0.d.l("Api-Login", b2 + " " + this.f8742h.toString());
                    String f2 = c.a.p0.a.e2.c.d.f(b2);
                    this.f8743i.handleSchemeDispatchCallback(this.f8744j, UnitedSchemeUtility.wrapCallbackParams(b2, f2).toString());
                    c.a.p0.a.c1.b.j().f(this.f8743i, UnitedSchemeUtility.wrapCallbackParams(b2, f2).toString());
                    c.B(this.k, 43, b2, f2);
                    String str = "Error: login failed error code = " + b2 + " error msg = " + f2;
                    c.a.p0.a.e0.d.h("Api-Login", str);
                    k.O(this.l, com.baidu.pass.biometrics.face.liveness.b.a.g0, str);
                    return;
                }
                if (!this.f8739e && this.f8740f) {
                    k.M("success", 1, this.f8741g.optString("invokeFrom"));
                    c.a.p0.a.e0.d.h("Api-Login", "Success: login success from api-invoking.");
                }
                if (c.y(this.f8741g)) {
                    this.f8743i.handleSchemeDispatchCallback(this.f8744j, UnitedSchemeUtility.wrapCallbackParams(0).toString());
                    c.a.p0.a.e0.d.h("Api-Login", "Success: login success from component-invoking.");
                    k.O(this.l, "success", "Success: login success from component-invoking.");
                    return;
                }
                k.N(this.l, "getLoginCodeStart");
                if (TextUtils.isEmpty(iVar.f5582a.f5600a)) {
                    this.f8743i.handleSchemeDispatchCallback(this.f8744j, UnitedSchemeUtility.wrapCallbackParams(1001, "empty code").toString());
                    c.a.p0.a.c1.b.j().f(this.f8743i, UnitedSchemeUtility.wrapCallbackParams(1001, "empty code").toString());
                    c.B(this.k, 43, 1001, "empty code");
                    k.O(this.l, com.baidu.pass.biometrics.face.liveness.b.a.g0, "empty code");
                    return;
                }
                String optString = this.f8741g.optString("__plugin__");
                if (!TextUtils.isEmpty(optString)) {
                    c.w(optString, this.k, this.f8743i, this.f8744j, iVar, this.l);
                } else {
                    c.x(this.k, this.f8743i, this.f8744j, iVar, this.l);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b implements c.a.p0.a.v2.e1.b<c.a.p0.a.e2.d.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f8745e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f8746f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f8747g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f8748h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ e f8749i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ i f8750j;

        public b(CallbackHandler callbackHandler, String str, String str2, String str3, e eVar, i iVar) {
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
            this.f8745e = callbackHandler;
            this.f8746f = str;
            this.f8747g = str2;
            this.f8748h = str3;
            this.f8749i = eVar;
            this.f8750j = iVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(c.a.p0.a.e2.d.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                if (aVar != null && aVar.E()) {
                    c.x(this.f8749i, this.f8745e, this.f8746f, this.f8750j, this.f8748h);
                    return;
                }
                this.f8745e.handleSchemeDispatchCallback(this.f8746f, UnitedSchemeUtility.wrapCallbackParams(403, "permission denied").toString());
                String str = "Error: scope snsapi_userinfopermission denied plugin appkey : " + this.f8747g + " from plugin-invoking.";
                c.a.p0.a.e0.d.h("Api-Login", str);
                k.O(this.f8748h, com.baidu.pass.biometrics.face.liveness.b.a.g0, str);
            }
        }
    }

    /* renamed from: c.a.p0.a.u.e.a.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0384c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final boolean f8751a;

        /* renamed from: b  reason: collision with root package name */
        public final long f8752b;

        public C0384c(@NonNull JSONObject jSONObject) {
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
            this.f8751a = jSONObject.has("timeout");
            long optLong = jSONObject.optLong("timeout", 0L);
            this.f8752b = optLong;
            if (optLong < 0) {
                c.a.p0.a.e0.d.l("Api-Login", "timeout is a minus：" + toString());
            }
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return "LoginTimeoutConfig{enableTimeout=" + this.f8751a + ", timeoutMills=" + this.f8752b + ExtendedMessageFormat.END_FE;
            }
            return (String) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1123084001, "Lc/a/p0/a/u/e/a/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1123084001, "Lc/a/p0/a/u/e/a/c;");
                return;
            }
        }
        f8738d = c.a.p0.a.k.f7077a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(@NonNull c.a.p0.a.u.c.b bVar) {
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
                super((c.a.p0.a.u.c.b) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public static void B(e eVar, int i2, int i3, String str) {
        int l;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{eVar, Integer.valueOf(i2), Integer.valueOf(i3), str}) == null) && eVar != null && (l = eVar.l()) == 0) {
            c.a.p0.a.q2.a aVar = new c.a.p0.a.q2.a();
            aVar.j(5L);
            aVar.h(i2);
            c.a.p0.a.j2.p.d dVar = new c.a.p0.a.j2.p.d();
            dVar.p(aVar);
            dVar.r(eVar.N());
            dVar.q(k.m(l));
            dVar.m(e.V());
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("errorCode", i3);
                jSONObject.put("errorMessage", str);
            } catch (JSONException e2) {
                if (f8738d) {
                    e2.printStackTrace();
                }
            }
            dVar.e(jSONObject);
            k.L(dVar);
        }
    }

    public static void v(e eVar, Activity activity, JSONObject jSONObject, CallbackHandler callbackHandler, String str, boolean z, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(AdIconUtil.BAIDU_LOGO_ID, null, new Object[]{eVar, activity, jSONObject, callbackHandler, str, Boolean.valueOf(z), str2}) == null) {
            boolean e2 = eVar.j().e(activity);
            C0384c c0384c = new C0384c(jSONObject);
            eVar.T().r(activity, c0384c, null, new a(e2, z, jSONObject, c0384c, callbackHandler, str, eVar, str2), str2);
        }
    }

    public static void w(String str, e eVar, CallbackHandler callbackHandler, String str2, i<f.d> iVar, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65543, null, new Object[]{str, eVar, callbackHandler, str2, iVar, str3}) == null) {
            SwanAppActivity x = eVar.x();
            if (x == null) {
                callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(1001, "the activity is null").toString());
                c.a.p0.a.e0.d.h("Api-Login", "Error: activity is null from plugin-invoking.");
                k.O(str3, com.baidu.pass.biometrics.face.liveness.b.a.g0, "the activity is null");
                return;
            }
            String f2 = c.a.p0.a.t1.g.b.f(str);
            c.a.p0.a.e2.d.a.C(x, "snsapi_userinfo", f2, false, str3, new b(callbackHandler, str2, f2, str3, eVar, iVar));
        }
    }

    public static void x(e eVar, CallbackHandler callbackHandler, String str, i<f.d> iVar, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65544, null, eVar, callbackHandler, str, iVar, str2) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("code", iVar.f5582a.f5600a);
                c.a.p0.a.e0.d.h("Api-Login", "Success: call back msg = " + jSONObject.toString());
                c.a.p0.a.x1.c.f9705c.e();
                callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(jSONObject, iVar.b()).toString());
                k.N(str2, "success");
            } catch (JSONException e2) {
                if (f8738d) {
                    e2.printStackTrace();
                }
                callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(1001, e2.getMessage()).toString());
                c.a.p0.a.c1.b.j().f(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(1001, e2.getMessage()).toString());
                B(eVar, 43, 1001, e2.getMessage());
                String str3 = "Error: exception = " + e2.getMessage() + " stack trace = " + Arrays.toString(e2.getStackTrace());
                c.a.p0.a.e0.d.h("Api-Login", str3);
                k.O(str2, com.baidu.pass.biometrics.face.liveness.b.a.g0, str3);
            }
        }
    }

    public static boolean y(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65545, null, jSONObject)) == null) ? "component".equals(jSONObject.optString("invokeFrom")) : invokeL.booleanValue;
    }

    public c.a.p0.a.u.h.b A(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            c.a.p0.a.e0.d.h("Api-Login", "start login" + str);
            e Q = e.Q();
            CallbackHandler h2 = a().h();
            if (Q == null) {
                c.a.p0.a.c1.b.j().f(h2, UnitedSchemeUtility.wrapCallbackParams(1001, "empty swanApp").toString());
                c.a.p0.a.e0.d.h("Api-Login", "Error: empty swanApp");
                return new c.a.p0.a.u.h.b(1001, "empty swanApp");
            }
            JSONObject m = c.a.p0.a.u.c.d.m(str);
            if (m == null) {
                c.a.p0.a.c1.b.j().f(h2, UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams").toString());
                B(Q, 1, 201, "empty joParams");
                c.a.p0.a.e0.d.h("Api-Login", "Error: empty joParams");
                return new c.a.p0.a.u.h.b(201, "empty joParams");
            }
            String optString = m.optString("invokeFrom");
            String str2 = optString.equals("component") ? "loginButton" : "loginApi";
            k.N(str2, "create");
            String optString2 = m.optString("cb");
            if (TextUtils.isEmpty(optString2)) {
                c.a.p0.a.c1.b.j().f(h2, UnitedSchemeUtility.wrapCallbackParams(201, "empty cb").toString());
                B(Q, 1, 201, "empty cb");
                c.a.p0.a.e0.d.h("Api-Login", "Error: empty cb");
                return new c.a.p0.a.u.h.b(201, "empty cb");
            } else if (!m.optBoolean("force", true) && !Q.j().e(i())) {
                h2.handleSchemeDispatchCallback(optString2, UnitedSchemeUtility.wrapCallbackParams(10004, "user not logged in").toString());
                c.a.p0.a.c1.b.j().f(h2, UnitedSchemeUtility.wrapCallbackParams(10004, "user not logged in").toString());
                B(Q, 43, 10004, "user not logged in");
                c.a.p0.a.e0.d.h("Api-Login", "Success: force login is false, will not force execute login.");
                return new c.a.p0.a.u.h.b(0);
            } else {
                Context i2 = i();
                if (!(i2 instanceof Activity) && (i2 = Q.x()) == null) {
                    c.a.p0.a.e0.d.h("Api-Login", "Error: context is not an activity");
                    return new c.a.p0.a.u.h.b(1001, "the context is not an activity");
                }
                Activity activity = (Activity) i2;
                if (!Q.j().e(i2)) {
                    k.M("show", 1, optString);
                }
                if (!c.a.p0.a.a2.d.g().r().j().e(i2)) {
                    k.N(str2, "passLogin");
                }
                v(Q, activity, m, h2, optString2, true, str2);
                return new c.a.p0.a.u.h.b(0);
            }
        }
        return (c.a.p0.a.u.h.b) invokeL.objValue;
    }

    public c.a.p0.a.u.h.b u(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (f8738d) {
                String str2 = "start getLoginCode action, params = " + str;
            }
            k.N("getLoginCode", "create");
            CallbackHandler h2 = a().h();
            e Q = e.Q();
            if (Q == null) {
                c.a.p0.a.c1.b.j().f(h2, UnitedSchemeUtility.wrapCallbackParams(1001, "empty swanApp").toString());
                return new c.a.p0.a.u.h.b(1001, "empty swanApp");
            } else if (!Q.j().e(i())) {
                k.N("getLoginCode", com.baidu.pass.biometrics.face.liveness.b.a.g0);
                return new c.a.p0.a.u.h.b(10004, "user not logged in");
            } else {
                JSONObject m = c.a.p0.a.u.c.d.m(str);
                if (m == null) {
                    c.a.p0.a.c1.b.j().f(h2, UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams").toString());
                    B(Q, 1, 201, "empty joParams");
                    k.N("getLoginCode", com.baidu.pass.biometrics.face.liveness.b.a.g0);
                    return new c.a.p0.a.u.h.b(201, "empty joParams");
                }
                String optString = m.optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    c.a.p0.a.c1.b.j().f(h2, UnitedSchemeUtility.wrapCallbackParams(201, "empty cb").toString());
                    B(Q, 1, 201, "empty cb");
                    k.N("getLoginCode", com.baidu.pass.biometrics.face.liveness.b.a.g0);
                    return new c.a.p0.a.u.h.b(201, "empty cb");
                }
                Context i2 = i();
                if (!(i2 instanceof Activity) && (i2 = Q.x()) == null) {
                    k.N("getLoginCode", com.baidu.pass.biometrics.face.liveness.b.a.g0);
                    return new c.a.p0.a.u.h.b(1001, "the context is not an activity");
                }
                Activity activity = (Activity) i2;
                if (!c.a.p0.a.a2.d.g().r().j().e(i2)) {
                    k.N("getLoginCode", "passLogin");
                }
                v(Q, activity, m, h2, optString, false, "getLoginCode");
                return new c.a.p0.a.u.h.b(0);
            }
        }
        return (c.a.p0.a.u.h.b) invokeL.objValue;
    }

    public c.a.p0.a.u.h.b z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            boolean z = f8738d;
            e Q = e.Q();
            if (Q == null) {
                c.a.p0.a.e0.d.b("Api-Login", "swan app is null");
                return new c.a.p0.a.u.h.b(202, "swan app is null");
            }
            JSONObject d2 = c.a.p0.a.r1.k.g.a.c().d("isLoginSync");
            if (d2 == null) {
                try {
                    d2 = new JSONObject();
                    d2.put("isLogin", Q.j().e(i()));
                    c.a.p0.a.r1.k.g.a.c().h("isLoginSync", d2);
                } catch (JSONException unused) {
                    c.a.p0.a.e0.d.b("Api-Login", "json parse fail");
                    return new c.a.p0.a.u.h.b(1001);
                }
            }
            return new c.a.p0.a.u.h.b(0, d2);
        }
        return (c.a.p0.a.u.h.b) invokeV.objValue;
    }
}
