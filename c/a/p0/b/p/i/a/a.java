package c.a.p0.b.p.i.a;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import c.a.p0.a.c1.d.d;
import c.a.p0.a.c2.f.a0;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.location.BDLocation;
import com.baidu.searchbox.http.HttpManager;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.http.request.PostBodyRequest;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.dxmpay.wallet.paysdk.entrance.EnterDxmPayServiceAction;
import i.d;
import i.j;
import java.util.concurrent.TimeUnit;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public abstract class a extends a0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.p0.b.p.i.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0506a implements i.n.b<c.a.p0.b.p.i.b.b> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.b.p.i.b.a f10277e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Context f10278f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f10279g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f10280h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ a f10281i;

        public C0506a(a aVar, c.a.p0.b.p.i.b.a aVar2, Context context, CallbackHandler callbackHandler, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, aVar2, context, callbackHandler, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f10281i = aVar;
            this.f10277e = aVar2;
            this.f10278f = context;
            this.f10279g = callbackHandler;
            this.f10280h = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // i.n.b
        /* renamed from: a */
        public void call(c.a.p0.b.p.i.b.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
                c.a.p0.b.p.i.c.a.b(this.f10277e, bVar);
                this.f10281i.t(this.f10278f, this.f10279g, this.f10280h, this.f10277e);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements i.n.b<Throwable> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f10282e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f10283f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f10284g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.b.p.i.b.a f10285h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ a f10286i;

        public b(a aVar, Context context, CallbackHandler callbackHandler, String str, c.a.p0.b.p.i.b.a aVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, context, callbackHandler, str, aVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f10286i = aVar;
            this.f10282e = context;
            this.f10283f = callbackHandler;
            this.f10284g = str;
            this.f10285h = aVar2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // i.n.b
        /* renamed from: a */
        public void call(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, th) == null) {
                c.a.p0.a.e0.d.l("recommend", "get param(l) info fail: " + th.getMessage());
                this.f10286i.t(this.f10282e, this.f10283f, this.f10284g, this.f10285h);
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements d.a<c.a.p0.b.p.i.b.b> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c.a.p0.b.p.i.a.a$c$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0507a implements d.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ j f10287a;

            public C0507a(c cVar, j jVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, jVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f10287a = jVar;
            }

            @Override // c.a.p0.a.c1.d.d.a
            public void a(c.a.p0.a.c2.f.k0.b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
                    c.a.p0.b.p.i.b.b bVar2 = new c.a.p0.b.p.i.b.b();
                    if (bVar != null && !TextUtils.isEmpty(bVar.f4957a)) {
                        bVar2.f10310a = bVar.f4957a;
                        bVar2.f10311b = bVar.f4959c;
                        bVar2.f10312c = bVar.f4958b;
                    } else {
                        bVar2.f10310a = "unknown";
                    }
                    this.f10287a.onNext(bVar2);
                    this.f10287a.onCompleted();
                }
            }

            @Override // c.a.p0.a.c1.d.d.a
            public void onFailed(int i2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                    this.f10287a.onError(new Throwable());
                }
            }
        }

        public c(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // i.n.b
        /* renamed from: a */
        public void call(j<? super c.a.p0.b.p.i.b.b> jVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jVar) == null) {
                c.a.p0.a.c1.a.E().b(BDLocation.BDLOCATION_GCJ02_TO_BD09, true, false, new C0507a(this, jVar));
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements c.a.p0.a.v2.e1.b<JSONObject> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f10288e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f10289f;

        public d(a aVar, CallbackHandler callbackHandler, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, callbackHandler, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f10288e = callbackHandler;
            this.f10289f = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
                if (jSONObject == null) {
                    c.a.p0.a.e0.d.b("recommend", "response is null");
                    this.f10288e.handleSchemeDispatchCallback(this.f10289f, UnitedSchemeUtility.wrapCallbackParams(1001, "response is null").toString());
                    return;
                }
                c.a.p0.a.e0.d.g("recommend", "recommend action execute success");
                this.f10288e.handleSchemeDispatchCallback(this.f10289f, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString());
            }
        }
    }

    /* loaded from: classes.dex */
    public class e extends ResponseCallback<JSONObject> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.v2.e1.b f10290a;

        public e(a aVar, c.a.p0.a.v2.e1.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f10290a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(JSONObject jSONObject, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, jSONObject, i2) == null) {
                if (jSONObject == null) {
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        jSONObject2.put("info", "on success but jsonObject is null");
                        jSONObject2.put(EnterDxmPayServiceAction.SERVICE_STATUS_CODE, i2);
                    } catch (JSONException e2) {
                        if (a0.f4774b) {
                            e2.printStackTrace();
                        }
                    }
                    c.a.p0.b.p.i.c.a.f(jSONObject2.toString());
                }
                this.f10290a.onCallback(jSONObject);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: b */
        public JSONObject parseResponse(Response response, int i2) throws Exception {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, response, i2)) == null) {
                c.a.p0.a.e0.d.g("recommend", "parse response");
                String str = StringUtil.NULL_STRING;
                if (response != null && response.body() != null) {
                    String string = response.body().string();
                    if (TextUtils.isEmpty(string)) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("info", "parse response fail");
                            jSONObject.put("response code", response.code());
                            if (string != null) {
                                str = "empty";
                            }
                            jSONObject.put("response body", str);
                        } catch (JSONException e2) {
                            if (a0.f4774b) {
                                e2.printStackTrace();
                            }
                        }
                        c.a.p0.b.p.i.c.a.f(jSONObject.toString());
                        return null;
                    }
                    return new JSONObject(string);
                }
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("info", "parse response fail");
                    if (response == null) {
                        jSONObject2.put("response", StringUtil.NULL_STRING);
                    } else {
                        jSONObject2.put("response code", response.code());
                        if (response.body() == null) {
                            jSONObject2.put("response body", StringUtil.NULL_STRING);
                        } else {
                            jSONObject2.put("response", "unknown");
                        }
                    }
                } catch (JSONException e3) {
                    if (a0.f4774b) {
                        e3.printStackTrace();
                    }
                }
                c.a.p0.b.p.i.c.a.f(jSONObject2.toString());
                return null;
            }
            return (JSONObject) invokeLI.objValue;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, exc) == null) {
                c.a.p0.a.e0.d.c("recommend", "http response with exception:", exc);
                this.f10290a.onCallback(null);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("info", "http request fail with exception : " + exc.getMessage());
                } catch (JSONException e2) {
                    if (a0.f4774b) {
                        e2.printStackTrace();
                    }
                }
                c.a.p0.b.p.i.c.a.f(jSONObject.toString());
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(c.a.p0.a.c2.e eVar, String str) {
        super(eVar, str);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eVar, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((UnitedSchemeBaseDispatcher) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // c.a.p0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.p0.a.a2.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            if (a0.f4774b) {
                String str = "handle entity: " + unitedSchemeEntity.toString();
            }
            if (eVar == null) {
                c.a.p0.a.e0.d.b("recommend", "swanApp is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "swanApp is null");
                return false;
            }
            JSONObject a2 = a0.a(unitedSchemeEntity, "params");
            if (a2 == null) {
                c.a.p0.a.e0.d.b("recommend", "param is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "illegal params");
                return false;
            }
            String optString = a2.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                c.a.p0.a.e0.d.b("recommend", "cb is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "illegal cb");
                return false;
            }
            JSONObject optJSONObject = a2.optJSONObject("data");
            if (optJSONObject != null && optJSONObject.length() > 0) {
                c.a.p0.a.e0.d.g("recommend", "start perform request");
                s(context, callbackHandler, optString, optJSONObject);
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                return true;
            }
            c.a.p0.a.e0.d.b("recommend", "param data is empty");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "param data is empty");
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    @NonNull
    public final c.a.p0.a.v2.e1.b<JSONObject> o(@NonNull CallbackHandler callbackHandler, @NonNull String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, callbackHandler, str)) == null) ? new d(this, callbackHandler, str) : (c.a.p0.a.v2.e1.b) invokeLL.objValue;
    }

    @NonNull
    public final ResponseCallback<JSONObject> p(@NonNull c.a.p0.a.v2.e1.b<JSONObject> bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar)) == null) ? new e(this, bVar) : (ResponseCallback) invokeL.objValue;
    }

    public final i.d<c.a.p0.b.p.i.b.b> q(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, context)) == null) {
            if (context == null) {
                return null;
            }
            if (!c.a.p0.a.v2.d.h() || (context.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0 && context.checkSelfPermission("android.permission.ACCESS_COARSE_LOCATION") == 0)) {
                return i.d.b(new c(this));
            }
            return null;
        }
        return (i.d) invokeL.objValue;
    }

    @NonNull
    public abstract String r();

    public final void s(@NonNull Context context, @NonNull CallbackHandler callbackHandler, @NonNull String str, @NonNull JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048581, this, context, callbackHandler, str, jSONObject) == null) {
            c.a.p0.a.e0.d.g("recommend", "get request params");
            c.a.p0.b.p.i.b.a aVar = new c.a.p0.b.p.i.b.a(context, jSONObject);
            i.d<c.a.p0.b.p.i.b.b> q = q(context);
            if (q != null) {
                q.E(60L, TimeUnit.MILLISECONDS).C(new C0506a(this, aVar, context, callbackHandler, str), new b(this, context, callbackHandler, str, aVar));
                return;
            }
            c.a.p0.a.e0.d.l("recommend", "get param(l) is null");
            t(context, callbackHandler, str, aVar);
        }
    }

    public final void t(@NonNull Context context, @NonNull CallbackHandler callbackHandler, @NonNull String str, @NonNull c.a.p0.b.p.i.b.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048582, this, context, callbackHandler, str, aVar) == null) {
            c.a.p0.a.e0.d.g("recommend", "start real perform request");
            String v = c.a.p0.a.d0.c.v(r());
            c.a.p0.a.v2.e1.b<JSONObject> o = o(callbackHandler, str);
            ResponseCallback<JSONObject> p = p(o);
            MediaType parse = MediaType.parse("application/json");
            c.a.p0.a.e0.d.g("recommend", "encrypt request param");
            String a2 = c.a.p0.b.p.i.c.a.a(aVar.d());
            if (TextUtils.isEmpty(a2)) {
                c.a.p0.a.e0.d.b("recommend", "encrypt request param fail");
                o.onCallback(null);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("info", "encrypt request param fail");
                } catch (JSONException e2) {
                    if (a0.f4774b) {
                        e2.printStackTrace();
                    }
                }
                c.a.p0.b.p.i.c.a.f(jSONObject.toString());
                return;
            }
            c.a.p0.a.e0.d.g("recommend", "execute request");
            ((PostBodyRequest.PostBodyRequestBuilder) HttpManager.getDefault(context.getApplicationContext()).postRequest().url(v)).requestBody(RequestBody.create(parse, a2)).build().executeAsync(p);
        }
    }
}
