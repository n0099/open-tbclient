package com.baidu.swan.apps.t.a;
/* loaded from: classes6.dex */
public class f {
    private static volatile e dgX;

    public static synchronized e ayy() {
        e eVar;
        synchronized (f.class) {
            if (dgX == null) {
                dgX = new e();
            }
            eVar = dgX;
        }
        return eVar;
    }
}
