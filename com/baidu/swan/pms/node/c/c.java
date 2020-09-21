package com.baidu.swan.pms.node.c;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes24.dex */
public class c extends com.baidu.swan.pms.node.b {
    @Override // com.baidu.swan.pms.node.b
    public JSONObject aVi() {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("version", b.aVt().aVu());
            jSONObject.put("base_info", jSONObject2);
        } catch (JSONException e) {
            if (com.baidu.swan.pms.d.DEBUG) {
                e.printStackTrace();
            }
        }
        return jSONObject;
    }
}
