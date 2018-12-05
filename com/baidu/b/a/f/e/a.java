package com.baidu.b.a.f.e;

import com.baidu.searchbox.http.HttpManager;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.http.cookie.CookieManager;
import com.baidu.searchbox.http.request.PostFormRequest;
import java.util.Map;
/* loaded from: classes2.dex */
public class a {
    private static HttpManager aax;
    private static CookieManager aay;

    public static void a(HttpManager httpManager, CookieManager cookieManager) {
        aax = httpManager;
        aay = cookieManager;
    }

    public static void a(String str, Map<String, String> map, Map<String, String> map2, Map<String, String> map3, ResponseCallback<String> responseCallback) {
        ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) aax.postFormRequest().url(com.baidu.b.a.g.a.sa().c(str, map))).addHeaders(map2)).addParams(map3).cookieManager(aay)).build().executeAsync(responseCallback);
    }
}
