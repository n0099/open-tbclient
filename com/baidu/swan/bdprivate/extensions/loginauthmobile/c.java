package com.baidu.swan.bdprivate.extensions.loginauthmobile;
/* loaded from: classes3.dex */
public class c {
    private static com.baidu.swan.apps.a.a dim;
    private static final com.baidu.swan.apps.a.a din = new com.baidu.swan.apps.a.a() { // from class: com.baidu.swan.bdprivate.extensions.loginauthmobile.c.1
        @Override // com.baidu.swan.apps.a.a
        public void onResult(int i) {
        }
    };

    public static void g(com.baidu.swan.apps.a.a aVar) {
        if (dim != aVar) {
            dim = aVar;
        }
    }

    public static com.baidu.swan.apps.a.a aHm() {
        return dim == null ? din : dim;
    }

    public static void release() {
        dim = null;
    }
}
