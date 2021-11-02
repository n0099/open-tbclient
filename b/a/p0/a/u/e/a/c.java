package b.a.p0.a.u.e.a;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import b.a.p0.a.a2.e;
import b.a.p0.a.e2.c.i;
import b.a.p0.a.e2.c.j.f;
import b.a.p0.a.j2.k;
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
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.util.Arrays;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c extends b.a.p0.a.u.c.d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f8011d;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static class a implements b.a.p0.a.v2.e1.b<i<f.d>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f8012e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f8013f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ JSONObject f8014g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ C0379c f8015h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f8016i;
        public final /* synthetic */ String j;
        public final /* synthetic */ e k;
        public final /* synthetic */ String l;

        public a(boolean z, boolean z2, JSONObject jSONObject, C0379c c0379c, CallbackHandler callbackHandler, String str, e eVar, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Boolean.valueOf(z), Boolean.valueOf(z2), jSONObject, c0379c, callbackHandler, str, eVar, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8012e = z;
            this.f8013f = z2;
            this.f8014g = jSONObject;
            this.f8015h = c0379c;
            this.f8016i = callbackHandler;
            this.j = str;
            this.k = eVar;
            this.l = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(i<f.d> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                b.a.p0.a.e0.d.h("Api-Login", "Info: login request error code is  " + iVar.b() + " error info is " + iVar.a());
                if (!iVar.c()) {
                    if (!this.f8012e && this.f8013f) {
                        k.M(com.baidu.pass.biometrics.face.liveness.b.a.g0, 1, this.f8014g.optString("invokeFrom"));
                        b.a.p0.a.e0.d.h("Api-Login", "Error: login failed from api-invoking.");
                    }
                    int b2 = iVar.b();
                    b.a.p0.a.e0.d.l("Api-Login", b2 + " " + this.f8015h.toString());
                    String f2 = b.a.p0.a.e2.c.d.f(b2);
                    this.f8016i.handleSchemeDispatchCallback(this.j, UnitedSchemeUtility.wrapCallbackParams(b2, f2).toString());
                    b.a.p0.a.c1.b.j().f(this.f8016i, UnitedSchemeUtility.wrapCallbackParams(b2, f2).toString());
                    c.A(this.k, 43, b2, f2);
                    String str = "Error: login failed error code = " + b2 + " error msg = " + f2;
                    b.a.p0.a.e0.d.h("Api-Login", str);
                    k.O(this.l, com.baidu.pass.biometrics.face.liveness.b.a.g0, str);
                    return;
                }
                if (!this.f8012e && this.f8013f) {
                    k.M("success", 1, this.f8014g.optString("invokeFrom"));
                    b.a.p0.a.e0.d.h("Api-Login", "Success: login success from api-invoking.");
                }
                if (c.x(this.f8014g)) {
                    this.f8016i.handleSchemeDispatchCallback(this.j, UnitedSchemeUtility.wrapCallbackParams(0).toString());
                    b.a.p0.a.e0.d.h("Api-Login", "Success: login success from component-invoking.");
                    k.O(this.l, "success", "Success: login success from component-invoking.");
                    return;
                }
                k.N(this.l, "getLoginCodeStart");
                if (TextUtils.isEmpty(iVar.f4946a.f4964a)) {
                    this.f8016i.handleSchemeDispatchCallback(this.j, UnitedSchemeUtility.wrapCallbackParams(1001, "empty code").toString());
                    b.a.p0.a.c1.b.j().f(this.f8016i, UnitedSchemeUtility.wrapCallbackParams(1001, "empty code").toString());
                    c.A(this.k, 43, 1001, "empty code");
                    k.O(this.l, com.baidu.pass.biometrics.face.liveness.b.a.g0, "empty code");
                    return;
                }
                String optString = this.f8014g.optString("__plugin__");
                if (!TextUtils.isEmpty(optString)) {
                    c.v(optString, this.k, this.f8016i, this.j, iVar, this.l);
                } else {
                    c.w(this.k, this.f8016i, this.j, iVar, this.l);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b implements b.a.p0.a.v2.e1.b<b.a.p0.a.e2.d.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f8017e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f8018f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f8019g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f8020h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ e f8021i;
        public final /* synthetic */ i j;

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
            this.f8017e = callbackHandler;
            this.f8018f = str;
            this.f8019g = str2;
            this.f8020h = str3;
            this.f8021i = eVar;
            this.j = iVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(b.a.p0.a.e2.d.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                if (aVar != null && aVar.E()) {
                    c.w(this.f8021i, this.f8017e, this.f8018f, this.j, this.f8020h);
                    return;
                }
                this.f8017e.handleSchemeDispatchCallback(this.f8018f, UnitedSchemeUtility.wrapCallbackParams(403, "permission denied").toString());
                String str = "Error: scope snsapi_userinfopermission denied plugin appkey : " + this.f8019g + " from plugin-invoking.";
                b.a.p0.a.e0.d.h("Api-Login", str);
                k.O(this.f8020h, com.baidu.pass.biometrics.face.liveness.b.a.g0, str);
            }
        }
    }

    /* renamed from: b.a.p0.a.u.e.a.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0379c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final boolean f8022a;

        /* renamed from: b  reason: collision with root package name */
        public final long f8023b;

        public C0379c(@NonNull JSONObject jSONObject) {
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
            this.f8022a = jSONObject.has("timeout");
            long optLong = jSONObject.optLong("timeout", 0L);
            this.f8023b = optLong;
            if (optLong < 0) {
                b.a.p0.a.e0.d.l("Api-Login", "timeout is a minus：" + toString());
            }
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return "LoginTimeoutConfig{enableTimeout=" + this.f8022a + ", timeoutMills=" + this.f8023b + ExtendedMessageFormat.END_FE;
            }
            return (String) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-230225696, "Lb/a/p0/a/u/e/a/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-230225696, "Lb/a/p0/a/u/e/a/c;");
                return;
            }
        }
        f8011d = b.a.p0.a.k.f6397a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(@NonNull b.a.p0.a.u.c.b bVar) {
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
                super((b.a.p0.a.u.c.b) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public static void A(e eVar, int i2, int i3, String str) {
        int l;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{eVar, Integer.valueOf(i2), Integer.valueOf(i3), str}) == null) && eVar != null && (l = eVar.l()) == 0) {
            b.a.p0.a.q2.a aVar = new b.a.p0.a.q2.a();
            aVar.j(5L);
            aVar.h(i2);
            b.a.p0.a.j2.p.d dVar = new b.a.p0.a.j2.p.d();
            dVar.p(aVar);
            dVar.r(eVar.M());
            dVar.q(k.m(l));
            dVar.m(e.U());
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("errorCode", i3);
                jSONObject.put("errorMessage", str);
            } catch (JSONException e2) {
                if (f8011d) {
                    e2.printStackTrace();
                }
            }
            dVar.e(jSONObject);
            k.L(dVar);
        }
    }

    public static void u(e eVar, Activity activity, JSONObject jSONObject, CallbackHandler callbackHandler, String str, boolean z, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(AdIconUtil.BAIDU_LOGO_ID, null, new Object[]{eVar, activity, jSONObject, callbackHandler, str, Boolean.valueOf(z), str2}) == null) {
            boolean e2 = eVar.j().e(activity);
            C0379c c0379c = new C0379c(jSONObject);
            eVar.S().r(activity, c0379c, null, new a(e2, z, jSONObject, c0379c, callbackHandler, str, eVar, str2), str2);
        }
    }

    public static void v(String str, e eVar, CallbackHandler callbackHandler, String str2, i<f.d> iVar, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65543, null, new Object[]{str, eVar, callbackHandler, str2, iVar, str3}) == null) {
            SwanAppActivity x = eVar.x();
            if (x == null) {
                callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(1001, "the activity is null").toString());
                b.a.p0.a.e0.d.h("Api-Login", "Error: activity is null from plugin-invoking.");
                k.O(str3, com.baidu.pass.biometrics.face.liveness.b.a.g0, "the activity is null");
                return;
            }
            String f2 = b.a.p0.a.t1.g.b.f(str);
            b.a.p0.a.e2.d.a.C(x, "snsapi_userinfo", f2, false, str3, new b(callbackHandler, str2, f2, str3, eVar, iVar));
        }
    }

    public static void w(e eVar, CallbackHandler callbackHandler, String str, i<f.d> iVar, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65544, null, eVar, callbackHandler, str, iVar, str2) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("code", iVar.f4946a.f4964a);
                b.a.p0.a.e0.d.h("Api-Login", "Success: call back msg = " + jSONObject.toString());
                b.a.p0.a.x1.c.f8949c.e();
                callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(jSONObject, iVar.b()).toString());
                k.N(str2, "success");
            } catch (JSONException e2) {
                if (f8011d) {
                    e2.printStackTrace();
                }
                callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(1001, e2.getMessage()).toString());
                b.a.p0.a.c1.b.j().f(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(1001, e2.getMessage()).toString());
                A(eVar, 43, 1001, e2.getMessage());
                String str3 = "Error: exception = " + e2.getMessage() + " stack trace = " + Arrays.toString(e2.getStackTrace());
                b.a.p0.a.e0.d.h("Api-Login", str3);
                k.O(str2, com.baidu.pass.biometrics.face.liveness.b.a.g0, str3);
            }
        }
    }

    public static boolean x(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65545, null, jSONObject)) == null) ? "component".equals(jSONObject.optString("invokeFrom")) : invokeL.booleanValue;
    }

    public b.a.p0.a.u.h.b t(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (f8011d) {
                String str2 = "start getLoginCode action, params = " + str;
            }
            k.N("getLoginCode", "create");
            CallbackHandler g2 = a().g();
            e P = e.P();
            if (P == null) {
                b.a.p0.a.c1.b.j().f(g2, UnitedSchemeUtility.wrapCallbackParams(1001, "empty swanApp").toString());
                return new b.a.p0.a.u.h.b(1001, "empty swanApp");
            } else if (!P.j().e(getContext())) {
                k.N("getLoginCode", com.baidu.pass.biometrics.face.liveness.b.a.g0);
                return new b.a.p0.a.u.h.b(10004, "user not logged in");
            } else {
                JSONObject l = b.a.p0.a.u.c.d.l(str);
                if (l == null) {
                    b.a.p0.a.c1.b.j().f(g2, UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams").toString());
                    A(P, 1, 201, "empty joParams");
                    k.N("getLoginCode", com.baidu.pass.biometrics.face.liveness.b.a.g0);
                    return new b.a.p0.a.u.h.b(201, "empty joParams");
                }
                String optString = l.optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    b.a.p0.a.c1.b.j().f(g2, UnitedSchemeUtility.wrapCallbackParams(201, "empty cb").toString());
                    A(P, 1, 201, "empty cb");
                    k.N("getLoginCode", com.baidu.pass.biometrics.face.liveness.b.a.g0);
                    return new b.a.p0.a.u.h.b(201, "empty cb");
                }
                Context context = getContext();
                if (!(context instanceof Activity) && (context = P.x()) == null) {
                    k.N("getLoginCode", com.baidu.pass.biometrics.face.liveness.b.a.g0);
                    return new b.a.p0.a.u.h.b(1001, "the context is not an activity");
                }
                Activity activity = (Activity) context;
                if (!b.a.p0.a.a2.d.g().r().j().e(context)) {
                    k.N("getLoginCode", "passLogin");
                }
                u(P, activity, l, g2, optString, false, "getLoginCode");
                return new b.a.p0.a.u.h.b(0);
            }
        }
        return (b.a.p0.a.u.h.b) invokeL.objValue;
    }

    public b.a.p0.a.u.h.b y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            boolean z = f8011d;
            e P = e.P();
            if (P == null) {
                b.a.p0.a.e0.d.b("Api-Login", "swan app is null");
                return new b.a.p0.a.u.h.b(202, "swan app is null");
            }
            JSONObject d2 = b.a.p0.a.r1.k.g.a.c().d("isLoginSync");
            if (d2 == null) {
                try {
                    d2 = new JSONObject();
                    d2.put("isLogin", P.j().e(getContext()));
                    b.a.p0.a.r1.k.g.a.c().h("isLoginSync", d2);
                } catch (JSONException unused) {
                    b.a.p0.a.e0.d.b("Api-Login", "json parse fail");
                    return new b.a.p0.a.u.h.b(1001);
                }
            }
            return new b.a.p0.a.u.h.b(0, d2);
        }
        return (b.a.p0.a.u.h.b) invokeV.objValue;
    }

    public b.a.p0.a.u.h.b z(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            b.a.p0.a.e0.d.h("Api-Login", "start login" + str);
            e P = e.P();
            CallbackHandler g2 = a().g();
            if (P == null) {
                b.a.p0.a.c1.b.j().f(g2, UnitedSchemeUtility.wrapCallbackParams(1001, "empty swanApp").toString());
                b.a.p0.a.e0.d.h("Api-Login", "Error: empty swanApp");
                return new b.a.p0.a.u.h.b(1001, "empty swanApp");
            }
            JSONObject l = b.a.p0.a.u.c.d.l(str);
            if (l == null) {
                b.a.p0.a.c1.b.j().f(g2, UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams").toString());
                A(P, 1, 201, "empty joParams");
                b.a.p0.a.e0.d.h("Api-Login", "Error: empty joParams");
                return new b.a.p0.a.u.h.b(201, "empty joParams");
            }
            String optString = l.optString("invokeFrom");
            String str2 = optString.equals("component") ? "loginButton" : "loginApi";
            k.N(str2, "create");
            String optString2 = l.optString("cb");
            if (TextUtils.isEmpty(optString2)) {
                b.a.p0.a.c1.b.j().f(g2, UnitedSchemeUtility.wrapCallbackParams(201, "empty cb").toString());
                A(P, 1, 201, "empty cb");
                b.a.p0.a.e0.d.h("Api-Login", "Error: empty cb");
                return new b.a.p0.a.u.h.b(201, "empty cb");
            } else if (!l.optBoolean(TTDownloadField.TT_FORCE, true) && !P.j().e(getContext())) {
                g2.handleSchemeDispatchCallback(optString2, UnitedSchemeUtility.wrapCallbackParams(10004, "user not logged in").toString());
                b.a.p0.a.c1.b.j().f(g2, UnitedSchemeUtility.wrapCallbackParams(10004, "user not logged in").toString());
                A(P, 43, 10004, "user not logged in");
                b.a.p0.a.e0.d.h("Api-Login", "Success: force login is false, will not force execute login.");
                return new b.a.p0.a.u.h.b(0);
            } else {
                Context context = getContext();
                if (!(context instanceof Activity) && (context = P.x()) == null) {
                    b.a.p0.a.e0.d.h("Api-Login", "Error: context is not an activity");
                    return new b.a.p0.a.u.h.b(1001, "the context is not an activity");
                }
                Activity activity = (Activity) context;
                if (!P.j().e(context)) {
                    k.M("show", 1, optString);
                }
                if (!b.a.p0.a.a2.d.g().r().j().e(context)) {
                    k.N(str2, "passLogin");
                }
                u(P, activity, l, g2, optString2, true, str2);
                return new b.a.p0.a.u.h.b(0);
            }
        }
        return (b.a.p0.a.u.h.b) invokeL.objValue;
    }
}
