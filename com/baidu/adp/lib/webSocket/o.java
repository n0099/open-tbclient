package com.baidu.adp.lib.webSocket;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.lib.util.BdLog;
import java.net.SocketException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o extends Handler {
    final /* synthetic */ n An;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar) {
        this.An = nVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        k kVar;
        k kVar2;
        k kVar3;
        k kVar4;
        k kVar5;
        k kVar6;
        k kVar7;
        k kVar8;
        k kVar9;
        k kVar10;
        k kVar11;
        k kVar12;
        k kVar13;
        k kVar14;
        k kVar15;
        k kVar16;
        k kVar17;
        boolean jN;
        k kVar18;
        k kVar19;
        boolean jN2;
        k kVar20;
        k kVar21;
        k kVar22;
        if (message.obj instanceof ak) {
            ak akVar = (ak) message.obj;
            kVar21 = this.An.Ag;
            if (kVar21 != null) {
                kVar22 = this.An.Ag;
                kVar22.J(akVar.AB);
            }
        } else if (message.obj instanceof ae) {
            ae aeVar = (ae) message.obj;
            kVar19 = this.An.Ag;
            if (kVar19 != null) {
                kVar20 = this.An.Ag;
                kVar20.s(aeVar.Ao);
                return;
            }
            jN2 = this.An.jN();
            if (jN2) {
                BdLog.d("could not call onRawTextMessage() .. handler already NULL");
            }
        } else if (message.obj instanceof s) {
            s sVar = (s) message.obj;
            kVar17 = this.An.Ag;
            if (kVar17 != null) {
                kVar18 = this.An.Ag;
                kVar18.j(sVar.Ao);
                return;
            }
            jN = this.An.jN();
            if (jN) {
                BdLog.d("could not call onBinaryMessage() .. handler already NULL");
            }
        } else if (message.obj instanceof ab) {
            ac acVar = new ac();
            acVar.Ao = ((ab) message.obj).Ao;
            this.An.zX.q(acVar);
        } else if (message.obj instanceof ac) {
            ac acVar2 = (ac) message.obj;
            kVar15 = this.An.Ag;
            if (kVar15 != null) {
                kVar16 = this.An.Ag;
                kVar16.jH();
            }
        } else if (message.obj instanceof u) {
            this.An.close(1, null);
        } else if (message.obj instanceof ai) {
            ai aiVar = (ai) message.obj;
            if (aiVar.AA) {
                kVar11 = this.An.Ag;
                if (kVar11 != null) {
                    kVar12 = this.An.Ag;
                    kVar12.d(aiVar.mHeaders);
                    this.An.Ai = true;
                    this.An.Aj = false;
                    kVar13 = this.An.Ag;
                    if (kVar13 != null) {
                        kVar14 = this.An.Ag;
                        kVar14.a(null);
                        return;
                    }
                    return;
                }
                this.An.close(6, "handler already NULL");
            }
        } else if (message.obj instanceof v) {
            SocketException socketException = ((v) message.obj).Au;
            this.An.close(3, "WebSockets connection lost = " + (socketException != null ? socketException.getMessage() : null));
        } else if (message.obj instanceof ad) {
            WebSocketException webSocketException = ((ad) message.obj).Ay;
            this.An.close(4, "WebSockets protocol violation error = " + (webSocketException != null ? webSocketException.getMessage() : null));
        } else if (message.obj instanceof x) {
            this.An.close(5, "WebSockets internal error (" + ((x) message.obj).Aw.toString() + ")");
        } else if (message.obj instanceof ah) {
            ah ahVar = (ah) message.obj;
            this.An.close(6, "Server error " + ahVar.mStatusCode + " (" + ahVar.Av + ")");
        } else if (message.obj instanceof w) {
            this.An.close(2, "WebSockets connot connect:" + ((w) message.obj).Av);
        } else if (message.obj instanceof aj) {
            kVar9 = this.An.Ag;
            if (kVar9 != null) {
                c cVar = ((aj) message.obj).Az;
                kVar10 = this.An.Ag;
                kVar10.b(cVar);
            }
        } else if (message.obj instanceof y) {
            this.An.Am = null;
            c cVar2 = ((y) message.obj).Az;
            kVar5 = this.An.Ag;
            if (kVar5 != null) {
                kVar8 = this.An.Ag;
                kVar8.c(cVar2);
            }
            kVar6 = this.An.Ag;
            if (kVar6 != null) {
                kVar7 = this.An.Ag;
                kVar7.a(cVar2);
            }
        } else if (message.obj instanceof af) {
            this.An.Am = null;
            c cVar3 = ((af) message.obj).Az;
            kVar = this.An.Ag;
            if (kVar != null) {
                kVar4 = this.An.Ag;
                kVar4.a(2, cVar3);
            }
            kVar2 = this.An.Ag;
            if (kVar2 != null) {
                kVar3 = this.An.Ag;
                kVar3.a(cVar3);
            }
        } else {
            this.An.o(message.obj);
        }
    }
}
