package com.baidu.swan.config.c;

import org.json.JSONObject;
/* loaded from: classes10.dex */
public class b extends com.baidu.swan.config.core.b.a {
    @Override // com.baidu.swan.config.core.b.c
    public void bj(JSONObject jSONObject) {
        JSONObject bi;
        int optInt;
        if (jSONObject != null && (bi = bi(jSONObject.optJSONObject("base_info"))) != null && (optInt = bi.optInt("version")) > 0) {
            c.agO().d(bi.optString("host_name"), bi.optString("scheme_head"), bi.optString("share_callback_url"), optInt);
        }
    }
}
