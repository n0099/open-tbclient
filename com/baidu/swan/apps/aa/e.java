package com.baidu.swan.apps.aa;
/* loaded from: classes3.dex */
public class e {
    private static d cIb;
    private static final d cIc = new d() { // from class: com.baidu.swan.apps.aa.e.1
        @Override // com.baidu.swan.apps.aa.d
        public void onPayResult(int i, String str) {
        }
    };

    public static void a(d dVar) {
        if (cIb != dVar) {
            cIb = dVar;
        }
    }

    public static d awc() {
        return cIb == null ? cIc : cIb;
    }
}
