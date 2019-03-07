package com.baidu.swan.apps.performance.b;

import com.baidu.swan.apps.an.aa;
import com.baidu.swan.apps.performance.HybridUbcFlow;
/* loaded from: classes2.dex */
public class c implements com.baidu.swan.apps.an.c.a<HybridUbcFlow> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.an.c.a
    /* renamed from: a */
    public void D(HybridUbcFlow hybridUbcFlow) {
        aa.b(new Runnable() { // from class: com.baidu.swan.apps.performance.b.c.1
            @Override // java.lang.Runnable
            public void run() {
                aa.Mp();
            }
        }, FX());
    }

    private int FX() {
        if (com.baidu.swan.apps.u.a.CB() == null) {
            return 0;
        }
        int ve = com.baidu.swan.apps.u.a.CB().ve();
        if (ve <= 0) {
            ve = 0;
        }
        return ve;
    }
}
