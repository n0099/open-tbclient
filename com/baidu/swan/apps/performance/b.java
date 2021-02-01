package com.baidu.swan.apps.performance;

import android.text.TextUtils;
import com.baidu.searchbox.config.DefaultSharedPrefsWrapper;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes9.dex */
public class b {
    private final Map<String, Map<String, HybridUbcFlow>> dqq = new HashMap();
    private final Map<String, com.baidu.swan.apps.ao.e.b<HybridUbcFlow>> dqr = new HashMap();
    private final com.baidu.swan.apps.ao.e.b<HybridUbcFlow> dqs = new com.baidu.swan.apps.ao.e.b<HybridUbcFlow>() { // from class: com.baidu.swan.apps.performance.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.ao.e.b
        /* renamed from: a */
        public void L(HybridUbcFlow hybridUbcFlow) {
            b.this.ql(hybridUbcFlow.name);
        }
    };

    private HybridUbcFlow qj(String str) {
        HybridUbcFlow hybridUbcFlow = new HybridUbcFlow(str);
        hybridUbcFlow.d("callback_on_submit", this.dqs);
        com.baidu.swan.apps.ao.e.b<HybridUbcFlow> bVar = this.dqr.get(str);
        if (bVar != null) {
            bVar.L(hybridUbcFlow);
        }
        return hybridUbcFlow;
    }

    public synchronized HybridUbcFlow qk(String str) {
        return cd(str, DefaultSharedPrefsWrapper.SP_FILE_DEFAULT);
    }

    public synchronized HybridUbcFlow cd(String str, String str2) {
        HybridUbcFlow hybridUbcFlow;
        synchronized (this.dqq) {
            Map<String, HybridUbcFlow> map = this.dqq.get(str);
            if (map == null) {
                HashMap hashMap = new HashMap();
                hybridUbcFlow = qj(str);
                hashMap.put(str2, hybridUbcFlow);
                this.dqq.put(str, hashMap);
            } else {
                HybridUbcFlow hybridUbcFlow2 = map.get(str2);
                if (hybridUbcFlow2 == null) {
                    hybridUbcFlow2 = qj(str);
                    map.put(str2, hybridUbcFlow2);
                }
                hybridUbcFlow = hybridUbcFlow2;
            }
        }
        return hybridUbcFlow;
    }

    public b c(String str, com.baidu.swan.apps.ao.e.b<HybridUbcFlow> bVar) {
        synchronized (this.dqr) {
            this.dqr.put(str, bVar);
        }
        return this;
    }

    public b ql(String str) {
        if (TextUtils.equals(str, "startup")) {
            e.aDY();
        }
        synchronized (this.dqq) {
            this.dqq.remove(str);
        }
        return this;
    }

    public b ce(String str, String str2) {
        synchronized (this.dqq) {
            Map<String, HybridUbcFlow> map = this.dqq.get(str);
            if (map != null) {
                map.remove(str2);
            }
        }
        return this;
    }

    public HybridUbcFlow qm(String str) {
        return cf(str, DefaultSharedPrefsWrapper.SP_FILE_DEFAULT);
    }

    public HybridUbcFlow cf(String str, String str2) {
        HybridUbcFlow hybridUbcFlow;
        synchronized (this.dqq) {
            Map<String, HybridUbcFlow> map = this.dqq.get(str);
            hybridUbcFlow = map == null ? null : map.get(str2);
        }
        return hybridUbcFlow;
    }
}
