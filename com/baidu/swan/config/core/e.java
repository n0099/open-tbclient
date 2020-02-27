package com.baidu.swan.config.core;

import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.HttpManager;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidubce.AbstractBceClient;
import okhttp3.MediaType;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class e {
    public static void b(JSONObject jSONObject, ResponseCallback responseCallback) {
        HttpManager.getDefault(AppRuntime.getAppContext()).postStringRequest().url(f.processCommonParams(UP())).content(jSONObject.toString()).mediaType(MediaType.parse(AbstractBceClient.DEFAULT_CONTENT_TYPE)).cookieManager(com.baidu.swan.config.e.aiW().UY()).build().executeAsync(responseCallback);
    }

    private static String UP() {
        return String.format("%s/fetchbasedata", com.baidu.swan.config.e.aiW().Vb());
    }
}
