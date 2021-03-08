package com.baidu.swan.apps.statistic.a;

import android.text.TextUtils;
import com.baidu.swan.apps.u.c.b;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class b extends e {
    public String dMP = "";

    @Override // com.baidu.swan.apps.statistic.a.e
    public JSONObject toJSONObject() {
        com.baidu.swan.apps.runtime.e aov;
        if (this.dMW == null) {
            this.dMW = new JSONObject();
        }
        if (TextUtils.isEmpty(this.dMP) && (aov = com.baidu.swan.apps.v.f.aAo().aov()) != null) {
            b.a agc = aov.agc();
            this.dMP = agc != null ? agc.azd() : "";
        }
        try {
            this.dMW.put("source", this.dMP);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return super.toJSONObject();
    }
}
