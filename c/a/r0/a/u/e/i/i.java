package c.a.r0.a.u.e.i;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.a.n2.n;
import c.a.r0.a.u.c.d;
import c.a.r0.a.z2.q0;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
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
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
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
public class i extends c.a.r0.a.u.e.i.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static final Set<String> f9107f;

    /* renamed from: g  reason: collision with root package name */
    public static final Set<String> f9108g;

    /* renamed from: h  reason: collision with root package name */
    public static final Set<String> f9109h;

    /* renamed from: i  reason: collision with root package name */
    public static final Set<String> f9110i;

    /* renamed from: j  reason: collision with root package name */
    public static final List<String> f9111j;
    @SuppressLint({"BDOfflineUrl"})
    public static final String[] k;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements d.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i a;

        public a(i iVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = iVar;
        }

        @Override // c.a.r0.a.u.c.d.a
        public c.a.r0.a.u.h.b a(c.a.r0.a.d2.e eVar, JSONObject jSONObject, @Nullable String str) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, eVar, jSONObject, str)) == null) {
                String optString = jSONObject.optString("cancelTag");
                if (TextUtils.isEmpty(optString)) {
                    return new c.a.r0.a.u.h.b(202, "illegal cancelTag");
                }
                i iVar = this.a;
                iVar.q("#cancelRequest cancelTag=" + optString, false);
                SwanAppNetworkUtils.a((i.f9111j.remove(optString) ? c.a.r0.p.e.a.l() : c.a.r0.p.e.a.g()).getOkHttpClient(), optString);
                return c.a.r0.a.u.h.b.f();
            }
            return (c.a.r0.a.u.h.b) invokeLLL.objValue;
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.d2.e f9112e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ JSONObject f9113f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f9114g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f9115h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ i f9116i;

        public b(i iVar, c.a.r0.a.d2.e eVar, JSONObject jSONObject, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar, eVar, jSONObject, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9116i = iVar;
            this.f9112e = eVar;
            this.f9113f = jSONObject;
            this.f9114g = str;
            this.f9115h = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f9116i.N(this.f9112e, this.f9113f, this.f9114g, this.f9115h);
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements StatResponseCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f9117e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ HttpUrl f9118f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f9119g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f9120h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ long f9121i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ e f9122j;

        public c(i iVar, String str, HttpUrl httpUrl, String str2, int i2, long j2, e eVar, HttpRequest httpRequest) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar, str, httpUrl, str2, Integer.valueOf(i2), Long.valueOf(j2), eVar, httpRequest};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9117e = str;
            this.f9118f = httpUrl;
            this.f9119g = str2;
            this.f9120h = i2;
            this.f9121i = j2;
            this.f9122j = eVar;
        }

        @Override // com.baidu.searchbox.http.callback.StatResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
                n.C(this.f9119g, this.f9120h, null, this.f9121i, System.currentTimeMillis(), this.f9117e);
                if (exc instanceof IOException) {
                    this.f9122j.onFailure(null, (IOException) exc);
                } else {
                    this.f9122j.onFailure(null, new IOException("request fail"));
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
                c.a.r0.a.h0.q.b.k().C(this.f9117e, this.f9118f, networkStatRecord);
                n.C(this.f9119g, this.f9120h, networkStatRecord, this.f9121i, System.currentTimeMillis(), this.f9117e);
                this.f9122j.onResponse(null, response);
                return response;
            }
            return invokeLIL.objValue;
        }
    }

    /* loaded from: classes.dex */
    public class d implements c.a.r0.a.z2.g1.c<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f9123e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ i f9124f;

        public d(i iVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9124f = iVar;
            this.f9123e = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.r0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.f9124f.d(this.f9123e, new c.a.r0.a.u.h.b(1001, str));
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public c.a.r0.a.d2.e a;

        /* renamed from: b  reason: collision with root package name */
        public JSONObject f9125b;

        /* renamed from: c  reason: collision with root package name */
        public String f9126c;

        /* renamed from: d  reason: collision with root package name */
        public String f9127d;

        /* renamed from: e  reason: collision with root package name */
        public f f9128e;

        /* renamed from: f  reason: collision with root package name */
        public String f9129f;

        /* renamed from: g  reason: collision with root package name */
        public long f9130g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ i f9131h;

        public e(@NonNull i iVar, @NonNull c.a.r0.a.d2.e eVar, @NonNull JSONObject jSONObject, @NonNull String str, String str2, @NonNull f fVar, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar, eVar, jSONObject, str, str2, fVar, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9131h = iVar;
            this.a = eVar;
            this.f9125b = jSONObject;
            this.f9126c = str;
            this.f9127d = str2;
            this.f9128e = fVar;
            this.f9129f = str3;
            this.f9130g = System.currentTimeMillis();
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, call, iOException) == null) {
                int G = this.a.X().G();
                String l = n.l();
                String f2 = q0.n().f();
                SwanAppNetworkUtils.a((i.f9111j.remove(this.f9127d) ? c.a.r0.p.e.a.l() : c.a.r0.p.e.a.g()).getOkHttpClient(), this.f9127d);
                this.f9131h.d(this.f9129f, new c.a.r0.a.u.h.b(1001, iOException.getMessage()));
                n.Q(0, this.f9126c, G, iOException.getMessage(), l, f2, this.f9130g, System.currentTimeMillis(), this.f9127d);
            }
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, call, response) == null) {
                if (!n.o(this.f9126c)) {
                    c.a.r0.a.p2.b.l().x(this.f9126c, response.headers("Set-cookie"));
                }
                String J = i.J(this.f9125b);
                String L = i.L(this.f9125b);
                int G = this.a.X().G();
                long currentTimeMillis = System.currentTimeMillis();
                String l = n.l();
                String f2 = q0.n().f();
                try {
                    long K = i.K(response);
                    if (K <= 10485760) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put(EnterDxmPayServiceAction.SERVICE_STATUS_CODE, response.code());
                        jSONObject.put("header", j.g(response.headers()));
                        i.R(jSONObject, response.body(), J, L);
                        if (this.f9128e != null) {
                            this.f9128e.a(jSONObject);
                        }
                        this.f9131h.d(this.f9129f, new c.a.r0.a.u.h.b(0, jSONObject, true));
                    } else {
                        this.f9131h.d(this.f9129f, new c.a.r0.a.u.h.b(201, "response json length over limits"));
                        i.S(this.a, this.f9126c, K, currentTimeMillis);
                    }
                } catch (IOException | JSONException e2) {
                    this.f9131h.d(this.f9129f, new c.a.r0.a.u.h.b(201, e2.getMessage()));
                }
                n.Q(response.code(), this.f9126c, G, response.message(), l, f2, this.f9130g, System.currentTimeMillis(), this.f9127d);
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(536516501, "Lc/a/r0/a/u/e/i/i;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(536516501, "Lc/a/r0/a/u/e/i/i;");
                return;
            }
        }
        f9107f = Sets.newHashSet(HttpOptions.METHOD_NAME, "GET", "HEAD", "POST", HttpPut.METHOD_NAME, HttpDelete.METHOD_NAME, HttpTrace.METHOD_NAME, "CONNECT");
        f9108g = Sets.newHashSet("json", "string");
        f9109h = Sets.newHashSet("text", "arraybuffer");
        f9110i = Sets.newHashSet("REFERER");
        f9111j = Collections.synchronizedList(new ArrayList());
        k = new String[]{"https://hmma.baidu.com/mini.gif", "https://eclick.baidu.com/", "https://miniapp-ad.cdn.bcebos.com/", "https://mobads.baidu.com/", "https://als.baidu.com/", "https://wn.pos.baidu.com/"};
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(@NonNull c.a.r0.a.u.c.b bVar) {
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
                super((c.a.r0.a.u.c.b) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public static void A(@NonNull HttpRequestBuilder httpRequestBuilder, String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65538, null, httpRequestBuilder, str, str2) == null) || n.o(str)) {
            return;
        }
        String f2 = c.a.r0.a.p2.b.l().f(str, str2);
        if (TextUtils.isEmpty(f2)) {
            return;
        }
        httpRequestBuilder.setHeader("Cookie", f2);
    }

    @NonNull
    @SuppressLint({"BDThrowableCheck"})
    public static HttpUrl B(@NonNull HttpUrl httpUrl, @NonNull Object obj, @Nullable String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, httpUrl, obj, str)) == null) {
            HttpUrl.Builder newBuilder = httpUrl.newBuilder();
            if (TextUtils.equals("JSONToString", str) && (obj instanceof String)) {
                try {
                    obj = new JSONObject((String) obj);
                } catch (JSONException unused) {
                }
            }
            if (obj instanceof JSONObject) {
                boolean z = false;
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
                        z = true;
                    }
                }
                return z ? newBuilder.build() : httpUrl;
            }
            return httpUrl;
        }
        return (HttpUrl) invokeLLL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:73:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0166  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Pair<HttpRequest, Integer> C(@Nullable JSONObject jSONObject, @Nullable String str) {
        InterceptResult invokeLL;
        c.a.r0.p.e.a g2;
        int i2;
        HttpUrl httpUrl;
        HttpUrl httpUrl2;
        RequestBody G;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, jSONObject, str)) == null) {
            if (jSONObject != null && !TextUtils.isEmpty(str)) {
                HttpUrl f2 = j.f(jSONObject.optString("url"));
                if (f2 == null) {
                    return new Pair<>(null, 0);
                }
                String httpUrl3 = f2.toString();
                if (c.a.r0.a.u1.l.b.a() == 1) {
                    String[] strArr = k;
                    int length = strArr.length;
                    int i3 = 0;
                    while (true) {
                        if (i3 >= length) {
                            z = false;
                            break;
                        } else if (httpUrl3.startsWith(strArr[i3])) {
                            z = true;
                            break;
                        } else {
                            i3++;
                        }
                    }
                    if (z) {
                        f9111j.add(str);
                    }
                    g2 = z ? c.a.r0.p.e.a.l() : c.a.r0.p.e.a.g();
                } else {
                    g2 = c.a.r0.p.e.a.g();
                }
                String optString = jSONObject.optString("__plugin__");
                boolean optBoolean = jSONObject.optBoolean("ping", false);
                if (optBoolean) {
                    i2 = 0;
                } else {
                    i2 = c.a.r0.a.e2.a.b.c("request", httpUrl3, optString);
                    if (i2 != 0) {
                        return new Pair<>(null, Integer.valueOf(i2));
                    }
                }
                String optString2 = jSONObject.optString("method");
                if (TextUtils.isEmpty(optString2)) {
                    optString2 = "GET";
                }
                String upperCase = optString2.toUpperCase();
                if (!f9107f.contains(upperCase)) {
                    return new Pair<>(null, 4);
                }
                HashMap hashMap = new HashMap();
                c.a.r0.p.d.a aVar = new c.a.r0.p.d.a();
                aVar.f11449b = upperCase;
                HttpRequestBuilder b2 = c.a.r0.p.e.b.b(aVar, g2);
                W(httpUrl3, b2, jSONObject.optJSONObject("header"), hashMap);
                b2.setHeader("Referer", j.d());
                if (!TextUtils.isEmpty(optString)) {
                    b2.setHeader("X-SWAN-HOSTSIGN", c.a.r0.a.w1.h.a.b(c.a.r0.a.w1.h.b.h(optString)));
                }
                String optString3 = jSONObject.optString("__requestDataType__");
                Object Q = Q(jSONObject, optString3);
                if (Q instanceof byte[]) {
                    httpUrl = f2;
                    if (((byte[]) Q).length > 10485760) {
                        return new Pair<>(null, 3);
                    }
                } else {
                    httpUrl = f2;
                }
                boolean z2 = Q != null;
                if (z2 && !HttpMethod.permitsRequestBody(upperCase)) {
                    httpUrl2 = B(httpUrl, Q, optString3);
                } else {
                    httpUrl2 = httpUrl;
                    if (z2 || HttpMethod.requiresRequestBody(upperCase)) {
                        G = G(Q, hashMap, optString3);
                        if (!HttpMethod.requiresRequestBody(upperCase) && G == null) {
                            return new Pair<>(null, Integer.valueOf(i2));
                        }
                        if (b2 instanceof HttpCommonRequestBuilder) {
                            ((HttpCommonRequestBuilder) b2).requestBody(G);
                        }
                        aVar.a = httpUrl2.toString();
                        aVar.f11453f = X();
                        aVar.f11454g = false;
                        aVar.f11455h = true;
                        aVar.f11456i = str;
                        aVar.k = 3;
                        g2.u(b2, aVar);
                        HttpRequest build = b2.build();
                        if (!optBoolean) {
                            build = c.a.r0.a.p1.o.c.e(build, "request", optString);
                        }
                        c.a.r0.a.h0.q.b.k().r(str, httpUrl2);
                        return new Pair<>(build, Integer.valueOf(i2));
                    }
                }
                G = null;
                if (!HttpMethod.requiresRequestBody(upperCase)) {
                }
                if (b2 instanceof HttpCommonRequestBuilder) {
                }
                aVar.a = httpUrl2.toString();
                aVar.f11453f = X();
                aVar.f11454g = false;
                aVar.f11455h = true;
                aVar.f11456i = str;
                aVar.k = 3;
                g2.u(b2, aVar);
                HttpRequest build2 = b2.build();
                if (!optBoolean) {
                }
                c.a.r0.a.h0.q.b.k().r(str, httpUrl2);
                return new Pair<>(build2, Integer.valueOf(i2));
            }
            return new Pair<>(null, 0);
        }
        return (Pair) invokeLL.objValue;
    }

    public static RequestBody F(MediaType mediaType, @NonNull byte[] bArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, mediaType, bArr)) == null) ? RequestBody.create(mediaType, bArr) : (RequestBody) invokeLL.objValue;
    }

    @Nullable
    public static RequestBody G(@Nullable Object obj, Map<String, String> map, @Nullable String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65542, null, obj, map, str)) == null) {
            String str2 = map.get("content-type");
            if (TextUtils.isEmpty(str2)) {
                if (obj instanceof byte[]) {
                    return F(c.a.r0.a.p1.f.a, (byte[]) obj);
                }
                return RequestBody.create(c.a.r0.a.p1.f.a, obj != null ? obj.toString() : "");
            }
            MediaType parse = MediaType.parse(str2);
            if (c.a.r0.a.p1.f.a.equals(parse)) {
                if (obj instanceof byte[]) {
                    return F(c.a.r0.a.p1.f.a, (byte[]) obj);
                }
                return RequestBody.create(c.a.r0.a.p1.f.a, obj != null ? obj.toString() : "");
            }
            return H(obj, parse, str);
        }
        return (RequestBody) invokeLLL.objValue;
    }

    @SuppressLint({"BDThrowableCheck"})
    public static RequestBody H(@Nullable Object obj, MediaType mediaType, @Nullable String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65543, null, obj, mediaType, str)) == null) {
            FormBody.Builder builder = new FormBody.Builder();
            if (obj instanceof byte[]) {
                return F(mediaType, (byte[]) obj);
            }
            if (TextUtils.equals("JSONToString", str) && (obj instanceof String)) {
                try {
                    obj = new JSONObject((String) obj);
                } catch (JSONException unused) {
                }
            }
            if (obj != null && obj.toString().length() != 0) {
                if (obj instanceof String) {
                    return RequestBody.create(mediaType, (String) obj);
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
                return c.a.r0.a.p1.d.a(builder.build(), mediaType);
            }
            return builder.build();
        }
        return (RequestBody) invokeLLL.objValue;
    }

    @NonNull
    public static String J(@NonNull JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, jSONObject)) == null) {
            String optString = jSONObject.optString("dataType");
            return TextUtils.isEmpty(optString) ? "json" : !f9108g.contains(optString) ? "string" : optString;
        }
        return (String) invokeL.objValue;
    }

    public static long K(Response response) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, response)) == null) {
            if (response.body() != null) {
                return response.body().contentLength();
            }
            return 0L;
        }
        return invokeL.longValue;
    }

    @NonNull
    public static String L(@NonNull JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, jSONObject)) == null) {
            String optString = jSONObject.optString("responseType");
            return !f9109h.contains(optString) ? "text" : optString;
        }
        return (String) invokeL.objValue;
    }

    public static boolean O(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return str.trim().startsWith(PreferencesUtil.LEFT_MOUNT);
        }
        return invokeL.booleanValue;
    }

    public static boolean P(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return (str.trim().startsWith(StringUtil.ARRAY_START) && str.trim().endsWith("}")) || (str.trim().startsWith(PreferencesUtil.LEFT_MOUNT) && str.trim().endsWith(PreferencesUtil.RIGHT_MOUNT));
        }
        return invokeL.booleanValue;
    }

    @SuppressLint({"BDThrowableCheck"})
    public static Object Q(@NonNull JSONObject jSONObject, @Nullable String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65549, null, jSONObject, str)) == null) {
            Object opt = jSONObject.opt("data");
            return TextUtils.equals(str, "base64") ? opt instanceof String ? Base64.decode((String) opt, 2) : opt : opt instanceof JsArrayBuffer ? ((JsArrayBuffer) opt).buffer() : opt;
        }
        return invokeLL.objValue;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v7, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r6v9, types: [org.json.JSONArray] */
    public static void R(@NonNull JSONObject jSONObject, @Nullable ResponseBody responseBody, @NonNull String str, @NonNull String str2) throws IOException, JSONException {
        String str3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(65550, null, jSONObject, responseBody, str, str2) == null) || responseBody == null) {
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
                if (P(str3)) {
                    str3 = O(str3) ? new JSONArray(str3) : new JSONObject(str3);
                }
            } catch (JSONException unused) {
            }
        }
        jSONObject.put("data", str3);
    }

    public static void S(c.a.r0.a.d2.e eVar, String str, long j2, long j3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65551, null, new Object[]{eVar, str, Long.valueOf(j2), Long.valueOf(j3)}) == null) || eVar == null || TextUtils.isEmpty(str) || j2 < 0) {
            return;
        }
        c.a.r0.a.u2.a aVar = new c.a.r0.a.u2.a();
        aVar.k(5L);
        aVar.i(39L);
        c.a.r0.a.n2.s.d dVar = new c.a.r0.a.n2.s.d();
        dVar.p(aVar);
        dVar.r(eVar.V());
        dVar.q(n.n(c.a.r0.a.d2.d.J().l()));
        dVar.m(c.a.r0.a.d2.d.J().getAppId());
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("exceptionUrl", str);
            jSONObject.put("exceptionAppID", eVar.N());
            jSONObject.put("exceptionLength", j2);
            jSONObject.put("exceptionRequestTime", j3);
            jSONObject.put("exceptionResponseTime", System.currentTimeMillis());
            dVar.e(jSONObject);
        } catch (JSONException unused) {
        }
        n.R(dVar);
    }

    public static void W(String str, @NonNull HttpRequestBuilder httpRequestBuilder, @Nullable JSONObject jSONObject, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65552, null, str, httpRequestBuilder, jSONObject, map) == null) {
            if (jSONObject != null && jSONObject.length() >= 1) {
                Iterator<String> keys = jSONObject.keys();
                String str2 = "";
                while (keys.hasNext()) {
                    String next = keys.next();
                    if (!TextUtils.isEmpty(next) && !f9110i.contains(next.toUpperCase())) {
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
                A(httpRequestBuilder, str, str2);
                return;
            }
            A(httpRequestBuilder, str, "");
        }
    }

    public static boolean X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65553, null)) == null) {
            c.a.r0.a.d2.e L = c.a.r0.a.d2.e.L();
            return L == null || !L.d0().f("mapp_set_user_agent");
        }
        return invokeV.booleanValue;
    }

    @NonNull
    public static c.a.r0.a.u.h.b Y(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65554, null, i2)) == null) {
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
                return new c.a.r0.a.u.h.b(i3);
            }
            return new c.a.r0.a.u.h.b(i3, str);
        }
        return (c.a.r0.a.u.h.b) invokeI.objValue;
    }

    public c.a.r0.a.u.h.b D(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            q("#cancelRequest", false);
            return l(str, false, new a(this));
        }
        return (c.a.r0.a.u.h.b) invokeL.objValue;
    }

    public final boolean E(@NonNull c.a.r0.a.d2.e eVar, @NonNull JSONObject jSONObject, @NonNull String str, @NonNull String str2, f fVar, @NonNull String str3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{eVar, jSONObject, str, str2, fVar, str3})) == null) ? c.a.r0.a.c1.a.e().i(eVar, jSONObject, str, str2, new e(this, eVar, jSONObject, str, str2, fVar, str3), new d(this, str3)) : invokeCommon.booleanValue;
    }

    public void I(c.a.r0.a.d2.e eVar, JSONObject jSONObject, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, eVar, jSONObject, str, str2) == null) {
            if (c.a.r0.a.u1.l.e.i()) {
                N(eVar, jSONObject, str, str2);
            } else {
                ExecutorUtilsExt.postOnElastic(new b(this, eVar, jSONObject, str, str2), "doRequest", 0);
            }
        }
    }

    public final void M(@NonNull c.a.r0.a.d2.e eVar, @NonNull JSONObject jSONObject, @NonNull HttpRequest httpRequest, @NonNull String str, f fVar, @NonNull String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{eVar, jSONObject, httpRequest, str, fVar, str2}) == null) {
            HttpUrl url = httpRequest.getOkRequest().url();
            String httpUrl = url.toString();
            if (E(eVar, jSONObject, httpUrl, str, fVar, str2)) {
                return;
            }
            httpRequest.executeStat(new c(this, str, url, httpUrl, eVar.X().G(), System.currentTimeMillis(), new e(this, eVar, jSONObject, httpUrl, str, fVar, str2), httpRequest));
        }
    }

    public final void N(c.a.r0.a.d2.e eVar, JSONObject jSONObject, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048580, this, eVar, jSONObject, str, str2) == null) {
            Pair<HttpRequest, Integer> C = C(jSONObject, str);
            HttpRequest httpRequest = (HttpRequest) C.first;
            if (httpRequest == null) {
                d(str2, Y(((Integer) C.second).intValue()));
            } else {
                M(eVar, jSONObject, httpRequest, str, null, str2);
            }
        }
    }

    public c.a.r0.a.u.h.b T(JsObject jsObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, jsObject)) == null) {
            Pair<c.a.r0.a.u.h.a, JSONObject> t = c.a.r0.a.u.c.d.t(jsObject);
            if (!((c.a.r0.a.u.h.a) t.first).isSuccess()) {
                p("#request parseParams fail", null, false);
                return (c.a.r0.a.u.h.b) t.first;
            }
            JSONObject jSONObject = (JSONObject) t.second;
            if (jSONObject == null) {
                p("#request params parsed as JSONObject is null", null, true);
                return (c.a.r0.a.u.h.b) c.a.r0.a.u.h.a.a;
            }
            c.a.r0.a.d2.e L = c.a.r0.a.d2.e.L();
            if (L == null) {
                p("#request swan app is null", null, false);
                return new c.a.r0.a.u.h.b(1001, "swan app is null");
            }
            String optString = jSONObject.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                p("#request cb is empty", null, true);
                return new c.a.r0.a.u.h.b(1001, "cb is empty");
            }
            return U(L, jSONObject, optString);
        }
        return (c.a.r0.a.u.h.b) invokeL.objValue;
    }

    public final c.a.r0.a.u.h.b U(@NonNull c.a.r0.a.d2.e eVar, @NonNull JSONObject jSONObject, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048582, this, eVar, jSONObject, str)) == null) {
            String optString = jSONObject.optString("url");
            if (TextUtils.isEmpty(optString)) {
                p("#request illegal url", new Exception("stack"), true);
                return new c.a.r0.a.u.h.b(1001, "illegal url");
            }
            q("#request url=" + optString, false);
            String a2 = j.a(eVar.f5537f);
            JSONObject c2 = j.c(a2);
            c.a.r0.a.u.f.a.d().c(new c.a.r0.a.u.f.b.g.c(this, eVar, jSONObject, a2, str));
            return new c.a.r0.a.u.h.b(0, c2);
        }
        return (c.a.r0.a.u.h.b) invokeLLL.objValue;
    }

    public c.a.r0.a.u.h.b V(@NonNull JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, jSONObject)) == null) {
            c.a.r0.a.d2.e a0 = c.a.r0.a.d2.e.a0();
            if (a0 == null) {
                p("#request swan app is null", null, false);
                return new c.a.r0.a.u.h.b(1001, "swan app is null");
            }
            String optString = jSONObject.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                p("#request cb is empty", null, true);
                return new c.a.r0.a.u.h.b(202, "cb is empty");
            }
            return U(a0, jSONObject, optString);
        }
        return (c.a.r0.a.u.h.b) invokeL.objValue;
    }

    @Override // c.a.r0.a.u.c.d
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? "RequestApi" : (String) invokeV.objValue;
    }
}
