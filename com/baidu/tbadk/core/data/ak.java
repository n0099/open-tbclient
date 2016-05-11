package com.baidu.tbadk.core.data;

import tbclient.FrsPage.RealTime;
/* loaded from: classes.dex */
public class ak {
    private String NM;
    private Long Pf;
    private String mUrl;

    public Long pS() {
        return this.Pf;
    }

    public String getIcon() {
        return this.NM;
    }

    public String getUrl() {
        return this.mUrl;
    }

    public void a(RealTime realTime) {
        this.Pf = realTime.task_id;
        this.NM = realTime.icon;
        this.mUrl = realTime.url;
    }
}
