package com.baidu.adp.lib.cache;

import java.util.LinkedList;
/* loaded from: classes.dex */
class j implements g {
    private final int maxSize;
    private LinkedList<m<?>> sR;

    public j(int i) {
        this.maxSize = i;
    }

    @Override // com.baidu.adp.lib.cache.f
    public int gh() {
        return this.maxSize;
    }

    @Override // com.baidu.adp.lib.cache.g
    public void gj() {
        this.sR = new LinkedList<>();
    }

    @Override // com.baidu.adp.lib.cache.g
    public String d(m<?> mVar) {
        String str;
        long j;
        int i;
        String str2 = null;
        if (mVar.sX < System.currentTimeMillis()) {
            return mVar.sT;
        }
        this.sR.add(mVar);
        if (this.sR.size() > gh()) {
            long j2 = 0;
            int i2 = 0;
            int i3 = -1;
            while (i2 < this.sR.size()) {
                m<?> mVar2 = this.sR.get(i2);
                if (i3 == -1 || mVar2.sW < j2) {
                    String str3 = mVar2.sT;
                    long j3 = mVar2.sW;
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
            this.sR.remove(i3);
            return str2;
        }
        return null;
    }

    @Override // com.baidu.adp.lib.cache.g
    public void gk() {
        this.sR.clear();
        this.sR = null;
    }

    @Override // com.baidu.adp.lib.cache.f
    public boolean gi() {
        return true;
    }
}
