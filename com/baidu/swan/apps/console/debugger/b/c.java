package com.baidu.swan.apps.console.debugger.b;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.aq.al;
import com.baidu.webkit.internal.ETAG;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    String OJ;
    String bXj;
    String bXk;
    String bXl;
    String bXm;
    JSONArray bXn;
    String mAppKey;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static c aI(JSONObject jSONObject) {
        c cVar = new c();
        try {
            cVar.mAppKey = jSONObject.getString("appKey");
            cVar.bXj = jSONObject.getString("appUrl") + "?swanJsVersion" + ETAG.EQUAL + com.baidu.swan.apps.swancore.b.hv(0) + ETAG.ITEM_SEPARATOR + "appVersion" + ETAG.EQUAL + al.getVersionName();
            cVar.OJ = jSONObject.getString("wsUrl");
            cVar.bXk = jSONObject.optString("notInHistory", "1");
            cVar.bXl = jSONObject.optString("masterPreload");
            cVar.bXm = jSONObject.optString("slavePreload");
            cVar.bXn = jSONObject.optJSONArray("hosts");
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
    public String eO(int i) {
        return Q(i, this.bXj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String eP(int i) {
        return Q(i, this.OJ);
    }

    private String Q(int i, String str) {
        if (this.bXn != null && !TextUtils.isEmpty(str) && i >= 0 && i < this.bXn.length()) {
            Uri parse = Uri.parse(str);
            String optString = this.bXn.optString(i);
            if (!TextUtils.isEmpty(optString) && parse.getHost() != null) {
                return str.replace(parse.getHost(), optString);
            }
            return str;
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isInvalid() {
        return TextUtils.isEmpty(this.mAppKey) || TextUtils.isEmpty(this.bXj) || TextUtils.isEmpty(this.OJ);
    }
}
