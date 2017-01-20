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
    private static Handler hg = new Handler();
    private SocketMessageTask hc;
    private CoderException hh;
    private SocketMessage hi;
    private h hk;
    public long hp;
    public long hq;
    private volatile int hb = 0;
    private Runnable hj = null;
    private boolean hl = true;
    private int hm = 0;
    private int hn = 0;
    private long ho = 0;

    public e(SocketMessage socketMessage, SocketMessageTask socketMessageTask, h hVar) {
        this.hi = null;
        this.hk = null;
        this.hc = null;
        if (socketMessage == null || socketMessageTask == null) {
            throw new InvalidParameterException("SenderData msg null");
        }
        this.hc = socketMessageTask;
        this.hi = socketMessage;
        this.hk = hVar;
    }

    public int bn() {
        int retry = this.hc.getRetry();
        if (retry > 1) {
            return retry;
        }
        return 1;
    }

    private void N(int i) {
        if (this.hk != null && this.hl) {
            this.hk.a(i, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bo() {
        if (this.hk != null && this.hl) {
            this.hk.b(this);
        }
    }

    private void bp() {
        if (this.hk != null && this.hl) {
            this.hk.c(this);
        }
    }

    private void bq() {
        if (this.hk != null && this.hl) {
            this.hk.d(this);
        }
    }

    private Runnable br() {
        if (this.hj == null) {
            this.hj = new f(this);
        }
        return this.hj;
    }

    public void bs() {
        hg.removeCallbacks(br());
    }

    public void bt() {
        bs();
        this.hl = false;
    }

    public long bu() {
        return this.ho;
    }

    @Override // com.baidu.adp.lib.webSocket.p
    public void bv() {
        if (this.ho == 0) {
            this.ho = System.currentTimeMillis();
        }
        k.a("SenderData", this.hi.getCmd(), this.hi.getClientLogID(), this.hb, "StartSend", 0, "SenderData: start send size = " + (gT() != null ? gT().length : 0));
        hg.removeCallbacks(br());
        if (this.hc.getTimeOut() != null) {
            hg.postDelayed(br(), this.hc.getTimeOut().cn());
        }
        bq();
    }

    @Override // com.baidu.adp.lib.webSocket.p
    public void O(int i) {
        hg.removeCallbacks(br());
        N(i);
    }

    @Override // com.baidu.adp.lib.webSocket.p
    public void bw() {
        int i;
        int cmd = this.hi.getCmd();
        if (gT() != null) {
            int length = gT().length;
            this.hi.setEncodedBinarySize(length);
            i = length;
        } else {
            i = 0;
        }
        k.a("SenderData", cmd, this.hi.getClientLogID(), this.hb, "FinishSend", 0, "SenderData: finish send  size = " + i);
        if (!this.hc.cq()) {
            hg.removeCallbacks(br());
        }
        bp();
    }

    public CoderException bx() {
        return this.hh;
    }

    public boolean by() {
        return this.hc.cq();
    }

    public int getPriority() {
        return this.hc.getPriority();
    }

    public SocketMessage bz() {
        return this.hi;
    }

    public SocketMessageTask bA() {
        return this.hc;
    }

    @Override // com.baidu.adp.lib.webSocket.c
    protected byte[] bB() {
        if (this.ho == 0) {
            this.ho = System.currentTimeMillis();
        }
        this.hh = null;
        com.baidu.adp.framework.client.socket.coder.b ca = com.baidu.adp.framework.client.socket.coder.b.ca();
        this.hb = g.bH().bC();
        if (this.hi != null) {
            this.hi.setSquencedId(this.hb);
            com.baidu.adp.lib.stats.a eG = com.baidu.adp.lib.stats.a.eG();
            long clientLogID = this.hi == null ? -1L : this.hi.getClientLogID();
            String valueOf = String.valueOf(this.hb & 4294967295L);
            Object[] objArr = new Object[2];
            objArr[0] = IntentConfig.CMD;
            objArr[1] = Integer.valueOf(this.hi == null ? -1 : this.hi.getCmd());
            eG.a("seqid", clientLogID, valueOf, objArr);
        }
        try {
            return ca.a(this.hi, this.hb, this.hc.cr(), this.hc.getNeedEncrypt());
        } catch (CoderException e) {
            this.hh = e;
            return null;
        }
    }

    public int getCmd() {
        if (this.hi != null) {
            return this.hi.getCmd();
        }
        return 0;
    }

    public int bC() {
        return this.hb;
    }

    public boolean canRetry() {
        return this.hc.cs();
    }

    public int bD() {
        return this.hn;
    }

    public int bE() {
        int i = this.hn + 1;
        this.hn = i;
        return i;
    }

    public int bF() {
        return this.hm;
    }

    public int bG() {
        int i = this.hm + 1;
        this.hm = i;
        return i;
    }
}
