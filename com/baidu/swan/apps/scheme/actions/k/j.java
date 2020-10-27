package com.baidu.swan.apps.scheme.actions.k;

import android.text.TextUtils;
import com.baidu.swan.apps.ap.ai;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import java.util.Map;
/* loaded from: classes10.dex */
public class j {
    public static String sw(String str) {
        return c(str, com.baidu.swan.apps.runtime.d.aEQ().aEM().aFd());
    }

    public static String c(String str, SwanAppConfigData swanAppConfigData) {
        return swanAppConfigData == null ? str : swanAppConfigData.rY(str);
    }

    public static void g(String str, Map<String, String> map) {
        if (!TextUtils.isEmpty(str) && map != null) {
            String delAllParamsFromUrl = ai.delAllParamsFromUrl(str);
            String params = ai.getParams(str);
            String sw = sw(delAllParamsFromUrl);
            if (!TextUtils.equals(delAllParamsFromUrl, sw)) {
                if (!TextUtils.isEmpty(params)) {
                    sw = sw + "?" + params;
                }
                map.put("pageRoutePath", sw);
            }
        }
    }
}
