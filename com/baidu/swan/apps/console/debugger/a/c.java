package com.baidu.swan.apps.console.debugger.a;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import org.apache.http.cookie.ClientCookie;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    String appId;
    String appKey;
    JSONArray bWW;
    String bWX;
    String page;

    private c() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String eN(int i) {
        if (this.bWW == null) {
            return "";
        }
        String optString = this.bWW.optString(i);
        if (!TextUtils.isEmpty(optString)) {
            return "http://" + optString + ":" + this.bWX;
        }
        return "";
    }

    public static c aH(JSONObject jSONObject) {
        c cVar = new c();
        try {
            cVar.bWW = jSONObject.getJSONArray("host");
            cVar.appKey = jSONObject.getString("appKey");
            cVar.appId = jSONObject.getString("appId");
            cVar.bWX = jSONObject.getString(ClientCookie.PORT_ATTR);
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
