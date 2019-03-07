package com.baidu.swan.apps.performance;

import com.baidu.swan.apps.performance.HybridUbcFlow;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public class a {
    private final Map<String, HybridUbcFlow> aDp = new HashMap();
    private final Map<String, com.baidu.swan.apps.an.c.a<HybridUbcFlow>> aDq = new HashMap();
    private final com.baidu.swan.apps.an.c.a<HybridUbcFlow> aDr = new com.baidu.swan.apps.an.c.a<HybridUbcFlow>() { // from class: com.baidu.swan.apps.performance.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.an.c.a
        /* renamed from: a */
        public void D(HybridUbcFlow hybridUbcFlow) {
            a.this.fz(hybridUbcFlow.name);
        }
    };

    public synchronized HybridUbcFlow fy(String str) {
        HybridUbcFlow fA;
        synchronized (this.aDp) {
            fA = fA(str);
            if (fA == null) {
                HybridUbcFlow hybridUbcFlow = new HybridUbcFlow(str);
                hybridUbcFlow.a(HybridUbcFlow.ExtensionType.CALLBACK_ON_SUBMIT, this.aDr);
                com.baidu.swan.apps.an.c.a<HybridUbcFlow> aVar = this.aDq.get(str);
                if (aVar != null) {
                    aVar.D(hybridUbcFlow);
                }
                this.aDp.put(str, hybridUbcFlow);
                fA = hybridUbcFlow;
            }
        }
        return fA;
    }

    public a b(String str, com.baidu.swan.apps.an.c.a<HybridUbcFlow> aVar) {
        synchronized (this.aDq) {
            this.aDq.put(str, aVar);
        }
        return this;
    }

    public a fz(String str) {
        synchronized (this.aDp) {
            this.aDp.remove(str);
        }
        return this;
    }

    public HybridUbcFlow fA(String str) {
        HybridUbcFlow hybridUbcFlow;
        synchronized (this.aDp) {
            hybridUbcFlow = this.aDp.get(str);
        }
        return hybridUbcFlow;
    }
}
