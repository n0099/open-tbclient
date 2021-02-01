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
/* loaded from: classes9.dex */
public class a<T> extends b {
    private String edV = null;
    private String edW = null;
    private ResponseCallback<T> edX = null;
    private int mRetryCount;

    static /* synthetic */ int c(a aVar) {
        int i = aVar.mRetryCount;
        aVar.mRetryCount = i + 1;
        return i;
    }

    public void b(String str, String str2, ResponseCallback<T> responseCallback) {
        if (!TextUtils.isEmpty(str)) {
            this.edV = str;
            this.edW = str2;
            this.edX = responseCallback;
            if (com.baidu.swan.games.bdtls.a.DEBUG) {
                Log.d("BDTLS", "requestPost url=" + str);
                Log.d("BDTLS", "requestPost body=" + str2);
            }
            we(this.edW);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aVv() {
        b(this.edV, this.edW, this.edX);
    }

    @Override // com.baidu.swan.games.bdtls.b.b
    public void V(byte[] bArr) {
        String str = this.edV;
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", HttpHelper.CONTENT_JSON);
        if (this.eea) {
            hashMap.put("Bdtls", "Bdtls");
        }
        if (com.baidu.swan.games.bdtls.a.DEBUG) {
            Log.d("BDTLS", "BdtlsPostRequest url=" + str);
        }
        com.baidu.swan.a.c.a.bbY().postByteRequest().mediaType(HttpHelper.CONTENT_JSON).url(str).cookieManager(com.baidu.swan.apps.t.a.axv().aiy()).headers(hashMap).content(bArr).build().executeAsync(new ResponseCallback<String>() { // from class: com.baidu.swan.games.bdtls.b.a.1
            T edY;

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            public String parseResponse(Response response, int i) throws Exception {
                Headers headers = response.headers();
                if (headers != null && TextUtils.equals(headers.get("Bdtls"), "recovery")) {
                    e.aUl().aUm().la(0);
                    return "recovery";
                } else if (!a.this.eea) {
                    if (a.this.edX != null) {
                        this.edY = (T) a.this.edX.parseResponse(response, i);
                        return "";
                    }
                    return "";
                } else {
                    ResponseBody body = response.body();
                    String W = a.this.W(body.bytes());
                    if (com.baidu.swan.games.bdtls.a.DEBUG) {
                        Log.d("BDTLS", "BdtlsPostRequest parseResponse=" + W);
                    }
                    if (a.this.eeb == 1) {
                        Buffer buffer = new Buffer();
                        buffer.writeString(W, Charset.forName("utf-8"));
                        Response build = response.newBuilder().body(ResponseBody.create(body.contentType(), buffer.size(), buffer)).build();
                        if (a.this.edX != null) {
                            this.edY = (T) a.this.edX.parseResponse(build, i);
                            return W;
                        }
                        return W;
                    }
                    return W;
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            /* renamed from: U */
            public void onSuccess(String str2, int i) {
                if (com.baidu.swan.games.bdtls.a.DEBUG) {
                    Log.d("BDTLS", "BdtlsPostRequest onSuccess=" + str2);
                }
                if (TextUtils.equals(str2, "recovery")) {
                    if (!e.aUl().aUm().aVn()) {
                        a.this.edX.onFail(new Exception("Exceeded the limit of continuous downgrade"));
                        return;
                    }
                    e.aUl().aUm().aVl();
                    a.this.ia(true);
                    a.this.aVv();
                    return;
                }
                e.aUl().aUm().aVo();
                if (!a.this.eea) {
                    if (a.this.edX != null) {
                        a.this.edX.onSuccess(this.edY, i);
                        a.this.mRetryCount = 0;
                    }
                } else if (a.this.eeb == 1) {
                    f.wc("application");
                    if (a.this.edX != null) {
                        a.this.edX.onSuccess(this.edY, i);
                    }
                    a.this.mRetryCount = 0;
                } else if (a.c(a.this) < 3) {
                    a.this.b(a.this.edV, a.this.edW, a.this.edX);
                } else {
                    a.this.edX.onFail(new IOException("request fail : " + this.edY));
                    a.this.mRetryCount = 0;
                }
            }

            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            public void onFail(Exception exc) {
                if (com.baidu.swan.games.bdtls.a.DEBUG) {
                    Log.d("BDTLS", "BdtlsPostRequest onFail=" + exc.getMessage());
                }
                if (a.this.edX != null) {
                    a.this.edX.onFail(exc);
                }
            }
        });
    }

    @Override // com.baidu.swan.games.bdtls.b.b
    public void lb(int i) {
        if (com.baidu.swan.games.bdtls.a.DEBUG) {
            Log.d("BDTLS", "onRequestError=" + i);
        }
        if (this.edX != null) {
            this.edX.onFail(new Exception("request error  code : " + i));
        }
    }

    @Override // com.baidu.swan.games.bdtls.b.b
    public void b(IOException iOException) {
        if (this.edX != null) {
            this.edX.onFail(iOException);
        }
    }

    @Override // com.baidu.swan.games.bdtls.b.b
    public String getMethod() {
        return "POST";
    }
}
