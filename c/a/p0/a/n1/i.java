package c.a.p0.a.n1;

import android.content.Context;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import c.a.p0.a.c2.f.a0;
import c.a.p0.a.v2.q0;
import com.baidu.android.imsdk.internal.Constants;
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
public class i extends c.a.p0.a.n1.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements StatResponseCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f7587e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ HttpUrl f7588f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f7589g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f7590h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ long f7591i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ c f7592j;

        public a(i iVar, String str, HttpUrl httpUrl, String str2, int i2, long j2, c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar, str, httpUrl, str2, Integer.valueOf(i2), Long.valueOf(j2), cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7587e = str;
            this.f7588f = httpUrl;
            this.f7589g = str2;
            this.f7590h = i2;
            this.f7591i = j2;
            this.f7592j = cVar;
        }

        @Override // com.baidu.searchbox.http.callback.StatResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
                c.a.p0.a.j2.k.z(this.f7589g, this.f7590h, null, this.f7591i, System.currentTimeMillis());
                if (exc instanceof IOException) {
                    this.f7592j.onFailure(null, (IOException) exc);
                } else {
                    this.f7592j.onFailure(null, new IOException(exc));
                }
            }
        }

        @Override // com.baidu.searchbox.http.callback.StatResponseCallback
        public void onSuccess(Object obj, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj, i2) == null) {
            }
        }

        @Override // com.baidu.searchbox.http.callback.StatResponseCallback
        public Object parseResponse(Response response, int i2, NetworkStatRecord networkStatRecord) throws Exception {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(Constants.METHOD_SEND_USER_MSG, this, response, i2, networkStatRecord)) == null) {
                c.a.p0.a.h0.q.b.g().u(this.f7587e, this.f7588f, networkStatRecord);
                c.a.p0.a.j2.k.z(this.f7589g, this.f7590h, networkStatRecord, this.f7591i, System.currentTimeMillis());
                this.f7592j.onResponse(null, response);
                return response;
            }
            return invokeLIL.objValue;
        }
    }

    /* loaded from: classes.dex */
    public class b implements c.a.p0.a.v2.e1.b<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f7593e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f7594f;

        public b(i iVar, CallbackHandler callbackHandler, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar, callbackHandler, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7593e = callbackHandler;
            this.f7594f = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.f7593e.handleSchemeDispatchCallback(this.f7594f, UnitedSchemeUtility.wrapCallbackParams(1001, str).toString());
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public c.a.p0.a.a2.e f7595a;

        /* renamed from: b  reason: collision with root package name */
        public JSONObject f7596b;

        /* renamed from: c  reason: collision with root package name */
        public String f7597c;

        /* renamed from: d  reason: collision with root package name */
        public String f7598d;

        /* renamed from: e  reason: collision with root package name */
        public CallbackHandler f7599e;

        /* renamed from: f  reason: collision with root package name */
        public String f7600f;

        /* renamed from: g  reason: collision with root package name */
        public long f7601g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ i f7602h;

        public c(@NonNull i iVar, @NonNull c.a.p0.a.a2.e eVar, @NonNull JSONObject jSONObject, @NonNull String str, String str2, @NonNull CallbackHandler callbackHandler, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar, eVar, jSONObject, str, str2, callbackHandler, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7602h = iVar;
            this.f7595a = eVar;
            this.f7596b = jSONObject;
            this.f7597c = str;
            this.f7598d = str2;
            this.f7599e = callbackHandler;
            this.f7600f = str3;
            this.f7601g = System.currentTimeMillis();
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, call, iOException) == null) {
                if (a0.f4766b) {
                    String str = "onFailure: " + iOException.getMessage();
                }
                int G = this.f7595a.N().G();
                String l = c.a.p0.a.j2.k.l();
                String h2 = q0.n().h();
                SwanAppNetworkUtils.a(c.a.p0.m.e.a.g().getOkHttpClient(), this.f7598d);
                this.f7599e.handleSchemeDispatchCallback(this.f7600f, UnitedSchemeUtility.wrapCallbackParams(1001, iOException.getMessage()).toString());
                c.a.p0.a.j2.k.K(0, this.f7597c, G, iOException.getMessage(), l, h2, this.f7601g, System.currentTimeMillis());
            }
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, call, response) == null) {
                if (!c.a.p0.a.j2.k.n(this.f7597c)) {
                    c.a.p0.a.l2.b.l().x(this.f7597c, response.headers("Set-cookie"));
                }
                String B = c.a.p0.a.u.e.j.g.B(this.f7596b);
                String D = c.a.p0.a.u.e.j.g.D(this.f7596b);
                int G = this.f7595a.N().G();
                long currentTimeMillis = System.currentTimeMillis();
                String l = c.a.p0.a.j2.k.l();
                String h2 = q0.n().h();
                String optString = this.f7596b.optString("cb");
                try {
                    long C = c.a.p0.a.u.e.j.g.C(response);
                    if (C <= 10485760) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("statusCode", response.code());
                        jSONObject.put("header", c.a.p0.a.n1.a.s(response.headers()));
                        c.a.p0.a.u.e.j.g.J(jSONObject, response.body(), B, D);
                        this.f7602h.y(jSONObject);
                        this.f7599e.handleSchemeDispatchCallback(optString, UnitedSchemeUtility.wrapCallbackParamsWithEncode(jSONObject, 0).toString());
                    } else {
                        c.a.p0.a.u.e.j.g.K(this.f7595a, this.f7597c, C, currentTimeMillis);
                        this.f7599e.handleSchemeDispatchCallback(optString, UnitedSchemeUtility.wrapCallbackParams(201, "response json length over limits").toString());
                    }
                } catch (IOException | JSONException e2) {
                    if (a0.f4766b) {
                        Log.getStackTraceString(e2);
                    }
                    this.f7599e.handleSchemeDispatchCallback(optString, UnitedSchemeUtility.wrapCallbackParams(201, e2.getMessage()).toString());
                }
                int code = response.code();
                String message = response.message();
                if (a0.f4766b) {
                    String str = "onResponse: respCode: " + code + ", url=" + this.f7597c + ", msg=" + message;
                }
                c.a.p0.a.j2.k.K(code, this.f7597c, G, message, l, h2, this.f7601g, System.currentTimeMillis());
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(c.a.p0.a.c2.e eVar) {
        super(eVar, "/swanAPI/request");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((c.a.p0.a.c2.e) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public boolean A(@NonNull c.a.p0.a.a2.e eVar, @NonNull UnitedSchemeEntity unitedSchemeEntity, @NonNull CallbackHandler callbackHandler, @NonNull String str) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, eVar, unitedSchemeEntity, callbackHandler, str)) == null) {
            JSONObject a2 = a0.a(unitedSchemeEntity, "params");
            if (a2 == null) {
                return false;
            }
            Pair<HttpRequest, Integer> u = c.a.p0.a.u.e.j.g.u(a2, str);
            HttpRequest httpRequest = (HttpRequest) u.first;
            if (httpRequest == null) {
                unitedSchemeEntity.result = t(((Integer) u.second).intValue());
                return false;
            }
            z(eVar, a2, httpRequest, str, callbackHandler);
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    @Override // c.a.p0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.p0.a.a2.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            if (a0.f4766b) {
                String str = "request with scheme : " + unitedSchemeEntity.getParam("params");
            }
            if (k(eVar, unitedSchemeEntity)) {
                String a2 = c.a.p0.a.u.e.j.h.a(eVar.f4558f);
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

    public final boolean x(@NonNull c.a.p0.a.a2.e eVar, @NonNull JSONObject jSONObject, @NonNull String str, @NonNull String str2, CallbackHandler callbackHandler, @NonNull String str3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{eVar, jSONObject, str, str2, callbackHandler, str3})) == null) ? c.a.p0.a.c1.a.d().i(eVar, jSONObject, str, str2, new c(this, eVar, jSONObject, str, str2, callbackHandler, str3), new b(this, callbackHandler, str3)) : invokeCommon.booleanValue;
    }

    public void y(@NonNull JSONObject jSONObject) throws JSONException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, jSONObject) == null) {
        }
    }

    public final void z(@NonNull c.a.p0.a.a2.e eVar, @NonNull JSONObject jSONObject, @NonNull HttpRequest httpRequest, @NonNull String str, @NonNull CallbackHandler callbackHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048580, this, eVar, jSONObject, httpRequest, str, callbackHandler) == null) {
            HttpUrl url = httpRequest.getOkRequest().url();
            String httpUrl = url.toString();
            String optString = jSONObject.optString("cb");
            if (x(eVar, jSONObject, httpUrl, str, callbackHandler, optString)) {
                return;
            }
            httpRequest.executeStat(new a(this, str, url, httpUrl, eVar.N().G(), System.currentTimeMillis(), new c(this, eVar, jSONObject, httpUrl, str, callbackHandler, optString)));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(c.a.p0.a.c2.e eVar, String str) {
        super(eVar, str);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eVar, str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((c.a.p0.a.c2.e) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }
}
