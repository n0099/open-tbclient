package com.baidu.adp.lib.cache;

import java.util.LinkedList;
/* loaded from: classes.dex */
class j implements g {
    private final int maxSize;
    private LinkedList<m<?>> td;

    public j(int i) {
        this.maxSize = i;
    }

    @Override // com.baidu.adp.lib.cache.f
    public int gl() {
        return this.maxSize;
    }

    @Override // com.baidu.adp.lib.cache.g
    public void gn() {
        this.td = new LinkedList<>();
    }

    @Override // com.baidu.adp.lib.cache.g
    public String d(m<?> mVar) {
        String str;
        long j;
        int i;
        String str2 = null;
        if (mVar.tj < System.currentTimeMillis()) {
            return mVar.tf;
        }
        this.td.add(mVar);
        if (this.td.size() > gl()) {
            long j2 = 0;
            int i2 = 0;
            int i3 = -1;
            while (i2 < this.td.size()) {
                m<?> mVar2 = this.td.get(i2);
                if (i3 == -1 || mVar2.ti < j2) {
                    String str3 = mVar2.tf;
                    long j3 = mVar2.ti;
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
            this.td.remove(i3);
            return str2;
        }
        return null;
    }

    @Override // com.baidu.adp.lib.cache.g
    public void go() {
        this.td.clear();
        this.td = null;
    }

    @Override // com.baidu.adp.lib.cache.f
    public boolean gm() {
        return true;
    }
}
