package com.baidu.swan.apps.statistic.a;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b extends f {
    public String bpr = "";

    @Override // com.baidu.swan.apps.statistic.a.f, com.baidu.swan.apps.statistic.a.e
    public JSONObject toJSONObject() {
        com.baidu.swan.apps.ae.b FD;
        if (this.bpu == null) {
            this.bpu = new JSONObject();
        }
        if (TextUtils.isEmpty(this.bpr) && (FD = com.baidu.swan.apps.w.e.LD().FD()) != null) {
            com.baidu.swan.apps.v.b.b AJ = FD.AJ();
            this.bpr = AJ != null ? AJ.KE() : "";
        }
        try {
            this.bpu.put("source", this.bpr);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return super.toJSONObject();
    }
}
