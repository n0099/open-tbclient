package com.baidu.adp.lib.cache;

import java.util.LinkedList;
/* loaded from: classes.dex */
class j implements g {

    /* renamed from: a  reason: collision with root package name */
    private final int f431a;
    private LinkedList<m<?>> b;

    public j(int i) {
        this.f431a = i;
    }

    @Override // com.baidu.adp.lib.cache.f
    public int a() {
        return this.f431a;
    }

    @Override // com.baidu.adp.lib.cache.g
    public void c() {
        this.b = new LinkedList<>();
    }

    @Override // com.baidu.adp.lib.cache.g
    public String a(m<?> mVar) {
        String str;
        long j;
        int i;
        String str2 = null;
        if (mVar.f < System.currentTimeMillis()) {
            return mVar.f433a;
        }
        this.b.add(mVar);
        if (this.b.size() > a()) {
            long j2 = 0;
            int i2 = 0;
            int i3 = -1;
            while (i2 < this.b.size()) {
                m<?> mVar2 = this.b.get(i2);
                if (i3 == -1 || mVar2.e < j2) {
                    String str3 = mVar2.f433a;
                    long j3 = mVar2.e;
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

    @Override // com.baidu.adp.lib.cache.g
    public void d() {
        this.b.clear();
        this.b = null;
    }

    @Override // com.baidu.adp.lib.cache.f
    public boolean b() {
        return true;
    }
}
