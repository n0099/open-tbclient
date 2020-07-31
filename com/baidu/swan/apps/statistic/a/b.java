package com.baidu.swan.apps.statistic.a;

import android.text.TextUtils;
import com.baidu.swan.apps.u.c.b;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class b extends e {
    public String cOs = "";

    @Override // com.baidu.swan.apps.statistic.a.e
    public JSONObject toJSONObject() {
        com.baidu.swan.apps.runtime.e aad;
        if (this.cOz == null) {
            this.cOz = new JSONObject();
        }
        if (TextUtils.isEmpty(this.cOs) && (aad = com.baidu.swan.apps.v.f.akr().aad()) != null) {
            b.a Se = aad.Se();
            this.cOs = Se != null ? Se.ajg() : "";
        }
        try {
            this.cOz.put("source", this.cOs);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return super.toJSONObject();
    }
}
