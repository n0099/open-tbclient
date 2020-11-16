package com.baidu.swan.apps.aa;
/* loaded from: classes7.dex */
public class e {
    private static d dgQ;
    private static final d dgR = new d() { // from class: com.baidu.swan.apps.aa.e.1
        @Override // com.baidu.swan.apps.aa.d
        public void onPayResult(int i, String str) {
        }
    };

    public static void a(d dVar) {
        if (dgQ != dVar) {
            dgQ = dVar;
        }
    }

    public static d aCz() {
        return dgQ == null ? dgR : dgQ;
    }
}
