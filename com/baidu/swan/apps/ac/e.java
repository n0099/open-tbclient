package com.baidu.swan.apps.ac;
/* loaded from: classes11.dex */
public class e {
    private static d cvQ;
    private static final d cvR = new d() { // from class: com.baidu.swan.apps.ac.e.1
        @Override // com.baidu.swan.apps.ac.d
        public void onPayResult(int i, String str) {
        }
    };

    public static void a(d dVar) {
        if (cvQ != dVar) {
            cvQ = dVar;
        }
    }

    public static d amf() {
        return cvQ == null ? cvR : cvQ;
    }
}
