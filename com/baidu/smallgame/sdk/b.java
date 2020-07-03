package com.baidu.smallgame.sdk;

import com.baidu.searchbox.v8engine.V8ExceptionInfo;
import com.baidu.smallgame.sdk.b.c;
/* loaded from: classes11.dex */
class b extends c {
    private boolean bKa = false;
    private long bKb;
    private int bKc;
    private V8ExceptionInfo mV8ExceptionInfo;

    private void Rn() {
        this.mV8ExceptionInfo = null;
        this.bKb = 0L;
        this.bKc = -1;
    }

    @Override // com.baidu.smallgame.sdk.b.c
    public synchronized void a(int i, V8ExceptionInfo v8ExceptionInfo) {
        if (this.mV8ExceptionInfo == null && v8ExceptionInfo != null) {
            this.mV8ExceptionInfo = new V8ExceptionInfo(v8ExceptionInfo.exceptionTime, v8ExceptionInfo.exceptionMsg, v8ExceptionInfo.exceptionTrace, v8ExceptionInfo.exceptionType, v8ExceptionInfo.filePath);
            this.bKc = i;
            if (this.bKl != null) {
                this.bKl.Rp();
            }
        }
    }

    public synchronized void Ro() {
        if (!this.bKa) {
            if (this.bKl == null || this.bKb <= 0 || this.mV8ExceptionInfo == null) {
                android.util.Log.e("StuckScreenHandler", "[StuckScreen] 未设置冻屏监听器， 或者异常信息已经被清空（需等待下次上屏）。");
            } else if (System.currentTimeMillis() - this.mV8ExceptionInfo.exceptionTime > this.bKk && this.mV8ExceptionInfo.exceptionTime > this.bKb) {
                this.bKl.a(new com.baidu.smallgame.sdk.b.b(this.bKc, this.mV8ExceptionInfo, this.bKb));
                Rn();
            }
        }
    }

    public synchronized void b(boolean z, long j) {
        this.bKa = z;
        if (this.bKa) {
            this.bKb = j;
            this.mV8ExceptionInfo = null;
        }
    }
}
