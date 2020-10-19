package com.baidu.swan.apps.performance.c;

import com.baidu.swan.apps.ap.ak;
import com.baidu.swan.apps.performance.HybridUbcFlow;
/* loaded from: classes10.dex */
public class e implements com.baidu.swan.apps.ap.e.b<HybridUbcFlow> {
    private static boolean cVF = true;
    private static int cVG = -1;
    private final String cmp;

    public e(String str) {
        this.cmp = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.ap.e.b
    /* renamed from: a */
    public synchronized void M(HybridUbcFlow hybridUbcFlow) {
        if (cVF) {
            if (cVG == -1) {
                cVG = com.baidu.swan.apps.t.a.asi().getSwitch("swan_next_env_delay", 600);
            }
            ak.c(new Runnable() { // from class: com.baidu.swan.apps.performance.c.e.1
                @Override // java.lang.Runnable
                public void run() {
                    ak.aID();
                }
            }, cVG);
        }
        if ("fmp_callback".equals(this.cmp)) {
            cVF = false;
        } else if ("callback_on_submit".equals(this.cmp)) {
            cVF = true;
        }
    }
}
