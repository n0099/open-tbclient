package com.baidu.adp.lib.cache;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
class i implements f {

    /* renamed from: a  reason: collision with root package name */
    private final int f379a;
    private HashMap b = new HashMap();

    public i(int i) {
        this.f379a = i;
    }

    @Override // com.baidu.adp.lib.cache.d
    public int a() {
        return this.f379a;
    }

    @Override // com.baidu.adp.lib.cache.d
    public boolean b() {
        return true;
    }

    public String a(String str) {
        String str2;
        if (!this.b.containsKey(str) && this.b.size() >= this.f379a) {
            synchronized (this) {
                long j = -1;
                str2 = null;
                for (Map.Entry entry : this.b.entrySet()) {
                    long longValue = ((Long) entry.getValue()).longValue();
                    if (j == -1 || j > longValue) {
                        j = longValue;
                        str2 = (String) entry.getKey();
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
    public String a(k kVar) {
        String a2 = a(kVar.f380a);
        synchronized (this) {
            this.b.put(kVar.f380a, Long.valueOf(kVar.e));
        }
        return a2;
    }

    @Override // com.baidu.adp.lib.cache.f
    public void c() {
    }

    @Override // com.baidu.adp.lib.cache.f
    public String b(k kVar) {
        return kVar.f < System.currentTimeMillis() ? kVar.f380a : a(kVar);
    }

    @Override // com.baidu.adp.lib.cache.f
    public void d() {
    }
}
