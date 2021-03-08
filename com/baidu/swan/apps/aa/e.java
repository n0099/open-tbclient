package com.baidu.swan.apps.aa;
/* loaded from: classes8.dex */
public class e {
    private static d drP;
    private static final d drQ = new d() { // from class: com.baidu.swan.apps.aa.e.1
        @Override // com.baidu.swan.apps.aa.d
        public void onPayResult(int i, String str) {
        }
    };

    public static void a(d dVar) {
        if (drP != dVar) {
            drP = dVar;
        }
    }

    public static d aDI() {
        return drP == null ? drQ : drP;
    }
}
