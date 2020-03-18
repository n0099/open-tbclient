package com.baidu.smallgame.sdk;

import com.baidu.searchbox.v8engine.V8ExceptionInfo;
import com.baidu.smallgame.sdk.b.c;
/* loaded from: classes11.dex */
class b extends c {
    private boolean aZe = false;
    private long aZf;
    private int aZg;
    private V8ExceptionInfo mV8ExceptionInfo;

    private void Gi() {
        this.mV8ExceptionInfo = null;
        this.aZf = 0L;
        this.aZg = -1;
    }

    @Override // com.baidu.smallgame.sdk.b.c
    public synchronized void a(int i, V8ExceptionInfo v8ExceptionInfo) {
        if (this.mV8ExceptionInfo == null && v8ExceptionInfo != null) {
            this.mV8ExceptionInfo = new V8ExceptionInfo(v8ExceptionInfo.exceptionTime, v8ExceptionInfo.exceptionMsg, v8ExceptionInfo.exceptionTrace, v8ExceptionInfo.exceptionType, v8ExceptionInfo.filePath);
            this.aZg = i;
            if (this.aZp != null) {
                this.aZp.Gk();
            }
        }
    }

    public synchronized void Gj() {
        if (!this.aZe) {
            if (this.aZp == null || this.aZf <= 0 || this.mV8ExceptionInfo == null) {
                android.util.Log.e("StuckScreenHandler", "[StuckScreen] 未设置冻屏监听器， 或者异常信息已经被清空（需等待下次上屏）。");
            } else if (System.currentTimeMillis() - this.mV8ExceptionInfo.exceptionTime > this.aZo && this.mV8ExceptionInfo.exceptionTime > this.aZf) {
                this.aZp.a(new com.baidu.smallgame.sdk.b.b(this.aZg, this.mV8ExceptionInfo, this.aZf));
                Gi();
            }
        }
    }

    public synchronized void b(boolean z, long j) {
        this.aZe = z;
        if (this.aZe) {
            this.aZf = j;
            this.mV8ExceptionInfo = null;
        }
    }
}
