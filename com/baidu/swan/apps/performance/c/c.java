package com.baidu.swan.apps.performance.c;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes2.dex */
public class c implements e {
    private List<Long> aGm = new ArrayList();
    private long aGl = -1;

    @Override // com.baidu.swan.apps.performance.c.e
    public void N(long j) {
        if (this.aGm != null) {
            this.aGm.add(Long.valueOf(j));
        }
    }

    @Override // com.baidu.swan.apps.performance.c.e
    public void O(long j) {
        this.aGl = j;
    }

    @Override // com.baidu.swan.apps.performance.c.e
    public long Ie() {
        if (this.aGm == null || this.aGm.size() <= 0 || this.aGl < 0) {
            return -1L;
        }
        return this.aGl - ((Long) Collections.min(this.aGm)).longValue();
    }

    @Override // com.baidu.swan.apps.performance.c.e
    public String getType() {
        return "PageUpdateRender";
    }
}
