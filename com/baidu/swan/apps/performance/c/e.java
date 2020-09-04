package com.baidu.swan.apps.performance.c;

import com.baidu.swan.apps.ap.ak;
import com.baidu.swan.apps.performance.HybridUbcFlow;
/* loaded from: classes8.dex */
public class e implements com.baidu.swan.apps.ap.e.b<HybridUbcFlow> {
    private static boolean cHC = true;
    private static int cHD = -1;
    private final String bXY;

    public e(String str) {
        this.bXY = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.ap.e.b
    /* renamed from: a */
    public synchronized void I(HybridUbcFlow hybridUbcFlow) {
        if (cHC) {
            if (cHD == -1) {
                cHD = com.baidu.swan.apps.t.a.aoM().getSwitch("swan_next_env_delay", 600);
            }
            ak.c(new Runnable() { // from class: com.baidu.swan.apps.performance.c.e.1
                @Override // java.lang.Runnable
                public void run() {
                    ak.aFk();
                }
            }, cHD);
        }
        if ("fmp_callback".equals(this.bXY)) {
            cHC = false;
        } else if ("callback_on_submit".equals(this.bXY)) {
            cHC = true;
        }
    }
}
