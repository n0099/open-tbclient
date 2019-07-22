package com.baidu.swan.b;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class d {
    private static String bxt = b.Yy().getString("openstat_switch", "1");

    public static boolean YA() {
        return TextUtils.equals(bxt, "1");
    }

    public static boolean le(String str) {
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
