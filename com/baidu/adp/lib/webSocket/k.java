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
    final /* synthetic */ j Ag;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar) {
        this.Ag = jVar;
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
            aVar21 = this.Ag.zY;
            if (aVar21 != null) {
                aVar22 = this.Ag.zY;
                aVar22.I(sVar.Aw);
            }
        } else if (message.obj instanceof m.C0009m) {
            m.C0009m c0009m = (m.C0009m) message.obj;
            aVar19 = this.Ag.zY;
            if (aVar19 != null) {
                aVar20 = this.Ag.zY;
                aVar20.F(c0009m.Ah);
            } else if (this.Ag.isDebug()) {
                BdLog.d("could not call onRawTextMessage() .. handler already NULL");
            }
        } else if (message.obj instanceof m.a) {
            m.a aVar23 = (m.a) message.obj;
            aVar17 = this.Ag.zY;
            if (aVar17 != null) {
                aVar18 = this.Ag.zY;
                aVar18.w(aVar23.Ah);
            } else if (this.Ag.isDebug()) {
                BdLog.d("could not call onBinaryMessage() .. handler already NULL");
            }
        } else if (message.obj instanceof m.j) {
            m.k kVar = new m.k();
            kVar.Ah = ((m.j) message.obj).Ah;
            this.Ag.zQ.r(kVar);
        } else if (message.obj instanceof m.k) {
            m.k kVar2 = (m.k) message.obj;
            aVar15 = this.Ag.zY;
            if (aVar15 != null) {
                aVar16 = this.Ag.zY;
                aVar16.jB();
            }
        } else if (message.obj instanceof m.c) {
            this.Ag.close(1, null);
        } else if (message.obj instanceof m.q) {
            m.q qVar = (m.q) message.obj;
            if (qVar.Av) {
                aVar11 = this.Ag.zY;
                if (aVar11 != null) {
                    aVar12 = this.Ag.zY;
                    aVar12.c(qVar.mHeaders);
                    this.Ag.Aa = true;
                    this.Ag.Ab = false;
                    aVar13 = this.Ag.zY;
                    if (aVar13 != null) {
                        aVar14 = this.Ag.zY;
                        aVar14.a(null);
                        return;
                    }
                    return;
                }
                this.Ag.close(6, "handler already NULL");
            }
        } else if (message.obj instanceof m.d) {
            SocketException socketException = ((m.d) message.obj).Ap;
            this.Ag.close(3, "WebSockets connection lost = " + (socketException != null ? socketException.getMessage() : null));
        } else if (message.obj instanceof m.l) {
            WebSocketException webSocketException = ((m.l) message.obj).At;
            this.Ag.close(4, "WebSockets protocol violation error = " + (webSocketException != null ? webSocketException.getMessage() : null));
        } else if (message.obj instanceof m.f) {
            this.Ag.close(5, "WebSockets internal error (" + ((m.f) message.obj).Ar.toString() + ")");
        } else if (message.obj instanceof m.p) {
            m.p pVar = (m.p) message.obj;
            this.Ag.close(6, "Server error " + pVar.mStatusCode + " (" + pVar.Aq + ")");
        } else if (message.obj instanceof m.e) {
            this.Ag.close(2, "WebSockets connot connect:" + ((m.e) message.obj).Aq);
        } else if (message.obj instanceof m.r) {
            aVar9 = this.Ag.zY;
            if (aVar9 != null) {
                c cVar = ((m.r) message.obj).Au;
                aVar10 = this.Ag.zY;
                aVar10.b(cVar);
            }
        } else if (message.obj instanceof m.g) {
            this.Ag.Af = null;
            c cVar2 = ((m.g) message.obj).Au;
            aVar5 = this.Ag.zY;
            if (aVar5 != null) {
                aVar8 = this.Ag.zY;
                aVar8.c(cVar2);
            }
            aVar6 = this.Ag.zY;
            if (aVar6 != null) {
                aVar7 = this.Ag.zY;
                aVar7.a(cVar2);
            }
        } else if (message.obj instanceof m.n) {
            this.Ag.Af = null;
            c cVar3 = ((m.n) message.obj).Au;
            aVar = this.Ag.zY;
            if (aVar != null) {
                aVar4 = this.Ag.zY;
                aVar4.a(2, cVar3);
            }
            aVar2 = this.Ag.zY;
            if (aVar2 != null) {
                aVar3 = this.Ag.zY;
                aVar3.a(cVar3);
            }
        } else {
            this.Ag.p(message.obj);
        }
    }
}
