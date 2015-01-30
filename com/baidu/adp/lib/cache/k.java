package com.baidu.adp.lib.cache;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
class k implements h {
    private HashMap<String, Long> hx = new HashMap<>();
    private final int maxSize;

    public k(int i) {
        this.maxSize = i;
    }

    @Override // com.baidu.adp.lib.cache.f
    public int cI() {
        return this.maxSize;
    }

    @Override // com.baidu.adp.lib.cache.f
    public boolean cJ() {
        return true;
    }

    public String R(String str) {
        String str2;
        if (!this.hx.containsKey(str) && this.hx.size() >= this.maxSize) {
            synchronized (this) {
                long j = -1;
                str2 = null;
                for (Map.Entry<String, Long> entry : this.hx.entrySet()) {
                    long longValue = entry.getValue().longValue();
                    if (j == -1 || j > longValue) {
                        j = longValue;
                        str2 = entry.getKey();
                    }
                }
                if (str2 != null) {
                    this.hx.remove(str2);
                }
            }
            return str2;
        }
        return null;
    }

    @Override // com.baidu.adp.lib.cache.h
    public String e(m<?> mVar) {
        String R = R(mVar.hy);
        synchronized (this) {
            this.hx.put(mVar.hy, Long.valueOf(mVar.hB));
        }
        return R;
    }

    @Override // com.baidu.adp.lib.cache.h
    public void cM() {
    }

    @Override // com.baidu.adp.lib.cache.h
    public String f(m<?> mVar) {
        return mVar.hC < System.currentTimeMillis() ? mVar.hy : e(mVar);
    }

    @Override // com.baidu.adp.lib.cache.h
    public void cN() {
    }

    @Override // com.baidu.adp.lib.cache.h
    public void release() {
        synchronized (this) {
            this.hx.clear();
        }
    }
}
