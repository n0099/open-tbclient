package com.baidu.adp.lib.asyncTask;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends Handler {
    final /* synthetic */ f a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(f fVar, Looper looper) {
        super(looper);
        this.a = fVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (message.what == 1) {
            if (message.obj == null || !(message.obj instanceof j)) {
                return;
            }
            this.a.b((j) message.obj);
        } else if (message.what == 2 && message.obj != null && (message.obj instanceof j)) {
            this.a.a((j) message.obj);
        }
    }
}
