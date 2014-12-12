package com.baidu.adp.lib.asyncTask;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.adp.base.BdBaseApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends Handler {
    final /* synthetic */ f hc;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(f fVar, Looper looper) {
        super(looper);
        this.hc = fVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (message.what == 1) {
            if (message.obj == null || !(message.obj instanceof j)) {
                return;
            }
            this.hc.b((j) message.obj);
        } else if (message.what == 2 && message.obj != null && (message.obj instanceof j)) {
            this.hc.e((j) message.obj);
            BdBaseApplication.getInst().isDebugMode();
        }
    }
}
