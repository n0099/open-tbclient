package com.baidu.swan.pms.b;

import android.text.TextUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.HttpManager;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.http.cookie.CookieManager;
import com.baidu.searchbox.http.request.GetRequest;
import java.security.InvalidParameterException;
import java.util.Map;
/* loaded from: classes2.dex */
public class a {
    private static HttpManager bme = HttpManager.newHttpManager(AppRuntime.getAppContext());
    private static CookieManager bmf = com.baidu.swan.pms.e.Ru().Dn();

    public static void a(String str, Map<String, String> map, Map<String, String> map2, ResponseCallback<String> responseCallback) {
        if (TextUtils.isEmpty(str)) {
            throw new InvalidParameterException("PMS request URL is empty");
        }
        GetRequest.GetRequestBuilder url = bme.getRequest().url(e.g(str, map));
        if (map2 != null) {
            url.addHeaders(map2);
        }
        url.cookieManager(bmf).build().executeAsync(responseCallback);
    }
}
