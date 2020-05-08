package com.baidu.smallgame.sdk;

import com.baidu.searchbox.v8engine.V8ExceptionInfo;
import com.baidu.smallgame.sdk.b.c;
/* loaded from: classes11.dex */
class b extends c {
    private boolean bxJ = false;
    private long bxK;
    private int bxL;
    private V8ExceptionInfo mV8ExceptionInfo;

    private void NU() {
        this.mV8ExceptionInfo = null;
        this.bxK = 0L;
        this.bxL = -1;
    }

    @Override // com.baidu.smallgame.sdk.b.c
    public synchronized void a(int i, V8ExceptionInfo v8ExceptionInfo) {
        if (this.mV8ExceptionInfo == null && v8ExceptionInfo != null) {
            this.mV8ExceptionInfo = new V8ExceptionInfo(v8ExceptionInfo.exceptionTime, v8ExceptionInfo.exceptionMsg, v8ExceptionInfo.exceptionTrace, v8ExceptionInfo.exceptionType, v8ExceptionInfo.filePath);
            this.bxL = i;
            if (this.bxU != null) {
                this.bxU.NW();
            }
        }
    }

    public synchronized void NV() {
        if (!this.bxJ) {
            if (this.bxU == null || this.bxK <= 0 || this.mV8ExceptionInfo == null) {
                android.util.Log.e("StuckScreenHandler", "[StuckScreen] 未设置冻屏监听器， 或者异常信息已经被清空（需等待下次上屏）。");
            } else if (System.currentTimeMillis() - this.mV8ExceptionInfo.exceptionTime > this.bxT && this.mV8ExceptionInfo.exceptionTime > this.bxK) {
                this.bxU.a(new com.baidu.smallgame.sdk.b.b(this.bxL, this.mV8ExceptionInfo, this.bxK));
                NU();
            }
        }
    }

    public synchronized void b(boolean z, long j) {
        this.bxJ = z;
        if (this.bxJ) {
            this.bxK = j;
            this.mV8ExceptionInfo = null;
        }
    }
}
