package com.baidu.smallgame.sdk;

import com.baidu.searchbox.v8engine.V8ExceptionInfo;
import com.baidu.smallgame.sdk.b.c;
/* loaded from: classes14.dex */
class b extends c {
    private boolean cBW = false;
    private long cBX;
    private int mExceptionType;
    private V8ExceptionInfo mV8ExceptionInfo;

    private void afE() {
        this.mV8ExceptionInfo = null;
        this.cBX = 0L;
        this.mExceptionType = -1;
    }

    @Override // com.baidu.smallgame.sdk.b.c
    public synchronized void a(int i, V8ExceptionInfo v8ExceptionInfo) {
        if (this.mV8ExceptionInfo == null && v8ExceptionInfo != null) {
            this.mV8ExceptionInfo = new V8ExceptionInfo(v8ExceptionInfo.exceptionTime, v8ExceptionInfo.exceptionMsg, v8ExceptionInfo.exceptionTrace, v8ExceptionInfo.exceptionType, v8ExceptionInfo.filePath);
            this.mExceptionType = i;
            if (this.cCg != null) {
                this.cCg.afG();
            }
        }
    }

    public synchronized void afF() {
        if (!this.cBW) {
            if (this.cCg == null || this.cBX <= 0 || this.mV8ExceptionInfo == null) {
                android.util.Log.e("StuckScreenHandler", "[StuckScreen] 未设置冻屏监听器， 或者异常信息已经被清空（需等待下次上屏）。");
            } else if (System.currentTimeMillis() - this.mV8ExceptionInfo.exceptionTime > this.cCf && this.mV8ExceptionInfo.exceptionTime > this.cBX) {
                this.cCg.a(new com.baidu.smallgame.sdk.b.b(this.mExceptionType, this.mV8ExceptionInfo, this.cBX));
                afE();
            }
        }
    }

    public synchronized void m(boolean z, long j) {
        this.cBW = z;
        if (this.cBW) {
            this.cBX = j;
            this.mV8ExceptionInfo = null;
        }
    }
}
