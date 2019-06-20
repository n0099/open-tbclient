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
    private SocketMessageTask tO;
    private CoderException tR;
    private SocketMessage tS;
    private g tU;
    public long tZ;
    public long ub;
    private volatile int tN = 0;
    private Runnable tT = null;
    private boolean tV = true;
    private int tW = 0;
    private int tX = 0;
    private long tY = 0;

    public e(SocketMessage socketMessage, SocketMessageTask socketMessageTask, g gVar) {
        this.tS = null;
        this.tU = null;
        this.tO = null;
        if (socketMessage == null || socketMessageTask == null) {
            throw new InvalidParameterException("SenderData msg null");
        }
        this.tO = socketMessageTask;
        this.tS = socketMessage;
        this.tU = gVar;
    }

    public int fh() {
        int retry = this.tO.getRetry();
        if (retry > 1) {
            return retry;
        }
        return 1;
    }

    private void F(int i) {
        if (this.tU != null && this.tV) {
            this.tU.a(i, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fi() {
        if (this.tU != null && this.tV) {
            this.tU.b(this);
        }
    }

    private void fj() {
        if (this.tU != null && this.tV) {
            this.tU.c(this);
        }
    }

    private void fk() {
        if (this.tU != null && this.tV) {
            this.tU.d(this);
        }
    }

    private Runnable fl() {
        if (this.tT == null) {
            this.tT = new Runnable() { // from class: com.baidu.adp.framework.client.socket.e.1
                @Override // java.lang.Runnable
                public void run() {
                    e.this.fi();
                }
            };
        }
        return this.tT;
    }

    public void fm() {
        sHandler.removeCallbacks(fl());
    }

    public void fn() {
        fm();
        this.tV = false;
    }

    public long fo() {
        return this.tY;
    }

    @Override // com.baidu.adp.lib.webSocket.n
    public void fp() {
        if (this.tY == 0) {
            this.tY = System.currentTimeMillis();
        }
        i.a("SenderData", this.tS.getCmd(), this.tS.getClientLogID(), this.tN, "StartSend", 0, "SenderData: start send size = " + (ky() != null ? ky().length : 0));
        sHandler.removeCallbacks(fl());
        if (this.tO.getTimeOut() != null) {
            sHandler.postDelayed(fl(), this.tO.getTimeOut().gi());
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
        int cmd = this.tS.getCmd();
        if (ky() != null) {
            int length = ky().length;
            this.tS.setEncodedBinarySize(length);
            i = length;
        } else {
            i = 0;
        }
        i.a("SenderData", cmd, this.tS.getClientLogID(), this.tN, "FinishSend", 0, "SenderData: finish send  size = " + i);
        if (!this.tO.gl()) {
            sHandler.removeCallbacks(fl());
        }
        fj();
    }

    public CoderException fs() {
        return this.tR;
    }

    public boolean ft() {
        return this.tO.gl();
    }

    public int getPriority() {
        return this.tO.getPriority();
    }

    public SocketMessage fu() {
        return this.tS;
    }

    public SocketMessageTask fv() {
        return this.tO;
    }

    @Override // com.baidu.adp.lib.webSocket.c
    protected byte[] fw() {
        if (this.tY == 0) {
            this.tY = System.currentTimeMillis();
        }
        this.tR = null;
        com.baidu.adp.framework.client.socket.coder.b fU = com.baidu.adp.framework.client.socket.coder.b.fU();
        this.tN = f.fC().getSequenceId();
        if (this.tS != null) {
            this.tS.setSquencedId(this.tN);
            BdStatisticsManager bdStatisticsManager = BdStatisticsManager.getInstance();
            long clientLogID = this.tS == null ? -1L : this.tS.getClientLogID();
            String valueOf = String.valueOf(this.tN & 4294967295L);
            Object[] objArr = new Object[2];
            objArr[0] = IntentConfig.CMD;
            objArr[1] = Integer.valueOf(this.tS == null ? -1 : this.tS.getCmd());
            bdStatisticsManager.newDebug("seqid", clientLogID, valueOf, objArr);
        }
        try {
            return fU.a(this.tS, this.tN, this.tO.gm(), this.tO.getNeedEncrypt());
        } catch (CoderException e) {
            this.tR = e;
            return null;
        }
    }

    public int getCmd() {
        if (this.tS != null) {
            return this.tS.getCmd();
        }
        return 0;
    }

    public int getSequenceId() {
        return this.tN;
    }

    public boolean fx() {
        return this.tO.gn();
    }

    public int fy() {
        return this.tX;
    }

    public int fz() {
        int i = this.tX + 1;
        this.tX = i;
        return i;
    }

    public int fA() {
        return this.tW;
    }

    public int fB() {
        int i = this.tW + 1;
        this.tW = i;
        return i;
    }
}
