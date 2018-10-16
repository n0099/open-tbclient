package com.baidu.searchbox.ng.ai.apps.performance.panel;
/* loaded from: classes2.dex */
public interface TimeCost {
    public static final String PAGE_INIT_RENDER = "PageInitRender";
    public static final String PAGE_SWITCH = "PageSwitchCost";
    public static final String PAGE_UPDATE_RENDER = "PageUpdateRender";

    long getCost();

    String getType();

    void setEnd(long j);

    void setStart(long j);
}
