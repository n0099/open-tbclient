package com.baidu.swan.apps.performance;

import com.baidu.swan.apps.performance.HybridUbcFlow;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public class a {
    private final Map<String, HybridUbcFlow> aFU = new HashMap();
    private final Map<String, com.baidu.swan.apps.an.d.a<HybridUbcFlow>> aFV = new HashMap();
    private final com.baidu.swan.apps.an.d.a<HybridUbcFlow> aFW = new com.baidu.swan.apps.an.d.a<HybridUbcFlow>() { // from class: com.baidu.swan.apps.performance.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.an.d.a
        /* renamed from: a */
        public void D(HybridUbcFlow hybridUbcFlow) {
            a.this.fT(hybridUbcFlow.name);
        }
    };

    public synchronized HybridUbcFlow fS(String str) {
        HybridUbcFlow fU;
        synchronized (this.aFU) {
            fU = fU(str);
            if (fU == null) {
                HybridUbcFlow hybridUbcFlow = new HybridUbcFlow(str);
                hybridUbcFlow.a(HybridUbcFlow.ExtensionType.CALLBACK_ON_SUBMIT, this.aFW);
                com.baidu.swan.apps.an.d.a<HybridUbcFlow> aVar = this.aFV.get(str);
                if (aVar != null) {
                    aVar.D(hybridUbcFlow);
                }
                this.aFU.put(str, hybridUbcFlow);
                fU = hybridUbcFlow;
            }
        }
        return fU;
    }

    public a b(String str, com.baidu.swan.apps.an.d.a<HybridUbcFlow> aVar) {
        synchronized (this.aFV) {
            this.aFV.put(str, aVar);
        }
        return this;
    }

    public a fT(String str) {
        synchronized (this.aFU) {
            this.aFU.remove(str);
        }
        return this;
    }

    public HybridUbcFlow fU(String str) {
        HybridUbcFlow hybridUbcFlow;
        synchronized (this.aFU) {
            hybridUbcFlow = this.aFU.get(str);
        }
        return hybridUbcFlow;
    }
}
