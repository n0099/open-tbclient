package com.baidu.adp.lib.webSocket;

import android.os.Handler;
import android.os.Message;
import java.net.SocketException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o extends Handler {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ n f539a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar) {
        this.f539a = nVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        k kVar;
        am amVar;
        k kVar2;
        k kVar3;
        k kVar4;
        am amVar2;
        k kVar5;
        k kVar6;
        am amVar3;
        boolean k;
        k kVar7;
        boolean k2;
        k kVar8;
        k kVar9;
        k kVar10;
        boolean k3;
        k kVar11;
        boolean k4;
        k kVar12;
        boolean k5;
        k kVar13;
        k kVar14;
        boolean k6;
        k kVar15;
        k kVar16;
        boolean k7;
        k kVar17;
        if (message.obj instanceof ah) {
            ah ahVar = (ah) message.obj;
            kVar16 = this.f539a.n;
            if (kVar16 != null) {
                kVar17 = this.f539a.n;
                kVar17.a(ahVar.f526a);
                return;
            }
            k7 = this.f539a.k();
            if (k7) {
                com.baidu.adp.lib.h.d.d("could not call onTextMessage() .. handler already NULL");
            }
        } else if (message.obj instanceof ad) {
            ad adVar = (ad) message.obj;
            kVar14 = this.f539a.n;
            if (kVar14 != null) {
                kVar15 = this.f539a.n;
                kVar15.a(adVar.f523a);
                return;
            }
            k6 = this.f539a.k();
            if (k6) {
                com.baidu.adp.lib.h.d.d("could not call onRawTextMessage() .. handler already NULL");
            }
        } else if (message.obj instanceof s) {
            s sVar = (s) message.obj;
            kVar12 = this.f539a.n;
            if (kVar12 != null) {
                kVar13 = this.f539a.n;
                kVar13.b(sVar.f541a);
                return;
            }
            k5 = this.f539a.k();
            if (k5) {
                com.baidu.adp.lib.h.d.d("could not call onBinaryMessage() .. handler already NULL");
            }
        } else if (message.obj instanceof aa) {
            aa aaVar = (aa) message.obj;
            k4 = this.f539a.k();
            if (k4) {
                com.baidu.adp.lib.h.d.d("WebSockets Ping received");
            }
            ab abVar = new ab();
            abVar.f521a = aaVar.f520a;
            this.f539a.c.a((Object) abVar);
        } else if (message.obj instanceof ab) {
            ab abVar2 = (ab) message.obj;
            kVar10 = this.f539a.n;
            if (kVar10 != null) {
                kVar11 = this.f539a.n;
                kVar11.b();
            }
            k3 = this.f539a.k();
            if (k3) {
                com.baidu.adp.lib.h.d.d("WebSockets Pong received");
            }
        } else if (message.obj instanceof u) {
            this.f539a.a(1, (String) null);
        } else if (message.obj instanceof af) {
            af afVar = (af) message.obj;
            k = this.f539a.k();
            if (k) {
                com.baidu.adp.lib.h.d.d("opening handshake received");
            }
            if (afVar.f525a) {
                kVar7 = this.f539a.n;
                if (kVar7 != null) {
                    kVar8 = this.f539a.n;
                    kVar8.a();
                    this.f539a.o = true;
                    this.f539a.p = false;
                    kVar9 = this.f539a.n;
                    kVar9.a((am) null);
                    return;
                }
                k2 = this.f539a.k();
                if (k2) {
                    com.baidu.adp.lib.h.d.d("could not call onOpen() .. handler already NULL");
                }
                this.f539a.a(6, "handler already NULL");
            }
        } else if (message.obj instanceof v) {
            SocketException socketException = ((v) message.obj).f544a;
            this.f539a.a(3, "WebSockets connection lost = " + (socketException != null ? socketException.getMessage() : null));
        } else if (message.obj instanceof ac) {
            WebSocketException webSocketException = ((ac) message.obj).f522a;
            this.f539a.a(4, "WebSockets protocol violation error = " + (webSocketException != null ? webSocketException.getMessage() : null));
        } else if (message.obj instanceof x) {
            this.f539a.a(5, "WebSockets internal error (" + ((x) message.obj).f545a.toString() + ")");
        } else if (message.obj instanceof ae) {
            ae aeVar = (ae) message.obj;
            this.f539a.a(6, "Server error " + aeVar.f524a + " (" + aeVar.b + ")");
        } else if (message.obj instanceof w) {
            this.f539a.a(2, "WebSockets connot connect");
        } else if (message.obj instanceof ag) {
            kVar5 = this.f539a.n;
            if (kVar5 != null) {
                kVar6 = this.f539a.n;
                amVar3 = this.f539a.r;
                kVar6.b(amVar3);
            }
        } else if (message.obj instanceof y) {
            kVar = this.f539a.n;
            if (kVar != null) {
                kVar4 = this.f539a.n;
                amVar2 = this.f539a.r;
                kVar4.d(amVar2);
            }
            amVar = this.f539a.r;
            this.f539a.r = null;
            kVar2 = this.f539a.n;
            if (kVar2 != null) {
                kVar3 = this.f539a.n;
                kVar3.a(amVar);
            }
        } else {
            this.f539a.a(message.obj);
        }
    }
}
