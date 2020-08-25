package com.baidu.smallgame.sdk;

import com.baidu.searchbox.v8engine.V8ExceptionInfo;
import com.baidu.smallgame.sdk.b.c;
/* loaded from: classes20.dex */
class b extends c {
    private boolean bPU = false;
    private long bPV;
    private int bPW;
    private V8ExceptionInfo mV8ExceptionInfo;

    private void Xx() {
        this.mV8ExceptionInfo = null;
        this.bPV = 0L;
        this.bPW = -1;
    }

    @Override // com.baidu.smallgame.sdk.b.c
    public synchronized void a(int i, V8ExceptionInfo v8ExceptionInfo) {
        if (this.mV8ExceptionInfo == null && v8ExceptionInfo != null) {
            this.mV8ExceptionInfo = new V8ExceptionInfo(v8ExceptionInfo.exceptionTime, v8ExceptionInfo.exceptionMsg, v8ExceptionInfo.exceptionTrace, v8ExceptionInfo.exceptionType, v8ExceptionInfo.filePath);
            this.bPW = i;
            if (this.bQf != null) {
                this.bQf.Xz();
            }
        }
    }

    public synchronized void Xy() {
        if (!this.bPU) {
            if (this.bQf == null || this.bPV <= 0 || this.mV8ExceptionInfo == null) {
                android.util.Log.e("StuckScreenHandler", "[StuckScreen] 未设置冻屏监听器， 或者异常信息已经被清空（需等待下次上屏）。");
            } else if (System.currentTimeMillis() - this.mV8ExceptionInfo.exceptionTime > this.bQe && this.mV8ExceptionInfo.exceptionTime > this.bPV) {
                this.bQf.a(new com.baidu.smallgame.sdk.b.b(this.bPW, this.mV8ExceptionInfo, this.bPV));
                Xx();
            }
        }
    }

    public synchronized void b(boolean z, long j) {
        this.bPU = z;
        if (this.bPU) {
            this.bPV = j;
            this.mV8ExceptionInfo = null;
        }
    }
}
