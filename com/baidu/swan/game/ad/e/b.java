package com.baidu.swan.game.ad.e;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.http.request.PostBodyRequest;
import com.baidu.swan.game.ad.entity.AdResponseInfo;
import com.baidubce.AbstractBceClient;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class b implements com.baidu.swan.game.ad.a.b {
    private boolean dbL;
    private Context mContext;

    public b(Context context) {
        this.mContext = context;
    }

    @Override // com.baidu.swan.game.ad.a.b
    public void a(String str, ResponseCallback<AdResponseInfo> responseCallback) {
        this.dbL = str.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX);
        if (this.dbL) {
            com.baidu.swan.b.c.a.aKu().getRequest().url(str).cookieManager(com.baidu.swan.apps.t.a.ahH().Us()).build().executeAsync(responseCallback);
            return;
        }
        com.baidu.swan.b.c.a.aKu().getRequest().url(str).build().executeAsync(responseCallback);
    }

    @Override // com.baidu.swan.game.ad.a.b
    public void rx(String str) {
        ResponseCallback<String> responseCallback = new ResponseCallback<String>() { // from class: com.baidu.swan.game.ad.e.b.1
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
        this.dbL = str.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX);
        if (this.dbL) {
            com.baidu.swan.b.c.a.aKu().getRequest().url(str).cookieManager(com.baidu.swan.apps.t.a.ahH().Us()).build().executeAsync(responseCallback);
            return;
        }
        com.baidu.swan.b.c.a.aKu().getRequest().url(str).build().executeAsync(responseCallback);
    }

    @Override // com.baidu.swan.game.ad.a.b
    public void ry(String str) {
        if (!TextUtils.isEmpty(str)) {
            com.baidu.swan.b.b.a aVar = new com.baidu.swan.b.b.a();
            aVar.method = "POST";
            aVar.url = "https://pimlog.baidu.com/mapp/advlog";
            aVar.requestBody = RequestBody.create(MediaType.get(AbstractBceClient.DEFAULT_CONTENT_TYPE), str);
            com.baidu.swan.b.c.a.aKu().b(aVar);
        }
    }

    @Override // com.baidu.swan.game.ad.a.b
    public void b(String str, ResponseCallback<com.baidu.swan.game.ad.c.a> responseCallback) {
        this.dbL = str.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX);
        if (this.dbL) {
            com.baidu.swan.b.c.a.aKu().getRequest().url(str).cookieManager(com.baidu.swan.apps.t.a.ahH().Us()).build().executeAsync(responseCallback);
            return;
        }
        com.baidu.swan.b.c.a.aKu().getRequest().url(str).build().executeAsync(responseCallback);
    }

    @Override // com.baidu.swan.game.ad.a.b
    public void a(String str, JSONObject jSONObject, ResponseCallback<AdResponseInfo> responseCallback) {
        this.dbL = str.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX);
        if (this.dbL) {
            ((PostBodyRequest.PostBodyRequestBuilder) ((PostBodyRequest.PostBodyRequestBuilder) com.baidu.swan.b.c.a.aKu().postRequest().url(str)).cookieManager(com.baidu.swan.apps.t.a.ahH().Us())).requestBody(RequestBody.create(MediaType.parse(AbstractBceClient.DEFAULT_CONTENT_TYPE), jSONObject.toString())).build().executeAsync(responseCallback);
            return;
        }
        ((PostBodyRequest.PostBodyRequestBuilder) com.baidu.swan.b.c.a.aKu().postRequest().url(str)).requestBody(RequestBody.create(MediaType.parse(AbstractBceClient.DEFAULT_CONTENT_TYPE), jSONObject.toString())).build().executeAsync(responseCallback);
    }
}
