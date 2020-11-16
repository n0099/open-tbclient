package com.baidu.swan.pms.node.a;

import android.support.annotation.Nullable;
import com.baidu.swan.pms.a.g;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class d extends com.baidu.swan.pms.node.a {
    @Override // com.baidu.swan.pms.node.a, com.baidu.swan.pms.node.d
    public void a(JSONObject jSONObject, g gVar, @Nullable g gVar2, @Nullable g gVar3) {
        a cK;
        if (jSONObject != null && (cK = b.bbG().cK(jSONObject)) != null) {
            com.baidu.swan.pms.d.bau().a(cK);
        }
    }
}
