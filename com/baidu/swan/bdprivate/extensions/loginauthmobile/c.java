package com.baidu.swan.bdprivate.extensions.loginauthmobile;
/* loaded from: classes7.dex */
public class c {
    private static com.baidu.swan.apps.a.a dHb;
    private static final com.baidu.swan.apps.a.a dHc = new com.baidu.swan.apps.a.a() { // from class: com.baidu.swan.bdprivate.extensions.loginauthmobile.c.1
        @Override // com.baidu.swan.apps.a.a
        public void onResult(int i) {
        }
    };

    public static void g(com.baidu.swan.apps.a.a aVar) {
        if (dHb != aVar) {
            dHb = aVar;
        }
    }

    public static com.baidu.swan.apps.a.a aNH() {
        return dHb == null ? dHc : dHb;
    }

    public static void release() {
        dHb = null;
    }
}
