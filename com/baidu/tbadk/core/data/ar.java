package com.baidu.tbadk.core.data;

import tbclient.FrsPage.RealTime;
/* loaded from: classes.dex */
public class ar {
    private Long agW;
    private String mIcon;
    private String mUrl;

    public void a(RealTime realTime) {
        this.agW = realTime.task_id;
        this.mIcon = realTime.icon;
        this.mUrl = realTime.url;
    }
}
