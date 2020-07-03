package com.baidu.swan.apps.performance;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes11.dex */
public class b {
    private final Map<String, Map<String, HybridUbcFlow>> cvT = new HashMap();
    private final Map<String, com.baidu.swan.apps.aq.e.b<HybridUbcFlow>> cvU = new HashMap();
    private final com.baidu.swan.apps.aq.e.b<HybridUbcFlow> cvV = new com.baidu.swan.apps.aq.e.b<HybridUbcFlow>() { // from class: com.baidu.swan.apps.performance.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.aq.e.b
        /* renamed from: a */
        public void H(HybridUbcFlow hybridUbcFlow) {
            b.this.my(hybridUbcFlow.name);
        }
    };

    private HybridUbcFlow mw(String str) {
        HybridUbcFlow hybridUbcFlow = new HybridUbcFlow(str);
        hybridUbcFlow.c("callback_on_submit", this.cvV);
        com.baidu.swan.apps.aq.e.b<HybridUbcFlow> bVar = this.cvU.get(str);
        if (bVar != null) {
            bVar.H(hybridUbcFlow);
        }
        return hybridUbcFlow;
    }

    public synchronized HybridUbcFlow mx(String str) {
        return bC(str, "default");
    }

    public synchronized HybridUbcFlow bC(String str, String str2) {
        HybridUbcFlow hybridUbcFlow;
        synchronized (this.cvT) {
            Map<String, HybridUbcFlow> map = this.cvT.get(str);
            if (map == null) {
                HashMap hashMap = new HashMap();
                hybridUbcFlow = mw(str);
                hashMap.put(str2, hybridUbcFlow);
                this.cvT.put(str, hashMap);
            } else {
                HybridUbcFlow hybridUbcFlow2 = map.get(str2);
                if (hybridUbcFlow2 == null) {
                    hybridUbcFlow2 = mw(str);
                    map.put(str2, hybridUbcFlow2);
                }
                hybridUbcFlow = hybridUbcFlow2;
            }
        }
        return hybridUbcFlow;
    }

    public b b(String str, com.baidu.swan.apps.aq.e.b<HybridUbcFlow> bVar) {
        synchronized (this.cvU) {
            this.cvU.put(str, bVar);
        }
        return this;
    }

    public b my(String str) {
        if (TextUtils.equals(str, "startup")) {
            c.amA();
        }
        synchronized (this.cvT) {
            this.cvT.remove(str);
        }
        return this;
    }

    public b bD(String str, String str2) {
        synchronized (this.cvT) {
            Map<String, HybridUbcFlow> map = this.cvT.get(str);
            if (map != null) {
                map.remove(str2);
            }
        }
        return this;
    }

    public HybridUbcFlow mz(String str) {
        return bE(str, "default");
    }

    public HybridUbcFlow bE(String str, String str2) {
        HybridUbcFlow hybridUbcFlow;
        synchronized (this.cvT) {
            Map<String, HybridUbcFlow> map = this.cvT.get(str);
            hybridUbcFlow = map == null ? null : map.get(str2);
        }
        return hybridUbcFlow;
    }
}
