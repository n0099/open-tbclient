package com.baidu.swan.apps.core.h;

import com.baidu.swan.apps.b;
import java.util.Map;
/* loaded from: classes11.dex */
public class a {
    private static final boolean DEBUG = b.DEBUG;
    private static volatile a bPu;
    private Map<String, Object> bPv;

    private void XI() {
        this.bPv = null;
        bPu = null;
    }

    public static void release() {
        if (bPu != null) {
            bPu.XI();
        }
    }
}
