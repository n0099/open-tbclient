package b.a.p0.a.p0.f.d;

import android.content.Context;
import android.text.TextUtils;
import b.a.p0.a.c2.f.a0;
import b.a.p0.a.e2.c.j.b;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class f extends a0 {
    public static /* synthetic */ Interceptable $ic;
    public static final String j;
    public static final String k;
    public static final String l;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public boolean f7249c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f7250d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f7251e;

    /* renamed from: f  reason: collision with root package name */
    public String f7252f;

    /* renamed from: g  reason: collision with root package name */
    public String f7253g;

    /* renamed from: h  reason: collision with root package name */
    public String f7254h;

    /* renamed from: i  reason: collision with root package name */
    public JSONObject f7255i;

    /* loaded from: classes.dex */
    public class a implements b.a.p0.a.v2.e1.b<b.a.p0.a.e2.c.i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f7256e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ JSONObject f7257f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f7258g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.a2.e f7259h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ f f7260i;

        public a(f fVar, CallbackHandler callbackHandler, JSONObject jSONObject, Context context, b.a.p0.a.a2.e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, callbackHandler, jSONObject, context, eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7260i = fVar;
            this.f7256e = callbackHandler;
            this.f7257f = jSONObject;
            this.f7258g = context;
            this.f7259h = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(b.a.p0.a.e2.c.i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (!b.a.p0.a.e2.c.d.h(iVar)) {
                    b.a.p0.a.e2.c.d.p(iVar, this.f7256e, this.f7260i.f7254h);
                    return;
                }
                this.f7260i.f7255i = new JSONObject();
                if (this.f7257f.optInt("loadCts") == 1) {
                    this.f7260i.u(this.f7258g);
                    f fVar = this.f7260i;
                    fVar.w(this.f7259h, fVar.f7252f, this.f7256e, "master");
                    f fVar2 = this.f7260i;
                    fVar2.w(this.f7259h, fVar2.f7253g, this.f7256e, "slave");
                    this.f7260i.f7251e = true;
                    return;
                }
                this.f7260i.f7251e = false;
                b.a.p0.a.u1.a.a.Q(false);
                b.a.p0.a.u1.a.a.X();
                this.f7256e.handleSchemeDispatchCallback(this.f7260i.f7254h, UnitedSchemeUtility.wrapCallbackParams(0).toString());
            }
        }
    }

    /* loaded from: classes.dex */
    public class b extends ResponseCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.a2.e f7261a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f7262b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f7263c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ f f7264d;

        public b(f fVar, b.a.p0.a.a2.e eVar, String str, CallbackHandler callbackHandler) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, eVar, str, callbackHandler};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7264d = fVar;
            this.f7261a = eVar;
            this.f7262b = str;
            this.f7263c = callbackHandler;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
                b.a.p0.a.e0.d.b("SwanAppAction", "request Cts Server Address onFailure: " + exc.getMessage());
                this.f7263c.handleSchemeDispatchCallback(this.f7264d.f7254h, UnitedSchemeUtility.wrapCallbackParams(501, "网络异常").toString());
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(Object obj, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj, i2) == null) {
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public Object parseResponse(Response response, int i2) throws Exception {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, response, i2)) == null) {
                if (response.code() == 200 && response.body() != null) {
                    this.f7264d.s(this.f7261a, response, this.f7262b, this.f7263c);
                } else {
                    b.a.p0.a.e0.d.b("setCtsConfig", "request Cts Server Address fail,code is " + response.code());
                    this.f7263c.handleSchemeDispatchCallback(this.f7264d.f7254h, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
                }
                return response;
            }
            return invokeLI.objValue;
        }
    }

    /* loaded from: classes.dex */
    public class c extends ResponseCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f7265a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f7266b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ f f7267c;

        public c(f fVar, String str, CallbackHandler callbackHandler) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, str, callbackHandler};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7267c = fVar;
            this.f7265a = str;
            this.f7266b = callbackHandler;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
                b.a.p0.a.e0.d.b("setCtsConfig", "download cts file fail");
                this.f7266b.handleSchemeDispatchCallback(this.f7267c.f7254h, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(Object obj, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj, i2) == null) {
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public Object parseResponse(Response response, int i2) throws Exception {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, response, i2)) == null) {
                f fVar = this.f7267c;
                fVar.v(response, this.f7265a, fVar.f7254h, this.f7266b);
                return response;
            }
            return invokeLI.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(197517858, "Lb/a/p0/a/p0/f/d/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(197517858, "Lb/a/p0/a/p0/f/d/f;");
                return;
            }
        }
        j = String.format("?swanjs_version=%s", b.a.p0.a.m2.b.h(0));
        k = "https://smartprogram.baidu.com/batapi/engine" + j + "&type=1";
        l = "https://smartprogram.baidu.com/batapi/engine" + j + "&type=2";
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(b.a.p0.a.c2.e eVar) {
        super(eVar, "/swanAPI/debug/setCtsConfig");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((UnitedSchemeBaseDispatcher) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f7249c = false;
        this.f7250d = false;
        this.f7251e = false;
    }

    @Override // b.a.p0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, b.a.p0.a.a2.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            JSONObject a2 = a0.a(unitedSchemeEntity, "params");
            if (a2 == null) {
                b.a.p0.a.e0.d.b("setCtsConfig", "params is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            } else if (eVar == null) {
                b.a.p0.a.e0.d.b("setCtsConfig", "swanApp is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            } else {
                this.f7254h = a2.optString("cb");
                if (!a2.has("loadCts")) {
                    b.a.p0.a.e0.d.b("setCtsConfig", "loadCts is null");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                    return false;
                }
                eVar.S().g(context, "mapp_cts_debug", new a(this, callbackHandler, a2, context, eVar));
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(0);
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public final void s(b.a.p0.a.a2.e eVar, Response response, String str, CallbackHandler callbackHandler) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar, response, str, callbackHandler) == null) {
            try {
                JSONObject jSONObject = new JSONObject(response.body().string());
                if (jSONObject.has("code") && jSONObject.optInt("code") == 0) {
                    t(jSONObject.optJSONArray("data").optString(0), str, eVar, callbackHandler);
                } else {
                    callbackHandler.handleSchemeDispatchCallback(this.f7254h, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
                callbackHandler.handleSchemeDispatchCallback(this.f7254h, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
            }
        }
    }

    public final void t(String str, String str2, b.a.p0.a.a2.e eVar, CallbackHandler callbackHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, str, str2, eVar, callbackHandler) == null) {
            b.a.p0.m.d.a aVar = new b.a.p0.m.d.a(b.a.p0.a.c1.a.n().m(str), new c(this, str2, callbackHandler));
            aVar.f11038f = true;
            aVar.f11039g = false;
            aVar.f11040h = true;
            b.a.p0.m.e.a.g().d(aVar);
        }
    }

    public final void u(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, context) == null) {
            if (b.a.p0.a.v2.h.a(context, "aiapps/debug_cts_url.json")) {
                try {
                    JSONObject jSONObject = new JSONObject(b.a.p0.a.v2.h.b(context, "aiapps/debug_cts_url.json"));
                    this.f7252f = jSONObject.optString("master");
                    this.f7253g = jSONObject.optString("slave");
                    if (TextUtils.isEmpty(this.f7252f)) {
                        this.f7252f = k;
                    }
                    if (TextUtils.isEmpty(this.f7253g)) {
                        this.f7253g = l;
                        return;
                    }
                    return;
                } catch (JSONException e2) {
                    e2.printStackTrace();
                    this.f7252f = k;
                    this.f7253g = l;
                    return;
                }
            }
            this.f7252f = k;
            this.f7253g = l;
        }
    }

    public final void v(Response response, String str, String str2, CallbackHandler callbackHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048580, this, response, str, str2, callbackHandler) == null) {
            if (response.code() == 200 && response.body() != null) {
                try {
                    InputStream byteStream = response.body().byteStream();
                    File file = new File(AppRuntime.getAppContext().getFilesDir(), "aiapps_cts");
                    File file2 = new File(file, str + ".js");
                    if (b.a.p0.t.g.a(byteStream, file2)) {
                        JSONArray jSONArray = new JSONArray();
                        jSONArray.put(file2);
                        char c2 = 65535;
                        int hashCode = str.hashCode();
                        if (hashCode != -1081267614) {
                            if (hashCode == 109519319 && str.equals("slave")) {
                                c2 = 1;
                            }
                        } else if (str.equals("master")) {
                            c2 = 0;
                        }
                        if (c2 == 0) {
                            this.f7255i.put("master", jSONArray);
                            this.f7249c = true;
                            x(this.f7255i, callbackHandler, str2);
                            return;
                        } else if (c2 != 1) {
                            callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
                            b.a.p0.a.e0.d.b("setCtsConfig", "error type, get cts url failed");
                            return;
                        } else {
                            this.f7255i.put("slave", jSONArray);
                            this.f7250d = true;
                            x(this.f7255i, callbackHandler, str2);
                            return;
                        }
                    }
                    b.a.p0.a.e0.d.b("setCtsConfig", "save cts file fail");
                    callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
                    return;
                } catch (Exception unused) {
                    b.a.p0.a.e0.d.b("setCtsConfig", "save cts file fail");
                    callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
                    return;
                }
            }
            b.a.p0.a.e0.d.b("setCtsConfig", "download cts file fail,code is " + response.code());
            callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
        }
    }

    public final void w(b.a.p0.a.a2.e eVar, String str, CallbackHandler callbackHandler, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048581, this, eVar, str, callbackHandler, str2) == null) {
            b.a.p0.m.d.a aVar = new b.a.p0.m.d.a(str, new b(this, eVar, str2, callbackHandler));
            aVar.f11038f = true;
            aVar.f11039g = false;
            aVar.f11040h = true;
            b.a.p0.m.e.a.g().d(aVar);
        }
    }

    public final void x(JSONObject jSONObject, CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048582, this, jSONObject, callbackHandler, str) == null) && this.f7249c && this.f7250d && this.f7251e) {
            b.a.p0.a.u1.a.a.Q(true);
            b.a.p0.a.k2.g.h.a().putString("ctsUrl", jSONObject.toString());
            callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(0).toString());
            this.f7250d = false;
            this.f7249c = false;
            b.a.p0.a.u1.a.a.X();
        }
    }
}
