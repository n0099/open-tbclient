package com.baidu.swan.apps.performance;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes11.dex */
public class b {
    private final Map<String, Map<String, HybridUbcFlow>> bHm = new HashMap();
    private final Map<String, com.baidu.swan.apps.as.d.b<HybridUbcFlow>> bHn = new HashMap();
    private final com.baidu.swan.apps.as.d.b<HybridUbcFlow> bHo = new com.baidu.swan.apps.as.d.b<HybridUbcFlow>() { // from class: com.baidu.swan.apps.performance.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.as.d.b
        /* renamed from: a */
        public void D(HybridUbcFlow hybridUbcFlow) {
            b.this.jQ(hybridUbcFlow.name);
        }
    };

    private HybridUbcFlow jO(String str) {
        HybridUbcFlow hybridUbcFlow = new HybridUbcFlow(str);
        hybridUbcFlow.c("callback_on_submit", this.bHo);
        com.baidu.swan.apps.as.d.b<HybridUbcFlow> bVar = this.bHn.get(str);
        if (bVar != null) {
            bVar.D(hybridUbcFlow);
        }
        return hybridUbcFlow;
    }

    public synchronized HybridUbcFlow jP(String str) {
        return aY(str, "default");
    }

    public synchronized HybridUbcFlow aY(String str, String str2) {
        HybridUbcFlow hybridUbcFlow;
        synchronized (this.bHm) {
            Map<String, HybridUbcFlow> map = this.bHm.get(str);
            if (map == null) {
                HashMap hashMap = new HashMap();
                hybridUbcFlow = jO(str);
                hashMap.put(str2, hybridUbcFlow);
                this.bHm.put(str, hashMap);
            } else {
                HybridUbcFlow hybridUbcFlow2 = map.get(str2);
                if (hybridUbcFlow2 == null) {
                    hybridUbcFlow2 = jO(str);
                    map.put(str2, hybridUbcFlow2);
                }
                hybridUbcFlow = hybridUbcFlow2;
            }
        }
        return hybridUbcFlow;
    }

    public b b(String str, com.baidu.swan.apps.as.d.b<HybridUbcFlow> bVar) {
        synchronized (this.bHn) {
            this.bHn.put(str, bVar);
        }
        return this;
    }

    public b jQ(String str) {
        synchronized (this.bHm) {
            this.bHm.remove(str);
        }
        return this;
    }

    public b aZ(String str, String str2) {
        synchronized (this.bHm) {
            Map<String, HybridUbcFlow> map = this.bHm.get(str);
            if (map != null) {
                map.remove(str2);
            }
        }
        return this;
    }

    public HybridUbcFlow jR(String str) {
        return ba(str, "default");
    }

    public HybridUbcFlow ba(String str, String str2) {
        HybridUbcFlow hybridUbcFlow;
        synchronized (this.bHm) {
            Map<String, HybridUbcFlow> map = this.bHm.get(str);
            hybridUbcFlow = map == null ? null : map.get(str2);
        }
        return hybridUbcFlow;
    }
}
