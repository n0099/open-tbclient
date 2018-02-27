package com.baidu.tbadk.core.data;

import tbclient.FrsPage.RealTime;
/* loaded from: classes.dex */
public class at {
    private Long aNK;
    private String mIcon;
    private String mUrl;

    public void a(RealTime realTime) {
        this.aNK = realTime.task_id;
        this.mIcon = realTime.icon;
        this.mUrl = realTime.url;
    }
}
