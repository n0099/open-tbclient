package c.a.r0.a.p0.f.g;

import android.content.Context;
import android.text.TextUtils;
import c.a.r0.a.f2.f.z;
import c.a.r0.a.h2.c.j.b;
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
    public static final String f8394j;

    /* renamed from: k  reason: collision with root package name */
    public static final String f8395k;
    public static final String l;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public boolean f8396c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f8397d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f8398e;

    /* renamed from: f  reason: collision with root package name */
    public String f8399f;

    /* renamed from: g  reason: collision with root package name */
    public String f8400g;

    /* renamed from: h  reason: collision with root package name */
    public String f8401h;

    /* renamed from: i  reason: collision with root package name */
    public JSONObject f8402i;

    /* loaded from: classes.dex */
    public class a implements c.a.r0.a.z2.g1.c<c.a.r0.a.h2.c.i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f8403e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ JSONObject f8404f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f8405g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.d2.e f8406h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ g f8407i;

        public a(g gVar, CallbackHandler callbackHandler, JSONObject jSONObject, Context context, c.a.r0.a.d2.e eVar) {
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
            this.f8407i = gVar;
            this.f8403e = callbackHandler;
            this.f8404f = jSONObject;
            this.f8405g = context;
            this.f8406h = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.r0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(c.a.r0.a.h2.c.i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (!c.a.r0.a.h2.c.d.h(iVar)) {
                    c.a.r0.a.h2.c.d.q(iVar, this.f8403e, this.f8407i.f8401h);
                    return;
                }
                this.f8407i.f8402i = new JSONObject();
                c.a.r0.a.o2.g.h.a().edit().putInt("aiapps_web_mode_cts_use_key", this.f8404f.optInt("loadCts")).apply();
                if (this.f8404f.optInt("loadCts") == 1) {
                    this.f8407i.u(this.f8405g);
                    g gVar = this.f8407i;
                    gVar.w(this.f8406h, gVar.f8399f, this.f8403e, "master");
                    g gVar2 = this.f8407i;
                    gVar2.w(this.f8406h, gVar2.f8400g, this.f8403e, "slave");
                    this.f8407i.f8398e = true;
                    return;
                }
                this.f8407i.f8398e = false;
                c.a.r0.a.x1.a.a.R(false);
                c.a.r0.a.x1.a.a.Z();
                this.f8403e.handleSchemeDispatchCallback(this.f8407i.f8401h, UnitedSchemeUtility.wrapCallbackParams(0).toString());
            }
        }
    }

    /* loaded from: classes.dex */
    public class b extends ResponseCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.r0.a.d2.e a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f8408b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f8409c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ g f8410d;

        public b(g gVar, c.a.r0.a.d2.e eVar, String str, CallbackHandler callbackHandler) {
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
            this.f8410d = gVar;
            this.a = eVar;
            this.f8408b = str;
            this.f8409c = callbackHandler;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
                c.a.r0.a.e0.d.c("SwanAppAction", "request Cts Server Address onFailure: " + exc.getMessage());
                this.f8409c.handleSchemeDispatchCallback(this.f8410d.f8401h, UnitedSchemeUtility.wrapCallbackParams(501, "网络异常").toString());
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
                    this.f8410d.s(this.a, response, this.f8408b, this.f8409c);
                } else {
                    c.a.r0.a.e0.d.c("setCtsConfig", "request Cts Server Address fail,code is " + response.code());
                    this.f8409c.handleSchemeDispatchCallback(this.f8410d.f8401h, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
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
        public final /* synthetic */ CallbackHandler f8411b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ g f8412c;

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
            this.f8412c = gVar;
            this.a = str;
            this.f8411b = callbackHandler;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
                c.a.r0.a.e0.d.c("setCtsConfig", "download cts file fail");
                this.f8411b.handleSchemeDispatchCallback(this.f8412c.f8401h, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
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
                g gVar = this.f8412c;
                gVar.v(response, this.a, gVar.f8401h, this.f8411b);
                return response;
            }
            return invokeLI.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1810582341, "Lc/a/r0/a/p0/f/g/g;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1810582341, "Lc/a/r0/a/p0/f/g/g;");
                return;
            }
        }
        f8394j = String.format("?swanjs_version=%s", c.a.r0.a.q2.b.h(0));
        f8395k = "https://smartprogram.baidu.com/batapi/engine" + f8394j + "&type=1";
        l = "https://smartprogram.baidu.com/batapi/engine" + f8394j + "&type=2";
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(c.a.r0.a.f2.e eVar) {
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
        this.f8396c = false;
        this.f8397d = false;
        this.f8398e = false;
    }

    @Override // c.a.r0.a.f2.f.z
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.r0.a.d2.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            JSONObject a2 = z.a(unitedSchemeEntity, "params");
            if (a2 == null) {
                c.a.r0.a.e0.d.c("setCtsConfig", "params is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            } else if (eVar == null) {
                c.a.r0.a.e0.d.c("setCtsConfig", "swanApp is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            } else {
                this.f8401h = a2.optString("cb");
                if (!a2.has("loadCts")) {
                    c.a.r0.a.e0.d.c("setCtsConfig", "loadCts is null");
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

    public final void s(c.a.r0.a.d2.e eVar, Response response, String str, CallbackHandler callbackHandler) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar, response, str, callbackHandler) == null) {
            try {
                JSONObject jSONObject = new JSONObject(response.body().string());
                if (jSONObject.has("code") && jSONObject.optInt("code") == 0) {
                    t(jSONObject.optJSONArray("data").optString(0), str, eVar, callbackHandler);
                } else {
                    callbackHandler.handleSchemeDispatchCallback(this.f8401h, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
                callbackHandler.handleSchemeDispatchCallback(this.f8401h, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
            }
        }
    }

    public final void t(String str, String str2, c.a.r0.a.d2.e eVar, CallbackHandler callbackHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, str, str2, eVar, callbackHandler) == null) {
            c.a.r0.p.d.a aVar = new c.a.r0.p.d.a(c.a.r0.a.c1.a.o().m(str), new c(this, str2, callbackHandler));
            aVar.f11718f = true;
            aVar.f11719g = false;
            aVar.f11720h = true;
            c.a.r0.p.e.a.g().d(aVar);
        }
    }

    public final void u(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, context) == null) {
            if (c.a.r0.a.z2.h.a(context, "aiapps/debug_cts_url.json")) {
                try {
                    JSONObject jSONObject = new JSONObject(c.a.r0.a.z2.h.b(context, "aiapps/debug_cts_url.json"));
                    this.f8399f = jSONObject.optString("master");
                    this.f8400g = jSONObject.optString("slave");
                    if (TextUtils.isEmpty(this.f8399f)) {
                        this.f8399f = f8395k;
                    }
                    if (TextUtils.isEmpty(this.f8400g)) {
                        this.f8400g = l;
                        return;
                    }
                    return;
                } catch (JSONException e2) {
                    e2.printStackTrace();
                    this.f8399f = f8395k;
                    this.f8400g = l;
                    return;
                }
            }
            this.f8399f = f8395k;
            this.f8400g = l;
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
                    if (c.a.r0.w.g.a(byteStream, file2)) {
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
                            this.f8402i.put("master", jSONArray);
                            this.f8396c = true;
                            x(this.f8402i, callbackHandler, str2);
                            return;
                        } else if (c2 != 1) {
                            callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
                            c.a.r0.a.e0.d.c("setCtsConfig", "error type, get cts url failed");
                            return;
                        } else {
                            this.f8402i.put("slave", jSONArray);
                            this.f8397d = true;
                            x(this.f8402i, callbackHandler, str2);
                            return;
                        }
                    }
                    c.a.r0.a.e0.d.c("setCtsConfig", "save cts file fail");
                    callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
                    return;
                } catch (Exception unused) {
                    c.a.r0.a.e0.d.c("setCtsConfig", "save cts file fail");
                    callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
                    return;
                }
            }
            c.a.r0.a.e0.d.c("setCtsConfig", "download cts file fail,code is " + response.code());
            callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
        }
    }

    public final void w(c.a.r0.a.d2.e eVar, String str, CallbackHandler callbackHandler, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048581, this, eVar, str, callbackHandler, str2) == null) {
            c.a.r0.p.d.a aVar = new c.a.r0.p.d.a(str, new b(this, eVar, str2, callbackHandler));
            aVar.f11718f = true;
            aVar.f11719g = false;
            aVar.f11720h = true;
            c.a.r0.p.e.a.g().d(aVar);
        }
    }

    public final void x(JSONObject jSONObject, CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048582, this, jSONObject, callbackHandler, str) == null) && this.f8396c && this.f8397d && this.f8398e) {
            c.a.r0.a.x1.a.a.R(true);
            c.a.r0.a.o2.g.h.a().putString("ctsUrl", jSONObject.toString());
            callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(0).toString());
            this.f8397d = false;
            this.f8396c = false;
            c.a.r0.a.x1.a.a.Z();
        }
    }
}
