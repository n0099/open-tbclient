package com.baidu.swan.apps.console.a;

import android.text.TextUtils;
import android.util.Log;
import org.apache.http.cookie.ClientCookie;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    JSONArray aol;
    String aom;
    String appId;
    String appKey;

    private c() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String bS(int i) {
        if (this.aol == null) {
            return "";
        }
        String optString = this.aol.optString(i);
        if (!TextUtils.isEmpty(optString)) {
            return "http://" + optString + ":" + this.aom;
        }
        return "";
    }

    public static c t(JSONObject jSONObject) {
        c cVar = new c();
        try {
            cVar.aol = jSONObject.getJSONArray("host");
            cVar.appKey = jSONObject.getString("appKey");
            cVar.appId = jSONObject.getString("appId");
            cVar.aom = jSONObject.getString(ClientCookie.PORT_ATTR);
            return cVar;
        } catch (JSONException e) {
            if (DEBUG) {
                Log.e("RemoteDebugModel", "DebuggerLaunchAction params is invalid");
            }
            return null;
        }
    }
}
