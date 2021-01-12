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
    private String ebO = null;
    private String ebP = null;
    private ResponseCallback<T> ebQ = null;
    private int mRetryCount;

    static /* synthetic */ int c(a aVar) {
        int i = aVar.mRetryCount;
        aVar.mRetryCount = i + 1;
        return i;
    }

    public void b(String str, String str2, ResponseCallback<T> responseCallback) {
        if (!TextUtils.isEmpty(str)) {
            this.ebO = str;
            this.ebP = str2;
            this.ebQ = responseCallback;
            if (com.baidu.swan.games.bdtls.a.DEBUG) {
                Log.d("BDTLS", "requestPost url=" + str);
                Log.d("BDTLS", "requestPost body=" + str2);
            }
            vL(this.ebP);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aVj() {
        b(this.ebO, this.ebP, this.ebQ);
    }

    @Override // com.baidu.swan.games.bdtls.b.b
    public void W(byte[] bArr) {
        String str = this.ebO;
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", HttpHelper.CONTENT_JSON);
        if (this.ebT) {
            hashMap.put("Bdtls", "Bdtls");
        }
        if (com.baidu.swan.games.bdtls.a.DEBUG) {
            Log.d("BDTLS", "BdtlsPostRequest url=" + str);
        }
        com.baidu.swan.a.c.a.bbL().postByteRequest().mediaType(HttpHelper.CONTENT_JSON).url(str).cookieManager(com.baidu.swan.apps.t.a.awX().aia()).headers(hashMap).content(bArr).build().executeAsync(new ResponseCallback<String>() { // from class: com.baidu.swan.games.bdtls.b.a.1
            T ebR;

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            public String parseResponse(Response response, int i) throws Exception {
                Headers headers = response.headers();
                if (headers != null && TextUtils.equals(headers.get("Bdtls"), "recovery")) {
                    e.aTZ().aUa().kX(0);
                    return "recovery";
                } else if (!a.this.ebT) {
                    if (a.this.ebQ != null) {
                        this.ebR = (T) a.this.ebQ.parseResponse(response, i);
                        return "";
                    }
                    return "";
                } else {
                    ResponseBody body = response.body();
                    String X = a.this.X(body.bytes());
                    if (com.baidu.swan.games.bdtls.a.DEBUG) {
                        Log.d("BDTLS", "BdtlsPostRequest parseResponse=" + X);
                    }
                    if (a.this.ebU == 1) {
                        Buffer buffer = new Buffer();
                        buffer.writeString(X, Charset.forName("utf-8"));
                        Response build = response.newBuilder().body(ResponseBody.create(body.contentType(), buffer.size(), buffer)).build();
                        if (a.this.ebQ != null) {
                            this.ebR = (T) a.this.ebQ.parseResponse(build, i);
                            return X;
                        }
                        return X;
                    }
                    return X;
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            /* renamed from: S */
            public void onSuccess(String str2, int i) {
                if (com.baidu.swan.games.bdtls.a.DEBUG) {
                    Log.d("BDTLS", "BdtlsPostRequest onSuccess=" + str2);
                }
                if (TextUtils.equals(str2, "recovery")) {
                    if (!e.aTZ().aUa().aVb()) {
                        a.this.ebQ.onFail(new Exception("Exceeded the limit of continuous downgrade"));
                        return;
                    }
                    e.aTZ().aUa().aUZ();
                    a.this.hY(true);
                    a.this.aVj();
                    return;
                }
                e.aTZ().aUa().aVc();
                if (!a.this.ebT) {
                    if (a.this.ebQ != null) {
                        a.this.ebQ.onSuccess(this.ebR, i);
                        a.this.mRetryCount = 0;
                    }
                } else if (a.this.ebU == 1) {
                    f.vJ("application");
                    if (a.this.ebQ != null) {
                        a.this.ebQ.onSuccess(this.ebR, i);
                    }
                    a.this.mRetryCount = 0;
                } else if (a.c(a.this) < 3) {
                    a.this.b(a.this.ebO, a.this.ebP, a.this.ebQ);
                } else {
                    a.this.ebQ.onFail(new IOException("request fail : " + this.ebR));
                    a.this.mRetryCount = 0;
                }
            }

            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            public void onFail(Exception exc) {
                if (com.baidu.swan.games.bdtls.a.DEBUG) {
                    Log.d("BDTLS", "BdtlsPostRequest onFail=" + exc.getMessage());
                }
                if (a.this.ebQ != null) {
                    a.this.ebQ.onFail(exc);
                }
            }
        });
    }

    @Override // com.baidu.swan.games.bdtls.b.b
    public void kY(int i) {
        if (com.baidu.swan.games.bdtls.a.DEBUG) {
            Log.d("BDTLS", "onRequestError=" + i);
        }
        if (this.ebQ != null) {
            this.ebQ.onFail(new Exception("request error  code : " + i));
        }
    }

    @Override // com.baidu.swan.games.bdtls.b.b
    public void b(IOException iOException) {
        if (this.ebQ != null) {
            this.ebQ.onFail(iOException);
        }
    }

    @Override // com.baidu.swan.games.bdtls.b.b
    public String getMethod() {
        return "POST";
    }
}
