package com.baidu.swan.apps.aa;
/* loaded from: classes10.dex */
public class e {
    private static d dcD;
    private static final d dcE = new d() { // from class: com.baidu.swan.apps.aa.e.1
        @Override // com.baidu.swan.apps.aa.d
        public void onPayResult(int i, String str) {
        }
    };

    public static void a(d dVar) {
        if (dcD != dVar) {
            dcD = dVar;
        }
    }

    public static d aAH() {
        return dcD == null ? dcE : dcD;
    }
}
