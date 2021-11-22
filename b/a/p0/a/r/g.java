package b.a.p0.a.r;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.collection.ArrayMap;
import b.a.p0.a.f2.f.z;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.Iterator;
import java.util.Map;
import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class g extends c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a extends ResponseCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f7959a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f7960b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ h f7961c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ g f7962d;

        public a(g gVar, CallbackHandler callbackHandler, String str, h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, callbackHandler, str, hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7962d = gVar;
            this.f7959a = callbackHandler;
            this.f7960b = str;
            this.f7961c = hVar;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
                this.f7959a.handleSchemeDispatchCallback(this.f7960b, UnitedSchemeUtility.wrapCallbackParams(1001, exc.getMessage()).toString());
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(Object obj, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj, i2) == null) {
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public Object parseResponse(Response response, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, response, i2)) == null) {
                this.f7962d.r(response, this.f7959a, this.f7960b, this.f7961c);
                return response;
            }
            return invokeLI.objValue;
        }
    }

    /* loaded from: classes.dex */
    public class b extends ResponseCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f7963a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f7964b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f7965c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ g f7966d;

        public b(g gVar, CallbackHandler callbackHandler, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, callbackHandler, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7966d = gVar;
            this.f7963a = callbackHandler;
            this.f7964b = str;
            this.f7965c = str2;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
                boolean z = c.f7951c;
                g gVar = this.f7966d;
                CallbackHandler callbackHandler = this.f7963a;
                String str = this.f7964b;
                gVar.s(callbackHandler, str, null, "uploadFile:fail" + exc.getMessage());
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(Object obj, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj, i2) == null) {
                this.f7963a.handleSchemeDispatchCallback(this.f7964b, UnitedSchemeUtility.wrapCallbackParams(b.a.p0.a.r.a.n(this.f7965c, null, "uploadFile:ok"), 0).toString());
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public Object parseResponse(Response response, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, response, i2)) == null) ? response : invokeLI.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(b.a.p0.a.f2.e eVar) {
        super(eVar, "/swanAPI/cloudUploadFile");
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
                super((b.a.p0.a.f2.e) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // b.a.p0.a.r.c, b.a.p0.a.f2.f.z
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, b.a.p0.a.d2.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            if (eVar == null) {
                return l(unitedSchemeEntity, 1001, "swanApp is null");
            }
            JSONObject a2 = z.a(unitedSchemeEntity, "params");
            if (a2 == null) {
                return l(unitedSchemeEntity, 202, "illegal params");
            }
            String param = unitedSchemeEntity.getParam("callback");
            if (TextUtils.isEmpty(param)) {
                return l(unitedSchemeEntity, 202, "illegal callback");
            }
            String optString = a2.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                return l(unitedSchemeEntity, 202, "illegal cb");
            }
            if (c.f7951c) {
                String str = "schema params : " + a2.toString();
                String str2 = "schema cb : " + optString;
            }
            h p = p(a2);
            if (p == null) {
                l(unitedSchemeEntity, 202, "illegal params");
                return false;
            }
            Request c2 = b.a.p0.a.r.a.c(eVar, a2, unitedSchemeEntity);
            if (c2 != null) {
                callbackHandler.handleSchemeDispatchCallback(param, UnitedSchemeUtility.wrapCallbackParams(0).toString());
                b.a.p0.a.r.a.p(c2.url().toString(), c2.body(), new a(this, callbackHandler, optString, p));
                return true;
            }
            callbackHandler.handleSchemeDispatchCallback(param, unitedSchemeEntity.result.toString());
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    @Override // b.a.p0.a.r.c
    public void j(Response response, CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, response, callbackHandler, str) == null) {
        }
    }

    public h p(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("fileMap");
            JSONObject optJSONObject2 = jSONObject.optJSONObject("stringMap");
            if (optJSONObject == null || optJSONObject2 == null) {
                return null;
            }
            String optString = optJSONObject2.optString("cloudPath");
            if (TextUtils.isEmpty(optString) || optString.startsWith("/") || optString.contains("@")) {
                return null;
            }
            Iterator<String> keys = optJSONObject.keys();
            while (keys.hasNext()) {
                String M = b.a.p0.a.o2.b.M(optJSONObject.optString(keys.next()), b.a.p0.a.d2.e.f0());
                if (M != null && !TextUtils.isEmpty(M)) {
                    File file = new File(M);
                    if (file.exists()) {
                        h hVar = new h(file);
                        u(jSONObject, hVar.contentLength());
                        return hVar;
                    }
                }
            }
            return null;
        }
        return (h) invokeL.objValue;
    }

    public final int q(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            try {
                return Integer.parseInt(str);
            } catch (NumberFormatException e2) {
                if (c.f7951c) {
                    e2.printStackTrace();
                }
                return 1001;
            }
        }
        return invokeL.intValue;
    }

    public final void r(Response response, CallbackHandler callbackHandler, String str, RequestBody requestBody) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048580, this, response, callbackHandler, str, requestBody) == null) {
            if (!response.isSuccessful()) {
                s(callbackHandler, str, null, null);
                return;
            }
            String header = response.header("Content-Type", "");
            if (header != null && header.contains("application/json")) {
                JSONObject m = b.a.p0.a.r.a.m(response);
                if (m != null && response.isSuccessful()) {
                    String optString = m.optString("errno", String.valueOf(0));
                    String optString2 = m.optString("errmsg");
                    if (b.a.p0.a.r.a.o(optString)) {
                        s(callbackHandler, str, optString, optString2);
                        return;
                    }
                    String optString3 = m.optString("UploadUrl");
                    String optString4 = m.optString("fileID");
                    if (!TextUtils.isEmpty(optString3) && !TextUtils.isEmpty(optString4)) {
                        JSONObject optJSONObject = m.optJSONObject("ExtraHeaders");
                        if (optJSONObject == null) {
                            s(callbackHandler, str, optString, optString2);
                            return;
                        }
                        Map<String, String> t = t(optJSONObject);
                        try {
                            Request build = new Request.Builder().headers(Headers.of(t)).url(optString3).put(requestBody).build();
                            if (b.a.p0.a.d2.e.L() == null) {
                                k(callbackHandler, str, 1001, "uploadFile:fail");
                                return;
                            }
                            b.a.p0.p.d.a aVar = new b.a.p0.p.d.a(build.url().toString(), build.body(), new b(this, callbackHandler, str, optString4));
                            aVar.f11722c = t;
                            aVar.f11725f = true;
                            aVar.f11726g = false;
                            aVar.f11727h = true;
                            b.a.p0.p.e.a.g().f(aVar);
                            return;
                        } catch (Exception e2) {
                            if (c.f7951c) {
                                e2.printStackTrace();
                            }
                            s(callbackHandler, str, optString, optString2);
                            return;
                        }
                    }
                    s(callbackHandler, str, optString, optString2);
                    return;
                }
                k(callbackHandler, str, 1001, "uploadFile:fail");
                return;
            }
            k(callbackHandler, str, 1001, "uploadFile:fail");
        }
    }

    public final void s(CallbackHandler callbackHandler, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048581, this, callbackHandler, str, str2, str3) == null) {
            if (TextUtils.isEmpty(str2)) {
                k(callbackHandler, str, 1001, "uploadFile:fail");
            } else {
                k(callbackHandler, str, q(str2), b.a.p0.a.r.a.k(str3));
            }
        }
    }

    @NonNull
    public final Map<String, String> t(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, jSONObject)) == null) {
            ArrayMap arrayMap = new ArrayMap();
            if (jSONObject == null) {
                return arrayMap;
            }
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                arrayMap.put(next, jSONObject.optString(next));
            }
            return arrayMap;
        }
        return (Map) invokeL.objValue;
    }

    public final void u(JSONObject jSONObject, long j) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLJ(1048583, this, jSONObject, j) == null) || jSONObject == null) {
            return;
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("stringMap");
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject3.put("Content-Length", String.valueOf(j));
            jSONObject2.put("Headers", jSONObject3);
            if (optJSONObject != null) {
                optJSONObject.put("data", jSONObject2);
                jSONObject.put("stringMap", optJSONObject);
            }
        } catch (JSONException e2) {
            if (c.f7951c) {
                e2.printStackTrace();
            }
        }
    }
}
