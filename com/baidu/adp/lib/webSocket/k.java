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
    final /* synthetic */ j zY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar) {
        this.zY = jVar;
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
            aVar21 = this.zY.zR;
            if (aVar21 != null) {
                aVar22 = this.zY.zR;
                aVar22.I(sVar.Ap);
            }
        } else if (message.obj instanceof m.C0008m) {
            m.C0008m c0008m = (m.C0008m) message.obj;
            aVar19 = this.zY.zR;
            if (aVar19 != null) {
                aVar20 = this.zY.zR;
                aVar20.F(c0008m.zZ);
            } else if (this.zY.isDebug()) {
                BdLog.d("could not call onRawTextMessage() .. handler already NULL");
            }
        } else if (message.obj instanceof m.a) {
            m.a aVar23 = (m.a) message.obj;
            aVar17 = this.zY.zR;
            if (aVar17 != null) {
                aVar18 = this.zY.zR;
                aVar18.w(aVar23.zZ);
            } else if (this.zY.isDebug()) {
                BdLog.d("could not call onBinaryMessage() .. handler already NULL");
            }
        } else if (message.obj instanceof m.j) {
            m.k kVar = new m.k();
            kVar.zZ = ((m.j) message.obj).zZ;
            this.zY.zJ.r(kVar);
        } else if (message.obj instanceof m.k) {
            m.k kVar2 = (m.k) message.obj;
            aVar15 = this.zY.zR;
            if (aVar15 != null) {
                aVar16 = this.zY.zR;
                aVar16.jA();
            }
        } else if (message.obj instanceof m.c) {
            this.zY.close(1, null);
        } else if (message.obj instanceof m.q) {
            m.q qVar = (m.q) message.obj;
            if (qVar.Ao) {
                aVar11 = this.zY.zR;
                if (aVar11 != null) {
                    aVar12 = this.zY.zR;
                    aVar12.c(qVar.mHeaders);
                    this.zY.zT = true;
                    this.zY.zU = false;
                    aVar13 = this.zY.zR;
                    if (aVar13 != null) {
                        aVar14 = this.zY.zR;
                        aVar14.a(null);
                        return;
                    }
                    return;
                }
                this.zY.close(6, "handler already NULL");
            }
        } else if (message.obj instanceof m.d) {
            SocketException socketException = ((m.d) message.obj).Ai;
            this.zY.close(3, "WebSockets connection lost = " + (socketException != null ? socketException.getMessage() : null));
        } else if (message.obj instanceof m.l) {
            WebSocketException webSocketException = ((m.l) message.obj).Am;
            this.zY.close(4, "WebSockets protocol violation error = " + (webSocketException != null ? webSocketException.getMessage() : null));
        } else if (message.obj instanceof m.f) {
            this.zY.close(5, "WebSockets internal error (" + ((m.f) message.obj).Ak.toString() + ")");
        } else if (message.obj instanceof m.p) {
            m.p pVar = (m.p) message.obj;
            this.zY.close(6, "Server error " + pVar.mStatusCode + " (" + pVar.Aj + ")");
        } else if (message.obj instanceof m.e) {
            this.zY.close(2, "WebSockets connot connect:" + ((m.e) message.obj).Aj);
        } else if (message.obj instanceof m.r) {
            aVar9 = this.zY.zR;
            if (aVar9 != null) {
                c cVar = ((m.r) message.obj).An;
                aVar10 = this.zY.zR;
                aVar10.b(cVar);
            }
        } else if (message.obj instanceof m.g) {
            this.zY.zX = null;
            c cVar2 = ((m.g) message.obj).An;
            aVar5 = this.zY.zR;
            if (aVar5 != null) {
                aVar8 = this.zY.zR;
                aVar8.c(cVar2);
            }
            aVar6 = this.zY.zR;
            if (aVar6 != null) {
                aVar7 = this.zY.zR;
                aVar7.a(cVar2);
            }
        } else if (message.obj instanceof m.n) {
            this.zY.zX = null;
            c cVar3 = ((m.n) message.obj).An;
            aVar = this.zY.zR;
            if (aVar != null) {
                aVar4 = this.zY.zR;
                aVar4.a(2, cVar3);
            }
            aVar2 = this.zY.zR;
            if (aVar2 != null) {
                aVar3 = this.zY.zR;
                aVar3.a(cVar3);
            }
        } else {
            this.zY.p(message.obj);
        }
    }
}
