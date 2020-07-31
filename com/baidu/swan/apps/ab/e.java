package com.baidu.swan.apps.ab;
/* loaded from: classes7.dex */
public class e {
    private static d cyd;
    private static final d cye = new d() { // from class: com.baidu.swan.apps.ab.e.1
        @Override // com.baidu.swan.apps.ab.d
        public void onPayResult(int i, String str) {
        }
    };

    public static void a(d dVar) {
        if (cyd != dVar) {
            cyd = dVar;
        }
    }

    public static d any() {
        return cyd == null ? cye : cyd;
    }
}
