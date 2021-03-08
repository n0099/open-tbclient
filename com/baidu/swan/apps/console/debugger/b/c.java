package com.baidu.swan.apps.console.debugger.b;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.ao.ak;
import com.baidu.webkit.internal.ETAG;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    String Su;
    String cOP;
    String cOQ;
    String cOR;
    String cOS;
    JSONArray cOT;
    String mAppKey;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static c bk(JSONObject jSONObject) {
        c cVar = new c();
        try {
            cVar.mAppKey = jSONObject.getString("appKey");
            cVar.cOP = jSONObject.getString("appUrl") + "?swanJsVersion=" + com.baidu.swan.apps.swancore.b.jC(0) + ETAG.ITEM_SEPARATOR + "appVersion=" + ak.getVersionName();
            cVar.Su = jSONObject.getString("wsUrl");
            cVar.cOQ = jSONObject.optString("notInHistory", "1");
            cVar.cOR = jSONObject.optString("masterPreload");
            cVar.cOS = jSONObject.optString("slavePreload");
            cVar.cOT = jSONObject.optJSONArray("hosts");
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
    public String gz(int i) {
        return ao(i, this.cOP);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String gA(int i) {
        return ao(i, this.Su);
    }

    private String ao(int i, String str) {
        if (this.cOT != null && !TextUtils.isEmpty(str) && i >= 0 && i < this.cOT.length()) {
            Uri parse = Uri.parse(str);
            String optString = this.cOT.optString(i);
            if (!TextUtils.isEmpty(optString) && parse.getHost() != null) {
                return str.replace(parse.getHost(), optString);
            }
            return str;
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isInvalid() {
        return TextUtils.isEmpty(this.mAppKey) || TextUtils.isEmpty(this.cOP) || TextUtils.isEmpty(this.Su);
    }
}
