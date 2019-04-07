package com.baidu.tbadk.core.data;

import tbclient.FrsPage.RealTime;
/* loaded from: classes.dex */
public class au {
    private Long bAh;
    private String mIcon;
    private String mUrl;

    public void a(RealTime realTime) {
        this.bAh = realTime.task_id;
        this.mIcon = realTime.icon;
        this.mUrl = realTime.url;
    }
}
