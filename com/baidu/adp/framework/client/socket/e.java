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
    private static Handler sHandler = new Handler();
    private SocketMessageTask tR;
    private CoderException tU;
    private SocketMessage tV;
    private g tX;
    public long ud;
    public long ue;
    private volatile int tQ = 0;
    private Runnable tW = null;
    private boolean tY = true;
    private int tZ = 0;
    private int ub = 0;
    private long uc = 0;

    public e(SocketMessage socketMessage, SocketMessageTask socketMessageTask, g gVar) {
        this.tV = null;
        this.tX = null;
        this.tR = null;
        if (socketMessage == null || socketMessageTask == null) {
            throw new InvalidParameterException("SenderData msg null");
        }
        this.tR = socketMessageTask;
        this.tV = socketMessage;
        this.tX = gVar;
    }

    public int fo() {
        int retry = this.tR.getRetry();
        if (retry > 1) {
            return retry;
        }
        return 1;
    }

    private void F(int i) {
        if (this.tX != null && this.tY) {
            this.tX.a(i, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fp() {
        if (this.tX != null && this.tY) {
            this.tX.b(this);
        }
    }

    private void fq() {
        if (this.tX != null && this.tY) {
            this.tX.c(this);
        }
    }

    private void fs() {
        if (this.tX != null && this.tY) {
            this.tX.d(this);
        }
    }

    private Runnable ft() {
        if (this.tW == null) {
            this.tW = new Runnable() { // from class: com.baidu.adp.framework.client.socket.e.1
                @Override // java.lang.Runnable
                public void run() {
                    e.this.fp();
                }
            };
        }
        return this.tW;
    }

    public void fu() {
        sHandler.removeCallbacks(ft());
    }

    public void fv() {
        fu();
        this.tY = false;
    }

    public long fw() {
        return this.uc;
    }

    @Override // com.baidu.adp.lib.webSocket.n
    public void fx() {
        if (this.uc == 0) {
            this.uc = System.currentTimeMillis();
        }
        i.a("SenderData", this.tV.getCmd(), this.tV.getClientLogID(), this.tQ, "StartSend", 0, "SenderData: start send size = " + (kN() != null ? kN().length : 0));
        sHandler.removeCallbacks(ft());
        if (this.tR.getTimeOut() != null) {
            sHandler.postDelayed(ft(), this.tR.getTimeOut().gr());
        }
        fs();
    }

    @Override // com.baidu.adp.lib.webSocket.n
    public void G(int i) {
        sHandler.removeCallbacks(ft());
        F(i);
    }

    @Override // com.baidu.adp.lib.webSocket.n
    public void fy() {
        int i;
        int cmd = this.tV.getCmd();
        if (kN() != null) {
            int length = kN().length;
            this.tV.setEncodedBinarySize(length);
            i = length;
        } else {
            i = 0;
        }
        i.a("SenderData", cmd, this.tV.getClientLogID(), this.tQ, "FinishSend", 0, "SenderData: finish send  size = " + i);
        if (!this.tR.gu()) {
            sHandler.removeCallbacks(ft());
        }
        fq();
    }

    public CoderException fz() {
        return this.tU;
    }

    public boolean fA() {
        return this.tR.gu();
    }

    public int getPriority() {
        return this.tR.getPriority();
    }

    public SocketMessage fB() {
        return this.tV;
    }

    public SocketMessageTask fC() {
        return this.tR;
    }

    @Override // com.baidu.adp.lib.webSocket.c
    protected byte[] fD() {
        if (this.uc == 0) {
            this.uc = System.currentTimeMillis();
        }
        this.tU = null;
        com.baidu.adp.framework.client.socket.coder.b gd = com.baidu.adp.framework.client.socket.coder.b.gd();
        this.tQ = f.fK().fE();
        if (this.tV != null) {
            this.tV.setSquencedId(this.tQ);
            BdStatisticsManager bdStatisticsManager = BdStatisticsManager.getInstance();
            long clientLogID = this.tV == null ? -1L : this.tV.getClientLogID();
            String valueOf = String.valueOf(this.tQ & 4294967295L);
            Object[] objArr = new Object[2];
            objArr[0] = IntentConfig.CMD;
            objArr[1] = Integer.valueOf(this.tV == null ? -1 : this.tV.getCmd());
            bdStatisticsManager.newDebug("seqid", clientLogID, valueOf, objArr);
        }
        try {
            return gd.a(this.tV, this.tQ, this.tR.gv(), this.tR.getNeedEncrypt());
        } catch (CoderException e) {
            this.tU = e;
            return null;
        }
    }

    public int getCmd() {
        if (this.tV != null) {
            return this.tV.getCmd();
        }
        return 0;
    }

    public int fE() {
        return this.tQ;
    }

    public boolean fF() {
        return this.tR.gw();
    }

    public int fG() {
        return this.ub;
    }

    public int fH() {
        int i = this.ub + 1;
        this.ub = i;
        return i;
    }

    public int fI() {
        return this.tZ;
    }

    public int fJ() {
        int i = this.tZ + 1;
        this.tZ = i;
        return i;
    }
}
