package com.baidu.swan.config.a;

import com.baidu.swan.config.e;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class b extends com.baidu.swan.config.core.b.a {
    @Override // com.baidu.swan.config.core.b.c
    public void bj(JSONObject jSONObject) {
        if (jSONObject != null) {
            bk(jSONObject.optJSONObject("swan_ext"));
            bl(jSONObject.optJSONObject("game_ext"));
        }
    }

    private void bk(JSONObject jSONObject) {
        JSONObject bi = bi(jSONObject);
        if (bi != null) {
            e.agp().al(bi);
        }
    }

    private void bl(JSONObject jSONObject) {
        JSONObject bi = bi(jSONObject);
        if (bi != null) {
            e.agp().am(bi);
        }
    }
}
