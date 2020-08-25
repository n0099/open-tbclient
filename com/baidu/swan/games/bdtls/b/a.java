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
    private String dpP = null;
    private String dpQ = null;
    private ResponseCallback<T> dpR = null;
    private int mRetryCount;

    static /* synthetic */ int c(a aVar) {
        int i = aVar.mRetryCount;
        aVar.mRetryCount = i + 1;
        return i;
    }

    public void b(String str, String str2, ResponseCallback<T> responseCallback) {
        if (!TextUtils.isEmpty(str)) {
            this.dpP = str;
            this.dpQ = str2;
            this.dpR = responseCallback;
            if (com.baidu.swan.games.bdtls.a.DEBUG) {
                Log.d("BDTLS", "requestPost url=" + str);
                Log.d("BDTLS", "requestPost body=" + str2);
            }
            uI(this.dpQ);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aMx() {
        b(this.dpP, this.dpQ, this.dpR);
    }

    @Override // com.baidu.swan.games.bdtls.b.b
    public void Y(byte[] bArr) {
        String str = this.dpP;
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", HttpHelper.CONTENT_JSON);
        if (this.dpU) {
            hashMap.put("Bdtls", "Bdtls");
        }
        if (com.baidu.swan.games.bdtls.a.DEBUG) {
            Log.d("BDTLS", "BdtlsPostRequest url=" + str);
        }
        com.baidu.swan.a.c.a.aSW().postByteRequest().mediaType(HttpHelper.CONTENT_JSON).url(str).cookieManager(com.baidu.swan.apps.t.a.apj().aau()).headers(hashMap).content(bArr).build().executeAsync(new ResponseCallback<String>() { // from class: com.baidu.swan.games.bdtls.b.a.1
            T dpS;

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            public String parseResponse(Response response, int i) throws Exception {
                Headers headers = response.headers();
                if (headers != null && TextUtils.equals(headers.get("Bdtls"), "recovery")) {
                    e.aLn().aLo().kY(0);
                    return "recovery";
                } else if (!a.this.dpU) {
                    if (a.this.dpR != null) {
                        this.dpS = (T) a.this.dpR.parseResponse(response, i);
                        return "";
                    }
                    return "";
                } else {
                    ResponseBody body = response.body();
                    String Z = a.this.Z(body.bytes());
                    if (com.baidu.swan.games.bdtls.a.DEBUG) {
                        Log.d("BDTLS", "BdtlsPostRequest parseResponse=" + Z);
                    }
                    if (a.this.dpV == 1) {
                        Buffer buffer = new Buffer();
                        buffer.writeString(Z, Charset.forName("utf-8"));
                        Response build = response.newBuilder().body(ResponseBody.create(body.contentType(), buffer.size(), buffer)).build();
                        if (a.this.dpR != null) {
                            this.dpS = (T) a.this.dpR.parseResponse(build, i);
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
                    if (!e.aLn().aLo().aMp()) {
                        a.this.dpR.onFail(new Exception("Exceeded the limit of continuous downgrade"));
                        return;
                    }
                    e.aLn().aLo().aMn();
                    a.this.gB(true);
                    a.this.aMx();
                    return;
                }
                e.aLn().aLo().aMq();
                if (!a.this.dpU) {
                    if (a.this.dpR != null) {
                        a.this.dpR.onSuccess(this.dpS, i);
                        a.this.mRetryCount = 0;
                    }
                } else if (a.this.dpV == 1) {
                    f.uG("application");
                    if (a.this.dpR != null) {
                        a.this.dpR.onSuccess(this.dpS, i);
                    }
                    a.this.mRetryCount = 0;
                } else if (a.c(a.this) < 3) {
                    a.this.b(a.this.dpP, a.this.dpQ, a.this.dpR);
                } else {
                    a.this.dpR.onFail(new IOException("request fail : " + this.dpS));
                    a.this.mRetryCount = 0;
                }
            }

            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            public void onFail(Exception exc) {
                if (com.baidu.swan.games.bdtls.a.DEBUG) {
                    Log.d("BDTLS", "BdtlsPostRequest onFail=" + exc.getMessage());
                }
                if (a.this.dpR != null) {
                    a.this.dpR.onFail(exc);
                }
            }
        });
    }

    @Override // com.baidu.swan.games.bdtls.b.b
    public void kZ(int i) {
        if (com.baidu.swan.games.bdtls.a.DEBUG) {
            Log.d("BDTLS", "onRequestError=" + i);
        }
        if (this.dpR != null) {
            this.dpR.onFail(new Exception("request error  code : " + i));
        }
    }

    @Override // com.baidu.swan.games.bdtls.b.b
    public void b(IOException iOException) {
        if (this.dpR != null) {
            this.dpR.onFail(iOException);
        }
    }

    @Override // com.baidu.swan.games.bdtls.b.b
    public String getMethod() {
        return "POST";
    }
}
