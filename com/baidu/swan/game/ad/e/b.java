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
/* loaded from: classes14.dex */
public class b implements com.baidu.swan.game.ad.a.b {
    private boolean dTN;
    private Context mContext;

    public b(Context context) {
        this.mContext = context;
    }

    @Override // com.baidu.swan.game.ad.a.b
    public void a(String str, ResponseCallback<AdResponseInfo> responseCallback) {
        this.dTN = str.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX);
        if (this.dTN) {
            com.baidu.swan.a.c.a.bdi().getRequest().url(str).cookieManager(com.baidu.swan.apps.t.a.azz().akJ()).build().executeAsync(responseCallback);
            return;
        }
        com.baidu.swan.a.c.a.bdi().getRequest().url(str).build().executeAsync(responseCallback);
    }

    @Override // com.baidu.swan.game.ad.a.b
    public void wf(String str) {
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
        this.dTN = str.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX);
        if (this.dTN) {
            com.baidu.swan.a.c.a.bdi().getRequest().url(str).cookieManager(com.baidu.swan.apps.t.a.azz().akJ()).build().executeAsync(responseCallback);
            return;
        }
        com.baidu.swan.a.c.a.bdi().getRequest().url(str).build().executeAsync(responseCallback);
    }

    @Override // com.baidu.swan.game.ad.a.b
    public void wg(String str) {
        if (!TextUtils.isEmpty(str)) {
            com.baidu.swan.a.b.a aVar = new com.baidu.swan.a.b.a();
            aVar.method = "POST";
            aVar.url = "https://pimlog.baidu.com/mapp/advlog";
            aVar.requestBody = RequestBody.create(MediaType.get(AbstractBceClient.DEFAULT_CONTENT_TYPE), str);
            com.baidu.swan.a.c.a.bdi().b(aVar);
        }
    }

    @Override // com.baidu.swan.game.ad.a.b
    public void b(String str, ResponseCallback<com.baidu.swan.game.ad.c.a> responseCallback) {
        this.dTN = str.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX);
        if (this.dTN) {
            com.baidu.swan.a.c.a.bdi().getRequest().url(str).cookieManager(com.baidu.swan.apps.t.a.azz().akJ()).build().executeAsync(responseCallback);
            return;
        }
        com.baidu.swan.a.c.a.bdi().getRequest().url(str).build().executeAsync(responseCallback);
    }

    @Override // com.baidu.swan.game.ad.a.b
    public void a(String str, JSONObject jSONObject, ResponseCallback<AdResponseInfo> responseCallback) {
        this.dTN = str.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX);
        if (this.dTN) {
            ((PostBodyRequest.PostBodyRequestBuilder) ((PostBodyRequest.PostBodyRequestBuilder) com.baidu.swan.a.c.a.bdi().postRequest().url(str)).cookieManager(com.baidu.swan.apps.t.a.azz().akJ())).requestBody(RequestBody.create(MediaType.parse(AbstractBceClient.DEFAULT_CONTENT_TYPE), jSONObject.toString())).build().executeAsync(responseCallback);
            return;
        }
        ((PostBodyRequest.PostBodyRequestBuilder) com.baidu.swan.a.c.a.bdi().postRequest().url(str)).requestBody(RequestBody.create(MediaType.parse(AbstractBceClient.DEFAULT_CONTENT_TYPE), jSONObject.toString())).build().executeAsync(responseCallback);
    }
}
