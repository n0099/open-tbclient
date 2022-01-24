package c.a.r0.a.f2.f;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.chatmessage.request.IMAudioTransRequest;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.launch.stats.SpeedStatsStampTable;
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
public class c0 extends c.a.r0.a.p1.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f5998e;

    /* loaded from: classes.dex */
    public class a extends ResponseCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f5999b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f6000c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f6001d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f6002e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c0 f6003f;

        public a(c0 c0Var, CallbackHandler callbackHandler, String str, String str2, String str3, String str4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c0Var, callbackHandler, str, str2, str3, str4};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6003f = c0Var;
            this.a = callbackHandler;
            this.f5999b = str;
            this.f6000c = str2;
            this.f6001d = str3;
            this.f6002e = str4;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
                c.a.r0.a.n2.u.a.b("uploadFile", SpeedStatsStampTable.NEW_LOGO_ACTIVITY_END_STAMP_KEY, exc.getMessage(), 1001, exc.getMessage());
                c.a.r0.a.g1.f.U().R();
                this.a.handleSchemeDispatchCallback(this.f6000c, UnitedSchemeUtility.wrapCallbackParams(1001, exc.getMessage()).toString());
                this.f6003f.q(this.f6002e);
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(Object obj, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj, i2) == null) {
                c.a.r0.a.g1.f.U().R();
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public Object parseResponse(Response response, int i2) throws Exception {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, response, i2)) == null) {
                this.f6003f.z(response, this.a, this.f5999b, this.f6000c, this.f6001d, this.f6002e);
                return response;
            }
            return invokeLI.objValue;
        }
    }

    /* loaded from: classes.dex */
    public class b implements c.a.r0.a.p1.p.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ long a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f6004b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f6005c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f6006d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c0 f6007e;

        public b(c0 c0Var, long j2, String str, String str2, CallbackHandler callbackHandler) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c0Var, Long.valueOf(j2), str, str2, callbackHandler};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6007e = c0Var;
            this.a = j2;
            this.f6004b = str;
            this.f6005c = str2;
            this.f6006d = callbackHandler;
        }

        @Override // c.a.r0.a.p1.p.a
        public void a(long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048576, this, j2) == null) {
                this.f6007e.x(this.a, j2, this.f6004b, this.f6005c, this.f6006d);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c0(c.a.r0.a.f2.e eVar) {
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
                super((c.a.r0.a.f2.e) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f5998e = 0;
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

    public final void B(MultipartBody.Builder builder, String str, String str2, c.a.r0.a.p1.c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048576, this, builder, str, str2, cVar) == null) || builder == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || cVar == null) {
            return;
        }
        builder.addFormDataPart(str, str2, cVar);
    }

    @Override // c.a.r0.a.f2.f.z
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.r0.a.d2.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            if (eVar == null) {
                c.a.r0.a.n2.u.a.b("uploadFile", 2001, "swanApp is null", 1001, "swanApp is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "swanApp is null");
                return false;
            }
            JSONObject a2 = z.a(unitedSchemeEntity, "params");
            if (a2 == null) {
                c.a.r0.a.n2.u.a.b("uploadFile", 1001, "illegal params", 202, "illegal params");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal params");
                return false;
            }
            String optString = a2.optString("onProgressUpdate");
            String optString2 = a2.optString("headersReceivedEvent");
            String optString3 = a2.optString("cb");
            if (TextUtils.isEmpty(optString3)) {
                c.a.r0.a.n2.u.a.b("uploadFile", 1001, "illegal resultCallback", 202, "illegal resultCallback");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal resultCallback");
                return false;
            }
            String f0 = c.a.r0.a.d2.e.f0();
            if (TextUtils.isEmpty(f0)) {
                c.a.r0.a.n2.u.a.b("uploadFile", 1001, "illegal appId", 202, "illegal appId");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal appId");
                return false;
            }
            String a3 = c.a.r0.a.u.e.i.j.a(f0);
            String valueOf = String.valueOf(System.currentTimeMillis());
            Request w = w(a2, optString, a3, valueOf, eVar, callbackHandler);
            if (w == null) {
                c.a.r0.a.n2.u.a.b("uploadFile", 1001, "params is invalid, build request fail", -1, "");
                unitedSchemeEntity.result = t(this.f5998e);
                q(valueOf);
                return false;
            }
            JSONObject optJSONObject = a2.optJSONObject("header");
            c.a.r0.a.p1.o.b bVar = new c.a.r0.a.p1.o.b();
            HashMap<String, String> m = c.a.r0.a.p1.a.m(optJSONObject, true);
            String optString4 = a2.optString("__plugin__");
            if (!TextUtils.isEmpty(optString4)) {
                c.a.r0.q.i.i h2 = c.a.r0.a.w1.h.b.h(optString4);
                if (m == null) {
                    m = new HashMap<>();
                }
                m.put("X-SWAN-HOSTSIGN", c.a.r0.a.w1.h.a.b(h2));
            }
            HashMap<String, String> hashMap = m;
            hashMap.putAll(c.a.r0.a.p1.o.c.a("uploadFile", a2.optString("__plugin__")));
            bVar.a(hashMap);
            c.a.r0.a.g1.f.U().a0();
            c.a.r0.p.d.a aVar = new c.a.r0.p.d.a(w.url().toString(), w.body(), new a(this, callbackHandler, optString, optString3, optString2, valueOf));
            aVar.f11592c = hashMap;
            aVar.f11598i = w.tag();
            aVar.f11595f = true;
            aVar.f11596g = false;
            aVar.f11597h = true;
            aVar.k = 2;
            c.a.r0.p.e.a.g().e(aVar);
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
    public final Request w(@Nullable JSONObject jSONObject, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable c.a.r0.a.d2.e eVar, @Nullable CallbackHandler callbackHandler) {
        InterceptResult invokeCommon;
        HttpUrl f2;
        String str4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{jSONObject, str, str2, str3, eVar, callbackHandler})) == null) {
            if (jSONObject == null || (f2 = c.a.r0.a.u.e.i.j.f(jSONObject.optString("url"))) == null) {
                return null;
            }
            String httpUrl = f2.toString();
            if (TextUtils.isEmpty(httpUrl)) {
                return null;
            }
            int c2 = c.a.r0.a.e2.a.b.c("uploadFile", httpUrl, jSONObject.optString("__plugin__"));
            this.f5998e = c2;
            if (c2 != 0) {
                return null;
            }
            String optString = jSONObject.optString("filePath", "");
            if (TextUtils.isEmpty(optString) || c.a.r0.w.d.x(optString)) {
                return null;
            }
            String a2 = c.a.r0.a.g1.f.U().G().a(optString);
            if (TextUtils.isEmpty(a2)) {
                return null;
            }
            File file = new File(a2);
            if (file.exists() && file.isFile()) {
                long length = file.length();
                if (length > 524288000) {
                    if (z.f6343b) {
                        String str5 = "file over size: " + (length / 1048576) + " MB.";
                    }
                    this.f5998e = 5;
                    return null;
                }
                String optString2 = jSONObject.optString("name", "");
                if (TextUtils.isEmpty(optString2)) {
                    return null;
                }
                if (!jSONObject.has("formData") || (jSONObject.opt("formData") instanceof JSONObject)) {
                    JSONObject optJSONObject = jSONObject.optJSONObject("formData");
                    this.f8403c.put(str3, 0L);
                    String name = file.getName();
                    if (!TextUtils.isEmpty(name)) {
                        str4 = c.a.r0.a.z2.s.d(c.a.r0.a.z2.s.b(name));
                    }
                    str4 = IMAudioTransRequest.CONTENT_TYPE;
                    c.a.r0.a.p1.c cVar = new c.a.r0.a.p1.c(file, str4, new b(this, length, str, str3, callbackHandler));
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
                    if (z.f6343b) {
                        e2.printStackTrace();
                    }
                }
            }
            this.f8403c.put(str2, Long.valueOf(System.currentTimeMillis()));
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
                    r(str3, c.a.r0.a.p1.a.s(response.headers()));
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(EnterDxmPayServiceAction.SERVICE_STATUS_CODE, response.code());
                    y(jSONObject, response.body());
                    if (jSONObject.toString().length() > 26214400) {
                        c.a.r0.a.n2.u.a.b("uploadFile", 3002, "response json length over limits", 1001, "response json length over limits");
                        callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(201, "response json length over limits").toString());
                    } else {
                        callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParamsWithEncode(jSONObject, 0).toString());
                    }
                } catch (Exception e2) {
                    if (z.f6343b) {
                        e2.printStackTrace();
                    }
                    c.a.r0.a.n2.u.a.b("uploadFile", 2009, "json exception", 1001, e2.getMessage());
                    callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(201, e2.getMessage()).toString());
                }
            } finally {
                q(str4);
            }
        }
    }
}
