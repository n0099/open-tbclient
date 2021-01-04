package com.baidu.swan.apps.performance.c;

import com.baidu.swan.apps.ao.ak;
import com.baidu.swan.apps.performance.HybridUbcFlow;
/* loaded from: classes9.dex */
public class e implements com.baidu.swan.apps.ao.e.b<HybridUbcFlow> {
    private static boolean dus = true;
    private static int dut = -1;
    private final String cKK;

    public e(String str) {
        this.cKK = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.ao.e.b
    /* renamed from: a */
    public synchronized void L(HybridUbcFlow hybridUbcFlow) {
        if (dus) {
            if (dut == -1) {
                dut = com.baidu.swan.apps.t.a.aAu().getSwitch("swan_next_env_delay", 600);
            }
            ak.c(new Runnable() { // from class: com.baidu.swan.apps.performance.c.e.1
                @Override // java.lang.Runnable
                public void run() {
                    ak.aRM();
                }
            }, dut);
        }
        if ("fmp_callback".equals(this.cKK)) {
            dus = false;
        } else if ("callback_on_submit".equals(this.cKK)) {
            dus = true;
        }
    }
}
