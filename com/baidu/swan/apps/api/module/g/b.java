package com.baidu.swan.apps.api.module.g;

import android.net.http.Headers;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.util.Pair;
import com.baidu.searchbox.websocket.WebSocketRequest;
import com.baidu.swan.apps.api.a.c;
import com.baidu.swan.apps.as.ai;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.network.f;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.statistic.a.d;
import com.baidu.swan.apps.statistic.f;
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
import okhttp3.Request;
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
/* loaded from: classes11.dex */
public class b extends com.baidu.swan.apps.api.a.c {
    private static final Set<String> beR = i.L(HttpOptions.METHOD_NAME, "GET", HttpHead.METHOD_NAME, "POST", HttpPut.METHOD_NAME, HttpDelete.METHOD_NAME, HttpTrace.METHOD_NAME, "CONNECT");
    private static final Set<String> beS = i.L("json", "string");
    private static final Set<String> beT = i.L("text", "arraybuffer");
    private static final Set<String> beU = i.L("REFERER", "USER-AGENT");

    /* loaded from: classes11.dex */
    public interface a {
        void U(JSONObject jSONObject);
    }

    public b(@NonNull com.baidu.swan.apps.api.a.b bVar) {
        super(bVar);
    }

    public com.baidu.swan.apps.api.b.b fE(String str) {
        if (DEBUG) {
            Log.d("Api-Request", "start request");
        }
        return a(str, true, new c.a() { // from class: com.baidu.swan.apps.api.module.g.b.1
            @Override // com.baidu.swan.apps.api.a.c.a
            public com.baidu.swan.apps.api.b.b a(e eVar, JSONObject jSONObject, String str2) {
                if (TextUtils.isEmpty(jSONObject.optString("url"))) {
                    com.baidu.swan.apps.console.c.e("Api-Request", "illegal url");
                    return new com.baidu.swan.apps.api.b.b(1001, "illegal url");
                }
                String fH = c.fH(eVar.id);
                Pair<Request, Integer> j = b.j(jSONObject, fH);
                Request request = (Request) j.first;
                if (request == null) {
                    return b.this.ea(((Integer) j.second).intValue());
                }
                b.this.a(eVar, jSONObject, request, fH, null, TextUtils.isEmpty(str2) ? "" : str2);
                return new com.baidu.swan.apps.api.b.b(0, c.fJ(fH));
            }
        });
    }

