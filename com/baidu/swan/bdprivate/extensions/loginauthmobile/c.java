package com.baidu.swan.bdprivate.extensions.loginauthmobile;
/* loaded from: classes9.dex */
public class c {
    private static com.baidu.swan.apps.a.a dWS;
    private static final com.baidu.swan.apps.a.a dWT = new com.baidu.swan.apps.a.a() { // from class: com.baidu.swan.bdprivate.extensions.loginauthmobile.c.1
        @Override // com.baidu.swan.apps.a.a
        public void onResult(int i) {
        }
    };

    public static void g(com.baidu.swan.apps.a.a aVar) {
        if (dWS != aVar) {
            dWS = aVar;
        }
    }

    public static com.baidu.swan.apps.a.a aTj() {
        return dWS == null ? dWT : dWS;
    }

    public static void release() {
        dWS = null;
    }
}
