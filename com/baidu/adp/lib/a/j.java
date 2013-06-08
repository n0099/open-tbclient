package com.baidu.adp.lib.a;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j extends Handler {
    final /* synthetic */ h a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(h hVar, Looper looper) {
        super(looper);
        this.a = hVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (message.what == 1) {
            if (message.obj == null || !(message.obj instanceof l)) {
                return;
            }
            this.a.b((l) message.obj);
        } else if (message.what == 2 && message.obj != null && (message.obj instanceof l)) {
            this.a.a((l) message.obj);
        }
    }
}
