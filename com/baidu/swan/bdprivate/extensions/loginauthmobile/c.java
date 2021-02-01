package com.baidu.swan.bdprivate.extensions.loginauthmobile;
/* loaded from: classes9.dex */
public class c {
    private static com.baidu.swan.apps.a.a dUm;
    private static final com.baidu.swan.apps.a.a dUn = new com.baidu.swan.apps.a.a() { // from class: com.baidu.swan.bdprivate.extensions.loginauthmobile.c.1
        @Override // com.baidu.swan.apps.a.a
        public void onResult(int i) {
        }
    };

    public static void g(com.baidu.swan.apps.a.a aVar) {
        if (dUm != aVar) {
            dUm = aVar;
        }
    }

    public static com.baidu.swan.apps.a.a aPI() {
        return dUm == null ? dUn : dUm;
    }

    public static void release() {
        dUm = null;
    }
}
