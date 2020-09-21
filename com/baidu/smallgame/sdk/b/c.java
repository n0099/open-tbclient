package com.baidu.smallgame.sdk.b;

import com.baidu.searchbox.v8engine.V8ExceptionInfo;
/* loaded from: classes4.dex */
public abstract class c {
    protected long bSi = 2000;
    protected a bSj;

    public abstract void a(int i, V8ExceptionInfo v8ExceptionInfo);

    public void a(a aVar) {
        this.bSj = aVar;
    }

    public void setStuckScreenLimitTime(long j) {
        this.bSi = j;
    }
}
