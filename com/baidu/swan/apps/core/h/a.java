package com.baidu.swan.apps.core.h;

import com.baidu.swan.apps.b;
import java.util.Map;
/* loaded from: classes11.dex */
public class a {
    private static final boolean DEBUG = b.DEBUG;
    private static volatile a bqU;
    private Map<String, Object> bqV;

    private void PP() {
        this.bqV = null;
        bqU = null;
    }

    public static void release() {
        if (bqU != null) {
            bqU.PP();
        }
    }
}
