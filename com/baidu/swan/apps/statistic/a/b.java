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
        com.baidu.swan.apps.runtime.e arO;
        if (this.dOd == null) {
            this.dOd = new JSONObject();
        }
        if (TextUtils.isEmpty(this.dNW) && (arO = com.baidu.swan.apps.v.f.aDG().arO()) != null) {
            b.a aju = arO.aju();
            this.dNW = aju != null ? aju.aCv() : "";
        }
        try {
            this.dOd.put("source", this.dNW);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return super.toJSONObject();
    }
}
