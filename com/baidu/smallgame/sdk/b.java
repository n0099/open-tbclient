package com.baidu.smallgame.sdk;

import com.baidu.searchbox.v8engine.V8ExceptionInfo;
import com.baidu.smallgame.sdk.b.c;
/* loaded from: classes20.dex */
class b extends c {
    private boolean bPY = false;
    private long bPZ;
    private int bQa;
    private V8ExceptionInfo mV8ExceptionInfo;

    private void Xx() {
        this.mV8ExceptionInfo = null;
        this.bPZ = 0L;
        this.bQa = -1;
    }

    @Override // com.baidu.smallgame.sdk.b.c
    public synchronized void a(int i, V8ExceptionInfo v8ExceptionInfo) {
        if (this.mV8ExceptionInfo == null && v8ExceptionInfo != null) {
            this.mV8ExceptionInfo = new V8ExceptionInfo(v8ExceptionInfo.exceptionTime, v8ExceptionInfo.exceptionMsg, v8ExceptionInfo.exceptionTrace, v8ExceptionInfo.exceptionType, v8ExceptionInfo.filePath);
            this.bQa = i;
            if (this.bQj != null) {
                this.bQj.Xz();
            }
        }
    }

    public synchronized void Xy() {
        if (!this.bPY) {
            if (this.bQj == null || this.bPZ <= 0 || this.mV8ExceptionInfo == null) {
                android.util.Log.e("StuckScreenHandler", "[StuckScreen] 未设置冻屏监听器， 或者异常信息已经被清空（需等待下次上屏）。");
            } else if (System.currentTimeMillis() - this.mV8ExceptionInfo.exceptionTime > this.bQi && this.mV8ExceptionInfo.exceptionTime > this.bPZ) {
                this.bQj.a(new com.baidu.smallgame.sdk.b.b(this.bQa, this.mV8ExceptionInfo, this.bPZ));
                Xx();
            }
        }
    }

    public synchronized void b(boolean z, long j) {
        this.bPY = z;
        if (this.bPY) {
            this.bPZ = j;
            this.mV8ExceptionInfo = null;
        }
    }
}
