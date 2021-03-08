package com.baidu.tbadk.BdToken;

import com.kwad.sdk.collector.AppStatusRules;
/* loaded from: classes.dex */
public class l extends h {
    private volatile long eFT;

    public l(b bVar) {
        super(bVar);
        this.eFT = System.currentTimeMillis();
    }

    public synchronized long bhQ() {
        this.eFT = System.currentTimeMillis() + AppStatusRules.DEFAULT_GRANULARITY;
        return this.eFT;
    }

    public boolean isTimeout() {
        return System.currentTimeMillis() - this.eFT >= AppStatusRules.DEFAULT_GRANULARITY;
    }
}
