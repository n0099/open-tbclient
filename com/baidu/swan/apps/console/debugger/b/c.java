package com.baidu.swan.apps.console.debugger.b;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.aq.aj;
import com.baidu.webkit.internal.ETAG;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    String OJ;
    String bWs;
    String bWt;
    String bWu;
    String bWv;
    JSONArray bWw;
    String mAppKey;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static c aF(JSONObject jSONObject) {
        c cVar = new c();
        try {
            cVar.mAppKey = jSONObject.getString("appKey");
            cVar.bWs = jSONObject.getString("appUrl") + "?swanJsVersion" + ETAG.EQUAL + com.baidu.swan.apps.swancore.b.hm(0) + ETAG.ITEM_SEPARATOR + "appVersion" + ETAG.EQUAL + aj.getVersionName();
            cVar.OJ = jSONObject.getString("wsUrl");
            cVar.bWt = jSONObject.optString("notInHistory", "1");
            cVar.bWu = jSONObject.optString("masterPreload");
            cVar.bWv = jSONObject.optString("slavePreload");
            cVar.bWw = jSONObject.optJSONArray("hosts");
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
    public String eM(int i) {
        return Q(i, this.bWs);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String eN(int i) {
        return Q(i, this.OJ);
    }

    private String Q(int i, String str) {
        if (this.bWw != null && !TextUtils.isEmpty(str) && i >= 0 && i < this.bWw.length()) {
            Uri parse = Uri.parse(str);
            String optString = this.bWw.optString(i);
            if (!TextUtils.isEmpty(optString) && parse.getHost() != null) {
                return str.replace(parse.getHost(), optString);
            }
            return str;
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isInvalid() {
        return TextUtils.isEmpty(this.mAppKey) || TextUtils.isEmpty(this.bWs) || TextUtils.isEmpty(this.OJ);
    }
}
