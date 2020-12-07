package com.baidu.smallgame.sdk;

import com.baidu.searchbox.v8engine.V8ExceptionInfo;
import com.baidu.smallgame.sdk.b.c;
/* loaded from: classes14.dex */
class b extends c {
    private boolean cxT = false;
    private long cxU;
    private int cxV;
    private V8ExceptionInfo mV8ExceptionInfo;

    private void ahM() {
        this.mV8ExceptionInfo = null;
        this.cxU = 0L;
        this.cxV = -1;
    }

    @Override // com.baidu.smallgame.sdk.b.c
    public synchronized void a(int i, V8ExceptionInfo v8ExceptionInfo) {
        if (this.mV8ExceptionInfo == null && v8ExceptionInfo != null) {
            this.mV8ExceptionInfo = new V8ExceptionInfo(v8ExceptionInfo.exceptionTime, v8ExceptionInfo.exceptionMsg, v8ExceptionInfo.exceptionTrace, v8ExceptionInfo.exceptionType, v8ExceptionInfo.filePath);
            this.cxV = i;
            if (this.cye != null) {
                this.cye.ahO();
            }
        }
    }

    public synchronized void ahN() {
        if (!this.cxT) {
            if (this.cye == null || this.cxU <= 0 || this.mV8ExceptionInfo == null) {
                android.util.Log.e("StuckScreenHandler", "[StuckScreen] 未设置冻屏监听器， 或者异常信息已经被清空（需等待下次上屏）。");
            } else if (System.currentTimeMillis() - this.mV8ExceptionInfo.exceptionTime > this.cyd && this.mV8ExceptionInfo.exceptionTime > this.cxU) {
                this.cye.a(new com.baidu.smallgame.sdk.b.b(this.cxV, this.mV8ExceptionInfo, this.cxU));
                ahM();
            }
        }
    }

    public synchronized void e(boolean z, long j) {
        this.cxT = z;
        if (this.cxT) {
            this.cxU = j;
            this.mV8ExceptionInfo = null;
        }
    }
}
