package com.baidu.swan.config.b;

import com.baidu.swan.config.e;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class b extends com.baidu.swan.config.core.b.a {
    @Override // com.baidu.swan.config.core.b.c
    public void bu(JSONObject jSONObject) {
        if (jSONObject != null) {
            bx(jSONObject.optJSONObject("swan_core"));
            by(jSONObject.optJSONObject("swan_game"));
        }
    }

    private void bx(JSONObject jSONObject) {
        JSONObject bt = bt(jSONObject);
        if (bt != null) {
            e.arj().au(bt);
        }
    }

    private void by(JSONObject jSONObject) {
        JSONObject bt = bt(jSONObject);
        if (bt != null) {
            e.arj().av(bt);
        }
    }
}
