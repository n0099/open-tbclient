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
    final /* synthetic */ j AG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar) {
        this.AG = jVar;
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
            aVar21 = this.AG.Az;
            if (aVar21 != null) {
                aVar22 = this.AG.Az;
                aVar22.H(sVar.AW);
            }
        } else if (message.obj instanceof m.C0010m) {
            m.C0010m c0010m = (m.C0010m) message.obj;
            aVar19 = this.AG.Az;
            if (aVar19 != null) {
                aVar20 = this.AG.Az;
                aVar20.p(c0010m.AH);
            } else if (this.AG.isDebug()) {
                BdLog.d("could not call onRawTextMessage() .. handler already NULL");
            }
        } else if (message.obj instanceof m.a) {
            m.a aVar23 = (m.a) message.obj;
            aVar17 = this.AG.Az;
            if (aVar17 != null) {
                aVar18 = this.AG.Az;
                aVar18.b(aVar23);
            } else if (this.AG.isDebug()) {
                BdLog.d("could not call onBinaryMessage() .. handler already NULL");
            }
        } else if (message.obj instanceof m.j) {
            m.k kVar = new m.k();
            kVar.AH = ((m.j) message.obj).AH;
            this.AG.Ar.r(kVar);
        } else if (message.obj instanceof m.k) {
            m.k kVar2 = (m.k) message.obj;
            aVar15 = this.AG.Az;
            if (aVar15 != null) {
                aVar16 = this.AG.Az;
                aVar16.jQ();
            }
        } else if (message.obj instanceof m.c) {
            this.AG.close(1, null);
        } else if (message.obj instanceof m.q) {
            m.q qVar = (m.q) message.obj;
            if (qVar.AU) {
                aVar11 = this.AG.Az;
                if (aVar11 != null) {
                    aVar12 = this.AG.Az;
                    aVar12.d(qVar.AV);
                    this.AG.AB = true;
                    this.AG.AC = false;
                    aVar13 = this.AG.Az;
                    if (aVar13 != null) {
                        aVar14 = this.AG.Az;
                        aVar14.a(null);
                        return;
                    }
                    return;
                }
                this.AG.close(6, "handler already NULL");
            }
        } else if (message.obj instanceof m.d) {
            SocketException socketException = ((m.d) message.obj).AO;
            this.AG.close(3, "WebSockets connection lost = " + (socketException != null ? socketException.getMessage() : null));
        } else if (message.obj instanceof m.l) {
            WebSocketException webSocketException = ((m.l) message.obj).AS;
            this.AG.close(4, "WebSockets protocol violation error = " + (webSocketException != null ? webSocketException.getMessage() : null));
        } else if (message.obj instanceof m.f) {
            this.AG.close(5, "WebSockets internal error (" + ((m.f) message.obj).AQ.toString() + ")");
        } else if (message.obj instanceof m.p) {
            m.p pVar = (m.p) message.obj;
            this.AG.close(6, "Server error " + pVar.mStatusCode + " (" + pVar.AP + ")");
        } else if (message.obj instanceof m.e) {
            this.AG.close(2, "WebSockets connot connect:" + ((m.e) message.obj).AP);
        } else if (message.obj instanceof m.r) {
            aVar9 = this.AG.Az;
            if (aVar9 != null) {
                c cVar = ((m.r) message.obj).AT;
                aVar10 = this.AG.Az;
                aVar10.b(cVar);
            }
        } else if (message.obj instanceof m.g) {
            this.AG.AF = null;
            c cVar2 = ((m.g) message.obj).AT;
            aVar5 = this.AG.Az;
            if (aVar5 != null) {
                aVar8 = this.AG.Az;
                aVar8.c(cVar2);
            }
            aVar6 = this.AG.Az;
            if (aVar6 != null) {
                aVar7 = this.AG.Az;
                aVar7.a(cVar2);
            }
        } else if (message.obj instanceof m.n) {
            this.AG.AF = null;
            c cVar3 = ((m.n) message.obj).AT;
            aVar = this.AG.Az;
            if (aVar != null) {
                aVar4 = this.AG.Az;
                aVar4.a(2, cVar3);
            }
            aVar2 = this.AG.Az;
            if (aVar2 != null) {
                aVar3 = this.AG.Az;
                aVar3.a(cVar3);
            }
        } else {
            this.AG.p(message.obj);
        }
    }
}
