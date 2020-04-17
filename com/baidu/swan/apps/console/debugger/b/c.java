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
    String NV;
    String bII;
    String bIJ;
    String bIK;
    String bIL;
    JSONArray bIM;
    String mAppKey;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static c aq(JSONObject jSONObject) {
        c cVar = new c();
        try {
            cVar.mAppKey = jSONObject.getString("appKey");
            cVar.bII = jSONObject.getString("appUrl") + "?swanJsVersion" + ETAG.EQUAL + com.baidu.swan.apps.swancore.b.gF(0) + ETAG.ITEM_SEPARATOR + "appVersion" + ETAG.EQUAL + ai.getVersionName();
            cVar.NV = jSONObject.getString("wsUrl");
            cVar.bIJ = jSONObject.optString("notInHistory", "1");
            cVar.bIK = jSONObject.optString("masterPreload");
            cVar.bIL = jSONObject.optString("slavePreload");
            cVar.bIM = jSONObject.optJSONArray("hosts");
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
    public String eq(int i) {
        return N(i, this.bII);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String er(int i) {
        return N(i, this.NV);
    }

    private String N(int i, String str) {
        if (this.bIM != null && !TextUtils.isEmpty(str) && i >= 0 && i < this.bIM.length()) {
            Uri parse = Uri.parse(str);
            String optString = this.bIM.optString(i);
            if (!TextUtils.isEmpty(optString) && parse.getHost() != null) {
                return str.replace(parse.getHost(), optString);
            }
            return str;
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isInvalid() {
        return TextUtils.isEmpty(this.mAppKey) || TextUtils.isEmpty(this.bII) || TextUtils.isEmpty(this.NV);
    }
}
