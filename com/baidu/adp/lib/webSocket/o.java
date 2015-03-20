package com.baidu.adp.lib.webSocket;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.lib.util.BdLog;
import java.net.SocketException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o extends Handler {
    final /* synthetic */ n Ay;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar) {
        this.Ay = nVar;
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
        boolean jw;
        k kVar18;
        k kVar19;
        boolean jw2;
        k kVar20;
        k kVar21;
        k kVar22;
        if (message.obj instanceof ak) {
            ak akVar = (ak) message.obj;
            kVar21 = this.Ay.Ar;
            if (kVar21 != null) {
                kVar22 = this.Ay.Ar;
                kVar22.G(akVar.AN);
            }
        } else if (message.obj instanceof ae) {
            ae aeVar = (ae) message.obj;
            kVar19 = this.Ay.Ar;
            if (kVar19 != null) {
                kVar20 = this.Ay.Ar;
                kVar20.s(aeVar.Az);
                return;
            }
            jw2 = this.Ay.jw();
            if (jw2) {
                BdLog.d("could not call onRawTextMessage() .. handler already NULL");
            }
        } else if (message.obj instanceof s) {
            s sVar = (s) message.obj;
            kVar17 = this.Ay.Ar;
            if (kVar17 != null) {
                kVar18 = this.Ay.Ar;
                kVar18.j(sVar.Az);
                return;
            }
            jw = this.Ay.jw();
            if (jw) {
                BdLog.d("could not call onBinaryMessage() .. handler already NULL");
            }
        } else if (message.obj instanceof ab) {
            ac acVar = new ac();
            acVar.Az = ((ab) message.obj).Az;
            this.Ay.Aj.q(acVar);
        } else if (message.obj instanceof ac) {
            ac acVar2 = (ac) message.obj;
            kVar15 = this.Ay.Ar;
            if (kVar15 != null) {
                kVar16 = this.Ay.Ar;
                kVar16.jq();
            }
        } else if (message.obj instanceof u) {
            this.Ay.close(1, null);
        } else if (message.obj instanceof ai) {
            ai aiVar = (ai) message.obj;
            if (aiVar.AM) {
                kVar11 = this.Ay.Ar;
                if (kVar11 != null) {
                    kVar12 = this.Ay.Ar;
                    kVar12.d(aiVar.mHeaders);
                    this.Ay.At = true;
                    this.Ay.Au = false;
                    kVar13 = this.Ay.Ar;
                    if (kVar13 != null) {
                        kVar14 = this.Ay.Ar;
                        kVar14.a(null);
                        return;
                    }
                    return;
                }
                this.Ay.close(6, "handler already NULL");
            }
        } else if (message.obj instanceof v) {
            SocketException socketException = ((v) message.obj).AF;
            this.Ay.close(3, "WebSockets connection lost = " + (socketException != null ? socketException.getMessage() : null));
        } else if (message.obj instanceof ad) {
            WebSocketException webSocketException = ((ad) message.obj).AJ;
            this.Ay.close(4, "WebSockets protocol violation error = " + (webSocketException != null ? webSocketException.getMessage() : null));
        } else if (message.obj instanceof x) {
            this.Ay.close(5, "WebSockets internal error (" + ((x) message.obj).AH.toString() + ")");
        } else if (message.obj instanceof ah) {
            ah ahVar = (ah) message.obj;
            this.Ay.close(6, "Server error " + ahVar.mStatusCode + " (" + ahVar.AG + ")");
        } else if (message.obj instanceof w) {
            this.Ay.close(2, "WebSockets connot connect:" + ((w) message.obj).AG);
        } else if (message.obj instanceof aj) {
            kVar9 = this.Ay.Ar;
            if (kVar9 != null) {
                c cVar = ((aj) message.obj).AL;
                kVar10 = this.Ay.Ar;
                kVar10.b(cVar);
            }
        } else if (message.obj instanceof y) {
            this.Ay.Ax = null;
            c cVar2 = ((y) message.obj).AL;
            kVar5 = this.Ay.Ar;
            if (kVar5 != null) {
                kVar8 = this.Ay.Ar;
                kVar8.c(cVar2);
            }
            kVar6 = this.Ay.Ar;
            if (kVar6 != null) {
                kVar7 = this.Ay.Ar;
                kVar7.a(cVar2);
            }
        } else if (message.obj instanceof af) {
            this.Ay.Ax = null;
            c cVar3 = ((af) message.obj).AL;
            kVar = this.Ay.Ar;
            if (kVar != null) {
                kVar4 = this.Ay.Ar;
                kVar4.a(2, cVar3);
            }
            kVar2 = this.Ay.Ar;
            if (kVar2 != null) {
                kVar3 = this.Ay.Ar;
                kVar3.a(cVar3);
            }
        } else {
            this.Ay.o(message.obj);
        }
    }
}
