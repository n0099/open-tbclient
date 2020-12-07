package com.baidu.swan.apps.scheme.actions.k;

import android.text.TextUtils;
import com.baidu.swan.apps.ap.ai;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import java.util.Map;
/* loaded from: classes25.dex */
public class j {
    public static String tm(String str) {
        return c(str, com.baidu.swan.apps.runtime.d.aJQ().aJM().aKd());
    }

    public static String c(String str, SwanAppConfigData swanAppConfigData) {
        return swanAppConfigData == null ? str : swanAppConfigData.sP(str);
    }

    public static void f(String str, Map<String, String> map) {
        if (!TextUtils.isEmpty(str) && map != null) {
            String delAllParamsFromUrl = ai.delAllParamsFromUrl(str);
            String params = ai.getParams(str);
            String tm = tm(delAllParamsFromUrl);
            if (!TextUtils.equals(delAllParamsFromUrl, tm)) {
                if (!TextUtils.isEmpty(params)) {
                    tm = tm + "?" + params;
                }
                map.put("pageRoutePath", tm);
            }
        }
    }
}
