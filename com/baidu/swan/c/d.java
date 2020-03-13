package com.baidu.swan.c;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class d {
    private static String cFI = b.awd().getString("openstat_switch", "1");

    public static boolean awf() {
        return TextUtils.equals(cFI, "1");
    }

    public static boolean rf(String str) {
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
