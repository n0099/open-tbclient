package com.baidu.swan.apps.performance;

import com.baidu.swan.apps.performance.HybridUbcFlow;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public class a {
    private final Map<String, HybridUbcFlow> aDu = new HashMap();
    private final Map<String, com.baidu.swan.apps.an.c.a<HybridUbcFlow>> aDv = new HashMap();
    private final com.baidu.swan.apps.an.c.a<HybridUbcFlow> aDw = new com.baidu.swan.apps.an.c.a<HybridUbcFlow>() { // from class: com.baidu.swan.apps.performance.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.an.c.a
        /* renamed from: a */
        public void D(HybridUbcFlow hybridUbcFlow) {
            a.this.fA(hybridUbcFlow.name);
        }
    };

    public synchronized HybridUbcFlow fz(String str) {
        HybridUbcFlow fB;
        synchronized (this.aDu) {
            fB = fB(str);
            if (fB == null) {
                HybridUbcFlow hybridUbcFlow = new HybridUbcFlow(str);
                hybridUbcFlow.a(HybridUbcFlow.ExtensionType.CALLBACK_ON_SUBMIT, this.aDw);
                com.baidu.swan.apps.an.c.a<HybridUbcFlow> aVar = this.aDv.get(str);
                if (aVar != null) {
                    aVar.D(hybridUbcFlow);
                }
                this.aDu.put(str, hybridUbcFlow);
                fB = hybridUbcFlow;
            }
        }
        return fB;
    }

    public a b(String str, com.baidu.swan.apps.an.c.a<HybridUbcFlow> aVar) {
        synchronized (this.aDv) {
            this.aDv.put(str, aVar);
        }
        return this;
    }

    public a fA(String str) {
        synchronized (this.aDu) {
            this.aDu.remove(str);
        }
        return this;
    }

    public HybridUbcFlow fB(String str) {
        HybridUbcFlow hybridUbcFlow;
        synchronized (this.aDu) {
            hybridUbcFlow = this.aDu.get(str);
        }
        return hybridUbcFlow;
    }
}
