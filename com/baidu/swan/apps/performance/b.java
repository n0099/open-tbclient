package com.baidu.swan.apps.performance;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes10.dex */
public class b {
    private final Map<String, Map<String, HybridUbcFlow>> dcG = new HashMap();
    private final Map<String, com.baidu.swan.apps.ap.e.b<HybridUbcFlow>> dcH = new HashMap();
    private final com.baidu.swan.apps.ap.e.b<HybridUbcFlow> dcI = new com.baidu.swan.apps.ap.e.b<HybridUbcFlow>() { // from class: com.baidu.swan.apps.performance.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.ap.e.b
        /* renamed from: a */
        public void M(HybridUbcFlow hybridUbcFlow) {
            b.this.qw(hybridUbcFlow.name);
        }
    };

    private HybridUbcFlow qu(String str) {
        HybridUbcFlow hybridUbcFlow = new HybridUbcFlow(str);
        hybridUbcFlow.d("callback_on_submit", this.dcI);
        com.baidu.swan.apps.ap.e.b<HybridUbcFlow> bVar = this.dcH.get(str);
        if (bVar != null) {
            bVar.M(hybridUbcFlow);
        }
        return hybridUbcFlow;
    }

    public synchronized HybridUbcFlow qv(String str) {
        return cf(str, "default");
    }

    public synchronized HybridUbcFlow cf(String str, String str2) {
        HybridUbcFlow hybridUbcFlow;
        synchronized (this.dcG) {
            Map<String, HybridUbcFlow> map = this.dcG.get(str);
            if (map == null) {
                HashMap hashMap = new HashMap();
                hybridUbcFlow = qu(str);
                hashMap.put(str2, hybridUbcFlow);
                this.dcG.put(str, hashMap);
            } else {
                HybridUbcFlow hybridUbcFlow2 = map.get(str2);
                if (hybridUbcFlow2 == null) {
                    hybridUbcFlow2 = qu(str);
                    map.put(str2, hybridUbcFlow2);
                }
                hybridUbcFlow = hybridUbcFlow2;
            }
        }
        return hybridUbcFlow;
    }

    public b c(String str, com.baidu.swan.apps.ap.e.b<HybridUbcFlow> bVar) {
        synchronized (this.dcH) {
            this.dcH.put(str, bVar);
        }
        return this;
    }

    public b qw(String str) {
        if (TextUtils.equals(str, "startup")) {
            e.aBd();
        }
        synchronized (this.dcG) {
            this.dcG.remove(str);
        }
        return this;
    }

    public b cg(String str, String str2) {
        synchronized (this.dcG) {
            Map<String, HybridUbcFlow> map = this.dcG.get(str);
            if (map != null) {
                map.remove(str2);
            }
        }
        return this;
    }

    public HybridUbcFlow qx(String str) {
        return ch(str, "default");
    }

    public HybridUbcFlow ch(String str, String str2) {
        HybridUbcFlow hybridUbcFlow;
        synchronized (this.dcG) {
            Map<String, HybridUbcFlow> map = this.dcG.get(str);
            hybridUbcFlow = map == null ? null : map.get(str2);
        }
        return hybridUbcFlow;
    }
}
