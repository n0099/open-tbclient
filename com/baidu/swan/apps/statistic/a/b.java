package com.baidu.swan.apps.statistic.a;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b extends f {
    public String aSn = "";

    @Override // com.baidu.swan.apps.statistic.a.f, com.baidu.swan.apps.statistic.a.e
    public JSONObject toJSONObject() {
        com.baidu.swan.apps.ae.b zb;
        if (this.aSq == null) {
            this.aSq = new JSONObject();
        }
        if (TextUtils.isEmpty(this.aSn) && (zb = com.baidu.swan.apps.w.e.Ec().zb()) != null) {
            com.baidu.swan.apps.v.b.b uB = zb.uB();
            this.aSn = uB != null ? uB.axG : "";
        }
        try {
            this.aSq.put("source", this.aSn);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return super.toJSONObject();
    }
}
