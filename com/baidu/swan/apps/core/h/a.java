package com.baidu.swan.apps.core.h;

import com.baidu.swan.apps.b;
import java.util.Map;
/* loaded from: classes11.dex */
public class a {
    private static final boolean DEBUG = b.DEBUG;
    private static volatile a bqV;
    private Map<String, Object> bqW;

    private void PR() {
        this.bqW = null;
        bqV = null;
    }

    public static void release() {
        if (bqV != null) {
            bqV.PR();
        }
    }
}
