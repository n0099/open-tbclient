package com.baidu.adp.framework.client.socket;

import android.os.Handler;
import com.baidu.adp.framework.client.socket.coder.CoderException;
import com.baidu.adp.framework.message.SocketMessage;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import java.security.InvalidParameterException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends com.baidu.adp.lib.webSocket.c {
    private static Handler hi = new Handler();
    private SocketMessageTask hf;
    private CoderException hj;
    private SocketMessage hk;
    private h hm;
    public long hr;
    public long hs;
    private volatile int hd = 0;
    private Runnable hl = null;
    private boolean hn = true;
    private int ho = 0;
    private int hp = 0;
    private long hq = 0;

    public e(SocketMessage socketMessage, SocketMessageTask socketMessageTask, h hVar) {
        this.hk = null;
        this.hm = null;
        this.hf = null;
        if (socketMessage == null || socketMessageTask == null) {
            throw new InvalidParameterException("SenderData msg null");
        }
        this.hf = socketMessageTask;
        this.hk = socketMessage;
        this.hm = hVar;
    }

    public int bn() {
        int retry = this.hf.getRetry();
        if (retry > 1) {
            return retry;
        }
        return 1;
    }

    private void M(int i) {
        if (this.hm != null && this.hn) {
            this.hm.a(i, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bo() {
        if (this.hm != null && this.hn) {
            this.hm.b(this);
        }
    }

    private void bp() {
        if (this.hm != null && this.hn) {
            this.hm.c(this);
        }
    }

    private void bq() {
        if (this.hm != null && this.hn) {
            this.hm.d(this);
        }
    }

    private Runnable br() {
        if (this.hl == null) {
            this.hl = new f(this);
        }
        return this.hl;
    }

    public void bs() {
        hi.removeCallbacks(br());
    }

    public void bt() {
        bs();
        this.hn = false;
    }

    public long bu() {
        return this.hq;
    }

    @Override // com.baidu.adp.lib.webSocket.p
    public void bv() {
        if (this.hq == 0) {
            this.hq = System.currentTimeMillis();
        }
        k.a("SenderData", this.hk.getCmd(), this.hk.getClientLogID(), this.hd, "StartSend", 0, "SenderData: start send size = " + (gV() != null ? gV().length : 0));
        hi.removeCallbacks(br());
        if (this.hf.getTimeOut() != null) {
            hi.postDelayed(br(), this.hf.getTimeOut().cp());
        }
        bq();
    }

    @Override // com.baidu.adp.lib.webSocket.p
    public void N(int i) {
        hi.removeCallbacks(br());
        M(i);
    }

    @Override // com.baidu.adp.lib.webSocket.p
    public void bw() {
        int i;
        int cmd = this.hk.getCmd();
        if (gV() != null) {
            int length = gV().length;
            this.hk.setEncodedBinarySize(length);
            i = length;
        } else {
            i = 0;
        }
        k.a("SenderData", cmd, this.hk.getClientLogID(), this.hd, "FinishSend", 0, "SenderData: finish send  size = " + i);
        if (!this.hf.cs()) {
            hi.removeCallbacks(br());
        }
        bp();
    }

    public CoderException bx() {
        return this.hj;
    }

    public boolean by() {
        return this.hf.cs();
    }

    public int getPriority() {
        return this.hf.getPriority();
    }

    public SocketMessage bz() {
        return this.hk;
    }

    public SocketMessageTask bA() {
        return this.hf;
    }

    @Override // com.baidu.adp.lib.webSocket.c
    protected byte[] bB() {
        if (this.hq == 0) {
            this.hq = System.currentTimeMillis();
        }
        this.hj = null;
        com.baidu.adp.framework.client.socket.coder.b ca = com.baidu.adp.framework.client.socket.coder.b.ca();
        this.hd = g.bH().bC();
        if (this.hk != null) {
            this.hk.setSquencedId(this.hd);
            com.baidu.adp.lib.stats.a eI = com.baidu.adp.lib.stats.a.eI();
            long clientLogID = this.hk == null ? -1L : this.hk.getClientLogID();
            String valueOf = String.valueOf(this.hd & 4294967295L);
            Object[] objArr = new Object[2];
            objArr[0] = IntentConfig.CMD;
            objArr[1] = Integer.valueOf(this.hk == null ? -1 : this.hk.getCmd());
            eI.a("seqid", clientLogID, valueOf, objArr);
        }
        try {
            return ca.a(this.hk, this.hd, this.hf.ct(), this.hf.getNeedEncrypt());
        } catch (CoderException e) {
            this.hj = e;
            return null;
        }
    }

    public int getCmd() {
        if (this.hk != null) {
            return this.hk.getCmd();
        }
        return 0;
    }

    public int bC() {
        return this.hd;
    }

    public boolean canRetry() {
        return this.hf.cu();
    }

    public int bD() {
        return this.hp;
    }

    public int bE() {
        int i = this.hp + 1;
        this.hp = i;
        return i;
    }

    public int bF() {
        return this.ho;
    }

    public int bG() {
        int i = this.ho + 1;
        this.ho = i;
        return i;
    }
}
