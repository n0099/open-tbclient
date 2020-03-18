package com.baidu.swan.c;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class d {
    private static String cFT = b.awg().getString("openstat_switch", "1");

    public static boolean awi() {
        return TextUtils.equals(cFT, "1");
    }

    public static boolean re(String str) {
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
