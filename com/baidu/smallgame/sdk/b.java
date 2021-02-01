package com.baidu.smallgame.sdk;

import com.baidu.searchbox.v8engine.V8ExceptionInfo;
import com.baidu.smallgame.sdk.b.c;
/* loaded from: classes15.dex */
class b extends c {
    private boolean cAw = false;
    private long cAx;
    private int mExceptionType;
    private V8ExceptionInfo mV8ExceptionInfo;

    private void afB() {
        this.mV8ExceptionInfo = null;
        this.cAx = 0L;
        this.mExceptionType = -1;
    }

    @Override // com.baidu.smallgame.sdk.b.c
    public synchronized void a(int i, V8ExceptionInfo v8ExceptionInfo) {
        if (this.mV8ExceptionInfo == null && v8ExceptionInfo != null) {
            this.mV8ExceptionInfo = new V8ExceptionInfo(v8ExceptionInfo.exceptionTime, v8ExceptionInfo.exceptionMsg, v8ExceptionInfo.exceptionTrace, v8ExceptionInfo.exceptionType, v8ExceptionInfo.filePath);
            this.mExceptionType = i;
            if (this.cAG != null) {
                this.cAG.afD();
            }
        }
    }

    public synchronized void afC() {
        if (!this.cAw) {
            if (this.cAG == null || this.cAx <= 0 || this.mV8ExceptionInfo == null) {
                android.util.Log.e("StuckScreenHandler", "[StuckScreen] 未设置冻屏监听器， 或者异常信息已经被清空（需等待下次上屏）。");
            } else if (System.currentTimeMillis() - this.mV8ExceptionInfo.exceptionTime > this.cAF && this.mV8ExceptionInfo.exceptionTime > this.cAx) {
                this.cAG.a(new com.baidu.smallgame.sdk.b.b(this.mExceptionType, this.mV8ExceptionInfo, this.cAx));
                afB();
            }
        }
    }

    public synchronized void l(boolean z, long j) {
        this.cAw = z;
        if (this.cAw) {
            this.cAx = j;
            this.mV8ExceptionInfo = null;
        }
    }
}
