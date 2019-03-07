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
    private static HttpManager bma = HttpManager.newHttpManager(AppRuntime.getAppContext());
    private static CookieManager bmb = com.baidu.swan.pms.e.Rw().Dp();

    public static void a(String str, Map<String, String> map, Map<String, String> map2, ResponseCallback<String> responseCallback) {
        if (TextUtils.isEmpty(str)) {
            throw new InvalidParameterException("PMS request URL is empty");
        }
        GetRequest.GetRequestBuilder url = bma.getRequest().url(e.g(str, map));
        if (map2 != null) {
            url.addHeaders(map2);
        }
        url.cookieManager(bmb).build().executeAsync(responseCallback);
    }
}
