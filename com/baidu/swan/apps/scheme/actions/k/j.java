package com.baidu.swan.apps.scheme.actions.k;

import android.text.TextUtils;
import com.baidu.swan.apps.ao.ai;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import java.util.Map;
/* loaded from: classes8.dex */
public class j {
    public static String rX(String str) {
        return c(str, com.baidu.swan.apps.runtime.d.aIn().aIj().aIA());
    }

    public static String c(String str, SwanAppConfigData swanAppConfigData) {
        return swanAppConfigData == null ? str : swanAppConfigData.rA(str);
    }

    public static void f(String str, Map<String, String> map) {
        if (!TextUtils.isEmpty(str) && map != null) {
            String delAllParamsFromUrl = ai.delAllParamsFromUrl(str);
            String params = ai.getParams(str);
            String rX = rX(delAllParamsFromUrl);
            if (!TextUtils.equals(delAllParamsFromUrl, rX)) {
                if (!TextUtils.isEmpty(params)) {
                    rX = rX + "?" + params;
                }
                map.put("pageRoutePath", rX);
            }
        }
    }
}
