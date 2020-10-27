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
/* loaded from: classes10.dex */
public class a<T> extends b {
    private String dMv = null;
    private String dMw = null;
    private ResponseCallback<T> dMx = null;
    private int mRetryCount;

    static /* synthetic */ int c(a aVar) {
        int i = aVar.mRetryCount;
        aVar.mRetryCount = i + 1;
        return i;
    }

    public void b(String str, String str2, ResponseCallback<T> responseCallback) {
        if (!TextUtils.isEmpty(str)) {
            this.dMv = str;
            this.dMw = str2;
            this.dMx = responseCallback;
            if (com.baidu.swan.games.bdtls.a.DEBUG) {
                Log.d("BDTLS", "requestPost url=" + str);
                Log.d("BDTLS", "requestPost body=" + str2);
            }
            wh(this.dMw);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aRL() {
        b(this.dMv, this.dMw, this.dMx);
    }

    @Override // com.baidu.swan.games.bdtls.b.b
    public void Y(byte[] bArr) {
        String str = this.dMv;
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", HttpHelper.CONTENT_JSON);
        if (this.dMA) {
            hashMap.put("Bdtls", "Bdtls");
        }
        if (com.baidu.swan.games.bdtls.a.DEBUG) {
            Log.d("BDTLS", "BdtlsPostRequest url=" + str);
        }
        com.baidu.swan.a.c.a.aYk().postByteRequest().mediaType(HttpHelper.CONTENT_JSON).url(str).cookieManager(com.baidu.swan.apps.t.a.auz().afJ()).headers(hashMap).content(bArr).build().executeAsync(new ResponseCallback<String>() { // from class: com.baidu.swan.games.bdtls.b.a.1
            T dMy;

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            public String parseResponse(Response response, int i) throws Exception {
                Headers headers = response.headers();
                if (headers != null && TextUtils.equals(headers.get("Bdtls"), "recovery")) {
                    e.aQB().aQC().lR(0);
                    return "recovery";
                } else if (!a.this.dMA) {
                    if (a.this.dMx != null) {
                        this.dMy = (T) a.this.dMx.parseResponse(response, i);
                        return "";
                    }
                    return "";
                } else {
                    ResponseBody body = response.body();
                    String Z = a.this.Z(body.bytes());
                    if (com.baidu.swan.games.bdtls.a.DEBUG) {
                        Log.d("BDTLS", "BdtlsPostRequest parseResponse=" + Z);
                    }
                    if (a.this.dMB == 1) {
                        Buffer buffer = new Buffer();
                        buffer.writeString(Z, Charset.forName("utf-8"));
                        Response build = response.newBuilder().body(ResponseBody.create(body.contentType(), buffer.size(), buffer)).build();
                        if (a.this.dMx != null) {
                            this.dMy = (T) a.this.dMx.parseResponse(build, i);
                            return Z;
                        }
                        return Z;
                    }
                    return Z;
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            public void onSuccess(String str2, int i) {
                if (com.baidu.swan.games.bdtls.a.DEBUG) {
                    Log.d("BDTLS", "BdtlsPostRequest onSuccess=" + str2);
                }
                if (TextUtils.equals(str2, "recovery")) {
                    if (!e.aQB().aQC().aRD()) {
                        a.this.dMx.onFail(new Exception("Exceeded the limit of continuous downgrade"));
                        return;
                    }
                    e.aQB().aQC().aRB();
                    a.this.hj(true);
                    a.this.aRL();
                    return;
                }
                e.aQB().aQC().aRE();
                if (!a.this.dMA) {
                    if (a.this.dMx != null) {
                        a.this.dMx.onSuccess(this.dMy, i);
                        a.this.mRetryCount = 0;
                    }
                } else if (a.this.dMB == 1) {
                    f.wf("application");
                    if (a.this.dMx != null) {
                        a.this.dMx.onSuccess(this.dMy, i);
                    }
                    a.this.mRetryCount = 0;
                } else if (a.c(a.this) < 3) {
                    a.this.b(a.this.dMv, a.this.dMw, a.this.dMx);
                } else {
                    a.this.dMx.onFail(new IOException("request fail : " + this.dMy));
                    a.this.mRetryCount = 0;
                }
            }

            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            public void onFail(Exception exc) {
                if (com.baidu.swan.games.bdtls.a.DEBUG) {
                    Log.d("BDTLS", "BdtlsPostRequest onFail=" + exc.getMessage());
                }
                if (a.this.dMx != null) {
                    a.this.dMx.onFail(exc);
                }
            }
        });
    }

    @Override // com.baidu.swan.games.bdtls.b.b
    public void lS(int i) {
        if (com.baidu.swan.games.bdtls.a.DEBUG) {
            Log.d("BDTLS", "onRequestError=" + i);
        }
        if (this.dMx != null) {
            this.dMx.onFail(new Exception("request error  code : " + i));
        }
    }

    @Override // com.baidu.swan.games.bdtls.b.b
    public void b(IOException iOException) {
        if (this.dMx != null) {
            this.dMx.onFail(iOException);
        }
    }

    @Override // com.baidu.swan.games.bdtls.b.b
    public String getMethod() {
        return "POST";
    }
}
