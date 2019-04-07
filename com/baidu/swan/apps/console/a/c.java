package com.baidu.swan.apps.console.a;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.mobstat.Config;
import org.apache.http.cookie.ClientCookie;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    JSONArray amX;
    String amY;
    String appId;
    String appKey;

    private c() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String bR(int i) {
        if (this.amX == null) {
            return "";
        }
        String optString = this.amX.optString(i);
        if (!TextUtils.isEmpty(optString)) {
            return "http://" + optString + Config.TRACE_TODAY_VISIT_SPLIT + this.amY;
        }
        return "";
    }

    public static c y(JSONObject jSONObject) {
        c cVar = new c();
        try {
            cVar.amX = jSONObject.getJSONArray("host");
            cVar.appKey = jSONObject.getString("appKey");
            cVar.appId = jSONObject.getString("appId");
            cVar.amY = jSONObject.getString(ClientCookie.PORT_ATTR);
            return cVar;
        } catch (JSONException e) {
            if (DEBUG) {
                Log.e("RemoteDebugModel", "DebuggerLaunchAction params is invalid");
            }
            return null;
        }
    }
}
