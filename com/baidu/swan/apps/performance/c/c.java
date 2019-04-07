package com.baidu.swan.apps.performance.c;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes2.dex */
public class c implements e {
    private List<Long> aEt = new ArrayList();
    private long aEs = -1;

    @Override // com.baidu.swan.apps.performance.c.e
    public void B(long j) {
        if (this.aEt != null) {
            this.aEt.add(Long.valueOf(j));
        }
    }

    @Override // com.baidu.swan.apps.performance.c.e
    public void C(long j) {
        this.aEs = j;
    }

    @Override // com.baidu.swan.apps.performance.c.e
    public long FW() {
        if (this.aEt == null || this.aEt.size() <= 0 || this.aEs < 0) {
            return -1L;
        }
        return this.aEs - ((Long) Collections.min(this.aEt)).longValue();
    }

    @Override // com.baidu.swan.apps.performance.c.e
    public String getType() {
        return "PageUpdateRender";
    }
}
