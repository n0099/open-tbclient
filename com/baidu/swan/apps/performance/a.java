package com.baidu.swan.apps.performance;

import com.baidu.swan.apps.performance.HybridUbcFlow;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public class a {
    private final Map<String, HybridUbcFlow> aZH = new HashMap();
    private final Map<String, com.baidu.swan.apps.an.d.a<HybridUbcFlow>> aZI = new HashMap();
    private final com.baidu.swan.apps.an.d.a<HybridUbcFlow> aZJ = new com.baidu.swan.apps.an.d.a<HybridUbcFlow>() { // from class: com.baidu.swan.apps.performance.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.an.d.a
        /* renamed from: a */
        public void B(HybridUbcFlow hybridUbcFlow) {
            a.this.gA(hybridUbcFlow.name);
        }
    };

    public synchronized HybridUbcFlow gz(String str) {
        HybridUbcFlow gB;
        synchronized (this.aZH) {
            gB = gB(str);
            if (gB == null) {
                HybridUbcFlow hybridUbcFlow = new HybridUbcFlow(str);
                hybridUbcFlow.a(HybridUbcFlow.ExtensionType.CALLBACK_ON_SUBMIT, this.aZJ);
                com.baidu.swan.apps.an.d.a<HybridUbcFlow> aVar = this.aZI.get(str);
                if (aVar != null) {
                    aVar.B(hybridUbcFlow);
                }
                this.aZH.put(str, hybridUbcFlow);
                gB = hybridUbcFlow;
            }
        }
        return gB;
    }

    public a b(String str, com.baidu.swan.apps.an.d.a<HybridUbcFlow> aVar) {
        synchronized (this.aZI) {
            this.aZI.put(str, aVar);
        }
        return this;
    }

    public a gA(String str) {
        synchronized (this.aZH) {
            this.aZH.remove(str);
        }
        return this;
    }

    public HybridUbcFlow gB(String str) {
        HybridUbcFlow hybridUbcFlow;
        synchronized (this.aZH) {
            hybridUbcFlow = this.aZH.get(str);
        }
        return hybridUbcFlow;
    }
}
