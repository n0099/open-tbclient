package com.baidu.adp.framework.client.socket.link;

import android.os.Handler;
import com.baidu.adp.framework.client.socket.k;
import com.baidu.adp.lib.webSocket.l;
import com.baidu.adp.lib.webSocket.m;
import java.util.Map;
/* loaded from: classes.dex */
class c extends l {
    @Override // com.baidu.adp.lib.webSocket.l, com.baidu.adp.lib.webSocket.g.a
    public void b(m.a aVar) {
        e eVar;
        e eVar2;
        eVar = BdSocketLinkService.connStateCallBack;
        if (eVar != null) {
            eVar2 = BdSocketLinkService.connStateCallBack;
            eVar2.a(aVar);
        }
    }

    @Override // com.baidu.adp.lib.webSocket.l, com.baidu.adp.lib.webSocket.g.a
    public void y(String str) {
        e eVar;
        e eVar2;
        eVar = BdSocketLinkService.connStateCallBack;
        if (eVar != null) {
            eVar2 = BdSocketLinkService.connStateCallBack;
            eVar2.y(str);
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
    public void e(Map<String, String> map) {
        Handler handler;
        e eVar;
        e eVar2;
        k.a("linkservice", 0, 0, "onOpen", 0, "LinkService:onOpen");
        k.aY();
        handler = BdSocketLinkService.mHandler;
        handler.removeMessages(1);
        eVar = BdSocketLinkService.connStateCallBack;
        if (eVar != null) {
            eVar2 = BdSocketLinkService.connStateCallBack;
            eVar2.d(map);
        }
    }

    @Override // com.baidu.adp.lib.webSocket.l, com.baidu.adp.lib.webSocket.g.a
    public void e(int i, String str) {
        Handler handler;
        e eVar;
        h hVar;
        e eVar2;
        boolean z = false;
        k.a("linkservice", 0, 0, "onClose", i, str);
        if (i == 6 || i == 5 || i == 2 || i == 3 || i == 4) {
            k.aY();
        }
        handler = BdSocketLinkService.mHandler;
        handler.removeMessages(1);
        eVar = BdSocketLinkService.connStateCallBack;
        if (eVar != null) {
            eVar2 = BdSocketLinkService.connStateCallBack;
            z = eVar2.d(i, null);
        }
        if (!z && i != 1 && com.baidu.adp.lib.util.k.fI()) {
            hVar = BdSocketLinkService.reConnStra;
            hVar.start("onClose:" + i + ":" + str);
        }
    }
}
