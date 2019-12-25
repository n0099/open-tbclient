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
/* loaded from: classes9.dex */
public class a<T> extends b {
    private String cgX = null;
    private String cgY = null;
    private ResponseCallback<T> cgZ = null;

    public void a(String str, String str2, ResponseCallback<T> responseCallback) {
        if (!TextUtils.isEmpty(str)) {
            this.cgX = str;
            this.cgY = str2;
            this.cgZ = responseCallback;
            if (com.baidu.swan.games.bdtls.a.DEBUG) {
                Log.d("BDTLS", "requestPost url=" + str);
                Log.d("BDTLS", "requestPost body=" + str2);
            }
            od(this.cgY);
        }
    }

    @Override // com.baidu.swan.games.bdtls.b.b
    public void I(byte[] bArr) {
        String str = this.cgX;
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/json");
        if (this.chc) {
            hashMap.put("Bdtls", "Bdtls");
        }
        if (com.baidu.swan.games.bdtls.a.DEBUG) {
            Log.d("BDTLS", "BdtlsPostRequest url=" + str);
        }
        HttpManager.getDefault(AppRuntime.getAppContext()).postByteRequest().mediaType("application/json").url(str).cookieManager(com.baidu.swan.apps.w.a.RI().FH()).headers(hashMap).content(bArr).build().executeAsync(new ResponseCallback<String>() { // from class: com.baidu.swan.games.bdtls.b.a.1
            T cha;

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            public String parseResponse(Response response, int i) throws Exception {
                String str2 = "";
                if (!a.this.chc) {
                    if (a.this.cgZ != null) {
                        this.cha = (T) a.this.cgZ.parseResponse(response, i);
                    }
                } else {
                    ResponseBody body = response.body();
                    str2 = a.this.J(body.bytes());
                    if (com.baidu.swan.games.bdtls.a.DEBUG) {
                        Log.d("BDTLS", "BdtlsPostRequest parseResponse=" + str2);
                    }
                    if (a.this.chd == 1) {
                        Buffer buffer = new Buffer();
                        buffer.writeString(str2, Charset.forName("utf-8"));
                        Response build = response.newBuilder().body(ResponseBody.create(body.contentType(), buffer.size(), buffer)).build();
                        if (a.this.cgZ != null) {
                            this.cha = (T) a.this.cgZ.parseResponse(build, i);
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
                if (!a.this.chc) {
                    if (a.this.cgZ != null) {
                        a.this.cgZ.onSuccess(this.cha, i);
                    }
                } else if (a.this.chd != 1) {
                    a.this.a(a.this.cgX, a.this.cgY, a.this.cgZ);
                } else {
                    f.ob("application");
                    if (a.this.cgZ != null) {
                        a.this.cgZ.onSuccess(this.cha, i);
                    }
                }
            }

            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            public void onFail(Exception exc) {
                if (com.baidu.swan.games.bdtls.a.DEBUG) {
                    Log.d("BDTLS", "BdtlsPostRequest onFail=" + exc.getMessage());
                }
                if (a.this.cgZ != null) {
                    a.this.cgZ.onFail(exc);
                }
            }
        });
    }

    @Override // com.baidu.swan.games.bdtls.b.b
    public void hx(int i) {
        if (com.baidu.swan.games.bdtls.a.DEBUG) {
            Log.d("BDTLS", "onRequestError=" + i);
        }
    }
}
