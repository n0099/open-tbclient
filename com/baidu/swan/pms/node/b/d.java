package com.baidu.swan.pms.node.b;

import android.support.annotation.Nullable;
import org.json.JSONObject;
/* loaded from: classes24.dex */
public class d extends com.baidu.swan.pms.node.a {
    @Override // com.baidu.swan.pms.node.a, com.baidu.swan.pms.node.d
    public void a(JSONObject jSONObject, com.baidu.swan.pms.a.g gVar, @Nullable com.baidu.swan.pms.a.g gVar2, @Nullable com.baidu.swan.pms.a.g gVar3) {
        if (jSONObject != null) {
            e.aVq().cC(jSONObject.optJSONObject("tipmsgs"));
            b.aVo().cC(jSONObject.optJSONObject("pkg_clean_strategy"));
            g.aVs().cC(jSONObject.optJSONObject("pkg_preload"));
        }
    }
}
