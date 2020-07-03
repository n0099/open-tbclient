package com.baidu.swan.mini.a.a;

import android.net.http.Headers;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.v8engine.JsArrayBuffer;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.searchbox.websocket.WebSocketRequest;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.network.f;
import com.baidu.swan.games.network.c.d;
import com.baidu.swan.games.network.c.e;
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
/* loaded from: classes11.dex */
public class c extends a {
    private static final Set<String> bQv = i.O("text", "arraybuffer");
    private static final Set<String> bQt = i.O(HttpOptions.METHOD_NAME, "GET", HttpHead.METHOD_NAME, "POST", HttpPut.METHOD_NAME, HttpDelete.METHOD_NAME, HttpTrace.METHOD_NAME, "CONNECT");

    public c(com.baidu.swan.games.f.b bVar, com.baidu.swan.games.binding.model.c cVar) {
        super(bVar, cVar);
        this.deY = 1;
    }

    public void start() {
        Request aCj;
        if (this.deZ != null && (aCj = aCj()) != null) {
            d(aCj);
        }
    }

    protected void d(Request request) {
        final String k = k(this.deZ);
        final String httpUrl = request.url().toString();
        b.aGt().a(request, new Callback() { // from class: com.baidu.swan.mini.a.a.c.1
            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) {
                if (!response.isSuccessful()) {
                    c.this.j(httpUrl, response.code(), response.message());
                    return;
                }
                try {
                    JSEvent jSEvent = new JSEvent("headersReceived");
                    jSEvent.data = new e(c.this.a(response.headers()));
                    c.this.dispatchEvent(jSEvent);
                } catch (JSONException e) {
                    if (a.DEBUG) {
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
                if (a.DEBUG) {
                    Log.d("SwanMiniRequestTask", "onResponse: id:" + c.this.mTaskId + ",respCode: " + code + ", url=" + httpUrl + ", msg=" + message);
                }
            }

            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException iOException) {
                b.aGt().cancelTag(c.this.mTaskId);
                c.this.j(httpUrl, 0, iOException.getMessage());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(String str, int i, String str2) {
        if (DEBUG) {
            Log.d("SwanMiniRequestTask", "onFailure: " + str2);
        }
        if ("Canceled".equalsIgnoreCase(str2)) {
            str2 = "request:fail abort";
        }
        i(str, i, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, Response response) {
        byte[] bytes;
        if (response != null) {
            try {
                com.baidu.swan.games.network.c.a aVar = new com.baidu.swan.games.network.c.a();
                aVar.statusCode = response.code();
                aVar.header = a(response.headers());
                ResponseBody body = response.body();
                if (body != null && (bytes = body.bytes()) != null) {
                    aVar.data = new JsArrayBuffer(bytes, bytes.length);
                }
                onSuccess(aVar);
            } catch (IOException | JSONException e) {
                if (DEBUG) {
                    Log.d("SwanMiniRequestTask", Log.getStackTraceString(e));
                }
                i(str, -1, e.getMessage());
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
                        Log.d("SwanMiniRequestTask", "onStringResponse = " + dVar.data);
                    }
                }
                onSuccess(dVar);
            } catch (IOException | JSONException e) {
                if (DEBUG) {
                    Log.d("SwanMiniRequestTask", Log.getStackTraceString(e));
                }
                i(str, -1, e.getMessage());
            }
        }
    }

    @NonNull
    private static String k(@NonNull com.baidu.swan.games.binding.model.c cVar) {
        String lowerCase = cVar.optString("responseType").toLowerCase();
        if (!bQv.contains(lowerCase)) {
            return "text";
        }
        return lowerCase;
    }

    private Request aCj() {
        String aCc = aCc();
        if (TextUtils.isEmpty(aCc)) {
            if (DEBUG) {
                Log.d("SwanMiniRequestTask", "buildRequest url =" + aCc);
                return null;
            }
            return null;
        }
        String optString = this.deZ.optString("method");
        if (TextUtils.isEmpty(optString)) {
            optString = "GET";
        }
        String upperCase = optString.toUpperCase();
        if (!bQt.contains(upperCase)) {
            i(aCc, -1, "request:method is invalid");
            return null;
        }
        HashMap hashMap = new HashMap();
        Request.Builder builder = new Request.Builder();
        a(builder, this.deZ.rC(WebSocketRequest.PARAM_KEY_HEADER), (Map<String, String>) hashMap, true);
        if (DEBUG) {
            Log.d("SwanMiniRequestTask", "lowerCaseHeaderMap =" + hashMap);
        }
        String optString2 = this.deZ.optString("data", null);
        JsArrayBuffer a = optString2 == null ? this.deZ.a("data", (JsArrayBuffer) null) : optString2;
        boolean z = a != null;
        if (z && !HttpMethod.permitsRequestBody(upperCase)) {
            return builder.url(aCc).method(upperCase, null).tag(this.mTaskId).build();
        }
        RequestBody c = (z || HttpMethod.requiresRequestBody(upperCase)) ? c(a, hashMap) : null;
        if (HttpMethod.requiresRequestBody(upperCase) && c == null) {
            return null;
        }
        return builder.url(aCc).method(upperCase, c).tag(this.mTaskId).build();
    }

    private RequestBody c(Object obj, Map<String, String> map) {
        String str = map.get(Headers.CONTENT_TYPE);
        MediaType parse = !TextUtils.isEmpty(str) ? MediaType.parse(str) : f.a.cuG;
        if (obj instanceof JsArrayBuffer) {
            byte[] buffer = ((JsArrayBuffer) obj).buffer();
            if (buffer == null) {
                return RequestBody.create(parse, "");
            }
            return RequestBody.create(parse, buffer);
        } else if (obj instanceof String) {
            if (DEBUG) {
                Log.d("SwanMiniRequestTask", "createBody = " + obj);
            }
            return RequestBody.create(parse, (String) obj);
        } else {
            return RequestBody.create(parse, "");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.mini.a.a.a
    public void i(String str, int i, String str2) {
        super.i(str, i, str2);
        com.baidu.swan.games.v.c.a(str, i, str2, SwanAppNetworkUtils.isNetworkConnected(null));
    }
}
