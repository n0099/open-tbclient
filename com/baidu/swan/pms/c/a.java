package com.baidu.swan.pms.c;

import android.text.TextUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.HttpManager;
import com.baidu.searchbox.http.callback.StatResponseCallback;
import com.baidu.searchbox.http.cookie.CookieManager;
import com.baidu.searchbox.http.request.GetRequest;
import com.baidu.searchbox.http.request.PostStringRequest;
import com.baidubce.AbstractBceClient;
import java.security.InvalidParameterException;
import java.util.Map;
import okhttp3.MediaType;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a {
    private static HttpManager cBi = HttpManager.newHttpManager(AppRuntime.getAppContext());
    private static CookieManager cBj = com.baidu.swan.pms.d.atn().UY();

    public static void a(String str, Map<String, String> map, Map<String, String> map2, JSONObject jSONObject, StatResponseCallback<String> statResponseCallback) {
        if (TextUtils.isEmpty(str)) {
            throw new InvalidParameterException("PMS request URL is empty");
        }
        PostStringRequest.PostStringRequestBuilder mediaType = cBi.postStringRequest().url(e.g(str, map)).content(jSONObject.toString()).mediaType(MediaType.parse(AbstractBceClient.DEFAULT_CONTENT_TYPE));
        if (map2 != null) {
            mediaType.addHeaders(map2);
        }
        mediaType.cookieManager(cBj).enableStat(true).build().executeStat(statResponseCallback);
    }

    public static void a(String str, Map<String, String> map, Map<String, String> map2, StatResponseCallback<String> statResponseCallback) {
        if (TextUtils.isEmpty(str)) {
            throw new InvalidParameterException("PMS request URL is empty");
        }
        GetRequest.GetRequestBuilder url = cBi.getRequest().url(e.g(str, map));
        if (map2 != null) {
            url.addHeaders(map2);
        }
        url.cookieManager(cBj).enableStat(true).build().executeStat(statResponseCallback);
    }
}
