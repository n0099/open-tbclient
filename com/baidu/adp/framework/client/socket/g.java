package com.baidu.adp.framework.client.socket;

import android.os.Handler;
import com.baidu.adp.framework.client.socket.coder.CoderException;
import com.baidu.adp.framework.message.SocketMessage;
import com.baidu.adp.framework.task.SocketMessageTask;
import java.security.InvalidParameterException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends com.baidu.adp.lib.webSocket.d {
    private static Handler sHandler = new Handler();
    private SocketMessageTask db;
    private CoderException de;
    private SocketMessage df;
    private j dh;
    private volatile int da = 0;
    private Runnable dg = null;
    private boolean di = true;
    private int dj = 0;
    private int dk = 0;
    private long dl = 0;

    public g(SocketMessage socketMessage, SocketMessageTask socketMessageTask, j jVar) {
        this.df = null;
        this.dh = null;
        this.db = null;
        if (socketMessage == null || socketMessageTask == null) {
            throw new InvalidParameterException("SenderData msg null");
        }
        this.db = socketMessageTask;
        this.df = socketMessage;
        this.dh = jVar;
    }

    public int ay() {
        int retry = this.db.getRetry();
        if (retry > 1) {
            return retry;
        }
        return 1;
    }

    private void t(int i) {
        if (this.dh != null && this.di) {
            this.dh.a(i, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void az() {
        if (this.dh != null && this.di) {
            this.dh.b(this);
        }
    }

    private void aA() {
        if (this.dh != null && this.di) {
            this.dh.c(this);
        }
    }

    private void aB() {
        if (this.dh != null && this.di) {
            this.dh.d(this);
        }
    }

    private Runnable aC() {
        if (this.dg == null) {
            this.dg = new h(this);
        }
        return this.dg;
    }

    public void aD() {
        sHandler.removeCallbacks(aC());
    }

    public void aE() {
        aD();
        this.di = false;
    }

    public long aF() {
        return this.dl;
    }

    @Override // com.baidu.adp.lib.webSocket.ap
    public void aG() {
        if (this.dl == 0) {
            this.dl = System.currentTimeMillis();
        }
        m.a("SenderData", this.df.getCmd(), this.da, "StartSend", 0, "SenderData: start send size = " + (fR() != null ? fR().length : 0));
        sHandler.removeCallbacks(aC());
        if (this.db.getTimeOut() != null) {
            sHandler.postDelayed(aC(), this.db.getTimeOut().bA());
        }
        aB();
    }

    @Override // com.baidu.adp.lib.webSocket.ap
    public void u(int i) {
        sHandler.removeCallbacks(aC());
        t(i);
    }

    @Override // com.baidu.adp.lib.webSocket.ap
    public void aH() {
        m.a("SenderData", this.df.getCmd(), this.da, "FinishSend", 0, "SenderData: finish send  size = " + (fR() != null ? fR().length : 0));
        if (!this.db.bF()) {
            sHandler.removeCallbacks(aC());
        }
        aA();
    }

    public CoderException aI() {
        return this.de;
    }

    public boolean aJ() {
        return this.db.bF();
    }

    public int getPriority() {
        return this.db.getPriority();
    }

    public SocketMessage aK() {
        return this.df;
    }

    public SocketMessageTask aL() {
        return this.db;
    }

    @Override // com.baidu.adp.lib.webSocket.d
    protected byte[] aM() {
        this.de = null;
        com.baidu.adp.framework.client.socket.coder.b bk = com.baidu.adp.framework.client.socket.coder.b.bk();
        this.da = i.aT().aN();
        try {
            return bk.a(this.df, this.da, this.db.bG(), this.db.getNeedEncrypt());
        } catch (CoderException e) {
            this.de = e;
            return null;
        }
    }

    public int getCmd() {
        if (this.df != null) {
            return this.df.getCmd();
        }
        return 0;
    }

    public int aN() {
        return this.da;
    }

    public boolean aO() {
        return this.db.bH();
    }

    public int aP() {
        return this.dk;
    }

    public int aQ() {
        int i = this.dk + 1;
        this.dk = i;
        return i;
    }

    public int aR() {
        return this.dj;
    }

    public int aS() {
        int i = this.dj + 1;
        this.dj = i;
        return i;
    }
}
