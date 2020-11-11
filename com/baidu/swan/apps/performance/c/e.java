package com.baidu.swan.apps.performance.c;

import com.baidu.swan.apps.ap.ak;
import com.baidu.swan.apps.performance.HybridUbcFlow;
/* loaded from: classes10.dex */
public class e implements com.baidu.swan.apps.ap.e.b<HybridUbcFlow> {
    private static boolean dkb = true;
    private static int dkc = -1;
    private final String cAM;

    public e(String str) {
        this.cAM = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.ap.e.b
    /* renamed from: a */
    public synchronized void M(HybridUbcFlow hybridUbcFlow) {
        if (dkb) {
            if (dkc == -1) {
                dkc = com.baidu.swan.apps.t.a.awD().getSwitch("swan_next_env_delay", 600);
            }
            ak.c(new Runnable() { // from class: com.baidu.swan.apps.performance.c.e.1
                @Override // java.lang.Runnable
                public void run() {
                    ak.aMX();
                }
            }, dkc);
        }
        if ("fmp_callback".equals(this.cAM)) {
            dkb = false;
        } else if ("callback_on_submit".equals(this.cAM)) {
            dkb = true;
        }
    }
}
