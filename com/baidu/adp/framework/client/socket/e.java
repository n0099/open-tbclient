package com.baidu.adp.framework.client.socket;

import android.os.Handler;
import com.baidu.adp.framework.client.socket.coder.CoderException;
import com.baidu.adp.framework.message.SocketMessage;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import java.security.InvalidParameterException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends com.baidu.adp.lib.webSocket.c {
    private static Handler oz = new Handler();
    private CoderException oA;
    private SocketMessage oB;
    private h oD;
    public long oI;
    public long oJ;
    private SocketMessageTask ow;
    private volatile int ov = 0;
    private Runnable oC = null;
    private boolean oE = true;
    private int oF = 0;
    private int oG = 0;
    private long oH = 0;

    public e(SocketMessage socketMessage, SocketMessageTask socketMessageTask, h hVar) {
        this.oB = null;
        this.oD = null;
        this.ow = null;
        if (socketMessage == null || socketMessageTask == null) {
            throw new InvalidParameterException("SenderData msg null");
        }
        this.ow = socketMessageTask;
        this.oB = socketMessage;
        this.oD = hVar;
    }

    public int cv() {
        int retry = this.ow.getRetry();
        if (retry > 1) {
            return retry;
        }
        return 1;
    }

    private void L(int i) {
        if (this.oD != null && this.oE) {
            this.oD.a(i, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cw() {
        if (this.oD != null && this.oE) {
            this.oD.b(this);
        }
    }

    private void cx() {
        if (this.oD != null && this.oE) {
            this.oD.c(this);
        }
    }

    private void cy() {
        if (this.oD != null && this.oE) {
            this.oD.d(this);
        }
    }

    private Runnable cz() {
        if (this.oC == null) {
            this.oC = new f(this);
        }
        return this.oC;
    }

    public void cA() {
        oz.removeCallbacks(cz());
    }

    public void cB() {
        cA();
        this.oE = false;
    }

    public long cC() {
        return this.oH;
    }

    @Override // com.baidu.adp.lib.webSocket.p
    public void cD() {
        if (this.oH == 0) {
            this.oH = System.currentTimeMillis();
        }
        k.a("SenderData", this.oB.getCmd(), this.oB.getClientLogID(), this.ov, "StartSend", 0, "SenderData: start send size = " + (hT() != null ? hT().length : 0));
        oz.removeCallbacks(cz());
        if (this.ow.getTimeOut() != null) {
            oz.postDelayed(cz(), this.ow.getTimeOut().dw());
        }
        cy();
    }

    @Override // com.baidu.adp.lib.webSocket.p
    public void M(int i) {
        oz.removeCallbacks(cz());
        L(i);
    }

    @Override // com.baidu.adp.lib.webSocket.p
    public void cE() {
        int i;
        int cmd = this.oB.getCmd();
        if (hT() != null) {
            int length = hT().length;
            this.oB.setEncodedBinarySize(length);
            i = length;
        } else {
            i = 0;
        }
        k.a("SenderData", cmd, this.oB.getClientLogID(), this.ov, "FinishSend", 0, "SenderData: finish send  size = " + i);
        if (!this.ow.dz()) {
            oz.removeCallbacks(cz());
        }
        cx();
    }

    public CoderException cF() {
        return this.oA;
    }

    public boolean cG() {
        return this.ow.dz();
    }

    public int getPriority() {
        return this.ow.getPriority();
    }

    public SocketMessage cH() {
        return this.oB;
    }

    public SocketMessageTask cI() {
        return this.ow;
    }

    @Override // com.baidu.adp.lib.webSocket.c
    protected byte[] cJ() {
        if (this.oH == 0) {
            this.oH = System.currentTimeMillis();
        }
        this.oA = null;
        com.baidu.adp.framework.client.socket.coder.b dj = com.baidu.adp.framework.client.socket.coder.b.dj();
        this.ov = g.cP().cK();
        if (this.oB != null) {
            this.oB.setSquencedId(this.ov);
            BdStatisticsManager bdStatisticsManager = BdStatisticsManager.getInstance();
            long clientLogID = this.oB == null ? -1L : this.oB.getClientLogID();
            String valueOf = String.valueOf(this.ov & 4294967295L);
            Object[] objArr = new Object[2];
            objArr[0] = IntentConfig.CMD;
            objArr[1] = Integer.valueOf(this.oB == null ? -1 : this.oB.getCmd());
            bdStatisticsManager.newDebug("seqid", clientLogID, valueOf, objArr);
        }
        try {
            return dj.a(this.oB, this.ov, this.ow.dA(), this.ow.getNeedEncrypt());
        } catch (CoderException e) {
            this.oA = e;
            return null;
        }
    }

    public int getCmd() {
        if (this.oB != null) {
            return this.oB.getCmd();
        }
        return 0;
    }

    public int cK() {
        return this.ov;
    }

    public boolean canRetry() {
        return this.ow.dB();
    }

    public int cL() {
        return this.oG;
    }

    public int cM() {
        int i = this.oG + 1;
        this.oG = i;
        return i;
    }

    public int cN() {
        return this.oF;
    }

    public int cO() {
        int i = this.oF + 1;
        this.oF = i;
        return i;
    }
}
