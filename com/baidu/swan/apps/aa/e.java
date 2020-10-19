package com.baidu.swan.apps.aa;
/* loaded from: classes10.dex */
public class e {
    private static d cUe;
    private static final d cUf = new d() { // from class: com.baidu.swan.apps.aa.e.1
        @Override // com.baidu.swan.apps.aa.d
        public void onPayResult(int i, String str) {
        }
    };

    public static void a(d dVar) {
        if (cUe != dVar) {
            cUe = dVar;
        }
    }

    public static d ayN() {
        return cUe == null ? cUf : cUe;
    }
}
