package com.baidu.smallgame.sdk;

import com.baidu.searchbox.v8engine.V8ExceptionInfo;
import com.baidu.smallgame.sdk.b.c;
/* loaded from: classes11.dex */
class b extends c {
    private boolean aYP = false;
    private long aYQ;
    private int aYR;
    private V8ExceptionInfo mV8ExceptionInfo;

    private void Gb() {
        this.mV8ExceptionInfo = null;
        this.aYQ = 0L;
        this.aYR = -1;
    }

    @Override // com.baidu.smallgame.sdk.b.c
    public synchronized void a(int i, V8ExceptionInfo v8ExceptionInfo) {
        if (this.mV8ExceptionInfo == null && v8ExceptionInfo != null) {
            this.mV8ExceptionInfo = new V8ExceptionInfo(v8ExceptionInfo.exceptionTime, v8ExceptionInfo.exceptionMsg, v8ExceptionInfo.exceptionTrace, v8ExceptionInfo.exceptionType, v8ExceptionInfo.filePath);
            this.aYR = i;
            if (this.aZa != null) {
                this.aZa.Gd();
            }
        }
    }

    public synchronized void Gc() {
        if (!this.aYP) {
            if (this.aZa == null || this.aYQ <= 0 || this.mV8ExceptionInfo == null) {
                android.util.Log.e("StuckScreenHandler", "[StuckScreen] 未设置冻屏监听器， 或者异常信息已经被清空（需等待下次上屏）。");
            } else if (System.currentTimeMillis() - this.mV8ExceptionInfo.exceptionTime > this.aYZ && this.mV8ExceptionInfo.exceptionTime > this.aYQ) {
                this.aZa.a(new com.baidu.smallgame.sdk.b.b(this.aYR, this.mV8ExceptionInfo, this.aYQ));
                Gb();
            }
        }
    }

    public synchronized void b(boolean z, long j) {
        this.aYP = z;
        if (this.aYP) {
            this.aYQ = j;
            this.mV8ExceptionInfo = null;
        }
    }
}
