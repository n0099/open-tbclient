package com.baidu.adp.lib.asyncTask;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class d extends Handler {
    private d() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ d(byte b) {
        this();
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        c cVar = (c) message.obj;
        switch (message.what) {
            case 1:
                BdAsyncTask.a(cVar.a, cVar.b[0]);
                return;
            case 2:
                cVar.a.b((Object[]) cVar.b);
                return;
            default:
                return;
        }
    }
}
