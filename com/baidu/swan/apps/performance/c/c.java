package com.baidu.swan.apps.performance.c;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes2.dex */
public class c implements e {
    private List<Long> aEq = new ArrayList();
    private long aEp = -1;

    @Override // com.baidu.swan.apps.performance.c.e
    public void B(long j) {
        if (this.aEq != null) {
            this.aEq.add(Long.valueOf(j));
        }
    }

    @Override // com.baidu.swan.apps.performance.c.e
    public void C(long j) {
        this.aEp = j;
    }

    @Override // com.baidu.swan.apps.performance.c.e
    public long FY() {
        if (this.aEq == null || this.aEq.size() <= 0 || this.aEp < 0) {
            return -1L;
        }
        return this.aEp - ((Long) Collections.min(this.aEq)).longValue();
    }

    @Override // com.baidu.swan.apps.performance.c.e
    public String getType() {
        return "PageUpdateRender";
    }
}
