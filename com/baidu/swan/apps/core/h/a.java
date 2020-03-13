package com.baidu.swan.apps.core.h;

import com.baidu.swan.apps.b;
import java.util.Map;
/* loaded from: classes11.dex */
public class a {
    private static final boolean DEBUG = b.DEBUG;
    private static volatile a bqW;
    private Map<String, Object> bqX;

    private void PR() {
        this.bqX = null;
        bqW = null;
    }

    public static void release() {
        if (bqW != null) {
            bqW.PR();
        }
    }
}
