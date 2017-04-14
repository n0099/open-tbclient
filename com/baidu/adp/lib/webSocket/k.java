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
    final /* synthetic */ j Av;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar) {
        this.Av = jVar;
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
            aVar21 = this.Av.Ao;
            if (aVar21 != null) {
                aVar22 = this.Av.Ao;
                aVar22.x(sVar.AL);
            }
        } else if (message.obj instanceof m.C0008m) {
            m.C0008m c0008m = (m.C0008m) message.obj;
            aVar19 = this.Av.Ao;
            if (aVar19 != null) {
                aVar20 = this.Av.Ao;
                aVar20.r(c0008m.Aw);
            } else if (this.Av.isDebug()) {
                BdLog.d("could not call onRawTextMessage() .. handler already NULL");
            }
        } else if (message.obj instanceof m.a) {
            m.a aVar23 = (m.a) message.obj;
            aVar17 = this.Av.Ao;
            if (aVar17 != null) {
                aVar18 = this.Av.Ao;
                aVar18.b(aVar23);
            } else if (this.Av.isDebug()) {
                BdLog.d("could not call onBinaryMessage() .. handler already NULL");
            }
        } else if (message.obj instanceof m.j) {
            m.k kVar = new m.k();
            kVar.Aw = ((m.j) message.obj).Aw;
            this.Av.Ag.u(kVar);
        } else if (message.obj instanceof m.k) {
            m.k kVar2 = (m.k) message.obj;
            aVar15 = this.Av.Ao;
            if (aVar15 != null) {
                aVar16 = this.Av.Ao;
                aVar16.hW();
            }
        } else if (message.obj instanceof m.c) {
            this.Av.close(1, null);
        } else if (message.obj instanceof m.q) {
            m.q qVar = (m.q) message.obj;
            if (qVar.AJ) {
                aVar11 = this.Av.Ao;
                if (aVar11 != null) {
                    aVar12 = this.Av.Ao;
                    aVar12.e(qVar.AK);
                    this.Av.Aq = true;
                    this.Av.Ar = false;
                    aVar13 = this.Av.Ao;
                    if (aVar13 != null) {
                        aVar14 = this.Av.Ao;
                        aVar14.a(null);
                        return;
                    }
                    return;
                }
                this.Av.close(6, "handler already NULL");
            }
        } else if (message.obj instanceof m.d) {
            SocketException socketException = ((m.d) message.obj).AD;
            this.Av.close(3, "WebSockets connection lost = " + (socketException != null ? socketException.getMessage() : null));
        } else if (message.obj instanceof m.l) {
            WebSocketException webSocketException = ((m.l) message.obj).AH;
            this.Av.close(4, "WebSockets protocol violation error = " + (webSocketException != null ? webSocketException.getMessage() : null));
        } else if (message.obj instanceof m.f) {
            this.Av.close(5, "WebSockets internal error (" + ((m.f) message.obj).AF.toString() + ")");
        } else if (message.obj instanceof m.p) {
            m.p pVar = (m.p) message.obj;
            this.Av.close(6, "Server error " + pVar.mStatusCode + " (" + pVar.AE + ")");
        } else if (message.obj instanceof m.e) {
            this.Av.close(2, "WebSockets connot connect:" + ((m.e) message.obj).AE);
        } else if (message.obj instanceof m.r) {
            aVar9 = this.Av.Ao;
            if (aVar9 != null) {
                c cVar = ((m.r) message.obj).AI;
                aVar10 = this.Av.Ao;
                aVar10.b(cVar);
            }
        } else if (message.obj instanceof m.g) {
            this.Av.Au = null;
            c cVar2 = ((m.g) message.obj).AI;
            aVar5 = this.Av.Ao;
            if (aVar5 != null) {
                aVar8 = this.Av.Ao;
                aVar8.c(cVar2);
            }
            aVar6 = this.Av.Ao;
            if (aVar6 != null) {
                aVar7 = this.Av.Ao;
                aVar7.a(cVar2);
            }
        } else if (message.obj instanceof m.n) {
            this.Av.Au = null;
            c cVar3 = ((m.n) message.obj).AI;
            aVar = this.Av.Ao;
            if (aVar != null) {
                aVar4 = this.Av.Ao;
                aVar4.a(2, cVar3);
            }
            aVar2 = this.Av.Ao;
            if (aVar2 != null) {
                aVar3 = this.Av.Ao;
                aVar3.a(cVar3);
            }
        } else {
            this.Av.s(message.obj);
        }
    }
}
