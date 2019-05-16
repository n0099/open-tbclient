package com.baidu.swan.apps.performance;

import com.baidu.swan.apps.performance.HybridUbcFlow;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public class a {
    private final Map<String, HybridUbcFlow> aFm = new HashMap();
    private final Map<String, com.baidu.swan.apps.an.d.a<HybridUbcFlow>> aFn = new HashMap();
    private final com.baidu.swan.apps.an.d.a<HybridUbcFlow> aFo = new com.baidu.swan.apps.an.d.a<HybridUbcFlow>() { // from class: com.baidu.swan.apps.performance.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.an.d.a
        /* renamed from: a */
        public void D(HybridUbcFlow hybridUbcFlow) {
            a.this.fP(hybridUbcFlow.name);
        }
    };

    public synchronized HybridUbcFlow fO(String str) {
        HybridUbcFlow fQ;
        synchronized (this.aFm) {
            fQ = fQ(str);
            if (fQ == null) {
                HybridUbcFlow hybridUbcFlow = new HybridUbcFlow(str);
                hybridUbcFlow.a(HybridUbcFlow.ExtensionType.CALLBACK_ON_SUBMIT, this.aFo);
                com.baidu.swan.apps.an.d.a<HybridUbcFlow> aVar = this.aFn.get(str);
                if (aVar != null) {
                    aVar.D(hybridUbcFlow);
                }
                this.aFm.put(str, hybridUbcFlow);
                fQ = hybridUbcFlow;
            }
        }
        return fQ;
    }

    public a b(String str, com.baidu.swan.apps.an.d.a<HybridUbcFlow> aVar) {
        synchronized (this.aFn) {
            this.aFn.put(str, aVar);
        }
        return this;
    }

    public a fP(String str) {
        synchronized (this.aFm) {
            this.aFm.remove(str);
        }
        return this;
    }

    public HybridUbcFlow fQ(String str) {
        HybridUbcFlow hybridUbcFlow;
        synchronized (this.aFm) {
            hybridUbcFlow = this.aFm.get(str);
        }
        return hybridUbcFlow;
    }
}
