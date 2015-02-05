package com.baidu.tbadk.cdnOptimize;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j extends Handler {
    final /* synthetic */ h BN;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(h hVar, Looper looper) {
        super(looper);
        this.BN = hVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (10001 == message.what) {
            this.BN.lu();
        } else if (10002 == message.what) {
            this.BN.lw();
        }
    }
}
