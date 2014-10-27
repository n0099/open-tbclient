package com.baidu.adp.lib.webSocket;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.lib.util.BdLog;
import java.net.SocketException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p extends Handler {
    final /* synthetic */ o pL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(o oVar) {
        this.pL = oVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        l lVar;
        l lVar2;
        l lVar3;
        l lVar4;
        l lVar5;
        l lVar6;
        l lVar7;
        l lVar8;
        l lVar9;
        l lVar10;
        l lVar11;
        l lVar12;
        l lVar13;
        l lVar14;
        l lVar15;
        l lVar16;
        l lVar17;
        boolean fY;
        l lVar18;
        l lVar19;
        boolean fY2;
        l lVar20;
        l lVar21;
        l lVar22;
        if (message.obj instanceof al) {
            al alVar = (al) message.obj;
            lVar21 = this.pL.pE;
            if (lVar21 != null) {
                lVar22 = this.pL.pE;
                lVar22.j(alVar.qc);
            }
        } else if (message.obj instanceof af) {
            af afVar = (af) message.obj;
            lVar19 = this.pL.pE;
            if (lVar19 != null) {
                lVar20 = this.pL.pE;
                lVar20.s(afVar.pM);
                return;
            }
            fY2 = this.pL.fY();
            if (fY2) {
                BdLog.d("could not call onRawTextMessage() .. handler already NULL");
            }
        } else if (message.obj instanceof t) {
            t tVar = (t) message.obj;
            lVar17 = this.pL.pE;
            if (lVar17 != null) {
                lVar18 = this.pL.pE;
                lVar18.h(tVar.pM);
                return;
            }
            fY = this.pL.fY();
            if (fY) {
                BdLog.d("could not call onBinaryMessage() .. handler already NULL");
            }
        } else if (message.obj instanceof ac) {
            ad adVar = new ad();
            adVar.pM = ((ac) message.obj).pM;
            this.pL.pw.o(adVar);
        } else if (message.obj instanceof ad) {
            ad adVar2 = (ad) message.obj;
            lVar15 = this.pL.pE;
            if (lVar15 != null) {
                lVar16 = this.pL.pE;
                lVar16.fS();
            }
        } else if (message.obj instanceof v) {
            this.pL.close(1, null);
        } else if (message.obj instanceof aj) {
            aj ajVar = (aj) message.obj;
            if (ajVar.qa) {
                lVar11 = this.pL.pE;
                if (lVar11 != null) {
                    lVar12 = this.pL.pE;
                    lVar12.c(ajVar.qb);
                    this.pL.pG = true;
                    this.pL.pH = false;
                    lVar13 = this.pL.pE;
                    if (lVar13 != null) {
                        lVar14 = this.pL.pE;
                        lVar14.a(null);
                        return;
                    }
                    return;
                }
                this.pL.close(6, "handler already NULL");
            }
        } else if (message.obj instanceof w) {
            SocketException socketException = ((w) message.obj).pU;
            this.pL.close(3, "WebSockets connection lost = " + (socketException != null ? socketException.getMessage() : null));
        } else if (message.obj instanceof ae) {
            WebSocketException webSocketException = ((ae) message.obj).pY;
            this.pL.close(4, "WebSockets protocol violation error = " + (webSocketException != null ? webSocketException.getMessage() : null));
        } else if (message.obj instanceof y) {
            this.pL.close(5, "WebSockets internal error (" + ((y) message.obj).pW.toString() + ")");
        } else if (message.obj instanceof ai) {
            ai aiVar = (ai) message.obj;
            this.pL.close(6, "Server error " + aiVar.mStatusCode + " (" + aiVar.pV + ")");
        } else if (message.obj instanceof x) {
            this.pL.close(2, "WebSockets connot connect:" + ((x) message.obj).pV);
        } else if (message.obj instanceof ak) {
            lVar9 = this.pL.pE;
            if (lVar9 != null) {
                d dVar = ((ak) message.obj).pZ;
                lVar10 = this.pL.pE;
                lVar10.b(dVar);
            }
        } else if (message.obj instanceof z) {
            this.pL.pK = null;
            d dVar2 = ((z) message.obj).pZ;
            lVar5 = this.pL.pE;
            if (lVar5 != null) {
                lVar8 = this.pL.pE;
                lVar8.c(dVar2);
            }
            lVar6 = this.pL.pE;
            if (lVar6 != null) {
                lVar7 = this.pL.pE;
                lVar7.a(dVar2);
            }
        } else if (message.obj instanceof ag) {
            this.pL.pK = null;
            d dVar3 = ((ag) message.obj).pZ;
            lVar = this.pL.pE;
            if (lVar != null) {
                lVar4 = this.pL.pE;
                lVar4.a(2, dVar3);
            }
            lVar2 = this.pL.pE;
            if (lVar2 != null) {
                lVar3 = this.pL.pE;
                lVar3.a(dVar3);
            }
        } else {
            this.pL.m(message.obj);
        }
    }
}
