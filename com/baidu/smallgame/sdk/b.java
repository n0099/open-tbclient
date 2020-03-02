package com.baidu.smallgame.sdk;

import com.baidu.searchbox.v8engine.V8ExceptionInfo;
import com.baidu.smallgame.sdk.b.c;
/* loaded from: classes11.dex */
class b extends c {
    private boolean aYQ = false;
    private long aYR;
    private int aYS;
    private V8ExceptionInfo mV8ExceptionInfo;

    private void Gd() {
        this.mV8ExceptionInfo = null;
        this.aYR = 0L;
        this.aYS = -1;
    }

    @Override // com.baidu.smallgame.sdk.b.c
    public synchronized void a(int i, V8ExceptionInfo v8ExceptionInfo) {
        if (this.mV8ExceptionInfo == null && v8ExceptionInfo != null) {
            this.mV8ExceptionInfo = new V8ExceptionInfo(v8ExceptionInfo.exceptionTime, v8ExceptionInfo.exceptionMsg, v8ExceptionInfo.exceptionTrace, v8ExceptionInfo.exceptionType, v8ExceptionInfo.filePath);
            this.aYS = i;
            if (this.aZb != null) {
                this.aZb.Gf();
            }
        }
    }

    public synchronized void Ge() {
        if (!this.aYQ) {
            if (this.aZb == null || this.aYR <= 0 || this.mV8ExceptionInfo == null) {
                android.util.Log.e("StuckScreenHandler", "[StuckScreen] 未设置冻屏监听器， 或者异常信息已经被清空（需等待下次上屏）。");
            } else if (System.currentTimeMillis() - this.mV8ExceptionInfo.exceptionTime > this.aZa && this.mV8ExceptionInfo.exceptionTime > this.aYR) {
                this.aZb.a(new com.baidu.smallgame.sdk.b.b(this.aYS, this.mV8ExceptionInfo, this.aYR));
                Gd();
            }
        }
    }

    public synchronized void b(boolean z, long j) {
        this.aYQ = z;
        if (this.aYQ) {
            this.aYR = j;
            this.mV8ExceptionInfo = null;
        }
    }
}
