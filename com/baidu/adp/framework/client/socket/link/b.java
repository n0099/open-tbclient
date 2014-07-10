package com.baidu.adp.framework.client.socket.link;

import android.os.Handler;
import com.baidu.adp.framework.client.socket.m;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.webSocket.r;
import java.util.Map;
/* loaded from: classes.dex */
class b extends r {
    @Override // com.baidu.adp.lib.webSocket.r, com.baidu.adp.lib.webSocket.l
    public void a(byte[] bArr) {
        c cVar;
        c cVar2;
        cVar = BdSocketLinkService.connStateCallBack;
        if (cVar != null) {
            cVar2 = BdSocketLinkService.connStateCallBack;
            cVar2.a(bArr);
        }
    }

    @Override // com.baidu.adp.lib.webSocket.r, com.baidu.adp.lib.webSocket.l
    public void a(String str) {
        c cVar;
        c cVar2;
        cVar = BdSocketLinkService.connStateCallBack;
        if (cVar != null) {
            cVar2 = BdSocketLinkService.connStateCallBack;
            cVar2.a(str);
        }
    }

    @Override // com.baidu.adp.lib.webSocket.r, com.baidu.adp.lib.webSocket.l
    public void a(com.baidu.adp.lib.webSocket.d dVar) {
        c cVar;
        c cVar2;
        cVar = BdSocketLinkService.connStateCallBack;
        if (cVar != null) {
            cVar2 = BdSocketLinkService.connStateCallBack;
            cVar2.a(dVar);
        }
    }

    @Override // com.baidu.adp.lib.webSocket.r, com.baidu.adp.lib.webSocket.l
    public void a(Map<String, String> map) {
        Handler handler;
        c cVar;
        c cVar2;
        m.a("linkservice", 0, 0, "onOpen", 0, "TiebaSocketLinkService:onOpen");
        m.a();
        handler = BdSocketLinkService.mHandler;
        handler.removeMessages(1);
        cVar = BdSocketLinkService.connStateCallBack;
        if (cVar != null) {
            cVar2 = BdSocketLinkService.connStateCallBack;
            cVar2.a(map);
        }
    }

    @Override // com.baidu.adp.lib.webSocket.r, com.baidu.adp.lib.webSocket.l
    public void a(int i, String str) {
        Handler handler;
        c cVar;
        e eVar;
        c cVar2;
        boolean z = false;
        m.a("linkservice", 0, 0, "onClose", i, str);
        m.a();
        handler = BdSocketLinkService.mHandler;
        handler.removeMessages(1);
        cVar = BdSocketLinkService.connStateCallBack;
        if (cVar != null) {
            cVar2 = BdSocketLinkService.connStateCallBack;
            z = cVar2.a(i, null);
        }
        if (!z && i != 1 && j.c()) {
            eVar = BdSocketLinkService.reConnStra;
            eVar.a("onClose:" + i + ":" + str);
        }
    }
}
