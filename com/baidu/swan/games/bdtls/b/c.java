package com.baidu.swan.games.bdtls.b;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
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
/* loaded from: classes7.dex */
public class c extends b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private e bRs;
    private String bRt;
    private Callback dfO;
    private JSONObject dfP;
    private String dfQ;
    private String mHost;
    private String mUrl;
    private int retryCount;

    public c(e eVar, JSONObject jSONObject, String str, Callback callback) {
        this.bRs = eVar;
        this.dfO = callback;
        this.bRt = str;
        bU(jSONObject);
        ss(this.dfP.optString("method"));
    }

    private void bU(JSONObject jSONObject) {
        this.dfP = jSONObject;
        this.mUrl = this.dfP.optString("url");
        JSONObject optJSONObject = this.dfP.optJSONObject("ext");
        if (optJSONObject != null) {
            this.mHost = optJSONObject.optString("customHost");
        }
    }

    private void retry() {
        this.retryCount++;
        request(this.dfQ);
    }

    public void request(String str) {
        this.dfQ = str;
        String str2 = "";
        if (this.dfP != null) {
            str2 = this.dfP.optString("data");
        }
        sq(str2);
    }

    @Override // com.baidu.swan.games.bdtls.b.b
    public void X(byte[] bArr) {
        JSONObject jSONObject;
        JSONException e;
        HttpRequest httpRequest;
        String str;
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject = new JSONObject(this.dfP.toString());
        } catch (JSONException e2) {
            jSONObject = jSONObject2;
            e = e2;
        }
        try {
            Uri parse = Uri.parse(this.mUrl);
            String path = parse.getPath();
            String query = parse.getQuery();
            StringBuilder sb = new StringBuilder((TextUtils.isEmpty(this.mHost) ? "https://mbd.baidu.com/bdtls" : this.mHost + "/bdtls") + "/" + this.dfQ);
            if (TextUtils.isEmpty(path)) {
                path = "";
            }
            sb.append(path).append(TextUtils.isEmpty(query) ? "" : "?" + query);
            if (DEBUG) {
                Log.d("BdtlsRequestApi", "bdtls url is : " + sb.toString());
            }
            JSONObject optJSONObject = jSONObject.optJSONObject(WebSocketRequest.PARAM_KEY_HEADER);
            if (this.dfL) {
                if (TextUtils.equals(getMethod(), "GET")) {
                    str = Base64.encodeToString(bArr, 2);
                } else {
                    str = "Bdtls";
                    jSONObject.putOpt("data", bArr);
                }
                optJSONObject.put("Bdtls", str);
            }
            jSONObject.putOpt(WebSocketRequest.PARAM_KEY_HEADER, optJSONObject);
            jSONObject.putOpt("url", sb.toString());
        } catch (JSONException e3) {
            e = e3;
            if (DEBUG) {
                Log.e("BdtlsRequestApi", "Bdtls request data is invalid", e);
            }
            httpRequest = (HttpRequest) com.baidu.swan.apps.api.module.network.b.q(jSONObject, this.bRt).first;
            if (httpRequest == null) {
                this.dfO.onFailure(null, new IOException("request build fail, maybe your url is invalid"));
            }
            a(httpRequest);
        }
        httpRequest = (HttpRequest) com.baidu.swan.apps.api.module.network.b.q(jSONObject, this.bRt).first;
        if (httpRequest == null && this.dfO != null) {
            this.dfO.onFailure(null, new IOException("request build fail, maybe your url is invalid"));
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
                    if (c.this.dfO != null) {
                        if (exc instanceof IOException) {
                            c.this.dfO.onFailure(null, (IOException) exc);
                        } else {
                            c.this.dfO.onFailure(null, new IOException(exc));
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
            com.baidu.swan.games.bdtls.e.aCy().aCz().iP(0);
            if (com.baidu.swan.games.bdtls.e.aCy().aCz().aDA()) {
                com.baidu.swan.games.bdtls.e.aCy().aCz().aDy();
                gf(true);
                retry();
                return;
            }
            this.dfO.onFailure(call, new IOException("Exceeded the limit of continuous recovery"));
            return;
        }
        com.baidu.swan.games.bdtls.e.aCy().aCz().aDB();
        if (this.dfL) {
            ResponseBody body = response.body();
            String Y = Y(body.bytes());
            if (com.baidu.swan.games.bdtls.a.DEBUG) {
                Log.d("BDTLS", "BdtlsPostRequest parseResponse=" + Y);
            }
            if (this.dfM == 1) {
                Buffer buffer = new Buffer();
                buffer.writeString(Y, Charset.forName("utf-8"));
                Response build = response.newBuilder().body(ResponseBody.create(body.contentType(), buffer.size(), buffer)).build();
                if (this.dfO != null) {
                    this.dfO.onResponse(call, build);
                }
                this.retryCount = 0;
            } else if (this.retryCount < 3) {
                retry();
            } else {
                this.dfO.onFailure(call, new IOException("Url or serviceId is invalid"));
                this.retryCount = 0;
            }
        } else if (this.dfO != null) {
            this.dfO.onResponse(call, response);
        }
    }

    @Override // com.baidu.swan.games.bdtls.b.b
    public void iQ(int i) {
        if (com.baidu.swan.games.bdtls.a.DEBUG) {
            Log.d("BdtlsRequestApi", "onRequestError=" + i);
        }
        if (this.dfO != null) {
            this.dfO.onFailure(null, new IOException("request error  code : " + i));
        }
    }

    @Override // com.baidu.swan.games.bdtls.b.b
    public void b(IOException iOException) {
        if (this.dfO != null) {
            this.dfO.onFailure(null, iOException);
        }
    }
}
