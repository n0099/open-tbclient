package com.baidu.swan.apps.console.debugger.b;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.ap.ak;
import com.baidu.webkit.internal.ETAG;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    String Qe;
    String crp;
    String crq;
    String crr;
    String crs;
    JSONArray crt;
    String mAppKey;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static c aY(JSONObject jSONObject) {
        c cVar = new c();
        try {
            cVar.mAppKey = jSONObject.getString("appKey");
            cVar.crp = jSONObject.getString("appUrl") + "?swanJsVersion" + ETAG.EQUAL + com.baidu.swan.apps.swancore.b.kk(0) + ETAG.ITEM_SEPARATOR + "appVersion" + ETAG.EQUAL + ak.getVersionName();
            cVar.Qe = jSONObject.getString("wsUrl");
            cVar.crq = jSONObject.optString("notInHistory", "1");
            cVar.crr = jSONObject.optString("masterPreload");
            cVar.crs = jSONObject.optString("slavePreload");
            cVar.crt = jSONObject.optJSONArray("hosts");
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
    public String hs(int i) {
        return ab(i, this.crp);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String ht(int i) {
        return ab(i, this.Qe);
    }

    private String ab(int i, String str) {
        if (this.crt != null && !TextUtils.isEmpty(str) && i >= 0 && i < this.crt.length()) {
            Uri parse = Uri.parse(str);
            String optString = this.crt.optString(i);
            if (!TextUtils.isEmpty(optString) && parse.getHost() != null) {
                return str.replace(parse.getHost(), optString);
            }
            return str;
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isInvalid() {
        return TextUtils.isEmpty(this.mAppKey) || TextUtils.isEmpty(this.crp) || TextUtils.isEmpty(this.Qe);
    }
}
