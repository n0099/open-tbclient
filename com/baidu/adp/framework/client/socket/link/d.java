package com.baidu.adp.framework.client.socket.link;

import android.os.Handler;
import com.baidu.adp.framework.client.socket.m;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.lib.webSocket.r;
import java.util.Map;
/* loaded from: classes.dex */
class d extends r {
    @Override // com.baidu.adp.lib.webSocket.r, com.baidu.adp.lib.webSocket.l
    public void i(byte[] bArr) {
        g gVar;
        g gVar2;
        gVar = BdSocketLinkService.connStateCallBack;
        if (gVar != null) {
            gVar2 = BdSocketLinkService.connStateCallBack;
            gVar2.e(bArr);
        }
    }

    @Override // com.baidu.adp.lib.webSocket.r, com.baidu.adp.lib.webSocket.l
    public void y(String str) {
        g gVar;
        g gVar2;
        gVar = BdSocketLinkService.connStateCallBack;
        if (gVar != null) {
            gVar2 = BdSocketLinkService.connStateCallBack;
            gVar2.y(str);
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
    public void d(Map<String, String> map) {
        Handler handler;
        g gVar;
        g gVar2;
        m.a("linkservice", 0, 0, "onOpen", 0, "TiebaSocketLinkService:onOpen");
        m.be();
        handler = BdSocketLinkService.mHandler;
        handler.removeMessages(1);
        gVar = BdSocketLinkService.connStateCallBack;
        if (gVar != null) {
            gVar2 = BdSocketLinkService.connStateCallBack;
            gVar2.c(map);
        }
    }

    @Override // com.baidu.adp.lib.webSocket.r, com.baidu.adp.lib.webSocket.l
    public void l(int i, String str) {
        Handler handler;
        g gVar;
        i iVar;
        g gVar2;
        boolean z = false;
        m.a("linkservice", 0, 0, "onClose", i, str);
        m.be();
        handler = BdSocketLinkService.mHandler;
        handler.removeMessages(1);
        gVar = BdSocketLinkService.connStateCallBack;
        if (gVar != null) {
            gVar2 = BdSocketLinkService.connStateCallBack;
            z = gVar2.k(i, null);
        }
        if (!z && i != 1 && l.isNetOk()) {
            iVar = BdSocketLinkService.reConnStra;
            iVar.start("onClose:" + i + ":" + str);
        }
    }
}
