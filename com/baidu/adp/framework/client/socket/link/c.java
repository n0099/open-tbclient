package com.baidu.adp.framework.client.socket.link;

import android.os.Handler;
import com.baidu.adp.framework.client.socket.k;
import com.baidu.adp.lib.webSocket.l;
import java.util.Map;
/* loaded from: classes.dex */
class c extends l {
    @Override // com.baidu.adp.lib.webSocket.l, com.baidu.adp.lib.webSocket.g.a
    public void w(byte[] bArr) {
        e eVar;
        e eVar2;
        eVar = BdSocketLinkService.connStateCallBack;
        if (eVar != null) {
            eVar2 = BdSocketLinkService.connStateCallBack;
            eVar2.s(bArr);
        }
    }

    @Override // com.baidu.adp.lib.webSocket.l, com.baidu.adp.lib.webSocket.g.a
    public void I(String str) {
        e eVar;
        e eVar2;
        eVar = BdSocketLinkService.connStateCallBack;
        if (eVar != null) {
            eVar2 = BdSocketLinkService.connStateCallBack;
            eVar2.I(str);
        }
    }

    @Override // com.baidu.adp.lib.webSocket.l, com.baidu.adp.lib.webSocket.g.a
    public void a(com.baidu.adp.lib.webSocket.c cVar) {
        e eVar;
        e eVar2;
        eVar = BdSocketLinkService.connStateCallBack;
        if (eVar != null) {
            eVar2 = BdSocketLinkService.connStateCallBack;
            eVar2.a(cVar);
        }
    }

    @Override // com.baidu.adp.lib.webSocket.l, com.baidu.adp.lib.webSocket.g.a
    public void c(Map<String, String> map) {
        Handler handler;
        e eVar;
        e eVar2;
        k.a("linkservice", 0, 0, "onOpen", 0, "LinkService:onOpen");
        k.eE();
        handler = BdSocketLinkService.mHandler;
        handler.removeMessages(1);
        eVar = BdSocketLinkService.connStateCallBack;
        if (eVar != null) {
            eVar2 = BdSocketLinkService.connStateCallBack;
            eVar2.b(map);
        }
    }

    @Override // com.baidu.adp.lib.webSocket.l, com.baidu.adp.lib.webSocket.g.a
    public void l(int i, String str) {
        Handler handler;
        e eVar;
        h hVar;
        e eVar2;
        boolean z = false;
        k.a("linkservice", 0, 0, "onClose", i, str);
        k.eE();
        handler = BdSocketLinkService.mHandler;
        handler.removeMessages(1);
        eVar = BdSocketLinkService.connStateCallBack;
        if (eVar != null) {
            eVar2 = BdSocketLinkService.connStateCallBack;
            z = eVar2.k(i, null);
        }
        if (!z && i != 1 && com.baidu.adp.lib.util.k.jc()) {
            hVar = BdSocketLinkService.reConnStra;
            hVar.start("onClose:" + i + ":" + str);
        }
    }
}
