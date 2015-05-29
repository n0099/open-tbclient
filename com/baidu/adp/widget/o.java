package com.baidu.adp.widget;

import android.os.Handler;
import android.os.Message;
/* loaded from: classes.dex */
class o extends Handler {
    final /* synthetic */ n GF;

    private o(n nVar) {
        this.GF = nVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ o(n nVar, o oVar) {
        this(nVar);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        switch (message.what) {
            case 1000:
                n.a(this.GF);
                return;
            default:
                return;
        }
    }
}
