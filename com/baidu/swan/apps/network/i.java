package com.baidu.swan.apps.network;

import android.content.Context;
import android.net.http.Headers;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.searchbox.websocket.WebSocketRequest;
import com.baidu.swan.apps.an.ac;
import com.baidu.swan.apps.network.f;
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
/* loaded from: classes2.dex */
public class i extends a implements f {
    private static final Set<String> aYk = com.facebook.common.internal.h.J("json", "string");
    private static final Set<String> aYl = com.facebook.common.internal.h.J("text", "arraybuffer");
    private static final Set<String> aYm = com.facebook.common.internal.h.J(HttpOptions.METHOD_NAME, "GET", HttpHead.METHOD_NAME, "POST", HttpPut.METHOD_NAME, HttpDelete.METHOD_NAME, HttpTrace.METHOD_NAME, "CONNECT");

    public i(com.baidu.swan.apps.scheme.j jVar) {
        super(jVar, "/swan/request");
    }

    @Override // com.baidu.swan.apps.network.a, com.baidu.swan.apps.scheme.actions.z
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, final com.baidu.swan.apps.ae.b bVar) {
        if (bVar == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "swanApp is null");
            return false;
        }
        JSONObject c = c(unitedSchemeEntity, "params");
        if (c == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "illegal pamas");
            return false;
        }
        final String optString = c.optString("cb");
        if (TextUtils.isEmpty(optString)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "illegal cb");
            return false;
        }
        final String go = go(bVar.id);
        Request j = j(c, go);
        if (j == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "illegal request");
            return false;
        }
        final boolean optBoolean = c.optBoolean("ping", false);
        final String ai = ai(c);
        final String aj = aj(c);
        final int KP = bVar.AK().KP();
        final String httpUrl = j.url().toString();
        bVar.Rh().a(j, new Callback() { // from class: com.baidu.swan.apps.network.i.1
            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException iOException) {
                if (i.DEBUG) {
                    Log.d("RequestAction", "onFailure: " + iOException.getMessage());
                }
                SwanAppNetworkUtils.a(bVar.Rh().MM(), go);
                callbackHandler.handleSchemeDispatchCallback(optString, UnitedSchemeUtility.wrapCallbackParams(1001, iOException.getMessage()).toString());
                if (SwanAppNetworkUtils.isNetworkConnected(null)) {
                    com.baidu.swan.apps.statistic.e.a(0, httpUrl, KP, iOException.getMessage());
                }
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    if (optBoolean) {
                        jSONObject.put("tips", "this is a ping request：" + httpUrl);
                    } else {
                        jSONObject.put("statusCode", response.code());
                        jSONObject.put(WebSocketRequest.PARAM_KEY_HEADER, a.a(response.headers()));
                        i.this.a(jSONObject, response.body(), ai, aj);
                    }
                    callbackHandler.handleSchemeDispatchCallback(optString, UnitedSchemeUtility.wrapCallbackParamsWithEncode(jSONObject, 0).toString());
                } catch (IOException | JSONException e) {
                    if (i.DEBUG) {
                        Log.d("RequestAction", Log.getStackTraceString(e));
                    }
                    callbackHandler.handleSchemeDispatchCallback(optString, UnitedSchemeUtility.wrapCallbackParams(201, e.getMessage()).toString());
                }
                int code = response.code();
                String message = response.message();
                if (i.DEBUG) {
                    Log.d("RequestAction", "onResponse: respCode: " + code + ", url=" + httpUrl + ", msg=" + message);
                }
                com.baidu.swan.apps.statistic.e.a(code, httpUrl, KP, message);
            }
        });
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(gp(go), 0));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0060, code lost:
        if (r9.equals("json") != false) goto L15;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v8, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r1v9, types: [org.json.JSONArray] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(@NonNull JSONObject jSONObject, @Nullable ResponseBody responseBody, @NonNull String str, @NonNull String str2) throws IOException, JSONException {
        boolean z;
        String str3;
        boolean z2 = false;
        if (responseBody != null) {
            switch (str2.hashCode()) {
                case 3556653:
                    if (str2.equals("text")) {
                        z = true;
                        break;
                    }
                    z = true;
                    break;
                case 1154818009:
                    if (str2.equals("arraybuffer")) {
                        z = false;
                        break;
                    }
                    z = true;
                    break;
                default:
                    z = true;
                    break;
            }
            switch (z) {
                case false:
                    byte[] bytes = responseBody.bytes();
                    str3 = bytes == null ? null : new String(Base64.encode(bytes, 2));
                    str = "string";
                    break;
                default:
                    str3 = responseBody.string();
                    break;
            }
            if (!TextUtils.isEmpty(str3)) {
                switch (str.hashCode()) {
                    case -891985903:
                        if (str.equals("string")) {
                            z2 = true;
                            break;
                        }
                        z2 = true;
                        break;
                    case 3271912:
                        break;
                    default:
                        z2 = true;
                        break;
                }
                switch (z2) {
                    case false:
                        try {
                            if (gr(str3)) {
                                str3 = gq(str3) ? new JSONArray(str3) : new JSONObject(str3);
                            }
                            break;
                        } catch (JSONException e) {
                            break;
                        }
                }
                jSONObject.put("data", str3);
            }
        }
    }

    private boolean gq(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.trim().startsWith("[");
    }

    private boolean gr(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return (str.trim().startsWith("{") && str.trim().endsWith("}")) || (str.trim().startsWith("[") && str.trim().endsWith("]"));
    }

    @NonNull
    private static String ai(@NonNull JSONObject jSONObject) {
        String optString = jSONObject.optString("dataType");
        if (TextUtils.isEmpty(optString)) {
            return "json";
        }
        if (!aYk.contains(optString)) {
            return "string";
        }
        return optString;
    }

    @NonNull
    private static String aj(@NonNull JSONObject jSONObject) {
        String optString = jSONObject.optString("responseType");
        if (!aYl.contains(optString)) {
            return "text";
        }
        return optString;
    }

    @Nullable
    private Request j(@Nullable JSONObject jSONObject, @Nullable String str) {
        HttpUrl gn;
        RequestBody b;
        if (jSONObject == null || TextUtils.isEmpty(str) || (gn = gn(jSONObject.optString("url"))) == null) {
            return null;
        }
        gn.url().toString();
        if (!jSONObject.optBoolean("ping", false)) {
        }
        String optString = jSONObject.optString("method");
        if (!TextUtils.isEmpty(optString)) {
            optString = optString.toUpperCase();
        }
        optString = (TextUtils.isEmpty(optString) || !aYm.contains(optString)) ? "GET" : "GET";
        HashMap hashMap = new HashMap();
        Request.Builder builder = new Request.Builder();
        a(builder, jSONObject.optJSONObject(WebSocketRequest.PARAM_KEY_HEADER), (Map<String, String>) hashMap, true);
        Object opt = jSONObject.opt("data");
        boolean z = opt != null;
        if (z && !HttpMethod.permitsRequestBody(optString)) {
            gn = a(gn, opt);
            b = null;
        } else {
            b = (z || HttpMethod.requiresRequestBody(optString)) ? b(opt, hashMap) : null;
        }
        if (HttpMethod.requiresRequestBody(optString) && b == null) {
            return null;
        }
        return builder.url(gn).method(optString, b).tag(str).build();
    }

    private static void a(@NonNull Request.Builder builder, @Nullable JSONObject jSONObject, Map<String, String> map) {
        if (jSONObject != null && jSONObject.length() >= 1) {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (!TextUtils.isEmpty(next) && !aXZ.contains(next.toUpperCase())) {
                    String jd = ac.jd(jSONObject.optString(next));
                    if (TextUtils.isEmpty(jd)) {
                        jd = "";
                    }
                    if (map != null) {
                        map.put(next.toLowerCase(), jd);
                    }
                    builder.header(next, jd);
                }
            }
        }
    }

    private static void a(@NonNull Request.Builder builder, @Nullable JSONObject jSONObject, Map<String, String> map, boolean z) {
        a(builder, jSONObject, map);
        if (z) {
            builder.header("Referer", ML());
        }
    }

    @Nullable
    private static RequestBody b(@Nullable Object obj, Map<String, String> map) {
        String str = map.get(Headers.CONTENT_TYPE);
        if (TextUtils.isEmpty(str)) {
            return RequestBody.create(f.a.aYd, obj == null ? "" : obj.toString());
        }
        MediaType parse = MediaType.parse(str);
        if (f.a.aYd.equals(parse)) {
            return RequestBody.create(f.a.aYd, obj == null ? "" : obj.toString());
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
        return d.a(builder.build(), mediaType);
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
}
