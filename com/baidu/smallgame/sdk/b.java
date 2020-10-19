package com.baidu.smallgame.sdk;

import com.baidu.searchbox.v8engine.V8ExceptionInfo;
import com.baidu.smallgame.sdk.b.c;
/* loaded from: classes5.dex */
class b extends c {
    private boolean cem = false;
    private long cen;
    private int ceo;
    private V8ExceptionInfo mV8ExceptionInfo;

    private void aaS() {
        this.mV8ExceptionInfo = null;
        this.cen = 0L;
        this.ceo = -1;
    }

    @Override // com.baidu.smallgame.sdk.b.c
    public synchronized void a(int i, V8ExceptionInfo v8ExceptionInfo) {
        if (this.mV8ExceptionInfo == null && v8ExceptionInfo != null) {
            this.mV8ExceptionInfo = new V8ExceptionInfo(v8ExceptionInfo.exceptionTime, v8ExceptionInfo.exceptionMsg, v8ExceptionInfo.exceptionTrace, v8ExceptionInfo.exceptionType, v8ExceptionInfo.filePath);
            this.ceo = i;
            if (this.cex != null) {
                this.cex.aaU();
            }
        }
    }

    public synchronized void aaT() {
        if (!this.cem) {
            if (this.cex == null || this.cen <= 0 || this.mV8ExceptionInfo == null) {
                android.util.Log.e("StuckScreenHandler", "[StuckScreen] 未设置冻屏监听器， 或者异常信息已经被清空（需等待下次上屏）。");
            } else if (System.currentTimeMillis() - this.mV8ExceptionInfo.exceptionTime > this.cew && this.mV8ExceptionInfo.exceptionTime > this.cen) {
                this.cex.a(new com.baidu.smallgame.sdk.b.b(this.ceo, this.mV8ExceptionInfo, this.cen));
                aaS();
            }
        }
    }

    public synchronized void e(boolean z, long j) {
        this.cem = z;
        if (this.cem) {
            this.cen = j;
            this.mV8ExceptionInfo = null;
        }
    }
}
