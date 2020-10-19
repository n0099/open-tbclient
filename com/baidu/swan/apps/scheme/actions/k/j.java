package com.baidu.swan.apps.scheme.actions.k;

import android.text.TextUtils;
import com.baidu.swan.apps.ap.ai;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import java.util.Map;
/* loaded from: classes10.dex */
public class j {
    public static String sc(String str) {
        return c(str, com.baidu.swan.apps.runtime.d.aCW().aCS().aDj());
    }

    public static String c(String str, SwanAppConfigData swanAppConfigData) {
        return swanAppConfigData == null ? str : swanAppConfigData.rF(str);
    }

    public static void g(String str, Map<String, String> map) {
        if (!TextUtils.isEmpty(str) && map != null) {
            String delAllParamsFromUrl = ai.delAllParamsFromUrl(str);
            String params = ai.getParams(str);
            String sc = sc(delAllParamsFromUrl);
            if (!TextUtils.equals(delAllParamsFromUrl, sc)) {
                if (!TextUtils.isEmpty(params)) {
                    sc = sc + "?" + params;
                }
                map.put("pageRoutePath", sc);
            }
        }
    }
}
