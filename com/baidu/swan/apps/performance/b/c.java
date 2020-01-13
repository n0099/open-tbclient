package com.baidu.swan.apps.performance.b;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes10.dex */
public class c implements e {
    private List<Long> bDM = new ArrayList();
    private long bDL = -1;

    @Override // com.baidu.swan.apps.performance.b.e
    public void setStart(long j) {
        if (this.bDM != null) {
            this.bDM.add(Long.valueOf(j));
        }
    }

    @Override // com.baidu.swan.apps.performance.b.e
    public void setEnd(long j) {
        this.bDL = j;
    }

    @Override // com.baidu.swan.apps.performance.b.e
    public long XK() {
        if (this.bDM == null || this.bDM.size() <= 0 || this.bDL < 0) {
            return -1L;
        }
        return this.bDL - ((Long) Collections.min(this.bDM)).longValue();
    }

    @Override // com.baidu.swan.apps.performance.b.e
    public String getType() {
        return "PageUpdateRender";
    }
}
