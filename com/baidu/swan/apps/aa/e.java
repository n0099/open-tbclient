package com.baidu.swan.apps.aa;
/* loaded from: classes10.dex */
public class e {
    private static d diA;
    private static final d diB = new d() { // from class: com.baidu.swan.apps.aa.e.1
        @Override // com.baidu.swan.apps.aa.d
        public void onPayResult(int i, String str) {
        }
    };

    public static void a(d dVar) {
        if (diA != dVar) {
            diA = dVar;
        }
    }

    public static d aDh() {
        return diA == null ? diB : diA;
    }
}
