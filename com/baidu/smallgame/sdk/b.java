package com.baidu.smallgame.sdk;

import com.baidu.searchbox.v8engine.V8ExceptionInfo;
import com.baidu.smallgame.sdk.b.c;
/* loaded from: classes5.dex */
class b extends c {
    private boolean csH = false;
    private long csI;
    private int csJ;
    private V8ExceptionInfo mV8ExceptionInfo;

    private void afm() {
        this.mV8ExceptionInfo = null;
        this.csI = 0L;
        this.csJ = -1;
    }

    @Override // com.baidu.smallgame.sdk.b.c
    public synchronized void a(int i, V8ExceptionInfo v8ExceptionInfo) {
        if (this.mV8ExceptionInfo == null && v8ExceptionInfo != null) {
            this.mV8ExceptionInfo = new V8ExceptionInfo(v8ExceptionInfo.exceptionTime, v8ExceptionInfo.exceptionMsg, v8ExceptionInfo.exceptionTrace, v8ExceptionInfo.exceptionType, v8ExceptionInfo.filePath);
            this.csJ = i;
            if (this.csS != null) {
                this.csS.afo();
            }
        }
    }

    public synchronized void afn() {
        if (!this.csH) {
            if (this.csS == null || this.csI <= 0 || this.mV8ExceptionInfo == null) {
                android.util.Log.e("StuckScreenHandler", "[StuckScreen] 未设置冻屏监听器， 或者异常信息已经被清空（需等待下次上屏）。");
            } else if (System.currentTimeMillis() - this.mV8ExceptionInfo.exceptionTime > this.csR && this.mV8ExceptionInfo.exceptionTime > this.csI) {
                this.csS.a(new com.baidu.smallgame.sdk.b.b(this.csJ, this.mV8ExceptionInfo, this.csI));
                afm();
            }
        }
    }

    public synchronized void e(boolean z, long j) {
        this.csH = z;
        if (this.csH) {
            this.csI = j;
            this.mV8ExceptionInfo = null;
        }
    }
}
