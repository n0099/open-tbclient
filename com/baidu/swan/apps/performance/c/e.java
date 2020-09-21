package com.baidu.swan.apps.performance.c;

import com.baidu.swan.apps.ap.ak;
import com.baidu.swan.apps.performance.HybridUbcFlow;
/* loaded from: classes3.dex */
public class e implements com.baidu.swan.apps.ap.e.b<HybridUbcFlow> {
    private static boolean cJC = true;
    private static int cJD = -1;
    private final String bZZ;

    public e(String str) {
        this.bZZ = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.ap.e.b
    /* renamed from: a */
    public synchronized void J(HybridUbcFlow hybridUbcFlow) {
        if (cJC) {
            if (cJD == -1) {
                cJD = com.baidu.swan.apps.t.a.apx().getSwitch("swan_next_env_delay", 600);
            }
            ak.c(new Runnable() { // from class: com.baidu.swan.apps.performance.c.e.1
                @Override // java.lang.Runnable
                public void run() {
                    ak.aFU();
                }
            }, cJD);
        }
        if ("fmp_callback".equals(this.bZZ)) {
            cJC = false;
        } else if ("callback_on_submit".equals(this.bZZ)) {
            cJC = true;
        }
    }
}
