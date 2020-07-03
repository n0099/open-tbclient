package com.baidu.swan.apps.scheme.actions.k;

import android.text.TextUtils;
import com.baidu.swan.apps.aq.ah;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import java.util.Map;
/* loaded from: classes11.dex */
public class j {
    public static String oq(String str) {
        return b(str, com.baidu.swan.apps.runtime.d.apI().apE().apV());
    }

    public static String b(String str, SwanAppConfigData swanAppConfigData) {
        return swanAppConfigData == null ? str : swanAppConfigData.nU(str);
    }

    public static void f(String str, Map<String, String> map) {
        if (!TextUtils.isEmpty(str) && map != null) {
            String delAllParamsFromUrl = ah.delAllParamsFromUrl(str);
            String params = ah.getParams(str);
            String oq = oq(delAllParamsFromUrl);
            if (!TextUtils.equals(delAllParamsFromUrl, oq)) {
                if (!TextUtils.isEmpty(params)) {
                    oq = oq + "?" + params;
                }
                map.put("pageRoutePath", oq);
            }
        }
    }
}
