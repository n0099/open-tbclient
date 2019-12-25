package com.baidu.swan.apps.performance.b;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes9.dex */
public class c implements e {
    private List<Long> bDb = new ArrayList();
    private long bDa = -1;

    @Override // com.baidu.swan.apps.performance.b.e
    public void setStart(long j) {
        if (this.bDb != null) {
            this.bDb.add(Long.valueOf(j));
        }
    }

    @Override // com.baidu.swan.apps.performance.b.e
    public void setEnd(long j) {
        this.bDa = j;
    }

    @Override // com.baidu.swan.apps.performance.b.e
    public long Xn() {
        if (this.bDb == null || this.bDb.size() <= 0 || this.bDa < 0) {
            return -1L;
        }
        return this.bDa - ((Long) Collections.min(this.bDb)).longValue();
    }

    @Override // com.baidu.swan.apps.performance.b.e
    public String getType() {
        return "PageUpdateRender";
    }
}
