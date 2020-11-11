package com.baidu.swan.apps.console.debugger.a;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import org.apache.http.cookie.ClientCookie;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    String appId;
    String appKey;
    JSONArray cFv;
    String cFw;
    String page;

    private c() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String hM(int i) {
        if (this.cFv == null) {
            return "";
        }
        String optString = this.cFv.optString(i);
        if (!TextUtils.isEmpty(optString)) {
            return "http://" + optString + ":" + this.cFw;
        }
        return "";
    }

    public static c bg(JSONObject jSONObject) {
        c cVar = new c();
        try {
            cVar.cFv = jSONObject.getJSONArray("host");
            cVar.appKey = jSONObject.getString("appKey");
            cVar.appId = jSONObject.getString("appId");
            cVar.cFw = jSONObject.getString(ClientCookie.PORT_ATTR);
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
