package com.baidu.swan.apps.performance.c;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes2.dex */
public class c implements e {
    private List<Long> baG = new ArrayList();
    private long baF = -1;

    @Override // com.baidu.swan.apps.performance.c.e
    public void ag(long j) {
        if (this.baG != null) {
            this.baG.add(Long.valueOf(j));
        }
    }

    @Override // com.baidu.swan.apps.performance.c.e
    public void ah(long j) {
        this.baF = j;
    }

    @Override // com.baidu.swan.apps.performance.c.e
    public long NP() {
        if (this.baG == null || this.baG.size() <= 0 || this.baF < 0) {
            return -1L;
        }
        return this.baF - ((Long) Collections.min(this.baG)).longValue();
    }

    @Override // com.baidu.swan.apps.performance.c.e
    public String getType() {
        return "PageUpdateRender";
    }
}
