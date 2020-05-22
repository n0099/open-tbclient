package com.baidu.smallgame.sdk.b;

import com.baidu.searchbox.v8engine.V8ExceptionInfo;
/* loaded from: classes11.dex */
public abstract class c {
    protected long bFw = 2000;
    protected a bFx;

    public abstract void a(int i, V8ExceptionInfo v8ExceptionInfo);

    public void a(a aVar) {
        this.bFx = aVar;
    }

    public void setStuckScreenLimitTime(long j) {
        this.bFw = j;
    }
}
