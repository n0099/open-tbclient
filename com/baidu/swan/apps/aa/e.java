package com.baidu.swan.apps.aa;
/* loaded from: classes25.dex */
public class e {
    private static d dnR;
    private static final d dnS = new d() { // from class: com.baidu.swan.apps.aa.e.1
        @Override // com.baidu.swan.apps.aa.d
        public void onPayResult(int i, String str) {
        }
    };

    public static void a(d dVar) {
        if (dnR != dVar) {
            dnR = dVar;
        }
    }

    public static d aFI() {
        return dnR == null ? dnS : dnR;
    }
}
