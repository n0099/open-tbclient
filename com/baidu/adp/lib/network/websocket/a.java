package com.baidu.adp.lib.network.websocket;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
class a extends Handler {
    @Override // android.os.Handler
    public void dispatchMessage(Message message) {
        e eVar;
        switch (message.what) {
            case 1:
                BdLog.d("tcp建立和握手超时");
                BdSocketLinkService.a("tcp or websocket handshake timeout");
                eVar = BdSocketLinkService.b;
                eVar.a("tcp or websocket handshake timeout");
                return;
            default:
                return;
        }
    }
}
