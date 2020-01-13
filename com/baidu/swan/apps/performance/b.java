package com.baidu.swan.apps.performance;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes10.dex */
public class b {
    private final Map<String, Map<String, HybridUbcFlow>> bDf = new HashMap();
    private final Map<String, com.baidu.swan.apps.as.d.b<HybridUbcFlow>> bDg = new HashMap();
    private final com.baidu.swan.apps.as.d.b<HybridUbcFlow> bDh = new com.baidu.swan.apps.as.d.b<HybridUbcFlow>() { // from class: com.baidu.swan.apps.performance.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.as.d.b
        /* renamed from: a */
        public void B(HybridUbcFlow hybridUbcFlow) {
            b.this.jB(hybridUbcFlow.name);
        }
    };

    private HybridUbcFlow jz(String str) {
        HybridUbcFlow hybridUbcFlow = new HybridUbcFlow(str);
        hybridUbcFlow.c("callback_on_submit", this.bDh);
        com.baidu.swan.apps.as.d.b<HybridUbcFlow> bVar = this.bDg.get(str);
        if (bVar != null) {
            bVar.B(hybridUbcFlow);
        }
        return hybridUbcFlow;
    }

    public synchronized HybridUbcFlow jA(String str) {
        return aP(str, "default");
    }

    public synchronized HybridUbcFlow aP(String str, String str2) {
        HybridUbcFlow hybridUbcFlow;
        synchronized (this.bDf) {
            Map<String, HybridUbcFlow> map = this.bDf.get(str);
            if (map == null) {
                HashMap hashMap = new HashMap();
                hybridUbcFlow = jz(str);
                hashMap.put(str2, hybridUbcFlow);
                this.bDf.put(str, hashMap);
            } else {
                HybridUbcFlow hybridUbcFlow2 = map.get(str2);
                if (hybridUbcFlow2 == null) {
                    hybridUbcFlow2 = jz(str);
                    map.put(str2, hybridUbcFlow2);
                }
                hybridUbcFlow = hybridUbcFlow2;
            }
        }
        return hybridUbcFlow;
    }

    public b b(String str, com.baidu.swan.apps.as.d.b<HybridUbcFlow> bVar) {
        synchronized (this.bDg) {
            this.bDg.put(str, bVar);
        }
        return this;
    }

    public b jB(String str) {
        synchronized (this.bDf) {
            this.bDf.remove(str);
        }
        return this;
    }

    public b aQ(String str, String str2) {
        synchronized (this.bDf) {
            Map<String, HybridUbcFlow> map = this.bDf.get(str);
            if (map != null) {
                map.remove(str2);
            }
        }
        return this;
    }

    public HybridUbcFlow jC(String str) {
        return aR(str, "default");
    }

    public HybridUbcFlow aR(String str, String str2) {
        HybridUbcFlow hybridUbcFlow;
        synchronized (this.bDf) {
            Map<String, HybridUbcFlow> map = this.bDf.get(str);
            hybridUbcFlow = map == null ? null : map.get(str2);
        }
        return hybridUbcFlow;
    }
}
