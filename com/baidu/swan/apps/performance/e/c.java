package com.baidu.swan.apps.performance.e;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes8.dex */
public class c implements e {
    private List<Long> cHE = new ArrayList();
    private long mEndTime = -1;

    @Override // com.baidu.swan.apps.performance.e.e
    public void setStart(long j) {
        if (this.cHE != null) {
            this.cHE.add(Long.valueOf(j));
        }
    }

    @Override // com.baidu.swan.apps.performance.e.e
    public void setEnd(long j) {
        this.mEndTime = j;
    }

    @Override // com.baidu.swan.apps.performance.e.e
    public long aij() {
        if (this.cHE == null || this.cHE.size() <= 0 || this.mEndTime < 0) {
            return -1L;
        }
        return this.mEndTime - ((Long) Collections.min(this.cHE)).longValue();
    }

    @Override // com.baidu.swan.apps.performance.e.e
    public String getType() {
        return "PageUpdateRender";
    }
}
