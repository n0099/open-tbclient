package com.baidu.swan.game.ad.f;

import android.content.Context;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.searchbox.http.HttpManager;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.swan.game.ad.entity.AdResponseInfo;
import okhttp3.Response;
/* loaded from: classes10.dex */
public class b implements com.baidu.swan.game.ad.a.b {
    private boolean cer;
    private Context mContext;

    public b(Context context) {
        this.mContext = context;
    }

    @Override // com.baidu.swan.game.ad.a.b
    public void a(String str, ResponseCallback<AdResponseInfo> responseCallback) {
        this.cer = str.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX);
        if (this.cer) {
            HttpManager.getDefault(this.mContext).getRequest().url(str).cookieManager(com.baidu.swan.apps.w.a.Se().Gd()).build().executeAsync(responseCallback);
            return;
        }
        HttpManager.getDefault(this.mContext).getRequest().url(str).build().executeAsync(responseCallback);
    }

    @Override // com.baidu.swan.game.ad.a.b
    public void nu(String str) {
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
        this.cer = str.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX);
        if (this.cer) {
            HttpManager.getDefault(this.mContext).getRequest().url(str).cookieManager(com.baidu.swan.apps.w.a.Se().Gd()).build().executeAsync(responseCallback);
            return;
        }
        HttpManager.getDefault(this.mContext).getRequest().url(str).build().executeAsync(responseCallback);
    }
}
