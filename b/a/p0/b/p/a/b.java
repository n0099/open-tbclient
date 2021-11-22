package b.a.p0.b.p.a;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.h2.c.i;
import b.a.p0.a.h2.c.j.b;
import b.a.p0.a.k;
import b.a.p0.a.u.e.i.j;
import b.a.p0.a.z2.v;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
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
import java.util.Map;
import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b extends b.a.p0.a.p1.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f9981e;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements b.a.p0.a.z2.g1.c<i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f9982e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f9983f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f9984g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.d2.e f9985h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ b f9986i;

        /* renamed from: b.a.p0.b.p.a.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0516a implements b.a.p0.a.z2.g1.c<String> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f9987e;

            public C0516a(a aVar) {
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
                        return;
                    }
                }
                this.f9987e = aVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // b.a.p0.a.z2.g1.c
            /* renamed from: a */
            public void onCallback(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    a aVar = this.f9987e;
                    aVar.f9986i.E(str, aVar.f9982e, aVar.f9983f, aVar.f9985h);
                }
            }
        }

        public a(b bVar, CallbackHandler callbackHandler, String str, String str2, b.a.p0.a.d2.e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, callbackHandler, str, str2, eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9986i = bVar;
            this.f9982e = callbackHandler;
            this.f9983f = str;
            this.f9984g = str2;
            this.f9985h = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (!b.a.p0.a.h2.c.d.h(iVar)) {
                    b.a.p0.a.h2.c.d.q(iVar, this.f9982e, this.f9983f);
                } else {
                    b.z(this.f9984g, new C0516a(this));
                }
            }
        }
    }

    /* renamed from: b.a.p0.b.p.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0517b implements b.a.p0.a.z2.g1.c<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f9988e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f9989f;

        public C0517b(b bVar, CallbackHandler callbackHandler, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, callbackHandler, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9988e = callbackHandler;
            this.f9989f = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.f9988e.handleSchemeDispatchCallback(this.f9989f, str);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class c extends ResponseCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.z2.g1.c f9990a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Request f9991b;

        public c(b.a.p0.a.z2.g1.c cVar, Request request) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, request};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9990a = cVar;
            this.f9991b = request;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
                this.f9990a.onCallback(b.A(exc == null ? "" : exc.getMessage()));
                b.a.p0.a.n2.t.a.b(SwanInterfaceType.REAL_NAME_CHECK, 2101, this.f9991b.url().toString(), null, exc != null ? exc.getMessage() : "");
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
                b.F(response, this.f9990a);
                return response;
            }
            return invokeLI.objValue;
        }
    }

    /* loaded from: classes.dex */
    public static class d implements b.a.p0.a.z2.g1.c<Bundle> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.z2.g1.c f9992e;

        public d(b.a.p0.a.z2.g1.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9992e = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(Bundle bundle) {
            JSONObject wrapCallbackParams;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bundle) == null) {
                if (bundle == null) {
                    this.f9992e.onCallback(UnitedSchemeUtility.wrapCallbackParams(1001, "result is null").toString());
                    return;
                }
                String g2 = v.g(bundle, "callbackKey");
                if (TextUtils.isEmpty(g2)) {
                    this.f9992e.onCallback(UnitedSchemeUtility.wrapCallbackParams(1001, v.g(bundle, "failMsg")).toString());
                    return;
                }
                b.a.p0.a.e0.d.i("FaceVerifyAction", g2);
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("callbackKey", g2);
                    wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0);
                } catch (JSONException e2) {
                    if (b.f9981e) {
                        e2.printStackTrace();
                    }
                    wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(1001, "result JSONException");
                }
                this.f9992e.onCallback(wrapCallbackParams.toString());
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(84223771, "Lb/a/p0/b/p/a/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(84223771, "Lb/a/p0/b/p/a/b;");
                return;
            }
        }
        f9981e = k.f6863a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(b.a.p0.a.f2.e eVar) {
        super(eVar, "/swanAPI/faceVerify");
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
                super((b.a.p0.a.f2.e) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public static String A(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            b.a.p0.a.e0.d.i("FaceVerifyAction", str);
            return UnitedSchemeUtility.wrapCallbackParams(1001, str).toString();
        }
        return (String) invokeL.objValue;
    }

    public static String B(String str, int i2, String str2, Response response) {
        InterceptResult invokeLILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLILL = interceptable.invokeLILL(65539, null, str, i2, str2, response)) == null) {
            b.a.p0.a.n2.t.a.c(SwanInterfaceType.REAL_NAME_CHECK, i2, str2, response);
            return A(str);
        }
        return (String) invokeLILL.objValue;
    }

    public static void C(@NonNull Request request, b.a.p0.a.z2.g1.c<String> cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, request, cVar) == null) {
            b.a.p0.p.d.a aVar = new b.a.p0.p.d.a(request.url().toString(), request.body(), new c(cVar, request));
            aVar.f11728i = request.tag();
            aVar.f11725f = true;
            aVar.f11726g = true;
            aVar.f11727h = true;
            b.a.p0.p.e.a.g().e(aVar);
            b.a.p0.a.n2.t.a.a(SwanInterfaceType.REAL_NAME_CHECK);
        }
    }

    public static void D(String str, b.a.p0.a.d2.e eVar, b.a.p0.a.z2.g1.c<String> cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(AdIconUtil.AD_TEXT_ID, null, str, eVar, cVar) == null) {
            b.a.p0.b.l.a.J(eVar.x(), str, eVar.f4474f, new d(cVar));
        }
    }

    public static void F(Response response, b.a.p0.a.z2.g1.c<String> cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, response, cVar) == null) {
            String str = null;
            if (response == null) {
                cVar.onCallback(B("response is null", 2103, null, null));
            } else if (!response.isSuccessful()) {
                cVar.onCallback(B("response code is error", 2104, null, response));
            } else {
                ResponseBody body = response.body();
                if (body == null) {
                    cVar.onCallback(B("body is null", 2103, null, response));
                    return;
                }
                try {
                    str = body.string();
                } catch (IOException e2) {
                    if (f9981e) {
                        e2.printStackTrace();
                    }
                }
                if (f9981e) {
                    String str2 = "response body : " + str;
                }
                if (TextUtils.isEmpty(str)) {
                    cVar.onCallback(B("body is null", 2103, str, response));
                    return;
                }
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    int optInt = jSONObject.optInt("errno");
                    if (optInt != 0) {
                        cVar.onCallback(B(jSONObject.optString("errmsg"), optInt, str, response));
                        return;
                    }
                    JSONObject optJSONObject = jSONObject.optJSONObject("data");
                    if (optJSONObject == null) {
                        cVar.onCallback(A("server data is null"));
                    } else {
                        cVar.onCallback(String.valueOf(optJSONObject.optInt("real_name")));
                    }
                } catch (JSONException e3) {
                    if (f9981e) {
                        e3.printStackTrace();
                    }
                    cVar.onCallback(B("body format error", 2103, str, response));
                }
            }
        }
    }

    @Nullable
    public static Request y(@Nullable String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, str)) == null) {
            HttpUrl parse = HttpUrl.parse(b.a.p0.a.d0.c.f4448a);
            if (parse == null) {
                return null;
            }
            HttpUrl.Builder addPathSegments = parse.newBuilder().addPathSegments("ma/authentication/realnamecheck");
            for (Map.Entry<String, String> entry : b.a.p0.a.d0.b.b().f4447d.entrySet()) {
                addPathSegments.addQueryParameter(entry.getKey(), entry.getValue());
            }
            HttpUrl build = addPathSegments.build();
            Request.Builder builder = new Request.Builder();
            builder.tag(str);
            builder.post(new FormBody.Builder().build());
            builder.url(b.a.p0.a.d0.c.v(build.toString()));
            return builder.build();
        }
        return (Request) invokeL.objValue;
    }

    public static void z(String str, b.a.p0.a.z2.g1.c<String> cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65548, null, str, cVar) == null) {
            Request y = y(str);
            if (y == null) {
                cVar.onCallback(null);
            } else {
                C(y, cVar);
            }
        }
    }

    public final void E(String str, CallbackHandler callbackHandler, String str2, b.a.p0.a.d2.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048576, this, str, callbackHandler, str2, eVar) == null) {
            if (str == null) {
                callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(1001, "illegal request").toString());
            } else if (!TextUtils.equals(str, "1") && !TextUtils.equals(str, "0")) {
                callbackHandler.handleSchemeDispatchCallback(str2, str);
            } else {
                D(str, eVar, new C0517b(this, callbackHandler, str2));
            }
        }
    }

    @Override // b.a.p0.a.f2.f.z
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, b.a.p0.a.d2.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            if (eVar == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "runtime exception");
                return false;
            } else if (eVar.m0()) {
                boolean z = f9981e;
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "this operation does not supported when app is invisible.");
                return false;
            } else {
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
                String a2 = j.a(eVar.f4474f);
                JSONObject n = n(a2);
                eVar.d0().h(context, "mapp_i_face_verify", b.a.p0.a.h2.c.d.j(optParamsAsJo), new a(this, callbackHandler, optString, a2, eVar));
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(n, 0));
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }
}
