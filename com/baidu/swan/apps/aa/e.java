package com.baidu.swan.apps.aa;
/* loaded from: classes9.dex */
public class e {
    private static d dsR;
    private static final d dsS = new d() { // from class: com.baidu.swan.apps.aa.e.1
        @Override // com.baidu.swan.apps.aa.d
        public void onPayResult(int i, String str) {
        }
    };

    public static void a(d dVar) {
        if (dsR != dVar) {
            dsR = dVar;
        }
    }

    public static d aHc() {
        return dsR == null ? dsS : dsR;
    }
}
