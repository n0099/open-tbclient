package com.baidu.tbadk.core.data;

import tbclient.FrsPage.RealTime;
/* loaded from: classes.dex */
public class az {
    private Long WM;
    private String mIcon;
    private String mUrl;

    public void a(RealTime realTime) {
        this.WM = realTime.task_id;
        this.mIcon = realTime.icon;
        this.mUrl = realTime.url;
    }
}
