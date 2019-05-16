package com.baidu.swan.pms.c;

import com.baidu.swan.pms.e;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {
    public static void a(int i, String str, String str2, int i2, JSONObject jSONObject) {
        e.Vg().a(fI(i), str, str2, i2, jSONObject);
    }

    private static String fI(int i) {
        switch (i) {
            case 0:
                return "swan";
            case 1:
                return "swangame";
            case 2:
                return "swanplugin";
            default:
                return "unknown";
        }
    }
}
