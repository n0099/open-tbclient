package com.baidu.swan.apps.core.h;

import com.baidu.swan.apps.b;
import java.util.Map;
/* loaded from: classes10.dex */
public class a {
    private static final boolean DEBUG = b.DEBUG;
    private static volatile a bmL;
    private Map<String, Object> bmM;

    private void NB() {
        this.bmM = null;
        bmL = null;
    }

    public static void release() {
        if (bmL != null) {
            bmL.NB();
        }
    }
}
