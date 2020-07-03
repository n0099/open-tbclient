package com.baidu.swan.pms.node.c;

import com.baidu.swan.pms.a.g;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class d extends com.baidu.swan.pms.node.a {
    @Override // com.baidu.swan.pms.node.a, com.baidu.swan.pms.node.c
    public void a(JSONObject jSONObject, g gVar, g gVar2) {
        JSONObject optJSONObject;
        a cq;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("base_info")) != null && (cq = a.cq(optJSONObject)) != null) {
            b.aIq().a(cq);
        }
    }
}
