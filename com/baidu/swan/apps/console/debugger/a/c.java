package com.baidu.swan.apps.console.debugger.a;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import org.apache.http.cookie.ClientCookie;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    String appId;
    String appKey;
    JSONArray bWf;
    String bWg;
    String page;

    private c() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String eL(int i) {
        if (this.bWf == null) {
            return "";
        }
        String optString = this.bWf.optString(i);
        if (!TextUtils.isEmpty(optString)) {
            return "http://" + optString + ":" + this.bWg;
        }
        return "";
    }

    public static c aE(JSONObject jSONObject) {
        c cVar = new c();
        try {
            cVar.bWf = jSONObject.getJSONArray("host");
            cVar.appKey = jSONObject.getString("appKey");
            cVar.appId = jSONObject.getString("appId");
            cVar.bWg = jSONObject.getString(ClientCookie.PORT_ATTR);
            cVar.page = Uri.decode(jSONObject.optString("url"));
            return cVar;
        } catch (JSONException e) {
            if (DEBUG) {
                Log.e("RemoteDebugModel", "DebuggerLaunchAction params is invalid");
            }
            return null;
        }
    }
}
