package com.baidu.swan.apps.console.debugger.b;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.as.ai;
import com.baidu.webkit.internal.ETAG;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    String bfj;
    String bfk;
    String bfl;
    String bfm;
    JSONArray bfn;
    String mAppKey;
    String uJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static c af(JSONObject jSONObject) {
        c cVar = new c();
        try {
            cVar.mAppKey = jSONObject.getString("appKey");
            cVar.bfj = jSONObject.getString("appUrl") + "?swanJsVersion" + ETAG.EQUAL + com.baidu.swan.apps.swancore.b.gg(0) + ETAG.ITEM_SEPARATOR + "appVersion" + ETAG.EQUAL + ai.getVersionName();
            cVar.uJ = jSONObject.getString("wsUrl");
            cVar.bfk = jSONObject.optString("notInHistory", "1");
            cVar.bfl = jSONObject.optString("masterPreload");
            cVar.bfm = jSONObject.optString("slavePreload");
            cVar.bfn = jSONObject.optJSONArray("hosts");
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
    public String dU(int i) {
        return r(i, this.bfj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String dV(int i) {
        return r(i, this.uJ);
    }

    private String r(int i, String str) {
        if (this.bfn != null && !TextUtils.isEmpty(str) && i >= 0 && i < this.bfn.length()) {
            Uri parse = Uri.parse(str);
            String optString = this.bfn.optString(i);
            if (!TextUtils.isEmpty(optString) && parse.getHost() != null) {
                return str.replace(parse.getHost(), optString);
            }
            return str;
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isInvalid() {
        return TextUtils.isEmpty(this.mAppKey) || TextUtils.isEmpty(this.bfj) || TextUtils.isEmpty(this.uJ);
    }
}
