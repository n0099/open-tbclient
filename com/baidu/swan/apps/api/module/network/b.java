package com.baidu.swan.apps.api.module.network;

import android.net.http.Headers;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.http.callback.StatResponseCallback;
import com.baidu.searchbox.http.request.HttpCommonRequestBuilder;
import com.baidu.searchbox.http.request.HttpRequest;
import com.baidu.searchbox.http.request.HttpRequestBuilder;
import com.baidu.searchbox.http.statistics.NetworkStatRecord;
import com.baidu.searchbox.v8engine.JsArrayBuffer;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.searchbox.websocket.WebSocketRequest;
import com.baidu.swan.apps.ao.ak;
import com.baidu.swan.apps.api.a.d;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.network.f;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.statistic.h;
import com.facebook.common.internal.i;
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
import org.apache.http.client.methods.HttpHead;
import org.apache.http.client.methods.HttpOptions;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpTrace;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class b extends d {
    private static final Set<String> cIK = i.Q(HttpOptions.METHOD_NAME, "GET", HttpHead.METHOD_NAME, "POST", HttpPut.METHOD_NAME, HttpDelete.METHOD_NAME, HttpTrace.METHOD_NAME, "CONNECT");
    private static final Set<String> cIL = i.Q("json", "string");
    private static final Set<String> cIM = i.Q("text", "arraybuffer");
    private static final Set<String> cIN = i.Q("REFERER", "USER-AGENT");

    /* renamed from: com.baidu.swan.apps.api.module.network.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC0391b {
        void aT(JSONObject jSONObject);
    }

    public b(@NonNull com.baidu.swan.apps.api.a.b bVar) {
        super(bVar);
    }

    public com.baidu.swan.apps.api.c.b kT(String str) {
        if (DEBUG) {
            Log.d("Api-Request", "start cancelRequest");
        }
        return a(str, false, new d.a() { // from class: com.baidu.swan.apps.api.module.network.b.1
            @Override // com.baidu.swan.apps.api.a.d.a
            public com.baidu.swan.apps.api.c.b a(e eVar, JSONObject jSONObject, @Nullable String str2) {
                String optString = jSONObject.optString("cancelTag");
                if (TextUtils.isEmpty(optString)) {
                    return new com.baidu.swan.apps.api.c.b(202, "illegal cancelTag");
                }
                SwanAppNetworkUtils.a(com.baidu.swan.a.c.a.bca().getOkHttpClient(), optString);
                return new com.baidu.swan.apps.api.c.b(0);
            }
        });
    }

    public com.baidu.swan.apps.api.c.b aQ(@NonNull JSONObject jSONObject) {
        if (DEBUG) {
            Log.d("Api-Request", "request with JSONObject: " + jSONObject);
        }
        e aIN = e.aIN();
        if (aIN == null) {
            return new com.baidu.swan.apps.api.c.b(1001, "swan app is null");
        }
        String optString = jSONObject.optString("cb");
        if (TextUtils.isEmpty(optString)) {
            com.baidu.swan.apps.console.c.e("Api-Request", "callback is null");
            return new com.baidu.swan.apps.api.c.b(202, "callback is null");
        }
        return b(aIN, jSONObject, optString);
    }

    public com.baidu.swan.apps.api.c.b b(JsObject jsObject) {
        Pair<com.baidu.swan.apps.api.c.a, JSONObject> a2 = a(jsObject);
        if (!((com.baidu.swan.apps.api.c.a) a2.first).isSuccess()) {
            return (com.baidu.swan.apps.api.c.b) a2.first;
        }
        JSONObject jSONObject = (JSONObject) a2.second;
        if (jSONObject == null) {
            return (com.baidu.swan.apps.api.c.b) com.baidu.swan.apps.api.c.a.cKh;
        }
        if (DEBUG) {
            Log.d("Api-Request", "request with JsObject => JSONObject : " + jSONObject.toString());
        }
        e aIN = e.aIN();
        if (aIN == null) {
            return new com.baidu.swan.apps.api.c.b(1001, "swan app is null");
        }
        String optString = jSONObject.optString("cb");
        if (TextUtils.isEmpty(optString)) {
            com.baidu.swan.apps.console.c.e("Api-Request", "callback is null");
            return new com.baidu.swan.apps.api.c.b(1001, "callback is null");
        }
        return b(aIN, jSONObject, optString);
    }

    private com.baidu.swan.apps.api.c.b b(@NonNull e eVar, @NonNull JSONObject jSONObject, String str) {
        if (TextUtils.isEmpty(jSONObject.optString("url"))) {
            com.baidu.swan.apps.console.c.e("Api-Request", "illegal url");
            return new com.baidu.swan.apps.api.c.b(1001, "illegal url");
        }
        String kW = c.kW(eVar.id);
        JSONObject kY = c.kY(kW);
        a(eVar, jSONObject, kW, str);
        return new com.baidu.swan.apps.api.c.b(0, kY);
    }

    private void a(final e eVar, final JSONObject jSONObject, final String str, final String str2) {
        ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.swan.apps.api.module.network.b.2
            @Override // java.lang.Runnable
            public void run() {
                Pair<HttpRequest, Integer> m = b.m(jSONObject, str);
                HttpRequest httpRequest = (HttpRequest) m.first;
                if (httpRequest == null) {
                    b.this.a(str2, b.this.gj(((Integer) m.second).intValue()));
                    return;
                }
                b.this.a(eVar, jSONObject, httpRequest, str, (InterfaceC0391b) null, str2);
            }
        }, "doRequest", 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@NonNull e eVar, @NonNull JSONObject jSONObject, @NonNull HttpRequest httpRequest, @NonNull final String str, InterfaceC0391b interfaceC0391b, @NonNull String str2) {
        final HttpUrl url = httpRequest.getOkRequest().url();
        final String httpUrl = url.toString();
        if (!a(eVar, jSONObject, httpUrl, str, interfaceC0391b, str2)) {
            final int appFrameType = eVar.agc().getAppFrameType();
            if (!com.baidu.swan.apps.t.a.axc().ahp()) {
                h.a(httpUrl, appFrameType, (NetworkStatRecord) null);
            }
            final a aVar = new a(eVar, jSONObject, httpUrl, str, interfaceC0391b, str2);
            httpRequest.executeStat(new StatResponseCallback() { // from class: com.baidu.swan.apps.api.module.network.b.3
                @Override // com.baidu.searchbox.http.callback.StatResponseCallback
                public Object parseResponse(Response response, int i, NetworkStatRecord networkStatRecord) throws Exception {
                    com.baidu.swan.apps.core.i.a.arw().a(str, url, networkStatRecord);
                    if (com.baidu.swan.apps.t.a.axc().ahp()) {
                        h.a(httpUrl, appFrameType, networkStatRecord);
                    }
                    aVar.onResponse(null, response);
                    return response;
                }

                @Override // com.baidu.searchbox.http.callback.StatResponseCallback
                public void onSuccess(Object obj, int i) {
                }

                @Override // com.baidu.searchbox.http.callback.StatResponseCallback
                public void onFail(Exception exc) {
                    if (com.baidu.swan.apps.t.a.axc().ahp()) {
                        h.a(httpUrl, appFrameType, (NetworkStatRecord) null);
                    }
                    if (exc instanceof IOException) {
                        aVar.onFailure(null, (IOException) exc);
                    } else {
                        aVar.onFailure(null, new IOException("request fail"));
                    }
                }
            });
        }
    }

    private boolean a(@NonNull e eVar, @NonNull JSONObject jSONObject, @NonNull String str, @NonNull String str2, InterfaceC0391b interfaceC0391b, @NonNull String str3) {
        JSONObject optJSONObject = jSONObject.optJSONObject("ext");
        if (optJSONObject != null && optJSONObject.optBoolean("enableBdtls", false)) {
            String optString = optJSONObject.optString("serviceId");
            if (TextUtils.isEmpty(optString)) {
                if (DEBUG) {
                    Log.d("Api-Request", "onFailure: serviceId is invalid");
                }
                a(str3, new com.baidu.swan.apps.api.c.b(1001, "serviceId is invalid"));
            } else {
                h.a(str, eVar.agc().getAppFrameType(), (NetworkStatRecord) null);
                new com.baidu.swan.games.bdtls.b.c(eVar, jSONObject, str2, new a(eVar, jSONObject, str, str2, interfaceC0391b, str3)).request(optString);
            }
            return true;
        }
        return false;
    }

    public static Pair<HttpRequest, Integer> m(@Nullable JSONObject jSONObject, @Nullable String str) {
        RequestBody a2;
        int i = 0;
        if (jSONObject == null || TextUtils.isEmpty(str)) {
            return new Pair<>(null, 0);
        }
        HttpUrl kX = c.kX(jSONObject.optString("url"));
        if (kX == null) {
            return new Pair<>(null, 0);
        }
        String url = kX.url().toString();
        String optString = jSONObject.optString("__plugin__");
        boolean optBoolean = jSONObject.optBoolean("ping", false);
        if (!optBoolean && (i = com.baidu.swan.apps.af.a.b.Y("request", url, optString)) != 0) {
            return new Pair<>(null, Integer.valueOf(i));
        }
        int i2 = i;
        String optString2 = jSONObject.optString("method");
        if (TextUtils.isEmpty(optString2)) {
            optString2 = "GET";
        }
        String upperCase = optString2.toUpperCase();
        if (!cIK.contains(upperCase)) {
            return new Pair<>(null, 4);
        }
        HashMap hashMap = new HashMap();
        com.baidu.swan.a.b.a aVar = new com.baidu.swan.a.b.a();
        aVar.method = upperCase;
        HttpRequestBuilder d = com.baidu.swan.a.c.b.d(aVar);
        a(d, jSONObject.optJSONObject(WebSocketRequest.PARAM_KEY_HEADER), hashMap);
        d.setHeader("Referer", c.aki());
        if (!TextUtils.isEmpty(optString)) {
            d.setHeader("X-SWAN-HOSTSIGN", com.baidu.swan.apps.ac.g.a.e(com.baidu.swan.apps.ac.g.b.qX(optString)));
        }
        String optString3 = jSONObject.optString("__requestDataType__");
        Object n = n(jSONObject, optString3);
        if (n instanceof byte[]) {
            int length = ((byte[]) n).length;
            if (length > 10485760) {
                if (DEBUG) {
                    Log.d("Api-Request", "buildRequest: ArrayBuffer大小超过上限 " + length);
                }
                return new Pair<>(null, 3);
            }
        }
        boolean z = n != null;
        if (z && !HttpMethod.permitsRequestBody(upperCase)) {
            kX = a(kX, n, optString3);
            a2 = null;
        } else {
            a2 = (z || HttpMethod.requiresRequestBody(upperCase)) ? a(n, hashMap, optString3) : null;
        }
        if (HttpMethod.requiresRequestBody(upperCase) && a2 == null) {
            return new Pair<>(null, Integer.valueOf(i2));
        }
        if (d instanceof HttpCommonRequestBuilder) {
            ((HttpCommonRequestBuilder) d).requestBody(a2);
        }
        aVar.url = kX.toString();
        aVar.evi = true;
        aVar.evj = false;
        aVar.evk = true;
        aVar.tag = str;
        com.baidu.swan.a.c.a.bca().a(d, aVar);
        HttpRequest build = d.enableStat(true).build();
        if (!optBoolean) {
            build = com.baidu.swan.apps.network.a.c.a(build, "request", optString);
        }
        com.baidu.swan.apps.core.i.a.arw().a(str, kX);
        return new Pair<>(build, Integer.valueOf(i2));
    }

    private static Object n(@NonNull JSONObject jSONObject, @Nullable String str) {
        Object opt = jSONObject.opt("data");
        if (TextUtils.equals(str, "base64")) {
            if (DEBUG) {
                Log.d("Api-Request", "buildRequest: request with base64Data");
            }
            if (opt instanceof String) {
                opt = Base64.decode((String) opt, 2);
            } else if (DEBUG) {
                throw new RuntimeException("buildRequest: base64Data is illegal " + (opt == null));
            }
        } else if (opt instanceof JsArrayBuffer) {
            if (DEBUG) {
                Log.d("Api-Request", "buildRequest: request with arrayBuffer");
            }
            opt = ((JsArrayBuffer) opt).buffer();
            if (DEBUG && opt == null) {
                throw new RuntimeException("buildRequest: request with a null buffer");
            }
        }
        if (DEBUG) {
            Log.d("Api-Request", "parseRequestData: data: " + (opt == null ? "null" : opt.getClass().getSimpleName()) + " requestDataType: " + str);
        }
        return opt;
    }

    private static void a(@NonNull HttpRequestBuilder httpRequestBuilder, @Nullable JSONObject jSONObject, Map<String, String> map) {
        if (jSONObject != null && jSONObject.length() >= 1) {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (!TextUtils.isEmpty(next) && !cIN.contains(next.toUpperCase())) {
                    String uo = ak.uo(jSONObject.optString(next));
                    if (TextUtils.isEmpty(uo)) {
                        uo = "";
                    }
                    if (map != null) {
                        map.put(next.toLowerCase(), uo);
                    }
                    httpRequestBuilder.addHeader(next, uo);
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0060  */
    @NonNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static HttpUrl a(@NonNull HttpUrl httpUrl, @NonNull Object obj, @Nullable String str) {
        Object obj2;
        HttpUrl.Builder newBuilder = httpUrl.newBuilder();
        if (TextUtils.equals("JSONToString", str) && (obj instanceof String)) {
            if (DEBUG) {
                Log.d("Api-Request", "appendQueryTo: hint jsonToString");
            }
            try {
                obj2 = new JSONObject((String) obj);
            } catch (JSONException e) {
                if (DEBUG) {
                    throw new RuntimeException("appendQueryTo: illegal json str");
                }
            }
            if (obj2 instanceof JSONObject) {
                if (DEBUG) {
                    Log.w("Api-Request", "appendQueryTo: data cannot be " + obj2.getClass().getSimpleName());
                    return httpUrl;
                }
                return httpUrl;
            }
            if (DEBUG) {
                Log.d("Api-Request", "appendQueryTo with JSONObject");
            }
            boolean z = false;
            Iterator<String> keys = ((JSONObject) obj2).keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (!TextUtils.isEmpty(next)) {
                    String optString = ((JSONObject) obj2).optString(next);
                    if (TextUtils.isEmpty(optString)) {
                        optString = "";
                    }
                    newBuilder.addQueryParameter(next, optString);
                    z = true;
                }
            }
            return z ? newBuilder.build() : httpUrl;
        }
        obj2 = obj;
        if (obj2 instanceof JSONObject) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.swan.apps.api.c.b gj(int i) {
        String str = "";
        int i2 = 202;
        switch (i) {
            case 0:
                i2 = 0;
                break;
            case 1:
                str = "illegal request";
                break;
            case 2:
                str = "request url header must be https or wss";
                break;
            case 3:
                str = "request:fail parameter error: arrayBuffer of data exceed size limit.";
                break;
            case 4:
                str = "HTTP method is invalid";
                break;
            default:
                str = "illegal request";
                break;
        }
        if (TextUtils.isEmpty(str)) {
            return new com.baidu.swan.apps.api.c.b(i2);
        }
        return new com.baidu.swan.apps.api.c.b(i2, str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v13, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r1v14, types: [org.json.JSONArray] */
    public static void a(@NonNull JSONObject jSONObject, @Nullable ResponseBody responseBody, @NonNull String str, @NonNull String str2) throws IOException, JSONException {
        String str3;
        if (responseBody != null) {
            char c = 65535;
            switch (str2.hashCode()) {
                case 3556653:
                    if (str2.equals("text")) {
                        c = 1;
                        break;
                    }
                    break;
                case 1154818009:
                    if (str2.equals("arraybuffer")) {
                        c = 0;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    byte[] bytes = responseBody.bytes();
                    str3 = bytes == null ? null : new String(Base64.encode(bytes, 2));
                    str = "string";
                    break;
                default:
                    str3 = responseBody.string();
                    break;
            }
            if (!TextUtils.isEmpty(str3)) {
                if (TextUtils.equals(str, "json")) {
                    try {
                        if (kU(str3)) {
                            str3 = kV(str3) ? new JSONArray(str3) : new JSONObject(str3);
                        }
                    } catch (JSONException e) {
                    }
                }
                jSONObject.put("data", str3);
            }
        }
    }

    private static boolean kU(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return (str.trim().startsWith("{") && str.trim().endsWith("}")) || (str.trim().startsWith("[") && str.trim().endsWith("]"));
    }

    private static boolean kV(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.trim().startsWith("[");
    }

    public static void a(e eVar, String str, long j, long j2) {
        if (eVar != null && !TextUtils.isEmpty(str) && j >= 0) {
            com.baidu.swan.apps.statistic.a.d sX = new com.baidu.swan.apps.statistic.a.d().i(new com.baidu.swan.apps.al.a().db(5L).dc(39L)).a(eVar.aIR()).sW(h.jv(com.baidu.swan.apps.runtime.d.aIJ().getFrameType())).sX(com.baidu.swan.apps.runtime.d.aIJ().getAppId());
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("exceptionUrl", str);
                jSONObject.put("exceptionAppID", eVar.getAppKey());
                jSONObject.put("exceptionLength", j);
                jSONObject.put("exceptionRequestTime", j2);
                jSONObject.put("exceptionResponseTime", System.currentTimeMillis());
                sX.cj(jSONObject);
            } catch (JSONException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
            h.b(sX);
        }
    }

    @Nullable
    private static RequestBody a(@Nullable Object obj, Map<String, String> map, @Nullable String str) {
        String str2 = map.get(Headers.CONTENT_TYPE);
        if (TextUtils.isEmpty(str2)) {
            if (DEBUG) {
                Log.d("Api-Request", "createBody: content-type: " + f.a.dqr + " data: " + (obj == null ? "null" : obj.getClass().getSimpleName()));
            }
            if (obj instanceof byte[]) {
                return a(f.a.dqr, (byte[]) obj);
            }
            return RequestBody.create(f.a.dqr, obj == null ? "" : obj.toString());
        }
        MediaType parse = MediaType.parse(str2);
        if (f.a.dqr.equals(parse)) {
            if (DEBUG) {
                Log.d("Api-Request", "createBody: content-type: " + f.a.dqr + " data: " + (obj == null ? "null" : obj.getClass().getSimpleName()));
            }
            if (obj instanceof byte[]) {
                return a(f.a.dqr, (byte[]) obj);
            }
            return RequestBody.create(f.a.dqr, obj == null ? "" : obj.toString());
        }
        return a(obj, parse, str);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0046  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static RequestBody a(@Nullable Object obj, MediaType mediaType, @Nullable String str) {
        JSONObject jSONObject;
        FormBody.Builder builder = new FormBody.Builder();
        if (obj instanceof byte[]) {
            return a(mediaType, (byte[]) obj);
        }
        if (TextUtils.equals("JSONToString", str) && (obj instanceof String)) {
            if (DEBUG) {
                Log.d("Api-Request", "createFormBody: hint jsonToString");
            }
            try {
                jSONObject = new JSONObject((String) obj);
            } catch (JSONException e) {
                if (DEBUG) {
                    throw new RuntimeException("createFormBody: illegal json str");
                }
            }
            if (jSONObject != null || jSONObject.toString().length() == 0) {
                if (DEBUG) {
                    Log.d("Api-Request", "createFormBody: with empty data");
                }
                return builder.build();
            } else if (jSONObject instanceof String) {
                if (DEBUG) {
                    Log.d("Api-Request", "createFormBody: content-type: " + mediaType + " data: String");
                }
                return RequestBody.create(mediaType, (String) jSONObject);
            } else {
                if (DEBUG) {
                    Log.d("Api-Request", "createFormBody: content-type: " + mediaType + " data: " + jSONObject.getClass().getSimpleName());
                }
                if (jSONObject instanceof JSONObject) {
                    JSONObject jSONObject2 = (JSONObject) jSONObject;
                    Iterator<String> keys = jSONObject2.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        if (!TextUtils.isEmpty(next)) {
                            builder.add(next, jSONObject2.optString(next));
                        }
                    }
                }
                return com.baidu.swan.apps.network.d.a(builder.build(), mediaType);
            }
        }
        jSONObject = obj;
        if (jSONObject != null) {
        }
        if (DEBUG) {
        }
        return builder.build();
    }

    private static RequestBody a(MediaType mediaType, @NonNull byte[] bArr) {
        if (DEBUG) {
            Log.d("Api-Request", "createArrayBufferBody: " + bArr.length);
        }
        return RequestBody.create(mediaType, bArr);
    }

    @NonNull
    public static String aR(@NonNull JSONObject jSONObject) {
        String optString = jSONObject.optString("dataType");
        if (TextUtils.isEmpty(optString)) {
            return "json";
        }
        if (!cIL.contains(optString)) {
            return "string";
        }
        return optString;
    }

    @NonNull
    public static String aS(@NonNull JSONObject jSONObject) {
        String optString = jSONObject.optString("responseType");
        if (!cIM.contains(optString)) {
            return "text";
        }
        return optString;
    }

    public static long b(Response response) {
        if (response.body() == null) {
            return 0L;
        }
        return response.body().contentLength();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class a implements Callback {
        e cIT;
        String cIU;
        InterfaceC0391b cIV;
        long cIW = System.currentTimeMillis();
        String mCallback;
        JSONObject mParams;
        String mUrl;

        a(@NonNull e eVar, @NonNull JSONObject jSONObject, @NonNull String str, @NonNull String str2, InterfaceC0391b interfaceC0391b, @NonNull String str3) {
            this.cIT = eVar;
            this.mParams = jSONObject;
            this.mUrl = str;
            this.cIU = str2;
            this.cIV = interfaceC0391b;
            this.mCallback = str3;
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            if (d.DEBUG) {
                Log.d("Api-Request", "onFailure: " + iOException.getMessage());
            }
            int appFrameType = this.cIT.agc().getAppFrameType();
            String aLH = h.aLH();
            String page = ak.aOu().getPage();
            SwanAppNetworkUtils.a(com.baidu.swan.a.c.a.bca().getOkHttpClient(), this.cIU);
            b.this.a(this.mCallback, new com.baidu.swan.apps.api.c.b(1001, iOException.getMessage()));
            h.a(0, this.mUrl, appFrameType, iOException.getMessage(), aLH, page, this.cIW, System.currentTimeMillis());
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) {
            String aR = b.aR(this.mParams);
            String aS = b.aS(this.mParams);
            int appFrameType = this.cIT.agc().getAppFrameType();
            long currentTimeMillis = System.currentTimeMillis();
            String aLH = h.aLH();
            String page = ak.aOu().getPage();
            try {
                long b = b.b(response);
                if (b <= 10485760) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("statusCode", response.code());
                    jSONObject.put(WebSocketRequest.PARAM_KEY_HEADER, c.a(response.headers()));
                    b.a(jSONObject, response.body(), aR, aS);
                    if (this.cIV != null) {
                        this.cIV.aT(jSONObject);
                    }
                    b.this.a(this.mCallback, new com.baidu.swan.apps.api.c.b(0, jSONObject, true));
                } else {
                    b.a(this.cIT, this.mUrl, b, currentTimeMillis);
                    b.this.a(this.mCallback, new com.baidu.swan.apps.api.c.b(201, "response json length over limits"));
                }
            } catch (IOException | JSONException e) {
                if (d.DEBUG) {
                    Log.d("Api-Request", Log.getStackTraceString(e));
                }
                b.this.a(this.mCallback, new com.baidu.swan.apps.api.c.b(201, e.getMessage()));
            }
            int code = response.code();
            String message = response.message();
            if (d.DEBUG) {
                Log.d("Api-Request", "onResponse: respCode: " + code + ", url=" + this.mUrl + ", msg=" + message);
            }
            if (d.DEBUG) {
                Log.d("TAG", response.headers().toString());
            }
            h.a(code, this.mUrl, appFrameType, message, aLH, page, this.cIW, System.currentTimeMillis());
        }
    }
}
