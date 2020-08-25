package com.baidu.mapsdkplatform.comapi.map;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes20.dex */
public class o extends Handler {
    final /* synthetic */ n a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar) {
        this.a = nVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        n nVar;
        s sVar;
        super.handleMessage(message);
        nVar = n.c;
        if (nVar != null) {
            sVar = this.a.d;
            sVar.a(message);
        }
    }
}
