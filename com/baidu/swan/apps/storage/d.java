package com.baidu.swan.apps.storage;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.swan.apps.runtime.e;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static boolean arE() {
        String agM;
        String queryParameter;
        e aoG = e.aoG();
        if (aoG == null || (agM = aoG.aoJ().agM()) == null || (queryParameter = Uri.parse(agM).getQueryParameter("params")) == null) {
            return false;
        }
        try {
            return TextUtils.equals(new JSONObject(queryParameter).optString("forcePath"), "homepage");
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
                return false;
            }
            return false;
        }
    }
}
