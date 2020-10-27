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
    String Qf;
    String czP;
    String czQ;
    String czR;
    String czS;
    JSONArray czT;
    String mAppKey;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static c bb(JSONObject jSONObject) {
        c cVar = new c();
        try {
            cVar.mAppKey = jSONObject.getString("appKey");
            cVar.czP = jSONObject.getString("appUrl") + "?swanJsVersion" + ETAG.EQUAL + com.baidu.swan.apps.swancore.b.kv(0) + ETAG.ITEM_SEPARATOR + "appVersion" + ETAG.EQUAL + ak.getVersionName();
            cVar.Qf = jSONObject.getString("wsUrl");
            cVar.czQ = jSONObject.optString("notInHistory", "1");
            cVar.czR = jSONObject.optString("masterPreload");
            cVar.czS = jSONObject.optString("slavePreload");
            cVar.czT = jSONObject.optJSONArray("hosts");
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
    public String hD(int i) {
        return ad(i, this.czP);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String hE(int i) {
        return ad(i, this.Qf);
    }

    private String ad(int i, String str) {
        if (this.czT != null && !TextUtils.isEmpty(str) && i >= 0 && i < this.czT.length()) {
            Uri parse = Uri.parse(str);
            String optString = this.czT.optString(i);
            if (!TextUtils.isEmpty(optString) && parse.getHost() != null) {
                return str.replace(parse.getHost(), optString);
            }
            return str;
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isInvalid() {
        return TextUtils.isEmpty(this.mAppKey) || TextUtils.isEmpty(this.czP) || TextUtils.isEmpty(this.Qf);
    }
}
