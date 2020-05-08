package com.baidu.swan.games.bdtls.b;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.HttpManager;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.swan.games.bdtls.f;
import java.nio.charset.Charset;
import java.util.HashMap;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;
/* loaded from: classes11.dex */
public class a<T> extends b {
    private String cKE = null;
    private String cKF = null;
    private ResponseCallback<T> cKG = null;

    public void a(String str, String str2, ResponseCallback<T> responseCallback) {
        if (!TextUtils.isEmpty(str)) {
            this.cKE = str;
            this.cKF = str2;
            this.cKG = responseCallback;
            if (com.baidu.swan.games.bdtls.a.DEBUG) {
                Log.d("BDTLS", "requestPost url=" + str);
                Log.d("BDTLS", "requestPost body=" + str2);
            }
            pJ(this.cKF);
        }
    }

    @Override // com.baidu.swan.games.bdtls.b.b
    public void O(byte[] bArr) {
        String str = this.cKE;
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/json");
        if (this.cKJ) {
            hashMap.put("Bdtls", "Bdtls");
        }
        if (com.baidu.swan.games.bdtls.a.DEBUG) {
            Log.d("BDTLS", "BdtlsPostRequest url=" + str);
        }
        HttpManager.getDefault(AppRuntime.getAppContext()).postByteRequest().mediaType("application/json").url(str).cookieManager(com.baidu.swan.apps.w.a.acl().Qi()).headers(hashMap).content(bArr).build().executeAsync(new ResponseCallback<String>() { // from class: com.baidu.swan.games.bdtls.b.a.1
            T cKH;

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            public String parseResponse(Response response, int i) throws Exception {
                String str2 = "";
                if (!a.this.cKJ) {
                    if (a.this.cKG != null) {
                        this.cKH = (T) a.this.cKG.parseResponse(response, i);
                    }
                } else {
                    ResponseBody body = response.body();
                    str2 = a.this.P(body.bytes());
                    if (com.baidu.swan.games.bdtls.a.DEBUG) {
                        Log.d("BDTLS", "BdtlsPostRequest parseResponse=" + str2);
                    }
                    if (a.this.cKK == 1) {
                        Buffer buffer = new Buffer();
                        buffer.writeString(str2, Charset.forName("utf-8"));
                        Response build = response.newBuilder().body(ResponseBody.create(body.contentType(), buffer.size(), buffer)).build();
                        if (a.this.cKG != null) {
                            this.cKH = (T) a.this.cKG.parseResponse(build, i);
                        }
                    }
                }
                return str2;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            public void onSuccess(String str2, int i) {
                if (com.baidu.swan.games.bdtls.a.DEBUG) {
                    Log.d("BDTLS", "BdtlsPostRequest onSuccess=" + str2);
                }
                if (!a.this.cKJ) {
                    if (a.this.cKG != null) {
                        a.this.cKG.onSuccess(this.cKH, i);
                    }
                } else if (a.this.cKK != 1) {
                    a.this.a(a.this.cKE, a.this.cKF, a.this.cKG);
                } else {
                    f.pH("application");
                    if (a.this.cKG != null) {
                        a.this.cKG.onSuccess(this.cKH, i);
                    }
                }
            }

            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            public void onFail(Exception exc) {
                if (com.baidu.swan.games.bdtls.a.DEBUG) {
                    Log.d("BDTLS", "BdtlsPostRequest onFail=" + exc.getMessage());
                }
                if (a.this.cKG != null) {
                    a.this.cKG.onFail(exc);
                }
            }
        });
    }

    @Override // com.baidu.swan.games.bdtls.b.b
    public void hV(int i) {
        if (com.baidu.swan.games.bdtls.a.DEBUG) {
            Log.d("BDTLS", "onRequestError=" + i);
        }
    }
}
