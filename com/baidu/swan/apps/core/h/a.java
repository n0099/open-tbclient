package com.baidu.swan.apps.core.h;

import com.baidu.swan.apps.b;
import java.util.Map;
/* loaded from: classes11.dex */
public class a {
    private static final boolean DEBUG = b.DEBUG;
    private static volatile a bPp;
    private Map<String, Object> bPq;

    private void XJ() {
        this.bPq = null;
        bPp = null;
    }

    public static void release() {
        if (bPp != null) {
            bPp.XJ();
        }
    }
}
