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
    final /* synthetic */ j tO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar) {
        this.tO = jVar;
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
            aVar21 = this.tO.tH;
            if (aVar21 != null) {
                aVar22 = this.tO.tH;
                aVar22.B(sVar.ue);
            }
        } else if (message.obj instanceof m.C0010m) {
            m.C0010m c0010m = (m.C0010m) message.obj;
            aVar19 = this.tO.tH;
            if (aVar19 != null) {
                aVar20 = this.tO.tH;
                aVar20.r(c0010m.tP);
            } else if (this.tO.hf()) {
                BdLog.d("could not call onRawTextMessage() .. handler already NULL");
            }
        } else if (message.obj instanceof m.a) {
            m.a aVar23 = (m.a) message.obj;
            aVar17 = this.tO.tH;
            if (aVar17 != null) {
                aVar18 = this.tO.tH;
                aVar18.b(aVar23);
            } else if (this.tO.hf()) {
                BdLog.d("could not call onBinaryMessage() .. handler already NULL");
            }
        } else if (message.obj instanceof m.j) {
            m.k kVar = new m.k();
            kVar.tP = ((m.j) message.obj).tP;
            this.tO.tz.u(kVar);
        } else if (message.obj instanceof m.k) {
            m.k kVar2 = (m.k) message.obj;
            aVar15 = this.tO.tH;
            if (aVar15 != null) {
                aVar16 = this.tO.tH;
                aVar16.gZ();
            }
        } else if (message.obj instanceof m.c) {
            this.tO.close(1, null);
        } else if (message.obj instanceof m.q) {
            m.q qVar = (m.q) message.obj;
            if (qVar.uc) {
                aVar11 = this.tO.tH;
                if (aVar11 != null) {
                    aVar12 = this.tO.tH;
                    aVar12.e(qVar.ud);
                    this.tO.tJ = true;
                    this.tO.tK = false;
                    aVar13 = this.tO.tH;
                    if (aVar13 != null) {
                        aVar14 = this.tO.tH;
                        aVar14.a(null);
                        return;
                    }
                    return;
                }
                this.tO.close(6, "handler already NULL");
            }
        } else if (message.obj instanceof m.d) {
            SocketException socketException = ((m.d) message.obj).tW;
            this.tO.close(3, "WebSockets connection lost = " + (socketException != null ? socketException.getMessage() : null));
        } else if (message.obj instanceof m.l) {
            WebSocketException webSocketException = ((m.l) message.obj).ua;
            this.tO.close(4, "WebSockets protocol violation error = " + (webSocketException != null ? webSocketException.getMessage() : null));
        } else if (message.obj instanceof m.f) {
            this.tO.close(5, "WebSockets internal error (" + ((m.f) message.obj).tY.toString() + ")");
        } else if (message.obj instanceof m.p) {
            m.p pVar = (m.p) message.obj;
            this.tO.close(6, "Server error " + pVar.mStatusCode + " (" + pVar.tX + ")");
        } else if (message.obj instanceof m.e) {
            this.tO.close(2, "WebSockets connot connect:" + ((m.e) message.obj).tX);
        } else if (message.obj instanceof m.r) {
            aVar9 = this.tO.tH;
            if (aVar9 != null) {
                c cVar = ((m.r) message.obj).ub;
                aVar10 = this.tO.tH;
                aVar10.b(cVar);
            }
        } else if (message.obj instanceof m.g) {
            this.tO.tN = null;
            c cVar2 = ((m.g) message.obj).ub;
            aVar5 = this.tO.tH;
            if (aVar5 != null) {
                aVar8 = this.tO.tH;
                aVar8.c(cVar2);
            }
            aVar6 = this.tO.tH;
            if (aVar6 != null) {
                aVar7 = this.tO.tH;
                aVar7.a(cVar2);
            }
        } else if (message.obj instanceof m.n) {
            this.tO.tN = null;
            c cVar3 = ((m.n) message.obj).ub;
            aVar = this.tO.tH;
            if (aVar != null) {
                aVar4 = this.tO.tH;
                aVar4.a(2, cVar3);
            }
            aVar2 = this.tO.tH;
            if (aVar2 != null) {
                aVar3 = this.tO.tH;
                aVar3.a(cVar3);
            }
        } else {
            this.tO.s(message.obj);
        }
    }
}
