package c.a.p0.a.r;

import android.content.Context;
import android.text.TextUtils;
import c.a.p0.a.c2.f.a0;
import c.a.p0.a.k;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.dxmpay.wallet.paysdk.entrance.EnterDxmPayServiceAction;
import java.io.File;
import java.io.InputStream;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b extends c.a.p0.a.n1.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f8148e;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a extends ResponseCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f8149a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f8150b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b f8151c;

        public a(b bVar, String str, CallbackHandler callbackHandler) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, str, callbackHandler};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8151c = bVar;
            this.f8149a = str;
            this.f8150b = callbackHandler;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
                this.f8150b.handleSchemeDispatchCallback(this.f8149a, UnitedSchemeUtility.wrapCallbackParams(1001, "request IOException").toString());
                if (b.f8148e) {
                    String str = "response fail : " + UnitedSchemeUtility.wrapCallbackParams(1001, exc.getMessage()).toString();
                }
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
                this.f8151c.w(response, this.f8149a, this.f8150b);
                return response;
            }
            return invokeLI.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1358755251, "Lc/a/p0/a/r/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1358755251, "Lc/a/p0/a/r/b;");
                return;
            }
        }
        f8148e = k.f7085a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(c.a.p0.a.c2.e eVar) {
        super(eVar, "/swanAPI/aiRequest");
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
                super((c.a.p0.a.c2.e) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // c.a.p0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.p0.a.a2.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            if (eVar == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "swanApp is null");
                return false;
            }
            JSONObject a2 = a0.a(unitedSchemeEntity, "params");
            if (a2 == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal params");
                return false;
            }
            String param = unitedSchemeEntity.getParam("callback");
            if (TextUtils.isEmpty(param)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal callback");
                return false;
            }
            if (f8148e) {
                String str = "schema params : " + a2.toString();
                String str2 = "schema cb : " + param;
            }
            Request c2 = c.a.p0.a.r.a.c(eVar, a2, unitedSchemeEntity);
            if (c2 == null) {
                return false;
            }
            if (f8148e) {
                String str3 = "build request : " + c2.url().toString();
            }
            c.a.p0.a.r.a.p(c2.url().toString(), c2.body(), new a(this, param, callbackHandler));
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    public final void w(Response response, String str, CallbackHandler callbackHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, response, str, callbackHandler) == null) {
            try {
                String header = response.header("Content-Type", "");
                if (header != null && header.contains("application/json")) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put(EnterDxmPayServiceAction.SERVICE_STATUS_CODE, response.code());
                        jSONObject.put("header", c.a.p0.a.n1.a.s(response.headers()));
                        jSONObject.put("body", response.body().string());
                        callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString());
                        if (f8148e) {
                            String str2 = "response json : " + UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString();
                            return;
                        }
                        return;
                    } catch (JSONException unused) {
                        callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(1001, "response json error").toString());
                        return;
                    }
                }
                String n = c.a.p0.a.k2.b.n(c.a.p0.a.a2.e.V(), String.valueOf(System.currentTimeMillis()), "");
                if (TextUtils.isEmpty(n)) {
                    callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(1001, "bdfile error").toString());
                }
                String J = c.a.p0.a.k2.b.J(n, c.a.p0.a.a2.e.V());
                if (TextUtils.isEmpty(J)) {
                    callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(1001, "bdfile error").toString());
                }
                InputStream byteStream = response.body().byteStream();
                File file = new File(n);
                if (file.exists()) {
                    file.delete();
                    file.createNewFile();
                }
                if (c.a.p0.t.g.a(byteStream, file)) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("filePath", J);
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put(EnterDxmPayServiceAction.SERVICE_STATUS_CODE, response.code());
                    jSONObject3.put("header", c.a.p0.a.n1.a.s(response.headers()));
                    jSONObject3.put("body", jSONObject2.toString());
                    callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(jSONObject3, 0).toString());
                    if (f8148e) {
                        String str3 = "response file : " + UnitedSchemeUtility.wrapCallbackParams(jSONObject3, 0).toString();
                        return;
                    }
                    return;
                }
                callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(1001, "bdfile error").toString());
            } catch (Exception e2) {
                if (f8148e) {
                    e2.printStackTrace();
                }
                callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(201, e2.getMessage()).toString());
            }
        }
    }
}
