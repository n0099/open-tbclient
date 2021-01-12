package com.baidu.smallgame.sdk.b;

import com.baidu.searchbox.v8engine.V8ExceptionInfo;
/* loaded from: classes14.dex */
public abstract class c {
    protected long cyj = 2000;
    protected a cyk;

    public abstract void a(int i, V8ExceptionInfo v8ExceptionInfo);

    public void a(a aVar) {
        this.cyk = aVar;
    }

    public void setStuckScreenLimitTime(long j) {
        this.cyj = j;
    }
}
