package com.baidu.swan.apps.performance.c;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes2.dex */
public class c implements e {
    private List<Long> aEu = new ArrayList();
    private long aEt = -1;

    @Override // com.baidu.swan.apps.performance.c.e
    public void B(long j) {
        if (this.aEu != null) {
            this.aEu.add(Long.valueOf(j));
        }
    }

    @Override // com.baidu.swan.apps.performance.c.e
    public void C(long j) {
        this.aEt = j;
    }

    @Override // com.baidu.swan.apps.performance.c.e
    public long FW() {
        if (this.aEu == null || this.aEu.size() <= 0 || this.aEt < 0) {
            return -1L;
        }
        return this.aEt - ((Long) Collections.min(this.aEu)).longValue();
    }

    @Override // com.baidu.swan.apps.performance.c.e
    public String getType() {
        return "PageUpdateRender";
    }
}
