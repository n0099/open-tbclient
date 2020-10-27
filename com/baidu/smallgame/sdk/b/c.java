package com.baidu.smallgame.sdk.b;

import com.baidu.searchbox.v8engine.V8ExceptionInfo;
/* loaded from: classes5.dex */
public abstract class c {
    protected long cmU = 2000;
    protected a cmV;

    public abstract void a(int i, V8ExceptionInfo v8ExceptionInfo);

    public void a(a aVar) {
        this.cmV = aVar;
    }

    public void setStuckScreenLimitTime(long j) {
        this.cmU = j;
    }
}
