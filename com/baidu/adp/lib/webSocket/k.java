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
    final /* synthetic */ j zX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar) {
        this.zX = jVar;
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
            aVar21 = this.zX.zQ;
            if (aVar21 != null) {
                aVar22 = this.zX.zQ;
                aVar22.I(sVar.Ao);
            }
        } else if (message.obj instanceof m.C0008m) {
            m.C0008m c0008m = (m.C0008m) message.obj;
            aVar19 = this.zX.zQ;
            if (aVar19 != null) {
                aVar20 = this.zX.zQ;
                aVar20.F(c0008m.zY);
            } else if (this.zX.isDebug()) {
                BdLog.d("could not call onRawTextMessage() .. handler already NULL");
            }
        } else if (message.obj instanceof m.a) {
            m.a aVar23 = (m.a) message.obj;
            aVar17 = this.zX.zQ;
            if (aVar17 != null) {
                aVar18 = this.zX.zQ;
                aVar18.w(aVar23.zY);
            } else if (this.zX.isDebug()) {
                BdLog.d("could not call onBinaryMessage() .. handler already NULL");
            }
        } else if (message.obj instanceof m.j) {
            m.k kVar = new m.k();
            kVar.zY = ((m.j) message.obj).zY;
            this.zX.zI.r(kVar);
        } else if (message.obj instanceof m.k) {
            m.k kVar2 = (m.k) message.obj;
            aVar15 = this.zX.zQ;
            if (aVar15 != null) {
                aVar16 = this.zX.zQ;
                aVar16.jy();
            }
        } else if (message.obj instanceof m.c) {
            this.zX.close(1, null);
        } else if (message.obj instanceof m.q) {
            m.q qVar = (m.q) message.obj;
            if (qVar.An) {
                aVar11 = this.zX.zQ;
                if (aVar11 != null) {
                    aVar12 = this.zX.zQ;
                    aVar12.d(qVar.mHeaders);
                    this.zX.zS = true;
                    this.zX.zT = false;
                    aVar13 = this.zX.zQ;
                    if (aVar13 != null) {
                        aVar14 = this.zX.zQ;
                        aVar14.a(null);
                        return;
                    }
                    return;
                }
                this.zX.close(6, "handler already NULL");
            }
        } else if (message.obj instanceof m.d) {
            SocketException socketException = ((m.d) message.obj).Ah;
            this.zX.close(3, "WebSockets connection lost = " + (socketException != null ? socketException.getMessage() : null));
        } else if (message.obj instanceof m.l) {
            WebSocketException webSocketException = ((m.l) message.obj).Al;
            this.zX.close(4, "WebSockets protocol violation error = " + (webSocketException != null ? webSocketException.getMessage() : null));
        } else if (message.obj instanceof m.f) {
            this.zX.close(5, "WebSockets internal error (" + ((m.f) message.obj).Aj.toString() + ")");
        } else if (message.obj instanceof m.p) {
            m.p pVar = (m.p) message.obj;
            this.zX.close(6, "Server error " + pVar.mStatusCode + " (" + pVar.Ai + ")");
        } else if (message.obj instanceof m.e) {
            this.zX.close(2, "WebSockets connot connect:" + ((m.e) message.obj).Ai);
        } else if (message.obj instanceof m.r) {
            aVar9 = this.zX.zQ;
            if (aVar9 != null) {
                c cVar = ((m.r) message.obj).Am;
                aVar10 = this.zX.zQ;
                aVar10.b(cVar);
            }
        } else if (message.obj instanceof m.g) {
            this.zX.zW = null;
            c cVar2 = ((m.g) message.obj).Am;
            aVar5 = this.zX.zQ;
            if (aVar5 != null) {
                aVar8 = this.zX.zQ;
                aVar8.c(cVar2);
            }
            aVar6 = this.zX.zQ;
            if (aVar6 != null) {
                aVar7 = this.zX.zQ;
                aVar7.a(cVar2);
            }
        } else if (message.obj instanceof m.n) {
            this.zX.zW = null;
            c cVar3 = ((m.n) message.obj).Am;
            aVar = this.zX.zQ;
            if (aVar != null) {
                aVar4 = this.zX.zQ;
                aVar4.a(2, cVar3);
            }
            aVar2 = this.zX.zQ;
            if (aVar2 != null) {
                aVar3 = this.zX.zQ;
                aVar3.a(cVar3);
            }
        } else {
            this.zX.p(message.obj);
        }
    }
}
