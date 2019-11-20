package com.baidu.swan.b;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class d {
    private static String bPG = b.adp().getString("openstat_switch", "1");

    public static boolean adr() {
        return TextUtils.equals(bPG, "1");
    }

    public static boolean lI(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return new JSONObject(str).has("bizId");
        } catch (JSONException e) {
            return false;
        }
    }
}
