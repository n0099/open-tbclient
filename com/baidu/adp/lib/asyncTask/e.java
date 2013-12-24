package com.baidu.adp.lib.asyncTask;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends Handler {
    private e() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ e(a aVar) {
        this();
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        d dVar = (d) message.obj;
        switch (message.what) {
            case 1:
                dVar.a.d(dVar.b[0]);
                return;
            case 2:
                dVar.a.b((Object[]) dVar.b);
                return;
            default:
                return;
        }
    }
}
