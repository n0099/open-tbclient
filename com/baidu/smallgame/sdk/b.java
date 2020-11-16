package com.baidu.smallgame.sdk;

import com.baidu.searchbox.v8engine.V8ExceptionInfo;
import com.baidu.smallgame.sdk.b.c;
/* loaded from: classes6.dex */
class b extends c {
    private boolean cqW = false;
    private long cqX;
    private int cqY;
    private V8ExceptionInfo mV8ExceptionInfo;

    private void aeE() {
        this.mV8ExceptionInfo = null;
        this.cqX = 0L;
        this.cqY = -1;
    }

    @Override // com.baidu.smallgame.sdk.b.c
    public synchronized void a(int i, V8ExceptionInfo v8ExceptionInfo) {
        if (this.mV8ExceptionInfo == null && v8ExceptionInfo != null) {
            this.mV8ExceptionInfo = new V8ExceptionInfo(v8ExceptionInfo.exceptionTime, v8ExceptionInfo.exceptionMsg, v8ExceptionInfo.exceptionTrace, v8ExceptionInfo.exceptionType, v8ExceptionInfo.filePath);
            this.cqY = i;
            if (this.cri != null) {
                this.cri.aeG();
            }
        }
    }

    public synchronized void aeF() {
        if (!this.cqW) {
            if (this.cri == null || this.cqX <= 0 || this.mV8ExceptionInfo == null) {
                android.util.Log.e("StuckScreenHandler", "[StuckScreen] 未设置冻屏监听器， 或者异常信息已经被清空（需等待下次上屏）。");
            } else if (System.currentTimeMillis() - this.mV8ExceptionInfo.exceptionTime > this.crh && this.mV8ExceptionInfo.exceptionTime > this.cqX) {
                this.cri.a(new com.baidu.smallgame.sdk.b.b(this.cqY, this.mV8ExceptionInfo, this.cqX));
                aeE();
            }
        }
    }

    public synchronized void e(boolean z, long j) {
        this.cqW = z;
        if (this.cqW) {
            this.cqX = j;
            this.mV8ExceptionInfo = null;
        }
    }
}
