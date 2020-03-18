package com.baidu.swan.apps.performance;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes11.dex */
public class b {
    private final Map<String, Map<String, HybridUbcFlow>> bHy = new HashMap();
    private final Map<String, com.baidu.swan.apps.as.d.b<HybridUbcFlow>> bHz = new HashMap();
    private final com.baidu.swan.apps.as.d.b<HybridUbcFlow> bHA = new com.baidu.swan.apps.as.d.b<HybridUbcFlow>() { // from class: com.baidu.swan.apps.performance.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.as.d.b
        /* renamed from: a */
        public void D(HybridUbcFlow hybridUbcFlow) {
            b.this.jP(hybridUbcFlow.name);
        }
    };

    private HybridUbcFlow jN(String str) {
        HybridUbcFlow hybridUbcFlow = new HybridUbcFlow(str);
        hybridUbcFlow.c("callback_on_submit", this.bHA);
        com.baidu.swan.apps.as.d.b<HybridUbcFlow> bVar = this.bHz.get(str);
        if (bVar != null) {
            bVar.D(hybridUbcFlow);
        }
        return hybridUbcFlow;
    }

    public synchronized HybridUbcFlow jO(String str) {
        return aX(str, "default");
    }

    public synchronized HybridUbcFlow aX(String str, String str2) {
        HybridUbcFlow hybridUbcFlow;
        synchronized (this.bHy) {
            Map<String, HybridUbcFlow> map = this.bHy.get(str);
            if (map == null) {
                HashMap hashMap = new HashMap();
                hybridUbcFlow = jN(str);
                hashMap.put(str2, hybridUbcFlow);
                this.bHy.put(str, hashMap);
            } else {
                HybridUbcFlow hybridUbcFlow2 = map.get(str2);
                if (hybridUbcFlow2 == null) {
                    hybridUbcFlow2 = jN(str);
                    map.put(str2, hybridUbcFlow2);
                }
                hybridUbcFlow = hybridUbcFlow2;
            }
        }
        return hybridUbcFlow;
    }

    public b b(String str, com.baidu.swan.apps.as.d.b<HybridUbcFlow> bVar) {
        synchronized (this.bHz) {
            this.bHz.put(str, bVar);
        }
        return this;
    }

    public b jP(String str) {
        synchronized (this.bHy) {
            this.bHy.remove(str);
        }
        return this;
    }

    public b aY(String str, String str2) {
        synchronized (this.bHy) {
            Map<String, HybridUbcFlow> map = this.bHy.get(str);
            if (map != null) {
                map.remove(str2);
            }
        }
        return this;
    }

    public HybridUbcFlow jQ(String str) {
        return aZ(str, "default");
    }

    public HybridUbcFlow aZ(String str, String str2) {
        HybridUbcFlow hybridUbcFlow;
        synchronized (this.bHy) {
            Map<String, HybridUbcFlow> map = this.bHy.get(str);
            hybridUbcFlow = map == null ? null : map.get(str2);
        }
        return hybridUbcFlow;
    }
}
