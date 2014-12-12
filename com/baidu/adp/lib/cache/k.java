package com.baidu.adp.lib.cache;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
class k implements h {
    private HashMap<String, Long> hv = new HashMap<>();
    private final int maxSize;

    public k(int i) {
        this.maxSize = i;
    }

    @Override // com.baidu.adp.lib.cache.f
    public int cK() {
        return this.maxSize;
    }

    @Override // com.baidu.adp.lib.cache.f
    public boolean cL() {
        return true;
    }

    public String R(String str) {
        String str2;
        if (!this.hv.containsKey(str) && this.hv.size() >= this.maxSize) {
            synchronized (this) {
                long j = -1;
                str2 = null;
                for (Map.Entry<String, Long> entry : this.hv.entrySet()) {
                    long longValue = entry.getValue().longValue();
                    if (j == -1 || j > longValue) {
                        j = longValue;
                        str2 = entry.getKey();
                    }
                }
                if (str2 != null) {
                    this.hv.remove(str2);
                }
            }
            return str2;
        }
        return null;
    }

    @Override // com.baidu.adp.lib.cache.h
    public String e(m<?> mVar) {
        String R = R(mVar.hw);
        synchronized (this) {
            this.hv.put(mVar.hw, Long.valueOf(mVar.hz));
        }
        return R;
    }

    @Override // com.baidu.adp.lib.cache.h
    public void cO() {
    }

    @Override // com.baidu.adp.lib.cache.h
    public String f(m<?> mVar) {
        return mVar.hA < System.currentTimeMillis() ? mVar.hw : e(mVar);
    }

    @Override // com.baidu.adp.lib.cache.h
    public void cP() {
    }

    @Override // com.baidu.adp.lib.cache.h
    public void release() {
        synchronized (this) {
            this.hv.clear();
        }
    }
}
