package b.a.p0.b.p.a;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import b.a.p0.a.k;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.browser.sailor.util.BdZeusUtil;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.statistic.interfacestability.SwanInterfaceType;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a extends b.a.p0.a.n1.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f9386e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b.a.p0.b.p.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0490a implements b.a.p0.a.v2.e1.b<Bundle> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f9387e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f9388f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f9389g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f9390h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.a2.e f9391i;
        public final /* synthetic */ a j;

        public C0490a(a aVar, String str, String str2, String str3, CallbackHandler callbackHandler, b.a.p0.a.a2.e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str, str2, str3, callbackHandler, eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.j = aVar;
            this.f9387e = str;
            this.f9388f = str2;
            this.f9389g = str3;
            this.f9390h = callbackHandler;
            this.f9391i = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bundle) == null) {
                if (bundle != null && !TextUtils.isEmpty(bundle.getString(BdZeusUtil.URL_KEY_MACHINE))) {
                    String string = bundle.getString(BdZeusUtil.URL_KEY_MACHINE);
                    if (a.f9386e) {
                        String str = "stoken=" + string;
                    }
                    this.j.z(this.f9387e, string, this.f9388f, this.f9389g, this.f9390h, this.f9391i);
                    return;
                }
                this.f9390h.handleSchemeDispatchCallback(this.f9389g, UnitedSchemeUtility.wrapCallbackParams(1001, "stoken is null").toString());
            }
        }
    }

    /* loaded from: classes.dex */
    public class b extends ResponseCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f9392a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f9393b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Request f9394c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ a f9395d;

        public b(a aVar, String str, CallbackHandler callbackHandler, Request request) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str, callbackHandler, request};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9395d = aVar;
            this.f9392a = str;
            this.f9393b = callbackHandler;
            this.f9394c = request;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
                this.f9395d.A(exc == null ? "" : exc.getMessage(), this.f9392a, this.f9393b);
                b.a.p0.a.j2.q.a.b(SwanInterfaceType.FACE_CHECK, 2101, this.f9394c.url().toString(), null, exc != null ? exc.getMessage() : "");
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
                this.f9395d.D(response, this.f9392a, this.f9393b);
                return response;
            }
            return invokeLI.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(84223740, "Lb/a/p0/b/p/a/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(84223740, "Lb/a/p0/b/p/a/a;");
                return;
            }
        }
        f9386e = k.f6397a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(b.a.p0.a.c2.e eVar) {
        super(eVar, "/swanAPI/faceResultVerify");
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
                super((b.a.p0.a.c2.e) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public final void A(String str, String str2, CallbackHandler callbackHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, str, str2, callbackHandler) == null) {
            b.a.p0.a.e0.d.g("FaceResultVerifyAction", str);
            callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(1001, str).toString());
        }
    }

    public final void B(String str, String str2, CallbackHandler callbackHandler, int i2, String str3, Response response) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, str2, callbackHandler, Integer.valueOf(i2), str3, response}) == null) {
            A(str, str2, callbackHandler);
            b.a.p0.a.j2.q.a.c(SwanInterfaceType.FACE_CHECK, i2, str3, response);
        }
    }

    public final void C(@NonNull Request request, String str, CallbackHandler callbackHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, request, str, callbackHandler) == null) {
            b.a.p0.m.d.a aVar = new b.a.p0.m.d.a(request.url().toString(), request.body(), new b(this, str, callbackHandler, request));
            aVar.f11041i = request.tag();
            aVar.f11038f = true;
            aVar.f11039g = true;
            aVar.f11040h = true;
            b.a.p0.m.e.a.g().e(aVar);
            b.a.p0.a.j2.q.a.a(SwanInterfaceType.FACE_CHECK);
        }
    }

    public final void D(Response response, String str, CallbackHandler callbackHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, response, str, callbackHandler) == null) {
            if (response == null) {
                B("response is null", str, callbackHandler, 2103, null, null);
            } else if (!response.isSuccessful()) {
                B("response code is error", str, callbackHandler, 2104, null, response);
            } else {
                ResponseBody body = response.body();
                if (body == null) {
                    B("body is null", str, callbackHandler, 2103, null, response);
                    return;
                }
                String str2 = null;
                try {
                    str2 = body.string();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
                String str3 = str2;
                if (f9386e) {
                    String str4 = "response body : " + str3;
                }
                if (TextUtils.isEmpty(str3)) {
                    B("body is null", str, callbackHandler, 2103, str3, response);
                    return;
                }
                try {
                    JSONObject jSONObject = new JSONObject(str3);
                    int optInt = jSONObject.optInt("errno");
                    if (optInt != 0) {
                        B(jSONObject.optString("errmsg"), str, callbackHandler, optInt, str3, response);
                        return;
                    }
                    JSONObject optJSONObject = jSONObject.optJSONObject("data");
                    if (optJSONObject == null) {
                        A("server data is null", str, callbackHandler);
                    } else {
                        callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(optJSONObject, 0).toString());
                    }
                } catch (JSONException e3) {
                    if (f9386e) {
                        e3.printStackTrace();
                    }
                    B("body format error", str, callbackHandler, 2103, str3, response);
                }
            }
        }
    }

    @Override // b.a.p0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, b.a.p0.a.a2.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048580, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            if (eVar == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "runtime exception");
                return false;
            }
            JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
            if (optParamsAsJo == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "params is empty");
                return false;
            }
            String optString = optParamsAsJo.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "callback is empty");
                return false;
            }
            String optString2 = optParamsAsJo.optString("callbackKey");
            if (TextUtils.isEmpty(optString2)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "callbackKey is empty");
                return false;
            } else if (!eVar.j().e(context)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(10004, "user not logged in");
                return false;
            } else {
                String a2 = b.a.p0.a.u.e.j.h.a(eVar.f3961f);
                JSONObject n = n(a2);
                b.a.p0.b.l.a.t(eVar.x(), new C0490a(this, optString2, a2, optString, callbackHandler, eVar), BdZeusUtil.URL_KEY_MACHINE);
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(n, 0));
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    @Nullable
    public final Request y(@Nullable String str, Map<String, String> map) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, map)) == null) {
            HttpUrl parse = HttpUrl.parse(b.a.p0.a.d0.c.f4519a);
            if (parse == null) {
                return null;
            }
            HttpUrl.Builder addPathSegments = parse.newBuilder().addPathSegments("ma/authentication/facecheck");
            for (Map.Entry<String, String> entry : b.a.p0.a.d0.b.b().f4518d.entrySet()) {
                addPathSegments.addQueryParameter(entry.getKey(), entry.getValue());
            }
            HttpUrl build = addPathSegments.build();
            Request.Builder builder = new Request.Builder();
            builder.tag(str);
            if (map != null) {
                builder.post(b.a.p0.a.e2.c.d.b(map));
            }
            builder.url(b.a.p0.a.d0.c.v(build.toString()));
            return builder.build();
        }
        return (Request) invokeLL.objValue;
    }

    public final void z(String str, String str2, String str3, String str4, CallbackHandler callbackHandler, b.a.p0.a.a2.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{str, str2, str3, str4, callbackHandler, eVar}) == null) {
            HashMap hashMap = new HashMap();
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject.put("callbackkey", str);
                jSONObject.put("client_id", eVar.f3961f);
                jSONObject2.put("stoken", str2);
                jSONObject2.put("app_key", eVar.k());
                jSONObject2.put("host_pkgname", b.a.p0.a.e2.c.d.e().getPackageName());
                jSONObject2.put("host_key_hash", b.a.p0.a.e2.c.d.g());
                jSONObject.put("open", jSONObject2);
            } catch (JSONException e2) {
                if (f9386e) {
                    e2.printStackTrace();
                }
            }
            hashMap.put("data", jSONObject.toString());
            Request y = y(str3, hashMap);
            if (y == null) {
                callbackHandler.handleSchemeDispatchCallback(str4, UnitedSchemeUtility.wrapCallbackParams(1001, "illegal request").toString());
            } else {
                C(y, str4, callbackHandler);
            }
        }
    }
}
