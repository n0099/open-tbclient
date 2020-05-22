package com.baidu.swan.apps.performance;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes11.dex */
public class b {
    private final Map<String, Map<String, HybridUbcFlow>> crf = new HashMap();
    private final Map<String, com.baidu.swan.apps.aq.e.b<HybridUbcFlow>> crg = new HashMap();
    private final com.baidu.swan.apps.aq.e.b<HybridUbcFlow> crh = new com.baidu.swan.apps.aq.e.b<HybridUbcFlow>() { // from class: com.baidu.swan.apps.performance.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.aq.e.b
        /* renamed from: a */
        public void H(HybridUbcFlow hybridUbcFlow) {
            b.this.mq(hybridUbcFlow.name);
        }
    };

    private HybridUbcFlow mo(String str) {
        HybridUbcFlow hybridUbcFlow = new HybridUbcFlow(str);
        hybridUbcFlow.c("callback_on_submit", this.crh);
        com.baidu.swan.apps.aq.e.b<HybridUbcFlow> bVar = this.crg.get(str);
        if (bVar != null) {
            bVar.H(hybridUbcFlow);
        }
        return hybridUbcFlow;
    }

    public synchronized HybridUbcFlow mp(String str) {
        return bA(str, "default");
    }

    public synchronized HybridUbcFlow bA(String str, String str2) {
        HybridUbcFlow hybridUbcFlow;
        synchronized (this.crf) {
            Map<String, HybridUbcFlow> map = this.crf.get(str);
            if (map == null) {
                HashMap hashMap = new HashMap();
                hybridUbcFlow = mo(str);
                hashMap.put(str2, hybridUbcFlow);
                this.crf.put(str, hashMap);
            } else {
                HybridUbcFlow hybridUbcFlow2 = map.get(str2);
                if (hybridUbcFlow2 == null) {
                    hybridUbcFlow2 = mo(str);
                    map.put(str2, hybridUbcFlow2);
                }
                hybridUbcFlow = hybridUbcFlow2;
            }
        }
        return hybridUbcFlow;
    }

    public b b(String str, com.baidu.swan.apps.aq.e.b<HybridUbcFlow> bVar) {
        synchronized (this.crg) {
            this.crg.put(str, bVar);
        }
        return this;
    }

    public b mq(String str) {
        if (TextUtils.equals(str, "startup")) {
            c.alu();
        }
        synchronized (this.crf) {
            this.crf.remove(str);
        }
        return this;
    }

    public b bB(String str, String str2) {
        synchronized (this.crf) {
            Map<String, HybridUbcFlow> map = this.crf.get(str);
            if (map != null) {
                map.remove(str2);
            }
        }
        return this;
    }

    public HybridUbcFlow mr(String str) {
        return bC(str, "default");
    }

    public HybridUbcFlow bC(String str, String str2) {
        HybridUbcFlow hybridUbcFlow;
        synchronized (this.crf) {
            Map<String, HybridUbcFlow> map = this.crf.get(str);
            hybridUbcFlow = map == null ? null : map.get(str2);
        }
        return hybridUbcFlow;
    }
}
