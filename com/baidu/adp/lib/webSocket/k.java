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
    final /* synthetic */ j Ay;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar) {
        this.Ay = jVar;
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
            aVar21 = this.Ay.Ar;
            if (aVar21 != null) {
                aVar22 = this.Ay.Ar;
                aVar22.x(sVar.AO);
            }
        } else if (message.obj instanceof m.C0008m) {
            m.C0008m c0008m = (m.C0008m) message.obj;
            aVar19 = this.Ay.Ar;
            if (aVar19 != null) {
                aVar20 = this.Ay.Ar;
                aVar20.r(c0008m.Az);
            } else if (this.Ay.isDebug()) {
                BdLog.d("could not call onRawTextMessage() .. handler already NULL");
            }
        } else if (message.obj instanceof m.a) {
            m.a aVar23 = (m.a) message.obj;
            aVar17 = this.Ay.Ar;
            if (aVar17 != null) {
                aVar18 = this.Ay.Ar;
                aVar18.b(aVar23);
            } else if (this.Ay.isDebug()) {
                BdLog.d("could not call onBinaryMessage() .. handler already NULL");
            }
        } else if (message.obj instanceof m.j) {
            m.k kVar = new m.k();
            kVar.Az = ((m.j) message.obj).Az;
            this.Ay.Aj.u(kVar);
        } else if (message.obj instanceof m.k) {
            m.k kVar2 = (m.k) message.obj;
            aVar15 = this.Ay.Ar;
            if (aVar15 != null) {
                aVar16 = this.Ay.Ar;
                aVar16.hX();
            }
        } else if (message.obj instanceof m.c) {
            this.Ay.close(1, null);
        } else if (message.obj instanceof m.q) {
            m.q qVar = (m.q) message.obj;
            if (qVar.AM) {
                aVar11 = this.Ay.Ar;
                if (aVar11 != null) {
                    aVar12 = this.Ay.Ar;
                    aVar12.e(qVar.AN);
                    this.Ay.At = true;
                    this.Ay.Au = false;
                    aVar13 = this.Ay.Ar;
                    if (aVar13 != null) {
                        aVar14 = this.Ay.Ar;
                        aVar14.a(null);
                        return;
                    }
                    return;
                }
                this.Ay.close(6, "handler already NULL");
            }
        } else if (message.obj instanceof m.d) {
            SocketException socketException = ((m.d) message.obj).AG;
            this.Ay.close(3, "WebSockets connection lost = " + (socketException != null ? socketException.getMessage() : null));
        } else if (message.obj instanceof m.l) {
            WebSocketException webSocketException = ((m.l) message.obj).AK;
            this.Ay.close(4, "WebSockets protocol violation error = " + (webSocketException != null ? webSocketException.getMessage() : null));
        } else if (message.obj instanceof m.f) {
            this.Ay.close(5, "WebSockets internal error (" + ((m.f) message.obj).AI.toString() + ")");
        } else if (message.obj instanceof m.p) {
            m.p pVar = (m.p) message.obj;
            this.Ay.close(6, "Server error " + pVar.mStatusCode + " (" + pVar.AH + ")");
        } else if (message.obj instanceof m.e) {
            this.Ay.close(2, "WebSockets connot connect:" + ((m.e) message.obj).AH);
        } else if (message.obj instanceof m.r) {
            aVar9 = this.Ay.Ar;
            if (aVar9 != null) {
                c cVar = ((m.r) message.obj).AL;
                aVar10 = this.Ay.Ar;
                aVar10.b(cVar);
            }
        } else if (message.obj instanceof m.g) {
            this.Ay.Ax = null;
            c cVar2 = ((m.g) message.obj).AL;
            aVar5 = this.Ay.Ar;
            if (aVar5 != null) {
                aVar8 = this.Ay.Ar;
                aVar8.c(cVar2);
            }
            aVar6 = this.Ay.Ar;
            if (aVar6 != null) {
                aVar7 = this.Ay.Ar;
                aVar7.a(cVar2);
            }
        } else if (message.obj instanceof m.n) {
            this.Ay.Ax = null;
            c cVar3 = ((m.n) message.obj).AL;
            aVar = this.Ay.Ar;
            if (aVar != null) {
                aVar4 = this.Ay.Ar;
                aVar4.a(2, cVar3);
            }
            aVar2 = this.Ay.Ar;
            if (aVar2 != null) {
                aVar3 = this.Ay.Ar;
                aVar3.a(cVar3);
            }
        } else {
            this.Ay.s(message.obj);
        }
    }
}
