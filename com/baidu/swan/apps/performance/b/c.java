package com.baidu.swan.apps.performance.b;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes11.dex */
public class c implements e {
    private List<Long> bHR = new ArrayList();
    private long mEndTime = -1;

    @Override // com.baidu.swan.apps.performance.b.e
    public void setStart(long j) {
        if (this.bHR != null) {
            this.bHR.add(Long.valueOf(j));
        }
    }

    @Override // com.baidu.swan.apps.performance.b.e
    public void setEnd(long j) {
        this.mEndTime = j;
    }

    @Override // com.baidu.swan.apps.performance.b.e
    public long ZY() {
        if (this.bHR == null || this.bHR.size() <= 0 || this.mEndTime < 0) {
            return -1L;
        }
        return this.mEndTime - ((Long) Collections.min(this.bHR)).longValue();
    }

    @Override // com.baidu.swan.apps.performance.b.e
    public String getType() {
        return "PageUpdateRender";
    }
}
