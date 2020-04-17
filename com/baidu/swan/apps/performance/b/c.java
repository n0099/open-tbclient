package com.baidu.swan.apps.performance.b;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes11.dex */
public class c implements e {
    private List<Long> cgN = new ArrayList();
    private long mEndTime = -1;

    @Override // com.baidu.swan.apps.performance.b.e
    public void setStart(long j) {
        if (this.cgN != null) {
            this.cgN.add(Long.valueOf(j));
        }
    }

    @Override // com.baidu.swan.apps.performance.b.e
    public void setEnd(long j) {
        this.mEndTime = j;
    }

    @Override // com.baidu.swan.apps.performance.b.e
    public long aii() {
        if (this.cgN == null || this.cgN.size() <= 0 || this.mEndTime < 0) {
            return -1L;
        }
        return this.mEndTime - ((Long) Collections.min(this.cgN)).longValue();
    }

    @Override // com.baidu.swan.apps.performance.b.e
    public String getType() {
        return "PageUpdateRender";
    }
}
