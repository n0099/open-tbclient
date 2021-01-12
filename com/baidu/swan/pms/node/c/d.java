package com.baidu.swan.pms.node.c;

import androidx.annotation.Nullable;
import com.baidu.swan.pms.a.g;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class d extends com.baidu.swan.pms.node.a {
    @Override // com.baidu.swan.pms.node.a, com.baidu.swan.pms.node.d
    public void a(JSONObject jSONObject, g gVar, @Nullable g gVar2, @Nullable g gVar3) {
        JSONObject optJSONObject;
        a cY;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("base_info")) != null && (cY = a.cY(optJSONObject)) != null) {
            b.bdv().a(cY);
        }
    }
}
