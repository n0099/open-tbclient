package com.baidu.swan.apps.console.debugger.b;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.ap.ak;
import com.baidu.webkit.internal.ETAG;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    String PM;
    String ceY;
    String ceZ;
    String cfa;
    String cfb;
    JSONArray cfc;
    String mAppKey;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static c aR(JSONObject jSONObject) {
        c cVar = new c();
        try {
            cVar.mAppKey = jSONObject.getString("appKey");
            cVar.ceY = jSONObject.getString("appUrl") + "?swanJsVersion" + ETAG.EQUAL + com.baidu.swan.apps.swancore.b.jN(0) + ETAG.ITEM_SEPARATOR + "appVersion" + ETAG.EQUAL + ak.getVersionName();
            cVar.PM = jSONObject.getString("wsUrl");
            cVar.ceZ = jSONObject.optString("notInHistory", "1");
            cVar.cfa = jSONObject.optString("masterPreload");
            cVar.cfb = jSONObject.optString("slavePreload");
            cVar.cfc = jSONObject.optJSONArray("hosts");
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
    public String gV(int i) {
        return Q(i, this.ceY);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String gW(int i) {
        return Q(i, this.PM);
    }

    private String Q(int i, String str) {
        if (this.cfc != null && !TextUtils.isEmpty(str) && i >= 0 && i < this.cfc.length()) {
            Uri parse = Uri.parse(str);
            String optString = this.cfc.optString(i);
            if (!TextUtils.isEmpty(optString) && parse.getHost() != null) {
                return str.replace(parse.getHost(), optString);
            }
            return str;
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isInvalid() {
        return TextUtils.isEmpty(this.mAppKey) || TextUtils.isEmpty(this.ceY) || TextUtils.isEmpty(this.PM);
    }
}
