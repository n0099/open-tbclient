package com.baidu.tbadk.core.data;

import tbclient.FrsPage.RealTime;
/* loaded from: classes.dex */
public class ar {
    private Long aor;
    private String mIcon;
    private String mUrl;

    public void a(RealTime realTime) {
        this.aor = realTime.task_id;
        this.mIcon = realTime.icon;
        this.mUrl = realTime.url;
    }
}
