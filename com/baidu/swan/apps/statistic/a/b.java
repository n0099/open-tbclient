package com.baidu.swan.apps.statistic.a;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b extends f {
    public String aSr = "";

    @Override // com.baidu.swan.apps.statistic.a.f, com.baidu.swan.apps.statistic.a.e
    public JSONObject toJSONObject() {
        com.baidu.swan.apps.ae.b za;
        if (this.aSu == null) {
            this.aSu = new JSONObject();
        }
        if (TextUtils.isEmpty(this.aSr) && (za = com.baidu.swan.apps.w.e.Ea().za()) != null) {
            com.baidu.swan.apps.v.b.b uA = za.uA();
            this.aSr = uA != null ? uA.axK : "";
        }
        try {
            this.aSu.put("source", this.aSr);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return super.toJSONObject();
    }
}
