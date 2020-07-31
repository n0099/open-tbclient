package com.baidu.swan.bdprivate.extensions.loginauthmobile;
/* loaded from: classes11.dex */
public class c {
    private static com.baidu.swan.apps.a.a cWY;
    private static final com.baidu.swan.apps.a.a cWZ = new com.baidu.swan.apps.a.a() { // from class: com.baidu.swan.bdprivate.extensions.loginauthmobile.c.1
        @Override // com.baidu.swan.apps.a.a
        public void onResult(int i) {
        }
    };

    public static void g(com.baidu.swan.apps.a.a aVar) {
        if (cWY != aVar) {
            cWY = aVar;
        }
    }

    public static com.baidu.swan.apps.a.a ayt() {
        return cWY == null ? cWZ : cWY;
    }

    public static void release() {
        cWY = null;
    }
}
