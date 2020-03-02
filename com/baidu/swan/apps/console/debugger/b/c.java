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
    String bkm;
    String bkn;
    String bko;
    String bkp;
    JSONArray bkq;
    String mAppKey;
    String vd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static c af(JSONObject jSONObject) {
        c cVar = new c();
        try {
            cVar.mAppKey = jSONObject.getString("appKey");
            cVar.bkm = jSONObject.getString("appUrl") + "?swanJsVersion" + ETAG.EQUAL + com.baidu.swan.apps.swancore.b.gy(0) + ETAG.ITEM_SEPARATOR + "appVersion" + ETAG.EQUAL + ai.getVersionName();
            cVar.vd = jSONObject.getString("wsUrl");
            cVar.bkn = jSONObject.optString("notInHistory", "1");
            cVar.bko = jSONObject.optString("masterPreload");
            cVar.bkp = jSONObject.optString("slavePreload");
            cVar.bkq = jSONObject.optJSONArray("hosts");
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
        return w(i, this.bkm);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String em(int i) {
        return w(i, this.vd);
    }

    private String w(int i, String str) {
        if (this.bkq != null && !TextUtils.isEmpty(str) && i >= 0 && i < this.bkq.length()) {
            Uri parse = Uri.parse(str);
            String optString = this.bkq.optString(i);
            if (!TextUtils.isEmpty(optString) && parse.getHost() != null) {
                return str.replace(parse.getHost(), optString);
            }
            return str;
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isInvalid() {
        return TextUtils.isEmpty(this.mAppKey) || TextUtils.isEmpty(this.bkm) || TextUtils.isEmpty(this.vd);
    }
}
