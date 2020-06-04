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
    JSONArray bRr;
    String bRs;
    String page;

    private c() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String eA(int i) {
        if (this.bRr == null) {
            return "";
        }
        String optString = this.bRr.optString(i);
        if (!TextUtils.isEmpty(optString)) {
            return "http://" + optString + ":" + this.bRs;
        }
        return "";
    }

    public static c ax(JSONObject jSONObject) {
        c cVar = new c();
        try {
            cVar.bRr = jSONObject.getJSONArray("host");
            cVar.appKey = jSONObject.getString("appKey");
            cVar.appId = jSONObject.getString("appId");
            cVar.bRs = jSONObject.getString(ClientCookie.PORT_ATTR);
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
