package com.baidu.tbadk.core.data;

import tbclient.FrsPage.RealTime;
/* loaded from: classes.dex */
public class ar {
    private Long PN;
    private String mIcon;
    private String mUrl;

    public Long pv() {
        return this.PN;
    }

    public String getIcon() {
        return this.mIcon;
    }

    public String getUrl() {
        return this.mUrl;
    }

    public void a(RealTime realTime) {
        this.PN = realTime.task_id;
        this.mIcon = realTime.icon;
        this.mUrl = realTime.url;
    }
}
