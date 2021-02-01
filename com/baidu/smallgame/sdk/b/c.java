package com.baidu.smallgame.sdk.b;

import com.baidu.searchbox.v8engine.V8ExceptionInfo;
/* loaded from: classes15.dex */
public abstract class c {
    protected long cAF = 2000;
    protected a cAG;

    public abstract void a(int i, V8ExceptionInfo v8ExceptionInfo);

    public void a(a aVar) {
        this.cAG = aVar;
    }

    public void setStuckScreenLimitTime(long j) {
        this.cAF = j;
    }
}
