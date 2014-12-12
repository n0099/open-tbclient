package com.baidu.adp.lib.cache;

import java.util.LinkedList;
/* loaded from: classes.dex */
class j implements g {
    private LinkedList<m<?>> hu;
    private final int maxSize;

    public j(int i) {
        this.maxSize = i;
    }

    @Override // com.baidu.adp.lib.cache.f
    public int cK() {
        return this.maxSize;
    }

    @Override // com.baidu.adp.lib.cache.g
    public void cM() {
        this.hu = new LinkedList<>();
    }

    @Override // com.baidu.adp.lib.cache.g
    public String d(m<?> mVar) {
        String str;
        long j;
        int i;
        String str2 = null;
        if (mVar.hA < System.currentTimeMillis()) {
            return mVar.hw;
        }
        this.hu.add(mVar);
        if (this.hu.size() > cK()) {
            long j2 = 0;
            int i2 = 0;
            int i3 = -1;
            while (i2 < this.hu.size()) {
                m<?> mVar2 = this.hu.get(i2);
                if (i3 == -1 || mVar2.hz < j2) {
                    String str3 = mVar2.hw;
                    long j3 = mVar2.hz;
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
            this.hu.remove(i3);
            return str2;
        }
        return null;
    }

    @Override // com.baidu.adp.lib.cache.g
    public void cN() {
        this.hu.clear();
        this.hu = null;
    }

    @Override // com.baidu.adp.lib.cache.f
    public boolean cL() {
        return true;
    }
}
