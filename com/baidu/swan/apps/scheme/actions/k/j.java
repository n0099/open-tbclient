package com.baidu.swan.apps.scheme.actions.k;

import android.text.TextUtils;
import com.baidu.swan.apps.aq.aj;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import java.util.Map;
/* loaded from: classes7.dex */
public class j {
    public static String oZ(String str) {
        return c(str, com.baidu.swan.apps.runtime.d.arr().arn().arE());
    }

    public static String c(String str, SwanAppConfigData swanAppConfigData) {
        return swanAppConfigData == null ? str : swanAppConfigData.oC(str);
    }

    public static void g(String str, Map<String, String> map) {
        if (!TextUtils.isEmpty(str) && map != null) {
            String delAllParamsFromUrl = aj.delAllParamsFromUrl(str);
            String params = aj.getParams(str);
            String oZ = oZ(delAllParamsFromUrl);
            if (!TextUtils.equals(delAllParamsFromUrl, oZ)) {
                if (!TextUtils.isEmpty(params)) {
                    oZ = oZ + "?" + params;
                }
                map.put("pageRoutePath", oZ);
            }
        }
    }
}
