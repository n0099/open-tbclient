package com.baidu.searchbox.ng.ai.apps.performance.panel;
/* loaded from: classes2.dex */
public class PageSwitchCost implements TimeCost {
    private long mStartTime = -1;
    private long mEndTime = -1;

    @Override // com.baidu.searchbox.ng.ai.apps.performance.panel.TimeCost
    public void setStart(long j) {
        this.mStartTime = j;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.performance.panel.TimeCost
    public void setEnd(long j) {
        this.mEndTime = j;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.performance.panel.TimeCost
    public long getCost() {
        if (this.mStartTime < 0 || this.mEndTime < 0) {
            return -1L;
        }
        return this.mEndTime - this.mStartTime;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.performance.panel.TimeCost
    public String getType() {
        return TimeCost.PAGE_SWITCH;
    }
}
