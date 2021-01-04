package com.baidu.tbadk.BdToken;

import com.kwad.sdk.collector.AppStatusRules;
/* loaded from: classes.dex */
public class l extends h {
    private volatile long eGX;

    public l(b bVar) {
        super(bVar);
        this.eGX = System.currentTimeMillis();
    }

    public synchronized long blu() {
        this.eGX = System.currentTimeMillis() + AppStatusRules.DEFAULT_GRANULARITY;
        return this.eGX;
    }

    public boolean isTimeout() {
        return System.currentTimeMillis() - this.eGX >= AppStatusRules.DEFAULT_GRANULARITY;
    }
}
