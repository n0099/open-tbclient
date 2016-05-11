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
    private static Handler eu = new Handler();
    public long eD;
    public long eE;
    private SocketMessageTask eq;
    private CoderException ev;
    private SocketMessage ew;
    private h ey;
    private volatile int ep = 0;
    private Runnable ex = null;
    private boolean ez = true;
    private int eA = 0;
    private int eB = 0;
    private long eC = 0;

    public e(SocketMessage socketMessage, SocketMessageTask socketMessageTask, h hVar) {
        this.ew = null;
        this.ey = null;
        this.eq = null;
        if (socketMessage == null || socketMessageTask == null) {
            throw new InvalidParameterException("SenderData msg null");
        }
        this.eq = socketMessageTask;
        this.ew = socketMessage;
        this.ey = hVar;
    }

    public int as() {
        int retry = this.eq.getRetry();
        if (retry > 1) {
            return retry;
        }
        return 1;
    }

    private void w(int i) {
        if (this.ey != null && this.ez) {
            this.ey.a(i, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void at() {
        if (this.ey != null && this.ez) {
            this.ey.b(this);
        }
    }

    private void au() {
        if (this.ey != null && this.ez) {
            this.ey.c(this);
        }
    }

    private void av() {
        if (this.ey != null && this.ez) {
            this.ey.d(this);
        }
    }

    private Runnable aw() {
        if (this.ex == null) {
            this.ex = new f(this);
        }
        return this.ex;
    }

    public void ax() {
        eu.removeCallbacks(aw());
    }

    public void ay() {
        ax();
        this.ez = false;
    }

    public long az() {
        return this.eC;
    }

    @Override // com.baidu.adp.lib.webSocket.p
    public void aA() {
        if (this.eC == 0) {
            this.eC = System.currentTimeMillis();
        }
        k.a("SenderData", this.ew.getCmd(), this.ew.getClientLogID(), this.ep, "StartSend", 0, "SenderData: start send size = " + (fZ() != null ? fZ().length : 0));
        eu.removeCallbacks(aw());
        if (this.eq.getTimeOut() != null) {
            eu.postDelayed(aw(), this.eq.getTimeOut().bu());
        }
        av();
    }

    @Override // com.baidu.adp.lib.webSocket.p
    public void x(int i) {
        eu.removeCallbacks(aw());
        w(i);
    }

    @Override // com.baidu.adp.lib.webSocket.p
    public void aB() {
        int i;
        int cmd = this.ew.getCmd();
        if (fZ() != null) {
            int length = fZ().length;
            this.ew.setEncodedBinarySize(length);
            i = length;
        } else {
            i = 0;
        }
        k.a("SenderData", cmd, this.ew.getClientLogID(), this.ep, "FinishSend", 0, "SenderData: finish send  size = " + i);
        if (!this.eq.bx()) {
            eu.removeCallbacks(aw());
        }
        au();
    }

    public CoderException aC() {
        return this.ev;
    }

    public boolean aD() {
        return this.eq.bx();
    }

    public int getPriority() {
        return this.eq.getPriority();
    }

    public SocketMessage aE() {
        return this.ew;
    }

    public SocketMessageTask aF() {
        return this.eq;
    }

    @Override // com.baidu.adp.lib.webSocket.c
    protected byte[] aG() {
        if (this.eC == 0) {
            this.eC = System.currentTimeMillis();
        }
        this.ev = null;
        com.baidu.adp.framework.client.socket.coder.b bf = com.baidu.adp.framework.client.socket.coder.b.bf();
        this.ep = g.aN().aH();
        com.baidu.adp.lib.stats.a dN = com.baidu.adp.lib.stats.a.dN();
        long clientLogID = this.ew == null ? -1L : this.ew.getClientLogID();
        String valueOf = String.valueOf(this.ep & 4294967295L);
        Object[] objArr = new Object[2];
        objArr[0] = IntentConfig.CMD;
        objArr[1] = Integer.valueOf(this.ew == null ? -1 : this.ew.getCmd());
        dN.a("seqid", clientLogID, valueOf, objArr);
        try {
            return bf.a(this.ew, this.ep, this.eq.by(), this.eq.getNeedEncrypt());
        } catch (CoderException e) {
            this.ev = e;
            return null;
        }
    }

    public int getCmd() {
        if (this.ew != null) {
            return this.ew.getCmd();
        }
        return 0;
    }

    public int aH() {
        return this.ep;
    }

    public boolean aI() {
        return this.eq.bz();
    }

    public int aJ() {
        return this.eB;
    }

    public int aK() {
        int i = this.eB + 1;
        this.eB = i;
        return i;
    }

    public int aL() {
        return this.eA;
    }

    public int aM() {
        int i = this.eA + 1;
        this.eA = i;
        return i;
    }
}
