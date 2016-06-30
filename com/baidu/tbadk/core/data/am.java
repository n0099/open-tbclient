package com.baidu.tbadk.core.data;

import tbclient.FrsPage.RealTime;
/* loaded from: classes.dex */
public class am {
    private Long Pp;
    private String mIcon;
    private String mUrl;

    public Long pM() {
        return this.Pp;
    }

    public String getIcon() {
        return this.mIcon;
    }

    public String getUrl() {
        return this.mUrl;
    }

    public void a(RealTime realTime) {
        this.Pp = realTime.task_id;
        this.mIcon = realTime.icon;
        this.mUrl = realTime.url;
    }
}
