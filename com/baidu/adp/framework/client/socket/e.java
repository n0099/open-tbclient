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
    private SocketMessageTask wi;
    private CoderException wl;
    private SocketMessage wn;
    private g wp;
    public long wu;
    public long wv;
    private volatile int wh = 0;
    private Runnable wo = null;
    private boolean wq = true;
    private int wr = 0;
    private int ws = 0;
    private long wt = 0;

    public e(SocketMessage socketMessage, SocketMessageTask socketMessageTask, g gVar) {
        this.wn = null;
        this.wp = null;
        this.wi = null;
        if (socketMessage == null || socketMessageTask == null) {
            throw new InvalidParameterException("SenderData msg null");
        }
        this.wi = socketMessageTask;
        this.wn = socketMessage;
        this.wp = gVar;
    }

    public int gp() {
        int retry = this.wi.getRetry();
        if (retry > 1) {
            return retry;
        }
        return 1;
    }

    private void M(int i) {
        if (this.wp != null && this.wq) {
            this.wp.a(i, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gq() {
        if (this.wp != null && this.wq) {
            this.wp.b(this);
        }
    }

    private void gr() {
        if (this.wp != null && this.wq) {
            this.wp.c(this);
        }
    }

    private void gs() {
        if (this.wp != null && this.wq) {
            this.wp.d(this);
        }
    }

    private Runnable gt() {
        if (this.wo == null) {
            this.wo = new Runnable() { // from class: com.baidu.adp.framework.client.socket.e.1
                @Override // java.lang.Runnable
                public void run() {
                    e.this.gq();
                }
            };
        }
        return this.wo;
    }

    public void gu() {
        sHandler.removeCallbacks(gt());
    }

    public void gv() {
        gu();
        this.wq = false;
    }

    public long gw() {
        return this.wt;
    }

    @Override // com.baidu.adp.lib.webSocket.n
    public void gx() {
        if (this.wt == 0) {
            this.wt = System.currentTimeMillis();
        }
        i.a("SenderData", this.wn.getCmd(), this.wn.getClientLogID(), this.wh, "StartSend", 0, "SenderData: start send size = " + (lE() != null ? lE().length : 0));
        sHandler.removeCallbacks(gt());
        if (this.wi.getTimeOut() != null) {
            sHandler.postDelayed(gt(), this.wi.getTimeOut().ho());
        }
        gs();
    }

    @Override // com.baidu.adp.lib.webSocket.n
    public void N(int i) {
        sHandler.removeCallbacks(gt());
        M(i);
    }

    @Override // com.baidu.adp.lib.webSocket.n
    public void gy() {
        int i;
        int cmd = this.wn.getCmd();
        if (lE() != null) {
            int length = lE().length;
            this.wn.setEncodedBinarySize(length);
            i = length;
        } else {
            i = 0;
        }
        i.a("SenderData", cmd, this.wn.getClientLogID(), this.wh, "FinishSend", 0, "SenderData: finish send  size = " + i);
        if (!this.wi.hr()) {
            sHandler.removeCallbacks(gt());
        }
        gr();
    }

    public CoderException gz() {
        return this.wl;
    }

    public boolean gA() {
        return this.wi.hr();
    }

    public int getPriority() {
        return this.wi.getPriority();
    }

    public SocketMessage gB() {
        return this.wn;
    }

    public SocketMessageTask gC() {
        return this.wi;
    }

    @Override // com.baidu.adp.lib.webSocket.c
    protected byte[] gD() {
        if (this.wt == 0) {
            this.wt = System.currentTimeMillis();
        }
        this.wl = null;
        com.baidu.adp.framework.client.socket.coder.b hb = com.baidu.adp.framework.client.socket.coder.b.hb();
        this.wh = f.gJ().getSequenceId();
        if (this.wn != null) {
            this.wn.setSquencedId(this.wh);
            BdStatisticsManager bdStatisticsManager = BdStatisticsManager.getInstance();
            long clientLogID = this.wn == null ? -1L : this.wn.getClientLogID();
            String valueOf = String.valueOf(this.wh & 4294967295L);
            Object[] objArr = new Object[2];
            objArr[0] = IntentConfig.CMD;
            objArr[1] = Integer.valueOf(this.wn == null ? -1 : this.wn.getCmd());
            bdStatisticsManager.newDebug("seqid", clientLogID, valueOf, objArr);
        }
        try {
            return hb.a(this.wn, this.wh, this.wi.hs(), this.wi.getNeedEncrypt());
        } catch (CoderException e) {
            this.wl = e;
            return null;
        }
    }

    public int getCmd() {
        if (this.wn != null) {
            return this.wn.getCmd();
        }
        return 0;
    }

    public int getSequenceId() {
        return this.wh;
    }

    public boolean gE() {
        return this.wi.ht();
    }

    public int gF() {
        return this.ws;
    }

    public int gG() {
        int i = this.ws + 1;
        this.ws = i;
        return i;
    }

    public int gH() {
        return this.wr;
    }

    public int gI() {
        int i = this.wr + 1;
        this.wr = i;
        return i;
    }
}
