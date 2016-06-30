package com.baidu.adp.lib.webSocket;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.webSocket.g;
import com.baidu.adp.lib.webSocket.m;
import java.net.SocketException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k extends Handler {
    final /* synthetic */ j qS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar) {
        this.qS = jVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        g.a aVar;
        g.a aVar2;
        g.a aVar3;
        g.a aVar4;
        g.a aVar5;
        g.a aVar6;
        g.a aVar7;
        g.a aVar8;
        g.a aVar9;
        g.a aVar10;
        g.a aVar11;
        g.a aVar12;
        g.a aVar13;
        g.a aVar14;
        g.a aVar15;
        g.a aVar16;
        g.a aVar17;
        g.a aVar18;
        g.a aVar19;
        g.a aVar20;
        g.a aVar21;
        g.a aVar22;
        if (message.obj instanceof m.s) {
            m.s sVar = (m.s) message.obj;
            aVar21 = this.qS.qL;
            if (aVar21 != null) {
                aVar22 = this.qS.qL;
                aVar22.y(sVar.ri);
            }
        } else if (message.obj instanceof m.C0010m) {
            m.C0010m c0010m = (m.C0010m) message.obj;
            aVar19 = this.qS.qL;
            if (aVar19 != null) {
                aVar20 = this.qS.qL;
                aVar20.o(c0010m.qT);
            } else if (this.qS.gl()) {
                BdLog.d("could not call onRawTextMessage() .. handler already NULL");
            }
        } else if (message.obj instanceof m.a) {
            m.a aVar23 = (m.a) message.obj;
            aVar17 = this.qS.qL;
            if (aVar17 != null) {
                aVar18 = this.qS.qL;
                aVar18.b(aVar23);
            } else if (this.qS.gl()) {
                BdLog.d("could not call onBinaryMessage() .. handler already NULL");
            }
        } else if (message.obj instanceof m.j) {
            m.k kVar = new m.k();
            kVar.qT = ((m.j) message.obj).qT;
            this.qS.qD.r(kVar);
        } else if (message.obj instanceof m.k) {
            m.k kVar2 = (m.k) message.obj;
            aVar15 = this.qS.qL;
            if (aVar15 != null) {
                aVar16 = this.qS.qL;
                aVar16.gf();
            }
        } else if (message.obj instanceof m.c) {
            this.qS.close(1, null);
        } else if (message.obj instanceof m.q) {
            m.q qVar = (m.q) message.obj;
            if (qVar.rg) {
                aVar11 = this.qS.qL;
                if (aVar11 != null) {
                    aVar12 = this.qS.qL;
                    aVar12.e(qVar.rh);
                    this.qS.qN = true;
                    this.qS.qO = false;
                    aVar13 = this.qS.qL;
                    if (aVar13 != null) {
                        aVar14 = this.qS.qL;
                        aVar14.a(null);
                        return;
                    }
                    return;
                }
                this.qS.close(6, "handler already NULL");
            }
        } else if (message.obj instanceof m.d) {
            SocketException socketException = ((m.d) message.obj).ra;
            this.qS.close(3, "WebSockets connection lost = " + (socketException != null ? socketException.getMessage() : null));
        } else if (message.obj instanceof m.l) {
            WebSocketException webSocketException = ((m.l) message.obj).re;
            this.qS.close(4, "WebSockets protocol violation error = " + (webSocketException != null ? webSocketException.getMessage() : null));
        } else if (message.obj instanceof m.f) {
            this.qS.close(5, "WebSockets internal error (" + ((m.f) message.obj).rc.toString() + ")");
        } else if (message.obj instanceof m.p) {
            m.p pVar = (m.p) message.obj;
            this.qS.close(6, "Server error " + pVar.mStatusCode + " (" + pVar.rb + ")");
        } else if (message.obj instanceof m.e) {
            this.qS.close(2, "WebSockets connot connect:" + ((m.e) message.obj).rb);
        } else if (message.obj instanceof m.r) {
            aVar9 = this.qS.qL;
            if (aVar9 != null) {
                c cVar = ((m.r) message.obj).rf;
                aVar10 = this.qS.qL;
                aVar10.b(cVar);
            }
        } else if (message.obj instanceof m.g) {
            this.qS.qR = null;
            c cVar2 = ((m.g) message.obj).rf;
            aVar5 = this.qS.qL;
            if (aVar5 != null) {
                aVar8 = this.qS.qL;
                aVar8.c(cVar2);
            }
            aVar6 = this.qS.qL;
            if (aVar6 != null) {
                aVar7 = this.qS.qL;
                aVar7.a(cVar2);
            }
        } else if (message.obj instanceof m.n) {
            this.qS.qR = null;
            c cVar3 = ((m.n) message.obj).rf;
            aVar = this.qS.qL;
            if (aVar != null) {
                aVar4 = this.qS.qL;
                aVar4.a(2, cVar3);
            }
            aVar2 = this.qS.qL;
            if (aVar2 != null) {
                aVar3 = this.qS.qL;
                aVar3.a(cVar3);
            }
        } else {
            this.qS.p(message.obj);
        }
    }
}
