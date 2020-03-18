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
    private String clB = null;
    private String clC = null;
    private ResponseCallback<T> clD = null;

    public void a(String str, String str2, ResponseCallback<T> responseCallback) {
        if (!TextUtils.isEmpty(str)) {
            this.clB = str;
            this.clC = str2;
            this.clD = responseCallback;
            if (com.baidu.swan.games.bdtls.a.DEBUG) {
                Log.d("BDTLS", "requestPost url=" + str);
                Log.d("BDTLS", "requestPost body=" + str2);
            }
            ow(this.clC);
        }
    }

    @Override // com.baidu.swan.games.bdtls.b.b
    public void M(byte[] bArr) {
        String str = this.clB;
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/json");
        if (this.clG) {
            hashMap.put("Bdtls", "Bdtls");
        }
        if (com.baidu.swan.games.bdtls.a.DEBUG) {
            Log.d("BDTLS", "BdtlsPostRequest url=" + str);
        }
        HttpManager.getDefault(AppRuntime.getAppContext()).postByteRequest().mediaType("application/json").url(str).cookieManager(com.baidu.swan.apps.w.a.Ux().Ix()).headers(hashMap).content(bArr).build().executeAsync(new ResponseCallback<String>() { // from class: com.baidu.swan.games.bdtls.b.a.1
            T clE;

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            public String parseResponse(Response response, int i) throws Exception {
                String str2 = "";
                if (!a.this.clG) {
                    if (a.this.clD != null) {
                        this.clE = (T) a.this.clD.parseResponse(response, i);
                    }
                } else {
                    ResponseBody body = response.body();
                    str2 = a.this.N(body.bytes());
                    if (com.baidu.swan.games.bdtls.a.DEBUG) {
                        Log.d("BDTLS", "BdtlsPostRequest parseResponse=" + str2);
                    }
                    if (a.this.clH == 1) {
                        Buffer buffer = new Buffer();
                        buffer.writeString(str2, Charset.forName("utf-8"));
                        Response build = response.newBuilder().body(ResponseBody.create(body.contentType(), buffer.size(), buffer)).build();
                        if (a.this.clD != null) {
                            this.clE = (T) a.this.clD.parseResponse(build, i);
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
                if (!a.this.clG) {
                    if (a.this.clD != null) {
                        a.this.clD.onSuccess(this.clE, i);
                    }
                } else if (a.this.clH != 1) {
                    a.this.a(a.this.clB, a.this.clC, a.this.clD);
                } else {
                    f.ou("application");
                    if (a.this.clD != null) {
                        a.this.clD.onSuccess(this.clE, i);
                    }
                }
            }

            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            public void onFail(Exception exc) {
                if (com.baidu.swan.games.bdtls.a.DEBUG) {
                    Log.d("BDTLS", "BdtlsPostRequest onFail=" + exc.getMessage());
                }
                if (a.this.clD != null) {
                    a.this.clD.onFail(exc);
                }
            }
        });
    }

    @Override // com.baidu.swan.games.bdtls.b.b
    public void hO(int i) {
        if (com.baidu.swan.games.bdtls.a.DEBUG) {
            Log.d("BDTLS", "onRequestError=" + i);
        }
    }
}
