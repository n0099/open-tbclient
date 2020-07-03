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
/* loaded from: classes11.dex */
public class a<T> extends b {
    private String cZV = null;
    private String cZW = null;
    private ResponseCallback<T> cZX = null;
    private int mRetryCount;

    static /* synthetic */ int c(a aVar) {
        int i = aVar.mRetryCount;
        aVar.mRetryCount = i + 1;
        return i;
    }

    public void b(String str, String str2, ResponseCallback<T> responseCallback) {
        if (!TextUtils.isEmpty(str)) {
            this.cZV = str;
            this.cZW = str2;
            this.cZX = responseCallback;
            if (com.baidu.swan.games.bdtls.a.DEBUG) {
                Log.d("BDTLS", "requestPost url=" + str);
                Log.d("BDTLS", "requestPost body=" + str2);
            }
            rs(this.cZW);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aAd() {
        b(this.cZV, this.cZW, this.cZX);
    }

    @Override // com.baidu.swan.games.bdtls.b.b
    public void X(byte[] bArr) {
        String str = this.cZV;
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", HttpHelper.CONTENT_JSON);
        if (this.daa) {
            hashMap.put("Bdtls", "Bdtls");
        }
        if (com.baidu.swan.games.bdtls.a.DEBUG) {
            Log.d("BDTLS", "BdtlsPostRequest url=" + str);
        }
        com.baidu.swan.c.c.a.aGD().postByteRequest().mediaType(HttpHelper.CONTENT_JSON).url(str).cookieManager(com.baidu.swan.apps.u.a.agu().TS()).headers(hashMap).content(bArr).build().executeAsync(new ResponseCallback<String>() { // from class: com.baidu.swan.games.bdtls.b.a.1
            T cZY;

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            public String parseResponse(Response response, int i) throws Exception {
                Headers headers = response.headers();
                if (headers != null && TextUtils.equals(headers.get("Bdtls"), "recovery")) {
                    e.ayT().ayU().iy(0);
                    return "recovery";
                } else if (!a.this.daa) {
                    if (a.this.cZX != null) {
                        this.cZY = (T) a.this.cZX.parseResponse(response, i);
                        return "";
                    }
                    return "";
                } else {
                    ResponseBody body = response.body();
                    String Y = a.this.Y(body.bytes());
                    if (com.baidu.swan.games.bdtls.a.DEBUG) {
                        Log.d("BDTLS", "BdtlsPostRequest parseResponse=" + Y);
                    }
                    if (a.this.dab == 1) {
                        Buffer buffer = new Buffer();
                        buffer.writeString(Y, Charset.forName("utf-8"));
                        Response build = response.newBuilder().body(ResponseBody.create(body.contentType(), buffer.size(), buffer)).build();
                        if (a.this.cZX != null) {
                            this.cZY = (T) a.this.cZX.parseResponse(build, i);
                            return Y;
                        }
                        return Y;
                    }
                    return Y;
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            public void onSuccess(String str2, int i) {
                if (com.baidu.swan.games.bdtls.a.DEBUG) {
                    Log.d("BDTLS", "BdtlsPostRequest onSuccess=" + str2);
                }
                if (TextUtils.equals(str2, "recovery")) {
                    if (!e.ayT().ayU().azV()) {
                        a.this.cZX.onFail(new Exception("Exceeded the limit of continuous downgrade"));
                        return;
                    }
                    e.ayT().ayU().azT();
                    a.this.fO(true);
                    a.this.aAd();
                    return;
                }
                e.ayT().ayU().azW();
                if (!a.this.daa) {
                    if (a.this.cZX != null) {
                        a.this.cZX.onSuccess(this.cZY, i);
                        a.this.mRetryCount = 0;
                    }
                } else if (a.this.dab == 1) {
                    f.rq("application");
                    if (a.this.cZX != null) {
                        a.this.cZX.onSuccess(this.cZY, i);
                    }
                    a.this.mRetryCount = 0;
                } else if (a.c(a.this) < 3) {
                    a.this.b(a.this.cZV, a.this.cZW, a.this.cZX);
                } else {
                    a.this.cZX.onFail(new IOException("request fail : " + this.cZY));
                    a.this.mRetryCount = 0;
                }
            }

            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            public void onFail(Exception exc) {
                if (com.baidu.swan.games.bdtls.a.DEBUG) {
                    Log.d("BDTLS", "BdtlsPostRequest onFail=" + exc.getMessage());
                }
                if (a.this.cZX != null) {
                    a.this.cZX.onFail(exc);
                }
            }
        });
    }

    @Override // com.baidu.swan.games.bdtls.b.b
    public void iz(int i) {
        if (com.baidu.swan.games.bdtls.a.DEBUG) {
            Log.d("BDTLS", "onRequestError=" + i);
        }
        if (this.cZX != null) {
            this.cZX.onFail(new Exception("request error  code : " + i));
        }
    }

    @Override // com.baidu.swan.games.bdtls.b.b
    public void b(IOException iOException) {
        if (this.cZX != null) {
            this.cZX.onFail(iOException);
        }
    }

    @Override // com.baidu.swan.games.bdtls.b.b
    public String getMethod() {
        return "POST";
    }
}
