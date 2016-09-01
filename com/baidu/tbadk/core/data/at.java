package com.baidu.tbadk.core.data;

import tbclient.FrsPage.RealTime;
/* loaded from: classes.dex */
public class at {
    private Long Sx;
    private String mIcon;
    private String mUrl;

    public Long qz() {
        return this.Sx;
    }

    public String getIcon() {
        return this.mIcon;
    }

    public String getUrl() {
        return this.mUrl;
    }

    public void a(RealTime realTime) {
        this.Sx = realTime.task_id;
        this.mIcon = realTime.icon;
        this.mUrl = realTime.url;
    }
}
