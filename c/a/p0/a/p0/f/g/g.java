package c.a.p0.a.p0.f.g;

import android.content.Context;
import android.text.TextUtils;
import c.a.p0.a.f2.f.z;
import c.a.p0.a.h2.c.j.b;
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

    /* renamed from: j  reason: collision with root package name */
    public static final String f7350j;

    /* renamed from: k  reason: collision with root package name */
    public static final String f7351k;
    public static final String l;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public boolean f7352c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f7353d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f7354e;

    /* renamed from: f  reason: collision with root package name */
    public String f7355f;

    /* renamed from: g  reason: collision with root package name */
    public String f7356g;

    /* renamed from: h  reason: collision with root package name */
    public String f7357h;

    /* renamed from: i  reason: collision with root package name */
    public JSONObject f7358i;

    /* loaded from: classes.dex */
    public class a implements c.a.p0.a.z2.g1.c<c.a.p0.a.h2.c.i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f7359e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ JSONObject f7360f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f7361g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.d2.e f7362h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ g f7363i;

        public a(g gVar, CallbackHandler callbackHandler, JSONObject jSONObject, Context context, c.a.p0.a.d2.e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, callbackHandler, jSONObject, context, eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7363i = gVar;
            this.f7359e = callbackHandler;
            this.f7360f = jSONObject;
            this.f7361g = context;
            this.f7362h = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(c.a.p0.a.h2.c.i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (!c.a.p0.a.h2.c.d.h(iVar)) {
                    c.a.p0.a.h2.c.d.q(iVar, this.f7359e, this.f7363i.f7357h);
                    return;
                }
                this.f7363i.f7358i = new JSONObject();
                c.a.p0.a.o2.g.h.a().edit().putInt("aiapps_web_mode_cts_use_key", this.f7360f.optInt("loadCts")).apply();
                if (this.f7360f.optInt("loadCts") == 1) {
                    this.f7363i.u(this.f7361g);
                    g gVar = this.f7363i;
                    gVar.w(this.f7362h, gVar.f7355f, this.f7359e, "master");
                    g gVar2 = this.f7363i;
                    gVar2.w(this.f7362h, gVar2.f7356g, this.f7359e, "slave");
                    this.f7363i.f7354e = true;
                    return;
                }
                this.f7363i.f7354e = false;
                c.a.p0.a.x1.a.a.R(false);
                c.a.p0.a.x1.a.a.Z();
                this.f7359e.handleSchemeDispatchCallback(this.f7363i.f7357h, UnitedSchemeUtility.wrapCallbackParams(0).toString());
            }
        }
    }

    /* loaded from: classes.dex */
    public class b extends ResponseCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.p0.a.d2.e a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f7364b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f7365c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ g f7366d;

        public b(g gVar, c.a.p0.a.d2.e eVar, String str, CallbackHandler callbackHandler) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, eVar, str, callbackHandler};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7366d = gVar;
            this.a = eVar;
            this.f7364b = str;
            this.f7365c = callbackHandler;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
                c.a.p0.a.e0.d.c("SwanAppAction", "request Cts Server Address onFailure: " + exc.getMessage());
                this.f7365c.handleSchemeDispatchCallback(this.f7366d.f7357h, UnitedSchemeUtility.wrapCallbackParams(501, "网络异常").toString());
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
                    this.f7366d.s(this.a, response, this.f7364b, this.f7365c);
                } else {
                    c.a.p0.a.e0.d.c("setCtsConfig", "request Cts Server Address fail,code is " + response.code());
                    this.f7365c.handleSchemeDispatchCallback(this.f7366d.f7357h, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
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
        public final /* synthetic */ CallbackHandler f7367b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ g f7368c;

        public c(g gVar, String str, CallbackHandler callbackHandler) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, str, callbackHandler};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7368c = gVar;
            this.a = str;
            this.f7367b = callbackHandler;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
                c.a.p0.a.e0.d.c("setCtsConfig", "download cts file fail");
                this.f7367b.handleSchemeDispatchCallback(this.f7368c.f7357h, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
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
                g gVar = this.f7368c;
                gVar.v(response, this.a, gVar.f7357h, this.f7367b);
                return response;
            }
            return invokeLI.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-799465091, "Lc/a/p0/a/p0/f/g/g;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-799465091, "Lc/a/p0/a/p0/f/g/g;");
                return;
            }
        }
        f7350j = String.format("?swanjs_version=%s", c.a.p0.a.q2.b.h(0));
        f7351k = "https://smartprogram.baidu.com/batapi/engine" + f7350j + "&type=1";
        l = "https://smartprogram.baidu.com/batapi/engine" + f7350j + "&type=2";
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(c.a.p0.a.f2.e eVar) {
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
        this.f7352c = false;
        this.f7353d = false;
        this.f7354e = false;
    }

    @Override // c.a.p0.a.f2.f.z
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.p0.a.d2.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            JSONObject a2 = z.a(unitedSchemeEntity, "params");
            if (a2 == null) {
                c.a.p0.a.e0.d.c("setCtsConfig", "params is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            } else if (eVar == null) {
                c.a.p0.a.e0.d.c("setCtsConfig", "swanApp is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            } else {
                this.f7357h = a2.optString("cb");
                if (!a2.has("loadCts")) {
                    c.a.p0.a.e0.d.c("setCtsConfig", "loadCts is null");
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

    public final void s(c.a.p0.a.d2.e eVar, Response response, String str, CallbackHandler callbackHandler) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar, response, str, callbackHandler) == null) {
            try {
                JSONObject jSONObject = new JSONObject(response.body().string());
                if (jSONObject.has("code") && jSONObject.optInt("code") == 0) {
                    t(jSONObject.optJSONArray("data").optString(0), str, eVar, callbackHandler);
                } else {
                    callbackHandler.handleSchemeDispatchCallback(this.f7357h, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
                callbackHandler.handleSchemeDispatchCallback(this.f7357h, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
            }
        }
    }

    public final void t(String str, String str2, c.a.p0.a.d2.e eVar, CallbackHandler callbackHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, str, str2, eVar, callbackHandler) == null) {
            c.a.p0.p.d.a aVar = new c.a.p0.p.d.a(c.a.p0.a.c1.a.o().m(str), new c(this, str2, callbackHandler));
            aVar.f10674f = true;
            aVar.f10675g = false;
            aVar.f10676h = true;
            c.a.p0.p.e.a.g().d(aVar);
        }
    }

    public final void u(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, context) == null) {
            if (c.a.p0.a.z2.h.a(context, "aiapps/debug_cts_url.json")) {
                try {
                    JSONObject jSONObject = new JSONObject(c.a.p0.a.z2.h.b(context, "aiapps/debug_cts_url.json"));
                    this.f7355f = jSONObject.optString("master");
                    this.f7356g = jSONObject.optString("slave");
                    if (TextUtils.isEmpty(this.f7355f)) {
                        this.f7355f = f7351k;
                    }
                    if (TextUtils.isEmpty(this.f7356g)) {
                        this.f7356g = l;
                        return;
                    }
                    return;
                } catch (JSONException e2) {
                    e2.printStackTrace();
                    this.f7355f = f7351k;
                    this.f7356g = l;
                    return;
                }
            }
            this.f7355f = f7351k;
            this.f7356g = l;
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
                    if (c.a.p0.w.g.a(byteStream, file2)) {
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
                            this.f7358i.put("master", jSONArray);
                            this.f7352c = true;
                            x(this.f7358i, callbackHandler, str2);
                            return;
                        } else if (c2 != 1) {
                            callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
                            c.a.p0.a.e0.d.c("setCtsConfig", "error type, get cts url failed");
                            return;
                        } else {
                            this.f7358i.put("slave", jSONArray);
                            this.f7353d = true;
                            x(this.f7358i, callbackHandler, str2);
                            return;
                        }
                    }
                    c.a.p0.a.e0.d.c("setCtsConfig", "save cts file fail");
                    callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
                    return;
                } catch (Exception unused) {
                    c.a.p0.a.e0.d.c("setCtsConfig", "save cts file fail");
                    callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
                    return;
                }
            }
            c.a.p0.a.e0.d.c("setCtsConfig", "download cts file fail,code is " + response.code());
            callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
        }
    }

    public final void w(c.a.p0.a.d2.e eVar, String str, CallbackHandler callbackHandler, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048581, this, eVar, str, callbackHandler, str2) == null) {
            c.a.p0.p.d.a aVar = new c.a.p0.p.d.a(str, new b(this, eVar, str2, callbackHandler));
            aVar.f10674f = true;
            aVar.f10675g = false;
            aVar.f10676h = true;
            c.a.p0.p.e.a.g().d(aVar);
        }
    }

    public final void x(JSONObject jSONObject, CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048582, this, jSONObject, callbackHandler, str) == null) && this.f7352c && this.f7353d && this.f7354e) {
            c.a.p0.a.x1.a.a.R(true);
            c.a.p0.a.o2.g.h.a().putString("ctsUrl", jSONObject.toString());
            callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(0).toString());
            this.f7353d = false;
            this.f7352c = false;
            c.a.p0.a.x1.a.a.Z();
        }
    }
}
