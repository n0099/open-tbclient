package com.baidu.swan.pms.node.b;

import android.support.annotation.Nullable;
import org.json.JSONObject;
/* loaded from: classes15.dex */
public class d extends com.baidu.swan.pms.node.a {
    @Override // com.baidu.swan.pms.node.a, com.baidu.swan.pms.node.d
    public void a(JSONObject jSONObject, com.baidu.swan.pms.a.g gVar, @Nullable com.baidu.swan.pms.a.g gVar2, @Nullable com.baidu.swan.pms.a.g gVar3) {
        if (jSONObject != null) {
            e.bcs().cS(jSONObject.optJSONObject("tipmsgs"));
            b.bcq().cS(jSONObject.optJSONObject("pkg_clean_strategy"));
            g.bcu().cS(jSONObject.optJSONObject("pkg_preload"));
        }
    }
}
