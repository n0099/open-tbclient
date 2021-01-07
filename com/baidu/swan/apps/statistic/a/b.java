package com.baidu.swan.apps.statistic.a;

import android.text.TextUtils;
import com.baidu.swan.apps.u.c.b;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class b extends e {
    public String dNW = "";

    @Override // com.baidu.swan.apps.statistic.a.e
    public JSONObject toJSONObject() {
        com.baidu.swan.apps.runtime.e arP;
        if (this.dOd == null) {
            this.dOd = new JSONObject();
        }
        if (TextUtils.isEmpty(this.dNW) && (arP = com.baidu.swan.apps.v.f.aDH().arP()) != null) {
            b.a ajv = arP.ajv();
            this.dNW = ajv != null ? ajv.aCw() : "";
        }
        try {
            this.dOd.put("source", this.dNW);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return super.toJSONObject();
    }
}
