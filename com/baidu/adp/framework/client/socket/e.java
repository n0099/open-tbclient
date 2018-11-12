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
    private SocketMessageTask wn;
    private CoderException wq;
    private SocketMessage wr;
    private g wt;
    public long wx;
    public long wy;
    private volatile int wl = 0;
    private Runnable ws = null;
    private boolean mIsValid = true;
    private int wu = 0;
    private int wv = 0;
    private long ww = 0;

    public e(SocketMessage socketMessage, SocketMessageTask socketMessageTask, g gVar) {
        this.wr = null;
        this.wt = null;
        this.wn = null;
        if (socketMessage == null || socketMessageTask == null) {
            throw new InvalidParameterException("SenderData msg null");
        }
        this.wn = socketMessageTask;
        this.wr = socketMessage;
        this.wt = gVar;
    }

    public int gs() {
        int retry = this.wn.getRetry();
        if (retry > 1) {
            return retry;
        }
        return 1;
    }

    private void ae(int i) {
        if (this.wt != null && this.mIsValid) {
            this.wt.a(i, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gt() {
        if (this.wt != null && this.mIsValid) {
            this.wt.b(this);
        }
    }

    private void gu() {
        if (this.wt != null && this.mIsValid) {
            this.wt.c(this);
        }
    }

    private void gv() {
        if (this.wt != null && this.mIsValid) {
            this.wt.d(this);
        }
    }

    private Runnable gw() {
        if (this.ws == null) {
            this.ws = new Runnable() { // from class: com.baidu.adp.framework.client.socket.e.1
                @Override // java.lang.Runnable
                public void run() {
                    e.this.gt();
                }
            };
        }
        return this.ws;
    }

    public void gx() {
        sHandler.removeCallbacks(gw());
    }

    public void gy() {
        gx();
        this.mIsValid = false;
    }

    public long gz() {
        return this.ww;
    }

    @Override // com.baidu.adp.lib.webSocket.n
    public void gA() {
        if (this.ww == 0) {
            this.ww = System.currentTimeMillis();
        }
        i.a("SenderData", this.wr.getCmd(), this.wr.getClientLogID(), this.wl, "StartSend", 0, "SenderData: start send size = " + (lA() != null ? lA().length : 0));
        sHandler.removeCallbacks(gw());
        if (this.wn.getTimeOut() != null) {
            sHandler.postDelayed(gw(), this.wn.getTimeOut().hr());
        }
        gv();
    }

    @Override // com.baidu.adp.lib.webSocket.n
    public void af(int i) {
        sHandler.removeCallbacks(gw());
        ae(i);
    }

    @Override // com.baidu.adp.lib.webSocket.n
    public void gB() {
        int i;
        int cmd = this.wr.getCmd();
        if (lA() != null) {
            int length = lA().length;
            this.wr.setEncodedBinarySize(length);
            i = length;
        } else {
            i = 0;
        }
        i.a("SenderData", cmd, this.wr.getClientLogID(), this.wl, "FinishSend", 0, "SenderData: finish send  size = " + i);
        if (!this.wn.ht()) {
            sHandler.removeCallbacks(gw());
        }
        gu();
    }

    public CoderException gC() {
        return this.wq;
    }

    public boolean gD() {
        return this.wn.ht();
    }

    public int getPriority() {
        return this.wn.getPriority();
    }

    public SocketMessage gE() {
        return this.wr;
    }

    public SocketMessageTask gF() {
        return this.wn;
    }

    @Override // com.baidu.adp.lib.webSocket.c
    protected byte[] gG() {
        if (this.ww == 0) {
            this.ww = System.currentTimeMillis();
        }
        this.wq = null;
        com.baidu.adp.framework.client.socket.coder.b he = com.baidu.adp.framework.client.socket.coder.b.he();
        this.wl = f.gM().getSequenceId();
        if (this.wr != null) {
            this.wr.setSquencedId(this.wl);
            BdStatisticsManager bdStatisticsManager = BdStatisticsManager.getInstance();
            long clientLogID = this.wr == null ? -1L : this.wr.getClientLogID();
            String valueOf = String.valueOf(this.wl & 4294967295L);
            Object[] objArr = new Object[2];
            objArr[0] = IntentConfig.CMD;
            objArr[1] = Integer.valueOf(this.wr == null ? -1 : this.wr.getCmd());
            bdStatisticsManager.newDebug("seqid", clientLogID, valueOf, objArr);
        }
        try {
            return he.a(this.wr, this.wl, this.wn.hu(), this.wn.getNeedEncrypt());
        } catch (CoderException e) {
            this.wq = e;
            return null;
        }
    }

    public int getCmd() {
        if (this.wr != null) {
            return this.wr.getCmd();
        }
        return 0;
    }

    public int getSequenceId() {
        return this.wl;
    }

    public boolean gH() {
        return this.wn.hv();
    }

    public int gI() {
        return this.wv;
    }

    public int gJ() {
        int i = this.wv + 1;
        this.wv = i;
        return i;
    }

    public int gK() {
        return this.wu;
    }

    public int gL() {
        int i = this.wu + 1;
        this.wu = i;
        return i;
    }
}
