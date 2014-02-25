package com.baidu.adp.lib.cache;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
class k implements h {
    private final int a;
    private HashMap<String, Long> b = new HashMap<>();

    public k(int i) {
        this.a = i;
    }

    @Override // com.baidu.adp.lib.cache.f
    public int a() {
        return this.a;
    }

    @Override // com.baidu.adp.lib.cache.f
    public boolean b() {
        return true;
    }

    public String a(String str) {
        String str2;
        if (!this.b.containsKey(str) && this.b.size() >= this.a) {
            synchronized (this) {
                long j = -1;
                str2 = null;
                for (Map.Entry<String, Long> entry : this.b.entrySet()) {
                    long longValue = entry.getValue().longValue();
                    if (j == -1 || j > longValue) {
                        j = longValue;
                        str2 = entry.getKey();
                    }
                }
                if (str2 != null) {
                    this.b.remove(str2);
                }
            }
            return str2;
        }
        return null;
    }

    @Override // com.baidu.adp.lib.cache.h
    public String a(m<?> mVar) {
        String a = a(mVar.a);
        synchronized (this) {
            this.b.put(mVar.a, Long.valueOf(mVar.e));
        }
        return a;
    }

    @Override // com.baidu.adp.lib.cache.h
    public void c() {
    }

    @Override // com.baidu.adp.lib.cache.h
    public String b(m<?> mVar) {
        return mVar.f < System.currentTimeMillis() ? mVar.a : a(mVar);
    }

    @Override // com.baidu.adp.lib.cache.h
    public void d() {
    }

    @Override // com.baidu.adp.lib.cache.h
    public void e() {
        synchronized (this) {
            this.b.clear();
        }
    }
}
