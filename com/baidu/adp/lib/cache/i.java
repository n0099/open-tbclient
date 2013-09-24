package com.baidu.adp.lib.cache;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
class i implements f {

    /* renamed from: a  reason: collision with root package name */
    private final int f383a;
    private HashMap<String, Long> b = new HashMap<>();

    public i(int i) {
        this.f383a = i;
    }

    @Override // com.baidu.adp.lib.cache.d
    public int a() {
        return this.f383a;
    }

    @Override // com.baidu.adp.lib.cache.d
    public boolean b() {
        return true;
    }

    public String a(String str) {
        String str2;
        if (!this.b.containsKey(str) && this.b.size() >= this.f383a) {
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

    @Override // com.baidu.adp.lib.cache.f
    public String a(k<?> kVar) {
        String a2 = a(kVar.f384a);
        synchronized (this) {
            this.b.put(kVar.f384a, Long.valueOf(kVar.e));
        }
        return a2;
    }

    @Override // com.baidu.adp.lib.cache.f
    public void c() {
    }

    @Override // com.baidu.adp.lib.cache.f
    public String b(k<?> kVar) {
        return kVar.f < System.currentTimeMillis() ? kVar.f384a : a(kVar);
    }

    @Override // com.baidu.adp.lib.cache.f
    public void d() {
    }
}
