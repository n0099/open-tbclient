package com.baidu.adp.lib.stats;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends Handler {
    final /* synthetic */ d a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.a = dVar;
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
                d dVar = this.a;
                bdStatLog = this.a.v;
                dVar.a((BdStatBase) bdStatLog, true, true);
                d dVar2 = this.a;
                bdDebugLog = this.a.w;
                dVar2.a((BdStatBase) bdDebugLog, true, true);
                d dVar3 = this.a;
                bdErrorLog = this.a.x;
                dVar3.a((BdStatBase) bdErrorLog, true, true);
                this.a.m();
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
