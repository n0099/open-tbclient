package com.baidu.swan.apps.performance.c;

import com.baidu.swan.apps.ao.ak;
import com.baidu.swan.apps.performance.HybridUbcFlow;
/* loaded from: classes8.dex */
public class e implements com.baidu.swan.apps.ao.e.b<HybridUbcFlow> {
    private static boolean dpD = true;
    private static int dpE = -1;
    private final String cFY;

    public e(String str) {
        this.cFY = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.ao.e.b
    /* renamed from: a */
    public synchronized void L(HybridUbcFlow hybridUbcFlow) {
        if (dpD) {
            if (dpE == -1) {
                dpE = com.baidu.swan.apps.t.a.awB().getSwitch("swan_next_env_delay", 600);
            }
            ak.c(new Runnable() { // from class: com.baidu.swan.apps.performance.c.e.1
                @Override // java.lang.Runnable
                public void run() {
                    ak.aNT();
                }
            }, dpE);
        }
        if ("fmp_callback".equals(this.cFY)) {
            dpD = false;
        } else if ("callback_on_submit".equals(this.cFY)) {
            dpD = true;
        }
    }
}
