package com.baidu.swan.apps.performance.c;

import com.baidu.swan.apps.ap.ak;
import com.baidu.swan.apps.performance.HybridUbcFlow;
/* loaded from: classes7.dex */
public class e implements com.baidu.swan.apps.ap.e.b<HybridUbcFlow> {
    private static boolean diu = true;
    private static int div = -1;
    private final String czc;

    public e(String str) {
        this.czc = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.ap.e.b
    /* renamed from: a */
    public synchronized void M(HybridUbcFlow hybridUbcFlow) {
        if (diu) {
            if (div == -1) {
                div = com.baidu.swan.apps.t.a.avV().getSwitch("swan_next_env_delay", 600);
            }
            ak.c(new Runnable() { // from class: com.baidu.swan.apps.performance.c.e.1
                @Override // java.lang.Runnable
                public void run() {
                    ak.aMp();
                }
            }, div);
        }
        if ("fmp_callback".equals(this.czc)) {
            diu = false;
        } else if ("callback_on_submit".equals(this.czc)) {
            diu = true;
        }
    }
}
