package com.baidu.ar.statistic;

import java.util.List;
/* loaded from: classes11.dex */
final class m extends i {
    private long vz;

    public m(d dVar, int i, e eVar, boolean z) {
        super(dVar, i, eVar, z);
        this.vz = 0L;
    }

    @Override // com.baidu.ar.statistic.i
    public List<List<a>> eZ() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.vz < 1000) {
            return null;
        }
        this.vz = currentTimeMillis;
        List<List<a>> eZ = super.eZ();
        return eZ.size() > 1 ? eZ.subList(0, 1) : eZ;
    }
}
