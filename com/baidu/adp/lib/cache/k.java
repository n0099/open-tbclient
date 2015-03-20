package com.baidu.adp.lib.cache;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
class k implements h {
    private final int maxSize;
    private HashMap<String, Long> sS = new HashMap<>();

    public k(int i) {
        this.maxSize = i;
    }

    @Override // com.baidu.adp.lib.cache.f
    public int gh() {
        return this.maxSize;
    }

    @Override // com.baidu.adp.lib.cache.f
    public boolean gi() {
        return true;
    }

    public String Y(String str) {
        String str2;
        if (!this.sS.containsKey(str) && this.sS.size() >= this.maxSize) {
            synchronized (this) {
                long j = -1;
                str2 = null;
                for (Map.Entry<String, Long> entry : this.sS.entrySet()) {
                    long longValue = entry.getValue().longValue();
                    if (j == -1 || j > longValue) {
                        j = longValue;
                        str2 = entry.getKey();
                    }
                }
                if (str2 != null) {
                    this.sS.remove(str2);
                }
            }
            return str2;
        }
        return null;
    }

    @Override // com.baidu.adp.lib.cache.h
    public String e(m<?> mVar) {
        String Y = Y(mVar.sT);
        synchronized (this) {
            this.sS.put(mVar.sT, Long.valueOf(mVar.sW));
        }
        return Y;
    }

    @Override // com.baidu.adp.lib.cache.h
    public void gl() {
    }

    @Override // com.baidu.adp.lib.cache.h
    public String f(m<?> mVar) {
        return mVar.sX < System.currentTimeMillis() ? mVar.sT : e(mVar);
    }

    @Override // com.baidu.adp.lib.cache.h
    public void gm() {
    }

    @Override // com.baidu.adp.lib.cache.h
    public void release() {
        synchronized (this) {
            this.sS.clear();
        }
    }
}
