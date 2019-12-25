package com.baidu.smallgame.sdk;

import com.baidu.searchbox.v8engine.V8ExceptionInfo;
import com.baidu.smallgame.sdk.b.c;
/* loaded from: classes9.dex */
class b extends c {
    private boolean aTL = false;
    private long aTM;
    private int aTN;
    private V8ExceptionInfo mV8ExceptionInfo;

    private void Dq() {
        this.mV8ExceptionInfo = null;
        this.aTM = 0L;
        this.aTN = -1;
    }

    @Override // com.baidu.smallgame.sdk.b.c
    public synchronized void a(int i, V8ExceptionInfo v8ExceptionInfo) {
        if (this.mV8ExceptionInfo == null && v8ExceptionInfo != null) {
            this.mV8ExceptionInfo = new V8ExceptionInfo(v8ExceptionInfo.exceptionTime, v8ExceptionInfo.exceptionMsg, v8ExceptionInfo.exceptionTrace, v8ExceptionInfo.exceptionType, v8ExceptionInfo.filePath);
            this.aTN = i;
            if (this.aTW != null) {
                this.aTW.Ds();
            }
        }
    }

    public synchronized void Dr() {
        if (!this.aTL) {
            if (this.aTW == null || this.aTM <= 0 || this.mV8ExceptionInfo == null) {
                android.util.Log.e("StuckScreenHandler", "[StuckScreen] 未设置冻屏监听器， 或者异常信息已经被清空（需等待下次上屏）。");
            } else if (System.currentTimeMillis() - this.mV8ExceptionInfo.exceptionTime > this.aTV && this.mV8ExceptionInfo.exceptionTime > this.aTM) {
                this.aTW.a(new com.baidu.smallgame.sdk.b.b(this.aTN, this.mV8ExceptionInfo, this.aTM));
                Dq();
            }
        }
    }

    public synchronized void b(boolean z, long j) {
        this.aTL = z;
        if (this.aTL) {
            this.aTM = j;
            this.mV8ExceptionInfo = null;
        }
    }
}
