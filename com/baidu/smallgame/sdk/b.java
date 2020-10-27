package com.baidu.smallgame.sdk;

import com.baidu.searchbox.v8engine.V8ExceptionInfo;
import com.baidu.smallgame.sdk.b.c;
/* loaded from: classes5.dex */
class b extends c {
    private boolean cmK = false;
    private long cmL;
    private int cmM;
    private V8ExceptionInfo mV8ExceptionInfo;

    private void acM() {
        this.mV8ExceptionInfo = null;
        this.cmL = 0L;
        this.cmM = -1;
    }

    @Override // com.baidu.smallgame.sdk.b.c
    public synchronized void a(int i, V8ExceptionInfo v8ExceptionInfo) {
        if (this.mV8ExceptionInfo == null && v8ExceptionInfo != null) {
            this.mV8ExceptionInfo = new V8ExceptionInfo(v8ExceptionInfo.exceptionTime, v8ExceptionInfo.exceptionMsg, v8ExceptionInfo.exceptionTrace, v8ExceptionInfo.exceptionType, v8ExceptionInfo.filePath);
            this.cmM = i;
            if (this.cmV != null) {
                this.cmV.acO();
            }
        }
    }

    public synchronized void acN() {
        if (!this.cmK) {
            if (this.cmV == null || this.cmL <= 0 || this.mV8ExceptionInfo == null) {
                android.util.Log.e("StuckScreenHandler", "[StuckScreen] 未设置冻屏监听器， 或者异常信息已经被清空（需等待下次上屏）。");
            } else if (System.currentTimeMillis() - this.mV8ExceptionInfo.exceptionTime > this.cmU && this.mV8ExceptionInfo.exceptionTime > this.cmL) {
                this.cmV.a(new com.baidu.smallgame.sdk.b.b(this.cmM, this.mV8ExceptionInfo, this.cmL));
                acM();
            }
        }
    }

    public synchronized void e(boolean z, long j) {
        this.cmK = z;
        if (this.cmK) {
            this.cmL = j;
            this.mV8ExceptionInfo = null;
        }
    }
}
