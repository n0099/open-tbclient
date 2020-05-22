package com.baidu.swan.apps.scheme.actions.k;

import android.text.TextUtils;
import com.baidu.swan.apps.aq.ah;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import java.util.Map;
/* loaded from: classes11.dex */
public class j {
    public static String oh(String str) {
        return b(str, com.baidu.swan.apps.runtime.d.aoB().aox().aoO());
    }

    public static String b(String str, SwanAppConfigData swanAppConfigData) {
        return swanAppConfigData == null ? str : swanAppConfigData.nM(str);
    }

    public static void f(String str, Map<String, String> map) {
        if (!TextUtils.isEmpty(str) && map != null) {
            String delAllParamsFromUrl = ah.delAllParamsFromUrl(str);
            String params = ah.getParams(str);
            String oh = oh(delAllParamsFromUrl);
            if (!TextUtils.equals(delAllParamsFromUrl, oh)) {
                if (!TextUtils.isEmpty(params)) {
                    oh = oh + "?" + params;
                }
                map.put("pageRoutePath", oh);
            }
        }
    }
}
