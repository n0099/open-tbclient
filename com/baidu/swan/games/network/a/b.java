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
import com.baidu.swan.apps.an.aa;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.network.f;
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
public class b extends com.baidu.swan.games.network.a {
    private static final boolean DEBUG = com.baidu.swan.apps.c.DEBUG;
    private static final Set<String> aCr = h.K("text", "arraybuffer");
    private static final Set<String> aCs = h.K(HttpOptions.METHOD_NAME, "GET", HttpHead.METHOD_NAME, "POST", HttpPut.METHOD_NAME, HttpDelete.METHOD_NAME, HttpTrace.METHOD_NAME, "CONNECT");
    private com.baidu.swan.games.binding.model.c bep;
    private String mTaskId = OE();

    public b(JsObject jsObject) {
        this.bep = com.baidu.swan.games.binding.model.c.b(jsObject);
        execute();
    }

    @JavascriptInterface
    public void abort() {
        if (this.bep != null && com.baidu.swan.apps.ae.b.IX() != null) {
            com.baidu.swan.apps.ae.b.IX().Je().cancelTag(this.mTaskId);
        }
    }

    private void execute() {
        if (this.bep != null) {
            if (com.baidu.swan.apps.ae.b.IX() == null) {
                onError("request:swanApp is null");
                return;
            }
            Request OH = OH();
            if (OH != null) {
                final String d = d(this.bep);
                final String httpUrl = OH.url().toString();
                final com.baidu.swan.games.network.b Je = com.baidu.swan.apps.ae.b.IX().Je();
                Je.a(OH, new Callback() { // from class: com.baidu.swan.games.network.a.b.1
                    @Override // okhttp3.Callback
                    public void onResponse(Call call, Response response) {
                        if (!response.isSuccessful()) {
                            b.this.bc(httpUrl, response.message());
                            return;
                        }
                        String str = d;
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
                                b.this.a(response);
                                break;
                            default:
                                b.this.b(response);
                                break;
                        }
                        int code = response.code();
                        String message = response.message();
                        if (b.DEBUG) {
                            Log.d("RequestTask", "onResponse: id:" + b.this.mTaskId + ",respCode: " + code + ", url=" + httpUrl + ", msg=" + message);
                        }
                        com.baidu.swan.apps.statistic.c.a(code, httpUrl, 1, message);
                    }

                    @Override // okhttp3.Callback
                    public void onFailure(Call call, IOException iOException) {
                        Je.cancelTag(b.this.mTaskId);
                        b.this.bc(httpUrl, iOException.getMessage());
                    }
                });
            }
        }
    }

    public void onError(String str) {
        com.baidu.swan.games.binding.model.b bVar = new com.baidu.swan.games.binding.model.b();
        bVar.errMsg = str;
        com.baidu.swan.games.utils.a.a(this.bep, false, bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bc(String str, String str2) {
        if (DEBUG) {
            Log.d("RequestTask", "onFailure: " + str2);
        }
        onError(str2);
        if (SwanAppNetworkUtils.isNetworkConnected(null)) {
            com.baidu.swan.apps.statistic.c.a(0, str, 1, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Response response) {
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
                        Log.d("RequestTask", "onArrayBufferResponse = " + J(bytes));
                    }
                }
                com.baidu.swan.games.utils.a.a(this.bep, true, aVar);
            } catch (IOException | JSONException e) {
                if (DEBUG) {
                    Log.d("RequestTask", Log.getStackTraceString(e));
                }
                onError(e.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Response response) {
        if (response != null) {
            try {
                c cVar = new c();
                cVar.statusCode = response.code();
                cVar.header = a(response.headers());
                ResponseBody body = response.body();
                if (body != null) {
                    cVar.data = body.string();
                    if (DEBUG) {
                        Log.d("RequestTask", "onStringResponse = " + cVar.data);
                    }
                }
                com.baidu.swan.games.utils.a.a(this.bep, true, cVar);
            } catch (IOException | JSONException e) {
                if (DEBUG) {
                    Log.d("RequestTask", Log.getStackTraceString(e));
                }
                onError(e.getMessage());
            }
        }
    }

    @NonNull
    private static String d(@NonNull com.baidu.swan.games.binding.model.c cVar) {
        String lowerCase = cVar.optString("responseType").toLowerCase();
        if (!aCr.contains(lowerCase)) {
            return "text";
        }
        return lowerCase;
    }

    private Request OH() {
        if (this.bep == null || TextUtils.isEmpty(this.mTaskId)) {
            return null;
        }
        String optString = this.bep.optString("url");
        if (DEBUG) {
            Log.d("RequestTask", "buildRequest url =" + optString);
        }
        if (TextUtils.isEmpty(optString)) {
            onError("request:url is invalid");
            return null;
        }
        HttpUrl fo = fo(optString);
        if (fo == null) {
            onError("request:url scheme is invalid");
            return null;
        } else if (!com.baidu.swan.apps.af.a.b.av("request", fo.url().toString())) {
            onError("request:host not in white list");
            return null;
        } else {
            String optString2 = this.bep.optString("method");
            if (TextUtils.isEmpty(optString2)) {
                optString2 = "GET";
            }
            String upperCase = optString2.toUpperCase();
            if (!aCs.contains(upperCase)) {
                onError("request:method is invalid");
                return null;
            }
            HashMap hashMap = new HashMap();
            Request.Builder builder = new Request.Builder();
            a(builder, this.bep.ii(WebSocketRequest.PARAM_KEY_HEADER), hashMap, true);
            if (DEBUG) {
                Log.d("RequestTask", "lowerCaseHeaderMap =" + hashMap);
            }
            String optString3 = this.bep.optString("data", null);
            JsArrayBuffer a = optString3 == null ? this.bep.a("data", (JsArrayBuffer) null) : optString3;
            boolean z = a != null;
            if (z && !HttpMethod.permitsRequestBody(upperCase)) {
                return builder.url(fo).method(upperCase, null).tag(this.mTaskId).build();
            }
            RequestBody a2 = (z || HttpMethod.requiresRequestBody(upperCase)) ? a(a, hashMap) : null;
            if (HttpMethod.requiresRequestBody(upperCase) && a2 == null) {
                return null;
            }
            return builder.url(fo).method(upperCase, a2).tag(this.mTaskId).build();
        }
    }

    private static void a(@NonNull Request.Builder builder, JsObject jsObject, Map<String, String> map) {
        if (jsObject != null && jsObject.length() >= 1) {
            for (int i = 0; i < jsObject.length(); i++) {
                String propertyName = jsObject.getPropertyName(i);
                if (!TextUtils.isEmpty(propertyName) && !aCf.contains(propertyName.toUpperCase())) {
                    String hN = aa.hN(jsObject.toString(i));
                    if (!TextUtils.isEmpty(hN)) {
                        if (map != null) {
                            map.put(propertyName.toLowerCase(), hN);
                        }
                        builder.header(propertyName, hN);
                    }
                }
            }
        }
    }

    private void a(@NonNull Request.Builder builder, JsObject jsObject, Map<String, String> map, boolean z) {
        a(builder, jsObject, map);
        if (z) {
            builder.header("Referer", EY());
        }
    }

    @Nullable
    private RequestBody a(Object obj, Map<String, String> map) {
        String str = map.get(Headers.CONTENT_TYPE);
        MediaType parse = !TextUtils.isEmpty(str) ? MediaType.parse(str) : f.a.aCj;
        if (obj instanceof JsArrayBuffer) {
            byte[] buffer = ((JsArrayBuffer) obj).buffer();
            if (buffer == null) {
                return RequestBody.create(parse, "");
            }
            if (DEBUG) {
                Log.d("RequestTask", "createBody = " + J(buffer));
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

    private String J(byte[] bArr) {
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
