package com.baidu.swan.apps.scheme.actions.k;

import android.text.TextUtils;
import com.baidu.swan.apps.ao.ai;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import java.util.Map;
/* loaded from: classes9.dex */
public class j {
    public static String tj(String str) {
        return c(str, com.baidu.swan.apps.runtime.d.aMh().aMd().aMu());
    }

    public static String c(String str, SwanAppConfigData swanAppConfigData) {
        return swanAppConfigData == null ? str : swanAppConfigData.sM(str);
    }

    public static void f(String str, Map<String, String> map) {
        if (!TextUtils.isEmpty(str) && map != null) {
            String delAllParamsFromUrl = ai.delAllParamsFromUrl(str);
            String params = ai.getParams(str);
            String tj = tj(delAllParamsFromUrl);
            if (!TextUtils.equals(delAllParamsFromUrl, tj)) {
                if (!TextUtils.isEmpty(params)) {
                    tj = tj + "?" + params;
                }
                map.put("pageRoutePath", tj);
            }
        }
    }
}
