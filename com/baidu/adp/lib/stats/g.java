package com.baidu.adp.lib.stats;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends Handler {
    final /* synthetic */ f this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar) {
        this.this$0 = fVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        BdStatLog bdStatLog;
        BdDebugLog bdDebugLog;
        BdErrorLog bdErrorLog;
        BdPerformanceLog bdPerformanceLog;
        switch (message.what) {
            case 1:
                this.this$0.b((BdStatBase) message.obj, message.arg1 > 0, message.arg2 > 0);
                return;
            case 2:
                f fVar = this.this$0;
                bdStatLog = this.this$0.mc;
                fVar.a((BdStatBase) bdStatLog, true, true);
                f fVar2 = this.this$0;
                bdDebugLog = this.this$0.md;
                fVar2.a((BdStatBase) bdDebugLog, true, true);
                f fVar3 = this.this$0;
                bdErrorLog = this.this$0.mf;
                fVar3.a((BdStatBase) bdErrorLog, true, true);
                f fVar4 = this.this$0;
                bdPerformanceLog = this.this$0.mg;
                fVar4.a((BdStatBase) bdPerformanceLog, true, true);
                this.this$0.ex();
                return;
            case 3:
                this.this$0.c((BdStatBase) message.obj, message.arg1 > 0);
                return;
            case 4:
                this.this$0.b((BdStatBase) message.obj);
                return;
            default:
                return;
        }
    }
}
