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
    private String cKy = null;
    private String cKz = null;
    private ResponseCallback<T> cKA = null;

    public void a(String str, String str2, ResponseCallback<T> responseCallback) {
        if (!TextUtils.isEmpty(str)) {
            this.cKy = str;
            this.cKz = str2;
            this.cKA = responseCallback;
            if (com.baidu.swan.games.bdtls.a.DEBUG) {
                Log.d("BDTLS", "requestPost url=" + str);
                Log.d("BDTLS", "requestPost body=" + str2);
            }
            pJ(this.cKz);
        }
    }

    @Override // com.baidu.swan.games.bdtls.b.b
    public void O(byte[] bArr) {
        String str = this.cKy;
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/json");
        if (this.cKD) {
            hashMap.put("Bdtls", "Bdtls");
        }
        if (com.baidu.swan.games.bdtls.a.DEBUG) {
            Log.d("BDTLS", "BdtlsPostRequest url=" + str);
        }
        HttpManager.getDefault(AppRuntime.getAppContext()).postByteRequest().mediaType("application/json").url(str).cookieManager(com.baidu.swan.apps.w.a.acm().Qj()).headers(hashMap).content(bArr).build().executeAsync(new ResponseCallback<String>() { // from class: com.baidu.swan.games.bdtls.b.a.1
            T cKB;

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            public String parseResponse(Response response, int i) throws Exception {
                String str2 = "";
                if (!a.this.cKD) {
                    if (a.this.cKA != null) {
                        this.cKB = (T) a.this.cKA.parseResponse(response, i);
                    }
                } else {
                    ResponseBody body = response.body();
                    str2 = a.this.P(body.bytes());
                    if (com.baidu.swan.games.bdtls.a.DEBUG) {
                        Log.d("BDTLS", "BdtlsPostRequest parseResponse=" + str2);
                    }
                    if (a.this.cKE == 1) {
                        Buffer buffer = new Buffer();
                        buffer.writeString(str2, Charset.forName("utf-8"));
                        Response build = response.newBuilder().body(ResponseBody.create(body.contentType(), buffer.size(), buffer)).build();
                        if (a.this.cKA != null) {
                            this.cKB = (T) a.this.cKA.parseResponse(build, i);
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
                if (!a.this.cKD) {
                    if (a.this.cKA != null) {
                        a.this.cKA.onSuccess(this.cKB, i);
                    }
                } else if (a.this.cKE != 1) {
                    a.this.a(a.this.cKy, a.this.cKz, a.this.cKA);
                } else {
                    f.pH("application");
                    if (a.this.cKA != null) {
                        a.this.cKA.onSuccess(this.cKB, i);
                    }
                }
            }

            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            public void onFail(Exception exc) {
                if (com.baidu.swan.games.bdtls.a.DEBUG) {
                    Log.d("BDTLS", "BdtlsPostRequest onFail=" + exc.getMessage());
                }
                if (a.this.cKA != null) {
                    a.this.cKA.onFail(exc);
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
