package com.baidu.adp.lib.asyncTask;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends Handler {
    final /* synthetic */ f a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(f fVar) {
        this.a = fVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (message.what == 1) {
            if (message.obj == null || !(message.obj instanceof j)) {
                return;
            }
            this.a.c((j) message.obj);
        } else if (message.what == 2 && message.obj != null && (message.obj instanceof j)) {
            this.a.a((j) message.obj);
            if (BdBaseApplication.getInst().isDebugMode()) {
                BdLog.d(this.a.toString());
            }
        }
    }
}
