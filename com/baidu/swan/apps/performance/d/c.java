package com.baidu.swan.apps.performance.d;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes11.dex */
public class c implements e {
    private List<Long> csi = new ArrayList();
    private long mEndTime = -1;

    @Override // com.baidu.swan.apps.performance.d.e
    public void setStart(long j) {
        if (this.csi != null) {
            this.csi.add(Long.valueOf(j));
        }
    }

    @Override // com.baidu.swan.apps.performance.d.e
    public void setEnd(long j) {
        this.mEndTime = j;
    }

    @Override // com.baidu.swan.apps.performance.d.e
    public long alG() {
        if (this.csi == null || this.csi.size() <= 0 || this.mEndTime < 0) {
            return -1L;
        }
        return this.mEndTime - ((Long) Collections.min(this.csi)).longValue();
    }

    @Override // com.baidu.swan.apps.performance.d.e
    public String getType() {
        return "PageUpdateRender";
    }
}
