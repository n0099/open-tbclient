package com.baidu.swan.apps.storage;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.swan.apps.runtime.e;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static boolean aDF() {
        String arz;
        String queryParameter;
        e aAs = e.aAs();
        if (aAs == null || (arz = aAs.aAv().arz()) == null || (queryParameter = Uri.parse(arz).getQueryParameter("params")) == null) {
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
