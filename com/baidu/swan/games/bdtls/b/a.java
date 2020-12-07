package com.baidu.swan.games.bdtls.b;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.utils.HttpHelper;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.swan.games.bdtls.e;
import com.baidu.swan.games.bdtls.f;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.HashMap;
import okhttp3.Headers;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;
/* loaded from: classes25.dex */
public class a<T> extends b {
    private String dXD = null;
    private String dXE = null;
    private ResponseCallback<T> dXF = null;
    private int mRetryCount;

    static /* synthetic */ int c(a aVar) {
        int i = aVar.mRetryCount;
        aVar.mRetryCount = i + 1;
        return i;
    }

    public void b(String str, String str2, ResponseCallback<T> responseCallback) {
        if (!TextUtils.isEmpty(str)) {
            this.dXD = str;
            this.dXE = str2;
            this.dXF = responseCallback;
            if (com.baidu.swan.games.bdtls.a.DEBUG) {
                Log.d("BDTLS", "requestPost url=" + str);
                Log.d("BDTLS", "requestPost body=" + str2);
            }
            wX(this.dXE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aWI() {
        b(this.dXD, this.dXE, this.dXF);
    }

    @Override // com.baidu.swan.games.bdtls.b.b
    public void aa(byte[] bArr) {
        String str = this.dXD;
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", HttpHelper.CONTENT_JSON);
        if (this.dXI) {
            hashMap.put("Bdtls", "Bdtls");
        }
        if (com.baidu.swan.games.bdtls.a.DEBUG) {
            Log.d("BDTLS", "BdtlsPostRequest url=" + str);
        }
        com.baidu.swan.a.c.a.bdi().postByteRequest().mediaType(HttpHelper.CONTENT_JSON).url(str).cookieManager(com.baidu.swan.apps.t.a.azz().akJ()).headers(hashMap).content(bArr).build().executeAsync(new ResponseCallback<String>() { // from class: com.baidu.swan.games.bdtls.b.a.1
            T dXG;

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            public String parseResponse(Response response, int i) throws Exception {
                Headers headers = response.headers();
                if (headers != null && TextUtils.equals(headers.get("Bdtls"), "recovery")) {
                    e.aVy().aVz().mv(0);
                    return "recovery";
                } else if (!a.this.dXI) {
                    if (a.this.dXF != null) {
                        this.dXG = (T) a.this.dXF.parseResponse(response, i);
                        return "";
                    }
                    return "";
                } else {
                    ResponseBody body = response.body();
                    String ab = a.this.ab(body.bytes());
                    if (com.baidu.swan.games.bdtls.a.DEBUG) {
                        Log.d("BDTLS", "BdtlsPostRequest parseResponse=" + ab);
                    }
                    if (a.this.dXJ == 1) {
                        Buffer buffer = new Buffer();
                        buffer.writeString(ab, Charset.forName("utf-8"));
                        Response build = response.newBuilder().body(ResponseBody.create(body.contentType(), buffer.size(), buffer)).build();
                        if (a.this.dXF != null) {
                            this.dXG = (T) a.this.dXF.parseResponse(build, i);
                            return ab;
                        }
                        return ab;
                    }
                    return ab;
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            public void onSuccess(String str2, int i) {
                if (com.baidu.swan.games.bdtls.a.DEBUG) {
                    Log.d("BDTLS", "BdtlsPostRequest onSuccess=" + str2);
                }
                if (TextUtils.equals(str2, "recovery")) {
                    if (!e.aVy().aVz().aWA()) {
                        a.this.dXF.onFail(new Exception("Exceeded the limit of continuous downgrade"));
                        return;
                    }
                    e.aVy().aVz().aWy();
                    a.this.hK(true);
                    a.this.aWI();
                    return;
                }
                e.aVy().aVz().aWB();
                if (!a.this.dXI) {
                    if (a.this.dXF != null) {
                        a.this.dXF.onSuccess(this.dXG, i);
                        a.this.mRetryCount = 0;
                    }
                } else if (a.this.dXJ == 1) {
                    f.wV("application");
                    if (a.this.dXF != null) {
                        a.this.dXF.onSuccess(this.dXG, i);
                    }
                    a.this.mRetryCount = 0;
                } else if (a.c(a.this) < 3) {
                    a.this.b(a.this.dXD, a.this.dXE, a.this.dXF);
                } else {
                    a.this.dXF.onFail(new IOException("request fail : " + this.dXG));
                    a.this.mRetryCount = 0;
                }
            }

            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            public void onFail(Exception exc) {
                if (com.baidu.swan.games.bdtls.a.DEBUG) {
                    Log.d("BDTLS", "BdtlsPostRequest onFail=" + exc.getMessage());
                }
                if (a.this.dXF != null) {
                    a.this.dXF.onFail(exc);
                }
            }
        });
    }

    @Override // com.baidu.swan.games.bdtls.b.b
    public void mw(int i) {
        if (com.baidu.swan.games.bdtls.a.DEBUG) {
            Log.d("BDTLS", "onRequestError=" + i);
        }
        if (this.dXF != null) {
            this.dXF.onFail(new Exception("request error  code : " + i));
        }
    }

    @Override // com.baidu.swan.games.bdtls.b.b
    public void b(IOException iOException) {
        if (this.dXF != null) {
            this.dXF.onFail(iOException);
        }
    }

    @Override // com.baidu.swan.games.bdtls.b.b
    public String getMethod() {
        return "POST";
    }
}
