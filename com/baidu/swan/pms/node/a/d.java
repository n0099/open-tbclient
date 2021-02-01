package com.baidu.swan.pms.node.a;

import androidx.annotation.Nullable;
import com.baidu.swan.pms.a.g;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d extends com.baidu.swan.pms.node.a {
    @Override // com.baidu.swan.pms.node.a, com.baidu.swan.pms.node.d
    public void a(JSONObject jSONObject, g gVar, @Nullable g gVar2, @Nullable g gVar3) {
        a cR;
        if (jSONObject != null && (cR = b.bdA().cR(jSONObject)) != null) {
            com.baidu.swan.pms.d.bcp().a(cR);
        }
    }
}
