package com.baidu.adp.lib.asyncTask;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.asyncTask.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends Handler {
    final /* synthetic */ c iS;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(c cVar, Looper looper) {
        super(looper);
        this.iS = cVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (message.what == 1) {
            if (message.obj == null || !(message.obj instanceof c.a)) {
                return;
            }
            this.iS.b((c.a) message.obj);
        } else if (message.what == 2 && message.obj != null && (message.obj instanceof c.a)) {
            this.iS.e((c.a) message.obj);
            BdBaseApplication.getInst().isDebugMode();
        }
    }
}
