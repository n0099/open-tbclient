package com.baidu.swan.apps.console.debugger.b;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.ap.ak;
import com.baidu.webkit.internal.ETAG;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    String Pp;
    String ccS;
    String ccT;
    String ccU;
    String ccV;
    JSONArray ccW;
    String mAppKey;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static c aO(JSONObject jSONObject) {
        c cVar = new c();
        try {
            cVar.mAppKey = jSONObject.getString("appKey");
            cVar.ccS = jSONObject.getString("appUrl") + "?swanJsVersion" + ETAG.EQUAL + com.baidu.swan.apps.swancore.b.jC(0) + ETAG.ITEM_SEPARATOR + "appVersion" + ETAG.EQUAL + ak.getVersionName();
            cVar.Pp = jSONObject.getString("wsUrl");
            cVar.ccT = jSONObject.optString("notInHistory", "1");
            cVar.ccU = jSONObject.optString("masterPreload");
            cVar.ccV = jSONObject.optString("slavePreload");
            cVar.ccW = jSONObject.optJSONArray("hosts");
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
    public String gM(int i) {
        return P(i, this.ccS);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String gN(int i) {
        return P(i, this.Pp);
    }

    private String P(int i, String str) {
        if (this.ccW != null && !TextUtils.isEmpty(str) && i >= 0 && i < this.ccW.length()) {
            Uri parse = Uri.parse(str);
            String optString = this.ccW.optString(i);
            if (!TextUtils.isEmpty(optString) && parse.getHost() != null) {
                return str.replace(parse.getHost(), optString);
            }
            return str;
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isInvalid() {
        return TextUtils.isEmpty(this.mAppKey) || TextUtils.isEmpty(this.ccS) || TextUtils.isEmpty(this.Pp);
    }
}
