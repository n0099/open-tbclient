package com.baidu.smallgame.sdk.b;

import com.baidu.searchbox.v8engine.V8ExceptionInfo;
/* loaded from: classes11.dex */
public abstract class c {
    protected long bxO = 2000;
    protected a bxP;

    public abstract void a(int i, V8ExceptionInfo v8ExceptionInfo);

    public void a(a aVar) {
        this.bxP = aVar;
    }

    public void setStuckScreenLimitTime(long j) {
        this.bxO = j;
    }
}
