package com.baidu.smallgame.sdk;

import com.baidu.searchbox.v8engine.V8ExceptionInfo;
import com.baidu.smallgame.sdk.b.c;
/* loaded from: classes10.dex */
class b extends c {
    private boolean bKw = false;
    private long bKx;
    private int bKy;
    private V8ExceptionInfo mV8ExceptionInfo;

    private void RC() {
        this.mV8ExceptionInfo = null;
        this.bKx = 0L;
        this.bKy = -1;
    }

    @Override // com.baidu.smallgame.sdk.b.c
    public synchronized void a(int i, V8ExceptionInfo v8ExceptionInfo) {
        if (this.mV8ExceptionInfo == null && v8ExceptionInfo != null) {
            this.mV8ExceptionInfo = new V8ExceptionInfo(v8ExceptionInfo.exceptionTime, v8ExceptionInfo.exceptionMsg, v8ExceptionInfo.exceptionTrace, v8ExceptionInfo.exceptionType, v8ExceptionInfo.filePath);
            this.bKy = i;
            if (this.bKH != null) {
                this.bKH.RE();
            }
        }
    }

    public synchronized void RD() {
        if (!this.bKw) {
            if (this.bKH == null || this.bKx <= 0 || this.mV8ExceptionInfo == null) {
                android.util.Log.e("StuckScreenHandler", "[StuckScreen] 未设置冻屏监听器， 或者异常信息已经被清空（需等待下次上屏）。");
            } else if (System.currentTimeMillis() - this.mV8ExceptionInfo.exceptionTime > this.bKG && this.mV8ExceptionInfo.exceptionTime > this.bKx) {
                this.bKH.a(new com.baidu.smallgame.sdk.b.b(this.bKy, this.mV8ExceptionInfo, this.bKx));
                RC();
            }
        }
    }

    public synchronized void b(boolean z, long j) {
        this.bKw = z;
        if (this.bKw) {
            this.bKx = j;
            this.mV8ExceptionInfo = null;
        }
    }
}
