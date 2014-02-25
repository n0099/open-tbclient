package com.baidu.adp.lib.network.a;

import android.os.Handler;
import android.os.Message;
/* loaded from: classes.dex */
class b extends Handler {
    @Override // android.os.Handler
    public void dispatchMessage(Message message) {
        f fVar;
        switch (message.what) {
            case 1:
                com.baidu.adp.lib.util.f.e("tcp建立和握手超时");
                a.a("tcp or websocket handshake timeout");
                fVar = a.b;
                fVar.a("tcp or websocket handshake timeout");
                return;
            default:
                return;
        }
    }
}
