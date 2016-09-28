package com.baidu.tbadk.core.data;

import tbclient.FrsPage.RealTime;
/* loaded from: classes.dex */
public class av {
    private Long SE;
    private String mIcon;
    private String mUrl;

    public Long qK() {
        return this.SE;
    }

    public String getIcon() {
        return this.mIcon;
    }

    public String getUrl() {
        return this.mUrl;
    }

    public void a(RealTime realTime) {
        this.SE = realTime.task_id;
        this.mIcon = realTime.icon;
        this.mUrl = realTime.url;
    }
}
