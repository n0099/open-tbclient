package com.baidu.adp.lib.cache;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
class k implements h {
    private HashMap<String, Long> ft = new HashMap<>();
    private final int maxSize;

    public k(int i) {
        this.maxSize = i;
    }

    @Override // com.baidu.adp.lib.cache.f
    public int cj() {
        return this.maxSize;
    }

    @Override // com.baidu.adp.lib.cache.f
    public boolean ck() {
        return true;
    }

    public String D(String str) {
        String str2;
        if (!this.ft.containsKey(str) && this.ft.size() >= this.maxSize) {
            synchronized (this) {
                long j = -1;
                str2 = null;
                for (Map.Entry<String, Long> entry : this.ft.entrySet()) {
                    long longValue = entry.getValue().longValue();
                    if (j == -1 || j > longValue) {
                        j = longValue;
                        str2 = entry.getKey();
                    }
                }
                if (str2 != null) {
                    this.ft.remove(str2);
                }
            }
            return str2;
        }
        return null;
    }

    @Override // com.baidu.adp.lib.cache.h
    public String e(m<?> mVar) {
        String D = D(mVar.fu);
        synchronized (this) {
            this.ft.put(mVar.fu, Long.valueOf(mVar.fx));
        }
        return D;
    }

    @Override // com.baidu.adp.lib.cache.h
    public void cn() {
    }

    @Override // com.baidu.adp.lib.cache.h
    public String f(m<?> mVar) {
        return mVar.fy < System.currentTimeMillis() ? mVar.fu : e(mVar);
    }

    @Override // com.baidu.adp.lib.cache.h
    public void co() {
    }

    @Override // com.baidu.adp.lib.cache.h
    public void release() {
        synchronized (this) {
            this.ft.clear();
        }
    }
}
