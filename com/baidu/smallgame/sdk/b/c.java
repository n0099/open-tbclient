package com.baidu.smallgame.sdk.b;

import com.baidu.searchbox.v8engine.V8ExceptionInfo;
/* loaded from: classes3.dex */
public abstract class c {
    protected long cCV = 2000;
    protected a cCW;

    public abstract void a(int i, V8ExceptionInfo v8ExceptionInfo);

    public void a(a aVar) {
        this.cCW = aVar;
    }

    public void setStuckScreenLimitTime(long j) {
        this.cCV = j;
    }
}
