package com.baidu.smallgame.sdk.b;

import com.baidu.searchbox.v8engine.V8ExceptionInfo;
/* loaded from: classes20.dex */
public abstract class c {
    protected long bQe = 2000;
    protected a bQf;

    public abstract void a(int i, V8ExceptionInfo v8ExceptionInfo);

    public void a(a aVar) {
        this.bQf = aVar;
    }

    public void setStuckScreenLimitTime(long j) {
        this.bQe = j;
    }
}
