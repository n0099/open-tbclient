package com.baidu.smallgame.sdk.b;

import com.baidu.searchbox.v8engine.V8ExceptionInfo;
/* loaded from: classes9.dex */
public abstract class c {
    protected long aTV = 2000;
    protected a aTW;

    public abstract void a(int i, V8ExceptionInfo v8ExceptionInfo);

    public void a(a aVar) {
        this.aTW = aVar;
    }

    public void setStuckScreenLimitTime(long j) {
        this.aTV = j;
    }
}
