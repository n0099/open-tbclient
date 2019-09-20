package com.baidu.swan.apps.statistic.a;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b extends f {
    public String aWn = "";

    @Override // com.baidu.swan.apps.statistic.a.f, com.baidu.swan.apps.statistic.a.e
    public JSONObject toJSONObject() {
        com.baidu.swan.apps.ae.b AI;
        if (this.aWq == null) {
            this.aWq = new JSONObject();
        }
        if (TextUtils.isEmpty(this.aWn) && (AI = com.baidu.swan.apps.w.e.GJ().AI()) != null) {
            com.baidu.swan.apps.v.b.b vP = AI.vP();
            this.aWn = vP != null ? vP.FK() : "";
        }
        try {
            this.aWq.put("source", this.aWn);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return super.toJSONObject();
    }
}
