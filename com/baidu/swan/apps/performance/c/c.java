package com.baidu.swan.apps.performance.c;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes2.dex */
public class c implements e {
    private List<Long> aHs = new ArrayList();
    private long aHr = -1;

    @Override // com.baidu.swan.apps.performance.c.e
    public void N(long j) {
        if (this.aHs != null) {
            this.aHs.add(Long.valueOf(j));
        }
    }

    @Override // com.baidu.swan.apps.performance.c.e
    public void O(long j) {
        this.aHr = j;
    }

    @Override // com.baidu.swan.apps.performance.c.e
    public long IV() {
        if (this.aHs == null || this.aHs.size() <= 0 || this.aHr < 0) {
            return -1L;
        }
        return this.aHr - ((Long) Collections.min(this.aHs)).longValue();
    }

    @Override // com.baidu.swan.apps.performance.c.e
    public String getType() {
        return "PageUpdateRender";
    }
}
