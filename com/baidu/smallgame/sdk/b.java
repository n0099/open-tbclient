package com.baidu.smallgame.sdk;

import com.baidu.searchbox.v8engine.V8ExceptionInfo;
import com.baidu.smallgame.sdk.b.c;
/* loaded from: classes4.dex */
class b extends c {
    private boolean bRY = false;
    private long bRZ;
    private int bSa;
    private V8ExceptionInfo mV8ExceptionInfo;

    private void Yg() {
        this.mV8ExceptionInfo = null;
        this.bRZ = 0L;
        this.bSa = -1;
    }

    @Override // com.baidu.smallgame.sdk.b.c
    public synchronized void a(int i, V8ExceptionInfo v8ExceptionInfo) {
        if (this.mV8ExceptionInfo == null && v8ExceptionInfo != null) {
            this.mV8ExceptionInfo = new V8ExceptionInfo(v8ExceptionInfo.exceptionTime, v8ExceptionInfo.exceptionMsg, v8ExceptionInfo.exceptionTrace, v8ExceptionInfo.exceptionType, v8ExceptionInfo.filePath);
            this.bSa = i;
            if (this.bSj != null) {
                this.bSj.Yi();
            }
        }
    }

    public synchronized void Yh() {
        if (!this.bRY) {
            if (this.bSj == null || this.bRZ <= 0 || this.mV8ExceptionInfo == null) {
                android.util.Log.e("StuckScreenHandler", "[StuckScreen] 未设置冻屏监听器， 或者异常信息已经被清空（需等待下次上屏）。");
            } else if (System.currentTimeMillis() - this.mV8ExceptionInfo.exceptionTime > this.bSi && this.mV8ExceptionInfo.exceptionTime > this.bRZ) {
                this.bSj.a(new com.baidu.smallgame.sdk.b.b(this.bSa, this.mV8ExceptionInfo, this.bRZ));
                Yg();
            }
        }
    }

    public synchronized void c(boolean z, long j) {
        this.bRY = z;
        if (this.bRY) {
            this.bRZ = j;
            this.mV8ExceptionInfo = null;
        }
    }
}
