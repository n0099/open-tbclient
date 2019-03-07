package com.baidu.swan.apps.performance.c;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes2.dex */
public class c implements e {
    private List<Long> aEp = new ArrayList();
    private long aEo = -1;

    @Override // com.baidu.swan.apps.performance.c.e
    public void B(long j) {
        if (this.aEp != null) {
            this.aEp.add(Long.valueOf(j));
        }
    }

    @Override // com.baidu.swan.apps.performance.c.e
    public void C(long j) {
        this.aEo = j;
    }

    @Override // com.baidu.swan.apps.performance.c.e
    public long FY() {
        if (this.aEp == null || this.aEp.size() <= 0 || this.aEo < 0) {
            return -1L;
        }
        return this.aEo - ((Long) Collections.min(this.aEp)).longValue();
    }

    @Override // com.baidu.swan.apps.performance.c.e
    public String getType() {
        return "PageUpdateRender";
    }
}
