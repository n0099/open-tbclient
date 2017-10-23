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
    private static Handler nU = new Handler();
    private SocketMessageTask nR;
    private CoderException nV;
    private SocketMessage nW;
    private g nY;
    public long od;
    public long oe;
    private volatile int nQ = 0;
    private Runnable nX = null;
    private boolean nZ = true;
    private int oa = 0;
    private int ob = 0;
    private long oc = 0;

    public e(SocketMessage socketMessage, SocketMessageTask socketMessageTask, g gVar) {
        this.nW = null;
        this.nY = null;
        this.nR = null;
        if (socketMessage == null || socketMessageTask == null) {
            throw new InvalidParameterException("SenderData msg null");
        }
        this.nR = socketMessageTask;
        this.nW = socketMessage;
        this.nY = gVar;
    }

    public int cv() {
        int retry = this.nR.getRetry();
        if (retry > 1) {
            return retry;
        }
        return 1;
    }

    private void L(int i) {
        if (this.nY != null && this.nZ) {
            this.nY.a(i, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cw() {
        if (this.nY != null && this.nZ) {
            this.nY.b(this);
        }
    }

    private void cx() {
        if (this.nY != null && this.nZ) {
            this.nY.c(this);
        }
    }

    private void cy() {
        if (this.nY != null && this.nZ) {
            this.nY.d(this);
        }
    }

    private Runnable cz() {
        if (this.nX == null) {
            this.nX = new Runnable() { // from class: com.baidu.adp.framework.client.socket.e.1
                @Override // java.lang.Runnable
                public void run() {
                    e.this.cw();
                }
            };
        }
        return this.nX;
    }

    public void cA() {
        nU.removeCallbacks(cz());
    }

    public void cB() {
        cA();
        this.nZ = false;
    }

    public long cC() {
        return this.oc;
    }

    @Override // com.baidu.adp.lib.webSocket.n
    public void cD() {
        if (this.oc == 0) {
            this.oc = System.currentTimeMillis();
        }
        i.a("SenderData", this.nW.getCmd(), this.nW.getClientLogID(), this.nQ, "StartSend", 0, "SenderData: start send size = " + (hP() != null ? hP().length : 0));
        nU.removeCallbacks(cz());
        if (this.nR.getTimeOut() != null) {
            nU.postDelayed(cz(), this.nR.getTimeOut().dw());
        }
        cy();
    }

    @Override // com.baidu.adp.lib.webSocket.n
    public void M(int i) {
        nU.removeCallbacks(cz());
        L(i);
    }

    @Override // com.baidu.adp.lib.webSocket.n
    public void cE() {
        int i;
        int cmd = this.nW.getCmd();
        if (hP() != null) {
            int length = hP().length;
            this.nW.setEncodedBinarySize(length);
            i = length;
        } else {
            i = 0;
        }
        i.a("SenderData", cmd, this.nW.getClientLogID(), this.nQ, "FinishSend", 0, "SenderData: finish send  size = " + i);
        if (!this.nR.dz()) {
            nU.removeCallbacks(cz());
        }
        cx();
    }

    public CoderException cF() {
        return this.nV;
    }

    public boolean cG() {
        return this.nR.dz();
    }

    public int getPriority() {
        return this.nR.getPriority();
    }

    public SocketMessage cH() {
        return this.nW;
    }

    public SocketMessageTask cI() {
        return this.nR;
    }

    @Override // com.baidu.adp.lib.webSocket.c
    protected byte[] cJ() {
        if (this.oc == 0) {
            this.oc = System.currentTimeMillis();
        }
        this.nV = null;
        com.baidu.adp.framework.client.socket.coder.b dj = com.baidu.adp.framework.client.socket.coder.b.dj();
        this.nQ = f.cQ().cK();
        if (this.nW != null) {
            this.nW.setSquencedId(this.nQ);
            BdStatisticsManager bdStatisticsManager = BdStatisticsManager.getInstance();
            long clientLogID = this.nW == null ? -1L : this.nW.getClientLogID();
            String valueOf = String.valueOf(this.nQ & 4294967295L);
            Object[] objArr = new Object[2];
            objArr[0] = IntentConfig.CMD;
            objArr[1] = Integer.valueOf(this.nW == null ? -1 : this.nW.getCmd());
            bdStatisticsManager.newDebug("seqid", clientLogID, valueOf, objArr);
        }
        try {
            return dj.a(this.nW, this.nQ, this.nR.dA(), this.nR.getNeedEncrypt());
        } catch (CoderException e) {
            this.nV = e;
            return null;
        }
    }

    public int getCmd() {
        if (this.nW != null) {
            return this.nW.getCmd();
        }
        return 0;
    }

    public int cK() {
        return this.nQ;
    }

    public boolean cL() {
        return this.nR.dB();
    }

    public int cM() {
        return this.ob;
    }

    public int cN() {
        int i = this.ob + 1;
        this.ob = i;
        return i;
    }

    public int cO() {
        return this.oa;
    }

    public int cP() {
        int i = this.oa + 1;
        this.oa = i;
        return i;
    }
}
