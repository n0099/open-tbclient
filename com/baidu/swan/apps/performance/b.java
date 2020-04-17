package com.baidu.swan.apps.performance;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes11.dex */
public class b {
    private final Map<String, Map<String, HybridUbcFlow>> cgh = new HashMap();
    private final Map<String, com.baidu.swan.apps.as.d.b<HybridUbcFlow>> cgi = new HashMap();
    private final com.baidu.swan.apps.as.d.b<HybridUbcFlow> cgj = new com.baidu.swan.apps.as.d.b<HybridUbcFlow>() { // from class: com.baidu.swan.apps.performance.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.as.d.b
        /* renamed from: a */
        public void E(HybridUbcFlow hybridUbcFlow) {
            b.this.lc(hybridUbcFlow.name);
        }
    };

    private HybridUbcFlow la(String str) {
        HybridUbcFlow hybridUbcFlow = new HybridUbcFlow(str);
        hybridUbcFlow.c("callback_on_submit", this.cgj);
        com.baidu.swan.apps.as.d.b<HybridUbcFlow> bVar = this.cgi.get(str);
        if (bVar != null) {
            bVar.E(hybridUbcFlow);
        }
        return hybridUbcFlow;
    }

    public synchronized HybridUbcFlow lb(String str) {
        return bh(str, "default");
    }

    public synchronized HybridUbcFlow bh(String str, String str2) {
        HybridUbcFlow hybridUbcFlow;
        synchronized (this.cgh) {
            Map<String, HybridUbcFlow> map = this.cgh.get(str);
            if (map == null) {
                HashMap hashMap = new HashMap();
                hybridUbcFlow = la(str);
                hashMap.put(str2, hybridUbcFlow);
                this.cgh.put(str, hashMap);
            } else {
                HybridUbcFlow hybridUbcFlow2 = map.get(str2);
                if (hybridUbcFlow2 == null) {
                    hybridUbcFlow2 = la(str);
                    map.put(str2, hybridUbcFlow2);
                }
                hybridUbcFlow = hybridUbcFlow2;
            }
        }
        return hybridUbcFlow;
    }

    public b b(String str, com.baidu.swan.apps.as.d.b<HybridUbcFlow> bVar) {
        synchronized (this.cgi) {
            this.cgi.put(str, bVar);
        }
        return this;
    }

    public b lc(String str) {
        synchronized (this.cgh) {
            this.cgh.remove(str);
        }
        return this;
    }

    public b bi(String str, String str2) {
        synchronized (this.cgh) {
            Map<String, HybridUbcFlow> map = this.cgh.get(str);
            if (map != null) {
                map.remove(str2);
            }
        }
        return this;
    }

    public HybridUbcFlow ld(String str) {
        return bj(str, "default");
    }

    public HybridUbcFlow bj(String str, String str2) {
        HybridUbcFlow hybridUbcFlow;
        synchronized (this.cgh) {
            Map<String, HybridUbcFlow> map = this.cgh.get(str);
            hybridUbcFlow = map == null ? null : map.get(str2);
        }
        return hybridUbcFlow;
    }
}
