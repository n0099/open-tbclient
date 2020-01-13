package com.baidu.smallgame.sdk;

import com.baidu.searchbox.v8engine.V8ExceptionInfo;
import com.baidu.smallgame.sdk.b.c;
/* loaded from: classes10.dex */
class b extends c {
    private boolean aUD = false;
    private long aUE;
    private int aUF;
    private V8ExceptionInfo mV8ExceptionInfo;

    private void DM() {
        this.mV8ExceptionInfo = null;
        this.aUE = 0L;
        this.aUF = -1;
    }

    @Override // com.baidu.smallgame.sdk.b.c
    public synchronized void a(int i, V8ExceptionInfo v8ExceptionInfo) {
        if (this.mV8ExceptionInfo == null && v8ExceptionInfo != null) {
            this.mV8ExceptionInfo = new V8ExceptionInfo(v8ExceptionInfo.exceptionTime, v8ExceptionInfo.exceptionMsg, v8ExceptionInfo.exceptionTrace, v8ExceptionInfo.exceptionType, v8ExceptionInfo.filePath);
            this.aUF = i;
            if (this.aUO != null) {
                this.aUO.DO();
            }
        }
    }

    public synchronized void DN() {
        if (!this.aUD) {
            if (this.aUO == null || this.aUE <= 0 || this.mV8ExceptionInfo == null) {
                android.util.Log.e("StuckScreenHandler", "[StuckScreen] 未设置冻屏监听器， 或者异常信息已经被清空（需等待下次上屏）。");
            } else if (System.currentTimeMillis() - this.mV8ExceptionInfo.exceptionTime > this.aUN && this.mV8ExceptionInfo.exceptionTime > this.aUE) {
                this.aUO.a(new com.baidu.smallgame.sdk.b.b(this.aUF, this.mV8ExceptionInfo, this.aUE));
                DM();
            }
        }
    }

    public synchronized void b(boolean z, long j) {
        this.aUD = z;
        if (this.aUD) {
            this.aUE = j;
            this.mV8ExceptionInfo = null;
        }
    }
}
