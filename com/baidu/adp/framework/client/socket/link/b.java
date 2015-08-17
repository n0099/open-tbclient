package com.baidu.adp.framework.client.socket.link;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
class b extends Handler {
    /* JADX INFO: Access modifiers changed from: package-private */
    public b(Looper looper) {
        super(looper);
    }

    @Override // android.os.Handler
    public void dispatchMessage(Message message) {
        h hVar;
        switch (message.what) {
            case 1:
                BdLog.w("tcp建立和握手超时");
                BdSocketLinkService.close(9, "connect timeout");
                hVar = BdSocketLinkService.reConnStra;
                hVar.start("tcp or websocket handshake timeout");
                return;
            default:
                return;
        }
    }
}
