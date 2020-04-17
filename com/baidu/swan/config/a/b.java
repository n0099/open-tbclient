package com.baidu.swan.config.a;

import com.baidu.swan.config.e;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class b extends com.baidu.swan.config.core.b.a {
    @Override // com.baidu.swan.config.core.b.c
    public void bu(JSONObject jSONObject) {
        if (jSONObject != null) {
            bv(jSONObject.optJSONObject("swan_ext"));
            bw(jSONObject.optJSONObject("game_ext"));
        }
    }

    private void bv(JSONObject jSONObject) {
        JSONObject bt = bt(jSONObject);
        if (bt != null) {
            e.arj().aw(bt);
        }
    }

    private void bw(JSONObject jSONObject) {
        JSONObject bt = bt(jSONObject);
        if (bt != null) {
            e.arj().ax(bt);
        }
    }
}
