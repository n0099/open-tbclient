package com.baidu.adp.lib.cache;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
class k implements h {

    /* renamed from: a  reason: collision with root package name */
    private final int f432a;
    private HashMap<String, Long> b = new HashMap<>();

    public k(int i) {
        this.f432a = i;
    }

    @Override // com.baidu.adp.lib.cache.f
    public int a() {
        return this.f432a;
    }

    @Override // com.baidu.adp.lib.cache.f
    public boolean b() {
        return true;
    }

    public String a(String str) {
        String key;
        long j;
        String str2 = null;
        if (!this.b.containsKey(str) && this.b.size() >= this.f432a) {
            synchronized (this) {
                long j2 = -1;
                for (Map.Entry<String, Long> entry : this.b.entrySet()) {
                    long longValue = entry.getValue().longValue();
                    if (j2 == -1 || j2 > longValue) {
                        key = entry.getKey();
                        j = longValue;
                    } else {
                        j = j2;
                        key = str2;
                    }
                    j2 = j;
                    str2 = key;
                }
                if (str2 != null) {
                    this.b.remove(str2);
                }
            }
        }
        return str2;
    }

    @Override // com.baidu.adp.lib.cache.h
    public String a(m<?> mVar) {
        String a2 = a(mVar.f433a);
        synchronized (this) {
            this.b.put(mVar.f433a, Long.valueOf(mVar.e));
        }
        return a2;
    }

    @Override // com.baidu.adp.lib.cache.h
    public void c() {
    }

    @Override // com.baidu.adp.lib.cache.h
    public String b(m<?> mVar) {
        return mVar.f < System.currentTimeMillis() ? mVar.f433a : a(mVar);
    }

    @Override // com.baidu.adp.lib.cache.h
    public void d() {
    }
}
