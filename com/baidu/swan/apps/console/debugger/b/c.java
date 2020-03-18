package com.baidu.swan.apps.console.debugger.b;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.as.ai;
import com.baidu.webkit.internal.ETAG;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    String bkA;
    String bkB;
    String bkC;
    String bkD;
    JSONArray bkE;
    String mAppKey;
    String vd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static c af(JSONObject jSONObject) {
        c cVar = new c();
        try {
            cVar.mAppKey = jSONObject.getString("appKey");
            cVar.bkA = jSONObject.getString("appUrl") + "?swanJsVersion" + ETAG.EQUAL + com.baidu.swan.apps.swancore.b.gy(0) + ETAG.ITEM_SEPARATOR + "appVersion" + ETAG.EQUAL + ai.getVersionName();
            cVar.vd = jSONObject.getString("wsUrl");
            cVar.bkB = jSONObject.optString("notInHistory", "1");
            cVar.bkC = jSONObject.optString("masterPreload");
            cVar.bkD = jSONObject.optString("slavePreload");
            cVar.bkE = jSONObject.optJSONArray("hosts");
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
    public String el(int i) {
        return w(i, this.bkA);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String em(int i) {
        return w(i, this.vd);
    }

    private String w(int i, String str) {
        if (this.bkE != null && !TextUtils.isEmpty(str) && i >= 0 && i < this.bkE.length()) {
            Uri parse = Uri.parse(str);
            String optString = this.bkE.optString(i);
            if (!TextUtils.isEmpty(optString) && parse.getHost() != null) {
                return str.replace(parse.getHost(), optString);
            }
            return str;
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isInvalid() {
        return TextUtils.isEmpty(this.mAppKey) || TextUtils.isEmpty(this.bkA) || TextUtils.isEmpty(this.vd);
    }
}
