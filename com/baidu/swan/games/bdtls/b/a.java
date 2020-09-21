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
/* loaded from: classes3.dex */
public class a<T> extends b {
    private String drV = null;
    private String drW = null;
    private ResponseCallback<T> drX = null;
    private int mRetryCount;

    static /* synthetic */ int c(a aVar) {
        int i = aVar.mRetryCount;
        aVar.mRetryCount = i + 1;
        return i;
    }

    public void b(String str, String str2, ResponseCallback<T> responseCallback) {
        if (!TextUtils.isEmpty(str)) {
            this.drV = str;
            this.drW = str2;
            this.drX = responseCallback;
            if (com.baidu.swan.games.bdtls.a.DEBUG) {
                Log.d("BDTLS", "requestPost url=" + str);
                Log.d("BDTLS", "requestPost body=" + str2);
            }
            vc(this.drW);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aNi() {
        b(this.drV, this.drW, this.drX);
    }

    @Override // com.baidu.swan.games.bdtls.b.b
    public void Y(byte[] bArr) {
        String str = this.drV;
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", HttpHelper.CONTENT_JSON);
        if (this.dsa) {
            hashMap.put("Bdtls", "Bdtls");
        }
        if (com.baidu.swan.games.bdtls.a.DEBUG) {
            Log.d("BDTLS", "BdtlsPostRequest url=" + str);
        }
        com.baidu.swan.a.c.a.aTI().postByteRequest().mediaType(HttpHelper.CONTENT_JSON).url(str).cookieManager(com.baidu.swan.apps.t.a.apT().abd()).headers(hashMap).content(bArr).build().executeAsync(new ResponseCallback<String>() { // from class: com.baidu.swan.games.bdtls.b.a.1
            T drY;

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            public String parseResponse(Response response, int i) throws Exception {
                Headers headers = response.headers();
                if (headers != null && TextUtils.equals(headers.get("Bdtls"), "recovery")) {
                    e.aLY().aLZ().lj(0);
                    return "recovery";
                } else if (!a.this.dsa) {
                    if (a.this.drX != null) {
                        this.drY = (T) a.this.drX.parseResponse(response, i);
                        return "";
                    }
                    return "";
                } else {
                    ResponseBody body = response.body();
                    String Z = a.this.Z(body.bytes());
                    if (com.baidu.swan.games.bdtls.a.DEBUG) {
                        Log.d("BDTLS", "BdtlsPostRequest parseResponse=" + Z);
                    }
                    if (a.this.dsb == 1) {
                        Buffer buffer = new Buffer();
                        buffer.writeString(Z, Charset.forName("utf-8"));
                        Response build = response.newBuilder().body(ResponseBody.create(body.contentType(), buffer.size(), buffer)).build();
                        if (a.this.drX != null) {
                            this.drY = (T) a.this.drX.parseResponse(build, i);
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
                    if (!e.aLY().aLZ().aNa()) {
                        a.this.drX.onFail(new Exception("Exceeded the limit of continuous downgrade"));
                        return;
                    }
                    e.aLY().aLZ().aMY();
                    a.this.gA(true);
                    a.this.aNi();
                    return;
                }
                e.aLY().aLZ().aNb();
                if (!a.this.dsa) {
                    if (a.this.drX != null) {
                        a.this.drX.onSuccess(this.drY, i);
                        a.this.mRetryCount = 0;
                    }
                } else if (a.this.dsb == 1) {
                    f.va("application");
                    if (a.this.drX != null) {
                        a.this.drX.onSuccess(this.drY, i);
                    }
                    a.this.mRetryCount = 0;
                } else if (a.c(a.this) < 3) {
                    a.this.b(a.this.drV, a.this.drW, a.this.drX);
                } else {
                    a.this.drX.onFail(new IOException("request fail : " + this.drY));
                    a.this.mRetryCount = 0;
                }
            }

            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            public void onFail(Exception exc) {
                if (com.baidu.swan.games.bdtls.a.DEBUG) {
                    Log.d("BDTLS", "BdtlsPostRequest onFail=" + exc.getMessage());
                }
                if (a.this.drX != null) {
                    a.this.drX.onFail(exc);
                }
            }
        });
    }

    @Override // com.baidu.swan.games.bdtls.b.b
    public void lk(int i) {
        if (com.baidu.swan.games.bdtls.a.DEBUG) {
            Log.d("BDTLS", "onRequestError=" + i);
        }
        if (this.drX != null) {
            this.drX.onFail(new Exception("request error  code : " + i));
        }
    }

    @Override // com.baidu.swan.games.bdtls.b.b
    public void b(IOException iOException) {
        if (this.drX != null) {
            this.drX.onFail(iOException);
        }
    }

    @Override // com.baidu.swan.games.bdtls.b.b
    public String getMethod() {
        return "POST";
    }
}
