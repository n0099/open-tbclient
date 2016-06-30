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
    private static Handler es = new Handler();
    public long eC;
    public long eD;
    private SocketMessageTask ep;
    private CoderException eu;
    private SocketMessage ev;
    private h ex;
    private volatile int eo = 0;
    private Runnable ew = null;
    private boolean ey = true;
    private int ez = 0;
    private int eA = 0;
    private long eB = 0;

    public e(SocketMessage socketMessage, SocketMessageTask socketMessageTask, h hVar) {
        this.ev = null;
        this.ex = null;
        this.ep = null;
        if (socketMessage == null || socketMessageTask == null) {
            throw new InvalidParameterException("SenderData msg null");
        }
        this.ep = socketMessageTask;
        this.ev = socketMessage;
        this.ex = hVar;
    }

    public int as() {
        int retry = this.ep.getRetry();
        if (retry > 1) {
            return retry;
        }
        return 1;
    }

    private void w(int i) {
        if (this.ex != null && this.ey) {
            this.ex.a(i, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void at() {
        if (this.ex != null && this.ey) {
            this.ex.b(this);
        }
    }

    private void au() {
        if (this.ex != null && this.ey) {
            this.ex.c(this);
        }
    }

    private void av() {
        if (this.ex != null && this.ey) {
            this.ex.d(this);
        }
    }

    private Runnable aw() {
        if (this.ew == null) {
            this.ew = new f(this);
        }
        return this.ew;
    }

    public void ax() {
        es.removeCallbacks(aw());
    }

    public void ay() {
        ax();
        this.ey = false;
    }

    public long az() {
        return this.eB;
    }

    @Override // com.baidu.adp.lib.webSocket.p
    public void aA() {
        if (this.eB == 0) {
            this.eB = System.currentTimeMillis();
        }
        k.a("SenderData", this.ev.getCmd(), this.ev.getClientLogID(), this.eo, "StartSend", 0, "SenderData: start send size = " + (ga() != null ? ga().length : 0));
        es.removeCallbacks(aw());
        if (this.ep.getTimeOut() != null) {
            es.postDelayed(aw(), this.ep.getTimeOut().bv());
        }
        av();
    }

    @Override // com.baidu.adp.lib.webSocket.p
    public void x(int i) {
        es.removeCallbacks(aw());
        w(i);
    }

    @Override // com.baidu.adp.lib.webSocket.p
    public void aB() {
        int i;
        int cmd = this.ev.getCmd();
        if (ga() != null) {
            int length = ga().length;
            this.ev.setEncodedBinarySize(length);
            i = length;
        } else {
            i = 0;
        }
        k.a("SenderData", cmd, this.ev.getClientLogID(), this.eo, "FinishSend", 0, "SenderData: finish send  size = " + i);
        if (!this.ep.by()) {
            es.removeCallbacks(aw());
        }
        au();
    }

    public CoderException aC() {
        return this.eu;
    }

    public boolean aD() {
        return this.ep.by();
    }

    public int getPriority() {
        return this.ep.getPriority();
    }

    public SocketMessage aE() {
        return this.ev;
    }

    public SocketMessageTask aF() {
        return this.ep;
    }

    @Override // com.baidu.adp.lib.webSocket.c
    protected byte[] aG() {
        if (this.eB == 0) {
            this.eB = System.currentTimeMillis();
        }
        this.eu = null;
        com.baidu.adp.framework.client.socket.coder.b bg = com.baidu.adp.framework.client.socket.coder.b.bg();
        this.eo = g.aN().aH();
        if (this.ev != null) {
            this.ev.setSquencedId(this.eo);
            com.baidu.adp.lib.stats.a dO = com.baidu.adp.lib.stats.a.dO();
            long clientLogID = this.ev == null ? -1L : this.ev.getClientLogID();
            String valueOf = String.valueOf(this.eo & 4294967295L);
            Object[] objArr = new Object[2];
            objArr[0] = IntentConfig.CMD;
            objArr[1] = Integer.valueOf(this.ev == null ? -1 : this.ev.getCmd());
            dO.a("seqid", clientLogID, valueOf, objArr);
        }
        try {
            return bg.a(this.ev, this.eo, this.ep.bz(), this.ep.getNeedEncrypt());
        } catch (CoderException e) {
            this.eu = e;
            return null;
        }
    }

    public int getCmd() {
        if (this.ev != null) {
            return this.ev.getCmd();
        }
        return 0;
    }

    public int aH() {
        return this.eo;
    }

    public boolean aI() {
        return this.ep.bA();
    }

    public int aJ() {
        return this.eA;
    }

    public int aK() {
        int i = this.eA + 1;
        this.eA = i;
        return i;
    }

    public int aL() {
        return this.ez;
    }

    public int aM() {
        int i = this.ez + 1;
        this.ez = i;
        return i;
    }
}
