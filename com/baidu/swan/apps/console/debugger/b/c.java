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
    String cFI;
    String cFJ;
    String cFK;
    String cFL;
    JSONArray cFM;
    String mAppKey;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static c bh(JSONObject jSONObject) {
        c cVar = new c();
        try {
            cVar.mAppKey = jSONObject.getString("appKey");
            cVar.cFI = jSONObject.getString("appUrl") + "?swanJsVersion" + ETAG.EQUAL + com.baidu.swan.apps.swancore.b.kF(0) + ETAG.ITEM_SEPARATOR + "appVersion" + ETAG.EQUAL + ak.getVersionName();
            cVar.Qf = jSONObject.getString("wsUrl");
            cVar.cFJ = jSONObject.optString("notInHistory", "1");
            cVar.cFK = jSONObject.optString("masterPreload");
            cVar.cFL = jSONObject.optString("slavePreload");
            cVar.cFM = jSONObject.optJSONArray("hosts");
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
    public String hN(int i) {
        return ah(i, this.cFI);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String hO(int i) {
        return ah(i, this.Qf);
    }

    private String ah(int i, String str) {
        if (this.cFM != null && !TextUtils.isEmpty(str) && i >= 0 && i < this.cFM.length()) {
            Uri parse = Uri.parse(str);
            String optString = this.cFM.optString(i);
            if (!TextUtils.isEmpty(optString) && parse.getHost() != null) {
                return str.replace(parse.getHost(), optString);
            }
            return str;
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isInvalid() {
        return TextUtils.isEmpty(this.mAppKey) || TextUtils.isEmpty(this.cFI) || TextUtils.isEmpty(this.Qf);
    }
}
