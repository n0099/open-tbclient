package com.baidu.swan.apps.m.a;

import android.support.annotation.Nullable;
import java.util.Map;
/* loaded from: classes2.dex */
public class c extends b {
    public c(@Nullable Map<String, String> map) {
        super("lifecycle", map);
    }

    @Override // com.baidu.swan.apps.m.a.b, com.baidu.swan.apps.m.a.a
    public String fe(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(com.baidu.swan.apps.m.a.r(str, "cuid", com.baidu.swan.apps.u.a.Jn().bf(com.baidu.swan.apps.u.a.Ji())));
        sb.append(com.baidu.swan.apps.m.a.r(str, "mtjCuid", com.baidu.swan.apps.u.a.Jn().bf(com.baidu.swan.apps.u.a.Ji())));
        for (Map.Entry<String, String> entry : this.mParams.entrySet()) {
            sb.append(com.baidu.swan.apps.m.a.r(str, entry.getKey(), entry.getValue()));
        }
        return sb.toString();
    }
}
