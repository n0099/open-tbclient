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
    final /* synthetic */ j zW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar) {
        this.zW = jVar;
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
            aVar21 = this.zW.zP;
            if (aVar21 != null) {
                aVar22 = this.zW.zP;
                aVar22.I(sVar.An);
            }
        } else if (message.obj instanceof m.C0008m) {
            m.C0008m c0008m = (m.C0008m) message.obj;
            aVar19 = this.zW.zP;
            if (aVar19 != null) {
                aVar20 = this.zW.zP;
                aVar20.F(c0008m.zX);
            } else if (this.zW.isDebug()) {
                BdLog.d("could not call onRawTextMessage() .. handler already NULL");
            }
        } else if (message.obj instanceof m.a) {
            m.a aVar23 = (m.a) message.obj;
            aVar17 = this.zW.zP;
            if (aVar17 != null) {
                aVar18 = this.zW.zP;
                aVar18.w(aVar23.zX);
            } else if (this.zW.isDebug()) {
                BdLog.d("could not call onBinaryMessage() .. handler already NULL");
            }
        } else if (message.obj instanceof m.j) {
            m.k kVar = new m.k();
            kVar.zX = ((m.j) message.obj).zX;
            this.zW.zH.r(kVar);
        } else if (message.obj instanceof m.k) {
            m.k kVar2 = (m.k) message.obj;
            aVar15 = this.zW.zP;
            if (aVar15 != null) {
                aVar16 = this.zW.zP;
                aVar16.jx();
            }
        } else if (message.obj instanceof m.c) {
            this.zW.close(1, null);
        } else if (message.obj instanceof m.q) {
            m.q qVar = (m.q) message.obj;
            if (qVar.Am) {
                aVar11 = this.zW.zP;
                if (aVar11 != null) {
                    aVar12 = this.zW.zP;
                    aVar12.c(qVar.mHeaders);
                    this.zW.zR = true;
                    this.zW.zS = false;
                    aVar13 = this.zW.zP;
                    if (aVar13 != null) {
                        aVar14 = this.zW.zP;
                        aVar14.a(null);
                        return;
                    }
                    return;
                }
                this.zW.close(6, "handler already NULL");
            }
        } else if (message.obj instanceof m.d) {
            SocketException socketException = ((m.d) message.obj).Ag;
            this.zW.close(3, "WebSockets connection lost = " + (socketException != null ? socketException.getMessage() : null));
        } else if (message.obj instanceof m.l) {
            WebSocketException webSocketException = ((m.l) message.obj).Ak;
            this.zW.close(4, "WebSockets protocol violation error = " + (webSocketException != null ? webSocketException.getMessage() : null));
        } else if (message.obj instanceof m.f) {
            this.zW.close(5, "WebSockets internal error (" + ((m.f) message.obj).Ai.toString() + ")");
        } else if (message.obj instanceof m.p) {
            m.p pVar = (m.p) message.obj;
            this.zW.close(6, "Server error " + pVar.mStatusCode + " (" + pVar.Ah + ")");
        } else if (message.obj instanceof m.e) {
            this.zW.close(2, "WebSockets connot connect:" + ((m.e) message.obj).Ah);
        } else if (message.obj instanceof m.r) {
            aVar9 = this.zW.zP;
            if (aVar9 != null) {
                c cVar = ((m.r) message.obj).Al;
                aVar10 = this.zW.zP;
                aVar10.b(cVar);
            }
        } else if (message.obj instanceof m.g) {
            this.zW.zV = null;
            c cVar2 = ((m.g) message.obj).Al;
            aVar5 = this.zW.zP;
            if (aVar5 != null) {
                aVar8 = this.zW.zP;
                aVar8.c(cVar2);
            }
            aVar6 = this.zW.zP;
            if (aVar6 != null) {
                aVar7 = this.zW.zP;
                aVar7.a(cVar2);
            }
        } else if (message.obj instanceof m.n) {
            this.zW.zV = null;
            c cVar3 = ((m.n) message.obj).Al;
            aVar = this.zW.zP;
            if (aVar != null) {
                aVar4 = this.zW.zP;
                aVar4.a(2, cVar3);
            }
            aVar2 = this.zW.zP;
            if (aVar2 != null) {
                aVar3 = this.zW.zP;
                aVar3.a(cVar3);
            }
        } else {
            this.zW.p(message.obj);
        }
    }
}
