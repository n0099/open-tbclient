package com.baidu.adp.framework.client.socket.link;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
class a extends Handler {
    /* JADX INFO: Access modifiers changed from: package-private */
    public a(Looper looper) {
        super(looper);
    }

    @Override // android.os.Handler
    public void dispatchMessage(Message message) {
        d dVar;
        switch (message.what) {
            case 1:
                BdLog.d("tcp建立和握手超时");
                BdSocketLinkService.close(9, "connect timeout");
                dVar = BdSocketLinkService.reConnStra;
                dVar.a("tcp or websocket handshake timeout");
                return;
            default:
                return;
        }
    }
}
