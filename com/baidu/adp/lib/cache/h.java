package com.baidu.adp.lib.cache;

import java.util.LinkedList;
/* loaded from: classes.dex */
class h implements e {

    /* renamed from: a  reason: collision with root package name */
    private final int f382a;
    private LinkedList<k<?>> b;

    public h(int i) {
        this.f382a = i;
    }

    @Override // com.baidu.adp.lib.cache.d
    public int a() {
        return this.f382a;
    }

    @Override // com.baidu.adp.lib.cache.e
    public void c() {
        this.b = new LinkedList<>();
    }

    @Override // com.baidu.adp.lib.cache.e
    public String a(k<?> kVar) {
        String str;
        long j;
        int i;
        String str2 = null;
        if (kVar.f < System.currentTimeMillis()) {
            return kVar.f384a;
        }
        this.b.add(kVar);
        if (this.b.size() > a()) {
            long j2 = 0;
            int i2 = 0;
            int i3 = -1;
            while (i2 < this.b.size()) {
                k<?> kVar2 = this.b.get(i2);
                if (i3 == -1 || kVar2.e < j2) {
                    String str3 = kVar2.f384a;
                    long j3 = kVar2.e;
                    str = str3;
                    j = j3;
                    i = i2;
                } else {
                    str = str2;
                    j = j2;
                    i = i3;
                }
                i2++;
                i3 = i;
                j2 = j;
                str2 = str;
            }
            this.b.remove(i3);
            return str2;
        }
        return null;
    }

    @Override // com.baidu.adp.lib.cache.e
    public void d() {
        this.b.clear();
        this.b = null;
    }

    @Override // com.baidu.adp.lib.cache.d
    public boolean b() {
        return true;
    }
}
