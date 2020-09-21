package com.baidu.swan.apps.performance;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public class b {
    private final Map<String, Map<String, HybridUbcFlow>> cIe = new HashMap();
    private final Map<String, com.baidu.swan.apps.ap.e.b<HybridUbcFlow>> cIf = new HashMap();
    private final com.baidu.swan.apps.ap.e.b<HybridUbcFlow> cIg = new com.baidu.swan.apps.ap.e.b<HybridUbcFlow>() { // from class: com.baidu.swan.apps.performance.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.ap.e.b
        /* renamed from: a */
        public void J(HybridUbcFlow hybridUbcFlow) {
            b.this.pr(hybridUbcFlow.name);
        }
    };

    private HybridUbcFlow pp(String str) {
        HybridUbcFlow hybridUbcFlow = new HybridUbcFlow(str);
        hybridUbcFlow.d("callback_on_submit", this.cIg);
        com.baidu.swan.apps.ap.e.b<HybridUbcFlow> bVar = this.cIf.get(str);
        if (bVar != null) {
            bVar.J(hybridUbcFlow);
        }
        return hybridUbcFlow;
    }

    public synchronized HybridUbcFlow pq(String str) {
        return bT(str, "default");
    }

    public synchronized HybridUbcFlow bT(String str, String str2) {
        HybridUbcFlow hybridUbcFlow;
        synchronized (this.cIe) {
            Map<String, HybridUbcFlow> map = this.cIe.get(str);
            if (map == null) {
                HashMap hashMap = new HashMap();
                hybridUbcFlow = pp(str);
                hashMap.put(str2, hybridUbcFlow);
                this.cIe.put(str, hashMap);
            } else {
                HybridUbcFlow hybridUbcFlow2 = map.get(str2);
                if (hybridUbcFlow2 == null) {
                    hybridUbcFlow2 = pp(str);
                    map.put(str2, hybridUbcFlow2);
                }
                hybridUbcFlow = hybridUbcFlow2;
            }
        }
        return hybridUbcFlow;
    }

    public b c(String str, com.baidu.swan.apps.ap.e.b<HybridUbcFlow> bVar) {
        synchronized (this.cIf) {
            this.cIf.put(str, bVar);
        }
        return this;
    }

    public b pr(String str) {
        if (TextUtils.equals(str, "startup")) {
            e.awy();
        }
        synchronized (this.cIe) {
            this.cIe.remove(str);
        }
        return this;
    }

    public b bU(String str, String str2) {
        synchronized (this.cIe) {
            Map<String, HybridUbcFlow> map = this.cIe.get(str);
            if (map != null) {
                map.remove(str2);
            }
        }
        return this;
    }

    public HybridUbcFlow ps(String str) {
        return bV(str, "default");
    }

    public HybridUbcFlow bV(String str, String str2) {
        HybridUbcFlow hybridUbcFlow;
        synchronized (this.cIe) {
            Map<String, HybridUbcFlow> map = this.cIe.get(str);
            hybridUbcFlow = map == null ? null : map.get(str2);
        }
        return hybridUbcFlow;
    }
}
