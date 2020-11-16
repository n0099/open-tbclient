package com.baidu.swan.apps.scheme.actions.k;

import android.text.TextUtils;
import com.baidu.swan.apps.ap.ai;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import java.util.Map;
/* loaded from: classes7.dex */
public class j {
    public static String sF(String str) {
        return c(str, com.baidu.swan.apps.runtime.d.aGI().aGE().aGV());
    }

    public static String c(String str, SwanAppConfigData swanAppConfigData) {
        return swanAppConfigData == null ? str : swanAppConfigData.sh(str);
    }

    public static void f(String str, Map<String, String> map) {
        if (!TextUtils.isEmpty(str) && map != null) {
            String delAllParamsFromUrl = ai.delAllParamsFromUrl(str);
            String params = ai.getParams(str);
            String sF = sF(delAllParamsFromUrl);
            if (!TextUtils.equals(delAllParamsFromUrl, sF)) {
                if (!TextUtils.isEmpty(params)) {
                    sF = sF + "?" + params;
                }
                map.put("pageRoutePath", sF);
            }
        }
    }
}
