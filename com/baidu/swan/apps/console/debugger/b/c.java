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
    String ccW;
    String ccX;
    String ccY;
    String ccZ;
    JSONArray cda;
    String mAppKey;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static c aO(JSONObject jSONObject) {
        c cVar = new c();
        try {
            cVar.mAppKey = jSONObject.getString("appKey");
            cVar.ccW = jSONObject.getString("appUrl") + "?swanJsVersion" + ETAG.EQUAL + com.baidu.swan.apps.swancore.b.jC(0) + ETAG.ITEM_SEPARATOR + "appVersion" + ETAG.EQUAL + ak.getVersionName();
            cVar.Pp = jSONObject.getString("wsUrl");
            cVar.ccX = jSONObject.optString("notInHistory", "1");
            cVar.ccY = jSONObject.optString("masterPreload");
            cVar.ccZ = jSONObject.optString("slavePreload");
            cVar.cda = jSONObject.optJSONArray("hosts");
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
        return P(i, this.ccW);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String gN(int i) {
        return P(i, this.Pp);
    }

    private String P(int i, String str) {
        if (this.cda != null && !TextUtils.isEmpty(str) && i >= 0 && i < this.cda.length()) {
            Uri parse = Uri.parse(str);
            String optString = this.cda.optString(i);
            if (!TextUtils.isEmpty(optString) && parse.getHost() != null) {
                return str.replace(parse.getHost(), optString);
            }
            return str;
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isInvalid() {
        return TextUtils.isEmpty(this.mAppKey) || TextUtils.isEmpty(this.ccW) || TextUtils.isEmpty(this.Pp);
    }
}
