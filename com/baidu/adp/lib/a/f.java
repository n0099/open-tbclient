package com.baidu.adp.lib.a;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends Handler {
    private f() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ f(f fVar) {
        this();
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        d dVar = (d) message.obj;
        switch (message.what) {
            case 1:
                dVar.a.e(dVar.b[0]);
                return;
            case 2:
                dVar.a.b(dVar.b);
                return;
            default:
                return;
        }
    }
}
