package com.baidu.adp.lib.network.websocket;

import android.os.Handler;
import android.os.Message;
/* loaded from: classes.dex */
final class a extends Handler {
    @Override // android.os.Handler
    public final void dispatchMessage(Message message) {
        e eVar;
        switch (message.what) {
            case 1:
                com.baidu.adp.lib.util.f.e("tcp建立和握手超时");
                BdSocketLinkService.a("tcp or websocket handshake timeout");
                eVar = BdSocketLinkService.b;
                eVar.a();
                return;
            default:
                return;
        }
    }
}
