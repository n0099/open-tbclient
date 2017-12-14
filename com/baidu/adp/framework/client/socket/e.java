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
    private static Handler nT = new Handler();
    private SocketMessageTask nQ;
    private CoderException nU;
    private SocketMessage nV;
    private g nX;
    public long oc;
    public long od;
    private volatile int nP = 0;
    private Runnable nW = null;
    private boolean nY = true;
    private int nZ = 0;
    private int oa = 0;
    private long ob = 0;

    public e(SocketMessage socketMessage, SocketMessageTask socketMessageTask, g gVar) {
        this.nV = null;
        this.nX = null;
        this.nQ = null;
        if (socketMessage == null || socketMessageTask == null) {
            throw new InvalidParameterException("SenderData msg null");
        }
        this.nQ = socketMessageTask;
        this.nV = socketMessage;
        this.nX = gVar;
    }

    public int cv() {
        int retry = this.nQ.getRetry();
        if (retry > 1) {
            return retry;
        }
        return 1;
    }

    private void K(int i) {
        if (this.nX != null && this.nY) {
            this.nX.a(i, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cw() {
        if (this.nX != null && this.nY) {
            this.nX.b(this);
        }
    }

    private void cx() {
        if (this.nX != null && this.nY) {
            this.nX.c(this);
        }
    }

    private void cy() {
        if (this.nX != null && this.nY) {
            this.nX.d(this);
        }
    }

    private Runnable cz() {
        if (this.nW == null) {
            this.nW = new Runnable() { // from class: com.baidu.adp.framework.client.socket.e.1
                @Override // java.lang.Runnable
                public void run() {
                    e.this.cw();
                }
            };
        }
        return this.nW;
    }

    public void cA() {
        nT.removeCallbacks(cz());
    }

    public void cB() {
        cA();
        this.nY = false;
    }

    public long cC() {
        return this.ob;
    }

    @Override // com.baidu.adp.lib.webSocket.n
    public void cD() {
        if (this.ob == 0) {
            this.ob = System.currentTimeMillis();
        }
        i.a("SenderData", this.nV.getCmd(), this.nV.getClientLogID(), this.nP, "StartSend", 0, "SenderData: start send size = " + (hP() != null ? hP().length : 0));
        nT.removeCallbacks(cz());
        if (this.nQ.getTimeOut() != null) {
            nT.postDelayed(cz(), this.nQ.getTimeOut().dw());
        }
        cy();
    }

    @Override // com.baidu.adp.lib.webSocket.n
    public void L(int i) {
        nT.removeCallbacks(cz());
        K(i);
    }

    @Override // com.baidu.adp.lib.webSocket.n
    public void cE() {
        int i;
        int cmd = this.nV.getCmd();
        if (hP() != null) {
            int length = hP().length;
            this.nV.setEncodedBinarySize(length);
            i = length;
        } else {
            i = 0;
        }
        i.a("SenderData", cmd, this.nV.getClientLogID(), this.nP, "FinishSend", 0, "SenderData: finish send  size = " + i);
        if (!this.nQ.dz()) {
            nT.removeCallbacks(cz());
        }
        cx();
    }

    public CoderException cF() {
        return this.nU;
    }

    public boolean cG() {
        return this.nQ.dz();
    }

    public int getPriority() {
        return this.nQ.getPriority();
    }

    public SocketMessage cH() {
        return this.nV;
    }

    public SocketMessageTask cI() {
        return this.nQ;
    }

    @Override // com.baidu.adp.lib.webSocket.c
    protected byte[] cJ() {
        if (this.ob == 0) {
            this.ob = System.currentTimeMillis();
        }
        this.nU = null;
        com.baidu.adp.framework.client.socket.coder.b dj = com.baidu.adp.framework.client.socket.coder.b.dj();
        this.nP = f.cQ().cK();
        if (this.nV != null) {
            this.nV.setSquencedId(this.nP);
            BdStatisticsManager bdStatisticsManager = BdStatisticsManager.getInstance();
            long clientLogID = this.nV == null ? -1L : this.nV.getClientLogID();
            String valueOf = String.valueOf(this.nP & 4294967295L);
            Object[] objArr = new Object[2];
            objArr[0] = IntentConfig.CMD;
            objArr[1] = Integer.valueOf(this.nV == null ? -1 : this.nV.getCmd());
            bdStatisticsManager.newDebug("seqid", clientLogID, valueOf, objArr);
        }
        try {
            return dj.a(this.nV, this.nP, this.nQ.dA(), this.nQ.getNeedEncrypt());
        } catch (CoderException e) {
            this.nU = e;
            return null;
        }
    }

    public int getCmd() {
        if (this.nV != null) {
            return this.nV.getCmd();
        }
        return 0;
    }

    public int cK() {
        return this.nP;
    }

    public boolean cL() {
        return this.nQ.dB();
    }

    public int cM() {
        return this.oa;
    }

    public int cN() {
        int i = this.oa + 1;
        this.oa = i;
        return i;
    }

    public int cO() {
        return this.nZ;
    }

    public int cP() {
        int i = this.nZ + 1;
        this.nZ = i;
        return i;
    }
}
