package c.a.n0.b.g.f.a;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import c.a.n0.a.s0.d.e;
import c.a.n0.a.v1.f.z;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.location.BDLocation;
import com.baidu.nadcore.exp.ADConfigError;
import com.baidu.searchbox.http.HttpManager;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.http.request.PostBodyRequest;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.SchemeCollecter;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import g.d;
import g.j;
import java.util.concurrent.TimeUnit;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public abstract class a extends z {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.n0.b.g.f.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0629a implements g.n.b<c.a.n0.b.g.f.b.b> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.n0.b.g.f.b.a a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f8083b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f8084c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f8085d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f8086e;

        public C0629a(a aVar, c.a.n0.b.g.f.b.a aVar2, Context context, CallbackHandler callbackHandler, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, aVar2, context, callbackHandler, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8086e = aVar;
            this.a = aVar2;
            this.f8083b = context;
            this.f8084c = callbackHandler;
            this.f8085d = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // g.n.b
        public void call(c.a.n0.b.g.f.b.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
                c.a.n0.b.g.f.c.a.b(this.a, bVar);
                this.f8086e.t(this.f8083b, this.f8084c, this.f8085d, this.a);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements g.n.b<Throwable> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f8087b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f8088c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.b.g.f.b.a f8089d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f8090e;

        public b(a aVar, Context context, CallbackHandler callbackHandler, String str, c.a.n0.b.g.f.b.a aVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, context, callbackHandler, str, aVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8090e = aVar;
            this.a = context;
            this.f8087b = callbackHandler;
            this.f8088c = str;
            this.f8089d = aVar2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // g.n.b
        public void call(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                c.a.n0.a.u.d.o("recommend", "get param(l) info fail: " + th.getMessage());
                this.f8090e.t(this.a, this.f8087b, this.f8088c, this.f8089d);
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements d.a<c.a.n0.b.g.f.b.b> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c.a.n0.b.g.f.a.a$c$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0630a implements e.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ j a;

            public C0630a(c cVar, j jVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, jVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = jVar;
            }

            @Override // c.a.n0.a.s0.d.e.a
            public void a(c.a.n0.a.v1.f.j0.b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
                    c.a.n0.b.g.f.b.b bVar2 = new c.a.n0.b.g.f.b.b();
                    if (bVar != null && !TextUtils.isEmpty(bVar.a)) {
                        bVar2.a = bVar.a;
                        bVar2.f8106b = bVar.f6787c;
                        bVar2.f8107c = bVar.f6786b;
                    } else {
                        bVar2.a = "unknown";
                    }
                    this.a.onNext(bVar2);
                    this.a.onCompleted();
                }
            }

            @Override // c.a.n0.a.s0.d.e.a
            public void onFailed(int i) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
                    this.a.onError(new Throwable());
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // g.d.a, g.n.b
        public void call(j<? super c.a.n0.b.g.f.b.b> jVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jVar) == null) {
                c.a.n0.a.s0.a.I().b(BDLocation.BDLOCATION_GCJ02_TO_BD09, true, false, new C0630a(this, jVar));
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements c.a.n0.a.p2.g1.c<JSONObject> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f8091b;

        public d(a aVar, CallbackHandler callbackHandler, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, callbackHandler, str};
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
            this.f8091b = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.n0.a.p2.g1.c
        /* renamed from: a */
        public void onCallback(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
                if (jSONObject == null) {
                    c.a.n0.a.u.d.c("recommend", ADConfigError.REASON_NULL_RESPONSE);
                    this.a.handleSchemeDispatchCallback(this.f8091b, UnitedSchemeUtility.wrapCallbackParams(1001, ADConfigError.REASON_NULL_RESPONSE).toString());
                    return;
                }
                c.a.n0.a.u.d.i("recommend", "recommend action execute success");
                this.a.handleSchemeDispatchCallback(this.f8091b, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString());
            }
        }
    }

    /* loaded from: classes.dex */
    public class e extends ResponseCallback<JSONObject> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.n0.a.p2.g1.c a;

        public e(a aVar, c.a.n0.a.p2.g1.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
                c.a.n0.a.u.d.d("recommend", "http response with exception:", exc);
                this.a.onCallback(null);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("info", "http request fail with exception : " + exc.getMessage());
                } catch (JSONException e2) {
                    if (z.f6924b) {
                        e2.printStackTrace();
                    }
                }
                c.a.n0.b.g.f.c.a.f(jSONObject.toString());
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(JSONObject jSONObject, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, jSONObject, i) == null) {
                if (jSONObject == null) {
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        jSONObject2.put("info", "on success but jsonObject is null");
                        jSONObject2.put("statusCode", i);
                    } catch (JSONException e2) {
                        if (z.f6924b) {
                            e2.printStackTrace();
                        }
                    }
                    c.a.n0.b.g.f.c.a.f(jSONObject2.toString());
                }
                this.a.onCallback(jSONObject);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public JSONObject parseResponse(Response response, int i) throws Exception {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(1048580, this, response, i)) == null) {
                c.a.n0.a.u.d.i("recommend", "parse response");
                String str = StringUtil.NULL_STRING;
                if (response != null && response.body() != null) {
                    String string = response.body().string();
                    if (TextUtils.isEmpty(string)) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("info", "parse response fail");
                            jSONObject.put("response code", response.code());
                            if (string != null) {
                                str = SchemeCollecter.CLASSIFY_EMPTY;
                            }
                            jSONObject.put("response body", str);
                        } catch (JSONException e2) {
                            if (z.f6924b) {
                                e2.printStackTrace();
                            }
                        }
                        c.a.n0.b.g.f.c.a.f(jSONObject.toString());
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
                    if (z.f6924b) {
                        e3.printStackTrace();
                    }
                }
                c.a.n0.b.g.f.c.a.f(jSONObject2.toString());
                return null;
            }
            return (JSONObject) invokeLI.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(c.a.n0.a.v1.e eVar, String str) {
        super(eVar, str);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eVar, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((UnitedSchemeBaseDispatcher) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // c.a.n0.a.v1.f.z
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.n0.a.t1.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            if (z.f6924b) {
                Log.d("BaseRecommendAction", "handle entity: " + unitedSchemeEntity.toString());
            }
            if (eVar == null) {
                c.a.n0.a.u.d.c("recommend", "swanApp is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "swanApp is null");
                return false;
            }
            JSONObject a = z.a(unitedSchemeEntity, "params");
            if (a == null) {
                c.a.n0.a.u.d.c("recommend", "param is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "illegal params");
                return false;
            }
            String optString = a.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                c.a.n0.a.u.d.c("recommend", "cb is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "illegal cb");
                return false;
            }
            JSONObject optJSONObject = a.optJSONObject("data");
            if (optJSONObject != null && optJSONObject.length() > 0) {
                c.a.n0.a.u.d.i("recommend", "start perform request");
                s(context, callbackHandler, optString, optJSONObject);
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                return true;
            }
            c.a.n0.a.u.d.c("recommend", "param data is empty");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "param data is empty");
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    @NonNull
    public final c.a.n0.a.p2.g1.c<JSONObject> o(@NonNull CallbackHandler callbackHandler, @NonNull String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, callbackHandler, str)) == null) ? new d(this, callbackHandler, str) : (c.a.n0.a.p2.g1.c) invokeLL.objValue;
    }

    @NonNull
    public final ResponseCallback<JSONObject> p(@NonNull c.a.n0.a.p2.g1.c<JSONObject> cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar)) == null) ? new e(this, cVar) : (ResponseCallback) invokeL.objValue;
    }

    public final g.d<c.a.n0.b.g.f.b.b> q(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, context)) == null) {
            if (context == null) {
                return null;
            }
            if (!c.a.n0.a.p2.d.h() || (context.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0 && context.checkSelfPermission("android.permission.ACCESS_COARSE_LOCATION") == 0)) {
                return g.d.a(new c(this));
            }
            return null;
        }
        return (g.d) invokeL.objValue;
    }

    @NonNull
    public abstract String r();

    public final void s(@NonNull Context context, @NonNull CallbackHandler callbackHandler, @NonNull String str, @NonNull JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048581, this, context, callbackHandler, str, jSONObject) == null) {
            c.a.n0.a.u.d.i("recommend", "get request params");
            c.a.n0.b.g.f.b.a aVar = new c.a.n0.b.g.f.b.a(context, jSONObject);
            g.d<c.a.n0.b.g.f.b.b> q = q(context);
            if (q != null) {
                q.z(60L, TimeUnit.MILLISECONDS).x(new C0629a(this, aVar, context, callbackHandler, str), new b(this, context, callbackHandler, str, aVar));
                return;
            }
            c.a.n0.a.u.d.o("recommend", "get param(l) is null");
            t(context, callbackHandler, str, aVar);
        }
    }

    public final void t(@NonNull Context context, @NonNull CallbackHandler callbackHandler, @NonNull String str, @NonNull c.a.n0.b.g.f.b.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048582, this, context, callbackHandler, str, aVar) == null) {
            c.a.n0.a.u.d.i("recommend", "start real perform request");
            String v = c.a.n0.a.t.c.v(r());
            c.a.n0.a.p2.g1.c<JSONObject> o = o(callbackHandler, str);
            ResponseCallback<JSONObject> p = p(o);
            MediaType parse = MediaType.parse("application/json");
            c.a.n0.a.u.d.i("recommend", "encrypt request param");
            String a = c.a.n0.b.g.f.c.a.a(aVar.d());
            if (TextUtils.isEmpty(a)) {
                c.a.n0.a.u.d.c("recommend", "encrypt request param fail");
                o.onCallback(null);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("info", "encrypt request param fail");
                } catch (JSONException e2) {
                    if (z.f6924b) {
                        e2.printStackTrace();
                    }
                }
                c.a.n0.b.g.f.c.a.f(jSONObject.toString());
                return;
            }
            c.a.n0.a.u.d.i("recommend", "execute request");
            ((PostBodyRequest.PostBodyRequestBuilder) HttpManager.getDefault(context.getApplicationContext()).postRequest().url(v)).requestBody(RequestBody.create(parse, a)).build().executeAsync(p);
        }
    }
}
