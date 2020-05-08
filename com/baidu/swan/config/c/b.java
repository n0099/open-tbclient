package com.baidu.swan.config.c;

import org.json.JSONObject;
/* loaded from: classes11.dex */
public class b extends com.baidu.swan.config.core.b.a {
    @Override // com.baidu.swan.config.core.b.c
    public void bu(JSONObject jSONObject) {
        JSONObject bt;
        int optInt;
        if (jSONObject != null && (bt = bt(jSONObject.optJSONObject("base_info"))) != null && (optInt = bt.optInt("version")) > 0) {
            c.aro().d(bt.optString("host_name"), bt.optString("scheme_head"), bt.optString("share_callback_url"), optInt);
        }
    }
}
