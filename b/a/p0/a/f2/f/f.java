package b.a.p0.a.f2.f;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import b.a.p0.a.p.d.t1.a;
import b.a.p0.a.p1.o.a;
import b.a.p0.a.z2.q0;
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
public class f extends b.a.p0.a.p1.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static AtomicLong f4911f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f4912e;

    /* loaded from: classes.dex */
    public class a implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f4913a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f4914b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f4915c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f4916d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f4917e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ f f4918f;

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
            this.f4918f = fVar;
            this.f4913a = callbackHandler;
            this.f4914b = str;
            this.f4915c = str2;
            this.f4916d = str3;
            this.f4917e = str4;
        }

        @Override // b.a.p0.a.p1.o.a.b
        public void a(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
                this.f4913a.handleSchemeDispatchCallback(this.f4914b, UnitedSchemeUtility.wrapCallbackParams(1001, "download file failed because file size exceeds limit").toString());
                SwanAppNetworkUtils.a(b.a.p0.p.e.a.g().getOkHttpClient(), this.f4915c);
                this.f4918f.q(this.f4916d);
            }
        }

        @Override // b.a.p0.a.p1.o.a.b
        public void b(int i2, long j, long j2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j), Long.valueOf(j2)}) == null) || System.currentTimeMillis() - this.f4918f.p(this.f4916d) <= 500) {
                return;
            }
            if (i2 <= 100) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("progress", i2);
                    jSONObject.put("totalBytesWritten", j);
                    jSONObject.put("totalBytesExpectedToWrite", j2);
                    this.f4913a.handleSchemeDispatchCallback(this.f4917e, UnitedSchemeUtility.wrapCallbackParamsWithEncode(jSONObject, 0).toString());
                } catch (Exception e2) {
                    if (z.f5228b) {
                        e2.printStackTrace();
                    }
                }
            }
            this.f4918f.f7726c.put(this.f4916d, Long.valueOf(System.currentTimeMillis()));
        }

        @Override // b.a.p0.a.p1.o.a.b
        public void c(long j, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
                this.f4913a.handleSchemeDispatchCallback(this.f4914b, UnitedSchemeUtility.wrapCallbackParams(1001, "progress callback fail()").toString());
                SwanAppNetworkUtils.a(b.a.p0.p.e.a.g().getOkHttpClient(), this.f4915c);
                this.f4918f.q(this.f4916d);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f4919a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f4920b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f4921c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f4922d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f4923e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f4924f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f4925g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f4926h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f4927i;
        public final /* synthetic */ f j;

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
            this.j = fVar;
            this.f4919a = callbackHandler;
            this.f4920b = str;
            this.f4921c = str2;
            this.f4922d = str3;
            this.f4923e = str4;
            this.f4924f = str5;
            this.f4925g = str6;
            this.f4926h = str7;
            this.f4927i = str8;
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, call, iOException) == null) {
                b.a.p0.a.g1.f.U().R();
                this.f4919a.handleSchemeDispatchCallback(this.f4920b, UnitedSchemeUtility.wrapCallbackParams(1001, iOException.getMessage()).toString());
                this.j.q(this.f4921c);
                if (SwanAppNetworkUtils.i(null)) {
                    b.a.p0.a.n2.n.v(0, this.f4922d, 0, iOException.getMessage(), this.f4923e, this.f4924f);
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
                    if (!TextUtils.isEmpty(this.f4925g)) {
                        str = this.j.y(this.f4925g);
                    } else {
                        str = f.A(b.a.p0.a.p1.a.s(response.headers()), this.f4926h);
                    }
                } catch (JSONException e2) {
                    e2.printStackTrace();
                    str = null;
                }
                if (TextUtils.isEmpty(str)) {
                    this.f4919a.handleSchemeDispatchCallback(this.f4920b, UnitedSchemeUtility.wrapCallbackParams(1001, "realFilePath create fail").toString());
                    return;
                }
                if (z.f5228b) {
                    String str3 = "the real file path is " + str;
                }
                try {
                    this.j.r(this.f4927i, b.a.p0.a.p1.a.s(response.headers()));
                } catch (JSONException e3) {
                    e3.printStackTrace();
                }
                if (TextUtils.isEmpty(this.f4925g)) {
                    str2 = b.a.p0.a.g1.f.U().G().h(str);
                } else {
                    str2 = this.f4925g;
                }
                if (TextUtils.isEmpty(str2)) {
                    this.f4919a.handleSchemeDispatchCallback(this.f4920b, UnitedSchemeUtility.wrapCallbackParams(1001, "parse tmpFilePath from realFilePath fail").toString());
                    return;
                }
                int code = response.code();
                String message = response.message();
                try {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put(EnterDxmPayServiceAction.SERVICE_STATUS_CODE, code);
                        jSONObject.put(TextUtils.isEmpty(this.f4925g) ? "tempFilePath" : "filePath", str2);
                        InputStream byteStream = response.body().byteStream();
                        File file = new File(str);
                        if (file.exists()) {
                            file.delete();
                            file.createNewFile();
                        }
                        if (b.a.p0.w.g.a(byteStream, file)) {
                            this.f4919a.handleSchemeDispatchCallback(this.f4920b, UnitedSchemeUtility.wrapCallbackParamsWithEncode(jSONObject, 0).toString());
                        } else {
                            this.f4919a.handleSchemeDispatchCallback(this.f4920b, UnitedSchemeUtility.wrapCallbackParams(1001, "streamToFile fail").toString());
                        }
                    } catch (Exception e4) {
                        if (z.f5228b) {
                            e4.printStackTrace();
                        }
                        this.f4919a.handleSchemeDispatchCallback(this.f4920b, UnitedSchemeUtility.wrapCallbackParams(201, e4.getMessage()).toString());
                    }
                    this.j.q(this.f4921c);
                    b.a.p0.a.g1.f.U().R();
                    if (z.f5228b) {
                        String str4 = "onResponse: respCode: " + code + ", url=" + this.f4922d + ", msg=" + message;
                    }
                    b.a.p0.a.n2.n.v(code, this.f4922d, 0, message, this.f4923e, this.f4924f);
                } catch (Throwable th) {
                    this.j.q(this.f4921c);
                    b.a.p0.a.g1.f.U().R();
                    throw th;
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements a.InterfaceC0348a {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-120375861, "Lb/a/p0/a/f2/f/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-120375861, "Lb/a/p0/a/f2/f/f;");
                return;
            }
        }
        f4911f = new AtomicLong(System.currentTimeMillis());
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(b.a.p0.a.f2.e eVar) {
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
                super((b.a.p0.a.f2.e) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f4912e = 0;
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
                String e2 = b.a.p0.a.z2.s.e(optString);
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
                        String c2 = b.a.p0.a.z2.s.c(split[i2]);
                        if (!TextUtils.isEmpty(c2)) {
                            str = c2;
                            break;
                        }
                        i2++;
                    }
                }
            }
            long andIncrement = f4911f.getAndIncrement();
            StringBuilder sb = new StringBuilder();
            sb.append(andIncrement);
            if (TextUtils.isEmpty(str)) {
                str2 = "";
            } else {
                str2 = "." + str;
            }
            sb.append(str2);
            return b.a.p0.a.g1.f.U().G().c(sb.toString());
        }
        return (String) invokeLL.objValue;
    }

    public a.InterfaceC0348a B(CallbackHandler callbackHandler, String str, JSONObject jSONObject, String str2) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, callbackHandler, str, jSONObject, str2)) == null) {
            String optString = jSONObject.optString("filePath");
            String optString2 = jSONObject.optString("url");
            String z = z(optString2);
            return new c(this, str, callbackHandler, jSONObject.optString("onProgressUpdate"), jSONObject.optString("cb"), str2, optString2, b.a.p0.a.n2.n.l(), q0.n().f(), optString, z, jSONObject.optString("headersReceivedEvent"));
        }
        return (a.InterfaceC0348a) invokeLLLL.objValue;
    }

    @Override // b.a.p0.a.f2.f.z
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, b.a.p0.a.d2.e eVar) {
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
            if (!TextUtils.isEmpty(optString4) && b.a.p0.w.d.x(optString4)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal path");
                return false;
            }
            String f0 = b.a.p0.a.d2.e.f0();
            if (TextUtils.isEmpty(f0)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal appId");
                return false;
            }
            String a3 = b.a.p0.a.u.e.i.j.a(f0);
            Request x = x(a2, a3);
            if (x == null) {
                unitedSchemeEntity.result = t(this.f4912e);
                return false;
            }
            String httpUrl = x.url().toString();
            String z = z(httpUrl);
            JSONObject optJSONObject = a2.optJSONObject("header");
            b.a.p0.a.p1.o.b bVar = new b.a.p0.a.p1.o.b();
            HashMap<String, String> m = b.a.p0.a.p1.a.m(optJSONObject, true);
            String optString5 = a2.optString("__plugin__");
            if (!TextUtils.isEmpty(optString5)) {
                b.a.p0.q.i.i h2 = b.a.p0.a.w1.h.b.h(optString5);
                if (m == null) {
                    m = new HashMap<>();
                }
                m.put("X-SWAN-HOSTSIGN", b.a.p0.a.w1.h.a.b(h2));
            }
            bVar.a(m);
            b.a.p0.a.g1.f.U().a0();
            String valueOf = String.valueOf(System.currentTimeMillis());
            this.f7726c.put(valueOf, 0L);
            if (b.a.p0.a.c1.a.v().h()) {
                b.a.p0.a.p.d.t1.b bVar2 = new b.a.p0.a.p.d.t1.b();
                bVar2.H(a2.optString("url"));
                bVar2.G(optString4);
                b.a.p0.a.c1.a.v().k(context, new b.a.p0.a.p.d.t1.b().H(a2.optString("url")).I(false).E(a3).G(optString4).F(m), B(callbackHandler, valueOf, a2, a3));
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(n(a3), 0));
                return true;
            }
            b.a.p0.a.p1.o.a aVar = new b.a.p0.a.p1.o.a();
            aVar.b(new a(this, callbackHandler, optString3, a3, valueOf, optString));
            String l = b.a.p0.a.n2.n.l();
            String f2 = q0.n().f();
            if (SwanAppNetworkUtils.i(null)) {
                b.a.p0.a.n2.n.A(httpUrl, 0);
            }
            OkHttpClient.Builder i2 = b.a.p0.p.e.a.g().i();
            i2.addNetworkInterceptor(new b.a.p0.a.p1.o.d());
            b.a.p0.p.e.a.g().w(i2);
            i2.addInterceptor(bVar).addNetworkInterceptor(aVar).build().newCall(b.a.p0.a.p1.o.c.f(x, "downloadFile", a2.optString("__plugin__"))).enqueue(new b(this, callbackHandler, optString3, valueOf, httpUrl, l, f2, optString4, z, optString2));
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
            if (jSONObject == null || TextUtils.isEmpty(str) || (f2 = b.a.p0.a.u.e.i.j.f(jSONObject.optString("url"))) == null) {
                return null;
            }
            String httpUrl = f2.toString();
            if (TextUtils.isEmpty(httpUrl)) {
                return null;
            }
            int c2 = b.a.p0.a.e2.a.b.c("downloadFile", httpUrl, jSONObject.optString("__plugin__"));
            this.f4912e = c2;
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
            String i2 = b.a.p0.a.g1.f.U().G().i(str);
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
            return b.a.p0.w.d.t(parse.getPath());
        }
        return (String) invokeL.objValue;
    }
}
