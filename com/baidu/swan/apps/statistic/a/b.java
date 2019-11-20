package com.baidu.swan.apps.statistic.a;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b extends f {
    public String boZ = "";

    @Override // com.baidu.swan.apps.statistic.a.f, com.baidu.swan.apps.statistic.a.e
    public JSONObject toJSONObject() {
        com.baidu.swan.apps.ae.b FE;
        if (this.bpc == null) {
            this.bpc = new JSONObject();
        }
        if (TextUtils.isEmpty(this.boZ) && (FE = com.baidu.swan.apps.w.e.LE().FE()) != null) {
            com.baidu.swan.apps.v.b.b AK = FE.AK();
            this.boZ = AK != null ? AK.KF() : "";
        }
        try {
            this.bpc.put("source", this.boZ);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return super.toJSONObject();
    }
}
