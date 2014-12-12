package com.baidu.adp.lib.asyncTask;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends Handler {
    public d(Looper looper) {
        super(looper);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        c cVar = (c) message.obj;
        switch (message.what) {
            case 1:
                cVar.gQ.finish(cVar.mData[0]);
                return;
            case 2:
                cVar.gQ.onProgressUpdate(cVar.mData);
                return;
            default:
                return;
        }
    }
}
