package com.baidu.ar.npc;

import android.os.Handler;
import android.os.Message;
import com.baidu.ar.npc.ArBridge;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class a implements Handler.Callback {
    final /* synthetic */ ArBridge a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(ArBridge arBridge) {
        this.a = arBridge;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        switch (message.what) {
            case 1:
                this.a.processIncomingMessage((ArBridge.b) message.obj);
                return false;
            default:
                return false;
        }
    }
}
