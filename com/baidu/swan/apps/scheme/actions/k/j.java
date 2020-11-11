package com.baidu.swan.apps.scheme.actions.k;

import android.text.TextUtils;
import com.baidu.swan.apps.ap.ai;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import java.util.Map;
/* loaded from: classes10.dex */
public class j {
    public static String sK(String str) {
        return c(str, com.baidu.swan.apps.runtime.d.aHq().aHm().aHD());
    }

    public static String c(String str, SwanAppConfigData swanAppConfigData) {
        return swanAppConfigData == null ? str : swanAppConfigData.sm(str);
    }

    public static void g(String str, Map<String, String> map) {
        if (!TextUtils.isEmpty(str) && map != null) {
            String delAllParamsFromUrl = ai.delAllParamsFromUrl(str);
            String params = ai.getParams(str);
            String sK = sK(delAllParamsFromUrl);
            if (!TextUtils.equals(delAllParamsFromUrl, sK)) {
                if (!TextUtils.isEmpty(params)) {
                    sK = sK + "?" + params;
                }
                map.put("pageRoutePath", sK);
            }
        }
    }
}
