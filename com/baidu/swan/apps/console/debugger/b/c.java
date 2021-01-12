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
    String Rb;
    String cLb;
    String cLc;
    String cLd;
    String cLe;
    JSONArray cLf;
    String mAppKey;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static c bl(JSONObject jSONObject) {
        c cVar = new c();
        try {
            cVar.mAppKey = jSONObject.getString("appKey");
            cVar.cLb = jSONObject.getString("appUrl") + "?swanJsVersion=" + com.baidu.swan.apps.swancore.b.jy(0) + ETAG.ITEM_SEPARATOR + "appVersion=" + ak.getVersionName();
            cVar.Rb = jSONObject.getString("wsUrl");
            cVar.cLc = jSONObject.optString("notInHistory", "1");
            cVar.cLd = jSONObject.optString("masterPreload");
            cVar.cLe = jSONObject.optString("slavePreload");
            cVar.cLf = jSONObject.optJSONArray("hosts");
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
    public String gv(int i) {
        return ak(i, this.cLb);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String gw(int i) {
        return ak(i, this.Rb);
    }

    private String ak(int i, String str) {
        if (this.cLf != null && !TextUtils.isEmpty(str) && i >= 0 && i < this.cLf.length()) {
            Uri parse = Uri.parse(str);
            String optString = this.cLf.optString(i);
            if (!TextUtils.isEmpty(optString) && parse.getHost() != null) {
                return str.replace(parse.getHost(), optString);
            }
            return str;
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isInvalid() {
        return TextUtils.isEmpty(this.mAppKey) || TextUtils.isEmpty(this.cLb) || TextUtils.isEmpty(this.Rb);
    }
}
