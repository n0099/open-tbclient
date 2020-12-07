package com.baidu.swan.games.network.c;

import android.net.http.Headers;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.http.response.ResponseException;
import com.baidu.searchbox.http.statistics.NetworkStatRecord;
import com.baidu.searchbox.v8engine.JsArrayBuffer;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.searchbox.websocket.WebSocketRequest;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.network.f;
import com.baidu.swan.apps.statistic.h;
import com.facebook.common.internal.i;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import okhttp3.Call;
import okhttp3.Callback;
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
/* loaded from: classes25.dex */
public class c extends com.baidu.swan.games.network.a {
    private static final Set<String> cEM = i.N("text", "arraybuffer");
    private static final Set<String> cEK = i.N(HttpOptions.METHOD_NAME, "GET", HttpHead.METHOD_NAME, "POST", HttpPut.METHOD_NAME, HttpDelete.METHOD_NAME, HttpTrace.METHOD_NAME, "CONNECT");

    public c(com.baidu.swan.games.f.b bVar, com.baidu.swan.games.binding.model.c cVar) {
        super(bVar, cVar);
        this.ecz = 1;
    }

    @Override // com.baidu.swan.games.network.a
    public void start() {
        Request aYS;
        if (this.ecA != null && (aYS = aYS()) != null) {
            d(aYS);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d(Request request) {
        final String k = k(this.ecA);
        final String httpUrl = request.url().toString();
        if (com.baidu.swan.apps.runtime.e.aJU() == null) {
            l("", -1, "request:swanApp is null");
            return;
        }
        final long currentTimeMillis = System.currentTimeMillis();
        h.a(httpUrl, 1, (NetworkStatRecord) null);
        final com.baidu.swan.games.network.b aKj = com.baidu.swan.apps.runtime.e.aJU().aKj();
        aKj.a(request, new Callback() { // from class: com.baidu.swan.games.network.c.c.1
            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) {
                if (!response.isSuccessful()) {
                    c.this.a(httpUrl, response.code(), response.message(), currentTimeMillis);
                    return;
                }
                try {
                    JSEvent jSEvent = new JSEvent("headersReceived");
                    jSEvent.data = new e(c.this.a(response.headers()));
                    c.this.dispatchEvent(jSEvent);
                } catch (JSONException e) {
                    if (c.DEBUG) {
                        e.printStackTrace();
                    }
                }
                String str = k;
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
                h.a(code, httpUrl, 1, message, currentTimeMillis, System.currentTimeMillis());
            }

            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException iOException) {
                aKj.cancelTag(c.this.mTaskId);
                c.this.a(httpUrl, 0, iOException.getMessage(), currentTimeMillis);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i, String str2, long j) {
        if (DEBUG) {
            Log.d("RequestTask", "onFailure: " + str2);
        }
        String str3 = ResponseException.CANCELED.equalsIgnoreCase(str2) ? "request:fail abort" : str2;
        l(str, i, str3);
        if (SwanAppNetworkUtils.isNetworkConnected(null)) {
            h.a(i, str, 1, str3, j, System.currentTimeMillis());
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
                }
                onSuccess(aVar);
            } catch (IOException | JSONException e) {
                if (DEBUG) {
                    Log.d("RequestTask", Log.getStackTraceString(e));
                }
                l(str, -1, e.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str, Response response) {
        if (response != null) {
            ResponseBody body = response.body();
            try {
                d dVar = new d();
                dVar.statusCode = response.code();
                dVar.header = a(response.headers());
                if (body != null) {
                    dVar.data = body.string();
                    if (DEBUG) {
                        Log.d("RequestTask", "onStringResponse = " + dVar.data);
                    }
                }
                onSuccess(dVar);
            } catch (IOException | JSONException e) {
                if (DEBUG) {
                    Log.d("RequestTask", Log.getStackTraceString(e));
                }
                l(str, -1, e.getMessage());
            }
        }
    }

    @NonNull
    private static String k(@NonNull com.baidu.swan.games.binding.model.c cVar) {
        String lowerCase = cVar.optString("responseType").toLowerCase();
        if (!cEM.contains(lowerCase)) {
            return "text";
        }
        return lowerCase;
    }

    private Request aYS() {
        String aYL = aYL();
        if (TextUtils.isEmpty(aYL)) {
            if (DEBUG) {
                Log.d("RequestTask", "buildRequest url =" + aYL);
                return null;
            }
            return null;
        }
        String optString = this.ecA.optString("method");
        if (TextUtils.isEmpty(optString)) {
            optString = "GET";
        }
        String upperCase = optString.toUpperCase();
        if (!cEK.contains(upperCase)) {
            l(aYL, -1, "request:method is invalid");
            return null;
        }
        HashMap hashMap = new HashMap();
        Request.Builder builder = new Request.Builder();
        a(builder, this.ecA.xh(WebSocketRequest.PARAM_KEY_HEADER), (Map<String, String>) hashMap, true);
        if (DEBUG) {
            Log.d("RequestTask", "lowerCaseHeaderMap =" + hashMap);
        }
        String optString2 = this.ecA.optString("data", null);
        JsArrayBuffer a2 = optString2 == null ? this.ecA.a("data", (JsArrayBuffer) null) : optString2;
        boolean z = a2 != null;
        if (z && !HttpMethod.permitsRequestBody(upperCase)) {
            return builder.url(aYL).method(upperCase, null).tag(this.mTaskId).build();
        }
        RequestBody c = (z || HttpMethod.requiresRequestBody(upperCase)) ? c(a2, hashMap) : null;
        if (HttpMethod.requiresRequestBody(upperCase) && c == null) {
            return null;
        }
        return builder.url(aYL).method(upperCase, c).tag(this.mTaskId).build();
    }

    @Nullable
    private RequestBody c(Object obj, Map<String, String> map) {
        String str = map.get(Headers.CONTENT_TYPE);
        MediaType parse = !TextUtils.isEmpty(str) ? MediaType.parse(str) : f.a.dmt;
        if (obj instanceof JsArrayBuffer) {
            byte[] buffer = ((JsArrayBuffer) obj).buffer();
            if (buffer == null) {
                return RequestBody.create(parse, "");
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.games.network.a
    public void l(String str, int i, String str2) {
        super.l(str, i, str2);
        com.baidu.swan.games.v.c.a(str, i, str2, SwanAppNetworkUtils.isNetworkConnected(null));
    }
}
