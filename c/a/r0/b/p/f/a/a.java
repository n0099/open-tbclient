package c.a.r0.b.p.f.a;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import c.a.r0.a.c1.d.e;
import c.a.r0.a.f2.f.z;
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
import com.dxmpay.wallet.paysdk.entrance.EnterDxmPayServiceAction;
import com.kuaishou.weapon.un.s;
import i.d;
import i.j;
import java.util.concurrent.TimeUnit;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public abstract class a extends z {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.r0.b.p.f.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C0672a implements i.n.b<c.a.r0.b.p.f.b.b> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.b.p.f.b.a f10189e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Context f10190f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f10191g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f10192h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ a f10193i;

        public C0672a(a aVar, c.a.r0.b.p.f.b.a aVar2, Context context, CallbackHandler callbackHandler, String str) {
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
            this.f10193i = aVar;
            this.f10189e = aVar2;
            this.f10190f = context;
            this.f10191g = callbackHandler;
            this.f10192h = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // i.n.b
        public void call(c.a.r0.b.p.f.b.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
                c.a.r0.b.p.f.c.a.b(this.f10189e, bVar);
                this.f10193i.t(this.f10190f, this.f10191g, this.f10192h, this.f10189e);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements i.n.b<Throwable> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f10194e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f10195f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f10196g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.b.p.f.b.a f10197h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ a f10198i;

        public b(a aVar, Context context, CallbackHandler callbackHandler, String str, c.a.r0.b.p.f.b.a aVar2) {
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
            this.f10198i = aVar;
            this.f10194e = context;
            this.f10195f = callbackHandler;
            this.f10196g = str;
            this.f10197h = aVar2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // i.n.b
        public void call(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                c.a.r0.a.e0.d.o("recommend", "get param(l) info fail: " + th.getMessage());
                this.f10198i.t(this.f10194e, this.f10195f, this.f10196g, this.f10197h);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements d.a<c.a.r0.b.p.f.b.b> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c.a.r0.b.p.f.a.a$c$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class C0673a implements e.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ j a;

            public C0673a(c cVar, j jVar) {
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
                this.a = jVar;
            }

            @Override // c.a.r0.a.c1.d.e.a
            public void a(c.a.r0.a.f2.f.j0.b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
                    c.a.r0.b.p.f.b.b bVar2 = new c.a.r0.b.p.f.b.b();
                    if (bVar != null && !TextUtils.isEmpty(bVar.a)) {
                        bVar2.a = bVar.a;
                        bVar2.f10216b = bVar.f6037c;
                        bVar2.f10217c = bVar.f6036b;
                    } else {
                        bVar2.a = "unknown";
                    }
                    this.a.onNext(bVar2);
                    this.a.onCompleted();
                }
            }

            @Override // c.a.r0.a.c1.d.e.a
            public void onFailed(int i2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // i.d.a, i.n.b
        public void call(j<? super c.a.r0.b.p.f.b.b> jVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jVar) == null) {
                c.a.r0.a.c1.a.I().b(BDLocation.BDLOCATION_GCJ02_TO_BD09, true, false, new C0673a(this, jVar));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements c.a.r0.a.z2.g1.c<JSONObject> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f10199e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f10200f;

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
            this.f10199e = callbackHandler;
            this.f10200f = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.r0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
                if (jSONObject == null) {
                    c.a.r0.a.e0.d.c("recommend", ADConfigError.REASON_NULL_RESPONSE);
                    this.f10199e.handleSchemeDispatchCallback(this.f10200f, UnitedSchemeUtility.wrapCallbackParams(1001, ADConfigError.REASON_NULL_RESPONSE).toString());
                    return;
                }
                c.a.r0.a.e0.d.i("recommend", "recommend action execute success");
                this.f10199e.handleSchemeDispatchCallback(this.f10200f, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e extends ResponseCallback<JSONObject> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.r0.a.z2.g1.c a;

        public e(a aVar, c.a.r0.a.z2.g1.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
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
                        if (z.f6201b) {
                            e2.printStackTrace();
                        }
                    }
                    c.a.r0.b.p.f.c.a.f(jSONObject2.toString());
                }
                this.a.onCallback(jSONObject);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: b */
        public JSONObject parseResponse(Response response, int i2) throws Exception {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, response, i2)) == null) {
                c.a.r0.a.e0.d.i("recommend", "parse response");
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
                            if (z.f6201b) {
                                e2.printStackTrace();
                            }
                        }
                        c.a.r0.b.p.f.c.a.f(jSONObject.toString());
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
                    if (z.f6201b) {
                        e3.printStackTrace();
                    }
                }
                c.a.r0.b.p.f.c.a.f(jSONObject2.toString());
                return null;
            }
            return (JSONObject) invokeLI.objValue;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, exc) == null) {
                c.a.r0.a.e0.d.d("recommend", "http response with exception:", exc);
                this.a.onCallback(null);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("info", "http request fail with exception : " + exc.getMessage());
                } catch (JSONException e2) {
                    if (z.f6201b) {
                        e2.printStackTrace();
                    }
                }
                c.a.r0.b.p.f.c.a.f(jSONObject.toString());
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(c.a.r0.a.f2.e eVar, String str) {
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

    @Override // c.a.r0.a.f2.f.z
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.r0.a.d2.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            if (z.f6201b) {
                String str = "handle entity: " + unitedSchemeEntity.toString();
            }
            if (eVar == null) {
                c.a.r0.a.e0.d.c("recommend", "swanApp is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "swanApp is null");
                return false;
            }
            JSONObject a = z.a(unitedSchemeEntity, "params");
            if (a == null) {
                c.a.r0.a.e0.d.c("recommend", "param is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "illegal params");
                return false;
            }
            String optString = a.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                c.a.r0.a.e0.d.c("recommend", "cb is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "illegal cb");
                return false;
            }
            JSONObject optJSONObject = a.optJSONObject("data");
            if (optJSONObject != null && optJSONObject.length() > 0) {
                c.a.r0.a.e0.d.i("recommend", "start perform request");
                s(context, callbackHandler, optString, optJSONObject);
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                return true;
            }
            c.a.r0.a.e0.d.c("recommend", "param data is empty");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "param data is empty");
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    @NonNull
    public final c.a.r0.a.z2.g1.c<JSONObject> o(@NonNull CallbackHandler callbackHandler, @NonNull String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, callbackHandler, str)) == null) ? new d(this, callbackHandler, str) : (c.a.r0.a.z2.g1.c) invokeLL.objValue;
    }

    @NonNull
    public final ResponseCallback<JSONObject> p(@NonNull c.a.r0.a.z2.g1.c<JSONObject> cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar)) == null) ? new e(this, cVar) : (ResponseCallback) invokeL.objValue;
    }

    public final i.d<c.a.r0.b.p.f.b.b> q(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, context)) == null) {
            if (context == null) {
                return null;
            }
            if (!c.a.r0.a.z2.d.h() || (context.checkSelfPermission(s.f55246g) == 0 && context.checkSelfPermission(s.f55247h) == 0)) {
                return i.d.a(new c(this));
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
            c.a.r0.a.e0.d.i("recommend", "get request params");
            c.a.r0.b.p.f.b.a aVar = new c.a.r0.b.p.f.b.a(context, jSONObject);
            i.d<c.a.r0.b.p.f.b.b> q = q(context);
            if (q != null) {
                q.z(60L, TimeUnit.MILLISECONDS).x(new C0672a(this, aVar, context, callbackHandler, str), new b(this, context, callbackHandler, str, aVar));
                return;
            }
            c.a.r0.a.e0.d.o("recommend", "get param(l) is null");
            t(context, callbackHandler, str, aVar);
        }
    }

    public final void t(@NonNull Context context, @NonNull CallbackHandler callbackHandler, @NonNull String str, @NonNull c.a.r0.b.p.f.b.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048582, this, context, callbackHandler, str, aVar) == null) {
            c.a.r0.a.e0.d.i("recommend", "start real perform request");
            String v = c.a.r0.a.d0.c.v(r());
            c.a.r0.a.z2.g1.c<JSONObject> o = o(callbackHandler, str);
            ResponseCallback<JSONObject> p = p(o);
            MediaType parse = MediaType.parse("application/json");
            c.a.r0.a.e0.d.i("recommend", "encrypt request param");
            String a = c.a.r0.b.p.f.c.a.a(aVar.d());
            if (TextUtils.isEmpty(a)) {
                c.a.r0.a.e0.d.c("recommend", "encrypt request param fail");
                o.onCallback(null);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("info", "encrypt request param fail");
                } catch (JSONException e2) {
                    if (z.f6201b) {
                        e2.printStackTrace();
                    }
                }
                c.a.r0.b.p.f.c.a.f(jSONObject.toString());
                return;
            }
            c.a.r0.a.e0.d.i("recommend", "execute request");
            ((PostBodyRequest.PostBodyRequestBuilder) HttpManager.getDefault(context.getApplicationContext()).postRequest().url(v)).requestBody(RequestBody.create(parse, a)).build().executeAsync(p);
        }
    }
}
