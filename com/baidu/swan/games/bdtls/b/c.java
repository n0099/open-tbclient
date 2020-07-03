package com.baidu.swan.games.bdtls.b;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.baidu.android.imsdk.utils.HttpHelper;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.http.request.HttpRequest;
import com.baidu.searchbox.websocket.WebSocketRequest;
import com.baidu.swan.apps.runtime.e;
import java.io.IOException;
import java.nio.charset.Charset;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class c extends b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private e bQB;
    private String bQC;
    private Callback dad;
    private JSONObject dae;
    private String daf;
    private String mUrl;
    private int retryCount;

    public c(e eVar, JSONObject jSONObject, String str, Callback callback) {
        this.bQB = eVar;
        this.dad = callback;
        this.bQC = str;
        this.dae = jSONObject;
        this.mUrl = this.dae.optString("url");
        rt(this.dae.optString("method"));
    }

    private void retry() {
        this.retryCount++;
        request(this.daf);
    }

    public void request(String str) {
        this.daf = str;
        String str2 = "";
        if (this.dae != null) {
            str2 = this.dae.optString("data");
        }
        rs(str2);
    }

    @Override // com.baidu.swan.games.bdtls.b.b
    public void X(byte[] bArr) {
        JSONObject jSONObject;
        JSONException e;
        HttpRequest httpRequest;
        String str;
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject = new JSONObject(this.dae.toString());
        } catch (JSONException e2) {
            jSONObject = jSONObject2;
            e = e2;
        }
        try {
            Uri parse = Uri.parse(this.mUrl);
            String path = parse.getPath();
            String query = parse.getQuery();
            StringBuilder sb = new StringBuilder("https://mbd.baidu.com/bdtls/" + this.daf);
            if (TextUtils.isEmpty(path)) {
                path = "";
            }
            sb.append(path).append(TextUtils.isEmpty(query) ? "" : "?" + query);
            if (DEBUG) {
                Log.d("BdtlsRequestApi", "bdtls url is : " + sb.toString());
            }
            JSONObject optJSONObject = jSONObject.optJSONObject(WebSocketRequest.PARAM_KEY_HEADER);
            if (this.daa) {
                if (TextUtils.equals(getMethod(), "GET")) {
                    str = Base64.encodeToString(bArr, 2);
                } else {
                    str = "Bdtls";
                    jSONObject.putOpt("data", bArr);
                }
                optJSONObject.put("Bdtls", str);
                optJSONObject.put("Content-Type", HttpHelper.CONTENT_JSON);
            }
            jSONObject.putOpt(WebSocketRequest.PARAM_KEY_HEADER, optJSONObject);
            jSONObject.putOpt("url", sb.toString());
        } catch (JSONException e3) {
            e = e3;
            if (DEBUG) {
                Log.e("BdtlsRequestApi", "Bdtls request data is invalid", e);
            }
            httpRequest = (HttpRequest) com.baidu.swan.apps.api.module.network.b.q(jSONObject, this.bQC).first;
            if (httpRequest == null) {
                this.dad.onFailure(null, new IOException("request build fail, maybe your mUrl is invalid"));
            }
            a(httpRequest);
        }
        httpRequest = (HttpRequest) com.baidu.swan.apps.api.module.network.b.q(jSONObject, this.bQC).first;
        if (httpRequest == null && this.dad != null) {
            this.dad.onFailure(null, new IOException("request build fail, maybe your mUrl is invalid"));
        }
        a(httpRequest);
    }

    private void a(HttpRequest httpRequest) {
        if (httpRequest != null) {
            httpRequest.executeAsync(new ResponseCallback() { // from class: com.baidu.swan.games.bdtls.b.c.1
                @Override // com.baidu.searchbox.http.callback.ResponseCallback
                public Object parseResponse(Response response, int i) throws Exception {
                    c.this.a(null, response);
                    return response;
                }

                @Override // com.baidu.searchbox.http.callback.ResponseCallback
                public void onSuccess(Object obj, int i) {
                }

                @Override // com.baidu.searchbox.http.callback.ResponseCallback
                public void onFail(Exception exc) {
                    if (com.baidu.swan.games.bdtls.a.DEBUG) {
                        Log.d("BDTLS", "Bdtls Request API onFailure = " + exc.getMessage());
                    }
                    if (c.this.dad != null) {
                        if (exc instanceof IOException) {
                            c.this.dad.onFailure(null, (IOException) exc);
                        } else {
                            c.this.dad.onFailure(null, new IOException(exc));
                        }
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Call call, Response response) throws IOException {
        Headers headers = response.headers();
        if (headers != null && TextUtils.equals(headers.get("Bdtls"), "recovery")) {
            com.baidu.swan.games.bdtls.e.ayT().ayU().iy(0);
            if (com.baidu.swan.games.bdtls.e.ayT().ayU().azV()) {
                com.baidu.swan.games.bdtls.e.ayT().ayU().azT();
                fO(true);
                retry();
                return;
            }
            this.dad.onFailure(call, new IOException("Exceeded the limit of continuous recovery"));
            return;
        }
        com.baidu.swan.games.bdtls.e.ayT().ayU().azW();
        if (this.daa) {
            ResponseBody body = response.body();
            String Y = Y(body.bytes());
            if (com.baidu.swan.games.bdtls.a.DEBUG) {
                Log.d("BDTLS", "BdtlsPostRequest parseResponse=" + Y);
            }
            if (this.dab == 1) {
                Buffer buffer = new Buffer();
                buffer.writeString(Y, Charset.forName("utf-8"));
                Response build = response.newBuilder().body(ResponseBody.create(body.contentType(), buffer.size(), buffer)).build();
                if (this.dad != null) {
                    this.dad.onResponse(call, build);
                }
                this.retryCount = 0;
            } else if (this.retryCount < 3) {
                retry();
            } else {
                this.dad.onFailure(call, new IOException("Url or serviceId is invalid"));
                this.retryCount = 0;
            }
        } else if (this.dad != null) {
            this.dad.onResponse(call, response);
        }
    }

    @Override // com.baidu.swan.games.bdtls.b.b
    public void iz(int i) {
        if (com.baidu.swan.games.bdtls.a.DEBUG) {
            Log.d("BdtlsRequestApi", "onRequestError=" + i);
        }
        if (this.dad != null) {
            this.dad.onFailure(null, new IOException("request error  code : " + i));
        }
    }

    @Override // com.baidu.swan.games.bdtls.b.b
    public void b(IOException iOException) {
        if (this.dad != null) {
            this.dad.onFailure(null, iOException);
        }
    }
}
