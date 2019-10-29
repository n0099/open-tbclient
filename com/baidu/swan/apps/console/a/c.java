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
    JSONArray aHC;
    String aHD;
    String appId;
    String appKey;

    private c() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String cO(int i) {
        if (this.aHC == null) {
            return "";
        }
        String optString = this.aHC.optString(i);
        if (!TextUtils.isEmpty(optString)) {
            return "http://" + optString + ":" + this.aHD;
        }
        return "";
    }

    public static c R(JSONObject jSONObject) {
        c cVar = new c();
        try {
            cVar.aHC = jSONObject.getJSONArray("host");
            cVar.appKey = jSONObject.getString("appKey");
            cVar.appId = jSONObject.getString("appId");
            cVar.aHD = jSONObject.getString(ClientCookie.PORT_ATTR);
            return cVar;
        } catch (JSONException e) {
            if (DEBUG) {
                Log.e("RemoteDebugModel", "DebuggerLaunchAction params is invalid");
            }
            return null;
        }
    }
}
