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
/* loaded from: classes8.dex */
public class a<T> extends b {
    private String efw = null;
    private String efx = null;
    private ResponseCallback<T> efy = null;
    private int mRetryCount;

    static /* synthetic */ int c(a aVar) {
        int i = aVar.mRetryCount;
        aVar.mRetryCount = i + 1;
        return i;
    }

    public void b(String str, String str2, ResponseCallback<T> responseCallback) {
        if (!TextUtils.isEmpty(str)) {
            this.efw = str;
            this.efx = str2;
            this.efy = responseCallback;
            if (com.baidu.swan.games.bdtls.a.DEBUG) {
                Log.d("BDTLS", "requestPost url=" + str);
                Log.d("BDTLS", "requestPost body=" + str2);
            }
            wl(this.efx);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aVy() {
        b(this.efw, this.efx, this.efy);
    }

    @Override // com.baidu.swan.games.bdtls.b.b
    public void X(byte[] bArr) {
        String str = this.efw;
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", HttpHelper.CONTENT_JSON);
        if (this.efB) {
            hashMap.put("Bdtls", "Bdtls");
        }
        if (com.baidu.swan.games.bdtls.a.DEBUG) {
            Log.d("BDTLS", "BdtlsPostRequest url=" + str);
        }
        com.baidu.swan.a.c.a.bca().postByteRequest().mediaType(HttpHelper.CONTENT_JSON).url(str).cookieManager(com.baidu.swan.apps.t.a.axy().aiB()).headers(hashMap).content(bArr).build().executeAsync(new ResponseCallback<String>() { // from class: com.baidu.swan.games.bdtls.b.a.1
            T efz;

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            public String parseResponse(Response response, int i) throws Exception {
                Headers headers = response.headers();
                if (headers != null && TextUtils.equals(headers.get("Bdtls"), "recovery")) {
                    e.aUo().aUp().lb(0);
                    return "recovery";
                } else if (!a.this.efB) {
                    if (a.this.efy != null) {
                        this.efz = (T) a.this.efy.parseResponse(response, i);
                        return "";
                    }
                    return "";
                } else {
                    ResponseBody body = response.body();
                    String Y = a.this.Y(body.bytes());
                    if (com.baidu.swan.games.bdtls.a.DEBUG) {
                        Log.d("BDTLS", "BdtlsPostRequest parseResponse=" + Y);
                    }
                    if (a.this.efC == 1) {
                        Buffer buffer = new Buffer();
                        buffer.writeString(Y, Charset.forName("utf-8"));
                        Response build = response.newBuilder().body(ResponseBody.create(body.contentType(), buffer.size(), buffer)).build();
                        if (a.this.efy != null) {
                            this.efz = (T) a.this.efy.parseResponse(build, i);
                            return Y;
                        }
                        return Y;
                    }
                    return Y;
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            /* renamed from: V */
            public void onSuccess(String str2, int i) {
                if (com.baidu.swan.games.bdtls.a.DEBUG) {
                    Log.d("BDTLS", "BdtlsPostRequest onSuccess=" + str2);
                }
                if (TextUtils.equals(str2, "recovery")) {
                    if (!e.aUo().aUp().aVq()) {
                        a.this.efy.onFail(new Exception("Exceeded the limit of continuous downgrade"));
                        return;
                    }
                    e.aUo().aUp().aVo();
                    a.this.ia(true);
                    a.this.aVy();
                    return;
                }
                e.aUo().aUp().aVr();
                if (!a.this.efB) {
                    if (a.this.efy != null) {
                        a.this.efy.onSuccess(this.efz, i);
                        a.this.mRetryCount = 0;
                    }
                } else if (a.this.efC == 1) {
                    f.wj("application");
                    if (a.this.efy != null) {
                        a.this.efy.onSuccess(this.efz, i);
                    }
                    a.this.mRetryCount = 0;
                } else if (a.c(a.this) < 3) {
                    a.this.b(a.this.efw, a.this.efx, a.this.efy);
                } else {
                    a.this.efy.onFail(new IOException("request fail : " + this.efz));
                    a.this.mRetryCount = 0;
                }
            }

            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            public void onFail(Exception exc) {
                if (com.baidu.swan.games.bdtls.a.DEBUG) {
                    Log.d("BDTLS", "BdtlsPostRequest onFail=" + exc.getMessage());
                }
                if (a.this.efy != null) {
                    a.this.efy.onFail(exc);
                }
            }
        });
    }

    @Override // com.baidu.swan.games.bdtls.b.b
    public void lc(int i) {
        if (com.baidu.swan.games.bdtls.a.DEBUG) {
            Log.d("BDTLS", "onRequestError=" + i);
        }
        if (this.efy != null) {
            this.efy.onFail(new Exception("request error  code : " + i));
        }
    }

    @Override // com.baidu.swan.games.bdtls.b.b
    public void b(IOException iOException) {
        if (this.efy != null) {
            this.efy.onFail(iOException);
        }
    }

    @Override // com.baidu.swan.games.bdtls.b.b
    public String getMethod() {
        return "POST";
    }
}
