package com.baidu.adp.lib.stats;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends Handler {
    final /* synthetic */ f a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar) {
        this.a = fVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        BdStatLog bdStatLog;
        BdDebugLog bdDebugLog;
        BdErrorLog bdErrorLog;
        switch (message.what) {
            case 1:
                this.a.b((BdStatBase) message.obj, message.arg1 > 0, message.arg2 > 0);
                return;
            case 2:
                f fVar = this.a;
                bdStatLog = this.a.w;
                fVar.a((BdStatBase) bdStatLog, true, true);
                f fVar2 = this.a;
                bdDebugLog = this.a.x;
                fVar2.a((BdStatBase) bdDebugLog, true, true);
                f fVar3 = this.a;
                bdErrorLog = this.a.y;
                fVar3.a((BdStatBase) bdErrorLog, true, true);
                this.a.n();
                return;
            case 3:
                this.a.c((BdStatBase) message.obj, message.arg1 > 0);
                return;
            case 4:
                this.a.b((BdStatBase) message.obj);
                return;
            default:
                return;
        }
    }
}
