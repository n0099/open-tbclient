package com.baidu.swan.games.network.c;

import android.net.http.Headers;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.v8engine.JsArrayBuffer;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.searchbox.websocket.WebSocketRequest;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.network.f;
import com.baidu.swan.apps.statistic.f;
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
/* loaded from: classes10.dex */
public class c extends com.baidu.swan.games.network.a {
    private static final Set<String> bas = i.K("text", "arraybuffer");
    private static final Set<String> baq = i.K(HttpOptions.METHOD_NAME, "GET", HttpHead.METHOD_NAME, "POST", HttpPut.METHOD_NAME, HttpDelete.METHOD_NAME, HttpTrace.METHOD_NAME, "CONNECT");

    public c(com.baidu.swan.games.e.b bVar, com.baidu.swan.games.binding.model.c cVar) {
        super(bVar, cVar);
        this.cma = 1;
    }

    @Override // com.baidu.swan.games.network.a
    public void start() {
        Request amH;
        if (this.cmb != null && (amH = amH()) != null) {
            a(amH);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(Request request) {
        final String k = k(this.cmb);
        final String httpUrl = request.url().toString();
        if (com.baidu.swan.apps.runtime.e.aap() == null) {
            h("", -1, "request:swanApp is null");
            return;
        }
        final long currentTimeMillis = System.currentTimeMillis();
        f.H(httpUrl, 1);
        final com.baidu.swan.games.network.b aaC = com.baidu.swan.apps.runtime.e.aap().aaC();
        aaC.a(request, new Callback() { // from class: com.baidu.swan.games.network.c.c.1
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
                f.a(code, httpUrl, 1, message, currentTimeMillis, System.currentTimeMillis());
            }

            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException iOException) {
                aaC.cancelTag(c.this.mTaskId);
                c.this.a(httpUrl, 0, iOException.getMessage(), currentTimeMillis);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i, String str2, long j) {
        if (DEBUG) {
            Log.d("RequestTask", "onFailure: " + str2);
        }
        String str3 = "Canceled".equalsIgnoreCase(str2) ? "request:fail abort" : str2;
        h(str, i, str3);
        if (SwanAppNetworkUtils.isNetworkConnected(null)) {
            f.a(i, str, 1, str3, j, System.currentTimeMillis());
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
                h(str, -1, e.getMessage());
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
                h(str, -1, e.getMessage());
            }
        }
    }

    @NonNull
    private static String k(@NonNull com.baidu.swan.games.binding.model.c cVar) {
        String lowerCase = cVar.optString("responseType").toLowerCase();
        if (!bas.contains(lowerCase)) {
            return "text";
        }
        return lowerCase;
    }

    private Request amH() {
        String amA = amA();
        if (TextUtils.isEmpty(amA)) {
            if (DEBUG) {
                Log.d("RequestTask", "buildRequest url =" + amA);
                return null;
            }
            return null;
        }
        String optString = this.cmb.optString("method");
        if (TextUtils.isEmpty(optString)) {
            optString = "GET";
        }
        String upperCase = optString.toUpperCase();
        if (!baq.contains(upperCase)) {
            h(amA, -1, "request:method is invalid");
            return null;
        }
        HashMap hashMap = new HashMap();
        Request.Builder builder = new Request.Builder();
        a(builder, this.cmb.or(WebSocketRequest.PARAM_KEY_HEADER), (Map<String, String>) hashMap, true);
        if (DEBUG) {
            Log.d("RequestTask", "lowerCaseHeaderMap =" + hashMap);
        }
        String optString2 = this.cmb.optString("data", null);
        JsArrayBuffer a = optString2 == null ? this.cmb.a("data", (JsArrayBuffer) null) : optString2;
        boolean z = a != null;
        if (z && !HttpMethod.permitsRequestBody(upperCase)) {
            return builder.url(amA).method(upperCase, null).tag(this.mTaskId).build();
        }
        RequestBody b = (z || HttpMethod.requiresRequestBody(upperCase)) ? b(a, hashMap) : null;
        if (HttpMethod.requiresRequestBody(upperCase) && b == null) {
            return null;
        }
        return builder.url(amA).method(upperCase, b).tag(this.mTaskId).build();
    }

    @Nullable
    private RequestBody b(Object obj, Map<String, String> map) {
        String str = map.get(Headers.CONTENT_TYPE);
        MediaType parse = !TextUtils.isEmpty(str) ? MediaType.parse(str) : f.a.bCa;
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
    public void h(String str, int i, String str2) {
        super.h(str, i, str2);
        com.baidu.swan.games.u.c.a(str, i, str2, SwanAppNetworkUtils.isNetworkConnected(null));
    }
}
