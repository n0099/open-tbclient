package com.baidu.swan.bdprivate.extensions.loginauthmobile;
/* loaded from: classes8.dex */
public class c {
    private static com.baidu.swan.apps.a.a dSg;
    private static final com.baidu.swan.apps.a.a dSh = new com.baidu.swan.apps.a.a() { // from class: com.baidu.swan.bdprivate.extensions.loginauthmobile.c.1
        @Override // com.baidu.swan.apps.a.a
        public void onResult(int i) {
        }
    };

    public static void g(com.baidu.swan.apps.a.a aVar) {
        if (dSg != aVar) {
            dSg = aVar;
        }
    }

    public static com.baidu.swan.apps.a.a aPp() {
        return dSg == null ? dSh : dSg;
    }

    public static void release() {
        dSg = null;
    }
}
