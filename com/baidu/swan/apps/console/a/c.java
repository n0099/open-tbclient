package com.baidu.swan.apps.console.a;

import android.text.TextUtils;
import android.util.Log;
import com.sina.weibo.sdk.constant.WBConstants;
import org.apache.http.cookie.ClientCookie;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c {
    private static final boolean DEBUG = com.baidu.swan.apps.c.DEBUG;
    JSONArray amS;
    String amT;
    String appId;
    String appKey;

    private c() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String bS(int i) {
        if (this.amS == null) {
            return "";
        }
        String optString = this.amS.optString(i);
        if (!TextUtils.isEmpty(optString)) {
            return "http://" + optString + ":" + this.amT;
        }
        return "";
    }

    public static c y(JSONObject jSONObject) {
        c cVar = new c();
        try {
            cVar.amS = jSONObject.getJSONArray("host");
            cVar.appKey = jSONObject.getString(WBConstants.SSO_APP_KEY);
            cVar.appId = jSONObject.getString("appId");
            cVar.amT = jSONObject.getString(ClientCookie.PORT_ATTR);
            return cVar;
        } catch (JSONException e) {
            if (DEBUG) {
                Log.e("RemoteDebugModel", "DebuggerLaunchAction params is invalid");
            }
            return null;
        }
    }
}
