package com.baidu.adp.lib.cache;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
class k implements h {
    private final int maxSize;
    private HashMap<String, Long> te = new HashMap<>();

    public k(int i) {
        this.maxSize = i;
    }

    @Override // com.baidu.adp.lib.cache.f
    public int gl() {
        return this.maxSize;
    }

    @Override // com.baidu.adp.lib.cache.f
    public boolean gm() {
        return true;
    }

    public String aa(String str) {
        String str2;
        if (!this.te.containsKey(str) && this.te.size() >= this.maxSize) {
            synchronized (this) {
                long j = -1;
                str2 = null;
                for (Map.Entry<String, Long> entry : this.te.entrySet()) {
                    long longValue = entry.getValue().longValue();
                    if (j == -1 || j > longValue) {
                        j = longValue;
                        str2 = entry.getKey();
                    }
                }
                if (str2 != null) {
                    this.te.remove(str2);
                }
            }
            return str2;
        }
        return null;
    }

    @Override // com.baidu.adp.lib.cache.h
    public String e(m<?> mVar) {
        String aa = aa(mVar.tf);
        synchronized (this) {
            this.te.put(mVar.tf, Long.valueOf(mVar.ti));
        }
        return aa;
    }

    @Override // com.baidu.adp.lib.cache.h
    public void gp() {
    }

    @Override // com.baidu.adp.lib.cache.h
    public String f(m<?> mVar) {
        return mVar.tj < System.currentTimeMillis() ? mVar.tf : e(mVar);
    }

    @Override // com.baidu.adp.lib.cache.h
    public void gq() {
    }

    @Override // com.baidu.adp.lib.cache.h
    public void release() {
        synchronized (this) {
            this.te.clear();
        }
    }
}
