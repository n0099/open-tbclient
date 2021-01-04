package com.baidu.swan.apps.console.debugger.b;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.ao.ak;
import com.baidu.webkit.internal.ETAG;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    String Rd;
    String cPN;
    String cPO;
    String cPP;
    String cPQ;
    JSONArray cPR;
    String mAppKey;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static c bl(JSONObject jSONObject) {
        c cVar = new c();
        try {
            cVar.mAppKey = jSONObject.getString("appKey");
            cVar.cPN = jSONObject.getString("appUrl") + "?swanJsVersion=" + com.baidu.swan.apps.swancore.b.le(0) + ETAG.ITEM_SEPARATOR + "appVersion=" + ak.getVersionName();
            cVar.Rd = jSONObject.getString("wsUrl");
            cVar.cPO = jSONObject.optString("notInHistory", "1");
            cVar.cPP = jSONObject.optString("masterPreload");
            cVar.cPQ = jSONObject.optString("slavePreload");
            cVar.cPR = jSONObject.optJSONArray("hosts");
            return cVar;
        } catch (JSONException e) {
            if (DEBUG) {
                Log.e("WirelessDebugModel", "DebuggerLaunchAction params is invalid");
            }
            return null;
        }
    }

    private c() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String ib(int i) {
        return aj(i, this.cPN);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String ic(int i) {
        return aj(i, this.Rd);
    }

    private String aj(int i, String str) {
        if (this.cPR != null && !TextUtils.isEmpty(str) && i >= 0 && i < this.cPR.length()) {
            Uri parse = Uri.parse(str);
            String optString = this.cPR.optString(i);
            if (!TextUtils.isEmpty(optString) && parse.getHost() != null) {
                return str.replace(parse.getHost(), optString);
            }
            return str;
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isInvalid() {
        return TextUtils.isEmpty(this.mAppKey) || TextUtils.isEmpty(this.cPN) || TextUtils.isEmpty(this.Rd);
    }
}
