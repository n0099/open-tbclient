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
    final /* synthetic */ j tF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar) {
        this.tF = jVar;
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
            aVar21 = this.tF.ty;
            if (aVar21 != null) {
                aVar22 = this.tF.ty;
                aVar22.B(sVar.tV);
            }
        } else if (message.obj instanceof m.C0009m) {
            m.C0009m c0009m = (m.C0009m) message.obj;
            aVar19 = this.tF.ty;
            if (aVar19 != null) {
                aVar20 = this.tF.ty;
                aVar20.r(c0009m.tG);
            } else if (this.tF.hd()) {
                BdLog.d("could not call onRawTextMessage() .. handler already NULL");
            }
        } else if (message.obj instanceof m.a) {
            m.a aVar23 = (m.a) message.obj;
            aVar17 = this.tF.ty;
            if (aVar17 != null) {
                aVar18 = this.tF.ty;
                aVar18.b(aVar23);
            } else if (this.tF.hd()) {
                BdLog.d("could not call onBinaryMessage() .. handler already NULL");
            }
        } else if (message.obj instanceof m.j) {
            m.k kVar = new m.k();
            kVar.tG = ((m.j) message.obj).tG;
            this.tF.tq.u(kVar);
        } else if (message.obj instanceof m.k) {
            m.k kVar2 = (m.k) message.obj;
            aVar15 = this.tF.ty;
            if (aVar15 != null) {
                aVar16 = this.tF.ty;
                aVar16.gX();
            }
        } else if (message.obj instanceof m.c) {
            this.tF.close(1, null);
        } else if (message.obj instanceof m.q) {
            m.q qVar = (m.q) message.obj;
            if (qVar.tT) {
                aVar11 = this.tF.ty;
                if (aVar11 != null) {
                    aVar12 = this.tF.ty;
                    aVar12.e(qVar.tU);
                    this.tF.tA = true;
                    this.tF.tB = false;
                    aVar13 = this.tF.ty;
                    if (aVar13 != null) {
                        aVar14 = this.tF.ty;
                        aVar14.a(null);
                        return;
                    }
                    return;
                }
                this.tF.close(6, "handler already NULL");
            }
        } else if (message.obj instanceof m.d) {
            SocketException socketException = ((m.d) message.obj).tN;
            this.tF.close(3, "WebSockets connection lost = " + (socketException != null ? socketException.getMessage() : null));
        } else if (message.obj instanceof m.l) {
            WebSocketException webSocketException = ((m.l) message.obj).tR;
            this.tF.close(4, "WebSockets protocol violation error = " + (webSocketException != null ? webSocketException.getMessage() : null));
        } else if (message.obj instanceof m.f) {
            this.tF.close(5, "WebSockets internal error (" + ((m.f) message.obj).tP.toString() + ")");
        } else if (message.obj instanceof m.p) {
            m.p pVar = (m.p) message.obj;
            this.tF.close(6, "Server error " + pVar.mStatusCode + " (" + pVar.tO + ")");
        } else if (message.obj instanceof m.e) {
            this.tF.close(2, "WebSockets connot connect:" + ((m.e) message.obj).tO);
        } else if (message.obj instanceof m.r) {
            aVar9 = this.tF.ty;
            if (aVar9 != null) {
                c cVar = ((m.r) message.obj).tS;
                aVar10 = this.tF.ty;
                aVar10.b(cVar);
            }
        } else if (message.obj instanceof m.g) {
            this.tF.tE = null;
            c cVar2 = ((m.g) message.obj).tS;
            aVar5 = this.tF.ty;
            if (aVar5 != null) {
                aVar8 = this.tF.ty;
                aVar8.c(cVar2);
            }
            aVar6 = this.tF.ty;
            if (aVar6 != null) {
                aVar7 = this.tF.ty;
                aVar7.a(cVar2);
            }
        } else if (message.obj instanceof m.n) {
            this.tF.tE = null;
            c cVar3 = ((m.n) message.obj).tS;
            aVar = this.tF.ty;
            if (aVar != null) {
                aVar4 = this.tF.ty;
                aVar4.a(2, cVar3);
            }
            aVar2 = this.tF.ty;
            if (aVar2 != null) {
                aVar3 = this.tF.ty;
                aVar3.a(cVar3);
            }
        } else {
            this.tF.s(message.obj);
        }
    }
}
