package com.baidu.adp.lib.webSocket;

import android.os.Handler;
import android.os.Message;
import java.net.SocketException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p extends Handler {
    final /* synthetic */ o a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(o oVar) {
        this.a = oVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        l lVar;
        l lVar2;
        l lVar3;
        l lVar4;
        l lVar5;
        l lVar6;
        l lVar7;
        l lVar8;
        l lVar9;
        l lVar10;
        boolean k;
        l lVar11;
        boolean k2;
        l lVar12;
        l lVar13;
        l lVar14;
        l lVar15;
        boolean k3;
        l lVar16;
        boolean k4;
        l lVar17;
        boolean k5;
        l lVar18;
        l lVar19;
        boolean k6;
        l lVar20;
        l lVar21;
        boolean k7;
        l lVar22;
        if (message.obj instanceof al) {
            al alVar = (al) message.obj;
            lVar21 = this.a.n;
            if (lVar21 != null) {
                lVar22 = this.a.n;
                lVar22.a(alVar.a);
                return;
            }
            k7 = this.a.k();
            if (k7) {
                com.baidu.adp.lib.util.f.e("could not call onTextMessage() .. handler already NULL");
            }
        } else if (message.obj instanceof af) {
            af afVar = (af) message.obj;
            lVar19 = this.a.n;
            if (lVar19 != null) {
                lVar20 = this.a.n;
                lVar20.b(afVar.a);
                return;
            }
            k6 = this.a.k();
            if (k6) {
                com.baidu.adp.lib.util.f.e("could not call onRawTextMessage() .. handler already NULL");
            }
        } else if (message.obj instanceof t) {
            t tVar = (t) message.obj;
            lVar17 = this.a.n;
            if (lVar17 != null) {
                lVar18 = this.a.n;
                lVar18.a(tVar.a);
                return;
            }
            k5 = this.a.k();
            if (k5) {
                com.baidu.adp.lib.util.f.e("could not call onBinaryMessage() .. handler already NULL");
            }
        } else if (message.obj instanceof ac) {
            ac acVar = (ac) message.obj;
            k4 = this.a.k();
            if (k4) {
                com.baidu.adp.lib.util.f.e("WebSockets Ping received");
            }
            ad adVar = new ad();
            adVar.a = acVar.a;
            this.a.c.a((Object) adVar);
        } else if (message.obj instanceof ad) {
            ad adVar2 = (ad) message.obj;
            lVar15 = this.a.n;
            if (lVar15 != null) {
                lVar16 = this.a.n;
                lVar16.a();
            }
            k3 = this.a.k();
            if (k3) {
                com.baidu.adp.lib.util.f.e("WebSockets Pong received");
            }
        } else if (message.obj instanceof v) {
            this.a.a(1, (String) null);
        } else if (message.obj instanceof aj) {
            aj ajVar = (aj) message.obj;
            k = this.a.k();
            if (k) {
                com.baidu.adp.lib.util.f.e("opening handshake received");
            }
            if (ajVar.a) {
                lVar11 = this.a.n;
                if (lVar11 != null) {
                    lVar12 = this.a.n;
                    lVar12.a(ajVar.b);
                    this.a.o = true;
                    this.a.p = false;
                    lVar13 = this.a.n;
                    if (lVar13 != null) {
                        lVar14 = this.a.n;
                        lVar14.a((d) null);
                        return;
                    }
                    return;
                }
                k2 = this.a.k();
                if (k2) {
                    com.baidu.adp.lib.util.f.e("could not call onOpen() .. handler already NULL");
                }
                this.a.a(6, "handler already NULL");
            }
        } else if (message.obj instanceof w) {
            SocketException socketException = ((w) message.obj).a;
            this.a.a(3, "WebSockets connection lost = " + (socketException != null ? socketException.getMessage() : null));
        } else if (message.obj instanceof ae) {
            WebSocketException webSocketException = ((ae) message.obj).a;
            this.a.a(4, "WebSockets protocol violation error = " + (webSocketException != null ? webSocketException.getMessage() : null));
        } else if (message.obj instanceof y) {
            this.a.a(5, "WebSockets internal error (" + ((y) message.obj).a.toString() + ")");
        } else if (message.obj instanceof ai) {
            ai aiVar = (ai) message.obj;
            this.a.a(6, "Server error " + aiVar.a + " (" + aiVar.b + ")");
        } else if (message.obj instanceof x) {
            this.a.a(2, "WebSockets connot connect");
        } else if (message.obj instanceof ak) {
            lVar9 = this.a.n;
            if (lVar9 != null) {
                d dVar = ((ak) message.obj).a;
                lVar10 = this.a.n;
                lVar10.b(dVar);
            }
        } else if (message.obj instanceof z) {
            this.a.r = null;
            d dVar2 = ((z) message.obj).a;
            lVar5 = this.a.n;
            if (lVar5 != null) {
                lVar8 = this.a.n;
                lVar8.c(dVar2);
            }
            lVar6 = this.a.n;
            if (lVar6 != null) {
                lVar7 = this.a.n;
                lVar7.a(dVar2);
            }
        } else if (message.obj instanceof ag) {
            this.a.r = null;
            d dVar3 = ((ag) message.obj).a;
            lVar = this.a.n;
            if (lVar != null) {
                lVar4 = this.a.n;
                lVar4.a(2, dVar3);
            }
            lVar2 = this.a.n;
            if (lVar2 != null) {
                lVar3 = this.a.n;
                lVar3.a(dVar3);
            }
        } else {
            this.a.a(message.obj);
        }
    }
}
