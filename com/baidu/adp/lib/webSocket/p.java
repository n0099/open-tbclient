package com.baidu.adp.lib.webSocket;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.lib.util.BdLog;
import java.net.SocketException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p extends Handler {
    final /* synthetic */ o pO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(o oVar) {
        this.pO = oVar;
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
        boolean fZ;
        l lVar18;
        l lVar19;
        boolean fZ2;
        l lVar20;
        l lVar21;
        l lVar22;
        if (message.obj instanceof al) {
            al alVar = (al) message.obj;
            lVar21 = this.pO.pH;
            if (lVar21 != null) {
                lVar22 = this.pO.pH;
                lVar22.y(alVar.qc);
            }
        } else if (message.obj instanceof af) {
            af afVar = (af) message.obj;
            lVar19 = this.pO.pH;
            if (lVar19 != null) {
                lVar20 = this.pO.pH;
                lVar20.r(afVar.pP);
                return;
            }
            fZ2 = this.pO.fZ();
            if (fZ2) {
                BdLog.d("could not call onRawTextMessage() .. handler already NULL");
            }
        } else if (message.obj instanceof t) {
            t tVar = (t) message.obj;
            lVar17 = this.pO.pH;
            if (lVar17 != null) {
                lVar18 = this.pO.pH;
                lVar18.i(tVar.pP);
                return;
            }
            fZ = this.pO.fZ();
            if (fZ) {
                BdLog.d("could not call onBinaryMessage() .. handler already NULL");
            }
        } else if (message.obj instanceof ac) {
            ad adVar = new ad();
            adVar.pP = ((ac) message.obj).pP;
            this.pO.pz.q(adVar);
        } else if (message.obj instanceof ad) {
            ad adVar2 = (ad) message.obj;
            lVar15 = this.pO.pH;
            if (lVar15 != null) {
                lVar16 = this.pO.pH;
                lVar16.fT();
            }
        } else if (message.obj instanceof v) {
            this.pO.close(1, null);
        } else if (message.obj instanceof aj) {
            aj ajVar = (aj) message.obj;
            if (ajVar.qb) {
                lVar11 = this.pO.pH;
                if (lVar11 != null) {
                    lVar12 = this.pO.pH;
                    lVar12.d(ajVar.mHeaders);
                    this.pO.pJ = true;
                    this.pO.pK = false;
                    lVar13 = this.pO.pH;
                    if (lVar13 != null) {
                        lVar14 = this.pO.pH;
                        lVar14.a(null);
                        return;
                    }
                    return;
                }
                this.pO.close(6, "handler already NULL");
            }
        } else if (message.obj instanceof w) {
            SocketException socketException = ((w) message.obj).pV;
            this.pO.close(3, "WebSockets connection lost = " + (socketException != null ? socketException.getMessage() : null));
        } else if (message.obj instanceof ae) {
            WebSocketException webSocketException = ((ae) message.obj).pZ;
            this.pO.close(4, "WebSockets protocol violation error = " + (webSocketException != null ? webSocketException.getMessage() : null));
        } else if (message.obj instanceof y) {
            this.pO.close(5, "WebSockets internal error (" + ((y) message.obj).pX.toString() + ")");
        } else if (message.obj instanceof ai) {
            ai aiVar = (ai) message.obj;
            this.pO.close(6, "Server error " + aiVar.mStatusCode + " (" + aiVar.pW + ")");
        } else if (message.obj instanceof x) {
            this.pO.close(2, "WebSockets connot connect:" + ((x) message.obj).pW);
        } else if (message.obj instanceof ak) {
            lVar9 = this.pO.pH;
            if (lVar9 != null) {
                d dVar = ((ak) message.obj).qa;
                lVar10 = this.pO.pH;
                lVar10.b(dVar);
            }
        } else if (message.obj instanceof z) {
            this.pO.pN = null;
            d dVar2 = ((z) message.obj).qa;
            lVar5 = this.pO.pH;
            if (lVar5 != null) {
                lVar8 = this.pO.pH;
                lVar8.c(dVar2);
            }
            lVar6 = this.pO.pH;
            if (lVar6 != null) {
                lVar7 = this.pO.pH;
                lVar7.a(dVar2);
            }
        } else if (message.obj instanceof ag) {
            this.pO.pN = null;
            d dVar3 = ((ag) message.obj).qa;
            lVar = this.pO.pH;
            if (lVar != null) {
                lVar4 = this.pO.pH;
                lVar4.a(2, dVar3);
            }
            lVar2 = this.pO.pH;
            if (lVar2 != null) {
                lVar3 = this.pO.pH;
                lVar3.a(dVar3);
            }
        } else {
            this.pO.o(message.obj);
        }
    }
}
