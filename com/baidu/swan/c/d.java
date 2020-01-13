package com.baidu.swan.c;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class d {
    private static String cBI = b.atN().getString("openstat_switch", "1");

    public static boolean atP() {
        return TextUtils.equals(cBI, "1");
    }

    public static boolean qQ(String str) {
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
