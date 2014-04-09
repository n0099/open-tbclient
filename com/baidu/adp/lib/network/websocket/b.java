package com.baidu.adp.lib.network.websocket;

import android.os.Handler;
import com.baidu.adp.lib.webSocket.q;
import java.util.Map;
/* loaded from: classes.dex */
final class b extends q {
    @Override // com.baidu.adp.lib.webSocket.q, com.baidu.adp.lib.webSocket.k
    public final void a(byte[] bArr) {
        c cVar;
        c cVar2;
        cVar = BdSocketLinkService.c;
        if (cVar != null) {
            cVar2 = BdSocketLinkService.c;
            cVar2.a(bArr);
        }
    }

    @Override // com.baidu.adp.lib.webSocket.q, com.baidu.adp.lib.webSocket.k
    public final void a(String str) {
        c cVar;
        c cVar2;
        cVar = BdSocketLinkService.c;
        if (cVar != null) {
            cVar2 = BdSocketLinkService.c;
            cVar2.a(str);
        }
    }

    @Override // com.baidu.adp.lib.webSocket.q, com.baidu.adp.lib.webSocket.k
    public final void a(com.baidu.adp.lib.webSocket.d dVar) {
        c cVar;
        c cVar2;
        cVar = BdSocketLinkService.c;
        if (cVar != null) {
            cVar2 = BdSocketLinkService.c;
            cVar2.a(dVar);
        }
    }

    @Override // com.baidu.adp.lib.webSocket.q, com.baidu.adp.lib.webSocket.k
    public final void a(Map<String, String> map) {
        Handler handler;
        c cVar;
        c cVar2;
        j.a().b();
        handler = BdSocketLinkService.d;
        handler.removeMessages(1);
        cVar = BdSocketLinkService.c;
        if (cVar != null) {
            cVar2 = BdSocketLinkService.c;
            cVar2.a(map);
        }
    }

    @Override // com.baidu.adp.lib.webSocket.q, com.baidu.adp.lib.webSocket.k
    public final void a(int i, String str) {
        Handler handler;
        c cVar;
        e eVar;
        c cVar2;
        handler = BdSocketLinkService.d;
        handler.removeMessages(1);
        cVar = BdSocketLinkService.c;
        if (cVar != null) {
            if (i != 0) {
                if (com.baidu.adp.framework.e.c.a().i() != null) {
                    com.baidu.adp.framework.e.c.a().i().a("TiebaSocketLinkService", "close():" + str, i, (com.baidu.adp.framework.message.d<?>) null);
                }
                str = "你的网络状况不大好，请稍后重试";
            }
            cVar2 = BdSocketLinkService.c;
            cVar2.a(i, str);
        }
        if (com.baidu.adp.lib.util.i.d()) {
            eVar = BdSocketLinkService.b;
            String str2 = "onClose:" + i + ":" + str;
            eVar.a();
        }
    }
}
