package com.baidu.swan.apps.console.debugger.b;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.ap.ak;
import com.baidu.webkit.internal.ETAG;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes25.dex */
public class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    String Ra;
    String cKS;
    String cKT;
    String cKU;
    String cKV;
    JSONArray cKW;
    String mAppKey;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static c bd(JSONObject jSONObject) {
        c cVar = new c();
        try {
            cVar.mAppKey = jSONObject.getString("appKey");
            cVar.cKS = jSONObject.getString("appUrl") + "?swanJsVersion=" + com.baidu.swan.apps.swancore.b.kZ(0) + ETAG.ITEM_SEPARATOR + "appVersion=" + ak.getVersionName();
            cVar.Ra = jSONObject.getString("wsUrl");
            cVar.cKT = jSONObject.optString("notInHistory", "1");
            cVar.cKU = jSONObject.optString("masterPreload");
            cVar.cKV = jSONObject.optString("slavePreload");
            cVar.cKW = jSONObject.optJSONArray("hosts");
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
    public String ih(int i) {
        return ah(i, this.cKS);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String ii(int i) {
        return ah(i, this.Ra);
    }

    private String ah(int i, String str) {
        if (this.cKW != null && !TextUtils.isEmpty(str) && i >= 0 && i < this.cKW.length()) {
            Uri parse = Uri.parse(str);
            String optString = this.cKW.optString(i);
            if (!TextUtils.isEmpty(optString) && parse.getHost() != null) {
                return str.replace(parse.getHost(), optString);
            }
            return str;
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isInvalid() {
        return TextUtils.isEmpty(this.mAppKey) || TextUtils.isEmpty(this.cKS) || TextUtils.isEmpty(this.Ra);
    }
}
