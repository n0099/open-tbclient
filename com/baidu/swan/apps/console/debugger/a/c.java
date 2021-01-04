package com.baidu.swan.apps.console.debugger.a;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import org.apache.http.cookie.ClientCookie;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    String aAt;
    String appId;
    String appKey;
    JSONArray cPB;
    String page;

    private c() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String ia(int i) {
        if (this.cPB == null) {
            return "";
        }
        String optString = this.cPB.optString(i);
        if (!TextUtils.isEmpty(optString)) {
            return "http://" + optString + ":" + this.aAt;
        }
        return "";
    }

    public static c bk(JSONObject jSONObject) {
        c cVar = new c();
        try {
            cVar.cPB = jSONObject.getJSONArray("host");
            cVar.appKey = jSONObject.getString("appKey");
            cVar.appId = jSONObject.getString("appId");
            cVar.aAt = jSONObject.getString(ClientCookie.PORT_ATTR);
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
