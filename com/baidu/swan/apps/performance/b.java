package com.baidu.swan.apps.performance;

import android.text.TextUtils;
import com.baidu.searchbox.config.DefaultSharedPrefsWrapper;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes8.dex */
public class b {
    private final Map<String, Map<String, HybridUbcFlow>> drS = new HashMap();
    private final Map<String, com.baidu.swan.apps.ao.e.b<HybridUbcFlow>> drT = new HashMap();
    private final com.baidu.swan.apps.ao.e.b<HybridUbcFlow> drU = new com.baidu.swan.apps.ao.e.b<HybridUbcFlow>() { // from class: com.baidu.swan.apps.performance.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.ao.e.b
        /* renamed from: a */
        public void N(HybridUbcFlow hybridUbcFlow) {
            b.this.qs(hybridUbcFlow.name);
        }
    };

    private HybridUbcFlow qq(String str) {
        HybridUbcFlow hybridUbcFlow = new HybridUbcFlow(str);
        hybridUbcFlow.d("callback_on_submit", this.drU);
        com.baidu.swan.apps.ao.e.b<HybridUbcFlow> bVar = this.drT.get(str);
        if (bVar != null) {
            bVar.N(hybridUbcFlow);
        }
        return hybridUbcFlow;
    }

    public synchronized HybridUbcFlow qr(String str) {
        return cd(str, DefaultSharedPrefsWrapper.SP_FILE_DEFAULT);
    }

    public synchronized HybridUbcFlow cd(String str, String str2) {
        HybridUbcFlow hybridUbcFlow;
        synchronized (this.drS) {
            Map<String, HybridUbcFlow> map = this.drS.get(str);
            if (map == null) {
                HashMap hashMap = new HashMap();
                hybridUbcFlow = qq(str);
                hashMap.put(str2, hybridUbcFlow);
                this.drS.put(str, hashMap);
            } else {
                HybridUbcFlow hybridUbcFlow2 = map.get(str2);
                if (hybridUbcFlow2 == null) {
                    hybridUbcFlow2 = qq(str);
                    map.put(str2, hybridUbcFlow2);
                }
                hybridUbcFlow = hybridUbcFlow2;
            }
        }
        return hybridUbcFlow;
    }

    public b c(String str, com.baidu.swan.apps.ao.e.b<HybridUbcFlow> bVar) {
        synchronized (this.drT) {
            this.drT.put(str, bVar);
        }
        return this;
    }

    public b qs(String str) {
        if (TextUtils.equals(str, "startup")) {
            e.aEb();
        }
        synchronized (this.drS) {
            this.drS.remove(str);
        }
        return this;
    }

    public b ce(String str, String str2) {
        synchronized (this.drS) {
            Map<String, HybridUbcFlow> map = this.drS.get(str);
            if (map != null) {
                map.remove(str2);
            }
        }
        return this;
    }

    public HybridUbcFlow qt(String str) {
        return cf(str, DefaultSharedPrefsWrapper.SP_FILE_DEFAULT);
    }

    public HybridUbcFlow cf(String str, String str2) {
        HybridUbcFlow hybridUbcFlow;
        synchronized (this.drS) {
            Map<String, HybridUbcFlow> map = this.drS.get(str);
            hybridUbcFlow = map == null ? null : map.get(str2);
        }
        return hybridUbcFlow;
    }
}
