package com.baidu.swan.apps.storage;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.swan.apps.runtime.e;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static boolean acY() {
        String Tv;
        String queryParameter;
        e aaq = e.aaq();
        if (aaq == null || (Tv = aaq.aas().Tv()) == null || (queryParameter = Uri.parse(Tv).getQueryParameter("params")) == null) {
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
