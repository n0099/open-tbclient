package com.baidu.tbadk.core.data;

import tbclient.FrsPage.RealTime;
/* loaded from: classes.dex */
public class at {
    private Long aMC;
    private String mIcon;
    private String mUrl;

    public void a(RealTime realTime) {
        this.aMC = realTime.task_id;
        this.mIcon = realTime.icon;
        this.mUrl = realTime.url;
    }
}
