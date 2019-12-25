package com.baidu.swan.apps.console.debugger.a;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.datachannel.Contract;
import org.apache.http.cookie.ClientCookie;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    String appId;
    String appKey;
    JSONArray beV;
    String beW;
    String page;

    private c() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String dT(int i) {
        if (this.beV == null) {
            return "";
        }
        String optString = this.beV.optString(i);
        if (!TextUtils.isEmpty(optString)) {
            return "http://" + optString + ":" + this.beW;
        }
        return "";
    }

    public static c ae(JSONObject jSONObject) {
        c cVar = new c();
        try {
            cVar.beV = jSONObject.getJSONArray(Contract.SCHEME_KEY_HOST);
            cVar.appKey = jSONObject.getString("appKey");
            cVar.appId = jSONObject.getString("appId");
            cVar.beW = jSONObject.getString(ClientCookie.PORT_ATTR);
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
