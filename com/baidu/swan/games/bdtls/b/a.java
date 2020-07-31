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
/* loaded from: classes7.dex */
public class a<T> extends b {
    private String dfG = null;
    private String dfH = null;
    private ResponseCallback<T> dfI = null;
    private int mRetryCount;

    static /* synthetic */ int c(a aVar) {
        int i = aVar.mRetryCount;
        aVar.mRetryCount = i + 1;
        return i;
    }

    public void b(String str, String str2, ResponseCallback<T> responseCallback) {
        if (!TextUtils.isEmpty(str)) {
            this.dfG = str;
            this.dfH = str2;
            this.dfI = responseCallback;
            if (com.baidu.swan.games.bdtls.a.DEBUG) {
                Log.d("BDTLS", "requestPost url=" + str);
                Log.d("BDTLS", "requestPost body=" + str2);
            }
            sq(this.dfH);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aDI() {
        b(this.dfG, this.dfH, this.dfI);
    }

    @Override // com.baidu.swan.games.bdtls.b.b
    public void X(byte[] bArr) {
        String str = this.dfG;
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", HttpHelper.CONTENT_JSON);
        if (this.dfL) {
            hashMap.put("Bdtls", "Bdtls");
        }
        if (com.baidu.swan.games.bdtls.a.DEBUG) {
            Log.d("BDTLS", "BdtlsPostRequest url=" + str);
        }
        com.baidu.swan.b.c.a.aKu().postByteRequest().mediaType(HttpHelper.CONTENT_JSON).url(str).cookieManager(com.baidu.swan.apps.t.a.ahH().Us()).headers(hashMap).content(bArr).build().executeAsync(new ResponseCallback<String>() { // from class: com.baidu.swan.games.bdtls.b.a.1
            T dfJ;

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            public String parseResponse(Response response, int i) throws Exception {
                Headers headers = response.headers();
                if (headers != null && TextUtils.equals(headers.get("Bdtls"), "recovery")) {
                    e.aCy().aCz().iP(0);
                    return "recovery";
                } else if (!a.this.dfL) {
                    if (a.this.dfI != null) {
                        this.dfJ = (T) a.this.dfI.parseResponse(response, i);
                        return "";
                    }
                    return "";
                } else {
                    ResponseBody body = response.body();
                    String Y = a.this.Y(body.bytes());
                    if (com.baidu.swan.games.bdtls.a.DEBUG) {
                        Log.d("BDTLS", "BdtlsPostRequest parseResponse=" + Y);
                    }
                    if (a.this.dfM == 1) {
                        Buffer buffer = new Buffer();
                        buffer.writeString(Y, Charset.forName("utf-8"));
                        Response build = response.newBuilder().body(ResponseBody.create(body.contentType(), buffer.size(), buffer)).build();
                        if (a.this.dfI != null) {
                            this.dfJ = (T) a.this.dfI.parseResponse(build, i);
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
                    if (!e.aCy().aCz().aDA()) {
                        a.this.dfI.onFail(new Exception("Exceeded the limit of continuous downgrade"));
                        return;
                    }
                    e.aCy().aCz().aDy();
                    a.this.gf(true);
                    a.this.aDI();
                    return;
                }
                e.aCy().aCz().aDB();
                if (!a.this.dfL) {
                    if (a.this.dfI != null) {
                        a.this.dfI.onSuccess(this.dfJ, i);
                        a.this.mRetryCount = 0;
                    }
                } else if (a.this.dfM == 1) {
                    f.so("application");
                    if (a.this.dfI != null) {
                        a.this.dfI.onSuccess(this.dfJ, i);
                    }
                    a.this.mRetryCount = 0;
                } else if (a.c(a.this) < 3) {
                    a.this.b(a.this.dfG, a.this.dfH, a.this.dfI);
                } else {
                    a.this.dfI.onFail(new IOException("request fail : " + this.dfJ));
                    a.this.mRetryCount = 0;
                }
            }

            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            public void onFail(Exception exc) {
                if (com.baidu.swan.games.bdtls.a.DEBUG) {
                    Log.d("BDTLS", "BdtlsPostRequest onFail=" + exc.getMessage());
                }
                if (a.this.dfI != null) {
                    a.this.dfI.onFail(exc);
                }
            }
        });
    }

    @Override // com.baidu.swan.games.bdtls.b.b
    public void iQ(int i) {
        if (com.baidu.swan.games.bdtls.a.DEBUG) {
            Log.d("BDTLS", "onRequestError=" + i);
        }
        if (this.dfI != null) {
            this.dfI.onFail(new Exception("request error  code : " + i));
        }
    }

    @Override // com.baidu.swan.games.bdtls.b.b
    public void b(IOException iOException) {
        if (this.dfI != null) {
            this.dfI.onFail(iOException);
        }
    }

    @Override // com.baidu.swan.games.bdtls.b.b
    public String getMethod() {
        return "POST";
    }
}
