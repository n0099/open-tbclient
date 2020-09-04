package com.baidu.smallgame.sdk.b;

import com.baidu.searchbox.v8engine.V8ExceptionInfo;
/* loaded from: classes20.dex */
public abstract class c {
    protected long bQi = 2000;
    protected a bQj;

    public abstract void a(int i, V8ExceptionInfo v8ExceptionInfo);

    public void a(a aVar) {
        this.bQj = aVar;
    }

    public void setStuckScreenLimitTime(long j) {
        this.bQi = j;
    }
}
