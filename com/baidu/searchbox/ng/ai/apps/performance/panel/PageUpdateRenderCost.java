package com.baidu.searchbox.ng.ai.apps.performance.panel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes2.dex */
public class PageUpdateRenderCost implements TimeCost {
    private List<Long> mStartTime = new ArrayList();
    private long mEndTime = -1;

    @Override // com.baidu.searchbox.ng.ai.apps.performance.panel.TimeCost
    public void setStart(long j) {
        if (this.mStartTime != null) {
            this.mStartTime.add(Long.valueOf(j));
        }
    }

    @Override // com.baidu.searchbox.ng.ai.apps.performance.panel.TimeCost
    public void setEnd(long j) {
        this.mEndTime = j;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.performance.panel.TimeCost
    public long getCost() {
        if (this.mStartTime == null || this.mStartTime.size() <= 0 || this.mEndTime < 0) {
            return -1L;
        }
        return this.mEndTime - ((Long) Collections.min(this.mStartTime)).longValue();
    }

    @Override // com.baidu.searchbox.ng.ai.apps.performance.panel.TimeCost
    public String getType() {
        return TimeCost.PAGE_UPDATE_RENDER;
    }
}
