package com.baidu.tbadk.BdToken;

import com.kwad.sdk.collector.AppStatusRules;
/* loaded from: classes.dex */
public class l extends h {
    private volatile long eEs;

    public l(b bVar) {
        super(bVar);
        this.eEs = System.currentTimeMillis();
    }

    public synchronized long bhO() {
        this.eEs = System.currentTimeMillis() + AppStatusRules.DEFAULT_GRANULARITY;
        return this.eEs;
    }

    public boolean isTimeout() {
        return System.currentTimeMillis() - this.eEs >= AppStatusRules.DEFAULT_GRANULARITY;
    }
}
