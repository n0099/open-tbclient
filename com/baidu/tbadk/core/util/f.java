package com.baidu.tbadk.core.util;

import android.os.Handler;
import android.os.Message;
/* loaded from: classes.dex */
class f extends Handler {
    final /* synthetic */ e Dg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.Dg = eVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        switch (message.what) {
            case 0:
                this.Dg.b(message.arg1, (String) message.obj);
                return;
            case 1:
                this.Dg.e(message.arg1, (String) message.obj);
                return;
            default:
                return;
        }
    }
}
