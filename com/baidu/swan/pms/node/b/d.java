package com.baidu.swan.pms.node.b;

import androidx.annotation.Nullable;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class d extends com.baidu.swan.pms.node.a {
    @Override // com.baidu.swan.pms.node.a, com.baidu.swan.pms.node.d
    public void a(JSONObject jSONObject, com.baidu.swan.pms.a.g gVar, @Nullable com.baidu.swan.pms.a.g gVar2, @Nullable com.baidu.swan.pms.a.g gVar3) {
        if (jSONObject != null) {
            e.bhl().cW(jSONObject.optJSONObject("tipmsgs"));
            b.bhj().cW(jSONObject.optJSONObject("pkg_clean_strategy"));
            g.bhn().cW(jSONObject.optJSONObject("pkg_preload"));
        }
    }
}
