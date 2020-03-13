package com.baidu.swan.apps.performance.b;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes11.dex */
public class c implements e {
    private List<Long> bHT = new ArrayList();
    private long mEndTime = -1;

    @Override // com.baidu.swan.apps.performance.b.e
    public void setStart(long j) {
        if (this.bHT != null) {
            this.bHT.add(Long.valueOf(j));
        }
    }

    @Override // com.baidu.swan.apps.performance.b.e
    public void setEnd(long j) {
        this.mEndTime = j;
    }

    @Override // com.baidu.swan.apps.performance.b.e
    public long aaa() {
        if (this.bHT == null || this.bHT.size() <= 0 || this.mEndTime < 0) {
            return -1L;
        }
        return this.mEndTime - ((Long) Collections.min(this.bHT)).longValue();
    }

    @Override // com.baidu.swan.apps.performance.b.e
    public String getType() {
        return "PageUpdateRender";
    }
}
