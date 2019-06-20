package com.baidu.swan.games.network.a;

import android.net.http.Headers;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.JavascriptInterface;
import com.baidu.searchbox.v8engine.JsArrayBuffer;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.searchbox.websocket.WebSocketRequest;
import com.baidu.swan.apps.an.ac;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.network.f;
import com.baidu.swan.apps.statistic.e;
import com.facebook.common.internal.h;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import okhttp3.Call;
import okhttp3.Callback;
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
import org.json.JSONException;
/* loaded from: classes2.dex */
public class c extends com.baidu.swan.games.network.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final Set<String> aEi = h.L("text", "arraybuffer");
    private static final Set<String> aEj = h.L(HttpOptions.METHOD_NAME, "GET", HttpHead.METHOD_NAME, "POST", HttpPut.METHOD_NAME, HttpDelete.METHOD_NAME, HttpTrace.METHOD_NAME, "CONNECT");
    private com.baidu.swan.games.binding.model.c biL;
    private String mTaskId = RH();

    public c(JsObject jsObject) {
        this.biL = com.baidu.swan.games.binding.model.c.c(jsObject);
        execute();
    }

    @JavascriptInterface
    public void abort() {
        if (this.biL != null && com.baidu.swan.apps.ae.b.Lq() != null) {
            com.baidu.swan.apps.ae.b.Lq().Lx().cancelTag(this.mTaskId);
        }
    }

    private void execute() {
        if (this.biL != null) {
            if (com.baidu.swan.apps.ae.b.Lq() == null) {
                e("", -1, "request:swanApp is null");
                return;
            }
            Request RK = RK();
            if (RK != null) {
                final String h = h(this.biL);
                final String httpUrl = RK.url().toString();
                final com.baidu.swan.games.network.b Lx = com.baidu.swan.apps.ae.b.Lq().Lx();
                Lx.a(RK, new Callback() { // from class: com.baidu.swan.games.network.a.c.1
                    @Override // okhttp3.Callback
                    public void onResponse(Call call, Response response) {
                        if (!response.isSuccessful()) {
                            c.this.f(httpUrl, response.code(), response.message());
                            return;
                        }
                        String str = h;
                        char c = 65535;
                        switch (str.hashCode()) {
                            case 3556653:
                                if (str.equals("text")) {
                                    c = 1;
                                    break;
                                }
                                break;
                            case 1154818009:
                                if (str.equals("arraybuffer")) {
                                    c = 0;
                                    break;
                                }
                                break;
                        }
                        switch (c) {
                            case 0:
                                c.this.a(httpUrl, response);
                                break;
                            default:
                                c.this.b(httpUrl, response);
                                break;
                        }
                        int code = response.code();
                        String message = response.message();
                        if (c.DEBUG) {
                            Log.d("RequestTask", "onResponse: id:" + c.this.mTaskId + ",respCode: " + code + ", url=" + httpUrl + ", msg=" + message);
                        }
                        e.a(code, httpUrl, 1, message);
                    }

                    @Override // okhttp3.Callback
                    public void onFailure(Call call, IOException iOException) {
                        Lx.cancelTag(c.this.mTaskId);
                        c.this.f(httpUrl, 0, iOException.getMessage());
                    }
                });
            }
        }
    }

    public void e(String str, int i, String str2) {
        b bVar = new b();
        bVar.errMsg = str2;
        bVar.statusCode = i;
        com.baidu.swan.games.utils.a.a(this.biL, false, bVar);
        com.baidu.swan.games.r.c.a(str, i, str2, SwanAppNetworkUtils.isNetworkConnected(null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(String str, int i, String str2) {
        if (DEBUG) {
            Log.d("RequestTask", "onFailure: " + str2);
        }
        e(str, i, str2);
        if (SwanAppNetworkUtils.isNetworkConnected(null)) {
            e.a(0, str, 1, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, Response response) {
        byte[] bytes;
        if (response != null) {
            try {
                a aVar = new a();
                aVar.statusCode = response.code();
                aVar.header = a(response.headers());
                ResponseBody body = response.body();
                if (body != null && (bytes = body.bytes()) != null) {
                    aVar.data = new JsArrayBuffer(bytes, bytes.length);
                    if (DEBUG) {
                        Log.d("RequestTask", "onArrayBufferResponse = " + D(bytes));
                    }
                }
                com.baidu.swan.games.utils.a.a(this.biL, true, aVar);
            } catch (IOException | JSONException e) {
                if (DEBUG) {
                    Log.d("RequestTask", Log.getStackTraceString(e));
                }
                e(str, -1, e.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str, Response response) {
        if (response != null) {
            try {
                d dVar = new d();
                dVar.statusCode = response.code();
                dVar.header = a(response.headers());
                ResponseBody body = response.body();
                if (body != null) {
                    dVar.data = body.string();
                    if (DEBUG) {
                        Log.d("RequestTask", "onStringResponse = " + dVar.data);
                    }
                }
                com.baidu.swan.games.utils.a.a(this.biL, true, dVar);
            } catch (IOException | JSONException e) {
                if (DEBUG) {
                    Log.d("RequestTask", Log.getStackTraceString(e));
                }
                e(str, -1, e.getMessage());
            }
        }
    }

    @NonNull
    private static String h(@NonNull com.baidu.swan.games.binding.model.c cVar) {
        String lowerCase = cVar.optString("responseType").toLowerCase();
        if (!aEi.contains(lowerCase)) {
            return "text";
        }
        return lowerCase;
    }

    private Request RK() {
        if (this.biL == null || TextUtils.isEmpty(this.mTaskId)) {
            return null;
        }
        String optString = this.biL.optString("url");
        if (DEBUG) {
            Log.d("RequestTask", "buildRequest url =" + optString);
        }
        if (TextUtils.isEmpty(optString)) {
            e("", -1, "request:url is invalid");
            return null;
        }
        HttpUrl fC = fC(optString);
        if (fC == null) {
            e(optString, -1, "request:url scheme is invalid");
            return null;
        }
        String url = fC.url().toString();
        if (!com.baidu.swan.apps.af.a.b.av("request", url)) {
            e(url, -1, "request:host not in white list");
            return null;
        }
        String optString2 = this.biL.optString("method");
        if (TextUtils.isEmpty(optString2)) {
            optString2 = "GET";
        }
        String upperCase = optString2.toUpperCase();
        if (!aEj.contains(upperCase)) {
            e(url, -1, "request:method is invalid");
            return null;
        }
        HashMap hashMap = new HashMap();
        Request.Builder builder = new Request.Builder();
        a(builder, this.biL.iR(WebSocketRequest.PARAM_KEY_HEADER), (Map<String, String>) hashMap, true);
        if (DEBUG) {
            Log.d("RequestTask", "lowerCaseHeaderMap =" + hashMap);
        }
        String optString3 = this.biL.optString("data", null);
        JsArrayBuffer a = optString3 == null ? this.biL.a("data", (JsArrayBuffer) null) : optString3;
        boolean z = a != null;
        if (z && !HttpMethod.permitsRequestBody(upperCase)) {
            return builder.url(fC).method(upperCase, null).tag(this.mTaskId).build();
        }
        RequestBody a2 = (z || HttpMethod.requiresRequestBody(upperCase)) ? a(a, hashMap) : null;
        if (HttpMethod.requiresRequestBody(upperCase) && a2 == null) {
            return null;
        }
        return builder.url(fC).method(upperCase, a2).tag(this.mTaskId).build();
    }

    private static void a(@NonNull Request.Builder builder, JsObject jsObject, Map<String, String> map) {
        if (jsObject != null && jsObject.length() >= 1) {
            for (int i = 0; i < jsObject.length(); i++) {
                String propertyName = jsObject.getPropertyName(i);
                if (!TextUtils.isEmpty(propertyName) && !aDW.contains(propertyName.toUpperCase())) {
                    String ir = ac.ir(jsObject.toString(i));
                    if (!TextUtils.isEmpty(ir)) {
                        if (map != null) {
                            map.put(propertyName.toLowerCase(), ir);
                        }
                        builder.header(propertyName, ir);
                    }
                }
            }
        }
    }

    private void a(@NonNull Request.Builder builder, JsObject jsObject, Map<String, String> map, boolean z) {
        a(builder, jsObject, map);
        if (z) {
            builder.header("Referer", Hb());
        }
        if (jsObject != null) {
            jsObject.release();
        }
    }

    @Nullable
    private RequestBody a(Object obj, Map<String, String> map) {
        String str = map.get(Headers.CONTENT_TYPE);
        MediaType parse = !TextUtils.isEmpty(str) ? MediaType.parse(str) : f.a.aEa;
        if (obj instanceof JsArrayBuffer) {
            byte[] buffer = ((JsArrayBuffer) obj).buffer();
            if (buffer == null) {
                return RequestBody.create(parse, "");
            }
            if (DEBUG) {
                Log.d("RequestTask", "createBody = " + D(buffer));
            }
            return RequestBody.create(parse, buffer);
        } else if (obj instanceof String) {
            if (DEBUG) {
                Log.d("RequestTask", "createBody = " + obj);
            }
            return RequestBody.create(parse, (String) obj);
        } else {
            return RequestBody.create(parse, "");
        }
    }

    private String D(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        if (bArr != null) {
            sb.append("[ ");
            for (int i = 0; i < bArr.length; i++) {
                sb.append(((int) bArr[i]) + " ");
                if (i != 0 && i % 15 == 0) {
                    sb.append("\n");
                }
            }
            sb.append("]");
        }
        return sb.toString();
    }
}
