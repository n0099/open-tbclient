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
/* loaded from: classes19.dex */
public class a {
    private static com.baidu.swan.b.c.a dwm = com.baidu.swan.b.c.a.aKu();
    private static CookieManager dwn = com.baidu.swan.pms.d.aKM().aiv();

    @Deprecated
    public static void a(String str, Map<String, String> map, Map<String, String> map2, JSONObject jSONObject, StatResponseCallback<String> statResponseCallback) {
        if (TextUtils.isEmpty(str)) {
            throw new InvalidParameterException("PMS request URL is empty");
        }
        PostStringRequest.PostStringRequestBuilder mediaType = dwm.postStringRequest().url(e.l(str, map)).content(jSONObject.toString()).mediaType(MediaType.parse(AbstractBceClient.DEFAULT_CONTENT_TYPE));
        if (map2 != null) {
            mediaType.addHeaders(map2);
        }
        mediaType.cookieManager(dwn).enableStat(true).build().executeStat(statResponseCallback);
    }

    @Deprecated
    public static void a(String str, Map<String, String> map, Map<String, String> map2, StatResponseCallback<String> statResponseCallback) {
        if (TextUtils.isEmpty(str)) {
            throw new InvalidParameterException("PMS request URL is empty");
        }
        GetRequest.GetRequestBuilder url = dwm.getRequest().url(e.l(str, map));
        if (map2 != null) {
            url.addHeaders(map2);
        }
        url.cookieManager(dwn).enableStat(true).build().executeStat(statResponseCallback);
    }
}
