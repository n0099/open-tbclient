package com.baidu.adp.lib.webSocket;

import android.os.Handler;
import android.os.Message;
import java.net.SocketException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class o extends Handler {
    final /* synthetic */ n a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar) {
        this.a = nVar;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        k kVar;
        k kVar2;
        k kVar3;
        k kVar4;
        k kVar5;
        k kVar6;
        k kVar7;
        k kVar8;
        k kVar9;
        k kVar10;
        boolean d;
        k kVar11;
        boolean d2;
        k kVar12;
        k kVar13;
        k kVar14;
        k kVar15;
        boolean d3;
        k kVar16;
        boolean d4;
        k kVar17;
        boolean d5;
        k kVar18;
        k kVar19;
        boolean d6;
        k kVar20;
        k kVar21;
        boolean d7;
        k kVar22;
        if (message.obj instanceof ak) {
            ak akVar = (ak) message.obj;
            kVar21 = this.a.n;
            if (kVar21 != null) {
                kVar22 = this.a.n;
                kVar22.a(akVar.a);
                return;
            }
            n nVar = this.a;
            d7 = com.baidu.adp.a.b.a().d();
            if (d7) {
                com.baidu.adp.lib.util.e.e("could not call onTextMessage() .. handler already NULL");
            }
        } else if (message.obj instanceof ae) {
            ae aeVar = (ae) message.obj;
            kVar19 = this.a.n;
            if (kVar19 != null) {
                kVar20 = this.a.n;
                kVar20.b(aeVar.a);
                return;
            }
            n nVar2 = this.a;
            d6 = com.baidu.adp.a.b.a().d();
            if (d6) {
                com.baidu.adp.lib.util.e.e("could not call onRawTextMessage() .. handler already NULL");
            }
        } else if (message.obj instanceof s) {
            s sVar = (s) message.obj;
            kVar17 = this.a.n;
            if (kVar17 != null) {
                kVar18 = this.a.n;
                kVar18.a(sVar.a);
                return;
            }
            n nVar3 = this.a;
            d5 = com.baidu.adp.a.b.a().d();
            if (d5) {
                com.baidu.adp.lib.util.e.e("could not call onBinaryMessage() .. handler already NULL");
            }
        } else if (message.obj instanceof ab) {
            ab abVar = (ab) message.obj;
            n nVar4 = this.a;
            d4 = com.baidu.adp.a.b.a().d();
            if (d4) {
                com.baidu.adp.lib.util.e.e("WebSockets Ping received");
            }
            ac acVar = new ac();
            acVar.a = abVar.a;
            this.a.c.a(acVar);
        } else if (message.obj instanceof ac) {
            Object obj = message.obj;
            kVar15 = this.a.n;
            if (kVar15 != null) {
                kVar16 = this.a.n;
                kVar16.a();
            }
            n nVar5 = this.a;
            d3 = com.baidu.adp.a.b.a().d();
            if (d3) {
                com.baidu.adp.lib.util.e.e("WebSockets Pong received");
            }
        } else if (message.obj instanceof u) {
            this.a.a(1, (String) null);
        } else if (message.obj instanceof ai) {
            ai aiVar = (ai) message.obj;
            n nVar6 = this.a;
            d = com.baidu.adp.a.b.a().d();
            if (d) {
                com.baidu.adp.lib.util.e.e("opening handshake received");
            }
            if (aiVar.a) {
                kVar11 = this.a.n;
                if (kVar11 != null) {
                    kVar12 = this.a.n;
                    kVar12.a(aiVar.b);
                    this.a.o = true;
                    this.a.p = false;
                    kVar13 = this.a.n;
                    if (kVar13 != null) {
                        kVar14 = this.a.n;
                        kVar14.a((d) null);
                        return;
                    }
                    return;
                }
                n nVar7 = this.a;
                d2 = com.baidu.adp.a.b.a().d();
                if (d2) {
                    com.baidu.adp.lib.util.e.e("could not call onOpen() .. handler already NULL");
                }
                this.a.a(6, "handler already NULL");
            }
        } else if (message.obj instanceof v) {
            SocketException socketException = ((v) message.obj).a;
            this.a.a(3, "WebSockets connection lost = " + (socketException != null ? socketException.getMessage() : null));
        } else if (message.obj instanceof ad) {
            WebSocketException webSocketException = ((ad) message.obj).a;
            this.a.a(4, "WebSockets protocol violation error = " + (webSocketException != null ? webSocketException.getMessage() : null));
        } else if (message.obj instanceof x) {
            this.a.a(5, "WebSockets internal error (" + ((x) message.obj).a.toString() + ")");
        } else if (message.obj instanceof ah) {
            ah ahVar = (ah) message.obj;
            this.a.a(6, "Server error " + ahVar.a + " (" + ahVar.b + ")");
        } else if (message.obj instanceof w) {
            this.a.a(2, "WebSockets connot connect");
        } else if (message.obj instanceof aj) {
            kVar9 = this.a.n;
            if (kVar9 != null) {
                d dVar = ((aj) message.obj).a;
                kVar10 = this.a.n;
                kVar10.b(dVar);
            }
        } else if (message.obj instanceof y) {
            this.a.r = null;
            d dVar2 = ((y) message.obj).a;
            kVar5 = this.a.n;
            if (kVar5 != null) {
                kVar8 = this.a.n;
                kVar8.c(dVar2);
            }
            kVar6 = this.a.n;
            if (kVar6 != null) {
                kVar7 = this.a.n;
                kVar7.a(dVar2);
            }
        } else if (message.obj instanceof af) {
            this.a.r = null;
            d dVar3 = ((af) message.obj).a;
            kVar = this.a.n;
            if (kVar != null) {
                kVar4 = this.a.n;
                kVar4.a(2, dVar3);
            }
            kVar2 = this.a.n;
            if (kVar2 != null) {
                kVar3 = this.a.n;
                kVar3.a(dVar3);
            }
        } else {
            n nVar8 = this.a;
            Object obj2 = message.obj;
        }
    }
}
