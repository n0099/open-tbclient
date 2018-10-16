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
    private SocketMessageTask wj;
    private CoderException wn;
    private SocketMessage wo;
    private g wq;
    public long wu;
    public long wv;
    private volatile int wi = 0;
    private Runnable wp = null;
    private boolean mIsValid = true;
    private int wr = 0;
    private int ws = 0;
    private long wt = 0;

    public e(SocketMessage socketMessage, SocketMessageTask socketMessageTask, g gVar) {
        this.wo = null;
        this.wq = null;
        this.wj = null;
        if (socketMessage == null || socketMessageTask == null) {
            throw new InvalidParameterException("SenderData msg null");
        }
        this.wj = socketMessageTask;
        this.wo = socketMessage;
        this.wq = gVar;
    }

    public int gs() {
        int retry = this.wj.getRetry();
        if (retry > 1) {
            return retry;
        }
        return 1;
    }

    private void N(int i) {
        if (this.wq != null && this.mIsValid) {
            this.wq.a(i, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gt() {
        if (this.wq != null && this.mIsValid) {
            this.wq.b(this);
        }
    }

    private void gu() {
        if (this.wq != null && this.mIsValid) {
            this.wq.c(this);
        }
    }

    private void gv() {
        if (this.wq != null && this.mIsValid) {
            this.wq.d(this);
        }
    }

    private Runnable gw() {
        if (this.wp == null) {
            this.wp = new Runnable() { // from class: com.baidu.adp.framework.client.socket.e.1
                @Override // java.lang.Runnable
                public void run() {
                    e.this.gt();
                }
            };
        }
        return this.wp;
    }

    public void gx() {
        sHandler.removeCallbacks(gw());
    }

    public void gy() {
        gx();
        this.mIsValid = false;
    }

    public long gA() {
        return this.wt;
    }

    @Override // com.baidu.adp.lib.webSocket.n
    public void gB() {
        if (this.wt == 0) {
            this.wt = System.currentTimeMillis();
        }
        i.a("SenderData", this.wo.getCmd(), this.wo.getClientLogID(), this.wi, "StartSend", 0, "SenderData: start send size = " + (lC() != null ? lC().length : 0));
        sHandler.removeCallbacks(gw());
        if (this.wj.getTimeOut() != null) {
            sHandler.postDelayed(gw(), this.wj.getTimeOut().hs());
        }
        gv();
    }

    @Override // com.baidu.adp.lib.webSocket.n
    public void O(int i) {
        sHandler.removeCallbacks(gw());
        N(i);
    }

    @Override // com.baidu.adp.lib.webSocket.n
    public void gC() {
        int i;
        int cmd = this.wo.getCmd();
        if (lC() != null) {
            int length = lC().length;
            this.wo.setEncodedBinarySize(length);
            i = length;
        } else {
            i = 0;
        }
        i.a("SenderData", cmd, this.wo.getClientLogID(), this.wi, "FinishSend", 0, "SenderData: finish send  size = " + i);
        if (!this.wj.hu()) {
            sHandler.removeCallbacks(gw());
        }
        gu();
    }

    public CoderException gD() {
        return this.wn;
    }

    public boolean gE() {
        return this.wj.hu();
    }

    public int getPriority() {
        return this.wj.getPriority();
    }

    public SocketMessage gF() {
        return this.wo;
    }

    public SocketMessageTask gG() {
        return this.wj;
    }

    @Override // com.baidu.adp.lib.webSocket.c
    protected byte[] gH() {
        if (this.wt == 0) {
            this.wt = System.currentTimeMillis();
        }
        this.wn = null;
        com.baidu.adp.framework.client.socket.coder.b hf = com.baidu.adp.framework.client.socket.coder.b.hf();
        this.wi = f.gN().getSequenceId();
        if (this.wo != null) {
            this.wo.setSquencedId(this.wi);
            BdStatisticsManager bdStatisticsManager = BdStatisticsManager.getInstance();
            long clientLogID = this.wo == null ? -1L : this.wo.getClientLogID();
            String valueOf = String.valueOf(this.wi & 4294967295L);
            Object[] objArr = new Object[2];
            objArr[0] = IntentConfig.CMD;
            objArr[1] = Integer.valueOf(this.wo == null ? -1 : this.wo.getCmd());
            bdStatisticsManager.newDebug("seqid", clientLogID, valueOf, objArr);
        }
        try {
            return hf.a(this.wo, this.wi, this.wj.hv(), this.wj.getNeedEncrypt());
        } catch (CoderException e) {
            this.wn = e;
            return null;
        }
    }

    public int getCmd() {
        if (this.wo != null) {
            return this.wo.getCmd();
        }
        return 0;
    }

    public int getSequenceId() {
        return this.wi;
    }

    public boolean gI() {
        return this.wj.hw();
    }

    public int gJ() {
        return this.ws;
    }

    public int gK() {
        int i = this.ws + 1;
        this.ws = i;
        return i;
    }

    public int gL() {
        return this.wr;
    }

    public int gM() {
        int i = this.wr + 1;
        this.wr = i;
        return i;
    }
}
