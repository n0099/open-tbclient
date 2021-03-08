package com.baidu.swan.apps.scheme.actions.k;

import android.text.TextUtils;
import com.baidu.swan.apps.ao.ai;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import java.util.Map;
/* loaded from: classes8.dex */
public class j {
    public static String sy(String str) {
        return c(str, com.baidu.swan.apps.runtime.d.aIJ().aIF().aIW());
    }

    public static String c(String str, SwanAppConfigData swanAppConfigData) {
        return swanAppConfigData == null ? str : swanAppConfigData.sa(str);
    }

    public static void e(String str, Map<String, String> map) {
        if (!TextUtils.isEmpty(str) && map != null) {
            String delAllParamsFromUrl = ai.delAllParamsFromUrl(str);
            String params = ai.getParams(str);
            String sy = sy(delAllParamsFromUrl);
            if (!TextUtils.equals(delAllParamsFromUrl, sy)) {
                if (!TextUtils.isEmpty(params)) {
                    sy = sy + "?" + params;
                }
                map.put("pageRoutePath", sy);
            }
        }
    }
}
