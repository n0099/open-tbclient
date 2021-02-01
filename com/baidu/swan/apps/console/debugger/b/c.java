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
    String QZ;
    String cNp;
    String cNq;
    String cNr;
    String cNs;
    JSONArray cNt;
    String mAppKey;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static c bi(JSONObject jSONObject) {
        c cVar = new c();
        try {
            cVar.mAppKey = jSONObject.getString("appKey");
            cVar.cNp = jSONObject.getString("appUrl") + "?swanJsVersion=" + com.baidu.swan.apps.swancore.b.jB(0) + ETAG.ITEM_SEPARATOR + "appVersion=" + ak.getVersionName();
            cVar.QZ = jSONObject.getString("wsUrl");
            cVar.cNq = jSONObject.optString("notInHistory", "1");
            cVar.cNr = jSONObject.optString("masterPreload");
            cVar.cNs = jSONObject.optString("slavePreload");
            cVar.cNt = jSONObject.optJSONArray("hosts");
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
    public String gy(int i) {
        return ao(i, this.cNp);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String gz(int i) {
        return ao(i, this.QZ);
    }

    private String ao(int i, String str) {
        if (this.cNt != null && !TextUtils.isEmpty(str) && i >= 0 && i < this.cNt.length()) {
            Uri parse = Uri.parse(str);
            String optString = this.cNt.optString(i);
            if (!TextUtils.isEmpty(optString) && parse.getHost() != null) {
                return str.replace(parse.getHost(), optString);
            }
            return str;
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isInvalid() {
        return TextUtils.isEmpty(this.mAppKey) || TextUtils.isEmpty(this.cNp) || TextUtils.isEmpty(this.QZ);
    }
}
