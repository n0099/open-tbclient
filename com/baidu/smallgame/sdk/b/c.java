package com.baidu.smallgame.sdk.b;

import com.baidu.searchbox.v8engine.V8ExceptionInfo;
/* loaded from: classes14.dex */
public abstract class c {
    protected long cyd = 2000;
    protected a cye;

    public abstract void a(int i, V8ExceptionInfo v8ExceptionInfo);

    public void a(a aVar) {
        this.cye = aVar;
    }

    public void setStuckScreenLimitTime(long j) {
        this.cyd = j;
    }
}
