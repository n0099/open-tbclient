package com.baidu.swan.apps.m.a;

import android.support.annotation.Nullable;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import java.util.Map;
/* loaded from: classes2.dex */
public class c extends b {
    public c(@Nullable Map<String, String> map) {
        super("lifecycle", map);
    }

    @Override // com.baidu.swan.apps.m.a.b, com.baidu.swan.apps.m.a.a
    public String ex(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(com.baidu.swan.apps.m.a.n(str, DpStatConstants.KEY_CUID, com.baidu.swan.apps.u.a.Et().bd(com.baidu.swan.apps.u.a.Eo())));
        sb.append(com.baidu.swan.apps.m.a.n(str, "mtjCuid", com.baidu.swan.apps.u.a.Et().bd(com.baidu.swan.apps.u.a.Eo())));
        for (Map.Entry<String, String> entry : this.mParams.entrySet()) {
            sb.append(com.baidu.swan.apps.m.a.n(str, entry.getKey(), entry.getValue()));
        }
        return sb.toString();
    }
}
