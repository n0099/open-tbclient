package com.baidu.smallgame.sdk;

import com.baidu.searchbox.v8engine.V8ExceptionInfo;
import com.baidu.smallgame.sdk.b.c;
/* loaded from: classes11.dex */
class b extends c {
    private boolean aYR = false;
    private long aYS;
    private int aYT;
    private V8ExceptionInfo mV8ExceptionInfo;

    private void Gd() {
        this.mV8ExceptionInfo = null;
        this.aYS = 0L;
        this.aYT = -1;
    }

    @Override // com.baidu.smallgame.sdk.b.c
    public synchronized void a(int i, V8ExceptionInfo v8ExceptionInfo) {
        if (this.mV8ExceptionInfo == null && v8ExceptionInfo != null) {
            this.mV8ExceptionInfo = new V8ExceptionInfo(v8ExceptionInfo.exceptionTime, v8ExceptionInfo.exceptionMsg, v8ExceptionInfo.exceptionTrace, v8ExceptionInfo.exceptionType, v8ExceptionInfo.filePath);
            this.aYT = i;
            if (this.aZc != null) {
                this.aZc.Gf();
            }
        }
    }

    public synchronized void Ge() {
        if (!this.aYR) {
            if (this.aZc == null || this.aYS <= 0 || this.mV8ExceptionInfo == null) {
                android.util.Log.e("StuckScreenHandler", "[StuckScreen] 未设置冻屏监听器， 或者异常信息已经被清空（需等待下次上屏）。");
            } else if (System.currentTimeMillis() - this.mV8ExceptionInfo.exceptionTime > this.aZb && this.mV8ExceptionInfo.exceptionTime > this.aYS) {
                this.aZc.a(new com.baidu.smallgame.sdk.b.b(this.aYT, this.mV8ExceptionInfo, this.aYS));
                Gd();
            }
        }
    }

    public synchronized void b(boolean z, long j) {
        this.aYR = z;
        if (this.aYR) {
            this.aYS = j;
            this.mV8ExceptionInfo = null;
        }
    }
}
