package com.baidu.swan.apps.aa;
/* loaded from: classes9.dex */
public class e {
    private static d dqn;
    private static final d dqo = new d() { // from class: com.baidu.swan.apps.aa.e.1
        @Override // com.baidu.swan.apps.aa.d
        public void onPayResult(int i, String str) {
        }
    };

    public static void a(d dVar) {
        if (dqn != dVar) {
            dqn = dVar;
        }
    }

    public static d aDF() {
        return dqn == null ? dqo : dqn;
    }
}
