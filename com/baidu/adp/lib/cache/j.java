package com.baidu.adp.lib.cache;

import java.util.LinkedList;
/* loaded from: classes.dex */
final class j implements g {
    private final int a;
    private LinkedList<m<?>> b;

    public j(int i) {
        this.a = i;
    }

    @Override // com.baidu.adp.lib.cache.f
    public final int a() {
        return this.a;
    }

    @Override // com.baidu.adp.lib.cache.g
    public final void c() {
        this.b = new LinkedList<>();
    }

    @Override // com.baidu.adp.lib.cache.g
    public final String a(m<?> mVar) {
        String str;
        long j;
        int i;
        String str2 = null;
        if (mVar.f < System.currentTimeMillis()) {
            return mVar.a;
        }
        this.b.add(mVar);
        if (this.b.size() > this.a) {
            long j2 = 0;
            int i2 = 0;
            int i3 = -1;
            while (i2 < this.b.size()) {
                m<?> mVar2 = this.b.get(i2);
                if (i3 == -1 || mVar2.e < j2) {
                    str = mVar2.a;
                    j = mVar2.e;
                    i = i2;
                } else {
                    j = j2;
                    str = str2;
                    i = i3;
                }
                i2++;
                i3 = i;
                str2 = str;
                j2 = j;
            }
            this.b.remove(i3);
            return str2;
        }
        return null;
    }

    @Override // com.baidu.adp.lib.cache.g
    public final void d() {
        this.b.clear();
        this.b = null;
    }

    @Override // com.baidu.adp.lib.cache.f
    public final boolean b() {
        return true;
    }
}
