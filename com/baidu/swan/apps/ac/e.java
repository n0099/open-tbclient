package com.baidu.swan.apps.ac;
/* loaded from: classes11.dex */
public class e {
    private static d crb;
    private static final d crd = new d() { // from class: com.baidu.swan.apps.ac.e.1
        @Override // com.baidu.swan.apps.ac.d
        public void onPayResult(int i, String str) {
        }
    };

    public static void a(d dVar) {
        if (crb != dVar) {
            crb = dVar;
        }
    }

    public static d akZ() {
        return crb == null ? crd : crb;
    }
}
