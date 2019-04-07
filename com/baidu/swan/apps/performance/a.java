package com.baidu.swan.apps.performance;

import com.baidu.swan.apps.performance.HybridUbcFlow;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public class a {
    private final Map<String, HybridUbcFlow> aDt = new HashMap();
    private final Map<String, com.baidu.swan.apps.an.c.a<HybridUbcFlow>> aDu = new HashMap();
    private final com.baidu.swan.apps.an.c.a<HybridUbcFlow> aDv = new com.baidu.swan.apps.an.c.a<HybridUbcFlow>() { // from class: com.baidu.swan.apps.performance.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.an.c.a
        /* renamed from: a */
        public void D(HybridUbcFlow hybridUbcFlow) {
            a.this.fA(hybridUbcFlow.name);
        }
    };

    public synchronized HybridUbcFlow fz(String str) {
        HybridUbcFlow fB;
        synchronized (this.aDt) {
            fB = fB(str);
            if (fB == null) {
                HybridUbcFlow hybridUbcFlow = new HybridUbcFlow(str);
                hybridUbcFlow.a(HybridUbcFlow.ExtensionType.CALLBACK_ON_SUBMIT, this.aDv);
                com.baidu.swan.apps.an.c.a<HybridUbcFlow> aVar = this.aDu.get(str);
                if (aVar != null) {
                    aVar.D(hybridUbcFlow);
                }
                this.aDt.put(str, hybridUbcFlow);
                fB = hybridUbcFlow;
            }
        }
        return fB;
    }

    public a b(String str, com.baidu.swan.apps.an.c.a<HybridUbcFlow> aVar) {
        synchronized (this.aDu) {
            this.aDu.put(str, aVar);
        }
        return this;
    }

    public a fA(String str) {
        synchronized (this.aDt) {
            this.aDt.remove(str);
        }
        return this;
    }

    public HybridUbcFlow fB(String str) {
        HybridUbcFlow hybridUbcFlow;
        synchronized (this.aDt) {
            hybridUbcFlow = this.aDt.get(str);
        }
        return hybridUbcFlow;
    }
}
