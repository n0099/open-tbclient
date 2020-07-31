package com.baidu.swan.pms.node.b;

import org.json.JSONObject;
/* loaded from: classes19.dex */
public class d extends com.baidu.swan.pms.node.a {
    @Override // com.baidu.swan.pms.node.a, com.baidu.swan.pms.node.c
    public void a(JSONObject jSONObject, com.baidu.swan.pms.a.g gVar, com.baidu.swan.pms.a.g gVar2) {
        if (jSONObject != null) {
            e.aMf().cu(jSONObject.optJSONObject("tipmsgs"));
            b.aMd().cu(jSONObject.optJSONObject("pkg_clean_strategy"));
            g.aMh().cu(jSONObject.optJSONObject("pkg_preload"));
        }
    }
}
