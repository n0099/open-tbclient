package com.baidu.swan.apps.core.h;

import com.baidu.swan.apps.b;
import java.util.Map;
/* loaded from: classes11.dex */
public class a {
    private static final boolean DEBUG = b.DEBUG;
    private static volatile a bri;
    private Map<String, Object> brj;

    private void PU() {
        this.brj = null;
        bri = null;
    }

    public static void release() {
        if (bri != null) {
            bri.PU();
        }
    }
}