    protected void a(@NonNull final e eVar, @NonNull JSONObject jSONObject, @NonNull Request request, @NonNull final String str, final a aVar, @NonNull final String str2) {
        final String S = S(jSONObject);
        final String T = T(jSONObject);
        final int appFrameType = eVar.GJ().getAppFrameType();
        final String httpUrl = request.url().toString();
        final long currentTimeMillis = System.currentTimeMillis();
        final String afb = f.afb();
        final String page = ai.ahn().getPage();
        final long currentTimeMillis2 = System.currentTimeMillis();
        f.F(httpUrl, appFrameType);
        eVar.acU().a(request, new Callback() { // from class: com.baidu.swan.apps.api.module.g.b.2
            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException iOException) {
                if (com.baidu.swan.apps.api.a.c.DEBUG) {
                    Log.d("Api-Request", "onFailure: " + iOException.getMessage());
                }
                SwanAppNetworkUtils.a(eVar.acU().YZ(), str);
                b.this.a(str2, new com.baidu.swan.apps.api.b.b(1001, iOException.getMessage()));
                if (SwanAppNetworkUtils.isNetworkConnected(null)) {
                    f.a(0, httpUrl, appFrameType, iOException.getMessage(), afb, page, currentTimeMillis2, System.currentTimeMillis());
                }
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) {
                try {
                    long a2 = b.a(response);
                    if (a2 <= 10485760) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("statusCode", response.code());
                        jSONObject2.put(WebSocketRequest.PARAM_KEY_HEADER, c.a(response.headers()));
                        b.a(jSONObject2, response.body(), S, T);
                        if (aVar != null) {
                            aVar.U(jSONObject2);
                        }
                        b.this.a(str2, new com.baidu.swan.apps.api.b.b(0, jSONObject2, true));
                    } else {
                        b.a(eVar, httpUrl, a2, currentTimeMillis);
                        b.this.a(str2, new com.baidu.swan.apps.api.b.b(201, "response json length over limits"));
                    }
                } catch (IOException | JSONException e) {
                    if (com.baidu.swan.apps.api.a.c.DEBUG) {
                        Log.d("Api-Request", Log.getStackTraceString(e));
                    }
                    b.this.a(str2, new com.baidu.swan.apps.api.b.b(201, e.getMessage()));
                }
                int code = response.code();
                String message = response.message();
                if (com.baidu.swan.apps.api.a.c.DEBUG) {
                    Log.d("Api-Request", "onResponse: respCode: " + code + ", url=" + httpUrl + ", msg=" + message);
                }
                if (com.baidu.swan.apps.api.a.c.DEBUG) {
                    Log.d("TAG", response.headers().toString());
                }
                f.a(code, httpUrl, appFrameType, message, afb, page, currentTimeMillis2, System.currentTimeMillis());
            }
        });
    }

    public static Pair<Request, Integer> j(@Nullable JSONObject jSONObject, @Nullable String str) {
        int i;
        RequestBody b;
        if (jSONObject == null || TextUtils.isEmpty(str)) {
            return new Pair<>(null, 0);
        }
        HttpUrl fI = c.fI(jSONObject.optString("url"));
        if (fI == null) {
            return new Pair<>(null, 0);
        }
        String url = fI.url().toString();
        String optString = jSONObject.optString("__plugin__");
        if (jSONObject.optBoolean("ping", false)) {
            i = 0;
        } else {
            i = com.baidu.swan.apps.aj.a.b.D("request", url, optString);
            if (i != 0) {
                return new Pair<>(null, Integer.valueOf(i));
            }
        }
        String optString2 = jSONObject.optString("method");
        if (!TextUtils.isEmpty(optString2)) {
            optString2 = optString2.toUpperCase();
        }
        optString2 = (TextUtils.isEmpty(optString2) || !beR.contains(optString2)) ? "GET" : "GET";
        HashMap hashMap = new HashMap();
        Request.Builder builder = new Request.Builder();
        a(builder, jSONObject.optJSONObject(WebSocketRequest.PARAM_KEY_HEADER), (Map<String, String>) hashMap, true);
        if (!TextUtils.isEmpty(optString)) {
            builder.addHeader("X-SWAN-HOSTSIGN", com.baidu.swan.apps.ag.g.a.e(com.baidu.swan.apps.ag.g.b.kl(optString)));
        }
        Object opt = jSONObject.opt("data");
        boolean z = opt != null;
        if (z && !HttpMethod.permitsRequestBody(optString2)) {
            fI = a(fI, opt);
            b = null;
        } else {
            b = (z || HttpMethod.requiresRequestBody(optString2)) ? b(opt, hashMap) : null;
        }
        if (HttpMethod.requiresRequestBody(optString2) && b == null) {
            return new Pair<>(null, Integer.valueOf(i));
        }
        return new Pair<>(builder.url(fI).method(optString2, b).tag(str).build(), Integer.valueOf(i));
    }

    private static void a(@NonNull Request.Builder builder, @Nullable JSONObject jSONObject, Map<String, String> map) {
        if (jSONObject != null && jSONObject.length() >= 1) {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (!TextUtils.isEmpty(next) && !beU.contains(next.toUpperCase())) {
                    String mT = ai.mT(jSONObject.optString(next));
                    if (TextUtils.isEmpty(mT)) {
                        mT = "";
                    }
                    if (map != null) {
                        map.put(next.toLowerCase(), mT);
                    }
                    builder.header(next, mT);
                }
            }
        }
    }

    public static void a(@NonNull Request.Builder builder, @Nullable JSONObject jSONObject, Map<String, String> map, boolean z) {
        a(builder, jSONObject, map);
        if (z) {
            builder.header("Referer", c.JW());
        }
    }

    @NonNull
    private static HttpUrl a(@NonNull HttpUrl httpUrl, @NonNull Object obj) {
        HttpUrl.Builder newBuilder = httpUrl.newBuilder();
        if (obj instanceof JSONObject) {
            boolean z = false;
            Iterator<String> keys = ((JSONObject) obj).keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (!TextUtils.isEmpty(next)) {
                    String optString = ((JSONObject) obj).optString(next);
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

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.swan.apps.api.b.b ea(int i) {
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
            default:
                str = "illegal request";
                break;
        }
        if (TextUtils.isEmpty(str)) {
            return new com.baidu.swan.apps.api.b.b(i2);
        }
        return new com.baidu.swan.apps.api.b.b(i2, str);
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
                        if (fF(str3)) {
                            str3 = fG(str3) ? new JSONArray(str3) : new JSONObject(str3);
                        }
                    } catch (JSONException e) {
                    }
                }
                jSONObject.put("data", str3);
            }
        }
    }

    private static boolean fF(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return (str.trim().startsWith("{") && str.trim().endsWith("}")) || (str.trim().startsWith("[") && str.trim().endsWith("]"));
    }

    private static boolean fG(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.trim().startsWith("[");
    }

    public static void a(e eVar, String str, long j, long j2) {
        if (eVar != null && !TextUtils.isEmpty(str) && j >= 0) {
            d lN = new d().e(new com.baidu.swan.apps.ap.a().aI(5L).aJ(39L)).a(eVar.acL()).lM(f.gs(com.baidu.swan.apps.runtime.d.acF().Gz())).lN(com.baidu.swan.apps.runtime.d.acF().getAppId());
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("exceptionUrl", str);
                jSONObject.put("exceptionAppID", eVar.getAppKey());
                jSONObject.put("exceptionLength", j);
                jSONObject.put("exceptionRequestTime", j2);
                jSONObject.put("exceptionResponseTime", System.currentTimeMillis());
                lN.aZ(jSONObject);
            } catch (JSONException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
            f.b(lN);
        }
    }

    @Nullable
    private static RequestBody b(@Nullable Object obj, Map<String, String> map) {
        String str = map.get(Headers.CONTENT_TYPE);
        if (TextUtils.isEmpty(str)) {
            return RequestBody.create(f.a.bGt, obj == null ? "" : obj.toString());
        }
        MediaType parse = MediaType.parse(str);
        if (f.a.bGt.equals(parse)) {
            return RequestBody.create(f.a.bGt, obj == null ? "" : obj.toString());
        }
        return a(obj, parse);
    }

    private static RequestBody a(@Nullable Object obj, MediaType mediaType) {
        FormBody.Builder builder = new FormBody.Builder();
        if (obj == null || obj.toString().length() == 0) {
            return builder.build();
        }
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
        return com.baidu.swan.apps.network.d.a(builder.build(), mediaType);
    }

    @NonNull
    public static String S(@NonNull JSONObject jSONObject) {
        String optString = jSONObject.optString("dataType");
        if (TextUtils.isEmpty(optString)) {
            return "json";
        }
        if (!beS.contains(optString)) {
            return "string";
        }
        return optString;
    }

    @NonNull
    public static String T(@NonNull JSONObject jSONObject) {
        String optString = jSONObject.optString("responseType");
        if (!beT.contains(optString)) {
            return "text";
        }
        return optString;
    }

    public static long a(Response response) {
        if (response.body() == null) {
            return 0L;
        }
        return response.body().contentLength();
    }
}
