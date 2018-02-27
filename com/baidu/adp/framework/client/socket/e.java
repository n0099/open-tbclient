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
    private static Handler pL = new Handler();
    private g acA;
    public long acF;
    public long acG;
    private SocketMessageTask acu;
    private CoderException acx;
    private SocketMessage acy;
    private volatile int act = 0;
    private Runnable acz = null;
    private boolean acB = true;
    private int acC = 0;
    private int acD = 0;
    private long acE = 0;

    public e(SocketMessage socketMessage, SocketMessageTask socketMessageTask, g gVar) {
        this.acy = null;
        this.acA = null;
        this.acu = null;
        if (socketMessage == null || socketMessageTask == null) {
            throw new InvalidParameterException("SenderData msg null");
        }
        this.acu = socketMessageTask;
        this.acy = socketMessage;
        this.acA = gVar;
    }

    public int ka() {
        int retry = this.acu.getRetry();
        if (retry > 1) {
            return retry;
        }
        return 1;
    }

    private void cE(int i) {
        if (this.acA != null && this.acB) {
            this.acA.a(i, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kb() {
        if (this.acA != null && this.acB) {
            this.acA.b(this);
        }
    }

    private void kc() {
        if (this.acA != null && this.acB) {
            this.acA.c(this);
        }
    }

    private void kd() {
        if (this.acA != null && this.acB) {
            this.acA.d(this);
        }
    }

    private Runnable ke() {
        if (this.acz == null) {
            this.acz = new Runnable() { // from class: com.baidu.adp.framework.client.socket.e.1
                @Override // java.lang.Runnable
                public void run() {
                    e.this.kb();
                }
            };
        }
        return this.acz;
    }

    public void kf() {
        pL.removeCallbacks(ke());
    }

    public void kg() {
        kf();
        this.acB = false;
    }

    public long kh() {
        return this.acE;
    }

    @Override // com.baidu.adp.lib.webSocket.n
    public void ki() {
        if (this.acE == 0) {
            this.acE = System.currentTimeMillis();
        }
        i.a("SenderData", this.acy.getCmd(), this.acy.getClientLogID(), this.act, "StartSend", 0, "SenderData: start send size = " + (pq() != null ? pq().length : 0));
        pL.removeCallbacks(ke());
        if (this.acu.getTimeOut() != null) {
            pL.postDelayed(ke(), this.acu.getTimeOut().la());
        }
        kd();
    }

    @Override // com.baidu.adp.lib.webSocket.n
    public void cF(int i) {
        pL.removeCallbacks(ke());
        cE(i);
    }

    @Override // com.baidu.adp.lib.webSocket.n
    public void kj() {
        int i;
        int cmd = this.acy.getCmd();
        if (pq() != null) {
            int length = pq().length;
            this.acy.setEncodedBinarySize(length);
            i = length;
        } else {
            i = 0;
        }
        i.a("SenderData", cmd, this.acy.getClientLogID(), this.act, "FinishSend", 0, "SenderData: finish send  size = " + i);
        if (!this.acu.ld()) {
            pL.removeCallbacks(ke());
        }
        kc();
    }

    public CoderException kk() {
        return this.acx;
    }

    public boolean kl() {
        return this.acu.ld();
    }

    public int getPriority() {
        return this.acu.getPriority();
    }

    public SocketMessage km() {
        return this.acy;
    }

    public SocketMessageTask kn() {
        return this.acu;
    }

    @Override // com.baidu.adp.lib.webSocket.c
    protected byte[] ko() {
        if (this.acE == 0) {
            this.acE = System.currentTimeMillis();
        }
        this.acx = null;
        com.baidu.adp.framework.client.socket.coder.b kN = com.baidu.adp.framework.client.socket.coder.b.kN();
        this.act = f.ku().getSequenceId();
        if (this.acy != null) {
            this.acy.setSquencedId(this.act);
            BdStatisticsManager bdStatisticsManager = BdStatisticsManager.getInstance();
            long clientLogID = this.acy == null ? -1L : this.acy.getClientLogID();
            String valueOf = String.valueOf(this.act & 4294967295L);
            Object[] objArr = new Object[2];
            objArr[0] = IntentConfig.CMD;
            objArr[1] = Integer.valueOf(this.acy == null ? -1 : this.acy.getCmd());
            bdStatisticsManager.newDebug("seqid", clientLogID, valueOf, objArr);
        }
        try {
            return kN.a(this.acy, this.act, this.acu.le(), this.acu.getNeedEncrypt());
        } catch (CoderException e) {
            this.acx = e;
            return null;
        }
    }

    public int getCmd() {
        if (this.acy != null) {
            return this.acy.getCmd();
        }
        return 0;
    }

    public int getSequenceId() {
        return this.act;
    }

    public boolean kp() {
        return this.acu.lf();
    }

    public int kq() {
        return this.acD;
    }

    public int kr() {
        int i = this.acD + 1;
        this.acD = i;
        return i;
    }

    public int ks() {
        return this.acC;
    }

    public int kt() {
        int i = this.acC + 1;
        this.acC = i;
        return i;
    }
}
