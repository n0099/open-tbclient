package com.baidu.swan.apps.performance;

import android.text.TextUtils;
import com.baidu.searchbox.config.DefaultSharedPrefsWrapper;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes8.dex */
public class b {
    private final Map<String, Map<String, HybridUbcFlow>> doe = new HashMap();
    private final Map<String, com.baidu.swan.apps.ao.e.b<HybridUbcFlow>> dof = new HashMap();
    private final com.baidu.swan.apps.ao.e.b<HybridUbcFlow> dog = new com.baidu.swan.apps.ao.e.b<HybridUbcFlow>() { // from class: com.baidu.swan.apps.performance.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.ao.e.b
        /* renamed from: a */
        public void L(HybridUbcFlow hybridUbcFlow) {
            b.this.pT(hybridUbcFlow.name);
        }
    };

    private HybridUbcFlow pR(String str) {
        HybridUbcFlow hybridUbcFlow = new HybridUbcFlow(str);
        hybridUbcFlow.d("callback_on_submit", this.dog);
        com.baidu.swan.apps.ao.e.b<HybridUbcFlow> bVar = this.dof.get(str);
        if (bVar != null) {
            bVar.L(hybridUbcFlow);
        }
        return hybridUbcFlow;
    }

    public synchronized HybridUbcFlow pS(String str) {
        return cj(str, DefaultSharedPrefsWrapper.SP_FILE_DEFAULT);
    }

    public synchronized HybridUbcFlow cj(String str, String str2) {
        HybridUbcFlow hybridUbcFlow;
        synchronized (this.doe) {
            Map<String, HybridUbcFlow> map = this.doe.get(str);
            if (map == null) {
                HashMap hashMap = new HashMap();
                hybridUbcFlow = pR(str);
                hashMap.put(str2, hybridUbcFlow);
                this.doe.put(str, hashMap);
            } else {
                HybridUbcFlow hybridUbcFlow2 = map.get(str2);
                if (hybridUbcFlow2 == null) {
                    hybridUbcFlow2 = pR(str);
                    map.put(str2, hybridUbcFlow2);
                }
                hybridUbcFlow = hybridUbcFlow2;
            }
        }
        return hybridUbcFlow;
    }

    public b c(String str, com.baidu.swan.apps.ao.e.b<HybridUbcFlow> bVar) {
        synchronized (this.dof) {
            this.dof.put(str, bVar);
        }
        return this;
    }

    public b pT(String str) {
        if (TextUtils.equals(str, "startup")) {
            e.aDD();
        }
        synchronized (this.doe) {
            this.doe.remove(str);
        }
        return this;
    }

    public b ck(String str, String str2) {
        synchronized (this.doe) {
            Map<String, HybridUbcFlow> map = this.doe.get(str);
            if (map != null) {
                map.remove(str2);
            }
        }
        return this;
    }

    public HybridUbcFlow pU(String str) {
        return cl(str, DefaultSharedPrefsWrapper.SP_FILE_DEFAULT);
    }

    public HybridUbcFlow cl(String str, String str2) {
        HybridUbcFlow hybridUbcFlow;
        synchronized (this.doe) {
            Map<String, HybridUbcFlow> map = this.doe.get(str);
            hybridUbcFlow = map == null ? null : map.get(str2);
        }
        return hybridUbcFlow;
    }
}
