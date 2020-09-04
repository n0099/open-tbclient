package com.baidu.swan.apps.statistic.a;

import android.text.TextUtils;
import com.baidu.swan.apps.u.c.b;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class b extends e {
    public String cXw = "";

    @Override // com.baidu.swan.apps.statistic.a.e
    public JSONObject toJSONObject() {
        com.baidu.swan.apps.runtime.e agn;
        if (this.cXD == null) {
            this.cXD = new JSONObject();
        }
        if (TextUtils.isEmpty(this.cXw) && (agn = com.baidu.swan.apps.v.f.arY().agn()) != null) {
            b.a XZ = agn.XZ();
            this.cXw = XZ != null ? XZ.aqN() : "";
        }
        try {
            this.cXD.put("source", this.cXw);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return super.toJSONObject();
    }
}
