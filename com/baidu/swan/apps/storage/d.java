package com.baidu.swan.apps.storage;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.swan.apps.runtime.e;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static boolean aKI() {
        String ayF;
        String queryParameter;
        e aHv = e.aHv();
        if (aHv == null || (ayF = aHv.aHy().ayF()) == null || (queryParameter = Uri.parse(ayF).getQueryParameter("params")) == null) {
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
