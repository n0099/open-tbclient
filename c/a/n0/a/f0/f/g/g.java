package c.a.n0.a.f0.f.g;

import android.content.Context;
import android.text.TextUtils;
import c.a.n0.a.v1.f.z;
import c.a.n0.a.x1.c.j.b;
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
public class g extends z {
    public static /* synthetic */ Interceptable $ic;
    public static final String j;
    public static final String k;
    public static final String l;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public boolean f4378c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f4379d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f4380e;

    /* renamed from: f  reason: collision with root package name */
    public String f4381f;

    /* renamed from: g  reason: collision with root package name */
    public String f4382g;

    /* renamed from: h  reason: collision with root package name */
    public String f4383h;
    public JSONObject i;

    /* loaded from: classes.dex */
    public class a implements c.a.n0.a.p2.g1.c<c.a.n0.a.x1.c.i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ JSONObject f4384b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Context f4385c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.t1.e f4386d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f4387e;

        public a(g gVar, CallbackHandler callbackHandler, JSONObject jSONObject, Context context, c.a.n0.a.t1.e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, callbackHandler, jSONObject, context, eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4387e = gVar;
            this.a = callbackHandler;
            this.f4384b = jSONObject;
            this.f4385c = context;
            this.f4386d = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.n0.a.p2.g1.c
        /* renamed from: a */
        public void onCallback(c.a.n0.a.x1.c.i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (!c.a.n0.a.x1.c.d.h(iVar)) {
                    c.a.n0.a.x1.c.d.q(iVar, this.a, this.f4387e.f4383h);
                    return;
                }
                this.f4387e.i = new JSONObject();
                c.a.n0.a.e2.g.h.a().edit().putInt("aiapps_web_mode_cts_use_key", this.f4384b.optInt("loadCts")).apply();
                if (this.f4384b.optInt("loadCts") == 1) {
                    this.f4387e.u(this.f4385c);
                    g gVar = this.f4387e;
                    gVar.w(this.f4386d, gVar.f4381f, this.a, "master");
                    g gVar2 = this.f4387e;
                    gVar2.w(this.f4386d, gVar2.f4382g, this.a, "slave");
                    this.f4387e.f4380e = true;
                    return;
                }
                this.f4387e.f4380e = false;
                c.a.n0.a.n1.a.a.R(false);
                c.a.n0.a.n1.a.a.Z();
                this.a.handleSchemeDispatchCallback(this.f4387e.f4383h, UnitedSchemeUtility.wrapCallbackParams(0).toString());
            }
        }
    }

    /* loaded from: classes.dex */
    public class b extends ResponseCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.n0.a.t1.e a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f4388b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f4389c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ g f4390d;

        public b(g gVar, c.a.n0.a.t1.e eVar, String str, CallbackHandler callbackHandler) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, eVar, str, callbackHandler};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4390d = gVar;
            this.a = eVar;
            this.f4388b = str;
            this.f4389c = callbackHandler;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
                c.a.n0.a.u.d.c("SwanAppAction", "request Cts Server Address onFailure: " + exc.getMessage());
                this.f4389c.handleSchemeDispatchCallback(this.f4390d.f4383h, UnitedSchemeUtility.wrapCallbackParams(501, "网络异常").toString());
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(Object obj, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj, i) == null) {
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public Object parseResponse(Response response, int i) throws Exception {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, response, i)) == null) {
                if (response.code() == 200 && response.body() != null) {
                    this.f4390d.s(this.a, response, this.f4388b, this.f4389c);
                } else {
                    c.a.n0.a.u.d.c("setCtsConfig", "request Cts Server Address fail,code is " + response.code());
                    this.f4389c.handleSchemeDispatchCallback(this.f4390d.f4383h, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
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
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f4391b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ g f4392c;

        public c(g gVar, String str, CallbackHandler callbackHandler) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, str, callbackHandler};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4392c = gVar;
            this.a = str;
            this.f4391b = callbackHandler;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
                c.a.n0.a.u.d.c("setCtsConfig", "download cts file fail");
                this.f4391b.handleSchemeDispatchCallback(this.f4392c.f4383h, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(Object obj, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj, i) == null) {
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public Object parseResponse(Response response, int i) throws Exception {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, response, i)) == null) {
                g gVar = this.f4392c;
                gVar.v(response, this.a, gVar.f4383h, this.f4391b);
                return response;
            }
            return invokeLI.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1106327605, "Lc/a/n0/a/f0/f/g/g;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1106327605, "Lc/a/n0/a/f0/f/g/g;");
                return;
            }
        }
        j = String.format("?swanjs_version=%s", c.a.n0.a.g2.b.h(0));
        k = "https://smartprogram.baidu.com/batapi/engine" + j + "&type=1";
        l = "https://smartprogram.baidu.com/batapi/engine" + j + "&type=2";
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(c.a.n0.a.v1.e eVar) {
        super(eVar, "/swanAPI/debug/setCtsConfig");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((UnitedSchemeBaseDispatcher) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f4378c = false;
        this.f4379d = false;
        this.f4380e = false;
    }

    @Override // c.a.n0.a.v1.f.z
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.n0.a.t1.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            JSONObject a2 = z.a(unitedSchemeEntity, "params");
            if (a2 == null) {
                c.a.n0.a.u.d.c("setCtsConfig", "params is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            } else if (eVar == null) {
                c.a.n0.a.u.d.c("setCtsConfig", "swanApp is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            } else {
                this.f4383h = a2.optString("cb");
                if (!a2.has("loadCts")) {
                    c.a.n0.a.u.d.c("setCtsConfig", "loadCts is null");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                    return false;
                }
                eVar.d0().g(context, "mapp_cts_debug", new a(this, callbackHandler, a2, context, eVar));
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(0);
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public final void s(c.a.n0.a.t1.e eVar, Response response, String str, CallbackHandler callbackHandler) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar, response, str, callbackHandler) == null) {
            try {
                JSONObject jSONObject = new JSONObject(response.body().string());
                if (jSONObject.has("code") && jSONObject.optInt("code") == 0) {
                    t(jSONObject.optJSONArray("data").optString(0), str, eVar, callbackHandler);
                } else {
                    callbackHandler.handleSchemeDispatchCallback(this.f4383h, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
                callbackHandler.handleSchemeDispatchCallback(this.f4383h, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
            }
        }
    }

    public final void t(String str, String str2, c.a.n0.a.t1.e eVar, CallbackHandler callbackHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, str, str2, eVar, callbackHandler) == null) {
            c.a.n0.p.d.a aVar = new c.a.n0.p.d.a(c.a.n0.a.s0.a.o().m(str), new c(this, str2, callbackHandler));
            aVar.f9110f = true;
            aVar.f9111g = false;
            aVar.f9112h = true;
            c.a.n0.p.e.a.g().d(aVar);
        }
    }

    public final void u(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, context) == null) {
            if (c.a.n0.a.p2.h.a(context, "aiapps/debug_cts_url.json")) {
                try {
                    JSONObject jSONObject = new JSONObject(c.a.n0.a.p2.h.b(context, "aiapps/debug_cts_url.json"));
                    this.f4381f = jSONObject.optString("master");
                    this.f4382g = jSONObject.optString("slave");
                    if (TextUtils.isEmpty(this.f4381f)) {
                        this.f4381f = k;
                    }
                    if (TextUtils.isEmpty(this.f4382g)) {
                        this.f4382g = l;
                        return;
                    }
                    return;
                } catch (JSONException e2) {
                    e2.printStackTrace();
                    this.f4381f = k;
                    this.f4382g = l;
                    return;
                }
            }
            this.f4381f = k;
            this.f4382g = l;
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
                    if (c.a.n0.w.g.a(byteStream, file2)) {
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
                            this.i.put("master", jSONArray);
                            this.f4378c = true;
                            x(this.i, callbackHandler, str2);
                            return;
                        } else if (c2 != 1) {
                            callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
                            c.a.n0.a.u.d.c("setCtsConfig", "error type, get cts url failed");
                            return;
                        } else {
                            this.i.put("slave", jSONArray);
                            this.f4379d = true;
                            x(this.i, callbackHandler, str2);
                            return;
                        }
                    }
                    c.a.n0.a.u.d.c("setCtsConfig", "save cts file fail");
                    callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
                    return;
                } catch (Exception unused) {
                    c.a.n0.a.u.d.c("setCtsConfig", "save cts file fail");
                    callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
                    return;
                }
            }
            c.a.n0.a.u.d.c("setCtsConfig", "download cts file fail,code is " + response.code());
            callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
        }
    }

    public final void w(c.a.n0.a.t1.e eVar, String str, CallbackHandler callbackHandler, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048581, this, eVar, str, callbackHandler, str2) == null) {
            c.a.n0.p.d.a aVar = new c.a.n0.p.d.a(str, new b(this, eVar, str2, callbackHandler));
            aVar.f9110f = true;
            aVar.f9111g = false;
            aVar.f9112h = true;
            c.a.n0.p.e.a.g().d(aVar);
        }
    }

    public final void x(JSONObject jSONObject, CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048582, this, jSONObject, callbackHandler, str) == null) && this.f4378c && this.f4379d && this.f4380e) {
            c.a.n0.a.n1.a.a.R(true);
            c.a.n0.a.e2.g.h.a().putString("ctsUrl", jSONObject.toString());
            callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(0).toString());
            this.f4379d = false;
            this.f4378c = false;
            c.a.n0.a.n1.a.a.Z();
        }
    }
}
