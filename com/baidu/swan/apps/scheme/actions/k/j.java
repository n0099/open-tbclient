package com.baidu.swan.apps.scheme.actions.k;

import android.text.TextUtils;
import com.baidu.swan.apps.ap.ai;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import java.util.Map;
/* loaded from: classes8.dex */
public class j {
    public static String qW(String str) {
        return c(str, com.baidu.swan.apps.runtime.d.azE().azA().azR());
    }

    public static String c(String str, SwanAppConfigData swanAppConfigData) {
        return swanAppConfigData == null ? str : swanAppConfigData.qz(str);
    }

    public static void g(String str, Map<String, String> map) {
        if (!TextUtils.isEmpty(str) && map != null) {
            String delAllParamsFromUrl = ai.delAllParamsFromUrl(str);
            String params = ai.getParams(str);
            String qW = qW(delAllParamsFromUrl);
            if (!TextUtils.equals(delAllParamsFromUrl, qW)) {
                if (!TextUtils.isEmpty(params)) {
                    qW = qW + "?" + params;
                }
                map.put("pageRoutePath", qW);
            }
        }
    }
}
