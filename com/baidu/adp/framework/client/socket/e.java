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
    private static Handler nS = new Handler();
    private SocketMessageTask nP;
    private CoderException nT;
    private SocketMessage nU;
    private g nW;
    public long ob;
    public long oc;
    private volatile int nO = 0;
    private Runnable nV = null;
    private boolean nX = true;
    private int nY = 0;
    private int nZ = 0;
    private long oa = 0;

    public e(SocketMessage socketMessage, SocketMessageTask socketMessageTask, g gVar) {
        this.nU = null;
        this.nW = null;
        this.nP = null;
        if (socketMessage == null || socketMessageTask == null) {
            throw new InvalidParameterException("SenderData msg null");
        }
        this.nP = socketMessageTask;
        this.nU = socketMessage;
        this.nW = gVar;
    }

    public int cv() {
        int retry = this.nP.getRetry();
        if (retry > 1) {
            return retry;
        }
        return 1;
    }

    private void L(int i) {
        if (this.nW != null && this.nX) {
            this.nW.a(i, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cw() {
        if (this.nW != null && this.nX) {
            this.nW.b(this);
        }
    }

    private void cx() {
        if (this.nW != null && this.nX) {
            this.nW.c(this);
        }
    }

    private void cy() {
        if (this.nW != null && this.nX) {
            this.nW.d(this);
        }
    }

    private Runnable cz() {
        if (this.nV == null) {
            this.nV = new Runnable() { // from class: com.baidu.adp.framework.client.socket.e.1
                @Override // java.lang.Runnable
                public void run() {
                    e.this.cw();
                }
            };
        }
        return this.nV;
    }

    public void cA() {
        nS.removeCallbacks(cz());
    }

    public void cB() {
        cA();
        this.nX = false;
    }

    public long cC() {
        return this.oa;
    }

    @Override // com.baidu.adp.lib.webSocket.n
    public void cD() {
        if (this.oa == 0) {
            this.oa = System.currentTimeMillis();
        }
        i.a("SenderData", this.nU.getCmd(), this.nU.getClientLogID(), this.nO, "StartSend", 0, "SenderData: start send size = " + (hQ() != null ? hQ().length : 0));
        nS.removeCallbacks(cz());
        if (this.nP.getTimeOut() != null) {
            nS.postDelayed(cz(), this.nP.getTimeOut().dw());
        }
        cy();
    }

    @Override // com.baidu.adp.lib.webSocket.n
    public void M(int i) {
        nS.removeCallbacks(cz());
        L(i);
    }

    @Override // com.baidu.adp.lib.webSocket.n
    public void cE() {
        int i;
        int cmd = this.nU.getCmd();
        if (hQ() != null) {
            int length = hQ().length;
            this.nU.setEncodedBinarySize(length);
            i = length;
        } else {
            i = 0;
        }
        i.a("SenderData", cmd, this.nU.getClientLogID(), this.nO, "FinishSend", 0, "SenderData: finish send  size = " + i);
        if (!this.nP.dz()) {
            nS.removeCallbacks(cz());
        }
        cx();
    }

    public CoderException cF() {
        return this.nT;
    }

    public boolean cG() {
        return this.nP.dz();
    }

    public int getPriority() {
        return this.nP.getPriority();
    }

    public SocketMessage cH() {
        return this.nU;
    }

    public SocketMessageTask cI() {
        return this.nP;
    }

    @Override // com.baidu.adp.lib.webSocket.c
    protected byte[] cJ() {
        if (this.oa == 0) {
            this.oa = System.currentTimeMillis();
        }
        this.nT = null;
        com.baidu.adp.framework.client.socket.coder.b dj = com.baidu.adp.framework.client.socket.coder.b.dj();
        this.nO = f.cQ().cK();
        if (this.nU != null) {
            this.nU.setSquencedId(this.nO);
            BdStatisticsManager bdStatisticsManager = BdStatisticsManager.getInstance();
            long clientLogID = this.nU == null ? -1L : this.nU.getClientLogID();
            String valueOf = String.valueOf(this.nO & 4294967295L);
            Object[] objArr = new Object[2];
            objArr[0] = IntentConfig.CMD;
            objArr[1] = Integer.valueOf(this.nU == null ? -1 : this.nU.getCmd());
            bdStatisticsManager.newDebug("seqid", clientLogID, valueOf, objArr);
        }
        try {
            return dj.a(this.nU, this.nO, this.nP.dA(), this.nP.getNeedEncrypt());
        } catch (CoderException e) {
            this.nT = e;
            return null;
        }
    }

    public int getCmd() {
        if (this.nU != null) {
            return this.nU.getCmd();
        }
        return 0;
    }

    public int cK() {
        return this.nO;
    }

    public boolean cL() {
        return this.nP.dB();
    }

    public int cM() {
        return this.nZ;
    }

    public int cN() {
        int i = this.nZ + 1;
        this.nZ = i;
        return i;
    }

    public int cO() {
        return this.nY;
    }

    public int cP() {
        int i = this.nY + 1;
        this.nY = i;
        return i;
    }
}
