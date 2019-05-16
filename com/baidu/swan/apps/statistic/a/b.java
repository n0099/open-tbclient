package com.baidu.swan.apps.statistic.a;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b extends f {
    public String aVf = "";

    @Override // com.baidu.swan.apps.statistic.a.f, com.baidu.swan.apps.statistic.a.e
    public JSONObject toJSONObject() {
        com.baidu.swan.apps.ae.b zX;
        if (this.aVi == null) {
            this.aVi = new JSONObject();
        }
        if (TextUtils.isEmpty(this.aVf) && (zX = com.baidu.swan.apps.w.e.FV().zX()) != null) {
            com.baidu.swan.apps.v.b.b vk = zX.vk();
            this.aVf = vk != null ? vk.EW() : "";
        }
        try {
            this.aVi.put("source", this.aVf);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return super.toJSONObject();
    }
}
