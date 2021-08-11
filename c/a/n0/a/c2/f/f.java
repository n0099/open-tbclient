package c.a.n0.a.c2.f;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c.a.n0.a.n1.o.a;
import c.a.n0.a.v2.q0;
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
import org.json.JSONObject;
/* loaded from: classes.dex */
public class f extends c.a.n0.a.n1.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static AtomicLong f4510f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f4511e;

    /* loaded from: classes.dex */
    public class a implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f4512a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f4513b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f4514c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f4515d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f4516e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ f f4517f;

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
            this.f4517f = fVar;
            this.f4512a = callbackHandler;
            this.f4513b = str;
            this.f4514c = str2;
            this.f4515d = str3;
            this.f4516e = str4;
        }

        @Override // c.a.n0.a.n1.o.a.b
        public void a(long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048576, this, j2) == null) {
                this.f4512a.handleSchemeDispatchCallback(this.f4513b, UnitedSchemeUtility.wrapCallbackParams(1001, "download file failed because file size exceeds limit").toString());
                SwanAppNetworkUtils.a(c.a.n0.m.e.a.g().getOkHttpClient(), this.f4514c);
                this.f4517f.q(this.f4515d);
            }
        }

        @Override // c.a.n0.a.n1.o.a.b
        public void b(int i2, long j2, long j3) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2), Long.valueOf(j3)}) == null) || System.currentTimeMillis() - this.f4517f.p(this.f4515d) <= 500) {
                return;
            }
            if (i2 <= 100) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("progress", i2);
                    jSONObject.put("totalBytesWritten", j2);
                    jSONObject.put("totalBytesExpectedToWrite", j3);
                    this.f4512a.handleSchemeDispatchCallback(this.f4516e, UnitedSchemeUtility.wrapCallbackParamsWithEncode(jSONObject, 0).toString());
                } catch (Exception e2) {
                    if (a0.f4492b) {
                        e2.printStackTrace();
                    }
                }
            }
            this.f4517f.f7300c.put(this.f4515d, Long.valueOf(System.currentTimeMillis()));
        }

        @Override // c.a.n0.a.n1.o.a.b
        public void c(long j2, long j3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)}) == null) {
                this.f4512a.handleSchemeDispatchCallback(this.f4513b, UnitedSchemeUtility.wrapCallbackParams(1001, "progress callback fail()").toString());
                SwanAppNetworkUtils.a(c.a.n0.m.e.a.g().getOkHttpClient(), this.f4514c);
                this.f4517f.q(this.f4515d);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f4518a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f4519b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f4520c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f4521d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f4522e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f4523f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f4524g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f4525h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f4526i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ f f4527j;

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
            this.f4527j = fVar;
            this.f4518a = callbackHandler;
            this.f4519b = str;
            this.f4520c = str2;
            this.f4521d = str3;
            this.f4522e = str4;
            this.f4523f = str5;
            this.f4524g = str6;
            this.f4525h = str7;
            this.f4526i = str8;
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, call, iOException) == null) {
                c.a.n0.a.g1.f.V().S();
                this.f4518a.handleSchemeDispatchCallback(this.f4519b, UnitedSchemeUtility.wrapCallbackParams(1001, iOException.getMessage()).toString());
                this.f4527j.q(this.f4520c);
                if (SwanAppNetworkUtils.i(null)) {
                    c.a.n0.a.j2.k.s(0, this.f4521d, 0, iOException.getMessage(), this.f4522e, this.f4523f);
                }
            }
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) {
            String y;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, call, response) == null) {
                if (!TextUtils.isEmpty(this.f4524g)) {
                    y = this.f4527j.y(this.f4524g);
                } else {
                    y = f.A(response, this.f4525h);
                }
                if (TextUtils.isEmpty(y)) {
                    this.f4518a.handleSchemeDispatchCallback(this.f4519b, UnitedSchemeUtility.wrapCallbackParams(1001, "realFilePath create fail").toString());
                    return;
                }
                if (a0.f4492b) {
                    String str2 = "the real file path is " + y;
                }
                this.f4527j.r(this.f4526i, response.headers());
                if (TextUtils.isEmpty(this.f4524g)) {
                    str = c.a.n0.a.g1.f.V().I().h(y);
                } else {
                    str = this.f4524g;
                }
                if (TextUtils.isEmpty(str)) {
                    this.f4518a.handleSchemeDispatchCallback(this.f4519b, UnitedSchemeUtility.wrapCallbackParams(1001, "parse tmpFilePath from realFilePath fail").toString());
                    return;
                }
                int code = response.code();
                String message = response.message();
                try {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("statusCode", code);
                        jSONObject.put(TextUtils.isEmpty(this.f4524g) ? "tempFilePath" : "filePath", str);
                        InputStream byteStream = response.body().byteStream();
                        File file = new File(y);
                        if (file.exists()) {
                            file.delete();
                            file.createNewFile();
                        }
                        if (c.a.n0.t.g.a(byteStream, file)) {
                            this.f4518a.handleSchemeDispatchCallback(this.f4519b, UnitedSchemeUtility.wrapCallbackParamsWithEncode(jSONObject, 0).toString());
                        } else {
                            this.f4518a.handleSchemeDispatchCallback(this.f4519b, UnitedSchemeUtility.wrapCallbackParams(1001, "streamToFile fail").toString());
                        }
                    } catch (Exception e2) {
                        if (a0.f4492b) {
                            e2.printStackTrace();
                        }
                        this.f4518a.handleSchemeDispatchCallback(this.f4519b, UnitedSchemeUtility.wrapCallbackParams(201, e2.getMessage()).toString());
                    }
                    this.f4527j.q(this.f4520c);
                    c.a.n0.a.g1.f.V().S();
                    if (a0.f4492b) {
                        String str3 = "onResponse: respCode: " + code + ", url=" + this.f4521d + ", msg=" + message;
                    }
                    c.a.n0.a.j2.k.s(code, this.f4521d, 0, message, this.f4522e, this.f4523f);
                } catch (Throwable th) {
                    this.f4527j.q(this.f4520c);
                    c.a.n0.a.g1.f.V().S();
                    throw th;
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(743380777, "Lc/a/n0/a/c2/f/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(743380777, "Lc/a/n0/a/c2/f/f;");
                return;
            }
        }
        f4510f = new AtomicLong(System.currentTimeMillis());
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(c.a.n0.a.c2.e eVar) {
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
                super((c.a.n0.a.c2.e) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f4511e = 0;
    }

    @Nullable
    public static String A(Response response, String str) {
        InterceptResult invokeLL;
        String str2;
        int lastIndexOf;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, response, str)) == null) {
            String header = response.header("Content-Disposition", null);
            if (!TextUtils.isEmpty(header)) {
                String e2 = c.a.n0.a.v2.s.e(header);
                if (!TextUtils.isEmpty(e2) && (lastIndexOf = e2.lastIndexOf(".") + 1) > 0) {
                    str = e2.substring(lastIndexOf);
                }
            } else {
                String header2 = response.header("Content-Type", null);
                if (!TextUtils.isEmpty(header2)) {
                    String[] split = header2.split(";");
                    int length = split.length;
                    int i2 = 0;
                    while (true) {
                        if (i2 >= length) {
                            break;
                        }
                        String c2 = c.a.n0.a.v2.s.c(split[i2]);
                        if (!TextUtils.isEmpty(c2)) {
                            str = c2;
                            break;
                        }
                        i2++;
                    }
                }
            }
            long andIncrement = f4510f.getAndIncrement();
            StringBuilder sb = new StringBuilder();
            sb.append(andIncrement);
            if (TextUtils.isEmpty(str)) {
                str2 = "";
            } else {
                str2 = "." + str;
            }
            sb.append(str2);
            return c.a.n0.a.g1.f.V().I().c(sb.toString());
        }
        return (String) invokeLL.objValue;
    }

    @Override // c.a.n0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.n0.a.a2.e eVar) {
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
            String optString = a2.optString("onProgressUpdate");
            String optString2 = a2.optString("headersReceivedEvent");
            String optString3 = a2.optString("cb");
            if (TextUtils.isEmpty(optString3)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal resultCallback");
                return false;
            }
            String optString4 = a2.optString("filePath");
            if (!TextUtils.isEmpty(optString4) && c.a.n0.t.d.w(optString4)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal path");
                return false;
            }
            String V = c.a.n0.a.a2.e.V();
            if (TextUtils.isEmpty(V)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal appId");
                return false;
            }
            String a3 = c.a.n0.a.u.e.j.h.a(V);
            Request x = x(a2, a3);
            if (x == null) {
                unitedSchemeEntity.result = t(this.f4511e);
                return false;
            }
            String httpUrl = x.url().toString();
            String z = z(httpUrl);
            JSONObject optJSONObject = a2.optJSONObject("header");
            c.a.n0.a.n1.o.b bVar = new c.a.n0.a.n1.o.b();
            HashMap<String, String> m = c.a.n0.a.n1.a.m(optJSONObject, true);
            String optString5 = a2.optString("__plugin__");
            if (!TextUtils.isEmpty(optString5)) {
                c.a.n0.n.h.h h2 = c.a.n0.a.t1.g.b.h(optString5);
                if (m == null) {
                    m = new HashMap<>();
                }
                m.put("X-SWAN-HOSTSIGN", c.a.n0.a.t1.g.a.b(h2));
            }
            bVar.a(m);
            c.a.n0.a.g1.f.V().b0();
            String valueOf = String.valueOf(System.currentTimeMillis());
            this.f7300c.put(valueOf, 0L);
            c.a.n0.a.n1.o.a aVar = new c.a.n0.a.n1.o.a();
            aVar.b(new a(this, callbackHandler, optString3, a3, valueOf, optString));
            String l = c.a.n0.a.j2.k.l();
            String h3 = q0.n().h();
            if (SwanAppNetworkUtils.i(null)) {
                c.a.n0.a.j2.k.x(httpUrl, 0);
            }
            OkHttpClient.Builder i2 = c.a.n0.m.e.a.g().i();
            i2.addNetworkInterceptor(new c.a.n0.a.n1.o.d());
            c.a.n0.m.e.a.g().v(i2);
            i2.addInterceptor(bVar).addNetworkInterceptor(aVar).build().newCall(c.a.n0.a.n1.o.c.f(x, "downloadFile", a2.optString("__plugin__"))).enqueue(new b(this, callbackHandler, optString3, valueOf, httpUrl, l, h3, optString4, z, optString2));
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
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject, str)) == null) {
            if (jSONObject == null || TextUtils.isEmpty(str) || (f2 = c.a.n0.a.u.e.j.h.f(jSONObject.optString("url"))) == null) {
                return null;
            }
            String httpUrl = f2.toString();
            if (TextUtils.isEmpty(httpUrl)) {
                return null;
            }
            int c2 = c.a.n0.a.b2.a.b.c("downloadFile", httpUrl, jSONObject.optString("__plugin__"));
            this.f4511e = c2;
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
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            String i2 = c.a.n0.a.g1.f.V().I().i(str);
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
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            if (TextUtils.isEmpty(str) || (parse = Uri.parse(str)) == null) {
                return null;
            }
            return c.a.n0.t.d.s(parse.getPath());
        }
        return (String) invokeL.objValue;
    }
}
