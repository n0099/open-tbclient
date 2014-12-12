package com.baidu.adp.lib.webSocket;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.lib.util.BdLog;
import java.net.SocketException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p extends Handler {
    final /* synthetic */ o pJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(o oVar) {
        this.pJ = oVar;
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
        boolean ga;
        l lVar18;
        l lVar19;
        boolean ga2;
        l lVar20;
        l lVar21;
        l lVar22;
        if (message.obj instanceof al) {
            al alVar = (al) message.obj;
            lVar21 = this.pJ.pC;
            if (lVar21 != null) {
                lVar22 = this.pJ.pC;
                lVar22.y(alVar.pX);
            }
        } else if (message.obj instanceof af) {
            af afVar = (af) message.obj;
            lVar19 = this.pJ.pC;
            if (lVar19 != null) {
                lVar20 = this.pJ.pC;
                lVar20.r(afVar.pK);
                return;
            }
            ga2 = this.pJ.ga();
            if (ga2) {
                BdLog.d("could not call onRawTextMessage() .. handler already NULL");
            }
        } else if (message.obj instanceof t) {
            t tVar = (t) message.obj;
            lVar17 = this.pJ.pC;
            if (lVar17 != null) {
                lVar18 = this.pJ.pC;
                lVar18.i(tVar.pK);
                return;
            }
            ga = this.pJ.ga();
            if (ga) {
                BdLog.d("could not call onBinaryMessage() .. handler already NULL");
            }
        } else if (message.obj instanceof ac) {
            ad adVar = new ad();
            adVar.pK = ((ac) message.obj).pK;
            this.pJ.pu.q(adVar);
        } else if (message.obj instanceof ad) {
            ad adVar2 = (ad) message.obj;
            lVar15 = this.pJ.pC;
            if (lVar15 != null) {
                lVar16 = this.pJ.pC;
                lVar16.fU();
            }
        } else if (message.obj instanceof v) {
            this.pJ.close(1, null);
        } else if (message.obj instanceof aj) {
            aj ajVar = (aj) message.obj;
            if (ajVar.pW) {
                lVar11 = this.pJ.pC;
                if (lVar11 != null) {
                    lVar12 = this.pJ.pC;
                    lVar12.d(ajVar.mHeaders);
                    this.pJ.pE = true;
                    this.pJ.pF = false;
                    lVar13 = this.pJ.pC;
                    if (lVar13 != null) {
                        lVar14 = this.pJ.pC;
                        lVar14.a(null);
                        return;
                    }
                    return;
                }
                this.pJ.close(6, "handler already NULL");
            }
        } else if (message.obj instanceof w) {
            SocketException socketException = ((w) message.obj).pQ;
            this.pJ.close(3, "WebSockets connection lost = " + (socketException != null ? socketException.getMessage() : null));
        } else if (message.obj instanceof ae) {
            WebSocketException webSocketException = ((ae) message.obj).pU;
            this.pJ.close(4, "WebSockets protocol violation error = " + (webSocketException != null ? webSocketException.getMessage() : null));
        } else if (message.obj instanceof y) {
            this.pJ.close(5, "WebSockets internal error (" + ((y) message.obj).pS.toString() + ")");
        } else if (message.obj instanceof ai) {
            ai aiVar = (ai) message.obj;
            this.pJ.close(6, "Server error " + aiVar.mStatusCode + " (" + aiVar.pR + ")");
        } else if (message.obj instanceof x) {
            this.pJ.close(2, "WebSockets connot connect:" + ((x) message.obj).pR);
        } else if (message.obj instanceof ak) {
            lVar9 = this.pJ.pC;
            if (lVar9 != null) {
                d dVar = ((ak) message.obj).pV;
                lVar10 = this.pJ.pC;
                lVar10.b(dVar);
            }
        } else if (message.obj instanceof z) {
            this.pJ.pI = null;
            d dVar2 = ((z) message.obj).pV;
            lVar5 = this.pJ.pC;
            if (lVar5 != null) {
                lVar8 = this.pJ.pC;
                lVar8.c(dVar2);
            }
            lVar6 = this.pJ.pC;
            if (lVar6 != null) {
                lVar7 = this.pJ.pC;
                lVar7.a(dVar2);
            }
        } else if (message.obj instanceof ag) {
            this.pJ.pI = null;
            d dVar3 = ((ag) message.obj).pV;
            lVar = this.pJ.pC;
            if (lVar != null) {
                lVar4 = this.pJ.pC;
                lVar4.a(2, dVar3);
            }
            lVar2 = this.pJ.pC;
            if (lVar2 != null) {
                lVar3 = this.pJ.pC;
                lVar3.a(dVar3);
            }
        } else {
            this.pJ.o(message.obj);
        }
    }
}
