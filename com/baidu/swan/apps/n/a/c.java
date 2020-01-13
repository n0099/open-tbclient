package com.baidu.swan.apps.n.a;

import android.support.annotation.Nullable;
import java.util.Map;
/* loaded from: classes10.dex */
public class c extends b {
    public c(@Nullable Map<String, String> map) {
        super("lifecycle", map);
    }

    @Override // com.baidu.swan.apps.n.a.b, com.baidu.swan.apps.n.a.a
    public String hu(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(com.baidu.swan.apps.n.a.r(str, "cuid", com.baidu.swan.apps.w.a.RL().bn(com.baidu.swan.apps.w.a.RG())));
        sb.append(com.baidu.swan.apps.n.a.r(str, "mtjCuid", com.baidu.swan.apps.w.a.RL().bn(com.baidu.swan.apps.w.a.RG())));
        for (Map.Entry<String, String> entry : this.mParams.entrySet()) {
            sb.append(com.baidu.swan.apps.n.a.r(str, entry.getKey(), entry.getValue()));
        }
        return sb.toString();
    }
}
