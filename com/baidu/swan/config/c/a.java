package com.baidu.swan.config.c;

import com.baidu.swan.config.e;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a extends com.baidu.swan.config.core.a.a {
    @Override // com.baidu.swan.config.core.a.c
    public JSONObject aro() {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("version", c.arp().arq());
            jSONObject.put("base_info", jSONObject2);
        } catch (JSONException e) {
            if (e.DEBUG) {
                e.printStackTrace();
            }
        }
        return jSONObject;
    }
}
