package com.baidu.adp.framework.client.socket.link;

import android.os.Handler;
import com.baidu.adp.framework.client.socket.m;
import com.baidu.adp.lib.webSocket.r;
import java.util.Map;
/* loaded from: classes.dex */
class d extends r {
    @Override // com.baidu.adp.lib.webSocket.r, com.baidu.adp.lib.webSocket.l
    public void h(byte[] bArr) {
        g gVar;
        g gVar2;
        gVar = BdSocketLinkService.connStateCallBack;
        if (gVar != null) {
            gVar2 = BdSocketLinkService.connStateCallBack;
            gVar2.d(bArr);
        }
    }

    @Override // com.baidu.adp.lib.webSocket.r, com.baidu.adp.lib.webSocket.l
    public void j(String str) {
        g gVar;
        g gVar2;
        gVar = BdSocketLinkService.connStateCallBack;
        if (gVar != null) {
            gVar2 = BdSocketLinkService.connStateCallBack;
            gVar2.j(str);
        }
    }

    @Override // com.baidu.adp.lib.webSocket.r, com.baidu.adp.lib.webSocket.l
    public void a(com.baidu.adp.lib.webSocket.d dVar) {
        g gVar;
        g gVar2;
        gVar = BdSocketLinkService.connStateCallBack;
        if (gVar != null) {
            gVar2 = BdSocketLinkService.connStateCallBack;
            gVar2.a(dVar);
        }
    }

    @Override // com.baidu.adp.lib.webSocket.r, com.baidu.adp.lib.webSocket.l
    public void c(Map<String, String> map) {
        Handler handler;
        g gVar;
        g gVar2;
        m.a("linkservice", 0, 0, "onOpen", 0, "TiebaSocketLinkService:onOpen");
        m.aE();
        handler = BdSocketLinkService.mHandler;
        handler.removeMessages(1);
        gVar = BdSocketLinkService.connStateCallBack;
        if (gVar != null) {
            gVar2 = BdSocketLinkService.connStateCallBack;
            gVar2.b(map);
        }
    }

    @Override // com.baidu.adp.lib.webSocket.r, com.baidu.adp.lib.webSocket.l
    public void b(int i, String str) {
        Handler handler;
        g gVar;
        i iVar;
        g gVar2;
        boolean z = false;
        m.a("linkservice", 0, 0, "onClose", i, str);
        m.aE();
        handler = BdSocketLinkService.mHandler;
        handler.removeMessages(1);
        gVar = BdSocketLinkService.connStateCallBack;
        if (gVar != null) {
            gVar2 = BdSocketLinkService.connStateCallBack;
            z = gVar2.a(i, null);
        }
        if (!z && i != 1 && com.baidu.adp.lib.util.m.isNetOk()) {
            iVar = BdSocketLinkService.reConnStra;
            iVar.start("onClose:" + i + ":" + str);
        }
    }
}
