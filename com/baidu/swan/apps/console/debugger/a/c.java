package com.baidu.swan.apps.console.debugger.a;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.datachannel.Contract;
import org.apache.http.cookie.ClientCookie;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    String appId;
    String appKey;
    JSONArray bka;
    String bkb;
    String page;

    private c() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String ek(int i) {
        if (this.bka == null) {
            return "";
        }
        String optString = this.bka.optString(i);
        if (!TextUtils.isEmpty(optString)) {
            return "http://" + optString + ":" + this.bkb;
        }
        return "";
    }

    public static c ae(JSONObject jSONObject) {
        c cVar = new c();
        try {
            cVar.bka = jSONObject.getJSONArray(Contract.SCHEME_KEY_HOST);
            cVar.appKey = jSONObject.getString("appKey");
            cVar.appId = jSONObject.getString("appId");
            cVar.bkb = jSONObject.getString(ClientCookie.PORT_ATTR);
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
