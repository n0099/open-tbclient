package com.baidu.ar.statistic;

import java.util.List;
/* loaded from: classes3.dex */
final class m extends i {
    private long uZ;

    public m(d dVar, int i, e eVar, boolean z) {
        super(dVar, i, eVar, z);
        this.uZ = 0L;
    }

    @Override // com.baidu.ar.statistic.i
    public List<List<a>> eJ() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.uZ < 1000) {
            return null;
        }
        this.uZ = currentTimeMillis;
        List<List<a>> eJ = super.eJ();
        return eJ.size() > 1 ? eJ.subList(0, 1) : eJ;
    }
}
