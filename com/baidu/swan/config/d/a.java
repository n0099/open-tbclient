package com.baidu.swan.config.d;

import com.baidu.swan.config.e;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a extends com.baidu.swan.config.core.a.a {
    @Override // com.baidu.swan.config.core.a.c
    public JSONObject agN() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("version", c.agS().getVersion());
        } catch (JSONException e) {
            if (e.DEBUG) {
                e.printStackTrace();
            }
        }
        return jSONObject;
    }
}
