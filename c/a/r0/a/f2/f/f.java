package c.a.r0.a.f2.f;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c.a.r0.a.p.d.t1.a;
import c.a.r0.a.p1.o.a;
import c.a.r0.a.z2.q0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.dxmpay.wallet.paysdk.entrance.EnterDxmPayServiceAction;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicLong;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class f extends c.a.r0.a.p1.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static AtomicLong f6044f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f6045e;

    /* loaded from: classes.dex */
    public class a implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f6046b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f6047c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f6048d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f6049e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ f f6050f;

        public a(f fVar, CallbackHandler callbackHandler, String str, String str2, String str3, String str4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, callbackHandler, str, str2, str3, str4};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6050f = fVar;
            this.a = callbackHandler;
            this.f6046b = str;
            this.f6047c = str2;
            this.f6048d = str3;
            this.f6049e = str4;
        }

        @Override // c.a.r0.a.p1.o.a.b
        public void a(long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048576, this, j2) == null) {
                this.a.handleSchemeDispatchCallback(this.f6046b, UnitedSchemeUtility.wrapCallbackParams(1001, "download file failed because file size exceeds limit").toString());
                SwanAppNetworkUtils.a(c.a.r0.p.e.a.g().getOkHttpClient(), this.f6047c);
                this.f6050f.q(this.f6048d);
            }
        }

        @Override // c.a.r0.a.p1.o.a.b
        public void b(int i2, long j2, long j3) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2), Long.valueOf(j3)}) == null) || System.currentTimeMillis() - this.f6050f.p(this.f6048d) <= 500) {
                return;
            }
            if (i2 <= 100) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("progress", i2);
                    jSONObject.put("totalBytesWritten", j2);
                    jSONObject.put("totalBytesExpectedToWrite", j3);
                    this.a.handleSchemeDispatchCallback(this.f6049e, UnitedSchemeUtility.wrapCallbackParamsWithEncode(jSONObject, 0).toString());
                } catch (Exception e2) {
                    if (z.f6343b) {
                        e2.printStackTrace();
                    }
                }
            }
            this.f6050f.f8403c.put(this.f6048d, Long.valueOf(System.currentTimeMillis()));
        }

        @Override // c.a.r0.a.p1.o.a.b
        public void c(long j2, long j3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)}) == null) {
                this.a.handleSchemeDispatchCallback(this.f6046b, UnitedSchemeUtility.wrapCallbackParams(1001, "progress callback fail()").toString());
                SwanAppNetworkUtils.a(c.a.r0.p.e.a.g().getOkHttpClient(), this.f6047c);
                this.f6050f.q(this.f6048d);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f6051b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f6052c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f6053d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f6054e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f6055f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f6056g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f6057h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f6058i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ f f6059j;

        public b(f fVar, CallbackHandler callbackHandler, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, callbackHandler, str, str2, str3, str4, str5, str6, str7, str8};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6059j = fVar;
            this.a = callbackHandler;
            this.f6051b = str;
            this.f6052c = str2;
            this.f6053d = str3;
            this.f6054e = str4;
            this.f6055f = str5;
            this.f6056g = str6;
            this.f6057h = str7;
            this.f6058i = str8;
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, call, iOException) == null) {
                c.a.r0.a.g1.f.U().R();
                this.a.handleSchemeDispatchCallback(this.f6051b, UnitedSchemeUtility.wrapCallbackParams(1001, iOException.getMessage()).toString());
                this.f6059j.q(this.f6052c);
                if (SwanAppNetworkUtils.i(null)) {
                    c.a.r0.a.n2.n.v(0, this.f6053d, 0, iOException.getMessage(), this.f6054e, this.f6055f);
                }
            }
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) {
            String str;
            String str2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, call, response) == null) {
                try {
                    if (!TextUtils.isEmpty(this.f6056g)) {
                        str = this.f6059j.y(this.f6056g);
                    } else {
                        str = f.A(c.a.r0.a.p1.a.s(response.headers()), this.f6057h);
                    }
                } catch (JSONException e2) {
                    e2.printStackTrace();
                    str = null;
                }
                if (TextUtils.isEmpty(str)) {
                    this.a.handleSchemeDispatchCallback(this.f6051b, UnitedSchemeUtility.wrapCallbackParams(1001, "realFilePath create fail").toString());
                    return;
                }
                if (z.f6343b) {
                    String str3 = "the real file path is " + str;
                }
                try {
                    this.f6059j.r(this.f6058i, c.a.r0.a.p1.a.s(response.headers()));
                } catch (JSONException e3) {
                    e3.printStackTrace();
                }
                if (TextUtils.isEmpty(this.f6056g)) {
                    str2 = c.a.r0.a.g1.f.U().G().h(str);
                } else {
                    str2 = this.f6056g;
                }
                if (TextUtils.isEmpty(str2)) {
                    this.a.handleSchemeDispatchCallback(this.f6051b, UnitedSchemeUtility.wrapCallbackParams(1001, "parse tmpFilePath from realFilePath fail").toString());
                    return;
                }
                int code = response.code();
                String message = response.message();
                try {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put(EnterDxmPayServiceAction.SERVICE_STATUS_CODE, code);
                        jSONObject.put(TextUtils.isEmpty(this.f6056g) ? "tempFilePath" : "filePath", str2);
                        InputStream byteStream = response.body().byteStream();
                        File file = new File(str);
                        if (file.exists()) {
                            file.delete();
                            file.createNewFile();
                        }
                        if (c.a.r0.w.g.a(byteStream, file)) {
                            this.a.handleSchemeDispatchCallback(this.f6051b, UnitedSchemeUtility.wrapCallbackParamsWithEncode(jSONObject, 0).toString());
                        } else {
                            this.a.handleSchemeDispatchCallback(this.f6051b, UnitedSchemeUtility.wrapCallbackParams(1001, "streamToFile fail").toString());
                        }
                    } catch (Exception e4) {
                        if (z.f6343b) {
                            e4.printStackTrace();
                        }
                        this.a.handleSchemeDispatchCallback(this.f6051b, UnitedSchemeUtility.wrapCallbackParams(201, e4.getMessage()).toString());
                    }
                    this.f6059j.q(this.f6052c);
                    c.a.r0.a.g1.f.U().R();
                    if (z.f6343b) {
                        String str4 = "onResponse: respCode: " + code + ", url=" + this.f6053d + ", msg=" + message;
                    }
                    c.a.r0.a.n2.n.v(code, this.f6053d, 0, message, this.f6054e, this.f6055f);
                } catch (Throwable th) {
                    this.f6059j.q(this.f6052c);
                    c.a.r0.a.g1.f.U().R();
                    throw th;
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements a.InterfaceC0506a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c(f fVar, String str, CallbackHandler callbackHandler, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, str, callbackHandler, str2, str3, str4, str5, str6, str7, str8, str9, str10};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-372744600, "Lc/a/r0/a/f2/f/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-372744600, "Lc/a/r0/a/f2/f/f;");
                return;
            }
        }
        f6044f = new AtomicLong(System.currentTimeMillis());
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(c.a.r0.a.f2.e eVar) {
        super(eVar, "/swanAPI/downloadFile");
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
                super((c.a.r0.a.f2.e) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f6045e = 0;
    }

    @Nullable
    public static String A(JSONObject jSONObject, String str) {
        InterceptResult invokeLL;
        String str2;
        int lastIndexOf;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, jSONObject, str)) == null) {
            String optString = jSONObject.optString("Content-Disposition", null);
            if (!TextUtils.isEmpty(optString)) {
                String e2 = c.a.r0.a.z2.s.e(optString);
                if (!TextUtils.isEmpty(e2) && (lastIndexOf = e2.lastIndexOf(".") + 1) > 0) {
                    str = e2.substring(lastIndexOf);
                }
            } else {
                String optString2 = jSONObject.optString("Content-Type", null);
                if (!TextUtils.isEmpty(optString2)) {
                    String[] split = optString2.split(";");
                    int length = split.length;
                    int i2 = 0;
                    while (true) {
                        if (i2 >= length) {
                            break;
                        }
                        String c2 = c.a.r0.a.z2.s.c(split[i2]);
                        if (!TextUtils.isEmpty(c2)) {
                            str = c2;
                            break;
                        }
                        i2++;
                    }
                }
            }
            long andIncrement = f6044f.getAndIncrement();
            StringBuilder sb = new StringBuilder();
            sb.append(andIncrement);
            if (TextUtils.isEmpty(str)) {
                str2 = "";
            } else {
                str2 = "." + str;
            }
            sb.append(str2);
            return c.a.r0.a.g1.f.U().G().c(sb.toString());
        }
        return (String) invokeLL.objValue;
    }

    public a.InterfaceC0506a B(CallbackHandler callbackHandler, String str, JSONObject jSONObject, String str2) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, callbackHandler, str, jSONObject, str2)) == null) {
            String optString = jSONObject.optString("filePath");
            String optString2 = jSONObject.optString("url");
            String z = z(optString2);
            return new c(this, str, callbackHandler, jSONObject.optString("onProgressUpdate"), jSONObject.optString("cb"), str2, optString2, c.a.r0.a.n2.n.l(), q0.n().f(), optString, z, jSONObject.optString("headersReceivedEvent"));
        }
        return (a.InterfaceC0506a) invokeLLLL.objValue;
    }

    @Override // c.a.r0.a.f2.f.z
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.r0.a.d2.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            if (eVar == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "swanApp is null");
                return false;
            }
            JSONObject a2 = z.a(unitedSchemeEntity, "params");
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
            String optString4 = a2.optString("filePath");
            if (!TextUtils.isEmpty(optString4) && c.a.r0.w.d.x(optString4)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal path");
                return false;
            }
            String f0 = c.a.r0.a.d2.e.f0();
            if (TextUtils.isEmpty(f0)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal appId");
                return false;
            }
            String a3 = c.a.r0.a.u.e.i.j.a(f0);
            Request x = x(a2, a3);
            if (x == null) {
                unitedSchemeEntity.result = t(this.f6045e);
                return false;
            }
            String httpUrl = x.url().toString();
            String z = z(httpUrl);
            JSONObject optJSONObject = a2.optJSONObject("header");
            c.a.r0.a.p1.o.b bVar = new c.a.r0.a.p1.o.b();
            HashMap<String, String> m = c.a.r0.a.p1.a.m(optJSONObject, true);
            String optString5 = a2.optString("__plugin__");
            if (!TextUtils.isEmpty(optString5)) {
                c.a.r0.q.i.i h2 = c.a.r0.a.w1.h.b.h(optString5);
                if (m == null) {
                    m = new HashMap<>();
                }
                m.put("X-SWAN-HOSTSIGN", c.a.r0.a.w1.h.a.b(h2));
            }
            bVar.a(m);
            c.a.r0.a.g1.f.U().a0();
            String valueOf = String.valueOf(System.currentTimeMillis());
            this.f8403c.put(valueOf, 0L);
            if (c.a.r0.a.c1.a.v().h()) {
                c.a.r0.a.p.d.t1.b bVar2 = new c.a.r0.a.p.d.t1.b();
                bVar2.H(a2.optString("url"));
                bVar2.G(optString4);
                c.a.r0.a.c1.a.v().k(context, new c.a.r0.a.p.d.t1.b().H(a2.optString("url")).I(false).E(a3).G(optString4).F(m), B(callbackHandler, valueOf, a2, a3));
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(n(a3), 0));
                return true;
            }
            c.a.r0.a.p1.o.a aVar = new c.a.r0.a.p1.o.a();
            aVar.b(new a(this, callbackHandler, optString3, a3, valueOf, optString));
            String l = c.a.r0.a.n2.n.l();
            String f2 = q0.n().f();
            if (SwanAppNetworkUtils.i(null)) {
                c.a.r0.a.n2.n.A(httpUrl, 0);
            }
            OkHttpClient.Builder i2 = c.a.r0.p.e.a.g().i();
            i2.addNetworkInterceptor(new c.a.r0.a.p1.o.d());
            c.a.r0.p.e.a.g().w(i2);
            i2.addInterceptor(bVar).addNetworkInterceptor(aVar).build().newCall(c.a.r0.a.p1.o.c.f(x, "downloadFile", a2.optString("__plugin__"))).enqueue(new b(this, callbackHandler, optString3, valueOf, httpUrl, l, f2, optString4, z, optString2));
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(n(a3), 0));
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    @Nullable
    public final Request x(@Nullable JSONObject jSONObject, @Nullable String str) {
        InterceptResult invokeLL;
        HttpUrl f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, jSONObject, str)) == null) {
            if (jSONObject == null || TextUtils.isEmpty(str) || (f2 = c.a.r0.a.u.e.i.j.f(jSONObject.optString("url"))) == null) {
                return null;
            }
            String httpUrl = f2.toString();
            if (TextUtils.isEmpty(httpUrl)) {
                return null;
            }
            int c2 = c.a.r0.a.e2.a.b.c("downloadFile", httpUrl, jSONObject.optString("__plugin__"));
            this.f6045e = c2;
            if (c2 != 0) {
                return null;
            }
            return new Request.Builder().url(httpUrl).tag(str).build();
        }
        return (Request) invokeLL.objValue;
    }

    @Nullable
    public final String y(@NonNull String str) {
        InterceptResult invokeL;
        File parentFile;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            String i2 = c.a.r0.a.g1.f.U().G().i(str);
            if (i2 == null || i2.endsWith(File.separator) || (parentFile = new File(i2).getParentFile()) == null || !parentFile.exists()) {
                return null;
            }
            return i2;
        }
        return (String) invokeL.objValue;
    }

    public final String z(String str) {
        InterceptResult invokeL;
        Uri parse;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            if (TextUtils.isEmpty(str) || (parse = Uri.parse(str)) == null) {
                return null;
            }
            return c.a.r0.w.d.t(parse.getPath());
        }
        return (String) invokeL.objValue;
    }
}
