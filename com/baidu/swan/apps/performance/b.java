package com.baidu.swan.apps.performance;

import com.baidu.searchbox.config.DefaultSharedPrefsWrapper;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes9.dex */
public class b {
    private final Map<String, Map<String, HybridUbcFlow>> bCu = new HashMap();
    private final Map<String, com.baidu.swan.apps.as.d.b<HybridUbcFlow>> bCv = new HashMap();
    private final com.baidu.swan.apps.as.d.b<HybridUbcFlow> bCw = new com.baidu.swan.apps.as.d.b<HybridUbcFlow>() { // from class: com.baidu.swan.apps.performance.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.as.d.b
        /* renamed from: a */
        public void B(HybridUbcFlow hybridUbcFlow) {
            b.this.jy(hybridUbcFlow.name);
        }
    };

    private HybridUbcFlow jw(String str) {
        HybridUbcFlow hybridUbcFlow = new HybridUbcFlow(str);
        hybridUbcFlow.c("callback_on_submit", this.bCw);
        com.baidu.swan.apps.as.d.b<HybridUbcFlow> bVar = this.bCv.get(str);
        if (bVar != null) {
            bVar.B(hybridUbcFlow);
        }
        return hybridUbcFlow;
    }

    public synchronized HybridUbcFlow jx(String str) {
        return aO(str, DefaultSharedPrefsWrapper.SP_FILE_DEFAULT);
    }

    public synchronized HybridUbcFlow aO(String str, String str2) {
        HybridUbcFlow hybridUbcFlow;
        synchronized (this.bCu) {
            Map<String, HybridUbcFlow> map = this.bCu.get(str);
            if (map == null) {
                HashMap hashMap = new HashMap();
                hybridUbcFlow = jw(str);
                hashMap.put(str2, hybridUbcFlow);
                this.bCu.put(str, hashMap);
            } else {
                HybridUbcFlow hybridUbcFlow2 = map.get(str2);
                if (hybridUbcFlow2 == null) {
                    hybridUbcFlow2 = jw(str);
                    map.put(str2, hybridUbcFlow2);
                }
                hybridUbcFlow = hybridUbcFlow2;
            }
        }
        return hybridUbcFlow;
    }

    public b b(String str, com.baidu.swan.apps.as.d.b<HybridUbcFlow> bVar) {
        synchronized (this.bCv) {
            this.bCv.put(str, bVar);
        }
        return this;
    }

    public b jy(String str) {
        synchronized (this.bCu) {
            this.bCu.remove(str);
        }
        return this;
    }

    public b aP(String str, String str2) {
        synchronized (this.bCu) {
            Map<String, HybridUbcFlow> map = this.bCu.get(str);
            if (map != null) {
                map.remove(str2);
            }
        }
        return this;
    }

    public HybridUbcFlow jz(String str) {
        return aQ(str, DefaultSharedPrefsWrapper.SP_FILE_DEFAULT);
    }

    public HybridUbcFlow aQ(String str, String str2) {
        HybridUbcFlow hybridUbcFlow;
        synchronized (this.bCu) {
            Map<String, HybridUbcFlow> map = this.bCu.get(str);
            hybridUbcFlow = map == null ? null : map.get(str2);
        }
        return hybridUbcFlow;
    }
}
