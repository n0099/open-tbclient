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
    private SocketMessageTask mK;
    private CoderException mN;
    private SocketMessage mO;
    private g mQ;
    public long mW;
    public long mZ;
    private volatile int mJ = 0;
    private Runnable mP = null;
    private boolean mS = true;
    private int mT = 0;
    private int mU = 0;
    private long mV = 0;

    public e(SocketMessage socketMessage, SocketMessageTask socketMessageTask, g gVar) {
        this.mO = null;
        this.mQ = null;
        this.mK = null;
        if (socketMessage == null || socketMessageTask == null) {
            throw new InvalidParameterException("SenderData msg null");
        }
        this.mK = socketMessageTask;
        this.mO = socketMessage;
        this.mQ = gVar;
    }

    public int ce() {
        int retry = this.mK.getRetry();
        if (retry > 1) {
            return retry;
        }
        return 1;
    }

    private void E(int i) {
        if (this.mQ != null && this.mS) {
            this.mQ.a(i, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cf() {
        if (this.mQ != null && this.mS) {
            this.mQ.b(this);
        }
    }

    private void cg() {
        if (this.mQ != null && this.mS) {
            this.mQ.c(this);
        }
    }

    private void ch() {
        if (this.mQ != null && this.mS) {
            this.mQ.d(this);
        }
    }

    private Runnable ci() {
        if (this.mP == null) {
            this.mP = new Runnable() { // from class: com.baidu.adp.framework.client.socket.e.1
                @Override // java.lang.Runnable
                public void run() {
                    e.this.cf();
                }
            };
        }
        return this.mP;
    }

    public void cj() {
        sHandler.removeCallbacks(ci());
    }

    public void ck() {
        cj();
        this.mS = false;
    }

    public long cl() {
        return this.mV;
    }

    @Override // com.baidu.adp.lib.webSocket.n
    public void cm() {
        if (this.mV == 0) {
            this.mV = System.currentTimeMillis();
        }
        i.a("SenderData", this.mO.getCmd(), this.mO.getClientLogID(), this.mJ, "StartSend", 0, "SenderData: start send size = " + (hw() != null ? hw().length : 0));
        sHandler.removeCallbacks(ci());
        if (this.mK.getTimeOut() != null) {
            sHandler.postDelayed(ci(), this.mK.getTimeOut().de());
        }
        ch();
    }

    @Override // com.baidu.adp.lib.webSocket.n
    public void F(int i) {
        sHandler.removeCallbacks(ci());
        E(i);
    }

    @Override // com.baidu.adp.lib.webSocket.n
    public void cn() {
        int i;
        int cmd = this.mO.getCmd();
        if (hw() != null) {
            int length = hw().length;
            this.mO.setEncodedBinarySize(length);
            i = length;
        } else {
            i = 0;
        }
        i.a("SenderData", cmd, this.mO.getClientLogID(), this.mJ, "FinishSend", 0, "SenderData: finish send  size = " + i);
        if (!this.mK.dh()) {
            sHandler.removeCallbacks(ci());
        }
        cg();
    }

    public CoderException co() {
        return this.mN;
    }

    public boolean cp() {
        return this.mK.dh();
    }

    public int getPriority() {
        return this.mK.getPriority();
    }

    public SocketMessage cq() {
        return this.mO;
    }

    public SocketMessageTask cr() {
        return this.mK;
    }

    @Override // com.baidu.adp.lib.webSocket.c
    protected byte[] cs() {
        if (this.mV == 0) {
            this.mV = System.currentTimeMillis();
        }
        this.mN = null;
        com.baidu.adp.framework.client.socket.coder.b cR = com.baidu.adp.framework.client.socket.coder.b.cR();
        this.mJ = f.cy().getSequenceId();
        if (this.mO != null) {
            this.mO.setSquencedId(this.mJ);
            BdStatisticsManager bdStatisticsManager = BdStatisticsManager.getInstance();
            long clientLogID = this.mO == null ? -1L : this.mO.getClientLogID();
            String valueOf = String.valueOf(this.mJ & 4294967295L);
            Object[] objArr = new Object[2];
            objArr[0] = IntentConfig.CMD;
            objArr[1] = Integer.valueOf(this.mO == null ? -1 : this.mO.getCmd());
            bdStatisticsManager.newDebug("seqid", clientLogID, valueOf, objArr);
        }
        try {
            return cR.a(this.mO, this.mJ, this.mK.di(), this.mK.getNeedEncrypt());
        } catch (CoderException e) {
            this.mN = e;
            return null;
        }
    }

    public int getCmd() {
        if (this.mO != null) {
            return this.mO.getCmd();
        }
        return 0;
    }

    public int getSequenceId() {
        return this.mJ;
    }

    public boolean ct() {
        return this.mK.dj();
    }

    public int cu() {
        return this.mU;
    }

    public int cv() {
        int i = this.mU + 1;
        this.mU = i;
        return i;
    }

    public int cw() {
        return this.mT;
    }

    public int cx() {
        int i = this.mT + 1;
        this.mT = i;
        return i;
    }
}
