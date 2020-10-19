package com.baidu.ar.statistic;

import java.util.List;
/* loaded from: classes14.dex */
final class m extends i {
    private long wc;

    public m(d dVar, int i, e eVar, boolean z) {
        super(dVar, i, eVar, z);
        this.wc = 0L;
    }

    @Override // com.baidu.ar.statistic.i
    public List<List<a>> gn() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.wc < 1000) {
            return null;
        }
        this.wc = currentTimeMillis;
        List<List<a>> gn = super.gn();
        return gn.size() > 1 ? gn.subList(0, 1) : gn;
    }
}
