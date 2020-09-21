package com.baidu.swan.apps.scheme.actions.k;

import android.text.TextUtils;
import com.baidu.swan.apps.ap.ai;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import java.util.Map;
/* loaded from: classes3.dex */
public class j {
    public static String rq(String str) {
        return c(str, com.baidu.swan.apps.runtime.d.aAn().aAj().aAA());
    }

    public static String c(String str, SwanAppConfigData swanAppConfigData) {
        return swanAppConfigData == null ? str : swanAppConfigData.qT(str);
    }

    public static void g(String str, Map<String, String> map) {
        if (!TextUtils.isEmpty(str) && map != null) {
            String delAllParamsFromUrl = ai.delAllParamsFromUrl(str);
            String params = ai.getParams(str);
            String rq = rq(delAllParamsFromUrl);
            if (!TextUtils.equals(delAllParamsFromUrl, rq)) {
                if (!TextUtils.isEmpty(params)) {
                    rq = rq + "?" + params;
                }
                map.put("pageRoutePath", rq);
            }
        }
    }
}
