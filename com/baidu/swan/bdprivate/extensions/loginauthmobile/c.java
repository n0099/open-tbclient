package com.baidu.swan.bdprivate.extensions.loginauthmobile;
/* loaded from: classes3.dex */
public class c {
    private static com.baidu.swan.apps.a.a dgl;
    private static final com.baidu.swan.apps.a.a dgm = new com.baidu.swan.apps.a.a() { // from class: com.baidu.swan.bdprivate.extensions.loginauthmobile.c.1
        @Override // com.baidu.swan.apps.a.a
        public void onResult(int i) {
        }
    };

    public static void g(com.baidu.swan.apps.a.a aVar) {
        if (dgl != aVar) {
            dgl = aVar;
        }
    }

    public static com.baidu.swan.apps.a.a aGC() {
        return dgl == null ? dgm : dgl;
    }

    public static void release() {
        dgl = null;
    }
}
