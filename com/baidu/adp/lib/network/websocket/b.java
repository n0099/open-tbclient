package com.baidu.adp.lib.network.websocket;

import android.os.Handler;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.lib.webSocket.r;
import java.util.Map;
/* loaded from: classes.dex */
class b extends r {
    @Override // com.baidu.adp.lib.webSocket.r, com.baidu.adp.lib.webSocket.l
    public void a(byte[] bArr) {
        c cVar;
        c cVar2;
        cVar = BdSocketLinkService.c;
        if (cVar != null) {
            cVar2 = BdSocketLinkService.c;
            cVar2.a(bArr);
        }
    }

    @Override // com.baidu.adp.lib.webSocket.r, com.baidu.adp.lib.webSocket.l
    public void a(String str) {
        c cVar;
        c cVar2;
        cVar = BdSocketLinkService.c;
        if (cVar != null) {
            cVar2 = BdSocketLinkService.c;
            cVar2.a(str);
        }
    }

    @Override // com.baidu.adp.lib.webSocket.r, com.baidu.adp.lib.webSocket.l
    public void a(com.baidu.adp.lib.webSocket.d dVar) {
        c cVar;
        c cVar2;
        cVar = BdSocketLinkService.c;
        if (cVar != null) {
            cVar2 = BdSocketLinkService.c;
            cVar2.a(dVar);
        }
    }

    @Override // com.baidu.adp.lib.webSocket.r, com.baidu.adp.lib.webSocket.l
    public void a(Map<String, String> map) {
        Handler handler;
        c cVar;
        c cVar2;
        j.a().c();
        handler = BdSocketLinkService.d;
        handler.removeMessages(1);
        cVar = BdSocketLinkService.c;
        if (cVar != null) {
            cVar2 = BdSocketLinkService.c;
            cVar2.a(map);
        }
    }

    @Override // com.baidu.adp.lib.webSocket.r, com.baidu.adp.lib.webSocket.l
    public void a(int i, String str) {
        Handler handler;
        c cVar;
        e eVar;
        c cVar2;
        handler = BdSocketLinkService.d;
        handler.removeMessages(1);
        boolean z = false;
        cVar = BdSocketLinkService.c;
        if (cVar != null) {
            if (i != 0 && com.baidu.adp.framework.c.c.a().i() != null) {
                com.baidu.adp.framework.c.c.a().i().a("TiebaSocketLinkService", "close():" + str, i, (Message<?>) null);
            }
            cVar2 = BdSocketLinkService.c;
            z = cVar2.a(i, str);
        }
        if (!z && com.baidu.adp.lib.util.h.d()) {
            eVar = BdSocketLinkService.b;
            eVar.a("onClose:" + i + ":" + str);
        }
    }
}
