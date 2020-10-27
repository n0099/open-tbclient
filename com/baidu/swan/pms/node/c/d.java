package com.baidu.swan.pms.node.c;

import android.support.annotation.Nullable;
import com.baidu.swan.pms.a.g;
import org.json.JSONObject;
/* loaded from: classes15.dex */
public class d extends com.baidu.swan.pms.node.a {
    @Override // com.baidu.swan.pms.node.a, com.baidu.swan.pms.node.d
    public void a(JSONObject jSONObject, g gVar, @Nullable g gVar2, @Nullable g gVar3) {
        JSONObject optJSONObject;
        a cO;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("base_info")) != null && (cO = a.cO(optJSONObject)) != null) {
            b.aZV().a(cO);
        }
    }
}
