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
    private SocketMessageTask acC;
    private CoderException acF;
    private SocketMessage acG;
    private g acI;
    public long acN;
    public long acO;
    private volatile int acB = 0;
    private Runnable acH = null;
    private boolean acJ = true;
    private int acK = 0;
    private int acL = 0;
    private long acM = 0;

    public e(SocketMessage socketMessage, SocketMessageTask socketMessageTask, g gVar) {
        this.acG = null;
        this.acI = null;
        this.acC = null;
        if (socketMessage == null || socketMessageTask == null) {
            throw new InvalidParameterException("SenderData msg null");
        }
        this.acC = socketMessageTask;
        this.acG = socketMessage;
        this.acI = gVar;
    }

    public int ka() {
        int retry = this.acC.getRetry();
        if (retry > 1) {
            return retry;
        }
        return 1;
    }

    private void cE(int i) {
        if (this.acI != null && this.acJ) {
            this.acI.a(i, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kb() {
        if (this.acI != null && this.acJ) {
            this.acI.b(this);
        }
    }

    private void kc() {
        if (this.acI != null && this.acJ) {
            this.acI.c(this);
        }
    }

    private void kd() {
        if (this.acI != null && this.acJ) {
            this.acI.d(this);
        }
    }

    private Runnable ke() {
        if (this.acH == null) {
            this.acH = new Runnable() { // from class: com.baidu.adp.framework.client.socket.e.1
                @Override // java.lang.Runnable
                public void run() {
                    e.this.kb();
                }
            };
        }
        return this.acH;
    }

    public void kf() {
        pM.removeCallbacks(ke());
    }

    public void kg() {
        kf();
        this.acJ = false;
    }

    public long kh() {
        return this.acM;
    }

    @Override // com.baidu.adp.lib.webSocket.n
    public void ki() {
        if (this.acM == 0) {
            this.acM = System.currentTimeMillis();
        }
        i.a("SenderData", this.acG.getCmd(), this.acG.getClientLogID(), this.acB, "StartSend", 0, "SenderData: start send size = " + (pp() != null ? pp().length : 0));
        pM.removeCallbacks(ke());
        if (this.acC.getTimeOut() != null) {
            pM.postDelayed(ke(), this.acC.getTimeOut().la());
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
        int cmd = this.acG.getCmd();
        if (pp() != null) {
            int length = pp().length;
            this.acG.setEncodedBinarySize(length);
            i = length;
        } else {
            i = 0;
        }
        i.a("SenderData", cmd, this.acG.getClientLogID(), this.acB, "FinishSend", 0, "SenderData: finish send  size = " + i);
        if (!this.acC.ld()) {
            pM.removeCallbacks(ke());
        }
        kc();
    }

    public CoderException kk() {
        return this.acF;
    }

    public boolean kl() {
        return this.acC.ld();
    }

    public int getPriority() {
        return this.acC.getPriority();
    }

    public SocketMessage km() {
        return this.acG;
    }

    public SocketMessageTask kn() {
        return this.acC;
    }

    @Override // com.baidu.adp.lib.webSocket.c
    protected byte[] ko() {
        if (this.acM == 0) {
            this.acM = System.currentTimeMillis();
        }
        this.acF = null;
        com.baidu.adp.framework.client.socket.coder.b kN = com.baidu.adp.framework.client.socket.coder.b.kN();
        this.acB = f.ku().getSequenceId();
        if (this.acG != null) {
            this.acG.setSquencedId(this.acB);
            BdStatisticsManager bdStatisticsManager = BdStatisticsManager.getInstance();
            long clientLogID = this.acG == null ? -1L : this.acG.getClientLogID();
            String valueOf = String.valueOf(this.acB & 4294967295L);
            Object[] objArr = new Object[2];
            objArr[0] = IntentConfig.CMD;
            objArr[1] = Integer.valueOf(this.acG == null ? -1 : this.acG.getCmd());
            bdStatisticsManager.newDebug("seqid", clientLogID, valueOf, objArr);
        }
        try {
            return kN.a(this.acG, this.acB, this.acC.le(), this.acC.getNeedEncrypt());
        } catch (CoderException e) {
            this.acF = e;
            return null;
        }
    }

    public int getCmd() {
        if (this.acG != null) {
            return this.acG.getCmd();
        }
        return 0;
    }

    public int getSequenceId() {
        return this.acB;
    }

    public boolean kp() {
        return this.acC.lf();
    }

    public int kq() {
        return this.acL;
    }

    public int kr() {
        int i = this.acL + 1;
        this.acL = i;
        return i;
    }

    public int ks() {
        return this.acK;
    }

    public int kt() {
        int i = this.acK + 1;
        this.acK = i;
        return i;
    }
}
