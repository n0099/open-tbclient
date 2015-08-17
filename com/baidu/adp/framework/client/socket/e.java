package com.baidu.adp.framework.client.socket;

import android.os.Handler;
import com.baidu.adp.framework.client.socket.coder.CoderException;
import com.baidu.adp.framework.message.SocketMessage;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import java.security.InvalidParameterException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends com.baidu.adp.lib.webSocket.c {
    private static Handler oy = new Handler();
    private SocketMessage oA;
    private h oC;
    private SocketMessageTask ov;
    private CoderException oz;
    private volatile int ou = 0;
    private Runnable oB = null;
    private boolean oD = true;
    private int oE = 0;
    private int oF = 0;
    private long oG = 0;

    public e(SocketMessage socketMessage, SocketMessageTask socketMessageTask, h hVar) {
        this.oA = null;
        this.oC = null;
        this.ov = null;
        if (socketMessage == null || socketMessageTask == null) {
            throw new InvalidParameterException("SenderData msg null");
        }
        this.ov = socketMessageTask;
        this.oA = socketMessage;
        this.oC = hVar;
    }

    public int dZ() {
        int retry = this.ov.getRetry();
        if (retry > 1) {
            return retry;
        }
        return 1;
    }

    private void x(int i) {
        if (this.oC != null && this.oD) {
            this.oC.a(i, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ea() {
        if (this.oC != null && this.oD) {
            this.oC.b(this);
        }
    }

    private void eb() {
        if (this.oC != null && this.oD) {
            this.oC.c(this);
        }
    }

    private void ec() {
        if (this.oC != null && this.oD) {
            this.oC.d(this);
        }
    }

    private Runnable ed() {
        if (this.oB == null) {
            this.oB = new f(this);
        }
        return this.oB;
    }

    public void ee() {
        oy.removeCallbacks(ed());
    }

    public void ef() {
        ee();
        this.oD = false;
    }

    public long eg() {
        return this.oG;
    }

    @Override // com.baidu.adp.lib.webSocket.p
    public void eh() {
        if (this.oG == 0) {
            this.oG = System.currentTimeMillis();
        }
        k.a("SenderData", this.oA.getCmd(), this.oA.getClientLogID(), this.ou, "StartSend", 0, "SenderData: start send size = " + (jw() != null ? jw().length : 0));
        oy.removeCallbacks(ed());
        if (this.ov.getTimeOut() != null) {
            oy.postDelayed(ed(), this.ov.getTimeOut().fa());
        }
        ec();
    }

    @Override // com.baidu.adp.lib.webSocket.p
    public void y(int i) {
        oy.removeCallbacks(ed());
        x(i);
    }

    @Override // com.baidu.adp.lib.webSocket.p
    public void ei() {
        int i;
        int cmd = this.oA.getCmd();
        if (jw() != null) {
            int length = jw().length;
            this.oA.setEncodedBinarySize(length);
            i = length;
        } else {
            i = 0;
        }
        k.a("SenderData", cmd, this.oA.getClientLogID(), this.ou, "FinishSend", 0, "SenderData: finish send  size = " + i);
        if (!this.ov.fd()) {
            oy.removeCallbacks(ed());
        }
        eb();
    }

    public CoderException ej() {
        return this.oz;
    }

    public boolean ek() {
        return this.ov.fd();
    }

    public int getPriority() {
        return this.ov.getPriority();
    }

    public SocketMessage el() {
        return this.oA;
    }

    public SocketMessageTask em() {
        return this.ov;
    }

    @Override // com.baidu.adp.lib.webSocket.c
    protected byte[] en() {
        this.oz = null;
        com.baidu.adp.framework.client.socket.coder.b eL = com.baidu.adp.framework.client.socket.coder.b.eL();
        this.ou = g.eu().eo();
        com.baidu.adp.lib.stats.a hk = com.baidu.adp.lib.stats.a.hk();
        long clientLogID = this.oA == null ? -1L : this.oA.getClientLogID();
        String valueOf = String.valueOf(this.ou & 4294967295L);
        Object[] objArr = new Object[2];
        objArr[0] = IntentConfig.CMD;
        objArr[1] = Integer.valueOf(this.oA == null ? -1 : this.oA.getCmd());
        hk.a("seqid", clientLogID, valueOf, objArr);
        try {
            return eL.a(this.oA, this.ou, this.ov.fe(), this.ov.getNeedEncrypt());
        } catch (CoderException e) {
            this.oz = e;
            return null;
        }
    }

    public int getCmd() {
        if (this.oA != null) {
            return this.oA.getCmd();
        }
        return 0;
    }

    public int eo() {
        return this.ou;
    }

    public boolean ep() {
        return this.ov.ff();
    }

    public int eq() {
        return this.oF;
    }

    public int er() {
        int i = this.oF + 1;
        this.oF = i;
        return i;
    }

    public int es() {
        return this.oE;
    }

    public int et() {
        int i = this.oE + 1;
        this.oE = i;
        return i;
    }
}
