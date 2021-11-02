package b.a.p0.a.n1;

import android.content.Context;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import b.a.p0.a.c2.f.a0;
import b.a.p0.a.v2.q0;
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
import com.dxmpay.wallet.paysdk.entrance.EnterDxmPayServiceAction;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;
@Deprecated
/* loaded from: classes.dex */
public class i extends b.a.p0.a.n1.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements StatResponseCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f6898e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ HttpUrl f6899f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f6900g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f6901h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ long f6902i;
        public final /* synthetic */ c j;

        public a(i iVar, String str, HttpUrl httpUrl, String str2, int i2, long j, c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar, str, httpUrl, str2, Integer.valueOf(i2), Long.valueOf(j), cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6898e = str;
            this.f6899f = httpUrl;
            this.f6900g = str2;
            this.f6901h = i2;
            this.f6902i = j;
            this.j = cVar;
        }

        @Override // com.baidu.searchbox.http.callback.StatResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
                b.a.p0.a.j2.k.z(this.f6900g, this.f6901h, null, this.f6902i, System.currentTimeMillis());
                if (exc instanceof IOException) {
                    this.j.onFailure(null, (IOException) exc);
                } else {
                    this.j.onFailure(null, new IOException(exc));
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
                b.a.p0.a.h0.q.b.g().u(this.f6898e, this.f6899f, networkStatRecord);
                b.a.p0.a.j2.k.z(this.f6900g, this.f6901h, networkStatRecord, this.f6902i, System.currentTimeMillis());
                this.j.onResponse(null, response);
                return response;
            }
            return invokeLIL.objValue;
        }
    }

    /* loaded from: classes.dex */
    public class b implements b.a.p0.a.v2.e1.b<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f6903e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f6904f;

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
            this.f6903e = callbackHandler;
            this.f6904f = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.f6903e.handleSchemeDispatchCallback(this.f6904f, UnitedSchemeUtility.wrapCallbackParams(1001, str).toString());
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public b.a.p0.a.a2.e f6905a;

        /* renamed from: b  reason: collision with root package name */
        public JSONObject f6906b;

        /* renamed from: c  reason: collision with root package name */
        public String f6907c;

        /* renamed from: d  reason: collision with root package name */
        public String f6908d;

        /* renamed from: e  reason: collision with root package name */
        public CallbackHandler f6909e;

        /* renamed from: f  reason: collision with root package name */
        public String f6910f;

        /* renamed from: g  reason: collision with root package name */
        public long f6911g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ i f6912h;

        public c(@NonNull i iVar, @NonNull b.a.p0.a.a2.e eVar, @NonNull JSONObject jSONObject, @NonNull String str, String str2, @NonNull CallbackHandler callbackHandler, String str3) {
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
            this.f6912h = iVar;
            this.f6905a = eVar;
            this.f6906b = jSONObject;
            this.f6907c = str;
            this.f6908d = str2;
            this.f6909e = callbackHandler;
            this.f6910f = str3;
            this.f6911g = System.currentTimeMillis();
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, call, iOException) == null) {
                if (a0.f4160b) {
                    String str = "onFailure: " + iOException.getMessage();
                }
                int F = this.f6905a.M().F();
                String l = b.a.p0.a.j2.k.l();
                String f2 = q0.n().f();
                SwanAppNetworkUtils.a(b.a.p0.m.e.a.g().getOkHttpClient(), this.f6908d);
                this.f6909e.handleSchemeDispatchCallback(this.f6910f, UnitedSchemeUtility.wrapCallbackParams(1001, iOException.getMessage()).toString());
                b.a.p0.a.j2.k.K(0, this.f6907c, F, iOException.getMessage(), l, f2, this.f6911g, System.currentTimeMillis());
            }
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, call, response) == null) {
                if (!b.a.p0.a.j2.k.n(this.f6907c)) {
                    b.a.p0.a.l2.b.l().x(this.f6907c, response.headers("Set-cookie"));
                }
                String A = b.a.p0.a.u.e.j.g.A(this.f6906b);
                String C = b.a.p0.a.u.e.j.g.C(this.f6906b);
                int F = this.f6905a.M().F();
                long currentTimeMillis = System.currentTimeMillis();
                String l = b.a.p0.a.j2.k.l();
                String f2 = q0.n().f();
                String optString = this.f6906b.optString("cb");
                try {
                    long B = b.a.p0.a.u.e.j.g.B(response);
                    if (B <= 10485760) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put(EnterDxmPayServiceAction.SERVICE_STATUS_CODE, response.code());
                        jSONObject.put("header", b.a.p0.a.n1.a.s(response.headers()));
                        b.a.p0.a.u.e.j.g.I(jSONObject, response.body(), A, C);
                        this.f6912h.y(jSONObject);
                        this.f6909e.handleSchemeDispatchCallback(optString, UnitedSchemeUtility.wrapCallbackParamsWithEncode(jSONObject, 0).toString());
                    } else {
                        b.a.p0.a.u.e.j.g.J(this.f6905a, this.f6907c, B, currentTimeMillis);
                        this.f6909e.handleSchemeDispatchCallback(optString, UnitedSchemeUtility.wrapCallbackParams(201, "response json length over limits").toString());
                    }
                } catch (IOException | JSONException e2) {
                    if (a0.f4160b) {
                        Log.getStackTraceString(e2);
                    }
                    this.f6909e.handleSchemeDispatchCallback(optString, UnitedSchemeUtility.wrapCallbackParams(201, e2.getMessage()).toString());
                }
                int code = response.code();
                String message = response.message();
                if (a0.f4160b) {
                    String str = "onResponse: respCode: " + code + ", url=" + this.f6907c + ", msg=" + message;
                }
                b.a.p0.a.j2.k.K(code, this.f6907c, F, message, l, f2, this.f6911g, System.currentTimeMillis());
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(b.a.p0.a.c2.e eVar) {
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
                super((b.a.p0.a.c2.e) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public boolean A(@NonNull b.a.p0.a.a2.e eVar, @NonNull UnitedSchemeEntity unitedSchemeEntity, @NonNull CallbackHandler callbackHandler, @NonNull String str) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, eVar, unitedSchemeEntity, callbackHandler, str)) == null) {
            JSONObject a2 = a0.a(unitedSchemeEntity, "params");
            if (a2 == null) {
                return false;
            }
            Pair<HttpRequest, Integer> t = b.a.p0.a.u.e.j.g.t(a2, str);
            HttpRequest httpRequest = (HttpRequest) t.first;
            if (httpRequest == null) {
                unitedSchemeEntity.result = t(((Integer) t.second).intValue());
                return false;
            }
            z(eVar, a2, httpRequest, str, callbackHandler);
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    @Override // b.a.p0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, b.a.p0.a.a2.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            if (a0.f4160b) {
                String str = "request with scheme : " + unitedSchemeEntity.getParam("params");
            }
            if (k(eVar, unitedSchemeEntity)) {
                String a2 = b.a.p0.a.u.e.j.h.a(eVar.f3961f);
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

    public final boolean x(@NonNull b.a.p0.a.a2.e eVar, @NonNull JSONObject jSONObject, @NonNull String str, @NonNull String str2, CallbackHandler callbackHandler, @NonNull String str3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{eVar, jSONObject, str, str2, callbackHandler, str3})) == null) ? b.a.p0.a.c1.a.d().i(eVar, jSONObject, str, str2, new c(this, eVar, jSONObject, str, str2, callbackHandler, str3), new b(this, callbackHandler, str3)) : invokeCommon.booleanValue;
    }

    public void y(@NonNull JSONObject jSONObject) throws JSONException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, jSONObject) == null) {
        }
    }

    public final void z(@NonNull b.a.p0.a.a2.e eVar, @NonNull JSONObject jSONObject, @NonNull HttpRequest httpRequest, @NonNull String str, @NonNull CallbackHandler callbackHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048580, this, eVar, jSONObject, httpRequest, str, callbackHandler) == null) {
            HttpUrl url = httpRequest.getOkRequest().url();
            String httpUrl = url.toString();
            String optString = jSONObject.optString("cb");
            if (x(eVar, jSONObject, httpUrl, str, callbackHandler, optString)) {
                return;
            }
            httpRequest.executeStat(new a(this, str, url, httpUrl, eVar.M().F(), System.currentTimeMillis(), new c(this, eVar, jSONObject, httpUrl, str, callbackHandler, optString)));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(b.a.p0.a.c2.e eVar, String str) {
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
                super((b.a.p0.a.c2.e) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }
}
