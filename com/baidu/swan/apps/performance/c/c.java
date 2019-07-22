package com.baidu.swan.apps.performance.c;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes2.dex */
public class c implements e {
    private List<Long> aGU = new ArrayList();
    private long aGT = -1;

    @Override // com.baidu.swan.apps.performance.c.e
    public void N(long j) {
        if (this.aGU != null) {
            this.aGU.add(Long.valueOf(j));
        }
    }

    @Override // com.baidu.swan.apps.performance.c.e
    public void O(long j) {
        this.aGT = j;
    }

    @Override // com.baidu.swan.apps.performance.c.e
    public long IR() {
        if (this.aGU == null || this.aGU.size() <= 0 || this.aGT < 0) {
            return -1L;
        }
        return this.aGT - ((Long) Collections.min(this.aGU)).longValue();
    }

    @Override // com.baidu.swan.apps.performance.c.e
    public String getType() {
        return "PageUpdateRender";
    }
}
