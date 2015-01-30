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
    private SocketMessageTask dc;
    private CoderException df;
    private SocketMessage dg;
    private j di;
    private volatile int db = 0;
    private Runnable dh = null;
    private boolean dj = true;
    private int dk = 0;
    private int dl = 0;
    private long dm = 0;

    public g(SocketMessage socketMessage, SocketMessageTask socketMessageTask, j jVar) {
        this.dg = null;
        this.di = null;
        this.dc = null;
        if (socketMessage == null || socketMessageTask == null) {
            throw new InvalidParameterException("SenderData msg null");
        }
        this.dc = socketMessageTask;
        this.dg = socketMessage;
        this.di = jVar;
    }

    public int ay() {
        int retry = this.dc.getRetry();
        if (retry > 1) {
            return retry;
        }
        return 1;
    }

    private void t(int i) {
        if (this.di != null && this.dj) {
            this.di.a(i, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void az() {
        if (this.di != null && this.dj) {
            this.di.b(this);
        }
    }

    private void aA() {
        if (this.di != null && this.dj) {
            this.di.c(this);
        }
    }

    private void aB() {
        if (this.di != null && this.dj) {
            this.di.d(this);
        }
    }

    private Runnable aC() {
        if (this.dh == null) {
            this.dh = new h(this);
        }
        return this.dh;
    }

    public void aD() {
        sHandler.removeCallbacks(aC());
    }

    public void aE() {
        aD();
        this.dj = false;
    }

    public long aF() {
        return this.dm;
    }

    @Override // com.baidu.adp.lib.webSocket.ap
    public void aG() {
        if (this.dm == 0) {
            this.dm = System.currentTimeMillis();
        }
        m.a("SenderData", this.dg.getCmd(), this.db, "StartSend", 0, "SenderData: start send size = " + (fQ() != null ? fQ().length : 0));
        sHandler.removeCallbacks(aC());
        if (this.dc.getTimeOut() != null) {
            sHandler.postDelayed(aC(), this.dc.getTimeOut().by());
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
        m.a("SenderData", this.dg.getCmd(), this.db, "FinishSend", 0, "SenderData: finish send  size = " + (fQ() != null ? fQ().length : 0));
        if (!this.dc.bD()) {
            sHandler.removeCallbacks(aC());
        }
        aA();
    }

    public CoderException aI() {
        return this.df;
    }

    public boolean aJ() {
        return this.dc.bD();
    }

    public int getPriority() {
        return this.dc.getPriority();
    }

    public SocketMessage aK() {
        return this.dg;
    }

    public SocketMessageTask aL() {
        return this.dc;
    }

    @Override // com.baidu.adp.lib.webSocket.d
    protected byte[] aM() {
        this.df = null;
        com.baidu.adp.framework.client.socket.coder.b bk = com.baidu.adp.framework.client.socket.coder.b.bk();
        this.db = i.aT().aN();
        try {
            return bk.a(this.dg, this.db, this.dc.bE(), this.dc.getNeedEncrypt());
        } catch (CoderException e) {
            this.df = e;
            return null;
        }
    }

    public int getCmd() {
        if (this.dg != null) {
            return this.dg.getCmd();
        }
        return 0;
    }

    public int aN() {
        return this.db;
    }

    public boolean aO() {
        return this.dc.bF();
    }

    public int aP() {
        return this.dl;
    }

    public int aQ() {
        int i = this.dl + 1;
        this.dl = i;
        return i;
    }

    public int aR() {
        return this.dk;
    }

    public int aS() {
        int i = this.dk + 1;
        this.dk = i;
        return i;
    }
}
