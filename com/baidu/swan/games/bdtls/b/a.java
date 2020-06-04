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
    private String cVl = null;
    private String cVm = null;
    private ResponseCallback<T> cVn = null;
    private int mRetryCount;

    static /* synthetic */ int c(a aVar) {
        int i = aVar.mRetryCount;
        aVar.mRetryCount = i + 1;
        return i;
    }

    public void b(String str, String str2, ResponseCallback<T> responseCallback) {
        if (!TextUtils.isEmpty(str)) {
            this.cVl = str;
            this.cVm = str2;
            this.cVn = responseCallback;
            if (com.baidu.swan.games.bdtls.a.DEBUG) {
                Log.d("BDTLS", "requestPost url=" + str);
                Log.d("BDTLS", "requestPost body=" + str2);
            }
            rk(this.cVm);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ayX() {
        b(this.cVl, this.cVm, this.cVn);
    }

    @Override // com.baidu.swan.games.bdtls.b.b
    public void V(byte[] bArr) {
        String str = this.cVl;
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", HttpHelper.CONTENT_JSON);
        if (this.cVq) {
            hashMap.put("Bdtls", "Bdtls");
        }
        if (com.baidu.swan.games.bdtls.a.DEBUG) {
            Log.d("BDTLS", "BdtlsPostRequest url=" + str);
        }
        com.baidu.swan.c.c.a.aFx().postByteRequest().mediaType(HttpHelper.CONTENT_JSON).url(str).cookieManager(com.baidu.swan.apps.u.a.afo().SM()).headers(hashMap).content(bArr).build().executeAsync(new ResponseCallback<String>() { // from class: com.baidu.swan.games.bdtls.b.a.1
            T cVo;

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            public String parseResponse(Response response, int i) throws Exception {
                Headers headers = response.headers();
                if (headers != null && TextUtils.equals(headers.get("Bdtls"), "recovery")) {
                    e.axN().axO().in(0);
                    return "recovery";
                } else if (!a.this.cVq) {
                    if (a.this.cVn != null) {
                        this.cVo = (T) a.this.cVn.parseResponse(response, i);
                        return "";
                    }
                    return "";
                } else {
                    ResponseBody body = response.body();
                    String W = a.this.W(body.bytes());
                    if (com.baidu.swan.games.bdtls.a.DEBUG) {
                        Log.d("BDTLS", "BdtlsPostRequest parseResponse=" + W);
                    }
                    if (a.this.cVr == 1) {
                        Buffer buffer = new Buffer();
                        buffer.writeString(W, Charset.forName("utf-8"));
                        Response build = response.newBuilder().body(ResponseBody.create(body.contentType(), buffer.size(), buffer)).build();
                        if (a.this.cVn != null) {
                            this.cVo = (T) a.this.cVn.parseResponse(build, i);
                            return W;
                        }
                        return W;
                    }
                    return W;
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            public void onSuccess(String str2, int i) {
                if (com.baidu.swan.games.bdtls.a.DEBUG) {
                    Log.d("BDTLS", "BdtlsPostRequest onSuccess=" + str2);
                }
                if (TextUtils.equals(str2, "recovery")) {
                    if (!e.axN().axO().ayP()) {
                        a.this.cVn.onFail(new Exception("Exceeded the limit of continuous downgrade"));
                        return;
                    }
                    e.axN().axO().ayN();
                    a.this.fJ(true);
                    a.this.ayX();
                    return;
                }
                e.axN().axO().ayQ();
                if (!a.this.cVq) {
                    if (a.this.cVn != null) {
                        a.this.cVn.onSuccess(this.cVo, i);
                        a.this.mRetryCount = 0;
                    }
                } else if (a.this.cVr == 1) {
                    f.ri("application");
                    if (a.this.cVn != null) {
                        a.this.cVn.onSuccess(this.cVo, i);
                    }
                    a.this.mRetryCount = 0;
                } else if (a.c(a.this) < 3) {
                    a.this.b(a.this.cVl, a.this.cVm, a.this.cVn);
                } else {
                    a.this.cVn.onFail(new IOException("request fail : " + this.cVo));
                    a.this.mRetryCount = 0;
                }
            }

            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            public void onFail(Exception exc) {
                if (com.baidu.swan.games.bdtls.a.DEBUG) {
                    Log.d("BDTLS", "BdtlsPostRequest onFail=" + exc.getMessage());
                }
                if (a.this.cVn != null) {
                    a.this.cVn.onFail(exc);
                }
            }
        });
    }

    @Override // com.baidu.swan.games.bdtls.b.b
    public void io(int i) {
        if (com.baidu.swan.games.bdtls.a.DEBUG) {
            Log.d("BDTLS", "onRequestError=" + i);
        }
        if (this.cVn != null) {
            this.cVn.onFail(new Exception("request error  code : " + i));
        }
    }

    @Override // com.baidu.swan.games.bdtls.b.b
    public void b(IOException iOException) {
        if (this.cVn != null) {
            this.cVn.onFail(iOException);
        }
    }

    @Override // com.baidu.swan.games.bdtls.b.b
    public String getMethod() {
        return "POST";
    }
}
