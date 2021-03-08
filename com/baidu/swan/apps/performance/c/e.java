package com.baidu.swan.apps.performance.c;

import com.baidu.swan.apps.ao.ak;
import com.baidu.swan.apps.performance.HybridUbcFlow;
/* loaded from: classes8.dex */
public class e implements com.baidu.swan.apps.ao.e.b<HybridUbcFlow> {
    private static boolean dtq = true;
    private static int dtr = -1;
    private final String cJT;

    public e(String str) {
        this.cJT = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.ao.e.b
    /* renamed from: a */
    public synchronized void N(HybridUbcFlow hybridUbcFlow) {
        if (dtq) {
            if (dtr == -1) {
                dtr = com.baidu.swan.apps.t.a.axc().getSwitch("swan_next_env_delay", 600);
            }
            ak.c(new Runnable() { // from class: com.baidu.swan.apps.performance.c.e.1
                @Override // java.lang.Runnable
                public void run() {
                    ak.aOp();
                }
            }, dtr);
        }
        if ("fmp_callback".equals(this.cJT)) {
            dtq = false;
        } else if ("callback_on_submit".equals(this.cJT)) {
            dtq = true;
        }
    }
}
