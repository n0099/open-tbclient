package com.baidu.swan.apps.console.debugger.b;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.as.ai;
import com.baidu.webkit.internal.ETAG;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    String bfY;
    String bfZ;
    String bga;
    String bgb;
    JSONArray bgc;
    String mAppKey;
    String uM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static c af(JSONObject jSONObject) {
        c cVar = new c();
        try {
            cVar.mAppKey = jSONObject.getString("appKey");
            cVar.bfY = jSONObject.getString("appUrl") + "?swanJsVersion" + ETAG.EQUAL + com.baidu.swan.apps.swancore.b.gh(0) + ETAG.ITEM_SEPARATOR + "appVersion" + ETAG.EQUAL + ai.getVersionName();
            cVar.uM = jSONObject.getString("wsUrl");
            cVar.bfZ = jSONObject.optString("notInHistory", "1");
            cVar.bga = jSONObject.optString("masterPreload");
            cVar.bgb = jSONObject.optString("slavePreload");
            cVar.bgc = jSONObject.optJSONArray("hosts");
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
    public String dV(int i) {
        return u(i, this.bfY);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String dW(int i) {
        return u(i, this.uM);
    }

    private String u(int i, String str) {
        if (this.bgc != null && !TextUtils.isEmpty(str) && i >= 0 && i < this.bgc.length()) {
            Uri parse = Uri.parse(str);
            String optString = this.bgc.optString(i);
            if (!TextUtils.isEmpty(optString) && parse.getHost() != null) {
                return str.replace(parse.getHost(), optString);
            }
            return str;
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isInvalid() {
        return TextUtils.isEmpty(this.mAppKey) || TextUtils.isEmpty(this.bfY) || TextUtils.isEmpty(this.uM);
    }
}
