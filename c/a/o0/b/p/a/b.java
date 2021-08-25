package c.a.o0.b.p.a;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.o0.a.e2.c.i;
import c.a.o0.a.e2.c.j.b;
import c.a.o0.a.k;
import c.a.o0.a.v2.v;
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
public class b extends c.a.o0.a.n1.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f10136e;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements c.a.o0.a.v2.e1.b<i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f10137e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f10138f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f10139g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.a.a2.e f10140h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ b f10141i;

        /* renamed from: c.a.o0.b.p.a.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0494a implements c.a.o0.a.v2.e1.b<String> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f10142e;

            public C0494a(a aVar) {
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
                this.f10142e = aVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // c.a.o0.a.v2.e1.b
            /* renamed from: a */
            public void onCallback(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    a aVar = this.f10142e;
                    aVar.f10141i.E(str, aVar.f10137e, aVar.f10138f, aVar.f10140h);
                }
            }
        }

        public a(b bVar, CallbackHandler callbackHandler, String str, String str2, c.a.o0.a.a2.e eVar) {
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
            this.f10141i = bVar;
            this.f10137e = callbackHandler;
            this.f10138f = str;
            this.f10139g = str2;
            this.f10140h = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.o0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (!c.a.o0.a.e2.c.d.h(iVar)) {
                    c.a.o0.a.e2.c.d.p(iVar, this.f10137e, this.f10138f);
                } else {
                    b.z(this.f10139g, new C0494a(this));
                }
            }
        }
    }

    /* renamed from: c.a.o0.b.p.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0495b implements c.a.o0.a.v2.e1.b<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f10143e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f10144f;

        public C0495b(b bVar, CallbackHandler callbackHandler, String str) {
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
            this.f10143e = callbackHandler;
            this.f10144f = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.o0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.f10143e.handleSchemeDispatchCallback(this.f10144f, str);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class c extends ResponseCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.a.v2.e1.b f10145a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Request f10146b;

        public c(c.a.o0.a.v2.e1.b bVar, Request request) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, request};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f10145a = bVar;
            this.f10146b = request;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
                this.f10145a.onCallback(b.A(exc == null ? "" : exc.getMessage()));
                c.a.o0.a.j2.q.a.b(SwanInterfaceType.REAL_NAME_CHECK, 2101, this.f10146b.url().toString(), null, exc != null ? exc.getMessage() : "");
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
                b.F(response, this.f10145a);
                return response;
            }
            return invokeLI.objValue;
        }
    }

    /* loaded from: classes.dex */
    public static class d implements c.a.o0.a.v2.e1.b<Bundle> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.a.v2.e1.b f10147e;

        public d(c.a.o0.a.v2.e1.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f10147e = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.o0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(Bundle bundle) {
            JSONObject wrapCallbackParams;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bundle) == null) {
                if (bundle == null) {
                    this.f10147e.onCallback(UnitedSchemeUtility.wrapCallbackParams(1001, "result is null").toString());
                    return;
                }
                String g2 = v.g(bundle, "callbackKey");
                if (TextUtils.isEmpty(g2)) {
                    this.f10147e.onCallback(UnitedSchemeUtility.wrapCallbackParams(1001, v.g(bundle, "failMsg")).toString());
                    return;
                }
                c.a.o0.a.e0.d.g("FaceVerifyAction", g2);
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("callbackKey", g2);
                    wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0);
                } catch (JSONException e2) {
                    if (b.f10136e) {
                        e2.printStackTrace();
                    }
                    wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(1001, "result JSONException");
                }
                this.f10147e.onCallback(wrapCallbackParams.toString());
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-906240357, "Lc/a/o0/b/p/a/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-906240357, "Lc/a/o0/b/p/a/b;");
                return;
            }
        }
        f10136e = k.f7049a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(c.a.o0.a.c2.e eVar) {
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
                super((c.a.o0.a.c2.e) objArr2[0], (String) objArr2[1]);
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
            c.a.o0.a.e0.d.g("FaceVerifyAction", str);
            return UnitedSchemeUtility.wrapCallbackParams(1001, str).toString();
        }
        return (String) invokeL.objValue;
    }

    public static String B(String str, int i2, String str2, Response response) {
        InterceptResult invokeLILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLILL = interceptable.invokeLILL(65539, null, str, i2, str2, response)) == null) {
            c.a.o0.a.j2.q.a.c(SwanInterfaceType.REAL_NAME_CHECK, i2, str2, response);
            return A(str);
        }
        return (String) invokeLILL.objValue;
    }

    public static void C(@NonNull Request request, c.a.o0.a.v2.e1.b<String> bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, request, bVar) == null) {
            c.a.o0.m.d.a aVar = new c.a.o0.m.d.a(request.url().toString(), request.body(), new c(bVar, request));
            aVar.f11820i = request.tag();
            aVar.f11817f = true;
            aVar.f11818g = true;
            aVar.f11819h = true;
            c.a.o0.m.e.a.g().e(aVar);
            c.a.o0.a.j2.q.a.a(SwanInterfaceType.REAL_NAME_CHECK);
        }
    }

    public static void D(String str, c.a.o0.a.a2.e eVar, c.a.o0.a.v2.e1.b<String> bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(AdIconUtil.AD_TEXT_ID, null, str, eVar, bVar) == null) {
            c.a.o0.b.l.a.K(eVar.x(), str, eVar.f4530f, new d(bVar));
        }
    }

    public static void F(Response response, c.a.o0.a.v2.e1.b<String> bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, response, bVar) == null) {
            String str = null;
            if (response == null) {
                bVar.onCallback(B("response is null", 2103, null, null));
            } else if (!response.isSuccessful()) {
                bVar.onCallback(B("response code is error", 2104, null, response));
            } else {
                ResponseBody body = response.body();
                if (body == null) {
                    bVar.onCallback(B("body is null", 2103, null, response));
                    return;
                }
                try {
                    str = body.string();
                } catch (IOException e2) {
                    if (f10136e) {
                        e2.printStackTrace();
                    }
                }
                if (f10136e) {
                    String str2 = "response body : " + str;
                }
                if (TextUtils.isEmpty(str)) {
                    bVar.onCallback(B("body is null", 2103, str, response));
                    return;
                }
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    int optInt = jSONObject.optInt("errno");
                    if (optInt != 0) {
                        bVar.onCallback(B(jSONObject.optString("errmsg"), optInt, str, response));
                        return;
                    }
                    JSONObject optJSONObject = jSONObject.optJSONObject("data");
                    if (optJSONObject == null) {
                        bVar.onCallback(A("server data is null"));
                    } else {
                        bVar.onCallback(String.valueOf(optJSONObject.optInt("real_name")));
                    }
                } catch (JSONException e3) {
                    if (f10136e) {
                        e3.printStackTrace();
                    }
                    bVar.onCallback(B("body format error", 2103, str, response));
                }
            }
        }
    }

    @Nullable
    public static Request y(@Nullable String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, str)) == null) {
            HttpUrl parse = HttpUrl.parse(c.a.o0.a.d0.c.f5112a);
            if (parse == null) {
                return null;
            }
            HttpUrl.Builder addPathSegments = parse.newBuilder().addPathSegments("ma/authentication/realnamecheck");
            for (Map.Entry<String, String> entry : c.a.o0.a.d0.b.b().f5111d.entrySet()) {
                addPathSegments.addQueryParameter(entry.getKey(), entry.getValue());
            }
            HttpUrl build = addPathSegments.build();
            Request.Builder builder = new Request.Builder();
            builder.tag(str);
            builder.post(new FormBody.Builder().build());
            builder.url(c.a.o0.a.d0.c.v(build.toString()));
            return builder.build();
        }
        return (Request) invokeL.objValue;
    }

    public static void z(String str, c.a.o0.a.v2.e1.b<String> bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65548, null, str, bVar) == null) {
            Request y = y(str);
            if (y == null) {
                bVar.onCallback(null);
            } else {
                C(y, bVar);
            }
        }
    }

    public final void E(String str, CallbackHandler callbackHandler, String str2, c.a.o0.a.a2.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048576, this, str, callbackHandler, str2, eVar) == null) {
            if (str == null) {
                callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(1001, "illegal request").toString());
            } else if (!TextUtils.equals(str, "1") && !TextUtils.equals(str, "0")) {
                callbackHandler.handleSchemeDispatchCallback(str2, str);
            } else {
                D(str, eVar, new C0495b(this, callbackHandler, str2));
            }
        }
    }

    @Override // c.a.o0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.o0.a.a2.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            if (eVar == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "runtime exception");
                return false;
            } else if (eVar.d0()) {
                boolean z = f10136e;
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
                String a2 = c.a.o0.a.u.e.j.h.a(eVar.f4530f);
                JSONObject n = n(a2);
                eVar.T().h(context, "mapp_i_face_verify", c.a.o0.a.e2.c.d.i(optParamsAsJo), new a(this, callbackHandler, optString, a2, eVar));
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(n, 0));
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }
}
