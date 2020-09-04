package com.baidu.swan.apps.performance;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes8.dex */
public class b {
    private final Map<String, Map<String, HybridUbcFlow>> cGe = new HashMap();
    private final Map<String, com.baidu.swan.apps.ap.e.b<HybridUbcFlow>> cGf = new HashMap();
    private final com.baidu.swan.apps.ap.e.b<HybridUbcFlow> cGg = new com.baidu.swan.apps.ap.e.b<HybridUbcFlow>() { // from class: com.baidu.swan.apps.performance.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.ap.e.b
        /* renamed from: a */
        public void I(HybridUbcFlow hybridUbcFlow) {
            b.this.oY(hybridUbcFlow.name);
        }
    };

    private HybridUbcFlow oW(String str) {
        HybridUbcFlow hybridUbcFlow = new HybridUbcFlow(str);
        hybridUbcFlow.d("callback_on_submit", this.cGg);
        com.baidu.swan.apps.ap.e.b<HybridUbcFlow> bVar = this.cGf.get(str);
        if (bVar != null) {
            bVar.I(hybridUbcFlow);
        }
        return hybridUbcFlow;
    }

    public synchronized HybridUbcFlow oX(String str) {
        return bT(str, "default");
    }

    public synchronized HybridUbcFlow bT(String str, String str2) {
        HybridUbcFlow hybridUbcFlow;
        synchronized (this.cGe) {
            Map<String, HybridUbcFlow> map = this.cGe.get(str);
            if (map == null) {
                HashMap hashMap = new HashMap();
                hybridUbcFlow = oW(str);
                hashMap.put(str2, hybridUbcFlow);
                this.cGe.put(str, hashMap);
            } else {
                HybridUbcFlow hybridUbcFlow2 = map.get(str2);
                if (hybridUbcFlow2 == null) {
                    hybridUbcFlow2 = oW(str);
                    map.put(str2, hybridUbcFlow2);
                }
                hybridUbcFlow = hybridUbcFlow2;
            }
        }
        return hybridUbcFlow;
    }

    public b c(String str, com.baidu.swan.apps.ap.e.b<HybridUbcFlow> bVar) {
        synchronized (this.cGf) {
            this.cGf.put(str, bVar);
        }
        return this;
    }

    public b oY(String str) {
        if (TextUtils.equals(str, "startup")) {
            e.avP();
        }
        synchronized (this.cGe) {
            this.cGe.remove(str);
        }
        return this;
    }

    public b bU(String str, String str2) {
        synchronized (this.cGe) {
            Map<String, HybridUbcFlow> map = this.cGe.get(str);
            if (map != null) {
                map.remove(str2);
            }
        }
        return this;
    }

    public HybridUbcFlow oZ(String str) {
        return bV(str, "default");
    }

    public HybridUbcFlow bV(String str, String str2) {
        HybridUbcFlow hybridUbcFlow;
        synchronized (this.cGe) {
            Map<String, HybridUbcFlow> map = this.cGe.get(str);
            hybridUbcFlow = map == null ? null : map.get(str2);
        }
        return hybridUbcFlow;
    }
}
