package com.baidu.swan.apps.scheme.actions.k;

import android.text.TextUtils;
import com.baidu.swan.apps.ao.ai;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import java.util.Map;
/* loaded from: classes9.dex */
public class j {
    public static String sq(String str) {
        return c(str, com.baidu.swan.apps.runtime.d.aIG().aIC().aIT());
    }

    public static String c(String str, SwanAppConfigData swanAppConfigData) {
        return swanAppConfigData == null ? str : swanAppConfigData.rT(str);
    }

    public static void e(String str, Map<String, String> map) {
        if (!TextUtils.isEmpty(str) && map != null) {
            String delAllParamsFromUrl = ai.delAllParamsFromUrl(str);
            String params = ai.getParams(str);
            String sq = sq(delAllParamsFromUrl);
            if (!TextUtils.equals(delAllParamsFromUrl, sq)) {
                if (!TextUtils.isEmpty(params)) {
                    sq = sq + "?" + params;
                }
                map.put("pageRoutePath", sq);
            }
        }
    }
}
