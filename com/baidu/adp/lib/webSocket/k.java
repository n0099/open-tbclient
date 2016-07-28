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
    final /* synthetic */ j rv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar) {
        this.rv = jVar;
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
            aVar21 = this.rv.ro;
            if (aVar21 != null) {
                aVar22 = this.rv.ro;
                aVar22.A(sVar.rL);
            }
        } else if (message.obj instanceof m.C0010m) {
            m.C0010m c0010m = (m.C0010m) message.obj;
            aVar19 = this.rv.ro;
            if (aVar19 != null) {
                aVar20 = this.rv.ro;
                aVar20.r(c0010m.rw);
            } else if (this.rv.gk()) {
                BdLog.d("could not call onRawTextMessage() .. handler already NULL");
            }
        } else if (message.obj instanceof m.a) {
            m.a aVar23 = (m.a) message.obj;
            aVar17 = this.rv.ro;
            if (aVar17 != null) {
                aVar18 = this.rv.ro;
                aVar18.b(aVar23);
            } else if (this.rv.gk()) {
                BdLog.d("could not call onBinaryMessage() .. handler already NULL");
            }
        } else if (message.obj instanceof m.j) {
            m.k kVar = new m.k();
            kVar.rw = ((m.j) message.obj).rw;
            this.rv.rf.u(kVar);
        } else if (message.obj instanceof m.k) {
            m.k kVar2 = (m.k) message.obj;
            aVar15 = this.rv.ro;
            if (aVar15 != null) {
                aVar16 = this.rv.ro;
                aVar16.ge();
            }
        } else if (message.obj instanceof m.c) {
            this.rv.close(1, null);
        } else if (message.obj instanceof m.q) {
            m.q qVar = (m.q) message.obj;
            if (qVar.rJ) {
                aVar11 = this.rv.ro;
                if (aVar11 != null) {
                    aVar12 = this.rv.ro;
                    aVar12.e(qVar.rK);
                    this.rv.rq = true;
                    this.rv.rr = false;
                    aVar13 = this.rv.ro;
                    if (aVar13 != null) {
                        aVar14 = this.rv.ro;
                        aVar14.a(null);
                        return;
                    }
                    return;
                }
                this.rv.close(6, "handler already NULL");
            }
        } else if (message.obj instanceof m.d) {
            SocketException socketException = ((m.d) message.obj).rD;
            this.rv.close(3, "WebSockets connection lost = " + (socketException != null ? socketException.getMessage() : null));
        } else if (message.obj instanceof m.l) {
            WebSocketException webSocketException = ((m.l) message.obj).rH;
            this.rv.close(4, "WebSockets protocol violation error = " + (webSocketException != null ? webSocketException.getMessage() : null));
        } else if (message.obj instanceof m.f) {
            this.rv.close(5, "WebSockets internal error (" + ((m.f) message.obj).rF.toString() + ")");
        } else if (message.obj instanceof m.p) {
            m.p pVar = (m.p) message.obj;
            this.rv.close(6, "Server error " + pVar.mStatusCode + " (" + pVar.rE + ")");
        } else if (message.obj instanceof m.e) {
            this.rv.close(2, "WebSockets connot connect:" + ((m.e) message.obj).rE);
        } else if (message.obj instanceof m.r) {
            aVar9 = this.rv.ro;
            if (aVar9 != null) {
                c cVar = ((m.r) message.obj).rI;
                aVar10 = this.rv.ro;
                aVar10.b(cVar);
            }
        } else if (message.obj instanceof m.g) {
            this.rv.ru = null;
            c cVar2 = ((m.g) message.obj).rI;
            aVar5 = this.rv.ro;
            if (aVar5 != null) {
                aVar8 = this.rv.ro;
                aVar8.c(cVar2);
            }
            aVar6 = this.rv.ro;
            if (aVar6 != null) {
                aVar7 = this.rv.ro;
                aVar7.a(cVar2);
            }
        } else if (message.obj instanceof m.n) {
            this.rv.ru = null;
            c cVar3 = ((m.n) message.obj).rI;
            aVar = this.rv.ro;
            if (aVar != null) {
                aVar4 = this.rv.ro;
                aVar4.a(2, cVar3);
            }
            aVar2 = this.rv.ro;
            if (aVar2 != null) {
                aVar3 = this.rv.ro;
                aVar3.a(cVar3);
            }
        } else {
            this.rv.s(message.obj);
        }
    }
}
