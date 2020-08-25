package com.baidu.swan.apps.performance.c;

import com.baidu.swan.apps.ap.ak;
import com.baidu.swan.apps.performance.HybridUbcFlow;
/* loaded from: classes8.dex */
public class e implements com.baidu.swan.apps.ap.e.b<HybridUbcFlow> {
    private static boolean cHy = true;
    private static int cHz = -1;
    private final String bXU;

    public e(String str) {
        this.bXU = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.ap.e.b
    /* renamed from: a */
    public synchronized void I(HybridUbcFlow hybridUbcFlow) {
        if (cHy) {
            if (cHz == -1) {
                cHz = com.baidu.swan.apps.t.a.aoM().getSwitch("swan_next_env_delay", 600);
            }
            ak.c(new Runnable() { // from class: com.baidu.swan.apps.performance.c.e.1
                @Override // java.lang.Runnable
                public void run() {
                    ak.aFk();
                }
            }, cHz);
        }
        if ("fmp_callback".equals(this.bXU)) {
            cHy = false;
        } else if ("callback_on_submit".equals(this.bXU)) {
            cHy = true;
        }
    }
}
