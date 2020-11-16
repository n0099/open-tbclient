package com.baidu.swan.apps.console.debugger.b;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.ap.ak;
import com.baidu.webkit.internal.ETAG;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    String Qg;
    String cDY;
    String cDZ;
    String cEa;
    String cEb;
    JSONArray cEc;
    String mAppKey;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static c bb(JSONObject jSONObject) {
        c cVar = new c();
        try {
            cVar.mAppKey = jSONObject.getString("appKey");
            cVar.cDY = jSONObject.getString("appUrl") + "?swanJsVersion" + ETAG.EQUAL + com.baidu.swan.apps.swancore.b.kB(0) + ETAG.ITEM_SEPARATOR + "appVersion" + ETAG.EQUAL + ak.getVersionName();
            cVar.Qg = jSONObject.getString("wsUrl");
            cVar.cDZ = jSONObject.optString("notInHistory", "1");
            cVar.cEa = jSONObject.optString("masterPreload");
            cVar.cEb = jSONObject.optString("slavePreload");
            cVar.cEc = jSONObject.optJSONArray("hosts");
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
    public String hJ(int i) {
        return ah(i, this.cDY);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String hK(int i) {
        return ah(i, this.Qg);
    }

    private String ah(int i, String str) {
        if (this.cEc != null && !TextUtils.isEmpty(str) && i >= 0 && i < this.cEc.length()) {
            Uri parse = Uri.parse(str);
            String optString = this.cEc.optString(i);
            if (!TextUtils.isEmpty(optString) && parse.getHost() != null) {
                return str.replace(parse.getHost(), optString);
            }
            return str;
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isInvalid() {
        return TextUtils.isEmpty(this.mAppKey) || TextUtils.isEmpty(this.cDY) || TextUtils.isEmpty(this.Qg);
    }
}
