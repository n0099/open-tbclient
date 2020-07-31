package com.baidu.swan.pms.node.c;

import com.baidu.swan.pms.a.g;
import org.json.JSONObject;
/* loaded from: classes19.dex */
public class d extends com.baidu.swan.pms.node.a {
    @Override // com.baidu.swan.pms.node.a, com.baidu.swan.pms.node.c
    public void a(JSONObject jSONObject, g gVar, g gVar2) {
        JSONObject optJSONObject;
        a cw;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("base_info")) != null && (cw = a.cw(optJSONObject)) != null) {
            b.aMi().a(cw);
        }
    }
}
