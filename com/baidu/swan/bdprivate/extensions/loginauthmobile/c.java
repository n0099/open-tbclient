package com.baidu.swan.bdprivate.extensions.loginauthmobile;
/* loaded from: classes8.dex */
public class c {
    private static com.baidu.swan.apps.a.a duu;
    private static final com.baidu.swan.apps.a.a duv = new com.baidu.swan.apps.a.a() { // from class: com.baidu.swan.bdprivate.extensions.loginauthmobile.c.1
        @Override // com.baidu.swan.apps.a.a
        public void onResult(int i) {
        }
    };

    public static void g(com.baidu.swan.apps.a.a aVar) {
        if (duu != aVar) {
            duu = aVar;
        }
    }

    public static com.baidu.swan.apps.a.a aJV() {
        return duu == null ? duv : duu;
    }

    public static void release() {
        duu = null;
    }
}
