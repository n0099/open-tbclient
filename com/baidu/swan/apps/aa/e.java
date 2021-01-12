package com.baidu.swan.apps.aa;
/* loaded from: classes8.dex */
public class e {
    private static d doa;
    private static final d dob = new d() { // from class: com.baidu.swan.apps.aa.e.1
        @Override // com.baidu.swan.apps.aa.d
        public void onPayResult(int i, String str) {
        }
    };

    public static void a(d dVar) {
        if (doa != dVar) {
            doa = dVar;
        }
    }

    public static d aDj() {
        return doa == null ? dob : doa;
    }
}
