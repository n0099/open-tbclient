package com.baidu.swan.b;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.ubc.g;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c {
    private static final boolean DEBUG = g.DEBUG;
    private static String bqh = b.TD().getString("openstat_switch", "1");

    public static boolean TE() {
        return TextUtils.equals(bqh, "1");
    }

    public static boolean jW(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return new JSONObject(str).has("bizId");
        } catch (JSONException e) {
            if (DEBUG) {
                Log.e("OpenStatUtils", "OpenStat content is not a json", e);
                return false;
            }
            return false;
        }
    }
}
