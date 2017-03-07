package com.baidu.tbadk.core.data;

import tbclient.FrsPage.RealTime;
/* loaded from: classes.dex */
public class ay {
    private Long Xi;
    private String mIcon;
    private String mUrl;

    public void a(RealTime realTime) {
        this.Xi = realTime.task_id;
        this.mIcon = realTime.icon;
        this.mUrl = realTime.url;
    }
}
