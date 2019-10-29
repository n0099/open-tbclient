package com.baidu.swan.b;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class d {
    private static String bQx = b.adr().getString("openstat_switch", "1");

    public static boolean adt() {
        return TextUtils.equals(bQx, "1");
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
