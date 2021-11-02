package b.a.p0.a.u.e.j;

import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.j2.k;
import b.a.p0.a.u.c.d;
import b.a.p0.a.v2.q0;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.http.callback.StatResponseCallback;
import com.baidu.searchbox.http.request.HttpCommonRequestBuilder;
import com.baidu.searchbox.http.request.HttpRequest;
import com.baidu.searchbox.http.request.HttpRequestBuilder;
import com.baidu.searchbox.http.statistics.NetworkStatRecord;
import com.baidu.searchbox.v8engine.JsArrayBuffer;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.dxmpay.wallet.paysdk.entrance.EnterDxmPayServiceAction;
import com.facebook.common.internal.Sets;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.http.HttpMethod;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpOptions;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpTrace;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class g extends b.a.p0.a.u.c.d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static final Set<String> f8237d;

    /* renamed from: e  reason: collision with root package name */
    public static final Set<String> f8238e;

    /* renamed from: f  reason: collision with root package name */
    public static final Set<String> f8239f;

    /* renamed from: g  reason: collision with root package name */
    public static final Set<String> f8240g;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements d.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // b.a.p0.a.u.c.d.b
        public b.a.p0.a.u.h.b a(b.a.p0.a.a2.e eVar, JSONObject jSONObject, @Nullable String str) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, eVar, jSONObject, str)) == null) {
                String optString = jSONObject.optString("cancelTag");
                if (TextUtils.isEmpty(optString)) {
                    return new b.a.p0.a.u.h.b(202, "illegal cancelTag");
                }
                SwanAppNetworkUtils.a(b.a.p0.m.e.a.g().getOkHttpClient(), optString);
                return new b.a.p0.a.u.h.b(0);
            }
            return (b.a.p0.a.u.h.b) invokeLLL.objValue;
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.a2.e f8241e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ JSONObject f8242f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f8243g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f8244h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ g f8245i;

        public b(g gVar, b.a.p0.a.a2.e eVar, JSONObject jSONObject, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, eVar, jSONObject, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8245i = gVar;
            this.f8241e = eVar;
            this.f8242f = jSONObject;
            this.f8243g = str;
            this.f8244h = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f8245i.E(this.f8241e, this.f8242f, this.f8243g, this.f8244h);
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements StatResponseCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8246e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ HttpUrl f8247f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f8248g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f8249h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ long f8250i;
        public final /* synthetic */ e j;

        public c(g gVar, String str, HttpUrl httpUrl, String str2, int i2, long j, e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, str, httpUrl, str2, Integer.valueOf(i2), Long.valueOf(j), eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8246e = str;
            this.f8247f = httpUrl;
            this.f8248g = str2;
            this.f8249h = i2;
            this.f8250i = j;
            this.j = eVar;
        }

        @Override // com.baidu.searchbox.http.callback.StatResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
                k.z(this.f8248g, this.f8249h, null, this.f8250i, System.currentTimeMillis());
                if (exc instanceof IOException) {
                    this.j.onFailure(null, (IOException) exc);
                } else {
                    this.j.onFailure(null, new IOException("request fail"));
                }
            }
        }

        @Override // com.baidu.searchbox.http.callback.StatResponseCallback
        public void onSuccess(Object obj, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj, i2) == null) {
            }
        }

        @Override // com.baidu.searchbox.http.callback.StatResponseCallback
        public Object parseResponse(Response response, int i2, NetworkStatRecord networkStatRecord) throws Exception {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(Constants.METHOD_SEND_USER_MSG, this, response, i2, networkStatRecord)) == null) {
                b.a.p0.a.h0.q.b.g().u(this.f8246e, this.f8247f, networkStatRecord);
                k.z(this.f8248g, this.f8249h, networkStatRecord, this.f8250i, System.currentTimeMillis());
                this.j.onResponse(null, response);
                return response;
            }
            return invokeLIL.objValue;
        }
    }

    /* loaded from: classes.dex */
    public class d implements b.a.p0.a.v2.e1.b<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8251e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ g f8252f;

        public d(g gVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8252f = gVar;
            this.f8251e = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.f8252f.d(this.f8251e, new b.a.p0.a.u.h.b(1001, str));
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public b.a.p0.a.a2.e f8253a;

        /* renamed from: b  reason: collision with root package name */
        public JSONObject f8254b;

        /* renamed from: c  reason: collision with root package name */
        public String f8255c;

        /* renamed from: d  reason: collision with root package name */
        public String f8256d;

        /* renamed from: e  reason: collision with root package name */
        public f f8257e;

        /* renamed from: f  reason: collision with root package name */
        public String f8258f;

        /* renamed from: g  reason: collision with root package name */
        public long f8259g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ g f8260h;

        public e(@NonNull g gVar, @NonNull b.a.p0.a.a2.e eVar, @NonNull JSONObject jSONObject, @NonNull String str, String str2, @NonNull f fVar, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, eVar, jSONObject, str, str2, fVar, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8260h = gVar;
            this.f8253a = eVar;
            this.f8254b = jSONObject;
            this.f8255c = str;
            this.f8256d = str2;
            this.f8257e = fVar;
            this.f8258f = str3;
            this.f8259g = System.currentTimeMillis();
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, call, iOException) == null) {
                if (b.a.p0.a.u.c.d.f8000c) {
                    String str = "onFailure: " + iOException.getMessage();
                }
                int F = this.f8253a.M().F();
                String l = k.l();
                String f2 = q0.n().f();
                SwanAppNetworkUtils.a(b.a.p0.m.e.a.g().getOkHttpClient(), this.f8256d);
                this.f8260h.d(this.f8258f, new b.a.p0.a.u.h.b(1001, iOException.getMessage()));
                k.K(0, this.f8255c, F, iOException.getMessage(), l, f2, this.f8259g, System.currentTimeMillis());
            }
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, call, response) == null) {
                if (!k.n(this.f8255c)) {
                    b.a.p0.a.l2.b.l().x(this.f8255c, response.headers("Set-cookie"));
                }
                String A = g.A(this.f8254b);
                String C = g.C(this.f8254b);
                int F = this.f8253a.M().F();
                long currentTimeMillis = System.currentTimeMillis();
                String l = k.l();
                String f2 = q0.n().f();
                try {
                    long B = g.B(response);
                    if (B <= 10485760) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put(EnterDxmPayServiceAction.SERVICE_STATUS_CODE, response.code());
                        jSONObject.put("header", h.g(response.headers()));
                        g.I(jSONObject, response.body(), A, C);
                        if (this.f8257e != null) {
                            this.f8257e.a(jSONObject);
                        }
                        this.f8260h.d(this.f8258f, new b.a.p0.a.u.h.b(0, jSONObject, true));
                    } else {
                        g.J(this.f8253a, this.f8255c, B, currentTimeMillis);
                        this.f8260h.d(this.f8258f, new b.a.p0.a.u.h.b(201, "response json length over limits"));
                    }
                } catch (IOException | JSONException e2) {
                    if (b.a.p0.a.u.c.d.f8000c) {
                        Log.getStackTraceString(e2);
                    }
                    this.f8260h.d(this.f8258f, new b.a.p0.a.u.h.b(201, e2.getMessage()));
                }
                int code = response.code();
                String message = response.message();
                if (b.a.p0.a.u.c.d.f8000c) {
                    String str = "onResponse: respCode: " + code + ", url=" + this.f8255c + ", msg=" + message;
                }
                if (b.a.p0.a.u.c.d.f8000c) {
                    response.headers().toString();
                }
                k.K(code, this.f8255c, F, message, l, f2, this.f8259g, System.currentTimeMillis());
            }
        }
    }

    /* loaded from: classes.dex */
    public interface f {
        void a(JSONObject jSONObject);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-229957453, "Lb/a/p0/a/u/e/j/g;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-229957453, "Lb/a/p0/a/u/e/j/g;");
                return;
            }
        }
        f8237d = Sets.newHashSet(HttpOptions.METHOD_NAME, "GET", "HEAD", "POST", HttpPut.METHOD_NAME, HttpDelete.METHOD_NAME, HttpTrace.METHOD_NAME, "CONNECT");
        f8238e = Sets.newHashSet("json", "string");
        f8239f = Sets.newHashSet("text", "arraybuffer");
        f8240g = Sets.newHashSet("REFERER", "USER-AGENT");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(@NonNull b.a.p0.a.u.c.b bVar) {
        super(bVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((b.a.p0.a.u.c.b) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @NonNull
    public static String A(@NonNull JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) {
            String optString = jSONObject.optString("dataType");
            return TextUtils.isEmpty(optString) ? "json" : !f8238e.contains(optString) ? "string" : optString;
        }
        return (String) invokeL.objValue;
    }

    public static long B(Response response) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, response)) == null) {
            if (response.body() != null) {
                return response.body().contentLength();
            }
            return 0L;
        }
        return invokeL.longValue;
    }

    @NonNull
    public static String C(@NonNull JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, jSONObject)) == null) {
            String optString = jSONObject.optString("responseType");
            return !f8239f.contains(optString) ? "text" : optString;
        }
        return (String) invokeL.objValue;
    }

    public static boolean F(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return str.trim().startsWith(PreferencesUtil.LEFT_MOUNT);
        }
        return invokeL.booleanValue;
    }

    public static boolean G(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return (str.trim().startsWith(StringUtil.ARRAY_START) && str.trim().endsWith("}")) || (str.trim().startsWith(PreferencesUtil.LEFT_MOUNT) && str.trim().endsWith(PreferencesUtil.RIGHT_MOUNT));
        }
        return invokeL.booleanValue;
    }

    public static Object H(@NonNull JSONObject jSONObject, @Nullable String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, jSONObject, str)) == null) {
            Object opt = jSONObject.opt("data");
            if (TextUtils.equals(str, "base64")) {
                boolean z = b.a.p0.a.u.c.d.f8000c;
                if (opt instanceof String) {
                    opt = Base64.decode((String) opt, 2);
                } else if (b.a.p0.a.u.c.d.f8000c) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("buildRequest: base64Data is illegal ");
                    sb.append(opt == null);
                    throw new RuntimeException(sb.toString());
                }
            } else if (opt instanceof JsArrayBuffer) {
                boolean z2 = b.a.p0.a.u.c.d.f8000c;
                opt = ((JsArrayBuffer) opt).buffer();
                if (b.a.p0.a.u.c.d.f8000c && opt == null) {
                    throw new RuntimeException("buildRequest: request with a null buffer");
                }
            }
            if (b.a.p0.a.u.c.d.f8000c) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("parseRequestData: data: ");
                sb2.append(opt == null ? StringUtil.NULL_STRING : opt.getClass().getSimpleName());
                sb2.append(" requestDataType: ");
                sb2.append(str);
                sb2.toString();
            }
            return opt;
        }
        return invokeLL.objValue;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v7, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r6v9, types: [org.json.JSONArray] */
    public static void I(@NonNull JSONObject jSONObject, @Nullable ResponseBody responseBody, @NonNull String str, @NonNull String str2) throws IOException, JSONException {
        String str3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(65544, null, jSONObject, responseBody, str, str2) == null) || responseBody == null) {
            return;
        }
        char c2 = 65535;
        int hashCode = str2.hashCode();
        if (hashCode != 3556653) {
            if (hashCode == 1154818009 && str2.equals("arraybuffer")) {
                c2 = 0;
            }
        } else if (str2.equals("text")) {
            c2 = 1;
        }
        if (c2 != 0) {
            str3 = responseBody.string();
        } else {
            byte[] bytes = responseBody.bytes();
            str3 = bytes == null ? null : new String(Base64.encode(bytes, 2));
            str = "string";
        }
        if (TextUtils.isEmpty(str3)) {
            return;
        }
        if (TextUtils.equals(str, "json")) {
            try {
                if (G(str3)) {
                    str3 = F(str3) ? new JSONArray(str3) : new JSONObject(str3);
                }
            } catch (JSONException unused) {
            }
        }
        jSONObject.put("data", str3);
    }

    public static void J(b.a.p0.a.a2.e eVar, String str, long j, long j2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65545, null, new Object[]{eVar, str, Long.valueOf(j), Long.valueOf(j2)}) == null) || eVar == null || TextUtils.isEmpty(str) || j < 0) {
            return;
        }
        b.a.p0.a.q2.a aVar = new b.a.p0.a.q2.a();
        aVar.j(5L);
        aVar.h(39L);
        b.a.p0.a.j2.p.d dVar = new b.a.p0.a.j2.p.d();
        dVar.p(aVar);
        dVar.r(eVar.K());
        dVar.q(k.m(b.a.p0.a.a2.d.g().l()));
        dVar.m(b.a.p0.a.a2.d.g().getAppId());
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("exceptionUrl", str);
            jSONObject.put("exceptionAppID", eVar.k());
            jSONObject.put("exceptionLength", j);
            jSONObject.put("exceptionRequestTime", j2);
            jSONObject.put("exceptionResponseTime", System.currentTimeMillis());
            dVar.e(jSONObject);
        } catch (JSONException e2) {
            if (b.a.p0.a.u.c.d.f8000c) {
                e2.printStackTrace();
            }
        }
        k.L(dVar);
    }

    public static void N(String str, @NonNull HttpRequestBuilder httpRequestBuilder, @Nullable JSONObject jSONObject, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65546, null, str, httpRequestBuilder, jSONObject, map) == null) {
            if (jSONObject != null && jSONObject.length() >= 1) {
                Iterator<String> keys = jSONObject.keys();
                String str2 = "";
                while (keys.hasNext()) {
                    String next = keys.next();
                    if (!TextUtils.isEmpty(next) && !f8240g.contains(next.toUpperCase())) {
                        String f2 = q0.f(jSONObject.optString(next));
                        if (TextUtils.isEmpty(f2)) {
                            f2 = "";
                        }
                        if (map != null) {
                            map.put(next.toLowerCase(), f2);
                        }
                        if ("Cookie".equalsIgnoreCase(next)) {
                            str2 = f2;
                        }
                        httpRequestBuilder.addHeader(next, f2);
                    }
                }
                r(httpRequestBuilder, str, str2);
                return;
            }
            r(httpRequestBuilder, str, "");
        }
    }

    @NonNull
    public static b.a.p0.a.u.h.b O(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65547, null, i2)) == null) {
            String str = "illegal request";
            int i3 = 202;
            if (i2 == 0) {
                i3 = 0;
                str = "";
            } else if (i2 != 1) {
                if (i2 == 2) {
                    str = "request url header must be https or wss";
                } else if (i2 == 3) {
                    str = "request:fail parameter error: arrayBuffer of data exceed size limit.";
                } else if (i2 == 4) {
                    str = "HTTP method is invalid";
                }
            }
            if (TextUtils.isEmpty(str)) {
                return new b.a.p0.a.u.h.b(i3);
            }
            return new b.a.p0.a.u.h.b(i3, str);
        }
        return (b.a.p0.a.u.h.b) invokeI.objValue;
    }

    public static void r(@NonNull HttpRequestBuilder httpRequestBuilder, String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65549, null, httpRequestBuilder, str, str2) == null) || k.n(str)) {
            return;
        }
        String f2 = b.a.p0.a.l2.b.l().f(str, str2);
        if (TextUtils.isEmpty(f2)) {
            return;
        }
        httpRequestBuilder.setHeader("Cookie", f2);
        if (b.a.p0.a.u.c.d.f8000c) {
            String str3 = "addCookiesToHeader cookie: " + f2;
        }
    }

    @NonNull
    public static HttpUrl s(@NonNull HttpUrl httpUrl, @NonNull Object obj, @Nullable String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65550, null, httpUrl, obj, str)) == null) {
            HttpUrl.Builder newBuilder = httpUrl.newBuilder();
            if (TextUtils.equals("JSONToString", str) && (obj instanceof String)) {
                boolean z = b.a.p0.a.u.c.d.f8000c;
                try {
                    obj = new JSONObject((String) obj);
                } catch (JSONException unused) {
                    if (b.a.p0.a.u.c.d.f8000c) {
                        throw new RuntimeException("appendQueryTo: illegal json str");
                    }
                }
            }
            if (!(obj instanceof JSONObject)) {
                if (b.a.p0.a.u.c.d.f8000c) {
                    String str2 = "appendQueryTo: data cannot be " + obj.getClass().getSimpleName();
                }
                return httpUrl;
            }
            boolean z2 = b.a.p0.a.u.c.d.f8000c;
            boolean z3 = false;
            JSONObject jSONObject = (JSONObject) obj;
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (!TextUtils.isEmpty(next)) {
                    String optString = jSONObject.optString(next);
                    if (TextUtils.isEmpty(optString)) {
                        optString = "";
                    }
                    newBuilder.addQueryParameter(next, optString);
                    z3 = true;
                }
            }
            return z3 ? newBuilder.build() : httpUrl;
        }
        return (HttpUrl) invokeLLL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:62:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0146  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Pair<HttpRequest, Integer> t(@Nullable JSONObject jSONObject, @Nullable String str) {
        InterceptResult invokeLL;
        int i2;
        String str2;
        RequestBody x;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65551, null, jSONObject, str)) == null) {
            if (jSONObject != null && !TextUtils.isEmpty(str)) {
                HttpUrl f2 = h.f(jSONObject.optString("url"));
                if (f2 == null) {
                    return new Pair<>(null, 0);
                }
                String httpUrl = f2.toString();
                String optString = jSONObject.optString("__plugin__");
                boolean optBoolean = jSONObject.optBoolean("ping", false);
                if (optBoolean) {
                    i2 = 0;
                } else {
                    i2 = b.a.p0.a.b2.a.b.c("request", httpUrl, optString);
                    if (i2 != 0) {
                        return new Pair<>(null, Integer.valueOf(i2));
                    }
                }
                String optString2 = jSONObject.optString("method");
                if (TextUtils.isEmpty(optString2)) {
                    optString2 = "GET";
                }
                String upperCase = optString2.toUpperCase();
                if (!f8237d.contains(upperCase)) {
                    return new Pair<>(null, 4);
                }
                HashMap hashMap = new HashMap();
                b.a.p0.m.d.a aVar = new b.a.p0.m.d.a();
                aVar.f11034b = upperCase;
                HttpRequestBuilder a2 = b.a.p0.m.e.b.a(aVar);
                N(httpUrl, a2, jSONObject.optJSONObject("header"), hashMap);
                a2.setHeader("Referer", h.d());
                if (!TextUtils.isEmpty(optString)) {
                    a2.setHeader("X-SWAN-HOSTSIGN", b.a.p0.a.t1.g.a.b(b.a.p0.a.t1.g.b.h(optString)));
                }
                String optString3 = jSONObject.optString("__requestDataType__");
                Object H = H(jSONObject, optString3);
                if (H instanceof byte[]) {
                    int length = ((byte[]) H).length;
                    str2 = optString3;
                    if (length > 10485760) {
                        if (b.a.p0.a.u.c.d.f8000c) {
                            String str3 = "buildRequest: ArrayBuffer大小超过上限 " + length;
                        }
                        return new Pair<>(null, 3);
                    }
                } else {
                    str2 = optString3;
                }
                boolean z = H != null;
                if (z && !HttpMethod.permitsRequestBody(upperCase)) {
                    f2 = s(f2, H, str2);
                } else {
                    String str4 = str2;
                    if (z || HttpMethod.requiresRequestBody(upperCase)) {
                        x = x(H, hashMap, str4);
                        if (!HttpMethod.requiresRequestBody(upperCase) && x == null) {
                            return new Pair<>(null, Integer.valueOf(i2));
                        }
                        if (a2 instanceof HttpCommonRequestBuilder) {
                            ((HttpCommonRequestBuilder) a2).requestBody(x);
                        }
                        aVar.f11033a = f2.toString();
                        aVar.f11038f = true;
                        aVar.f11039g = false;
                        aVar.f11040h = true;
                        aVar.f11041i = str;
                        aVar.k = 3;
                        b.a.p0.m.e.a.g().t(a2, aVar);
                        HttpRequest build = a2.build();
                        if (!optBoolean) {
                            build = b.a.p0.a.n1.o.c.e(build, "request", optString);
                        }
                        b.a.p0.a.h0.q.b.g().l(str, f2);
                        return new Pair<>(build, Integer.valueOf(i2));
                    }
                }
                x = null;
                if (!HttpMethod.requiresRequestBody(upperCase)) {
                }
                if (a2 instanceof HttpCommonRequestBuilder) {
                }
                aVar.f11033a = f2.toString();
                aVar.f11038f = true;
                aVar.f11039g = false;
                aVar.f11040h = true;
                aVar.f11041i = str;
                aVar.k = 3;
                b.a.p0.m.e.a.g().t(a2, aVar);
                HttpRequest build2 = a2.build();
                if (!optBoolean) {
                }
                b.a.p0.a.h0.q.b.g().l(str, f2);
                return new Pair<>(build2, Integer.valueOf(i2));
            }
            return new Pair<>(null, 0);
        }
        return (Pair) invokeLL.objValue;
    }

    public static RequestBody w(MediaType mediaType, @NonNull byte[] bArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65552, null, mediaType, bArr)) == null) {
            if (b.a.p0.a.u.c.d.f8000c) {
                String str = "createArrayBufferBody: " + bArr.length;
            }
            return RequestBody.create(mediaType, bArr);
        }
        return (RequestBody) invokeLL.objValue;
    }

    @Nullable
    public static RequestBody x(@Nullable Object obj, Map<String, String> map, @Nullable String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65553, null, obj, map, str)) == null) {
            String str2 = map.get("content-type");
            boolean isEmpty = TextUtils.isEmpty(str2);
            String str3 = StringUtil.NULL_STRING;
            if (isEmpty) {
                if (b.a.p0.a.u.c.d.f8000c) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("createBody: content-type: ");
                    sb.append(b.a.p0.a.n1.f.f6891a);
                    sb.append(" data: ");
                    if (obj != null) {
                        str3 = obj.getClass().getSimpleName();
                    }
                    sb.append(str3);
                    sb.toString();
                }
                if (obj instanceof byte[]) {
                    return w(b.a.p0.a.n1.f.f6891a, (byte[]) obj);
                }
                return RequestBody.create(b.a.p0.a.n1.f.f6891a, obj != null ? obj.toString() : "");
            }
            MediaType parse = MediaType.parse(str2);
            if (b.a.p0.a.n1.f.f6891a.equals(parse)) {
                if (b.a.p0.a.u.c.d.f8000c) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("createBody: content-type: ");
                    sb2.append(b.a.p0.a.n1.f.f6891a);
                    sb2.append(" data: ");
                    if (obj != null) {
                        str3 = obj.getClass().getSimpleName();
                    }
                    sb2.append(str3);
                    sb2.toString();
                }
                if (obj instanceof byte[]) {
                    return w(b.a.p0.a.n1.f.f6891a, (byte[]) obj);
                }
                return RequestBody.create(b.a.p0.a.n1.f.f6891a, obj != null ? obj.toString() : "");
            }
            return y(obj, parse, str);
        }
        return (RequestBody) invokeLLL.objValue;
    }

    public static RequestBody y(@Nullable Object obj, MediaType mediaType, @Nullable String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65554, null, obj, mediaType, str)) == null) {
            FormBody.Builder builder = new FormBody.Builder();
            if (obj instanceof byte[]) {
                return w(mediaType, (byte[]) obj);
            }
            if (TextUtils.equals("JSONToString", str) && (obj instanceof String)) {
                boolean z = b.a.p0.a.u.c.d.f8000c;
                try {
                    obj = new JSONObject((String) obj);
                } catch (JSONException unused) {
                    if (b.a.p0.a.u.c.d.f8000c) {
                        throw new RuntimeException("createFormBody: illegal json str");
                    }
                }
            }
            if (obj != null && obj.toString().length() != 0) {
                if (obj instanceof String) {
                    if (b.a.p0.a.u.c.d.f8000c) {
                        String str2 = "createFormBody: content-type: " + mediaType + " data: String";
                    }
                    return RequestBody.create(mediaType, (String) obj);
                }
                if (b.a.p0.a.u.c.d.f8000c) {
                    String str3 = "createFormBody: content-type: " + mediaType + " data: " + obj.getClass().getSimpleName();
                }
                if (obj instanceof JSONObject) {
                    JSONObject jSONObject = (JSONObject) obj;
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        if (!TextUtils.isEmpty(next)) {
                            builder.add(next, jSONObject.optString(next));
                        }
                    }
                }
                return b.a.p0.a.n1.d.a(builder.build(), mediaType);
            }
            boolean z2 = b.a.p0.a.u.c.d.f8000c;
            return builder.build();
        }
        return (RequestBody) invokeLLL.objValue;
    }

    public final void D(@NonNull b.a.p0.a.a2.e eVar, @NonNull JSONObject jSONObject, @NonNull HttpRequest httpRequest, @NonNull String str, f fVar, @NonNull String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{eVar, jSONObject, httpRequest, str, fVar, str2}) == null) {
            HttpUrl url = httpRequest.getOkRequest().url();
            String httpUrl = url.toString();
            if (v(eVar, jSONObject, httpUrl, str, fVar, str2)) {
                return;
            }
            httpRequest.executeStat(new c(this, str, url, httpUrl, eVar.M().F(), System.currentTimeMillis(), new e(this, eVar, jSONObject, httpUrl, str, fVar, str2)));
        }
    }

    public final void E(b.a.p0.a.a2.e eVar, JSONObject jSONObject, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar, jSONObject, str, str2) == null) {
            Pair<HttpRequest, Integer> t = t(jSONObject, str);
            HttpRequest httpRequest = (HttpRequest) t.first;
            if (httpRequest == null) {
                d(str2, O(((Integer) t.second).intValue()));
            } else {
                D(eVar, jSONObject, httpRequest, str, null, str2);
            }
        }
    }

    public b.a.p0.a.u.h.b K(JsObject jsObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jsObject)) == null) {
            Pair<b.a.p0.a.u.h.a, JSONObject> m = b.a.p0.a.u.c.d.m(jsObject);
            if (!((b.a.p0.a.u.h.a) m.first).isSuccess()) {
                return (b.a.p0.a.u.h.b) m.first;
            }
            JSONObject jSONObject = (JSONObject) m.second;
            if (jSONObject == null) {
                return (b.a.p0.a.u.h.b) b.a.p0.a.u.h.a.f8425a;
            }
            if (b.a.p0.a.u.c.d.f8000c) {
                String str = "request with JsObject => JSONObject : " + jSONObject.toString();
            }
            b.a.p0.a.a2.e i2 = b.a.p0.a.a2.e.i();
            if (i2 == null) {
                return new b.a.p0.a.u.h.b(1001, "swan app is null");
            }
            String optString = jSONObject.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                b.a.p0.a.e0.d.b("Api-Request", "callback is null");
                return new b.a.p0.a.u.h.b(1001, "callback is null");
            }
            return L(i2, jSONObject, optString);
        }
        return (b.a.p0.a.u.h.b) invokeL.objValue;
    }

    public final b.a.p0.a.u.h.b L(@NonNull b.a.p0.a.a2.e eVar, @NonNull JSONObject jSONObject, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, eVar, jSONObject, str)) == null) {
            if (TextUtils.isEmpty(jSONObject.optString("url"))) {
                b.a.p0.a.e0.d.b("Api-Request", "illegal url");
                return new b.a.p0.a.u.h.b(1001, "illegal url");
            }
            String a2 = h.a(eVar.f3961f);
            JSONObject c2 = h.c(a2);
            b.a.p0.a.u.f.a.d().c(new b.a.p0.a.u.f.b.g.c(this, eVar, jSONObject, a2, str));
            return new b.a.p0.a.u.h.b(0, c2);
        }
        return (b.a.p0.a.u.h.b) invokeLLL.objValue;
    }

    public b.a.p0.a.u.h.b M(@NonNull JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, jSONObject)) == null) {
            if (b.a.p0.a.u.c.d.f8000c) {
                String str = "request with JSONObject: " + jSONObject;
            }
            b.a.p0.a.a2.e i2 = b.a.p0.a.a2.e.i();
            if (i2 == null) {
                return new b.a.p0.a.u.h.b(1001, "swan app is null");
            }
            String optString = jSONObject.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                b.a.p0.a.e0.d.b("Api-Request", "callback is null");
                return new b.a.p0.a.u.h.b(202, "callback is null");
            }
            return L(i2, jSONObject, optString);
        }
        return (b.a.p0.a.u.h.b) invokeL.objValue;
    }

    public b.a.p0.a.u.h.b u(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            boolean z = b.a.p0.a.u.c.d.f8000c;
            return i(str, false, new a(this));
        }
        return (b.a.p0.a.u.h.b) invokeL.objValue;
    }

    public final boolean v(@NonNull b.a.p0.a.a2.e eVar, @NonNull JSONObject jSONObject, @NonNull String str, @NonNull String str2, f fVar, @NonNull String str3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{eVar, jSONObject, str, str2, fVar, str3})) == null) ? b.a.p0.a.c1.a.d().i(eVar, jSONObject, str, str2, new e(this, eVar, jSONObject, str, str2, fVar, str3), new d(this, str3)) : invokeCommon.booleanValue;
    }

    public void z(b.a.p0.a.a2.e eVar, JSONObject jSONObject, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048583, this, eVar, jSONObject, str, str2) == null) {
            if (b.a.p0.a.r1.l.e.l()) {
                E(eVar, jSONObject, str, str2);
            } else {
                ExecutorUtilsExt.postOnElastic(new b(this, eVar, jSONObject, str, str2), "doRequest", 0);
            }
        }
    }
}
