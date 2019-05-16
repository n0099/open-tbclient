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
    private SocketMessageTask tP;
    private CoderException tS;
    private SocketMessage tT;
    private g tV;
    public long ub;
    public long uc;
    private volatile int tO = 0;
    private Runnable tU = null;
    private boolean tW = true;
    private int tX = 0;
    private int tY = 0;
    private long tZ = 0;

    public e(SocketMessage socketMessage, SocketMessageTask socketMessageTask, g gVar) {
        this.tT = null;
        this.tV = null;
        this.tP = null;
        if (socketMessage == null || socketMessageTask == null) {
            throw new InvalidParameterException("SenderData msg null");
        }
        this.tP = socketMessageTask;
        this.tT = socketMessage;
        this.tV = gVar;
    }

    public int fh() {
        int retry = this.tP.getRetry();
        if (retry > 1) {
            return retry;
        }
        return 1;
    }

    private void F(int i) {
        if (this.tV != null && this.tW) {
            this.tV.a(i, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fi() {
        if (this.tV != null && this.tW) {
            this.tV.b(this);
        }
    }

    private void fj() {
        if (this.tV != null && this.tW) {
            this.tV.c(this);
        }
    }

    private void fk() {
        if (this.tV != null && this.tW) {
            this.tV.d(this);
        }
    }

    private Runnable fl() {
        if (this.tU == null) {
            this.tU = new Runnable() { // from class: com.baidu.adp.framework.client.socket.e.1
                @Override // java.lang.Runnable
                public void run() {
                    e.this.fi();
                }
            };
        }
        return this.tU;
    }

    public void fm() {
        sHandler.removeCallbacks(fl());
    }

    public void fn() {
        fm();
        this.tW = false;
    }

    public long fo() {
        return this.tZ;
    }

    @Override // com.baidu.adp.lib.webSocket.n
    public void fp() {
        if (this.tZ == 0) {
            this.tZ = System.currentTimeMillis();
        }
        i.a("SenderData", this.tT.getCmd(), this.tT.getClientLogID(), this.tO, "StartSend", 0, "SenderData: start send size = " + (ky() != null ? ky().length : 0));
        sHandler.removeCallbacks(fl());
        if (this.tP.getTimeOut() != null) {
            sHandler.postDelayed(fl(), this.tP.getTimeOut().gi());
        }
        fk();
    }

    @Override // com.baidu.adp.lib.webSocket.n
    public void G(int i) {
        sHandler.removeCallbacks(fl());
        F(i);
    }

    @Override // com.baidu.adp.lib.webSocket.n
    public void fq() {
        int i;
        int cmd = this.tT.getCmd();
        if (ky() != null) {
            int length = ky().length;
            this.tT.setEncodedBinarySize(length);
            i = length;
        } else {
            i = 0;
        }
        i.a("SenderData", cmd, this.tT.getClientLogID(), this.tO, "FinishSend", 0, "SenderData: finish send  size = " + i);
        if (!this.tP.gl()) {
            sHandler.removeCallbacks(fl());
        }
        fj();
    }

    public CoderException fs() {
        return this.tS;
    }

    public boolean ft() {
        return this.tP.gl();
    }

    public int getPriority() {
        return this.tP.getPriority();
    }

    public SocketMessage fu() {
        return this.tT;
    }

    public SocketMessageTask fv() {
        return this.tP;
    }

    @Override // com.baidu.adp.lib.webSocket.c
    protected byte[] fw() {
        if (this.tZ == 0) {
            this.tZ = System.currentTimeMillis();
        }
        this.tS = null;
        com.baidu.adp.framework.client.socket.coder.b fU = com.baidu.adp.framework.client.socket.coder.b.fU();
        this.tO = f.fC().getSequenceId();
        if (this.tT != null) {
            this.tT.setSquencedId(this.tO);
            BdStatisticsManager bdStatisticsManager = BdStatisticsManager.getInstance();
            long clientLogID = this.tT == null ? -1L : this.tT.getClientLogID();
            String valueOf = String.valueOf(this.tO & 4294967295L);
            Object[] objArr = new Object[2];
            objArr[0] = IntentConfig.CMD;
            objArr[1] = Integer.valueOf(this.tT == null ? -1 : this.tT.getCmd());
            bdStatisticsManager.newDebug("seqid", clientLogID, valueOf, objArr);
        }
        try {
            return fU.a(this.tT, this.tO, this.tP.gm(), this.tP.getNeedEncrypt());
        } catch (CoderException e) {
            this.tS = e;
            return null;
        }
    }

    public int getCmd() {
        if (this.tT != null) {
            return this.tT.getCmd();
        }
        return 0;
    }

    public int getSequenceId() {
        return this.tO;
    }

    public boolean fx() {
        return this.tP.gn();
    }

    public int fy() {
        return this.tY;
    }

    public int fz() {
        int i = this.tY + 1;
        this.tY = i;
        return i;
    }

    public int fA() {
        return this.tX;
    }

    public int fB() {
        int i = this.tX + 1;
        this.tX = i;
        return i;
    }
}
