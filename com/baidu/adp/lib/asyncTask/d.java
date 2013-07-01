package com.baidu.adp.lib.asyncTask;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends Handler {
    private d() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ d(d dVar) {
        this();
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        c cVar = (c) message.obj;
        switch (message.what) {
            case 1:
                cVar.f126a.d(cVar.b[0]);
                return;
            case 2:
                cVar.f126a.b(cVar.b);
                return;
            default:
                return;
        }
    }
}
