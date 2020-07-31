package com.baidu.swan.pms.node.b;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes19.dex */
public class c extends com.baidu.swan.pms.node.b {
    @Override // com.baidu.swan.pms.node.b, com.baidu.swan.pms.node.d
    public JSONObject aLW() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("version", e.aMf().getVersion());
            jSONObject.put("tipmsgs", jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("version", g.aMh().getVersion());
            jSONObject.put("pkg_preload", jSONObject3);
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put("version", b.aMd().getVersion());
            jSONObject.put("pkg_clean_strategy", jSONObject4);
        } catch (JSONException e) {
            if (com.baidu.swan.pms.d.DEBUG) {
                e.printStackTrace();
            }
        }
        return jSONObject;
    }
}
