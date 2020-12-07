package com.baidu.swan.apps.storage;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.swan.apps.runtime.e;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes25.dex */
public class d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static boolean aNh() {
        String aBg;
        String queryParameter;
        e aJV = e.aJV();
        if (aJV == null || (aBg = aJV.aJY().aBg()) == null || (queryParameter = Uri.parse(aBg).getQueryParameter("params")) == null) {
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
