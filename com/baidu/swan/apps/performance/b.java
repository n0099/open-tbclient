package com.baidu.swan.apps.performance;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes25.dex */
public class b {
    private final Map<String, Map<String, HybridUbcFlow>> dnU = new HashMap();
    private final Map<String, com.baidu.swan.apps.ap.e.b<HybridUbcFlow>> dnV = new HashMap();
    private final com.baidu.swan.apps.ap.e.b<HybridUbcFlow> dnW = new com.baidu.swan.apps.ap.e.b<HybridUbcFlow>() { // from class: com.baidu.swan.apps.performance.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.ap.e.b
        /* renamed from: a */
        public void M(HybridUbcFlow hybridUbcFlow) {
            b.this.rl(hybridUbcFlow.name);
        }
    };

    private HybridUbcFlow rj(String str) {
        HybridUbcFlow hybridUbcFlow = new HybridUbcFlow(str);
        hybridUbcFlow.d("callback_on_submit", this.dnW);
        com.baidu.swan.apps.ap.e.b<HybridUbcFlow> bVar = this.dnV.get(str);
        if (bVar != null) {
            bVar.M(hybridUbcFlow);
        }
        return hybridUbcFlow;
    }

    public synchronized HybridUbcFlow rk(String str) {
        return cl(str, "default");
    }

    public synchronized HybridUbcFlow cl(String str, String str2) {
        HybridUbcFlow hybridUbcFlow;
        synchronized (this.dnU) {
            Map<String, HybridUbcFlow> map = this.dnU.get(str);
            if (map == null) {
                HashMap hashMap = new HashMap();
                hybridUbcFlow = rj(str);
                hashMap.put(str2, hybridUbcFlow);
                this.dnU.put(str, hashMap);
            } else {
                HybridUbcFlow hybridUbcFlow2 = map.get(str2);
                if (hybridUbcFlow2 == null) {
                    hybridUbcFlow2 = rj(str);
                    map.put(str2, hybridUbcFlow2);
                }
                hybridUbcFlow = hybridUbcFlow2;
            }
        }
        return hybridUbcFlow;
    }

    public b c(String str, com.baidu.swan.apps.ap.e.b<HybridUbcFlow> bVar) {
        synchronized (this.dnV) {
            this.dnV.put(str, bVar);
        }
        return this;
    }

    public b rl(String str) {
        if (TextUtils.equals(str, "startup")) {
            e.aGd();
        }
        synchronized (this.dnU) {
            this.dnU.remove(str);
        }
        return this;
    }

    public b cm(String str, String str2) {
        synchronized (this.dnU) {
            Map<String, HybridUbcFlow> map = this.dnU.get(str);
            if (map != null) {
                map.remove(str2);
            }
        }
        return this;
    }

    public HybridUbcFlow rm(String str) {
        return cn(str, "default");
    }

    public HybridUbcFlow cn(String str, String str2) {
        HybridUbcFlow hybridUbcFlow;
        synchronized (this.dnU) {
            Map<String, HybridUbcFlow> map = this.dnU.get(str);
            hybridUbcFlow = map == null ? null : map.get(str2);
        }
        return hybridUbcFlow;
    }
}
