package com.baidu.smallgame.sdk.b;

import com.baidu.searchbox.v8engine.V8ExceptionInfo;
/* loaded from: classes10.dex */
public abstract class c {
    protected long aUN = 2000;
    protected a aUO;

    public abstract void a(int i, V8ExceptionInfo v8ExceptionInfo);

    public void a(a aVar) {
        this.aUO = aVar;
    }

    public void setStuckScreenLimitTime(long j) {
        this.aUN = j;
    }
}
