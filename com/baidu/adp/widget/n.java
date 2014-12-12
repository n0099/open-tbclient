package com.baidu.adp.widget;

import android.os.Handler;
import android.os.Message;
/* loaded from: classes.dex */
class n extends Handler {
    final /* synthetic */ m vN;

    private n(m mVar) {
        this.vN = mVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ n(m mVar, n nVar) {
        this(mVar);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        switch (message.what) {
            case 1000:
                m.a(this.vN);
                return;
            default:
                return;
        }
    }
}
