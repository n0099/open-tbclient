package com.baidu.smallgame.sdk;

import com.baidu.searchbox.v8engine.V8ExceptionInfo;
import com.baidu.smallgame.sdk.b.c;
/* loaded from: classes11.dex */
class b extends c {
    private boolean bxE = false;
    private long bxF;
    private int bxG;
    private V8ExceptionInfo mV8ExceptionInfo;

    private void NV() {
        this.mV8ExceptionInfo = null;
        this.bxF = 0L;
        this.bxG = -1;
    }

    @Override // com.baidu.smallgame.sdk.b.c
    public synchronized void a(int i, V8ExceptionInfo v8ExceptionInfo) {
        if (this.mV8ExceptionInfo == null && v8ExceptionInfo != null) {
            this.mV8ExceptionInfo = new V8ExceptionInfo(v8ExceptionInfo.exceptionTime, v8ExceptionInfo.exceptionMsg, v8ExceptionInfo.exceptionTrace, v8ExceptionInfo.exceptionType, v8ExceptionInfo.filePath);
            this.bxG = i;
            if (this.bxP != null) {
                this.bxP.NX();
            }
        }
    }

    public synchronized void NW() {
        if (!this.bxE) {
            if (this.bxP == null || this.bxF <= 0 || this.mV8ExceptionInfo == null) {
                android.util.Log.e("StuckScreenHandler", "[StuckScreen] 未设置冻屏监听器， 或者异常信息已经被清空（需等待下次上屏）。");
            } else if (System.currentTimeMillis() - this.mV8ExceptionInfo.exceptionTime > this.bxO && this.mV8ExceptionInfo.exceptionTime > this.bxF) {
                this.bxP.a(new com.baidu.smallgame.sdk.b.b(this.bxG, this.mV8ExceptionInfo, this.bxF));
                NV();
            }
        }
    }

    public synchronized void b(boolean z, long j) {
        this.bxE = z;
        if (this.bxE) {
            this.bxF = j;
            this.mV8ExceptionInfo = null;
        }
    }
}
