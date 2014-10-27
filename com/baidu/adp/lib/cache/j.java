package com.baidu.adp.lib.cache;

import java.util.LinkedList;
/* loaded from: classes.dex */
class j implements g {
    private LinkedList<m<?>> fs;
    private final int maxSize;

    public j(int i) {
        this.maxSize = i;
    }

    @Override // com.baidu.adp.lib.cache.f
    public int cj() {
        return this.maxSize;
    }

    @Override // com.baidu.adp.lib.cache.g
    public void cl() {
        this.fs = new LinkedList<>();
    }

    @Override // com.baidu.adp.lib.cache.g
    public String d(m<?> mVar) {
        String str;
        long j;
        int i;
        String str2 = null;
        if (mVar.fy < System.currentTimeMillis()) {
            return mVar.fu;
        }
        this.fs.add(mVar);
        if (this.fs.size() > cj()) {
            long j2 = 0;
            int i2 = 0;
            int i3 = -1;
            while (i2 < this.fs.size()) {
                m<?> mVar2 = this.fs.get(i2);
                if (i3 == -1 || mVar2.fx < j2) {
                    String str3 = mVar2.fu;
                    long j3 = mVar2.fx;
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
            this.fs.remove(i3);
            return str2;
        }
        return null;
    }

    @Override // com.baidu.adp.lib.cache.g
    public void cm() {
        this.fs.clear();
        this.fs = null;
    }

    @Override // com.baidu.adp.lib.cache.f
    public boolean ck() {
        return true;
    }
}
