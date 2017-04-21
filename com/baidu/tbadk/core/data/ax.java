package com.baidu.tbadk.core.data;

import tbclient.FrsPage.RealTime;
/* loaded from: classes.dex */
public class ax {
    private Long Xz;
    private String mIcon;
    private String mUrl;

    public void a(RealTime realTime) {
        this.Xz = realTime.task_id;
        this.mIcon = realTime.icon;
        this.mUrl = realTime.url;
    }
}
