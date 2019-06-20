package com.baidu.swan.apps.m.a;

import android.support.annotation.Nullable;
import java.util.Map;
/* loaded from: classes2.dex */
public class c extends b {
    public c(@Nullable Map<String, String> map) {
        super("lifecycle", map);
    }

    @Override // com.baidu.swan.apps.m.a.b, com.baidu.swan.apps.m.a.a
    public String eq(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(com.baidu.swan.apps.m.a.n(str, "cuid", com.baidu.swan.apps.u.a.DG().bd(com.baidu.swan.apps.u.a.DB())));
        sb.append(com.baidu.swan.apps.m.a.n(str, "mtjCuid", com.baidu.swan.apps.u.a.DG().bd(com.baidu.swan.apps.u.a.DB())));
        for (Map.Entry<String, String> entry : this.mParams.entrySet()) {
            sb.append(com.baidu.swan.apps.m.a.n(str, entry.getKey(), entry.getValue()));
        }
        return sb.toString();
    }
}
