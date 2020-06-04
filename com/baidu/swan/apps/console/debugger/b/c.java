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
    String Oh;
    String bRE;
    String bRF;
    String bRG;
    String bRH;
    JSONArray bRI;
    String mAppKey;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static c ay(JSONObject jSONObject) {
        c cVar = new c();
        try {
            cVar.mAppKey = jSONObject.getString("appKey");
            cVar.bRE = jSONObject.getString("appUrl") + "?swanJsVersion" + ETAG.EQUAL + com.baidu.swan.apps.swancore.b.hb(0) + ETAG.ITEM_SEPARATOR + "appVersion" + ETAG.EQUAL + aj.getVersionName();
            cVar.Oh = jSONObject.getString("wsUrl");
            cVar.bRF = jSONObject.optString("notInHistory", "1");
            cVar.bRG = jSONObject.optString("masterPreload");
            cVar.bRH = jSONObject.optString("slavePreload");
            cVar.bRI = jSONObject.optJSONArray("hosts");
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
    public String eB(int i) {
        return O(i, this.bRE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String eC(int i) {
        return O(i, this.Oh);
    }

    private String O(int i, String str) {
        if (this.bRI != null && !TextUtils.isEmpty(str) && i >= 0 && i < this.bRI.length()) {
            Uri parse = Uri.parse(str);
            String optString = this.bRI.optString(i);
            if (!TextUtils.isEmpty(optString) && parse.getHost() != null) {
                return str.replace(parse.getHost(), optString);
            }
            return str;
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isInvalid() {
        return TextUtils.isEmpty(this.mAppKey) || TextUtils.isEmpty(this.bRE) || TextUtils.isEmpty(this.Oh);
    }
}
