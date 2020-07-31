package com.baidu.swan.apps.performance;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes7.dex */
public class b {
    private final Map<String, Map<String, HybridUbcFlow>> cyg = new HashMap();
    private final Map<String, com.baidu.swan.apps.aq.e.b<HybridUbcFlow>> cyh = new HashMap();
    private final com.baidu.swan.apps.aq.e.b<HybridUbcFlow> cyi = new com.baidu.swan.apps.aq.e.b<HybridUbcFlow>() { // from class: com.baidu.swan.apps.performance.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.aq.e.b
        /* renamed from: b */
        public void H(HybridUbcFlow hybridUbcFlow) {
            b.this.mY(hybridUbcFlow.name);
        }
    };

    private HybridUbcFlow mW(String str) {
        HybridUbcFlow hybridUbcFlow = new HybridUbcFlow(str);
        hybridUbcFlow.c("callback_on_submit", this.cyi);
        com.baidu.swan.apps.aq.e.b<HybridUbcFlow> bVar = this.cyh.get(str);
        if (bVar != null) {
            bVar.H(hybridUbcFlow);
        }
        return hybridUbcFlow;
    }

    public synchronized HybridUbcFlow mX(String str) {
        return bE(str, "default");
    }

    public synchronized HybridUbcFlow bE(String str, String str2) {
        HybridUbcFlow hybridUbcFlow;
        synchronized (this.cyg) {
            Map<String, HybridUbcFlow> map = this.cyg.get(str);
            if (map == null) {
                HashMap hashMap = new HashMap();
                hybridUbcFlow = mW(str);
                hashMap.put(str2, hybridUbcFlow);
                this.cyg.put(str, hashMap);
            } else {
                HybridUbcFlow hybridUbcFlow2 = map.get(str2);
                if (hybridUbcFlow2 == null) {
                    hybridUbcFlow2 = mW(str);
                    map.put(str2, hybridUbcFlow2);
                }
                hybridUbcFlow = hybridUbcFlow2;
            }
        }
        return hybridUbcFlow;
    }

    public b b(String str, com.baidu.swan.apps.aq.e.b<HybridUbcFlow> bVar) {
        synchronized (this.cyh) {
            this.cyh.put(str, bVar);
        }
        return this;
    }

    public b mY(String str) {
        if (TextUtils.equals(str, "startup")) {
            e.anU();
        }
        synchronized (this.cyg) {
            this.cyg.remove(str);
        }
        return this;
    }

    public b bF(String str, String str2) {
        synchronized (this.cyg) {
            Map<String, HybridUbcFlow> map = this.cyg.get(str);
            if (map != null) {
                map.remove(str2);
            }
        }
        return this;
    }

    public HybridUbcFlow mZ(String str) {
        return bG(str, "default");
    }

    public HybridUbcFlow bG(String str, String str2) {
        HybridUbcFlow hybridUbcFlow;
        synchronized (this.cyg) {
            Map<String, HybridUbcFlow> map = this.cyg.get(str);
            hybridUbcFlow = map == null ? null : map.get(str2);
        }
        return hybridUbcFlow;
    }
}
