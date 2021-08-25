package c.a.o0.a.u.e.j;

import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.o0.a.j2.k;
import c.a.o0.a.u.c.d;
import c.a.o0.a.v2.q0;
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
public class g extends c.a.o0.a.u.c.d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static final Set<String> f8943d;

    /* renamed from: e  reason: collision with root package name */
    public static final Set<String> f8944e;

    /* renamed from: f  reason: collision with root package name */
    public static final Set<String> f8945f;

    /* renamed from: g  reason: collision with root package name */
    public static final Set<String> f8946g;
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

        @Override // c.a.o0.a.u.c.d.b
        public c.a.o0.a.u.h.b a(c.a.o0.a.a2.e eVar, JSONObject jSONObject, @Nullable String str) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, eVar, jSONObject, str)) == null) {
                String optString = jSONObject.optString("cancelTag");
                if (TextUtils.isEmpty(optString)) {
                    return new c.a.o0.a.u.h.b(202, "illegal cancelTag");
                }
                SwanAppNetworkUtils.a(c.a.o0.m.e.a.g().getOkHttpClient(), optString);
                return new c.a.o0.a.u.h.b(0);
            }
            return (c.a.o0.a.u.h.b) invokeLLL.objValue;
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.a.a2.e f8947e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ JSONObject f8948f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f8949g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f8950h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ g f8951i;

        public b(g gVar, c.a.o0.a.a2.e eVar, JSONObject jSONObject, String str, String str2) {
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
            this.f8951i = gVar;
            this.f8947e = eVar;
            this.f8948f = jSONObject;
            this.f8949g = str;
            this.f8950h = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f8951i.F(this.f8947e, this.f8948f, this.f8949g, this.f8950h);
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements StatResponseCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8952e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ HttpUrl f8953f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f8954g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f8955h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ long f8956i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ e f8957j;

        public c(g gVar, String str, HttpUrl httpUrl, String str2, int i2, long j2, e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, str, httpUrl, str2, Integer.valueOf(i2), Long.valueOf(j2), eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8952e = str;
            this.f8953f = httpUrl;
            this.f8954g = str2;
            this.f8955h = i2;
            this.f8956i = j2;
            this.f8957j = eVar;
        }

        @Override // com.baidu.searchbox.http.callback.StatResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
                k.z(this.f8954g, this.f8955h, null, this.f8956i, System.currentTimeMillis());
                if (exc instanceof IOException) {
                    this.f8957j.onFailure(null, (IOException) exc);
                } else {
                    this.f8957j.onFailure(null, new IOException("request fail"));
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
                c.a.o0.a.h0.q.b.g().u(this.f8952e, this.f8953f, networkStatRecord);
                k.z(this.f8954g, this.f8955h, networkStatRecord, this.f8956i, System.currentTimeMillis());
                this.f8957j.onResponse(null, response);
                return response;
            }
            return invokeLIL.objValue;
        }
    }

    /* loaded from: classes.dex */
    public class d implements c.a.o0.a.v2.e1.b<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8958e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ g f8959f;

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
            this.f8959f = gVar;
            this.f8958e = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.o0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.f8959f.d(this.f8958e, new c.a.o0.a.u.h.b(1001, str));
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public c.a.o0.a.a2.e f8960a;

        /* renamed from: b  reason: collision with root package name */
        public JSONObject f8961b;

        /* renamed from: c  reason: collision with root package name */
        public String f8962c;

        /* renamed from: d  reason: collision with root package name */
        public String f8963d;

        /* renamed from: e  reason: collision with root package name */
        public f f8964e;

        /* renamed from: f  reason: collision with root package name */
        public String f8965f;

        /* renamed from: g  reason: collision with root package name */
        public long f8966g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ g f8967h;

        public e(@NonNull g gVar, @NonNull c.a.o0.a.a2.e eVar, @NonNull JSONObject jSONObject, @NonNull String str, String str2, @NonNull f fVar, String str3) {
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
            this.f8967h = gVar;
            this.f8960a = eVar;
            this.f8961b = jSONObject;
            this.f8962c = str;
            this.f8963d = str2;
            this.f8964e = fVar;
            this.f8965f = str3;
            this.f8966g = System.currentTimeMillis();
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, call, iOException) == null) {
                if (c.a.o0.a.u.c.d.f8699c) {
                    String str = "onFailure: " + iOException.getMessage();
                }
                int G = this.f8960a.N().G();
                String l = k.l();
                String h2 = q0.n().h();
                SwanAppNetworkUtils.a(c.a.o0.m.e.a.g().getOkHttpClient(), this.f8963d);
                this.f8967h.d(this.f8965f, new c.a.o0.a.u.h.b(1001, iOException.getMessage()));
                k.K(0, this.f8962c, G, iOException.getMessage(), l, h2, this.f8966g, System.currentTimeMillis());
            }
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, call, response) == null) {
                if (!k.n(this.f8962c)) {
                    c.a.o0.a.l2.b.l().x(this.f8962c, response.headers("Set-cookie"));
                }
                String B = g.B(this.f8961b);
                String D = g.D(this.f8961b);
                int G = this.f8960a.N().G();
                long currentTimeMillis = System.currentTimeMillis();
                String l = k.l();
                String h2 = q0.n().h();
                try {
                    long C = g.C(response);
                    if (C <= 10485760) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("statusCode", response.code());
                        jSONObject.put("header", h.g(response.headers()));
                        g.J(jSONObject, response.body(), B, D);
                        if (this.f8964e != null) {
                            this.f8964e.a(jSONObject);
                        }
                        this.f8967h.d(this.f8965f, new c.a.o0.a.u.h.b(0, jSONObject, true));
                    } else {
                        g.K(this.f8960a, this.f8962c, C, currentTimeMillis);
                        this.f8967h.d(this.f8965f, new c.a.o0.a.u.h.b(201, "response json length over limits"));
                    }
                } catch (IOException | JSONException e2) {
                    if (c.a.o0.a.u.c.d.f8699c) {
                        Log.getStackTraceString(e2);
                    }
                    this.f8967h.d(this.f8965f, new c.a.o0.a.u.h.b(201, e2.getMessage()));
                }
                int code = response.code();
                String message = response.message();
                if (c.a.o0.a.u.c.d.f8699c) {
                    String str = "onResponse: respCode: " + code + ", url=" + this.f8962c + ", msg=" + message;
                }
                if (c.a.o0.a.u.c.d.f8699c) {
                    response.headers().toString();
                }
                k.K(code, this.f8962c, G, message, l, h2, this.f8966g, System.currentTimeMillis());
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1416755251, "Lc/a/o0/a/u/e/j/g;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1416755251, "Lc/a/o0/a/u/e/j/g;");
                return;
            }
        }
        f8943d = Sets.newHashSet(HttpOptions.METHOD_NAME, "GET", "HEAD", "POST", HttpPut.METHOD_NAME, HttpDelete.METHOD_NAME, HttpTrace.METHOD_NAME, "CONNECT");
        f8944e = Sets.newHashSet("json", "string");
        f8945f = Sets.newHashSet("text", "arraybuffer");
        f8946g = Sets.newHashSet("REFERER", "USER-AGENT");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(@NonNull c.a.o0.a.u.c.b bVar) {
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
                super((c.a.o0.a.u.c.b) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @NonNull
    public static String B(@NonNull JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) {
            String optString = jSONObject.optString("dataType");
            return TextUtils.isEmpty(optString) ? "json" : !f8944e.contains(optString) ? "string" : optString;
        }
        return (String) invokeL.objValue;
    }

    public static long C(Response response) {
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
    public static String D(@NonNull JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, jSONObject)) == null) {
            String optString = jSONObject.optString("responseType");
            return !f8945f.contains(optString) ? "text" : optString;
        }
        return (String) invokeL.objValue;
    }

    public static boolean G(String str) {
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

    public static boolean H(String str) {
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

    public static Object I(@NonNull JSONObject jSONObject, @Nullable String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, jSONObject, str)) == null) {
            Object opt = jSONObject.opt("data");
            if (TextUtils.equals(str, "base64")) {
                boolean z = c.a.o0.a.u.c.d.f8699c;
                if (opt instanceof String) {
                    opt = Base64.decode((String) opt, 2);
                } else if (c.a.o0.a.u.c.d.f8699c) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("buildRequest: base64Data is illegal ");
                    sb.append(opt == null);
                    throw new RuntimeException(sb.toString());
                }
            } else if (opt instanceof JsArrayBuffer) {
                boolean z2 = c.a.o0.a.u.c.d.f8699c;
                opt = ((JsArrayBuffer) opt).buffer();
                if (c.a.o0.a.u.c.d.f8699c && opt == null) {
                    throw new RuntimeException("buildRequest: request with a null buffer");
                }
            }
            if (c.a.o0.a.u.c.d.f8699c) {
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
    public static void J(@NonNull JSONObject jSONObject, @Nullable ResponseBody responseBody, @NonNull String str, @NonNull String str2) throws IOException, JSONException {
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
                if (H(str3)) {
                    str3 = G(str3) ? new JSONArray(str3) : new JSONObject(str3);
                }
            } catch (JSONException unused) {
            }
        }
        jSONObject.put("data", str3);
    }

    public static void K(c.a.o0.a.a2.e eVar, String str, long j2, long j3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65545, null, new Object[]{eVar, str, Long.valueOf(j2), Long.valueOf(j3)}) == null) || eVar == null || TextUtils.isEmpty(str) || j2 < 0) {
            return;
        }
        c.a.o0.a.q2.a aVar = new c.a.o0.a.q2.a();
        aVar.j(5L);
        aVar.h(39L);
        c.a.o0.a.j2.p.d dVar = new c.a.o0.a.j2.p.d();
        dVar.p(aVar);
        dVar.r(eVar.L());
        dVar.q(k.m(c.a.o0.a.a2.d.g().l()));
        dVar.m(c.a.o0.a.a2.d.g().getAppId());
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("exceptionUrl", str);
            jSONObject.put("exceptionAppID", eVar.D());
            jSONObject.put("exceptionLength", j2);
            jSONObject.put("exceptionRequestTime", j3);
            jSONObject.put("exceptionResponseTime", System.currentTimeMillis());
            dVar.e(jSONObject);
        } catch (JSONException e2) {
            if (c.a.o0.a.u.c.d.f8699c) {
                e2.printStackTrace();
            }
        }
        k.L(dVar);
    }

    public static void O(String str, @NonNull HttpRequestBuilder httpRequestBuilder, @Nullable JSONObject jSONObject, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65546, null, str, httpRequestBuilder, jSONObject, map) == null) {
            if (jSONObject != null && jSONObject.length() >= 1) {
                Iterator<String> keys = jSONObject.keys();
                String str2 = "";
                while (keys.hasNext()) {
                    String next = keys.next();
                    if (!TextUtils.isEmpty(next) && !f8946g.contains(next.toUpperCase())) {
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
                s(httpRequestBuilder, str, str2);
                return;
            }
            s(httpRequestBuilder, str, "");
        }
    }

    @NonNull
    public static c.a.o0.a.u.h.b P(int i2) {
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
                return new c.a.o0.a.u.h.b(i3);
            }
            return new c.a.o0.a.u.h.b(i3, str);
        }
        return (c.a.o0.a.u.h.b) invokeI.objValue;
    }

    public static void s(@NonNull HttpRequestBuilder httpRequestBuilder, String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65549, null, httpRequestBuilder, str, str2) == null) || k.n(str)) {
            return;
        }
        String f2 = c.a.o0.a.l2.b.l().f(str, str2);
        if (TextUtils.isEmpty(f2)) {
            return;
        }
        httpRequestBuilder.setHeader("Cookie", f2);
        if (c.a.o0.a.u.c.d.f8699c) {
            String str3 = "addCookiesToHeader cookie: " + f2;
        }
    }

    @NonNull
    public static HttpUrl t(@NonNull HttpUrl httpUrl, @NonNull Object obj, @Nullable String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65550, null, httpUrl, obj, str)) == null) {
            HttpUrl.Builder newBuilder = httpUrl.newBuilder();
            if (TextUtils.equals("JSONToString", str) && (obj instanceof String)) {
                boolean z = c.a.o0.a.u.c.d.f8699c;
                try {
                    obj = new JSONObject((String) obj);
                } catch (JSONException unused) {
                    if (c.a.o0.a.u.c.d.f8699c) {
                        throw new RuntimeException("appendQueryTo: illegal json str");
                    }
                }
            }
            if (!(obj instanceof JSONObject)) {
                if (c.a.o0.a.u.c.d.f8699c) {
                    String str2 = "appendQueryTo: data cannot be " + obj.getClass().getSimpleName();
                }
                return httpUrl;
            }
            boolean z2 = c.a.o0.a.u.c.d.f8699c;
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
    public static Pair<HttpRequest, Integer> u(@Nullable JSONObject jSONObject, @Nullable String str) {
        InterceptResult invokeLL;
        int i2;
        String str2;
        RequestBody y;
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
                    i2 = c.a.o0.a.b2.a.b.c("request", httpUrl, optString);
                    if (i2 != 0) {
                        return new Pair<>(null, Integer.valueOf(i2));
                    }
                }
                String optString2 = jSONObject.optString("method");
                if (TextUtils.isEmpty(optString2)) {
                    optString2 = "GET";
                }
                String upperCase = optString2.toUpperCase();
                if (!f8943d.contains(upperCase)) {
                    return new Pair<>(null, 4);
                }
                HashMap hashMap = new HashMap();
                c.a.o0.m.d.a aVar = new c.a.o0.m.d.a();
                aVar.f11813b = upperCase;
                HttpRequestBuilder a2 = c.a.o0.m.e.b.a(aVar);
                O(httpUrl, a2, jSONObject.optJSONObject("header"), hashMap);
                a2.setHeader("Referer", h.d());
                if (!TextUtils.isEmpty(optString)) {
                    a2.setHeader("X-SWAN-HOSTSIGN", c.a.o0.a.t1.g.a.b(c.a.o0.a.t1.g.b.h(optString)));
                }
                String optString3 = jSONObject.optString("__requestDataType__");
                Object I = I(jSONObject, optString3);
                if (I instanceof byte[]) {
                    int length = ((byte[]) I).length;
                    str2 = optString3;
                    if (length > 10485760) {
                        if (c.a.o0.a.u.c.d.f8699c) {
                            String str3 = "buildRequest: ArrayBuffer大小超过上限 " + length;
                        }
                        return new Pair<>(null, 3);
                    }
                } else {
                    str2 = optString3;
                }
                boolean z = I != null;
                if (z && !HttpMethod.permitsRequestBody(upperCase)) {
                    f2 = t(f2, I, str2);
                } else {
                    String str4 = str2;
                    if (z || HttpMethod.requiresRequestBody(upperCase)) {
                        y = y(I, hashMap, str4);
                        if (!HttpMethod.requiresRequestBody(upperCase) && y == null) {
                            return new Pair<>(null, Integer.valueOf(i2));
                        }
                        if (a2 instanceof HttpCommonRequestBuilder) {
                            ((HttpCommonRequestBuilder) a2).requestBody(y);
                        }
                        aVar.f11812a = f2.toString();
                        aVar.f11817f = true;
                        aVar.f11818g = false;
                        aVar.f11819h = true;
                        aVar.f11820i = str;
                        aVar.k = 3;
                        c.a.o0.m.e.a.g().t(a2, aVar);
                        HttpRequest build = a2.build();
                        if (!optBoolean) {
                            build = c.a.o0.a.n1.o.c.e(build, "request", optString);
                        }
                        c.a.o0.a.h0.q.b.g().l(str, f2);
                        return new Pair<>(build, Integer.valueOf(i2));
                    }
                }
                y = null;
                if (!HttpMethod.requiresRequestBody(upperCase)) {
                }
                if (a2 instanceof HttpCommonRequestBuilder) {
                }
                aVar.f11812a = f2.toString();
                aVar.f11817f = true;
                aVar.f11818g = false;
                aVar.f11819h = true;
                aVar.f11820i = str;
                aVar.k = 3;
                c.a.o0.m.e.a.g().t(a2, aVar);
                HttpRequest build2 = a2.build();
                if (!optBoolean) {
                }
                c.a.o0.a.h0.q.b.g().l(str, f2);
                return new Pair<>(build2, Integer.valueOf(i2));
            }
            return new Pair<>(null, 0);
        }
        return (Pair) invokeLL.objValue;
    }

    public static RequestBody x(MediaType mediaType, @NonNull byte[] bArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65552, null, mediaType, bArr)) == null) {
            if (c.a.o0.a.u.c.d.f8699c) {
                String str = "createArrayBufferBody: " + bArr.length;
            }
            return RequestBody.create(mediaType, bArr);
        }
        return (RequestBody) invokeLL.objValue;
    }

    @Nullable
    public static RequestBody y(@Nullable Object obj, Map<String, String> map, @Nullable String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65553, null, obj, map, str)) == null) {
            String str2 = map.get("content-type");
            boolean isEmpty = TextUtils.isEmpty(str2);
            String str3 = StringUtil.NULL_STRING;
            if (isEmpty) {
                if (c.a.o0.a.u.c.d.f8699c) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("createBody: content-type: ");
                    sb.append(c.a.o0.a.n1.f.f7552a);
                    sb.append(" data: ");
                    if (obj != null) {
                        str3 = obj.getClass().getSimpleName();
                    }
                    sb.append(str3);
                    sb.toString();
                }
                if (obj instanceof byte[]) {
                    return x(c.a.o0.a.n1.f.f7552a, (byte[]) obj);
                }
                return RequestBody.create(c.a.o0.a.n1.f.f7552a, obj != null ? obj.toString() : "");
            }
            MediaType parse = MediaType.parse(str2);
            if (c.a.o0.a.n1.f.f7552a.equals(parse)) {
                if (c.a.o0.a.u.c.d.f8699c) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("createBody: content-type: ");
                    sb2.append(c.a.o0.a.n1.f.f7552a);
                    sb2.append(" data: ");
                    if (obj != null) {
                        str3 = obj.getClass().getSimpleName();
                    }
                    sb2.append(str3);
                    sb2.toString();
                }
                if (obj instanceof byte[]) {
                    return x(c.a.o0.a.n1.f.f7552a, (byte[]) obj);
                }
                return RequestBody.create(c.a.o0.a.n1.f.f7552a, obj != null ? obj.toString() : "");
            }
            return z(obj, parse, str);
        }
        return (RequestBody) invokeLLL.objValue;
    }

    public static RequestBody z(@Nullable Object obj, MediaType mediaType, @Nullable String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65554, null, obj, mediaType, str)) == null) {
            FormBody.Builder builder = new FormBody.Builder();
            if (obj instanceof byte[]) {
                return x(mediaType, (byte[]) obj);
            }
            if (TextUtils.equals("JSONToString", str) && (obj instanceof String)) {
                boolean z = c.a.o0.a.u.c.d.f8699c;
                try {
                    obj = new JSONObject((String) obj);
                } catch (JSONException unused) {
                    if (c.a.o0.a.u.c.d.f8699c) {
                        throw new RuntimeException("createFormBody: illegal json str");
                    }
                }
            }
            if (obj != null && obj.toString().length() != 0) {
                if (obj instanceof String) {
                    if (c.a.o0.a.u.c.d.f8699c) {
                        String str2 = "createFormBody: content-type: " + mediaType + " data: String";
                    }
                    return RequestBody.create(mediaType, (String) obj);
                }
                if (c.a.o0.a.u.c.d.f8699c) {
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
                return c.a.o0.a.n1.d.a(builder.build(), mediaType);
            }
            boolean z2 = c.a.o0.a.u.c.d.f8699c;
            return builder.build();
        }
        return (RequestBody) invokeLLL.objValue;
    }

    public void A(c.a.o0.a.a2.e eVar, JSONObject jSONObject, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048576, this, eVar, jSONObject, str, str2) == null) {
            if (c.a.o0.a.r1.l.e.l()) {
                F(eVar, jSONObject, str, str2);
            } else {
                ExecutorUtilsExt.postOnElastic(new b(this, eVar, jSONObject, str, str2), "doRequest", 0);
            }
        }
    }

    public final void E(@NonNull c.a.o0.a.a2.e eVar, @NonNull JSONObject jSONObject, @NonNull HttpRequest httpRequest, @NonNull String str, f fVar, @NonNull String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{eVar, jSONObject, httpRequest, str, fVar, str2}) == null) {
            HttpUrl url = httpRequest.getOkRequest().url();
            String httpUrl = url.toString();
            if (w(eVar, jSONObject, httpUrl, str, fVar, str2)) {
                return;
            }
            httpRequest.executeStat(new c(this, str, url, httpUrl, eVar.N().G(), System.currentTimeMillis(), new e(this, eVar, jSONObject, httpUrl, str, fVar, str2)));
        }
    }

    public final void F(c.a.o0.a.a2.e eVar, JSONObject jSONObject, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, eVar, jSONObject, str, str2) == null) {
            Pair<HttpRequest, Integer> u = u(jSONObject, str);
            HttpRequest httpRequest = (HttpRequest) u.first;
            if (httpRequest == null) {
                d(str2, P(((Integer) u.second).intValue()));
            } else {
                E(eVar, jSONObject, httpRequest, str, null, str2);
            }
        }
    }

    public c.a.o0.a.u.h.b L(JsObject jsObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, jsObject)) == null) {
            Pair<c.a.o0.a.u.h.a, JSONObject> n = c.a.o0.a.u.c.d.n(jsObject);
            if (!((c.a.o0.a.u.h.a) n.first).isSuccess()) {
                return (c.a.o0.a.u.h.b) n.first;
            }
            JSONObject jSONObject = (JSONObject) n.second;
            if (jSONObject == null) {
                return (c.a.o0.a.u.h.b) c.a.o0.a.u.h.a.f9140a;
            }
            if (c.a.o0.a.u.c.d.f8699c) {
                String str = "request with JsObject => JSONObject : " + jSONObject.toString();
            }
            c.a.o0.a.a2.e i2 = c.a.o0.a.a2.e.i();
            if (i2 == null) {
                return new c.a.o0.a.u.h.b(1001, "swan app is null");
            }
            String optString = jSONObject.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                c.a.o0.a.e0.d.b("Api-Request", "callback is null");
                return new c.a.o0.a.u.h.b(1001, "callback is null");
            }
            return M(i2, jSONObject, optString);
        }
        return (c.a.o0.a.u.h.b) invokeL.objValue;
    }

    public final c.a.o0.a.u.h.b M(@NonNull c.a.o0.a.a2.e eVar, @NonNull JSONObject jSONObject, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048580, this, eVar, jSONObject, str)) == null) {
            if (TextUtils.isEmpty(jSONObject.optString("url"))) {
                c.a.o0.a.e0.d.b("Api-Request", "illegal url");
                return new c.a.o0.a.u.h.b(1001, "illegal url");
            }
            String a2 = h.a(eVar.f4530f);
            JSONObject c2 = h.c(a2);
            c.a.o0.a.u.f.a.d().c(new c.a.o0.a.u.f.b.g.c(this, eVar, jSONObject, a2, str));
            return new c.a.o0.a.u.h.b(0, c2);
        }
        return (c.a.o0.a.u.h.b) invokeLLL.objValue;
    }

    public c.a.o0.a.u.h.b N(@NonNull JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, jSONObject)) == null) {
            if (c.a.o0.a.u.c.d.f8699c) {
                String str = "request with JSONObject: " + jSONObject;
            }
            c.a.o0.a.a2.e i2 = c.a.o0.a.a2.e.i();
            if (i2 == null) {
                return new c.a.o0.a.u.h.b(1001, "swan app is null");
            }
            String optString = jSONObject.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                c.a.o0.a.e0.d.b("Api-Request", "callback is null");
                return new c.a.o0.a.u.h.b(202, "callback is null");
            }
            return M(i2, jSONObject, optString);
        }
        return (c.a.o0.a.u.h.b) invokeL.objValue;
    }

    public c.a.o0.a.u.h.b v(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            boolean z = c.a.o0.a.u.c.d.f8699c;
            return j(str, false, new a(this));
        }
        return (c.a.o0.a.u.h.b) invokeL.objValue;
    }

    public final boolean w(@NonNull c.a.o0.a.a2.e eVar, @NonNull JSONObject jSONObject, @NonNull String str, @NonNull String str2, f fVar, @NonNull String str3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{eVar, jSONObject, str, str2, fVar, str3})) == null) ? c.a.o0.a.c1.a.d().i(eVar, jSONObject, str, str2, new e(this, eVar, jSONObject, str, str2, fVar, str3), new d(this, str3)) : invokeCommon.booleanValue;
    }
}
