package com.baidu.tbadk.core.data;

import tbclient.FrsPage.RealTime;
/* loaded from: classes.dex */
public class as {
    private Long Zh;
    private String mIcon;
    private String mUrl;

    public void a(RealTime realTime) {
        this.Zh = realTime.task_id;
        this.mIcon = realTime.icon;
        this.mUrl = realTime.url;
    }
}
