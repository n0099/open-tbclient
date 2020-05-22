package com.baidu.swan.game.ad.f;

import android.content.Context;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.swan.game.ad.entity.AdResponseInfo;
import okhttp3.Response;
/* loaded from: classes11.dex */
public class b implements com.baidu.swan.game.ad.a.b {
    private boolean cRT;
    private Context mContext;

    public b(Context context) {
        this.mContext = context;
    }

    @Override // com.baidu.swan.game.ad.a.b
    public void a(String str, ResponseCallback<AdResponseInfo> responseCallback) {
        this.cRT = str.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX);
        if (this.cRT) {
            com.baidu.swan.c.c.a.aFx().getRequest().url(str).cookieManager(com.baidu.swan.apps.u.a.afo().SM()).build().executeAsync(responseCallback);
            return;
        }
        com.baidu.swan.c.c.a.aFx().getRequest().url(str).build().executeAsync(responseCallback);
    }

    @Override // com.baidu.swan.game.ad.a.b
    public void qv(String str) {
        ResponseCallback<String> responseCallback = new ResponseCallback<String>() { // from class: com.baidu.swan.game.ad.f.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            public String parseResponse(Response response, int i) throws Exception {
                if (response != null && response.body() != null) {
                    response.body().close();
                    return "";
                }
                return "";
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            public void onSuccess(String str2, int i) {
            }

            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            public void onFail(Exception exc) {
            }
        };
        this.cRT = str.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX);
        if (this.cRT) {
            com.baidu.swan.c.c.a.aFx().getRequest().url(str).cookieManager(com.baidu.swan.apps.u.a.afo().SM()).build().executeAsync(responseCallback);
            return;
        }
        com.baidu.swan.c.c.a.aFx().getRequest().url(str).build().executeAsync(responseCallback);
    }
}
