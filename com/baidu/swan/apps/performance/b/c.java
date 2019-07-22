package com.baidu.swan.apps.performance.b;

import com.baidu.swan.apps.an.ac;
import com.baidu.swan.apps.performance.HybridUbcFlow;
/* loaded from: classes2.dex */
public class c implements com.baidu.swan.apps.an.d.a<HybridUbcFlow> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.an.d.a
    /* renamed from: a */
    public void D(HybridUbcFlow hybridUbcFlow) {
        ac.c(new Runnable() { // from class: com.baidu.swan.apps.performance.b.c.1
            @Override // java.lang.Runnable
            public void run() {
                ac.PL();
            }
        }, IQ());
    }

    private int IQ() {
        if (com.baidu.swan.apps.u.a.En() == null) {
            return 0;
        }
        int wg = com.baidu.swan.apps.u.a.En().wg();
        if (wg <= 0) {
            wg = 0;
        }
        return wg;
    }
}
