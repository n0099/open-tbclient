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
    private static Handler hj = new Handler();
    private SocketMessageTask hg;
    private CoderException hk;
    private SocketMessage hl;
    private h hn;
    public long hs;
    public long ht;
    private volatile int hf = 0;
    private Runnable hm = null;
    private boolean ho = true;
    private int hp = 0;
    private int hq = 0;
    private long hr = 0;

    public e(SocketMessage socketMessage, SocketMessageTask socketMessageTask, h hVar) {
        this.hl = null;
        this.hn = null;
        this.hg = null;
        if (socketMessage == null || socketMessageTask == null) {
            throw new InvalidParameterException("SenderData msg null");
        }
        this.hg = socketMessageTask;
        this.hl = socketMessage;
        this.hn = hVar;
    }

    public int bn() {
        int retry = this.hg.getRetry();
        if (retry > 1) {
            return retry;
        }
        return 1;
    }

    private void M(int i) {
        if (this.hn != null && this.ho) {
            this.hn.a(i, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bo() {
        if (this.hn != null && this.ho) {
            this.hn.b(this);
        }
    }

    private void bp() {
        if (this.hn != null && this.ho) {
            this.hn.c(this);
        }
    }

    private void bq() {
        if (this.hn != null && this.ho) {
            this.hn.d(this);
        }
    }

    private Runnable br() {
        if (this.hm == null) {
            this.hm = new f(this);
        }
        return this.hm;
    }

    public void bs() {
        hj.removeCallbacks(br());
    }

    public void bt() {
        bs();
        this.ho = false;
    }

    public long bu() {
        return this.hr;
    }

    @Override // com.baidu.adp.lib.webSocket.p
    public void bv() {
        if (this.hr == 0) {
            this.hr = System.currentTimeMillis();
        }
        k.a("SenderData", this.hl.getCmd(), this.hl.getClientLogID(), this.hf, "StartSend", 0, "SenderData: start send size = " + (gV() != null ? gV().length : 0));
        hj.removeCallbacks(br());
        if (this.hg.getTimeOut() != null) {
            hj.postDelayed(br(), this.hg.getTimeOut().cp());
        }
        bq();
    }

    @Override // com.baidu.adp.lib.webSocket.p
    public void N(int i) {
        hj.removeCallbacks(br());
        M(i);
    }

    @Override // com.baidu.adp.lib.webSocket.p
    public void bw() {
        int i;
        int cmd = this.hl.getCmd();
        if (gV() != null) {
            int length = gV().length;
            this.hl.setEncodedBinarySize(length);
            i = length;
        } else {
            i = 0;
        }
        k.a("SenderData", cmd, this.hl.getClientLogID(), this.hf, "FinishSend", 0, "SenderData: finish send  size = " + i);
        if (!this.hg.cs()) {
            hj.removeCallbacks(br());
        }
        bp();
    }

    public CoderException bx() {
        return this.hk;
    }

    public boolean by() {
        return this.hg.cs();
    }

    public int getPriority() {
        return this.hg.getPriority();
    }

    public SocketMessage bz() {
        return this.hl;
    }

    public SocketMessageTask bA() {
        return this.hg;
    }

    @Override // com.baidu.adp.lib.webSocket.c
    protected byte[] bB() {
        if (this.hr == 0) {
            this.hr = System.currentTimeMillis();
        }
        this.hk = null;
        com.baidu.adp.framework.client.socket.coder.b ca = com.baidu.adp.framework.client.socket.coder.b.ca();
        this.hf = g.bH().bC();
        if (this.hl != null) {
            this.hl.setSquencedId(this.hf);
            com.baidu.adp.lib.stats.a eI = com.baidu.adp.lib.stats.a.eI();
            long clientLogID = this.hl == null ? -1L : this.hl.getClientLogID();
            String valueOf = String.valueOf(this.hf & 4294967295L);
            Object[] objArr = new Object[2];
            objArr[0] = IntentConfig.CMD;
            objArr[1] = Integer.valueOf(this.hl == null ? -1 : this.hl.getCmd());
            eI.a("seqid", clientLogID, valueOf, objArr);
        }
        try {
            return ca.a(this.hl, this.hf, this.hg.ct(), this.hg.getNeedEncrypt());
        } catch (CoderException e) {
            this.hk = e;
            return null;
        }
    }

    public int getCmd() {
        if (this.hl != null) {
            return this.hl.getCmd();
        }
        return 0;
    }

    public int bC() {
        return this.hf;
    }

    public boolean canRetry() {
        return this.hg.cu();
    }

    public int bD() {
        return this.hq;
    }

    public int bE() {
        int i = this.hq + 1;
        this.hq = i;
        return i;
    }

    public int bF() {
        return this.hp;
    }

    public int bG() {
        int i = this.hp + 1;
        this.hp = i;
        return i;
    }
}
