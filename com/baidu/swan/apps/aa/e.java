package com.baidu.swan.apps.aa;
/* loaded from: classes8.dex */
public class e {
    private static d cFX;
    private static final d cFY = new d() { // from class: com.baidu.swan.apps.aa.e.1
        @Override // com.baidu.swan.apps.aa.d
        public void onPayResult(int i, String str) {
        }
    };

    public static void a(d dVar) {
        if (cFX != dVar) {
            cFX = dVar;
        }
    }

    public static d avt() {
        return cFX == null ? cFY : cFX;
    }
}
