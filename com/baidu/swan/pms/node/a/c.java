package com.baidu.swan.pms.node.a;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class c extends com.baidu.swan.pms.node.b {
    @Override // com.baidu.swan.pms.node.b, com.baidu.swan.pms.node.d
    public JSONObject aIe() {
        b aIi = b.aIi();
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("version", aIi.aIj());
            jSONObject.put("ceres_info", jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("version", aIi.aIk());
            jSONObject.put("global_info", jSONObject3);
        } catch (JSONException e) {
            if (com.baidu.swan.pms.d.DEBUG) {
                e.printStackTrace();
            }
        }
        return jSONObject;
    }
}
