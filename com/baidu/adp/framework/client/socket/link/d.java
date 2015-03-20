package com.baidu.adp.framework.client.socket.link;

import android.os.Handler;
import com.baidu.adp.framework.client.socket.m;
import com.baidu.adp.lib.util.n;
import com.baidu.adp.lib.webSocket.q;
import java.util.Map;
/* loaded from: classes.dex */
class d extends q {
    @Override // com.baidu.adp.lib.webSocket.q, com.baidu.adp.lib.webSocket.k
    public void j(byte[] bArr) {
        g gVar;
        g gVar2;
        gVar = BdSocketLinkService.connStateCallBack;
        if (gVar != null) {
            gVar2 = BdSocketLinkService.connStateCallBack;
            gVar2.e(bArr);
        }
    }

    @Override // com.baidu.adp.lib.webSocket.q, com.baidu.adp.lib.webSocket.k
    public void G(String str) {
        g gVar;
        g gVar2;
        gVar = BdSocketLinkService.connStateCallBack;
        if (gVar != null) {
            gVar2 = BdSocketLinkService.connStateCallBack;
            gVar2.G(str);
        }
    }

    @Override // com.baidu.adp.lib.webSocket.q, com.baidu.adp.lib.webSocket.k
    public void a(com.baidu.adp.lib.webSocket.c cVar) {
        g gVar;
        g gVar2;
        gVar = BdSocketLinkService.connStateCallBack;
        if (gVar != null) {
            gVar2 = BdSocketLinkService.connStateCallBack;
            gVar2.a(cVar);
        }
    }

    @Override // com.baidu.adp.lib.webSocket.q, com.baidu.adp.lib.webSocket.k
    public void d(Map<String, String> map) {
        Handler handler;
        g gVar;
        g gVar2;
        m.a("linkservice", 0, 0, "onOpen", 0, "TiebaSocketLinkService:onOpen");
        m.eB();
        handler = BdSocketLinkService.mHandler;
        handler.removeMessages(1);
        gVar = BdSocketLinkService.connStateCallBack;
        if (gVar != null) {
            gVar2 = BdSocketLinkService.connStateCallBack;
            gVar2.c(map);
        }
    }

    @Override // com.baidu.adp.lib.webSocket.q, com.baidu.adp.lib.webSocket.k
    public void l(int i, String str) {
        Handler handler;
        g gVar;
        j jVar;
        g gVar2;
        boolean z = false;
        m.a("linkservice", 0, 0, "onClose", i, str);
        m.eB();
        handler = BdSocketLinkService.mHandler;
        handler.removeMessages(1);
        gVar = BdSocketLinkService.connStateCallBack;
        if (gVar != null) {
            gVar2 = BdSocketLinkService.connStateCallBack;
            z = gVar2.k(i, null);
        }
        if (!z && i != 1 && n.isNetOk()) {
            jVar = BdSocketLinkService.reConnStra;
            jVar.start("onClose:" + i + ":" + str);
        }
    }
}
