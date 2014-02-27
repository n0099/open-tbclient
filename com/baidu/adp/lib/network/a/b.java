package com.baidu.adp.lib.network.a;

import android.os.Handler;
import android.os.Message;
/* loaded from: classes.dex */
final class b extends Handler {
    @Override // android.os.Handler
    public final void dispatchMessage(Message message) {
        f fVar;
        switch (message.what) {
            case 1:
                com.baidu.adp.lib.util.e.e("tcp建立和握手超时");
                a.a("tcp or websocket handshake timeout");
                fVar = a.b;
                fVar.a();
                return;
            default:
                return;
        }
    }
}
