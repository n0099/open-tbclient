package com.baidu.swan.pms.node.a;

import com.baidu.swan.pms.a.g;
import org.json.JSONObject;
/* loaded from: classes19.dex */
public class d extends com.baidu.swan.pms.node.a {
    @Override // com.baidu.swan.pms.node.a, com.baidu.swan.pms.node.c
    public void a(JSONObject jSONObject, g gVar, g gVar2) {
        a cs;
        if (jSONObject != null && (cs = b.aMa().cs(jSONObject)) != null) {
            com.baidu.swan.pms.d.aKM().a(cs);
        }
    }
}
