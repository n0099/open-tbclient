package com.baidu.adp.lib.cache;

import java.util.LinkedList;
/* loaded from: classes.dex */
class j implements g {
    private LinkedList<m<?>> hw;
    private final int maxSize;

    public j(int i) {
        this.maxSize = i;
    }

    @Override // com.baidu.adp.lib.cache.f
    public int cI() {
        return this.maxSize;
    }

    @Override // com.baidu.adp.lib.cache.g
    public void cK() {
        this.hw = new LinkedList<>();
    }

    @Override // com.baidu.adp.lib.cache.g
    public String d(m<?> mVar) {
        String str;
        long j;
        int i;
        String str2 = null;
        if (mVar.hC < System.currentTimeMillis()) {
            return mVar.hy;
        }
        this.hw.add(mVar);
        if (this.hw.size() > cI()) {
            long j2 = 0;
            int i2 = 0;
            int i3 = -1;
            while (i2 < this.hw.size()) {
                m<?> mVar2 = this.hw.get(i2);
                if (i3 == -1 || mVar2.hB < j2) {
                    String str3 = mVar2.hy;
                    long j3 = mVar2.hB;
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
            this.hw.remove(i3);
            return str2;
        }
        return null;
    }

    @Override // com.baidu.adp.lib.cache.g
    public void cL() {
        this.hw.clear();
        this.hw = null;
    }

    @Override // com.baidu.adp.lib.cache.f
    public boolean cJ() {
        return true;
    }
}
