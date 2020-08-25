package com.baidu.swan.apps.statistic.a;

import android.text.TextUtils;
import com.baidu.swan.apps.u.c.b;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class b extends e {
    public String cXs = "";

    @Override // com.baidu.swan.apps.statistic.a.e
    public JSONObject toJSONObject() {
        com.baidu.swan.apps.runtime.e agn;
        if (this.cXz == null) {
            this.cXz = new JSONObject();
        }
        if (TextUtils.isEmpty(this.cXs) && (agn = com.baidu.swan.apps.v.f.arY().agn()) != null) {
            b.a XZ = agn.XZ();
            this.cXs = XZ != null ? XZ.aqN() : "";
        }
        try {
            this.cXz.put("source", this.cXs);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return super.toJSONObject();
    }
}
