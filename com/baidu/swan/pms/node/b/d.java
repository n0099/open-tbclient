package com.baidu.swan.pms.node.b;

import org.json.JSONObject;
/* loaded from: classes11.dex */
public class d extends com.baidu.swan.pms.node.a {
    @Override // com.baidu.swan.pms.node.a, com.baidu.swan.pms.node.c
    public void a(JSONObject jSONObject, com.baidu.swan.pms.a.g gVar, com.baidu.swan.pms.a.g gVar2) {
        if (jSONObject != null) {
            e.aHh().ch(jSONObject.optJSONObject("tipmsgs"));
            b.aHf().ch(jSONObject.optJSONObject("pkg_clean_strategy"));
            g.aHj().ch(jSONObject.optJSONObject("pkg_preload"));
        }
    }
}
