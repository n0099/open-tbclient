package com.baidu.swan.apps.core.h;

import com.baidu.swan.apps.b;
import java.util.Map;
/* loaded from: classes9.dex */
public class a {
    private static final boolean DEBUG = b.DEBUG;
    private static volatile a blV;
    private Map<String, Object> blW;

    private void Nf() {
        this.blW = null;
        blV = null;
    }

    public static void release() {
        if (blV != null) {
            blV.Nf();
        }
    }
}
