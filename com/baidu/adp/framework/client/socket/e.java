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
    private static Handler pM = new Handler();
    private SocketMessageTask acA;
    private CoderException acD;
    private SocketMessage acE;
    private g acG;
    public long acL;
    public long acM;
    private volatile int acz = 0;
    private Runnable acF = null;
    private boolean acH = true;
    private int acI = 0;
    private int acJ = 0;
    private long acK = 0;

    public e(SocketMessage socketMessage, SocketMessageTask socketMessageTask, g gVar) {
        this.acE = null;
        this.acG = null;
        this.acA = null;
        if (socketMessage == null || socketMessageTask == null) {
            throw new InvalidParameterException("SenderData msg null");
        }
        this.acA = socketMessageTask;
        this.acE = socketMessage;
        this.acG = gVar;
    }

    public int ka() {
        int retry = this.acA.getRetry();
        if (retry > 1) {
            return retry;
        }
        return 1;
    }

    private void cE(int i) {
        if (this.acG != null && this.acH) {
            this.acG.a(i, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kb() {
        if (this.acG != null && this.acH) {
            this.acG.b(this);
        }
    }

    private void kc() {
        if (this.acG != null && this.acH) {
            this.acG.c(this);
        }
    }

    private void kd() {
        if (this.acG != null && this.acH) {
            this.acG.d(this);
        }
    }

    private Runnable ke() {
        if (this.acF == null) {
            this.acF = new Runnable() { // from class: com.baidu.adp.framework.client.socket.e.1
                @Override // java.lang.Runnable
                public void run() {
                    e.this.kb();
                }
            };
        }
        return this.acF;
    }

    public void kf() {
        pM.removeCallbacks(ke());
    }

    public void kg() {
        kf();
        this.acH = false;
    }

    public long kh() {
        return this.acK;
    }

    @Override // com.baidu.adp.lib.webSocket.n
    public void ki() {
        if (this.acK == 0) {
            this.acK = System.currentTimeMillis();
        }
        i.a("SenderData", this.acE.getCmd(), this.acE.getClientLogID(), this.acz, "StartSend", 0, "SenderData: start send size = " + (pq() != null ? pq().length : 0));
        pM.removeCallbacks(ke());
        if (this.acA.getTimeOut() != null) {
            pM.postDelayed(ke(), this.acA.getTimeOut().la());
        }
        kd();
    }

    @Override // com.baidu.adp.lib.webSocket.n
    public void cF(int i) {
        pM.removeCallbacks(ke());
        cE(i);
    }

    @Override // com.baidu.adp.lib.webSocket.n
    public void kj() {
        int i;
        int cmd = this.acE.getCmd();
        if (pq() != null) {
            int length = pq().length;
            this.acE.setEncodedBinarySize(length);
            i = length;
        } else {
            i = 0;
        }
        i.a("SenderData", cmd, this.acE.getClientLogID(), this.acz, "FinishSend", 0, "SenderData: finish send  size = " + i);
        if (!this.acA.ld()) {
            pM.removeCallbacks(ke());
        }
        kc();
    }

    public CoderException kk() {
        return this.acD;
    }

    public boolean kl() {
        return this.acA.ld();
    }

    public int getPriority() {
        return this.acA.getPriority();
    }

    public SocketMessage km() {
        return this.acE;
    }

    public SocketMessageTask kn() {
        return this.acA;
    }

    @Override // com.baidu.adp.lib.webSocket.c
    protected byte[] ko() {
        if (this.acK == 0) {
            this.acK = System.currentTimeMillis();
        }
        this.acD = null;
        com.baidu.adp.framework.client.socket.coder.b kN = com.baidu.adp.framework.client.socket.coder.b.kN();
        this.acz = f.ku().getSequenceId();
        if (this.acE != null) {
            this.acE.setSquencedId(this.acz);
            BdStatisticsManager bdStatisticsManager = BdStatisticsManager.getInstance();
            long clientLogID = this.acE == null ? -1L : this.acE.getClientLogID();
            String valueOf = String.valueOf(this.acz & 4294967295L);
            Object[] objArr = new Object[2];
            objArr[0] = IntentConfig.CMD;
            objArr[1] = Integer.valueOf(this.acE == null ? -1 : this.acE.getCmd());
            bdStatisticsManager.newDebug("seqid", clientLogID, valueOf, objArr);
        }
        try {
            return kN.a(this.acE, this.acz, this.acA.le(), this.acA.getNeedEncrypt());
        } catch (CoderException e) {
            this.acD = e;
            return null;
        }
    }

    public int getCmd() {
        if (this.acE != null) {
            return this.acE.getCmd();
        }
        return 0;
    }

    public int getSequenceId() {
        return this.acz;
    }

    public boolean kp() {
        return this.acA.lf();
    }

    public int kq() {
        return this.acJ;
    }

    public int kr() {
        int i = this.acJ + 1;
        this.acJ = i;
        return i;
    }

    public int ks() {
        return this.acI;
    }

    public int kt() {
        int i = this.acI + 1;
        this.acI = i;
        return i;
    }
}
