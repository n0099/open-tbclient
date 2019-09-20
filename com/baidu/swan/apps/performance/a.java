package com.baidu.swan.apps.performance;

import com.baidu.swan.apps.performance.HybridUbcFlow;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public class a {
    private final Map<String, HybridUbcFlow> aGs = new HashMap();
    private final Map<String, com.baidu.swan.apps.an.d.a<HybridUbcFlow>> aGt = new HashMap();
    private final com.baidu.swan.apps.an.d.a<HybridUbcFlow> aGu = new com.baidu.swan.apps.an.d.a<HybridUbcFlow>() { // from class: com.baidu.swan.apps.performance.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.an.d.a
        /* renamed from: a */
        public void D(HybridUbcFlow hybridUbcFlow) {
            a.this.fV(hybridUbcFlow.name);
        }
    };

    public synchronized HybridUbcFlow fU(String str) {
        HybridUbcFlow fW;
        synchronized (this.aGs) {
            fW = fW(str);
            if (fW == null) {
                HybridUbcFlow hybridUbcFlow = new HybridUbcFlow(str);
                hybridUbcFlow.a(HybridUbcFlow.ExtensionType.CALLBACK_ON_SUBMIT, this.aGu);
                com.baidu.swan.apps.an.d.a<HybridUbcFlow> aVar = this.aGt.get(str);
                if (aVar != null) {
                    aVar.D(hybridUbcFlow);
                }
                this.aGs.put(str, hybridUbcFlow);
                fW = hybridUbcFlow;
            }
        }
        return fW;
    }

    public a b(String str, com.baidu.swan.apps.an.d.a<HybridUbcFlow> aVar) {
        synchronized (this.aGt) {
            this.aGt.put(str, aVar);
        }
        return this;
    }

    public a fV(String str) {
        synchronized (this.aGs) {
            this.aGs.remove(str);
        }
        return this;
    }

    public HybridUbcFlow fW(String str) {
        HybridUbcFlow hybridUbcFlow;
        synchronized (this.aGs) {
            hybridUbcFlow = this.aGs.get(str);
        }
        return hybridUbcFlow;
    }
}
