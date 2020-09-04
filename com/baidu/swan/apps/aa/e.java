package com.baidu.swan.apps.aa;
/* loaded from: classes8.dex */
public class e {
    private static d cGb;
    private static final d cGc = new d() { // from class: com.baidu.swan.apps.aa.e.1
        @Override // com.baidu.swan.apps.aa.d
        public void onPayResult(int i, String str) {
        }
    };

    public static void a(d dVar) {
        if (cGb != dVar) {
            cGb = dVar;
        }
    }

    public static d avt() {
        return cGb == null ? cGc : cGb;
    }
}
