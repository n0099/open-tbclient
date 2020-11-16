package com.baidu.swan.apps.performance;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes7.dex */
public class b {
    private final Map<String, Map<String, HybridUbcFlow>> dgT = new HashMap();
    private final Map<String, com.baidu.swan.apps.ap.e.b<HybridUbcFlow>> dgU = new HashMap();
    private final com.baidu.swan.apps.ap.e.b<HybridUbcFlow> dgV = new com.baidu.swan.apps.ap.e.b<HybridUbcFlow>() { // from class: com.baidu.swan.apps.performance.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.ap.e.b
        /* renamed from: a */
        public void M(HybridUbcFlow hybridUbcFlow) {
            b.this.qE(hybridUbcFlow.name);
        }
    };

    private HybridUbcFlow qC(String str) {
        HybridUbcFlow hybridUbcFlow = new HybridUbcFlow(str);
        hybridUbcFlow.d("callback_on_submit", this.dgV);
        com.baidu.swan.apps.ap.e.b<HybridUbcFlow> bVar = this.dgU.get(str);
        if (bVar != null) {
            bVar.M(hybridUbcFlow);
        }
        return hybridUbcFlow;
    }

    public synchronized HybridUbcFlow qD(String str) {
        return ce(str, "default");
    }

    public synchronized HybridUbcFlow ce(String str, String str2) {
        HybridUbcFlow hybridUbcFlow;
        synchronized (this.dgT) {
            Map<String, HybridUbcFlow> map = this.dgT.get(str);
            if (map == null) {
                HashMap hashMap = new HashMap();
                hybridUbcFlow = qC(str);
                hashMap.put(str2, hybridUbcFlow);
                this.dgT.put(str, hashMap);
            } else {
                HybridUbcFlow hybridUbcFlow2 = map.get(str2);
                if (hybridUbcFlow2 == null) {
                    hybridUbcFlow2 = qC(str);
                    map.put(str2, hybridUbcFlow2);
                }
                hybridUbcFlow = hybridUbcFlow2;
            }
        }
        return hybridUbcFlow;
    }

    public b c(String str, com.baidu.swan.apps.ap.e.b<HybridUbcFlow> bVar) {
        synchronized (this.dgU) {
            this.dgU.put(str, bVar);
        }
        return this;
    }

    public b qE(String str) {
        if (TextUtils.equals(str, "startup")) {
            e.aCV();
        }
        synchronized (this.dgT) {
            this.dgT.remove(str);
        }
        return this;
    }

    public b cf(String str, String str2) {
        synchronized (this.dgT) {
            Map<String, HybridUbcFlow> map = this.dgT.get(str);
            if (map != null) {
                map.remove(str2);
            }
        }
        return this;
    }

    public HybridUbcFlow qF(String str) {
        return cg(str, "default");
    }

    public HybridUbcFlow cg(String str, String str2) {
        HybridUbcFlow hybridUbcFlow;
        synchronized (this.dgT) {
            Map<String, HybridUbcFlow> map = this.dgT.get(str);
            hybridUbcFlow = map == null ? null : map.get(str2);
        }
        return hybridUbcFlow;
    }
}
