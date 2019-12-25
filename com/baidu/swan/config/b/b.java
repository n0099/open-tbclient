package com.baidu.swan.config.b;

import com.baidu.swan.config.e;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class b extends com.baidu.swan.config.core.b.a {
    @Override // com.baidu.swan.config.core.b.c
    public void bj(JSONObject jSONObject) {
        if (jSONObject != null) {
            bm(jSONObject.optJSONObject("swan_core"));
            bn(jSONObject.optJSONObject("swan_game"));
        }
    }

    private void bm(JSONObject jSONObject) {
        JSONObject bi = bi(jSONObject);
        if (bi != null) {
            e.agp().aj(bi);
        }
    }

    private void bn(JSONObject jSONObject) {
        JSONObject bi = bi(jSONObject);
        if (bi != null) {
            e.agp().ak(bi);
        }
    }
}
