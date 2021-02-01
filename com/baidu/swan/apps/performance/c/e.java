package com.baidu.swan.apps.performance.c;

import com.baidu.swan.apps.ao.ak;
import com.baidu.swan.apps.performance.HybridUbcFlow;
/* loaded from: classes9.dex */
public class e implements com.baidu.swan.apps.ao.e.b<HybridUbcFlow> {
    private static boolean drO = true;
    private static int drP = -1;
    private final String cIt;

    public e(String str) {
        this.cIt = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.ao.e.b
    /* renamed from: a */
    public synchronized void L(HybridUbcFlow hybridUbcFlow) {
        if (drO) {
            if (drP == -1) {
                drP = com.baidu.swan.apps.t.a.awZ().getSwitch("swan_next_env_delay", 600);
            }
            ak.c(new Runnable() { // from class: com.baidu.swan.apps.performance.c.e.1
                @Override // java.lang.Runnable
                public void run() {
                    ak.aOm();
                }
            }, drP);
        }
        if ("fmp_callback".equals(this.cIt)) {
            drO = false;
        } else if ("callback_on_submit".equals(this.cIt)) {
            drO = true;
        }
    }
}
