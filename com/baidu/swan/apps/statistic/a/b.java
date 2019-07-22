package com.baidu.swan.apps.statistic.a;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b extends f {
    public String aVP = "";

    @Override // com.baidu.swan.apps.statistic.a.f, com.baidu.swan.apps.statistic.a.e
    public JSONObject toJSONObject() {
        com.baidu.swan.apps.ae.b AE;
        if (this.aVS == null) {
            this.aVS = new JSONObject();
        }
        if (TextUtils.isEmpty(this.aVP) && (AE = com.baidu.swan.apps.w.e.GF().AE()) != null) {
            com.baidu.swan.apps.v.b.b vL = AE.vL();
            this.aVP = vL != null ? vL.FG() : "";
        }
        try {
            this.aVS.put("source", this.aVP);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return super.toJSONObject();
    }
}
