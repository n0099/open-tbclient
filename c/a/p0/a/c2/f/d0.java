package c.a.p0.a.c2.f;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.chatmessage.request.IMAudioTransRequest;
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
import com.dxmpay.wallet.paysdk.entrance.EnterDxmPayServiceAction;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import okhttp3.HttpUrl;
import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d0 extends c.a.p0.a.n1.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f4777e;

    /* loaded from: classes.dex */
    public class a extends ResponseCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f4778a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f4779b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f4780c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f4781d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f4782e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d0 f4783f;

        public a(d0 d0Var, CallbackHandler callbackHandler, String str, String str2, String str3, String str4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d0Var, callbackHandler, str, str2, str3, str4};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4783f = d0Var;
            this.f4778a = callbackHandler;
            this.f4779b = str;
            this.f4780c = str2;
            this.f4781d = str3;
            this.f4782e = str4;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
                c.a.p0.a.g1.f.V().S();
                this.f4778a.handleSchemeDispatchCallback(this.f4780c, UnitedSchemeUtility.wrapCallbackParams(1001, exc.getMessage()).toString());
                this.f4783f.q(this.f4782e);
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(Object obj, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj, i2) == null) {
                c.a.p0.a.g1.f.V().S();
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public Object parseResponse(Response response, int i2) throws Exception {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, response, i2)) == null) {
                this.f4783f.z(response, this.f4778a, this.f4779b, this.f4780c, this.f4781d, this.f4782e);
                return response;
            }
            return invokeLI.objValue;
        }
    }

    /* loaded from: classes.dex */
    public class b implements c.a.p0.a.n1.p.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ long f4784a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f4785b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f4786c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f4787d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d0 f4788e;

        public b(d0 d0Var, long j2, String str, String str2, CallbackHandler callbackHandler) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d0Var, Long.valueOf(j2), str, str2, callbackHandler};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4788e = d0Var;
            this.f4784a = j2;
            this.f4785b = str;
            this.f4786c = str2;
            this.f4787d = callbackHandler;
        }

        @Override // c.a.p0.a.n1.p.a
        public void a(long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048576, this, j2) == null) {
                this.f4788e.x(this.f4784a, j2, this.f4785b, this.f4786c, this.f4787d);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d0(c.a.p0.a.c2.e eVar) {
        super(eVar, "/swanAPI/uploadFile");
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
        this.f4777e = 0;
    }

    public static void A(MultipartBody.Builder builder, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65537, null, builder, jSONObject) == null) || builder == null || jSONObject == null || jSONObject.length() < 1) {
            return;
        }
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            if (!TextUtils.isEmpty(next)) {
                String optString = jSONObject.optString(next);
                if (!TextUtils.isEmpty(optString)) {
                    builder.addFormDataPart(next, optString);
                }
            }
        }
    }

    public final void B(MultipartBody.Builder builder, String str, String str2, c.a.p0.a.n1.c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048576, this, builder, str, str2, cVar) == null) || builder == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || cVar == null) {
            return;
        }
        builder.addFormDataPart(str, str2, cVar);
    }

    @Override // c.a.p0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.p0.a.a2.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            if (eVar == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "swanApp is null");
                return false;
            }
            JSONObject a2 = a0.a(unitedSchemeEntity, "params");
            if (a2 == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal params");
                return false;
            }
            String optString = a2.optString("onProgressUpdate");
            String optString2 = a2.optString("headersReceivedEvent");
            String optString3 = a2.optString("cb");
            if (TextUtils.isEmpty(optString3)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal resultCallback");
                return false;
            }
            String V = c.a.p0.a.a2.e.V();
            if (TextUtils.isEmpty(V)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal appId");
                return false;
            }
            String a3 = c.a.p0.a.u.e.j.h.a(V);
            String valueOf = String.valueOf(System.currentTimeMillis());
            Request w = w(a2, optString, a3, valueOf, eVar, callbackHandler);
            if (w == null) {
                unitedSchemeEntity.result = t(this.f4777e);
                q(valueOf);
                return false;
            }
            JSONObject optJSONObject = a2.optJSONObject("header");
            c.a.p0.a.n1.o.b bVar = new c.a.p0.a.n1.o.b();
            HashMap<String, String> m = c.a.p0.a.n1.a.m(optJSONObject, true);
            String optString4 = a2.optString("__plugin__");
            if (!TextUtils.isEmpty(optString4)) {
                c.a.p0.n.h.h h2 = c.a.p0.a.t1.g.b.h(optString4);
                if (m == null) {
                    m = new HashMap<>();
                }
                m.put("X-SWAN-HOSTSIGN", c.a.p0.a.t1.g.a.b(h2));
            }
            HashMap<String, String> hashMap = m;
            hashMap.putAll(c.a.p0.a.n1.o.c.a("uploadFile", a2.optString("__plugin__")));
            bVar.a(hashMap);
            c.a.p0.a.g1.f.V().b0();
            c.a.p0.m.d.a aVar = new c.a.p0.m.d.a(w.url().toString(), w.body(), new a(this, callbackHandler, optString, optString3, optString2, valueOf));
            aVar.f11850c = hashMap;
            aVar.f11856i = w.tag();
            aVar.f11853f = true;
            aVar.f11854g = false;
            aVar.f11855h = true;
            aVar.k = 2;
            c.a.p0.m.e.a.g().e(aVar);
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(n(a3), 0));
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:48:0x00e1, code lost:
        if (android.text.TextUtils.isEmpty(r0) == false) goto L48;
     */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Request w(@Nullable JSONObject jSONObject, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable c.a.p0.a.a2.e eVar, @Nullable CallbackHandler callbackHandler) {
        InterceptResult invokeCommon;
        HttpUrl f2;
        String str4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{jSONObject, str, str2, str3, eVar, callbackHandler})) == null) {
            if (jSONObject == null || (f2 = c.a.p0.a.u.e.j.h.f(jSONObject.optString("url"))) == null) {
                return null;
            }
            String httpUrl = f2.toString();
            if (TextUtils.isEmpty(httpUrl)) {
                return null;
            }
            int c2 = c.a.p0.a.b2.a.b.c("uploadFile", httpUrl, jSONObject.optString("__plugin__"));
            this.f4777e = c2;
            if (c2 != 0) {
                return null;
            }
            String optString = jSONObject.optString("filePath", "");
            if (TextUtils.isEmpty(optString) || c.a.p0.t.d.w(optString)) {
                return null;
            }
            String a2 = c.a.p0.a.g1.f.V().I().a(optString);
            if (TextUtils.isEmpty(a2)) {
                return null;
            }
            File file = new File(a2);
            if (file.exists() && file.isFile()) {
                long length = file.length();
                if (length > 524288000) {
                    if (a0.f4774b) {
                        String str5 = "file over size: " + (length / 1048576) + " MB.";
                    }
                    this.f4777e = 5;
                    return null;
                }
                String optString2 = jSONObject.optString("name", "");
                if (TextUtils.isEmpty(optString2)) {
                    return null;
                }
                if (!jSONObject.has("formData") || (jSONObject.opt("formData") instanceof JSONObject)) {
                    JSONObject optJSONObject = jSONObject.optJSONObject("formData");
                    this.f7582c.put(str3, 0L);
                    String name = file.getName();
                    if (!TextUtils.isEmpty(name)) {
                        str4 = c.a.p0.a.v2.s.d(c.a.p0.a.v2.s.b(name));
                    }
                    str4 = IMAudioTransRequest.CONTENT_TYPE;
                    c.a.p0.a.n1.c cVar = new c.a.p0.a.n1.c(file, str4, new b(this, length, str, str3, callbackHandler));
                    MultipartBody.Builder type = new MultipartBody.Builder().setType(MultipartBody.FORM);
                    A(type, optJSONObject);
                    B(type, optString2, file.getName(), cVar);
                    return new Request.Builder().url(httpUrl).tag(str2).post(type.build()).build();
                }
                return null;
            }
            return null;
        }
        return (Request) invokeCommon.objValue;
    }

    public final void x(long j2, long j3, String str, String str2, CallbackHandler callbackHandler) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3), str, str2, callbackHandler}) == null) || j2 <= 0 || j3 > j2 || j3 == 0 || TextUtils.isEmpty(str) || callbackHandler == null) {
            return;
        }
        int floor = (int) Math.floor((100 * j3) / j2);
        if (System.currentTimeMillis() - p(str2) > 500 || floor == 100) {
            if (floor <= 100) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("progress", floor);
                    jSONObject.put("totalBytesSent", j3);
                    jSONObject.put("totalBytesExpectedToSend", j2);
                    callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParamsWithEncode(jSONObject, 0).toString());
                } catch (Exception e2) {
                    if (a0.f4774b) {
                        e2.printStackTrace();
                    }
                }
            }
            this.f7582c.put(str2, Long.valueOf(System.currentTimeMillis()));
        }
    }

    public final void y(@NonNull JSONObject jSONObject, @Nullable ResponseBody responseBody) throws IOException, JSONException {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, jSONObject, responseBody) == null) || responseBody == null) {
            return;
        }
        String string = responseBody.string();
        if (TextUtils.isEmpty(string)) {
            return;
        }
        try {
            jSONObject.put("data", new JSONObject(string));
        } catch (JSONException unused) {
            jSONObject.put("data", string);
        }
    }

    public final void z(Response response, CallbackHandler callbackHandler, String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{response, callbackHandler, str, str2, str3, str4}) == null) {
            try {
                try {
                    r(str3, response.headers());
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(EnterDxmPayServiceAction.SERVICE_STATUS_CODE, response.code());
                    y(jSONObject, response.body());
                    if (jSONObject.toString().length() > 26214400) {
                        callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(201, "response json length over limits").toString());
                    } else {
                        callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParamsWithEncode(jSONObject, 0).toString());
                    }
                } catch (Exception e2) {
                    if (a0.f4774b) {
                        e2.printStackTrace();
                    }
                    callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(201, e2.getMessage()).toString());
                }
            } finally {
                q(str4);
            }
        }
    }
}
