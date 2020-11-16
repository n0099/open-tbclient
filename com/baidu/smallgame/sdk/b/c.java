package com.baidu.smallgame.sdk.b;

import com.baidu.searchbox.v8engine.V8ExceptionInfo;
/* loaded from: classes6.dex */
public abstract class c {
    protected long crh = 2000;
    protected a cri;

    public abstract void a(int i, V8ExceptionInfo v8ExceptionInfo);

    public void a(a aVar) {
        this.cri = aVar;
    }

    public void setStuckScreenLimitTime(long j) {
        this.crh = j;
    }
}
