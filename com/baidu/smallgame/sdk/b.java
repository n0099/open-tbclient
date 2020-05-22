package com.baidu.smallgame.sdk;

import com.baidu.searchbox.v8engine.V8ExceptionInfo;
import com.baidu.smallgame.sdk.b.c;
/* loaded from: classes11.dex */
class b extends c {
    private boolean bFm = false;
    private long bFn;
    private int bFo;
    private V8ExceptionInfo mV8ExceptionInfo;

    private void Qh() {
        this.mV8ExceptionInfo = null;
        this.bFn = 0L;
        this.bFo = -1;
    }

    @Override // com.baidu.smallgame.sdk.b.c
    public synchronized void a(int i, V8ExceptionInfo v8ExceptionInfo) {
        if (this.mV8ExceptionInfo == null && v8ExceptionInfo != null) {
            this.mV8ExceptionInfo = new V8ExceptionInfo(v8ExceptionInfo.exceptionTime, v8ExceptionInfo.exceptionMsg, v8ExceptionInfo.exceptionTrace, v8ExceptionInfo.exceptionType, v8ExceptionInfo.filePath);
            this.bFo = i;
            if (this.bFx != null) {
                this.bFx.Qj();
            }
        }
    }

    public synchronized void Qi() {
        if (!this.bFm) {
            if (this.bFx == null || this.bFn <= 0 || this.mV8ExceptionInfo == null) {
                android.util.Log.e("StuckScreenHandler", "[StuckScreen] 未设置冻屏监听器， 或者异常信息已经被清空（需等待下次上屏）。");
            } else if (System.currentTimeMillis() - this.mV8ExceptionInfo.exceptionTime > this.bFw && this.mV8ExceptionInfo.exceptionTime > this.bFn) {
                this.bFx.a(new com.baidu.smallgame.sdk.b.b(this.bFo, this.mV8ExceptionInfo, this.bFn));
                Qh();
            }
        }
    }

    public synchronized void b(boolean z, long j) {
        this.bFm = z;
        if (this.bFm) {
            this.bFn = j;
            this.mV8ExceptionInfo = null;
        }
    }
}
