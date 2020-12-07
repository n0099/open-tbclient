package com.baidu.swan.apps.performance.c;

import com.baidu.swan.apps.ap.ak;
import com.baidu.swan.apps.performance.HybridUbcFlow;
/* loaded from: classes25.dex */
public class e implements com.baidu.swan.apps.ap.e.b<HybridUbcFlow> {
    private static boolean dpt = true;
    private static int dpu = -1;
    private final String cFU;

    public e(String str) {
        this.cFU = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.ap.e.b
    /* renamed from: a */
    public synchronized void M(HybridUbcFlow hybridUbcFlow) {
        if (dpt) {
            if (dpu == -1) {
                dpu = com.baidu.swan.apps.t.a.azd().getSwitch("swan_next_env_delay", 600);
            }
            ak.c(new Runnable() { // from class: com.baidu.swan.apps.performance.c.e.1
                @Override // java.lang.Runnable
                public void run() {
                    ak.aPv();
                }
            }, dpu);
        }
        if ("fmp_callback".equals(this.cFU)) {
            dpt = false;
        } else if ("callback_on_submit".equals(this.cFU)) {
            dpt = true;
        }
    }
}
