package com.baidu.swan.b;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class d {
    private static String bxR = b.YC().getString("openstat_switch", "1");

    public static boolean YE() {
        return TextUtils.equals(bxR, "1");
    }

    public static boolean lg(String str) {
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
