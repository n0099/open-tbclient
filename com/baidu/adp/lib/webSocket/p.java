package com.baidu.adp.lib.webSocket;

import android.os.Handler;
import android.os.Message;
import java.net.SocketException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p extends Handler {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ o f543a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(o oVar) {
        this.f543a = oVar;
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
        boolean k3;
        l lVar15;
        boolean k4;
        l lVar16;
        boolean k5;
        l lVar17;
        l lVar18;
        boolean k6;
        l lVar19;
        l lVar20;
        boolean k7;
        l lVar21;
        if (message.obj instanceof al) {
            al alVar = (al) message.obj;
            lVar20 = this.f543a.n;
            if (lVar20 != null) {
                lVar21 = this.f543a.n;
                lVar21.a(alVar.f530a);
                return;
            }
            k7 = this.f543a.k();
            if (k7) {
                com.baidu.adp.lib.h.e.d("could not call onTextMessage() .. handler already NULL");
            }
        } else if (message.obj instanceof af) {
            af afVar = (af) message.obj;
            lVar18 = this.f543a.n;
            if (lVar18 != null) {
                lVar19 = this.f543a.n;
                lVar19.a(afVar.f526a);
                return;
            }
            k6 = this.f543a.k();
            if (k6) {
                com.baidu.adp.lib.h.e.d("could not call onRawTextMessage() .. handler already NULL");
            }
        } else if (message.obj instanceof t) {
            t tVar = (t) message.obj;
            lVar16 = this.f543a.n;
            if (lVar16 != null) {
                lVar17 = this.f543a.n;
                lVar17.b(tVar.f545a);
                return;
            }
            k5 = this.f543a.k();
            if (k5) {
                com.baidu.adp.lib.h.e.d("could not call onBinaryMessage() .. handler already NULL");
            }
        } else if (message.obj instanceof ac) {
            ac acVar = (ac) message.obj;
            k4 = this.f543a.k();
            if (k4) {
                com.baidu.adp.lib.h.e.d("WebSockets Ping received");
            }
            ad adVar = new ad();
            adVar.f524a = acVar.f523a;
            this.f543a.c.a((Object) adVar);
        } else if (message.obj instanceof ad) {
            ad adVar2 = (ad) message.obj;
            lVar14 = this.f543a.n;
            if (lVar14 != null) {
                lVar15 = this.f543a.n;
                lVar15.a();
            }
            k3 = this.f543a.k();
            if (k3) {
                com.baidu.adp.lib.h.e.d("WebSockets Pong received");
            }
        } else if (message.obj instanceof v) {
            this.f543a.a(1, (String) null);
        } else if (message.obj instanceof aj) {
            aj ajVar = (aj) message.obj;
            k = this.f543a.k();
            if (k) {
                com.baidu.adp.lib.h.e.d("opening handshake received");
            }
            if (ajVar.f529a) {
                lVar11 = this.f543a.n;
                if (lVar11 != null) {
                    lVar12 = this.f543a.n;
                    lVar12.a(ajVar.b);
                    this.f543a.o = true;
                    this.f543a.p = false;
                    lVar13 = this.f543a.n;
                    lVar13.a((d) null);
                    return;
                }
                k2 = this.f543a.k();
                if (k2) {
                    com.baidu.adp.lib.h.e.d("could not call onOpen() .. handler already NULL");
                }
                this.f543a.a(6, "handler already NULL");
            }
        } else if (message.obj instanceof w) {
            SocketException socketException = ((w) message.obj).f548a;
            this.f543a.a(3, "WebSockets connection lost = " + (socketException != null ? socketException.getMessage() : null));
        } else if (message.obj instanceof ae) {
            WebSocketException webSocketException = ((ae) message.obj).f525a;
            this.f543a.a(4, "WebSockets protocol violation error = " + (webSocketException != null ? webSocketException.getMessage() : null));
        } else if (message.obj instanceof y) {
            this.f543a.a(5, "WebSockets internal error (" + ((y) message.obj).f549a.toString() + ")");
        } else if (message.obj instanceof ai) {
            ai aiVar = (ai) message.obj;
            this.f543a.a(6, "Server error " + aiVar.f528a + " (" + aiVar.b + ")");
        } else if (message.obj instanceof x) {
            this.f543a.a(2, "WebSockets connot connect");
        } else if (message.obj instanceof ak) {
            lVar9 = this.f543a.n;
            if (lVar9 != null) {
                d dVar = ((ak) message.obj).f527a;
                lVar10 = this.f543a.n;
                lVar10.b(dVar);
            }
        } else if (message.obj instanceof z) {
            this.f543a.r = null;
            d dVar2 = ((z) message.obj).f527a;
            lVar5 = this.f543a.n;
            if (lVar5 != null) {
                lVar8 = this.f543a.n;
                lVar8.c(dVar2);
            }
            lVar6 = this.f543a.n;
            if (lVar6 != null) {
                lVar7 = this.f543a.n;
                lVar7.a(dVar2);
            }
        } else if (message.obj instanceof ag) {
            this.f543a.r = null;
            d dVar3 = ((ag) message.obj).f527a;
            lVar = this.f543a.n;
            if (lVar != null) {
                lVar4 = this.f543a.n;
                lVar4.a(2, dVar3);
            }
            lVar2 = this.f543a.n;
            if (lVar2 != null) {
                lVar3 = this.f543a.n;
                lVar3.a(dVar3);
            }
        } else {
            this.f543a.a(message.obj);
        }
    }
}
