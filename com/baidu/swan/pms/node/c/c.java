package com.baidu.swan.pms.node.c;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class c extends com.baidu.swan.pms.node.b {
    @Override // com.baidu.swan.pms.node.b
    public JSONObject beI() {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("version", b.beT().beU());
            jSONObject.put("base_info", jSONObject2);
        } catch (JSONException e) {
            if (com.baidu.swan.pms.d.DEBUG) {
                e.printStackTrace();
            }
        }
        return jSONObject;
    }
}
