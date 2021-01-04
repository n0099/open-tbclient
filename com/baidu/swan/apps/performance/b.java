package com.baidu.swan.apps.performance;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes9.dex */
public class b {
    private final Map<String, Map<String, HybridUbcFlow>> dsU = new HashMap();
    private final Map<String, com.baidu.swan.apps.ao.e.b<HybridUbcFlow>> dsV = new HashMap();
    private final com.baidu.swan.apps.ao.e.b<HybridUbcFlow> dsW = new com.baidu.swan.apps.ao.e.b<HybridUbcFlow>() { // from class: com.baidu.swan.apps.performance.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.ao.e.b
        /* renamed from: a */
        public void L(HybridUbcFlow hybridUbcFlow) {
            b.this.re(hybridUbcFlow.name);
        }
    };

    private HybridUbcFlow rc(String str) {
        HybridUbcFlow hybridUbcFlow = new HybridUbcFlow(str);
        hybridUbcFlow.d("callback_on_submit", this.dsW);
        com.baidu.swan.apps.ao.e.b<HybridUbcFlow> bVar = this.dsV.get(str);
        if (bVar != null) {
            bVar.L(hybridUbcFlow);
        }
        return hybridUbcFlow;
    }

    public synchronized HybridUbcFlow rd(String str) {
        return ck(str, "default");
    }

    public synchronized HybridUbcFlow ck(String str, String str2) {
        HybridUbcFlow hybridUbcFlow;
        synchronized (this.dsU) {
            Map<String, HybridUbcFlow> map = this.dsU.get(str);
            if (map == null) {
                HashMap hashMap = new HashMap();
                hybridUbcFlow = rc(str);
                hashMap.put(str2, hybridUbcFlow);
                this.dsU.put(str, hashMap);
            } else {
                HybridUbcFlow hybridUbcFlow2 = map.get(str2);
                if (hybridUbcFlow2 == null) {
                    hybridUbcFlow2 = rc(str);
                    map.put(str2, hybridUbcFlow2);
                }
                hybridUbcFlow = hybridUbcFlow2;
            }
        }
        return hybridUbcFlow;
    }

    public b c(String str, com.baidu.swan.apps.ao.e.b<HybridUbcFlow> bVar) {
        synchronized (this.dsV) {
            this.dsV.put(str, bVar);
        }
        return this;
    }

    public b re(String str) {
        if (TextUtils.equals(str, "startup")) {
            e.aHw();
        }
        synchronized (this.dsU) {
            this.dsU.remove(str);
        }
        return this;
    }

    public b cl(String str, String str2) {
        synchronized (this.dsU) {
            Map<String, HybridUbcFlow> map = this.dsU.get(str);
            if (map != null) {
                map.remove(str2);
            }
        }
        return this;
    }

    public HybridUbcFlow rf(String str) {
        return cm(str, "default");
    }

    public HybridUbcFlow cm(String str, String str2) {
        HybridUbcFlow hybridUbcFlow;
        synchronized (this.dsU) {
            Map<String, HybridUbcFlow> map = this.dsU.get(str);
            hybridUbcFlow = map == null ? null : map.get(str2);
        }
        return hybridUbcFlow;
    }
}
