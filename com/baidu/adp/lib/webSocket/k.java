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
    final /* synthetic */ j Ao;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar) {
        this.Ao = jVar;
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
            aVar21 = this.Ao.Ah;
            if (aVar21 != null) {
                aVar22 = this.Ao.Ah;
                aVar22.H(sVar.AE);
            }
        } else if (message.obj instanceof m.C0009m) {
            m.C0009m c0009m = (m.C0009m) message.obj;
            aVar19 = this.Ao.Ah;
            if (aVar19 != null) {
                aVar20 = this.Ao.Ah;
                aVar20.F(c0009m.Ap);
            } else if (this.Ao.isDebug()) {
                BdLog.d("could not call onRawTextMessage() .. handler already NULL");
            }
        } else if (message.obj instanceof m.a) {
            m.a aVar23 = (m.a) message.obj;
            aVar17 = this.Ao.Ah;
            if (aVar17 != null) {
                aVar18 = this.Ao.Ah;
                aVar18.w(aVar23.Ap);
            } else if (this.Ao.isDebug()) {
                BdLog.d("could not call onBinaryMessage() .. handler already NULL");
            }
        } else if (message.obj instanceof m.j) {
            m.k kVar = new m.k();
            kVar.Ap = ((m.j) message.obj).Ap;
            this.Ao.zY.r(kVar);
        } else if (message.obj instanceof m.k) {
            m.k kVar2 = (m.k) message.obj;
            aVar15 = this.Ao.Ah;
            if (aVar15 != null) {
                aVar16 = this.Ao.Ah;
                aVar16.jK();
            }
        } else if (message.obj instanceof m.c) {
            this.Ao.close(1, null);
        } else if (message.obj instanceof m.q) {
            m.q qVar = (m.q) message.obj;
            if (qVar.AD) {
                aVar11 = this.Ao.Ah;
                if (aVar11 != null) {
                    aVar12 = this.Ao.Ah;
                    aVar12.d(qVar.mHeaders);
                    this.Ao.Aj = true;
                    this.Ao.Ak = false;
                    aVar13 = this.Ao.Ah;
                    if (aVar13 != null) {
                        aVar14 = this.Ao.Ah;
                        aVar14.a(null);
                        return;
                    }
                    return;
                }
                this.Ao.close(6, "handler already NULL");
            }
        } else if (message.obj instanceof m.d) {
            SocketException socketException = ((m.d) message.obj).Ax;
            this.Ao.close(3, "WebSockets connection lost = " + (socketException != null ? socketException.getMessage() : null));
        } else if (message.obj instanceof m.l) {
            WebSocketException webSocketException = ((m.l) message.obj).AB;
            this.Ao.close(4, "WebSockets protocol violation error = " + (webSocketException != null ? webSocketException.getMessage() : null));
        } else if (message.obj instanceof m.f) {
            this.Ao.close(5, "WebSockets internal error (" + ((m.f) message.obj).Az.toString() + ")");
        } else if (message.obj instanceof m.p) {
            m.p pVar = (m.p) message.obj;
            this.Ao.close(6, "Server error " + pVar.mStatusCode + " (" + pVar.Ay + ")");
        } else if (message.obj instanceof m.e) {
            this.Ao.close(2, "WebSockets connot connect:" + ((m.e) message.obj).Ay);
        } else if (message.obj instanceof m.r) {
            aVar9 = this.Ao.Ah;
            if (aVar9 != null) {
                c cVar = ((m.r) message.obj).AC;
                aVar10 = this.Ao.Ah;
                aVar10.b(cVar);
            }
        } else if (message.obj instanceof m.g) {
            this.Ao.An = null;
            c cVar2 = ((m.g) message.obj).AC;
            aVar5 = this.Ao.Ah;
            if (aVar5 != null) {
                aVar8 = this.Ao.Ah;
                aVar8.c(cVar2);
            }
            aVar6 = this.Ao.Ah;
            if (aVar6 != null) {
                aVar7 = this.Ao.Ah;
                aVar7.a(cVar2);
            }
        } else if (message.obj instanceof m.n) {
            this.Ao.An = null;
            c cVar3 = ((m.n) message.obj).AC;
            aVar = this.Ao.Ah;
            if (aVar != null) {
                aVar4 = this.Ao.Ah;
                aVar4.a(2, cVar3);
            }
            aVar2 = this.Ao.Ah;
            if (aVar2 != null) {
                aVar3 = this.Ao.Ah;
                aVar3.a(cVar3);
            }
        } else {
            this.Ao.p(message.obj);
        }
    }
}
