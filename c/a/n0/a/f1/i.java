package c.a.n0.a.f1;

import android.content.Context;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import c.a.n0.a.p2.q0;
import c.a.n0.a.v1.f.z;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.http.callback.StatResponseCallback;
import com.baidu.searchbox.http.request.HttpRequest;
import com.baidu.searchbox.http.statistics.NetworkStatRecord;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;
@Deprecated
/* loaded from: classes.dex */
public class i extends c.a.n0.a.f1.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements StatResponseCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ HttpUrl f4427b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f4428c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ int f4429d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ long f4430e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c f4431f;

        public a(i iVar, String str, HttpUrl httpUrl, String str2, int i, long j, c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar, str, httpUrl, str2, Integer.valueOf(i), Long.valueOf(j), cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
            this.f4427b = httpUrl;
            this.f4428c = str2;
            this.f4429d = i;
            this.f4430e = j;
            this.f4431f = cVar;
        }

        @Override // com.baidu.searchbox.http.callback.StatResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
                c.a.n0.a.d2.n.C(this.f4428c, this.f4429d, null, this.f4430e, System.currentTimeMillis(), this.a);
                if (exc instanceof IOException) {
                    this.f4431f.onFailure(null, (IOException) exc);
                } else {
                    this.f4431f.onFailure(null, new IOException(exc));
                }
            }
        }

        @Override // com.baidu.searchbox.http.callback.StatResponseCallback
        public void onSuccess(Object obj, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj, i) == null) {
            }
        }

        @Override // com.baidu.searchbox.http.callback.StatResponseCallback
        public Object parseResponse(Response response, int i, NetworkStatRecord networkStatRecord) throws Exception {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(Constants.METHOD_SEND_USER_MSG, this, response, i, networkStatRecord)) == null) {
                c.a.n0.a.x.q.b.k().C(this.a, this.f4427b, networkStatRecord);
                c.a.n0.a.d2.n.C(this.f4428c, this.f4429d, networkStatRecord, this.f4430e, System.currentTimeMillis(), this.a);
                this.f4431f.onResponse(null, response);
                return response;
            }
            return invokeLIL.objValue;
        }
    }

    /* loaded from: classes.dex */
    public class b implements c.a.n0.a.p2.g1.c<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f4432b;

        public b(i iVar, CallbackHandler callbackHandler, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar, callbackHandler, str};
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
            this.f4432b = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.n0.a.p2.g1.c
        /* renamed from: a */
        public void onCallback(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.a.handleSchemeDispatchCallback(this.f4432b, UnitedSchemeUtility.wrapCallbackParams(1001, str).toString());
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public c.a.n0.a.t1.e a;

        /* renamed from: b  reason: collision with root package name */
        public JSONObject f4433b;

        /* renamed from: c  reason: collision with root package name */
        public String f4434c;

        /* renamed from: d  reason: collision with root package name */
        public String f4435d;

        /* renamed from: e  reason: collision with root package name */
        public CallbackHandler f4436e;

        /* renamed from: f  reason: collision with root package name */
        public String f4437f;

        /* renamed from: g  reason: collision with root package name */
        public long f4438g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ i f4439h;

        public c(@NonNull i iVar, @NonNull c.a.n0.a.t1.e eVar, @NonNull JSONObject jSONObject, @NonNull String str, String str2, @NonNull CallbackHandler callbackHandler, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar, eVar, jSONObject, str, str2, callbackHandler, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4439h = iVar;
            this.a = eVar;
            this.f4433b = jSONObject;
            this.f4434c = str;
            this.f4435d = str2;
            this.f4436e = callbackHandler;
            this.f4437f = str3;
            this.f4438g = System.currentTimeMillis();
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, call, iOException) == null) {
                if (z.f6924b) {
                    Log.d("RequestAction", "onFailure: " + iOException.getMessage());
                }
                int G = this.a.X().G();
                String l = c.a.n0.a.d2.n.l();
                String e2 = q0.n().e();
                SwanAppNetworkUtils.a(c.a.n0.p.e.a.g().getOkHttpClient(), this.f4435d);
                this.f4436e.handleSchemeDispatchCallback(this.f4437f, UnitedSchemeUtility.wrapCallbackParams(1001, iOException.getMessage()).toString());
                c.a.n0.a.d2.n.Q(0, this.f4434c, G, iOException.getMessage(), l, e2, this.f4438g, System.currentTimeMillis(), this.f4435d);
            }
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, call, response) == null) {
                if (!c.a.n0.a.d2.n.o(this.f4434c)) {
                    c.a.n0.a.f2.b.l().x(this.f4434c, response.headers("Set-cookie"));
                }
                String J = c.a.n0.a.k.e.i.i.J(this.f4433b);
                String L = c.a.n0.a.k.e.i.i.L(this.f4433b);
                int G = this.a.X().G();
                long currentTimeMillis = System.currentTimeMillis();
                String l = c.a.n0.a.d2.n.l();
                String e2 = q0.n().e();
                String optString = this.f4433b.optString("cb");
                try {
                    long K = c.a.n0.a.k.e.i.i.K(response);
                    if (K <= Config.FULL_TRACE_LOG_LIMIT) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("statusCode", response.code());
                        jSONObject.put("header", c.a.n0.a.f1.a.s(response.headers()));
                        c.a.n0.a.k.e.i.i.R(jSONObject, response.body(), J, L);
                        this.f4439h.y(jSONObject);
                        this.f4436e.handleSchemeDispatchCallback(optString, UnitedSchemeUtility.wrapCallbackParamsWithEncode(jSONObject, 0).toString());
                    } else {
                        c.a.n0.a.k.e.i.i.S(this.a, this.f4434c, K, currentTimeMillis);
                        this.f4436e.handleSchemeDispatchCallback(optString, UnitedSchemeUtility.wrapCallbackParams(201, "response json length over limits").toString());
                    }
                } catch (IOException | JSONException e3) {
                    if (z.f6924b) {
                        Log.d("RequestAction", Log.getStackTraceString(e3));
                    }
                    this.f4436e.handleSchemeDispatchCallback(optString, UnitedSchemeUtility.wrapCallbackParams(201, e3.getMessage()).toString());
                }
                int code = response.code();
                String message = response.message();
                if (z.f6924b) {
                    Log.d("RequestAction", "onResponse: respCode: " + code + ", url=" + this.f4434c + ", msg=" + message);
                }
                c.a.n0.a.d2.n.Q(code, this.f4434c, G, message, l, e2, this.f4438g, System.currentTimeMillis(), this.f4435d);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(c.a.n0.a.v1.e eVar) {
        super(eVar, "/swanAPI/request");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((c.a.n0.a.v1.e) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public boolean A(@NonNull c.a.n0.a.t1.e eVar, @NonNull UnitedSchemeEntity unitedSchemeEntity, @NonNull CallbackHandler callbackHandler, @NonNull String str) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, eVar, unitedSchemeEntity, callbackHandler, str)) == null) {
            JSONObject a2 = z.a(unitedSchemeEntity, "params");
            if (a2 == null) {
                return false;
            }
            Pair<HttpRequest, Integer> C = c.a.n0.a.k.e.i.i.C(a2, str);
            HttpRequest httpRequest = (HttpRequest) C.first;
            if (httpRequest == null) {
                unitedSchemeEntity.result = t(((Integer) C.second).intValue());
                return false;
            }
            z(eVar, a2, httpRequest, str, callbackHandler);
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    @Override // c.a.n0.a.v1.f.z
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.n0.a.t1.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            if (z.f6924b) {
                Log.d("RequestApi", "request with scheme : " + unitedSchemeEntity.getParam("params"));
            }
            if (k(eVar, unitedSchemeEntity)) {
                String a2 = c.a.n0.a.k.e.i.j.a(eVar.f6344b);
                if (A(eVar, unitedSchemeEntity, callbackHandler, a2)) {
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(n(a2), 0));
                    return true;
                }
                return false;
            }
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    public final boolean x(@NonNull c.a.n0.a.t1.e eVar, @NonNull JSONObject jSONObject, @NonNull String str, @NonNull String str2, CallbackHandler callbackHandler, @NonNull String str3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{eVar, jSONObject, str, str2, callbackHandler, str3})) == null) ? c.a.n0.a.s0.a.e().i(eVar, jSONObject, str, str2, new c(this, eVar, jSONObject, str, str2, callbackHandler, str3), new b(this, callbackHandler, str3)) : invokeCommon.booleanValue;
    }

    public void y(@NonNull JSONObject jSONObject) throws JSONException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, jSONObject) == null) {
        }
    }

    public final void z(@NonNull c.a.n0.a.t1.e eVar, @NonNull JSONObject jSONObject, @NonNull HttpRequest httpRequest, @NonNull String str, @NonNull CallbackHandler callbackHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048580, this, eVar, jSONObject, httpRequest, str, callbackHandler) == null) {
            HttpUrl url = httpRequest.getOkRequest().url();
            String httpUrl = url.toString();
            String optString = jSONObject.optString("cb");
            if (x(eVar, jSONObject, httpUrl, str, callbackHandler, optString)) {
                return;
            }
            httpRequest.executeStat(new a(this, str, url, httpUrl, eVar.X().G(), System.currentTimeMillis(), new c(this, eVar, jSONObject, httpUrl, str, callbackHandler, optString)));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(c.a.n0.a.v1.e eVar, String str) {
        super(eVar, str);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eVar, str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((c.a.n0.a.v1.e) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }
}
