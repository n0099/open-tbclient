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
    private static Handler oA = new Handler();
    private CoderException oB;
    private SocketMessage oC;
    private g oE;
    public long oJ;
    public long oK;
    private SocketMessageTask ox;
    private volatile int ow = 0;
    private Runnable oD = null;
    private boolean oF = true;
    private int oG = 0;
    private int oH = 0;
    private long oI = 0;

    public e(SocketMessage socketMessage, SocketMessageTask socketMessageTask, g gVar) {
        this.oC = null;
        this.oE = null;
        this.ox = null;
        if (socketMessage == null || socketMessageTask == null) {
            throw new InvalidParameterException("SenderData msg null");
        }
        this.ox = socketMessageTask;
        this.oC = socketMessage;
        this.oE = gVar;
    }

    public int cv() {
        int retry = this.ox.getRetry();
        if (retry > 1) {
            return retry;
        }
        return 1;
    }

    private void L(int i) {
        if (this.oE != null && this.oF) {
            this.oE.a(i, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cw() {
        if (this.oE != null && this.oF) {
            this.oE.b(this);
        }
    }

    private void cx() {
        if (this.oE != null && this.oF) {
            this.oE.c(this);
        }
    }

    private void cy() {
        if (this.oE != null && this.oF) {
            this.oE.d(this);
        }
    }

    private Runnable cz() {
        if (this.oD == null) {
            this.oD = new Runnable() { // from class: com.baidu.adp.framework.client.socket.e.1
                @Override // java.lang.Runnable
                public void run() {
                    e.this.cw();
                }
            };
        }
        return this.oD;
    }

    public void cA() {
        oA.removeCallbacks(cz());
    }

    public void cB() {
        cA();
        this.oF = false;
    }

    public long cC() {
        return this.oI;
    }

    @Override // com.baidu.adp.lib.webSocket.n
    public void cD() {
        if (this.oI == 0) {
            this.oI = System.currentTimeMillis();
        }
        i.a("SenderData", this.oC.getCmd(), this.oC.getClientLogID(), this.ow, "StartSend", 0, "SenderData: start send size = " + (hP() != null ? hP().length : 0));
        oA.removeCallbacks(cz());
        if (this.ox.getTimeOut() != null) {
            oA.postDelayed(cz(), this.ox.getTimeOut().dv());
        }
        cy();
    }

    @Override // com.baidu.adp.lib.webSocket.n
    public void M(int i) {
        oA.removeCallbacks(cz());
        L(i);
    }

    @Override // com.baidu.adp.lib.webSocket.n
    public void cE() {
        int i;
        int cmd = this.oC.getCmd();
        if (hP() != null) {
            int length = hP().length;
            this.oC.setEncodedBinarySize(length);
            i = length;
        } else {
            i = 0;
        }
        i.a("SenderData", cmd, this.oC.getClientLogID(), this.ow, "FinishSend", 0, "SenderData: finish send  size = " + i);
        if (!this.ox.dy()) {
            oA.removeCallbacks(cz());
        }
        cx();
    }

    public CoderException cF() {
        return this.oB;
    }

    public boolean cG() {
        return this.ox.dy();
    }

    public int getPriority() {
        return this.ox.getPriority();
    }

    public SocketMessage cH() {
        return this.oC;
    }

    public SocketMessageTask cI() {
        return this.ox;
    }

    @Override // com.baidu.adp.lib.webSocket.c
    protected byte[] cJ() {
        if (this.oI == 0) {
            this.oI = System.currentTimeMillis();
        }
        this.oB = null;
        com.baidu.adp.framework.client.socket.coder.b di = com.baidu.adp.framework.client.socket.coder.b.di();
        this.ow = f.cP().cK();
        if (this.oC != null) {
            this.oC.setSquencedId(this.ow);
            BdStatisticsManager bdStatisticsManager = BdStatisticsManager.getInstance();
            long clientLogID = this.oC == null ? -1L : this.oC.getClientLogID();
            String valueOf = String.valueOf(this.ow & 4294967295L);
            Object[] objArr = new Object[2];
            objArr[0] = IntentConfig.CMD;
            objArr[1] = Integer.valueOf(this.oC == null ? -1 : this.oC.getCmd());
            bdStatisticsManager.newDebug("seqid", clientLogID, valueOf, objArr);
        }
        try {
            return di.a(this.oC, this.ow, this.ox.dz(), this.ox.getNeedEncrypt());
        } catch (CoderException e) {
            this.oB = e;
            return null;
        }
    }

    public int getCmd() {
        if (this.oC != null) {
            return this.oC.getCmd();
        }
        return 0;
    }

    public int cK() {
        return this.ow;
    }

    public boolean canRetry() {
        return this.ox.dA();
    }

    public int cL() {
        return this.oH;
    }

    public int cM() {
        int i = this.oH + 1;
        this.oH = i;
        return i;
    }

    public int cN() {
        return this.oG;
    }

    public int cO() {
        int i = this.oG + 1;
        this.oG = i;
        return i;
    }
}
