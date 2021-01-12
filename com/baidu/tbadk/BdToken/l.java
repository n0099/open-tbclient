package com.baidu.tbadk.BdToken;

import com.kwad.sdk.collector.AppStatusRules;
/* loaded from: classes.dex */
public class l extends h {
    private volatile long eCl;

    public l(b bVar) {
        super(bVar);
        this.eCl = System.currentTimeMillis();
    }

    public synchronized long bhB() {
        this.eCl = System.currentTimeMillis() + AppStatusRules.DEFAULT_GRANULARITY;
        return this.eCl;
    }

    public boolean isTimeout() {
        return System.currentTimeMillis() - this.eCl >= AppStatusRules.DEFAULT_GRANULARITY;
    }
}
