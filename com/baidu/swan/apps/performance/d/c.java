package com.baidu.swan.apps.performance.d;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes11.dex */
public class c implements e {
    private List<Long> cwW = new ArrayList();
    private long mEndTime = -1;

    @Override // com.baidu.swan.apps.performance.d.e
    public void setStart(long j) {
        if (this.cwW != null) {
            this.cwW.add(Long.valueOf(j));
        }
    }

    @Override // com.baidu.swan.apps.performance.d.e
    public void setEnd(long j) {
        this.mEndTime = j;
    }

    @Override // com.baidu.swan.apps.performance.d.e
    public long amM() {
        if (this.cwW == null || this.cwW.size() <= 0 || this.mEndTime < 0) {
            return -1L;
        }
        return this.mEndTime - ((Long) Collections.min(this.cwW)).longValue();
    }

    @Override // com.baidu.swan.apps.performance.d.e
    public String getType() {
        return "PageUpdateRender";
    }
}
