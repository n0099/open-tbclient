package com.baidu.swan.bdprivate.extensions.loginauthmobile;
/* loaded from: classes25.dex */
public class c {
    private static com.baidu.swan.apps.a.a dNZ;
    private static final com.baidu.swan.apps.a.a dOa = new com.baidu.swan.apps.a.a() { // from class: com.baidu.swan.bdprivate.extensions.loginauthmobile.c.1
        @Override // com.baidu.swan.apps.a.a
        public void onResult(int i) {
        }
    };

    public static void g(com.baidu.swan.apps.a.a aVar) {
        if (dNZ != aVar) {
            dNZ = aVar;
        }
    }

    public static com.baidu.swan.apps.a.a aQN() {
        return dNZ == null ? dOa : dNZ;
    }

    public static void release() {
        dNZ = null;
    }
}
