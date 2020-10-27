package com.baidu.swan.apps.performance.c;

import com.baidu.swan.apps.ap.ak;
import com.baidu.swan.apps.performance.HybridUbcFlow;
/* loaded from: classes10.dex */
public class e implements com.baidu.swan.apps.ap.e.b<HybridUbcFlow> {
    private static boolean def = true;
    private static int deg = -1;
    private final String cuT;

    public e(String str) {
        this.cuT = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.ap.e.b
    /* renamed from: a */
    public synchronized void M(HybridUbcFlow hybridUbcFlow) {
        if (def) {
            if (deg == -1) {
                deg = com.baidu.swan.apps.t.a.aud().getSwitch("swan_next_env_delay", 600);
            }
            ak.c(new Runnable() { // from class: com.baidu.swan.apps.performance.c.e.1
                @Override // java.lang.Runnable
                public void run() {
                    ak.aKx();
                }
            }, deg);
        }
        if ("fmp_callback".equals(this.cuT)) {
            def = false;
        } else if ("callback_on_submit".equals(this.cuT)) {
            def = true;
        }
    }
}
