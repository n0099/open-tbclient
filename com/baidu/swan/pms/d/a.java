package com.baidu.swan.pms.d;

import com.baidu.swan.pms.d;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a {
    public static void a(int i, String str, String str2, int i2, JSONObject jSONObject) {
        d.aBC().a(iS(i), str, str2, i2, jSONObject);
    }

    private static String iS(int i) {
        switch (i) {
            case 0:
                return "swan";
            case 1:
                return "swangame";
            case 2:
                return "swangameconsole";
            case 3:
                return "swandynamiclib";
            case 4:
                return "swanplugin";
            default:
                return "unknown";
        }
    }
}
