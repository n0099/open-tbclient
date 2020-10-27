package com.baidu.swan.pms.c;

import android.text.TextUtils;
import com.baidu.searchbox.http.callback.StatResponseCallback;
import com.baidu.searchbox.http.cookie.CookieManager;
import com.baidu.searchbox.http.request.GetRequest;
import com.baidu.searchbox.http.request.PostStringRequest;
import com.baidubce.AbstractBceClient;
import java.security.InvalidParameterException;
import java.util.Map;
import okhttp3.MediaType;
import org.json.JSONObject;
@Deprecated
/* loaded from: classes15.dex */
public class a {
    private static com.baidu.swan.a.c.a ebV = com.baidu.swan.a.c.a.aYk();
    private static CookieManager ebW = com.baidu.swan.pms.d.aYB().avr();

    @Deprecated
    public static void a(String str, Map<String, String> map, Map<String, String> map2, JSONObject jSONObject, StatResponseCallback<String> statResponseCallback) {
        if (TextUtils.isEmpty(str)) {
            throw new InvalidParameterException("PMS request URL is empty");
        }
        PostStringRequest.PostStringRequestBuilder mediaType = ebV.postStringRequest().url(e.k(str, map)).content(jSONObject.toString()).mediaType(MediaType.parse(AbstractBceClient.DEFAULT_CONTENT_TYPE));
        if (map2 != null) {
            mediaType.addHeaders(map2);
        }
        mediaType.cookieManager(ebW).enableStat(true).build().executeStat(statResponseCallback);
    }

    @Deprecated
    public static void a(String str, Map<String, String> map, Map<String, String> map2, StatResponseCallback<String> statResponseCallback) {
        if (TextUtils.isEmpty(str)) {
            throw new InvalidParameterException("PMS request URL is empty");
        }
        GetRequest.GetRequestBuilder url = ebV.getRequest().url(e.k(str, map));
        if (map2 != null) {
            url.addHeaders(map2);
        }
        url.cookieManager(ebW).enableStat(true).build().executeStat(statResponseCallback);
    }
}
